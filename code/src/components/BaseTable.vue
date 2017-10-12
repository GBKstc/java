<template>
  <div class="basetable">
    <div class="tableMain">
      <el-table :data="tableData" style="width: 100%" v-loading='load'>
        <el-table-column prop="department" label="部门" width="100">
        </el-table-column>
        <el-table-column prop="name" label="姓名" width="100">
        </el-table-column>
        <el-table-column prop="date" label="日期" width="200">
        </el-table-column>
        <el-table-column prop="diningform" label="就餐形式" width="100">
        </el-table-column>
        <!--<el-table-column prop="status" label="status" width="100">-->
        <!--</el-table-column>-->
        <!--<el-table-column prop="id" label="id" width="100">-->
        <!--</el-table-column>-->

        <el-table-column prop="number" label="就餐人数" width="100">
        </el-table-column>
        <el-table-column prop="content" label="就餐标准" >
          <template scope="scope">
            <el-input v-model="standard" placeholder="元/人"></el-input>
          </template>
        </el-table-column>
        <el-table-column prop="content" label="来客单位或事由" width="300">
        </el-table-column>

        <el-table-column label="操作"  width="150">
          <template scope="scope">
            <el-button
              size="small"
              @click="handleEdit(scope.$index, scope.row)">同意</el-button>
            <el-button
              size="small"
              type="danger"
              @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>

      </el-table>
    </div>
    <el-dialog title="用户信息" :visible.sync="dialogFormVisible">

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script type="text/ecmascript-6">
  import jwt from 'jsonwebtoken'
  export default {
    data() {
      return {
        tableData:[],
        dialogFormVisible: false,
        formLabelWidth: '80px',
        form: {},
        value6: '',
        currentPage3: 1,
        load: false,
        standard:0,//就餐标准
      }
    },
    beforeCreate:function () {
      const token = sessionStorage.getItem('demo-token');
      if(token == null || token == 'null'){
        return null

      }else {
        let decode = jwt.verify(token, 'vue-koa-demo');
        console.log(decode)
        this.id = decode.id;
        this.name = decode.name;
        if(this.name!='admin')return
        this.$http.get('/api/todolist/0')
          .then((res) => {
            if (res.status == 200) {
              this.tableData = res.data
              console.log(res.data)
            } else {
              this.$message.error('获取列表失败！')
            }
          }, (err) => {
            this.$message.error('获取列表失败！')
            console.log(err)
          })
      }
    },
    methods: {
      handleEdit(index, row){
      	console.log(this.standard);
        this.$http.put('/api/todolist/'+row.id+'/1',{standard:this.standard})
          .then((res)=>{
          if(res.status==200){
            this.tableData.splice(index, 1)
            this.$message({
              type:'success',
              message:'审核通过'
            })
          }else {
            this.$message({
              type:'info',
              message:'数据出错'
            })
          }
          })
      },
      handleDelete(index, row) {

        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http.delete('api/todolist/'+row.id)
          this.tableData.splice(index, 1)
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
  }
</script>
<style lang="scss">
  .basetable {
    .selectMenu {}
    .tableMain {
      margin: {
        top: 10px;
      };
    }
    .page {
      float: right;
      margin: {
        top: 10px;
      };
    }
  }
</style>
