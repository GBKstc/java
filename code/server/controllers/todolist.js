import todolist from '../models/todolist.js'

const getTodolist = async function (ctx) {
  const status = ctx.params.status // 获取url里传过来的参数里的id
  const result = await todolist.getTodolistById(status) // 通过await “同步”地返回查询结果
  ctx.body = result // 将请求的结果放到response的body里返回
};

const createTodolist = async function (ctx) {
  const data = ctx.request.body
  const result = await todolist.createTodolist(data)

  ctx.body = {
    success: true
  }
};

const removeTodolist = async function (ctx) {
  const id = ctx.params.id
  const result = await todolist.removeTodolist(id)

  ctx.body = {
    success: true
  }
};

const updateTodolist = async function (ctx) {
  console.log(ctx);
  const id = ctx.params.id;
  let status = ctx.params.status;
  let standard = ctx.request.body.standard;

  const result = await todolist.updateTodolist(id, status, standard);

  ctx.body = {
    success: true
  }
};
//点餐统计接口
const getDiningList = async function (ctx) {
  const data = ctx.request.body;
  const result = await todolist.getDiningList(data);
  console.log("getDiningList!!!");
  ctx.body = {
    success: true,
    data:result
  }
};

const createDininglist = async function (ctx) {
  const data = ctx.request.body;
  const result = await todolist.createDininglist(data);

  ctx.body = {
    success: true
  }
}

export default {
  //订餐接口
  getTodolist,
  createTodolist,
  removeTodolist,
  updateTodolist,
  //点餐统计接口
  getDiningList,
  createDininglist
}
