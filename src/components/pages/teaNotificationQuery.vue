<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
    <div class="mainborder">
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
        <div class="right" >
          <template v-if="selectIndex==('unRead')">
            <un-read-list :child-un="this.tableData3" v-on:readedNo="readedNode"></un-read-list>
          </template>
          <template v-else-if="selectIndex==('Readed')">
            <readed-list :child-ed="this.tableData4"></readed-list>
          </template>
          <template v-else>
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
  import unReadList from './unreadNotificationList.vue'
  import ReadedList from './readNotificationList.vue'
  export default {
    name:'passmodi',
    components:{
              vHead,
              unReadList,
              ReadedList,
          },
    created(){
      if(localStorage){
          this.tea_id=localStorage.getItem("teaId");
          console.log("---->>>>>-------",this.tea_id);
          console.log(localStorage.getItem("teaId"));
          localStorage.setItem("UserType",110);
      }else{
        alert("This browser does not support localStorage");
      }
      var vm=this;
      
      $.ajax({
        type:'post',
        url:'/teacher/notificationQuery',
        dataType:'json',
        data:{
          "id":this.tea_id
        },
        success:function(response){
          console.log("-->",response);
          vm.analysisData(vm,response.string);
          console.log("结束");
        },
        error:function(err){
          console.log(err);
          console.log("error");
        }
      })
    },
    data () {
      
      return {
        tea_id:'',
       selectIndex:'',
        tableData3:[],
        tableData4:[],
      }
    },
    methods: {
    handleSelect:function(key,keyPath){
      this.selectIndex=key;
      console.log(this.selectIndex);
      var vm=this;
      this.tableData3=[],
      this.tableData4=[],
      $.ajax({
        type:'post',
        url:'/teacher/notificationQuery',
        dataType:'json',
        data:{
          "id":this.tea_id
        },
        success:function(response){
          console.log("-->",response);
          vm.analysisData(vm,response.string);
          console.log("结束");
        },
        error:function(err){
          console.log(err);
          console.log("error");
        }
      })
    },
    analysisData(vm,responseData){
      if(responseData)
      var arraya=responseData.split(';')
      console.log(arraya.length)
        for(var i=0;i<arraya.length;i++){
          var ele=arraya[i].split(',');
          var dist=new Array();
          for(var j=0;j<ele.length;j++){
            var eleItem=ele[j].split(':')
            console.log(eleItem[0],'->',eleItem[1])
            dist[eleItem[0]]=eleItem[1]
          }
          
          if(dist.readed=='0')
            vm.tableData3.push(dist)
          else if(dist.readed=='1')
            vm.tableData4.push(dist)
          else{}

        }
    },
    readedNode(item){
      // console.log(item.name);
      this.tableData4.unshift(item);
      // console.log(this.tableData4[0].name)
    }
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
  width:85%;
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

  