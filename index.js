import Vue from 'vue'
import Router from 'vue-router'
import TeacherNav from '@/components/commons/TeacherNav.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: TeacherNav
    }
    ,{
      path:'/password',
      component: resolve => require(['../components/pages/password.vue'],resolve)
    },{
      path:'/classTable',
      component:resolve=>require(['../components/pages/classTablequery'],resolve)
    },{
      path:'/notification',
      component:resolve=>require(['../components/pages/notificationquery'],resolve)
    },{
      path: '/filesInfo',
      component: resolve => require(['../components/pages/filesInfo.vue'], resolve)
    }

    
  ]
})
