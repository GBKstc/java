<template>
  <div class="register">
    <el-form :rules="rules" ref="form" :model="form" label-width="80px" id="form">
      <el-form-item label="就餐部门" prop="dep_id">
        <el-select v-model="form.dep_id" placeholder="就餐部门">
          <el-option label="党群办" value="1"></el-option>
          <el-option label="办公室" value="2"></el-option>
          <el-option label="技术科" value="3"></el-option>
          <el-option label="安全质量科(安全)" value="4"></el-option>
          <el-option label="安全质量科(质检)" value="5"></el-option>
          <el-option label="调度科" value="6"></el-option>
          <el-option label="计划财务科" value="7"></el-option>
          <el-option label="劳动人事科" value="8"></el-option>
          <el-option label="职工教育科" value="9"></el-option>
          <el-option label="驻段验收室" value="10"></el-option>
          <el-option label="材料科" value="11"></el-option>
          <el-option label="武装保卫科" value="12"></el-option>
          <el-option label="经营开发部" value="13"></el-option>
          <el-option label="杭州设备车间" value="14"></el-option>
          <el-option label="乔司检修车间" value="15"></el-option>
          <el-option label="其他" value="999"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="使用人" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="联系电话" prop="phone">
        <el-input v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item label="就餐形式" prop="diningform">
        <el-select v-model="form.diningform" placeholder="就餐形式">
          <el-option label="餐桌" value="餐桌"></el-option>
          <el-option label="托盘" value="托盘"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="就餐日期" prop="date">
        <div class="block">
          <span class="demonstration"></span>
          <el-date-picker
            v-model="form.date"
            type="datetime"
            placeholder="选择日期时间">
          </el-date-picker>
        </div>
      </el-form-item>
      <el-form-item label="就餐人数">
        <el-input-number v-model="form.number"  :min="1" ></el-input-number>

      </el-form-item>

      <el-form-item label="来客单位或事由">
        <el-input type="textarea"  v-model="form.content"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit(form)">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>

</template>

<script type="text/ecmascript-6">

  export default {

    data() {
      return {
        form: {
          dep_id: null,
          name: null,
          phone: null,
          diningform: null,
          date: null,
          number:null,
          content: null,
        },
        //
        rules: {
          dep_id: [
            {required: true, message: '请选择部门', trigger: 'blur'},
          ],
          name: [
            {required: true, message: '请输入您的姓名', trigger: 'blur'},
          ],
          phone: [
            {required: true, message: '请输入您的联系方式', trigger: 'blur'},
          ],
          date: [
            {type: 'date',required: true, message: '请选择日期', trigger: 'blur'},
          ],
          diningform: [
            {required: true, message: '请输入就餐形式', trigger: 'blur'},
          ]
        }
      }
    },
    methods:
      {
        getUserInfo(){
          const token = sessionStorage.getItem('demo-token');
          if(token != null && token != 'null'){
            let decode = jwt.verify(token,'vue-koa-demo');
            return decode
          }else {
            return null
          }
        },
        onSubmit(form) {
          this.$refs['form'].validate((valid) => {
            if (valid) {
              this.addForm(form);
//              this.resetForm(form);
            } else {
              this.$message.error('请填写完整！')
              return false;
            }
          });
        },
        addForm(form){
          this.$http.post('/api/todolist', form)
            .then((res) => {
              if (res.status == 200) {
                this.$message({
                  type: 'success',
                  message: '创建成功！'
                })

                this.resetForm(form);

              } else {
                this.$message.error('创建失败！')
              }
            }, (err) => {
              this.$message.error('创建失败！')
              console.log(err)
            })
        },
        resetForm(form) {
//        	console.log(this.$refs['form']);
          Object.assign(this.$data, this.$options.data());
//          this.form.reset();
          this.$refs['form'].resetFields();
        }

      }


  }
</script>
<style lang="scss">
  .register {
    width: 30%;
    min-width: 400px;
  }
</style>
