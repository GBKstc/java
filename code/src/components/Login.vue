<template>
  <div class="login-root">
      <div class="login-form" @keyup.enter="loginToDo">
        <p>杭州北车辆段订餐系统</p>
        <label>
          <i class="fa fa-user-o fw" aria-hidden="true"></i>
          <input type="text" v-model="account" placeholder="用户名">
        </label>
        <label>
          <i class="fa fa-lock fw" aria-hidden="true"></i>
          <input type="password" v-model="password" placeholder="密码">
        </label>
        <button @click="loginToDo">确认登录</button>
      </div>
    </div>
</template>


<script>
export default {
  data () {
    return {
      account: '',
      password: ''
    };
  },
  methods: {
    loginToDo() {
      let obj = {
        name: this.account,
        password: this.password
      }
      this.$http.post('/auth/user', obj) // 将信息发送给后端
        .then((res) => {
          console.log(res);
          if(res.data.success){ // 如果成功
            sessionStorage.setItem('demo-token',res.data.token); // 用sessionStorage把token存下来
            this.$message({ // 登录成功，显示提示语
              type: 'success',
              message: '登录成功！'
            });
            this.$router.push('/Home') // 进入todolist页面，登录成功
          }else{
            this.$message.error(res.data.info); // 登录失败，显示提示语
            sessionStorage.setItem('demo-token',null); // 将token清空
          }
        }, (err) => {
            this.$message.error('请求错误！')
            sessionStorage.setItem('demo-token',null); // 将token清空
        })
    }
  }
};
</script>
<style lang="scss" scoped>

  p {
    color: white;
  }

  .login-root {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: url("../assets/background.jpg");
    background-size: cover;
    text-align: center;
    font-weight: lighter;
  }



  .login-form {
    box-sizing: border-box;
    width: 340px;
    position: absolute;
    left: 70%;
    border-radius: 4px;
    height: 420px;
    top: 10%;
    font-weight: lighter;
    background-color: rgba(255,255,255,0.5);
    padding: 50px 0;

    p {
      font-size: 26px;
      color: #20a0ff;
    }

    label {
      display: block;
      color: #ccc;
      font-size: 20px;
      height: 40px;
      margin: 40px 0;
    }

    i {
      font-size: 14px;
    }

    input {
      height: 40px;
      padding: 0 10px;
      display: inline-block;
      width: 70%;
      color: #666666;
      font-size: 16px;
      border: none;
      border-bottom: 1px solid #e4e4e4;
      outline: none;
      &::placeholder {
        color: #8c939d;
      }
    }

    button {
      float: right;
      outline: none;
      margin: 40px 30px 0 0;
      height: 34px;
      width: 80px;
      border: none;
      background-color: #20a0ff;
      color: white;
      font-size: 14px;
      font-weight: lighter;
      border-radius: 4px;
      cursor: pointer;
      transition: all 0.3s;
      &:hover {
        background-color: #4db3ff;
      }
      &:active {
        background-color: #1d90e6;
      }
    }
  }
</style>
