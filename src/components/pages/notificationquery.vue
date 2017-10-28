<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
    <div class="mainborder">
      <!-- <div class="position">
        <div class="el-icon-caret-right">当前位置</div>
          >>
        <template v-for='index in indexs'> </template> -->
          <!-- <template v-for="index in indexs">
          <a  :href='index.url'>{{index.title}}</a>
          <template v-if="index.subs.size==0">
            >>
            <template v-for="subindex in index.subs">
            <a  :href='subindex.url'>{{subindex.title}}</a>
            </template>
          </template>
          </template>
        </div> --> 
    
      <div>
      <div class="left">
         <el-col :span="25">
        <el-menu default-active="onRoutes" class="el-menu-vertical-demo" @select="handleSelect" theme="light">
          <el-menu-item index="unRead"><i class="el-icon-setting"></i>未读通知</el-menu-item>
          <el-menu-item index="Readed"><i class="el-icon-setting"></i>已读通知</el-menu-item>
          <div class="tianchong"></div>
        </el-menu>
         </el-col>
        </div>
        <div class="right">
          <template v-if="selectIndex==('Unread')">
            <right></right>
          </template>
          <template v-else>
            <security-ques></security-ques> 
          </template>
        </div>

     <div class="clear"></div>
      </div>
    </div>
  
  </div>
</div>
</template>
    
<script>
  import vHead from '../commons/TeacherNav';

  var selectIndex='';
  export default {
    name:'passmodi',
    components:{
              vHead,
          
          },
    data () {
      return {

      }
    },
    methods: {
    handleSelect:function(key,keyPath){
      this.selectIndex=key;
      console.log(this.selectIndex);
   
    },

    }
  };


</script>


<style scoped>

.mainborder{
  border: 2px solid #F5F5F5;
 
}
.clear{
  clear: both;
}
.left{
  width: 14%;
  margin-top: 5px;
  float: left;
}
.right{
  float: right;
  width:85%;height:500px;
  text-align: center;
   margin-top: 5px;
   background-color:#eef1f6;
}

.tianchong{
  height: 400px;
  width: 100%
}

.position{
  margin-left:15px; 
  float:left;

}
  .el-row {
    margin-bottom: 20px;

  }
  .el-col {
    border-radius: 4px;
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

  