<template>
  <div class="board"> 
    <header class="header">
      <div class="logo">教务系统</div>
      <div class="clear"></div>
      <div class="nav">
          <el-menu @select="handleSelect" class="el-menu-demo" default-active="onRoutes" mode="horizontal" theme="dark" id="navigator" unique-opened router>
              <template v-for="item in items">
                <template v-if="item.subs">
                  <el-submenu :index="item.index" class="modules">
                          <template slot="title">{{ item.title }}</template>
                          <template v-for="subItem in item.subs">
                          <el-menu-item :index="subItem.index">{{ subItem.title }}
                          </el-menu-item>
                          </template>
                      </el-submenu>
              </template>
                  <template v-else>
                      <el-menu-item :index="item.index"class="modules">
                        <i class="el-icon-menu"></i>{{ item.title }}
                      </el-menu-item>
                  </template>
              </template>
          </el-menu>
          
      </div>
      
    </header>  
    <div class="pos"></div>
  </div>


</template>

<script>

export default {
  name: 'adminstratorHead',
  data () {
    return {
      items:[{
        index: 'studentInformationManagement',
        title: '学生信息管理',
        subs:[
          {
            index:'/adminstrator/studentInfo',
            title:'学籍管理'
          },
          {
            index:'/adminstrator/stuCourseManagement',
            title:'课程管理'
          }
        ]
      },{
        index: 'teacherInformationManagement',
        title: '教师信息管理',
        subs:[
          {
            index:'/adminstrator/teacherInfo',
            title:'档案管理'
          },{
            index:'/adminstrator/teaCourseManagement',
            title:'课程管理'
          }
        ]
      },{index:'/adminstrator/adMakeAnAnnouncement',
         title:'发布通知'
      },{
        index:'login',
        title:'退出登录'
      }
      ]
    }
  },
  methods: {
    handleSelect: function (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}

</script>

<style scoped>
.clear{
  clear: both;
}
.board{
  /* //width: 100%;
  // margin-right:15px;
 // margin-left: 15px;
 // position: relative; */
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        line-height: 70px;
        color: #fff;
}
.header {
  background-color:#2D2F33;
  height: 70px;
 /* // background-color:lightgrey; */
  top: 0;
  left: 0;
  width: 100%;
  padding-bottom: 10px;
  line-height: 70px;
  z-index: 100;
  display: table;
  position: fixed;

}
.logo{
   font-family: "STKaiti";
  float: left;
  padding-left: 40px;
  font-size: 30px;
  color:cornflowerblue
}
.nav{
  width:100%;
}
.el-menu-demo{
  padding-right:15px;
  padding-left: 15px; 
}
.modules{
  width:25%;
  height: 60px;
  line-height: 60px;
  text-align: center;
  background: transparent;
  padding:0px ;
  
}

.pos{
  height:38px;
}

.myuser{
 margin-right:10px; 
}
 
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}

</style>