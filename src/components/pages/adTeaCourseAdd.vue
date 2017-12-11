
<template>
    <div>
         <v-head></v-head>
         <p></p>
            <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" inline="true">
            <el-row style="width:1200px">    
                 <el-form-item label="课程名称" prop="name">
                    <el-input v-model="ruleForm.name" size = "small" placeholder = "" style="width:100%"></el-input>
                 </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="学院" prop="academy">
                    <el-input v-model="ruleForm.academy"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
             <el-row style="width:1200px">
                <el-form-item label="年级" prop="grade">
                    <el-input v-model="ruleForm.grade"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
             <el-row style="width:1200px">
                <el-form-item label="学期" prop="semester">
                    <el-input v-model="ruleForm.semester"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="课程性质" prop="nature">
                    <el-input v-model="ruleForm.nature"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="开课老师" prop="teaName">
                    <el-input v-model="ruleForm.teaName"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="上课地点" prop="place">
                    <el-input v-model="ruleForm.place"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="开课时间" prop="time">
                    <el-input v-model="ruleForm.time"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row style="width:1200px">
                <el-form-item label="课程介绍" prop="courseInfo">
                    <el-input type="textarea" v-model="ruleForm.courseInfo"size = "small" placeholder="" style="width:100%"></el-input>
                </el-form-item>
            </el-row>
            <el-row>
                <el-form-item> 
                <el-button type="success" @click="add('ruleForm')">保存</el-button>
                <el-button type="primary" @click="exit('ruleForm')">返回</el-button>
                <el-button type="success" @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>       
            </el-row>
            </el-form>

           
    </div>
</template>
<script>
import vHead from '../commons/AdminstratorNav.vue';
export default {
  components:{
      vHead,
  },
  data(){
      return{
         ruleForm: {
           name:'',
          academy:'',
          grade:'',
          semester:'',
          nature:'',
          teaName:'',
          place:'',
          time:'',
          courseInfo:'',
        },
      };
  },
  methods:{
       add(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      exit(formName) {
        this.$router.push({path: '/adminstrator/teaCourseManagement/'})
      }
    }
  }
</script>
<style scoped>
.clear{
    clear:both;
}
.selectBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    height:50px;
}
.firstBar{
   
    margin-left:5px;
}
.firstBar .selectBar{
    margin:5px 20px 5px 0px;
    
}
#info{
    width:96%;
    margin:0px auto;
    padding-top:10px;
}
#infoTable{
    border-color:#eefff6;
   
}
#query{

    width:100px;
}
.scoreBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    height:800px;
}
.lbl{
    font-family: "微软雅黑";
    color:#CDC1C5;
}
#table{
     margin:0px auto;
    margin-top:20px;
    width:95%;
}
</style>
