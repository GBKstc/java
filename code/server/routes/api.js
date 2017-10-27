import api from '../controllers/todolist.js'
import koa_router from 'koa-router'
const router = koa_router()
//订餐接口
router.get('/todolist/:status/:page/:limit', api.getTodolist);
router.post('/todolist', api.createTodolist);
router.delete('/todolist/:id', api.removeTodolist);
router.put('/todolist/:id/:status', api.updateTodolist);
//点餐统计接口
router.post('/getdininglist', api.getDiningList);
router.post('/tododininglist', api.createDininglist);


export default router
