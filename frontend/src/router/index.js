import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'welcome',
            component: () => import('@/views/WelcomeView.vue'),
            children: [
                {
                    path: '',
                    name: 'welcome-login',
                    component: () => import('@/components/welcome/LoginPage.vue')
                },
                {
                    path: 'register',
                    name: 'welcome-register',
                    component: () => import('@/components/welcome/RegisterPage.vue')
                }
            ]
        },
        {
            path: '/index',
            name: 'index',
            component: () => import('@/views/IndexView.vue')
        },
        {
            path:'/admin',
            name: 'admin',
            component: () => import('@/views/AdminView.vue'),
            children:[
                {
                    path: 'userList',
                    name: 'admin-userList',
                    component:()=> import('@/components/manage/UserListPage.vue')
                },
            ]
        },
        {
            path: '/admin/editUser/:userId',
            name: 'admin-editUser',
            component:()=> import('@/components/manage/EditUserPage.vue')
        }
    ]
})

export default router
