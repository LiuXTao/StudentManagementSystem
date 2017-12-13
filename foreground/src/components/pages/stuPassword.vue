<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="clear"></div>
        <div class="mainborder">
            <div>
            <div class="left">
                <el-menu default-active="onRoutes" class="siderBar" @select="handleSelect" theme="light">
                    <el-menu-item index="modifyPassword"><i class="el-icon-setting"></i>修改密码</el-menu-item>
                    <el-menu-item index="question"><i class="el-icon-setting"></i>修改密保</el-menu-item>
                    <div class="tianchong"></div>
                </el-menu>

            </div>
             <div class="right">
          <template v-if="selectIndex==('modifyPassword')">
            <password-modify></password-modify>
          </template>
          <template v-else-if="selectIndex==('question')">
            <security-ques :security-ques="this.securityQues" ></security-ques> 
          </template>
        </div>
            <div class="clear"></div>            
            </div>
        </div>

    </div>
</template>
<script>
import vHead from '../commons/StudentNav.vue';
import securityQues from './securityQuestionModify.vue'
import passwordModify from './passwordModify';
import Bus from './bus.js'
export default {
    name:'password',
    components:{
        vHead,
        securityQues,
        passwordModify
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
          url:'/student/securityQuery',
          dataType:'json',
          data:{
            "id":this.stu_id
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
        stu_id:'',
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
          url:'/student/securityQuery',
          dataType:'json',
          data:{
            "id":this.stu_id
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
  .el-row {
    margin-bottom: 20px;

  }
  .el-col {
    border-radius: 4px;
  }
   

</style>
