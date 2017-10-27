<template>
  <div class="header">

    <el-menu theme="dark" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <div class="logo">
        <a >杭州北车辆段订餐系统</a>
      </div>
      <el-submenu index="3">
        <template slot="title">用户设置({{username}})</template>
        <el-menu-item index="2-1" @click="signOut">退出登录</el-menu-item>
      </el-submenu>
      <!--<div></div>-->
    </el-menu>
    <div class="line"></div>
  </div>

</template>

<script type="text/ecmascript-6">
  import jwt from 'jsonwebtoken'
  export default{
    data(){
      return {
        activeIndex: '1',
        username: jwt.verify(sessionStorage.getItem('demo-token'), 'vue-koa-demo').name
      }
    },
    beforeCreate:function () {
//      const token = sessionStorage.getItem('demo-token');
//      if(token == null || token == 'null'){
//        return null
//
//      }else {
//        let decode = jwt.verify(token, 'vue-koa-demo');
//        console.log(decode);
//        this.id = decode.id;
//        this.name = decode.name;
//        this.jurisdiction = decode.jurisdiction;
////        this.show = decode.jurisdiction==0?false : true;
//      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      signOut(){
        sessionStorage.setItem('demo-token',null); // 将token清空
        this.$router.push({path: '/'});
      }

    }
  }

</script>
<style lang="scss">
  .header {
    width: 100%;
    position: fixed;
    z-index: 99;
    .el-menu-demo {
      width: 100%;
      min-width: 500px;
      border-radius: 0;
      display: flex;
      .menuSub {
        flex: 6;
        position: relative;
      }
      .logo {
        color: #ffffff;
        font-size: 30px;
        flex: 1;
        position: relative;
        top: 20px;
        left: 22px;
      }
    }
  }

</style>
