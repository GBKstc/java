import user from '../models/user.js'
import jwt from 'jsonwebtoken'
// import bcrypt from 'bcryptjs'

const getUserInfo = async function (ctx) {
  const id = ctx.params.id // 获取url里传过来的参数里的id
  const result = await user.getUserById(id) // 通过await “同步”地返回查询结果
  console.log(result)
  ctx.body = result // 将请求的结果放到response的body里返回
};

const getUserInfoList = async function (ctx) {
  const result = await user.getUserInfoList() // 通过await “同步”地返回查询结果

  ctx.body = {
    success: true,
    data:result
  }; // 将请求的结果放到response的body里返回
}

const postUserAuth = async function (ctx) {
  const data = ctx.request.body // post过来的数据存在request.body里
  const userInfo = await user.getUserByName(data.name)
  console.log(ctx.request)
  if (userInfo != null) { // 如果查无此用户会返回null
    // if (!bcrypt.compareSync(data.password, userInfo.password)) {
    if (data.password!==userInfo.password) {
      ctx.body = {
        success: false, // success标志位是方便前端判断返回是正确与否
        info: '密码错误！'
      }
    } else {
      const userToken = {
        name: userInfo.user_name,
        id: userInfo.id,
        jurisdiction: userInfo.jurisdiction,
      }
      const secret = 'vue-koa-demo';// 指定密钥
      const token = jwt.sign(userToken, secret) // 签发token
      ctx.body = {
        success: true,
        token: token // 返回token
      }
    }
  } else {
    ctx.body = {
      success: false,
      info: '用户不存在！' // 如果用户不存在返回用户不存在
    }
  }
};

const createUser = async function (ctx) {
  const data = ctx.request.body;
  console.log(data);
  const result = await user.createUser(data);

  ctx.body = {
    success: result
  }
};

const removeUser = async function (ctx) {
  const id = ctx.params.id
  console.log(id);
  const result = await user.removeUser(id);

  ctx.body = {
    success: result
  }
}

export default {
  getUserInfo,
  postUserAuth,
  getUserInfoList,
  createUser,
  removeUser
}
