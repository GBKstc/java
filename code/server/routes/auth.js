import auth from '../controllers/user.js'
import koa_router from 'koa-router'
const router = koa_router()

router.get('/user/:id', auth.getUserInfo); // 定义url的参数是id
router.get('/userList', auth.getUserInfoList); // 定义url的参数是id
router.post('/user', auth.postUserAuth);
router.post('/addUser', auth.createUser);
router.delete('/deleteUser/:id', auth.removeUser);

export default router
