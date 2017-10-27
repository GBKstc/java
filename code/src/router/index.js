import Vue from 'vue'
import Router from 'vue-router';
import Home from '../components/Home.vue'
import Login from '../components/Login.vue'
import BaseTabel from '../components/BaseTable.vue'
import BaseTabel1 from '../components/BaseTable1.vue'
import Register from '../components/Register.vue'
import RepastNum from '../components/RepastNum.vue'
import RepastNumTable from '../components/RepastNumTable.vue'
import UserTable from '../components/UserTable.vue'

Vue.use(Router);
export default new Router({
  mode: 'history', // 开启HTML5的history模式，可以让地址栏的url长得跟正常页面跳转的url一样。
  base: __dirname,
  routes:[
    {
      path:'/Home',
      component:Home,
      children:[
        {
          path:'/Home',
          redirect:'/Home/Register',
          component:Register,
          children:[{
            path:'/Home/Register'
          }]
        }, {
          path:'/Home/RepastNum',
          component:RepastNum
        }, {
        path:'/Home/BaseTable',
          component:BaseTabel
        }, {
          path:'/Home/BaseTable1',
          component:BaseTabel1
        }, {
          path:'/Home/RepastNumTable',
          component:RepastNumTable
        }, {
          path:'/Home/UserTable',
          component:UserTable
        }

      ]
    },{
    path:'/',
      component:Login
    }
  ]
})
