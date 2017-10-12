<template>
  <div class="basetable">
    <div class="tableMain">
      <el-row>
        <el-col :span="18">
          <el-table :data="tableData" style="width: 100%" v-loading='load'>
          <el-table-column prop="department.name" label="部门" width="100">
          </el-table-column>
          <!--<el-table-column prop="date" label="日期" width="200">-->
          <!--</el-table-column>-->
          <el-table-column prop="br_num" label="早餐人数" width="100">
          </el-table-column>
          <el-table-column prop="lu_num" label="午餐人数" width="100">
          </el-table-column>
          <el-table-column prop="di_num" label="晚餐人数" width="100">
          </el-table-column>
          <el-table-column prop="content" label="备注" >
          </el-table-column>

         </el-table>
        </el-col>
        <el-col :span="6">
          <el-form  ref="form" label-width="80px" id="form">
            <el-form-item label="就餐日期">
              <div class="block">
                <span class="demonstration"></span>
                <el-date-picker
                  v-model="date"
                  align="left"
                  type="date"
                  placeholder="选择日期">
                </el-date-picker>
              </div>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="getList()">查询</el-button>
              <el-button>取消</el-button>
            </el-form-item>
          </el-form>
        </el-col>
      </el-row>

    </div>

    <!--<el-dialog title="用户信息" :visible.sync="dialogFormVisible">-->

      <!--<div slot="footer" class="dialog-footer">-->
        <!--<el-button @click="dialogFormVisible = false">取 消</el-button>-->
        <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
      <!--</div>-->
    <!--</el-dialog>-->
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
        date:new Date()
      }
    },
    beforeCreate:function () {
      const token = sessionStorage.getItem('demo-token');
      if(token == null || token == 'null'){
        return null

      }else {
        let decode = jwt.verify(token, 'vue-koa-demo');
        console.log(decode);
        this.id = decode.id;
        this.name = decode.name;
      };
    },
    mounted:function () {
        if(this.name!='admin')return;
        this.getList();
    },
    methods: {
      getList:function () {
        this.$http.post('/api/getdininglist',{date:this.date})
          .then((res) => {
            if (res.status == 200) {
              this.tableData = res.data.data;
              console.log(res.data);
            } else {
              this.$message.error('获取列表失败！')
            }
          }, (err) => {
            this.$message.error('获取列表失败！')
            console.log(err)
          })
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
