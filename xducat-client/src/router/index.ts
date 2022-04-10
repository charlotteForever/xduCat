import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/login',
    name: '用户登录',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/searchResult',
    name: '猫咪搜索结果',
    component: () => import('../views/SearchResultView.vue')
  },
  {
    path: '/refresh',
    name: '刷新',
    component: () => import('../views/RefreshView.vue')
  },
  {
    path: '/catDetail',
    name: '猫咪详细信息',
    component: () => import('../views/CatDetailView.vue')
  },
  {
    path: '/:catchAll(.*)',
    name: '页面不存在',
    component: () => import('../views/NotFoundView.vue')
  },
  {
    path: '/*',
    redirect: '/home'
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
