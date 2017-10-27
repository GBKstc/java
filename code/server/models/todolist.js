import db from '../config/db.js' // 引入todolist的表结构
const todoModel = '../schema/list.js';
const diningModel = '../schema/dining_statistics.js';
const departmentModel = '../schema/department.js';
const TodolistDb = db.Todolist // 引入数据库
const format = require('date-fns/format');
const Todolist = TodolistDb.import(todoModel);
const Dininglist = TodolistDb.import(diningModel);
const Department = TodolistDb.import(departmentModel);
Todolist.belongsTo(Department,{foreignKey:'dep_id'});
Dininglist.belongsTo(Department,{foreignKey:'dep_id'});

const getTodolistById = async function (status,page,limit) {
  let Offset = page*limit;
  const todolist = await Todolist.findAll({ // 查找全部的todolist
    where:{
      status:status
    },
    order: "id DESC",
    offset: Offset, //跳过 offset 条
    limit : 10,//获取 limit 条
    attributes: ['id', 'content', 'status','name','number','diningform','date','dep_id','phone','standard'],
    include:{model:Department,attributes:['name']}
  });
  const Count = await Todolist.findOne({ //获取总数量
    where:{
      status:status,
    },
    attributes: [[TodolistDb.fn('COUNT', TodolistDb.col('id')), 'count']],
  });
  let data = {
    todolist:todolist,
    count:Count,
  };
  return data ;// 返回数据
};

const createTodolist = async function (data) {
  await Todolist.create({
    name: data.name,
    content: data.content,
    status: data.status||0,
    diningform:data.diningform,
    date:format(data.date, 'YYYY-MM-DD HH:mm:ss'),
    number:data.number,
    dep_id:data.dep_id,
    phone:data.phone
  })
  return true
};

const removeTodolist = async function (id) {
  await Todolist.destroy({
    where: {
      id
    }
  })
  return true
};

const updateTodolist = async function (id, status, standard) {
  await Todolist.update(
    {
      status:status,
      standard:standard
    },
    {
      where: {
        id,
      }
    }
  )
  return true
};
const getDiningList = async function (data) {

  const diningList = await Dininglist.findAll({ // 查找全部的list
    where:{
      date:format(data.date, 'YYYY-MM-DD')+" 00:00:00"
    },
    order: "dep_id",
    limit : 200,
    attributes: ['id', 'content', 'br_num','lu_num','di_num','dep_id','date'],
    include:{model:Department,attributes:['name']}
  });
  return diningList // 返回数据
  // return null;
};

const createDininglist = async function (data) {
  await Dininglist.create({
    name: data.name,
    content: data.content,
    date:format(data.date, 'YYYY-MM-DD HH:mm:ss'),
    br_num:data.br_num,
    lu_num:data.lu_num,
    di_num:data.di_num,
    dep_id:data.dep_id
  });
  return true
};

export default {
  //订餐接口
  getTodolistById,
  createTodolist,
  removeTodolist,
  updateTodolist,
  //点餐统计接口
  createDininglist,
  getDiningList
}
