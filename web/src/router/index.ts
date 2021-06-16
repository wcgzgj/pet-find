import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import Find from '../views/Find.vue'
import About from '../views/About.vue'
import Upload from '../views/Upload.vue'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/find',
    name: 'Find',
    component: Find,
    meta:{
      needLogin: true
    }
  },
  {
    path: '/upload',
    name: 'Upload',
    component: Upload,
    meta:{
      needLogin: true
    }
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
