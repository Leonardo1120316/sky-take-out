import { createRouter, createWebHashHistory } from 'vue-router'
import { routes } from './routes'       
import nprogress from 'nprogress';
import '../../node_modules/nprogress/nprogress.css'
import EmployeeStore from '@/store/modules/employee';

const router = createRouter({
    routes: routes,
    history: createWebHashHistory(),
    scrollBehavior() {
        return {
          left: 0,
          top: 0,
        }
      },
});
router.beforeEach(async (to: any,from:any,next:any)=>{
  nprogress.start()
  let employeeStore = EmployeeStore()
  let token = employeeStore.token
  if(token) {
         next()
  }else{
        //非登录状态，只允许进入登录和注册页面，输入其他路由跳转登录页
          if(to.path == '/login'|| to.path =='/register' ){
                  next()
          }else{
                  next({path:'/login'})
          }
  }
}
)
router.afterEach((to: any,from:any,next:any)=>{
  nprogress.done()
})
export default router