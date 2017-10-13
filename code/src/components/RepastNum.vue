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
          <el-option label="驻段验收室" value="驻段验收室"></el-option>
          <el-option label="材料科" value="材料科"></el-option>
          <el-option label="武装保卫科" value="武装保卫科"></el-option>
          <el-option label="经营开发部" value="经营开发部"></el-option>
          <el-option label="杭州设备车间" value="杭州设备车间"></el-option>
          <el-option label="乔司检修车间" value="乔司检修车间"></el-option>
          <el-option label="其他" value="999"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="就餐日期" prop="date">
        <div class="block">
          <span class="demonstration"></span>
          <el-date-picker
            v-model="form.date"
            align="left"
            type="date"
            placeholder="选择日期">
          </el-date-picker>
        </div>
      </el-form-item>
      <el-form-item label="早餐人数" prop="br_num">
        <el-input-number v-model="form.br_num"  :min="1" ></el-input-number>
      </el-form-item>
      <el-form-item label="午餐人数" prop="lu_num">
        <el-input-number v-model="form.lu_num"  :min="1" ></el-input-number>
      </el-form-item>
      <el-form-item label="晚餐人数" prop="di_num">
        <el-input-number v-model="form.di_num"  :min="1" ></el-input-number>
      </el-form-item>

      <el-form-item label="备注">
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
          date: null,
          br_num: null,
          lu_num: null,
          di_num: null,
          content: null,
        },
        rules: {
          dep_id: [
            {required: true, message: '请选择部门', trigger: 'blur'}
          ],
          date: [
            {type: 'date',required: true, message: '请选择日期', trigger: 'blur'}
          ],
//          br_num: [
//            {required: true, message: '请选择日期', trigger: 'blur'}
//          ],
//          lu_num: [
//            {required: true, message: '请选择日期', trigger: 'blur'}
//          ],
//          di_num: [
//            {required: true, message: '请选择日期', trigger: 'blur'}
//          ]
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
              this.addDiningList(form);
            } else {
              this.$message.error('请填写完整！');
              return false;
            }
          });

        },
        addDiningList(form){
          this.$http.post('/api/tododininglist', form)
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
//          console.log(this.$refs['form']);
//          Object.assign(this.$data, this.$options.data());
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
