<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
    <div class="mainborder">
     
    
      <div>
      <div class="left">
         
        <el-menu   class="el-menu-vertical-demo" @select="handleSelect" theme="light">
          <el-menu-item index="modify"><i class="el-icon-setting"></i>修改密码</el-menu-item>
          <el-menu-item index="question"><i class="el-icon-setting"></i>修改密保</el-menu-item>
          <div class="tianchong"></div>
        </el-menu>
       
        </div>
        <div class="right">
          <template v-if="selectIndex==('modify')">
            <right></right>
          </template>
          <template v-else-if="selectIndex==('question')">
            <security-ques :security-ques="this.securityQues" ></security-ques> 
          </template>
          <template v-else>
          </template>
        </div>

     <div class="clear"></div>
      </div>
    </div>
  
  
</div>
</template>
    
<script>
  import vHead from '../commons/TeacherNav';
  import right from './passwordModify';
  import securityQues from './securityQuestionModify.vue';
  
  export default {
    name:'passmodi',
    components:{
              vHead,
              right,
              securityQues
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
        url:'/teacher/securityQuery',
        dataType:'json',
        data:{
          "id":this.tea_id
        },
        success:function(response){
          console.log("-->",response);
          vm.securityQues.firstP=response.queone;
          vm.securityQues.firstA=response.ansone;
          vm.securityQues.secondP=response.quetwo;
          vm.securityQues.secondA=response.anstwo;
          vm.securityQues.thirdP=response.quethree;
          vm.securityQues.thirdA=response.ansthree;
        }
      })
    },
    data () {

      return {
        tea_id:'',
        selectIndex:'',
        securityQues: {
            firstP:"",
            firstA:"",
            secondP:"",
            secondA:"",
            thirdP:"",
            thirdA:""
        },
      }
    },
    methods: {
    handleSelect:function(key,keyPath){
      this.selectIndex=key;
      console.log(this.selectIndex);
      var vm=this;
      $.ajax({
        type:'post',
        url:'/teacher/securityQuery',
        dataType:'json',
        data:{
          "id":this.tea_id
        },
        success:function(response){
          console.log("-->",response);
          vm.securityQues.firstP=response.queone;
          vm.securityQues.firstA=response.ansone;
          vm.securityQues.secondP=response.quetwo;
          vm.securityQues.secondA=response.anstwo;
          vm.securityQues.thirdP=response.quethree;
          vm.securityQues.thirdA=response.ansthree;
        }

      })

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
.el-menu-vertical-demo{
  margin:0px auto;
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
