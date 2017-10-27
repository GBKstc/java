<template>
  <div class="basetable">
    <div class="tableMain">
      <el-row>
        添加账户：
        <el-button
          type="primary"
          @click="dialogFormVisible = true">添加账户</el-button>
      </el-row>
      <el-row>
        <el-table :data="tableData" style="width: 100%" v-loading='load'>
          <el-table-column prop="id" label="id" width="100">
          </el-table-column>
          <el-table-column prop="user_name" label="姓名" width="100">
          </el-table-column>
          <el-table-column prop="jurisdiction" label="权限" width="100">
          </el-table-column>
          <el-table-column label="操作"  width="150">
            <template scope="scope">
              <el-button
                size="small"
                type="danger"
                @click="handleDelete(scope.$index, scope.row,scope)">删除账户</el-button>
            </template>
          </el-table-column>

        </el-table>
      </el-row>
      <!--<el-row>-->
        <!--<el-pagination-->
          <!--@size-change="handleSizeChange"-->
          <!--@current-change="handleCurrentChange"-->
          <!--:page-size="10"-->
          <!--layout="prev, pager, next, jumper"-->
          <!--:total="count">-->
        <!--</el-pagination>-->
      <!--</el-row>-->
    </div>
    <el-dialog title="用户信息" :visible.sync="dialogFormVisible">
      <el-row>
          <el-form :rules="rules" ref="form" :model="form" label-width="80px" id="form">
            <el-form-item label="用户名" prop="user_name">
              <el-input v-model="form.user_name"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
              <el-input v-model="form.password"></el-input>
            </el-form-item>
            <el-form-item label="再次输入" prop="againpassword">
              <el-input v-model="form.againpassword"></el-input>
            </el-form-item>
            <el-form-item label="账户权限" prop="jurisdiction">
              <el-select v-model="form.jurisdiction" placeholder="账户权限">
                <el-option label="管理员" value="管理员"></el-option>
                <el-option label="用户" value="用户"></el-option>
              </el-select>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="onSubmit(form)">确认添加</el-button>
              <el-button @click="dialogFormVisible = false">取消</el-button>
            </el-form-item>
          </el-form>

      </el-row>

      <!--<div slot="footer" class="dialog-footer">-->
        <!--<el-button >取 消</el-button>-->
        <!--<el-button type="primary" @click="dialogFormVisible = false">确 定</el-button>-->
      <!--</div>-->
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
        form: {
          user_name:null,
          password:null,
          againpassword:null,
          jurisdiction:null,
        },
        value6: '',
        currentPage3: 1,
        load: false,
        standard:[],//就餐标准
        count:1,
        jurisdiction:null,
        rules: {
          user_name: [
            {required: true, message: '请输入用户名', trigger: 'blur'},
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'},
          ],
          againpassword: [
            {required: true, message: '请再次输入密码', trigger: 'blur'},
          ],
          jurisdiction: [
            {required: true, message: '请选择账户权限', trigger: 'blur'},
          ]
        }
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

      }
    },
    mounted:function () {
//      if(this.name!='admin')return false;
     this.getList();
    },
    methods: {
      handleEdit(index, row, scope){
//      	console.log(index, row, scope);
//      	this.form = row;
//      	let id = row.id;
//      	let password = row.password;
//      	this.jurisdiction = row.jurisdiction;
//      	this.user_name = row.user_name;
//      	this.dialogFormVisible = true;
      },
      handleDelete(index, row) {

        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http.delete('/auth/deleteUser/'+row.id)
            .then((res) => {
              if (res.status == 200) {
                this.tableData.splice(index, 1);
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                });
              } else {
                this.$message.error('删除失败！')
              }
            }, (err) => {
              this.$message.error('删除错误！')
              console.log(err)
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
      handleCurrentChange(page) {
        console.log("Current"+page);
        this.getList(page);
      },
      getList(page){
        let Page = page||1;
        Page = Page-1;
//      	console.log(Page);
        this.$http.get('/auth/userList')
          .then((res) => {
          if (res.status == 200) {
              this.tableData = res.data.data;
              console.log(res.data)
          } else {
            this.$message.error('获取列表失败！')
          }
        }, (err) => {
          this.$message.error('获取列表失败！')
          console.log(err)
        })
      },
      onSubmit(form) {
        this.$refs['form'].validate((valid) => {
          if (valid) {
          	if(form.password!==form.againpassword){
              this.$message.error('两次密码不一致！');
              return false;
            }
            this.addUserInfo(form);
          } else {
            this.$message.error('请填写完整！');
            return false;
          }
        });
      },
      addUserInfo(data){
        this.$http.post('/auth/addUser',data)
          .then((res)=>{
          if(res.status==200){
//            this.tableData.splice(index, 1);
//            this.standard.splice(index, 1);
            this.$message({
              type:'success',
              message:'添加成功'
            });
            this.dialogFormVisible = false;
            this.getList(1);
          }else {
            this.$message({
              type:'info',
              message:'添加失败'
            })
          }
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
