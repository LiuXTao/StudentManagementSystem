<template>
  <div class="loginpassword">
  <div class="daohang"><span class="zi">教务系统|找回密码</span>
 </div>
  <div class="buzhoutiao">
<el-steps :active="active" finish-status="success">
  <el-step title="填写账号"></el-step>
  <el-step title="填写密保"></el-step>
  <el-step title="重置密码"></el-step>
   <el-step title="完成"></el-step>
</el-steps>


 </div>
 
          <div >
		   <template v-if="active=== 0">
		   
            <find-password1></find-password1>
			<el-button style="margin-top: 12px;" @click="next">下一步</el-button>
          </template>
		  <template v-if="active=== 1">
            <find-password2></find-password2>
			<el-button style="margin-top: 12px;" @click="next">下一步</el-button>
          </template>
          <template v-if="active=== 2">
            <find-password3></find-password3>
			<el-button style="margin-top: 12px;" @click="next">下一步</el-button>
          </template>
          <template v-if="active=== 3">
		  <div class="success">
            <p>成功找回密码！</p>
			</div>
			<el-button @click="back">登陆教务系统</el-button>
          </template>
        </div>
 
 
 
 
 </div>
</template>



<script>
import findPassword1 from './findPassword1';
import findPassword2 from './findPassword2';
import findPassword3 from './findPassword3';
  export default {
  components:{
       
        findPassword1,
		findPassword2,
	 findPassword3
    },
    data:function() {
      return {
        active:0
      };
    },

    methods: {
      next() {
	   if(this.active++ >2) active=0;
      
      },
	  back(){
	  this.$router.push({path: '/login'})
	  }
    }
  }
</script>
<style scoped>
.logo{
  float: left;
  padding-left: 40px;
  font-size: 30px;
  color:cornflowerblue
}
.daohang{
width:100%;
height:40px;
background-color:cornflowerblue;

}
.zi{

font-size:30px;
color:white;
}
.buzhoutiao{
margin-top:40px;

margin-left:200px;
}
.success{
font-size:40px;
color:cornflowerblue;
}
</style>