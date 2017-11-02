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
          <template v-else>
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
export default {
    name:'password',
    components:{
        vHead,
        securityQues,
        passwordModify
    },
    data () {

      return {
        selectIndex:'',
        securityQues: {
            firstP:"你第一所学校是什么",
            firstA:"1",
            secondP:"你父亲的名字是什么",
            secondA:"2",
            thirdP:"你母亲的名字是什么",
            thirdA:"3"
        },
      }
    },
    methods: {
    handleSelect:function(key,keyPath){
      this.selectIndex=key;
      console.log(this.selectIndex);
     
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
