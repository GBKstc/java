<template>
  <div class="leftMenu">
    <el-menu :default-active="onRoutes" theme="dark" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" router>
      <el-menu-item index="/Home/Register"><i class="el-icon-menu"></i>预约订餐</el-menu-item>
      <el-menu-item index="/Home/RepastNum"><i class="el-icon-menu"></i>每日就餐统计</el-menu-item>
      <el-menu-item v-if="show" index="/Home/BaseTable"><i class="el-icon-message"></i>管理员</el-menu-item>
      <el-menu-item index="/Home/BaseTable1"><i class="el-icon-edit"></i>订餐表报</el-menu-item>
      <el-menu-item index="/Home/RepastNumTable"><i class="el-icon-edit"></i>就餐统计表报</el-menu-item>
      <el-menu-item v-if="show" index="/Home/UserTable"><i class="el-icon-setting"></i>用户添加</el-menu-item>
      <!--<el-menu-item index="/home/mainActive"><i class="el-icon-minus"></i>主页</el-menu-item>-->
      <!--<el-menu-item index="6"><i class="el-icon-view"></i>消息提示</el-menu-item>-->
      <!--<el-menu-item index="2"><i class="el-icon-star-off"></i>评分</el-menu-item>-->
      <!--<el-menu-item index="7"><i class="el-icon-star-on"></i>通知</el-menu-item>-->
    </el-menu>
  </div>
</template>

<script type="text/ecmascript-6">
  import jwt from 'jsonwebtoken'
  export default {
    data() {
      return {
        id:null,
        name:null,
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
        this.jurisdiction = decode.jurisdiction;
        this.show = decode.jurisdiction=="管理员"?true : false;
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      }
    },
    computed: {
      onRoutes() {
        return this.$route.path.replace('/', '');
      }
    }
  }
</script>
<style lang="scss">
  .leftMenu {
    display: block;
    position: fixed;
    bottom: 0;
    top: 60px;
    width: 190px;
    left: 0;
    z-index: 999;
    ul {
      height: 100%;
      border-radius: 0;
    }
  }
</style>
