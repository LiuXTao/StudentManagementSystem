<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="clear"></div>
        <div class="mainborder">
            <div>
                <div class="left">
                    <el-col :span="25">
                <el-menu default-active="onRoutes" class="siderBar" @select="handleSelect" theme="light">
                    <el-menu-item index="unRead"><i class="el-icon-setting"></i>未读通知</el-menu-item>
                    <el-menu-item index="readed"><i class="el-icon-setting"></i>已读通知</el-menu-item>
                    <div class="tianchong"></div>
                </el-menu>
                 </el-col>
                </div>
                <div class="right">
                    <template v-if="selectIndex==('unRead')">
                        <un-read-list :child-un="this.tableData3" v-on:readedNo="readedNode">
                          
                        </un-read-list>
                    </template>
                    <template v-else-if="selectIndex==('readed')">
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
import vHead from '../commons/StudentNav.vue';
 import unReadList from './unreadNotificationList.vue';
  import ReadedList from './readNotificationList.vue';
export default {
  components:{
      vHead,
      unReadList,
      ReadedList
  },
created(){
      if(localStorage){
          this.stu_id=localStorage.getItem("stuId");
          console.log("---->>>>>-------",this.stu_id);
          console.log(localStorage.getItem("stuId"));
          localStorage.setItem("UserType",111);
      }else{
        alert("This browser does not support localStorage");
      }
      var vm=this;
      
      $.ajax({
        type:'post',
        url:'/student/notificationQuery',
        dataType:'json',
        data:{
          "id":this.stu_id
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
  data(){
      return {
        stu_id:'',
          selectIndex:'',
          tableData3:[],
          tableData4:[],
      }
  },
    methods:{
        handleSelect:function(key,keyPath){
            console.log(keyPath);
            this.selectIndex=key;
            var vm=this;
            this.tableData3=[],
            this.tableData4=[],
            $.ajax({
              type:'post',
              url:'/student/notificationQuery',
              dataType:'json',
              data:{
                "id":this.stu_id
              },
              success:function(response){
                console.log("-->",response);

                if(vm.response!=null);
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
          else {}
        }
    },
        readedNode(item){
            this.reList.unshift(item)
        }
    }

}
</script>
<style scoped>
.clear{
    clear: both;
}
.mainborder{
     border: 2px solid #F5F5F5;
      
}
.left{
  width: 14%;
  margin-top: 5px;
  float: left;
}
.tianchong{
  height: 400px;
  width: 100%
}
.right{
  float: right;
  width:85%;
  text-align: center;
   margin-top: 5px;
   background-color:#eef1f6;
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
