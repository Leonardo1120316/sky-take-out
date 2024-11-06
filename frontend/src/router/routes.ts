import { path } from 'path';
//配置常量路由
export const routes = [
    {
        //登录
        path: '/login',
        component: () => import('@/views/login/index.vue'),
        name: 'login',
        meta: {
            title: '登录',
            hidden: true
        }
    },
    {
        //布局页
        path: '/',
        component: () => import('@/layout/index.vue'),
        name: 'layout',
        redirect: '/person',
        meta: {
            title: '个人中心',
            hidden: false,
            icon: 'House'
        },
    },
    {
        //任意路由页
        path: '/:pathMatch(.*)*',
        redirect: '/404',
        name: 'Any',
        meta: {
            title: "any",
            hidden: true
        }
    }
]

//任意路由
export const anyRoute = {
    //任意路由
    path: '/:pathMatch(.*)*',
    redirect: '/404',
    name: 'Any',
    meta: {
        title: '任意路由',
        hidden: true,
        icon: 'DataLine',
    },
}