import Vue from 'vue'
import Router from 'vue-router'
import TeacherNav from '@/components/commons/TeacherNav.vue'

Vue.use(Router)

export default new Router({
  routes: [
        {
            path: '/',
            redirect: '/login'
        },
		{
            path: '/student/login',
            redirect: '/login'
        },
		{
            path: '/teacher/login',
            redirect: '/login'
        },
		{
            path: '/adminstrator/login',
            redirect: '/login'
        },
        {
            path: '/login',
            component: resolve => require(['../components/pages/login.vue'], resolve)
        },{
            path: '/modifypassword',
            component: resolve => require(['../components/pages/modifyPassword.vue'], resolve)
        },
		
   {
    path:'/student',
    component:resolve=>require(['../components/commons/StudentHome.vue'],resolve),
    children:[
      {
        path:'/student/password',
        component:resolve=>require(['../components/pages/stuPassword.vue'],resolve)
      }, {
        path:'/student/fileInfo',
        component:resolve=>require(['../components/pages/stuFileInfo'],resolve)
      },{
        path:'/student/notification',
        component:resolve=>require(['../components/pages/stuNotificationQuery'],resolve)
      },{
        path:'/student/classTable',
        component:resolve=>require(['../components/pages/stuClassTableQuery'],resolve)
      },{
        path:'/student/scoreQuery',
        component:resolve=>require(['../components/pages/stuScoreQuery'],resolve)
      },{
        path:'/student/courseQuery',
        component:resolve=>require(['../components/pages/stuCourseQuery'],resolve)
      },{
        path:'/student/selectclass',
        component:resolve=>require(['../components/pages/stuSelectClass'],resolve)
      },{
        path:'/student/dropclass',
        component:resolve=>require(['../components/pages/stuDropClass'],resolve)
      },{
        path:'/student/selectedclass',
        component:resolve=>require(['../components/pages/stuSelectedClass'],resolve)
      }

    ]
  },{
      path: '/teacher',
      component: resolve=>require(['../components/commons/TeacherHome.vue'],resolve),
      children:[
        {
          path:'/teacher/password',
          component: resolve => require(['../components/pages/teaPassword.vue'],resolve)
        },{
          path:'/teacher/classTable',
          component:resolve=>require(['../components/pages/teaClassTablequery'],resolve)
        },{
          path:'/teacher/notification',
          component:resolve=>require(['../components/pages/teaNotificationQuery'],resolve)
        },{
          path:'/teacher/registerScore',
          component:resolve=>require(['../components/pages/teaScore'],resolve)
        },{
          path:'/teacher/changescore',
          component:resolve=>require(['../components/pages/teaChangeScore'],resolve)
        },{
          path: '/teacher/filesInfo',
          component: resolve => require(['../components/pages/teaFilesInfo.vue'], resolve)
        },{
          path: '/teacher/batchscore',
          component: resolve => require(['../components/pages/teaBatchScore.vue'], resolve)
        },{
          path: '/teacher/seescore',
          component: resolve => require(['../components/pages/teaSeeScore.vue'], resolve)
        }
		
		
		
       ] },
         {
      path: '/adminstrator',
      component: resolve=>require(['../components/commons/AdminstratorHome.vue'],resolve),
      children:[
        {
          path:'/adminstrator/studentInfo',
          component: resolve=>require(['../components/pages/adStuInfo.vue'],resolve)
        },
        {
          path:'/adminstrator/studentInfo/:Id',
          component: resolve=>require(['../components/pages/adStuInfoId.vue'],resolve)
        },
        {
          path:'/adminstrator/studentInfoModify/:Id',
          component: resolve=>require(['../components/pages/adStuInfoModify.vue'],resolve)
        },
        {
          path:'/adminstrator/studentInfoAdd',
          component: resolve=>require(['../components/pages/adStuInfoAdd.vue'],resolve)
        },
        {
          path:'/adminstrator/stuCourseManagement',
          component: resolve=>require(['../components/pages/adStuCourse.vue'],resolve)
        },
        {
          path:'/adminstrator/stuCourseManagement/:Id',
          component: resolve=>require(['../components/pages/adStuCourseSelected.vue'],resolve)
        },
        {
          path:'/adminstrator/teacherInfo',
          component: resolve=>require(['../components/pages/adTeaInfo.vue'],resolve)
        },
        {
          path:'/adminstrator/teacherInfo/:Id',
          component: resolve=>require(['../components/pages/adTeaInfoId.vue'],resolve)
        },
        {
          path:'/adminstrator/teacherInfoModify/:Id',
          component: resolve=>require(['../components/pages/adTeaInfoModify.vue'],resolve)
        },
        {
          path:'/adminstrator/teacherInfoAdd',
          component: resolve=>require(['../components/pages/adTeaInfoAdd.vue'],resolve)
        },
        {
          path:'/adminstrator/teaCourseManagement',
          component: resolve=>require(['../components/pages/adTeaCourse.vue'],resolve)
        },
        {
          path:'/adminstrator/teaCourseManagement/:Id',
          component: resolve=>require(['../components/pages/adTeaCourseInfo.vue'],resolve)
        },
        {
          path:'/adminstrator/teaCourseManagementModify/:Id',
          component: resolve=>require(['../components/pages/adTeaCourseInfoModify.vue'],resolve)
        },
        {
          path:'/adminstrator/teaCourseAdd',
          component: resolve=>require(['../components/pages/adTeaCourseAdd.vue'],resolve)
        }
        ,
        {
          path:'/adminstrator/adMakeAnAnnouncement',
          component: resolve=>require(['../components/pages/adMakeAnAnnouncement.vue'],resolve)
        }
      ]
    }
   
    
  ]
})
