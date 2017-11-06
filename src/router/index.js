import Vue from 'vue'
import Router from 'vue-router'
import TeacherNav from '@/components/commons/TeacherNav.vue'

Vue.use(Router)

export default new Router({
  routes: [
   {
    path:'/student',
    component:resolve=>require(['../components/commons/StudentHome.vue'],resolve),
    children:[
      {
        path:'/student/password',
        component:resolve=>require(['../components/pages/stuPassword.vue'],resolve)
      },{
        path:'/student/notification',
        component:resolve=>require(['../components/pages/stuNotificationQuery'],resolve)
      },{
        path:'/student/classTable',
        component:resolve=>require(['../components/pages/stuClassTableQuery'],resolve)
      },{
        path:'/student/scoreQuery',
        component:resolve=>require(['../components/pages/scoreQuery'],resolve)
      },{
        path:'/student/courseQuery',
        component:resolve=>require(['../components/pages/coursequery'],resolve)
      }

    ]
  },{
      path: '/teacher',
      component: resolve=>require(['../components/commons/TeacherHome.vue'],resolve),
      children:[
        {
          path:'/teacher/password',
          component: resolve => require(['../components/pages/password.vue'],resolve)
        },{
          path:'/teacher/classTable',
          component:resolve=>require(['../components/pages/classTablequery'],resolve)
        },{
          path:'/teacher/notification',
          component:resolve=>require(['../components/pages/notificationquery'],resolve)
        },{
          path:'/teacher/registerScore',
          component:resolve=>require(['../components/pages/score'],resolve)
        },{
          path:'/teacher/changescore',
          component:resolve=>require(['../components/pages/changescore'],resolve)
        },{
          path: '/teacher/filesInfo',
          component: resolve => require(['../components/pages/filesInfo.vue'], resolve)
        },{
          path: '/teacher/batchscore',
          component: resolve => require(['../components/pages/batchscore.vue'], resolve)
        },{
          path: '/teacher/seescore',
          component: resolve => require(['../components/pages/seescore.vue'], resolve)
        }
		
		
		
       ] }

   
    
  ]
})
