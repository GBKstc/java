<template>
  <div class="basetable">
    <div class="tableMain">
      <el-row>
        <el-table :data="tableData" style="width: 100%" v-loading='load'>
          <el-table-column prop="department.name" label="部门" width="150">
          </el-table-column>
          <el-table-column prop="name" label="姓名" width="100">
          </el-table-column>
          <el-table-column prop="date" label="日期" width="200">
          </el-table-column>

          <el-table-column prop="diningform" label="就餐形式" width="100">
          </el-table-column>
          <el-table-column prop="standard" label="就餐标准" width="100">
          </el-table-column>
          <!--<el-table-column prop="status" label="status" width="100">-->
          <!--</el-table-column>-->
          <!--<el-table-column prop="id" label="id" width="100">-->
          <!--</el-table-column>-->
          <el-table-column prop="number" label="就餐人数" width="100">
          </el-table-column>
          <el-table-column prop="content" label="来客单位或事由" >
          </el-table-column>
        </el-table>
      </el-row>
      <el-row >
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-size="10"
          layout="prev, pager, next, jumper"
          :total="count">
        </el-pagination>
      </el-row>


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
        count:1,
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
//        if(this.name!='admin')return
//        this.getList();
      }
    },
    mounted:function () {
//      if(this.name!='admin')return;
      this.getList();
    },
    methods: {
      handleEdit(index, row){
        this.$http.put('api/todolist/'+row.id+'/1')
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
      getList(page){
      	let Page = page||1;
      	Page = Page-1;
//      	console.log(Page);
        this.$http.get('/api/todolist/1/'+Page+"/10")
          .then((res) => {
            if (res.status == 200) {
              this.tableData = res.data.todolist;
              this.count = res.data.count.count;
              console.log(res.data)
            } else {
              this.$message.error('获取列表失败！')
            }
          }, (err) => {
            this.$message.error('获取列表失败！')
            console.log(err)
          })
      },
      handleSizeChange(val) {
      	console.log("size"+val)
      },
      handleCurrentChange(page) {
        console.log("Current"+page);
        this.getList(page);
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
