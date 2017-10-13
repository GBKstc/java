import todolist from '../models/todolist.js'

const getTodolist = async function (ctx) {
  const status = ctx.params.status; // 获取url里传过来的参数里的status
  const page = ctx.params.page;// 获取url里传过来的参数里的page
  const limit = ctx.params.limit;// 获取url里传过来的参数里的page
  console.log(page);
  const result = await todolist.getTodolistById(status,page,limit); // 通过await “同步”地返回查询结果
  ctx.body = result // 将请求的结果放到response的body里返回
};

const createTodolist = async function (ctx) {
  const data = ctx.request.body;
  const result = await todolist.createTodolist(data);

  ctx.body = {
    success: true
  }
};

const removeTodolist = async function (ctx) {
  const id = ctx.params.id;
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
  console.log(result);
  let length = result.length;
  let di_numAll = 0;
  let br_numAll = 0;
  let lu_numAll = 0;
  if (length!=0){
    for (let i=0;i<length;i++){
      di_numAll = result[i].di_num+di_numAll;
      br_numAll = result[i].br_num+br_numAll;
      lu_numAll = result[i].lu_num+lu_numAll;
    }
  }
  //合计
  let total = {
    id: null,
    content: null,
    date: "0000-00-00 00:00:00",
    dep_id: 1000,
    department: {name: "合计"},
    di_num: di_numAll,
    br_num: br_numAll,
    lu_num: lu_numAll,
  };
  result.push(total);
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
