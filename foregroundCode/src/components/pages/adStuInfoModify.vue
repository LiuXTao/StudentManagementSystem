<template>
<div class='wrapper'>
<v-head></v-head>
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="form1" :inline="true" :rules="rules" :model="form1" ref="form1" label-width="100px" >
     <el-form-item label="账号：" prop="student_id" >
        <el-input v-model="form1.student_id" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="姓名：" prop="s_name">
        <el-input v-model="form1.s_name" type="text" style="width:220px"></el-input>
     </el-form-item>
    </el-form-item>
    <el-form-item label="学院：" prop="sdepartment">
        <el-input v-model="form1.sdepartment" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="专业：" prop="smajor">
        <el-input v-model="form1.smajor" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="班级：" prop="sclass">
        <el-input v-model="form1.sclass" style="width:220px"></el-input>
     </el-form-item>
         <el-form-item label="入学时间：" prop="stime_of_enrollment">
        <el-date-picker v-model="form1.stime_of_enrollment" type="date" style="width:220px"></el-date-picker>
     </el-form-item>
    </el-form-item>
         <el-form-item label="毕业时间：" prop="stime_of_graduation">
        <el-date-picker v-model="form1.stime_of_graduation" type="date" style="width:220px"></el-date-picker>
     </el-form-item>
    </el-form-item>
    <el-form-item label="职务：" prop="stitle">
        <el-input v-model="form1.stitle" type="text" style="width:220px"></el-input>
    </el-form-item>
    <el-form-item label="性别：" prop="ssex">
       <el-select v-model="form1.ssex" style="width:220px">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
         <el-form-item label="出生日期：" prop="sbirthday">
        <el-date-picker v-model="form1.sbirthday" type="date" style="width:220px"></el-date-picker>
     </el-form-item>
        <el-form-item label="民族：" prop="snationality">
        <el-input v-model="form1.snationality" style="width:220px"  type="text"></el-input>
     </el-form-item>
        <el-form-item label="健康状态：" prop="shealth_state">
        <el-input v-model="form1.shealth_state" style="width:220px"  type="text"></el-input>
     </el-form-item>
        <el-form-item label="籍贯：" prop="snative_place">
        <el-input v-model="form1.snative_place" style="width:220px"  type="text"></el-input>
     </el-form-item>    
         <el-form-item label="政治面貌：" prop="spolitics_status">
        <el-input v-model="form1.spolitics_status"  type="text" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="方向：" prop="sarea_of_interest">
        <el-input v-model="form1.sarea_of_interest"  type="text" style="width:220px"></el-input>
     </el-form-item>
<el-col></el-col>
</el-form>
<el-form id="form2" :inline="true" label-width="150px" >
<el-form-item>
        <el-button type="primary" @click="modifyForm('form1')">保存</el-button>
                 <el-button type="success" @click="resetForm('form1')">重置</el-button>
                 <el-button @click="exit('form1')">返回</el-button>
     </el-form-item>
    
     </el-form>
        </div>
      </div>
    </div>
   </div>
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
          hostUrl:'/student',
          check1: false,
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
          form1:{
              student_id: '123456789123',
              s_name: '22',
              sdepartment:'22',
              smajor:'',
              sclass:'',
              stime_of_enrollment:'',
              stime_of_graduation:'',
              stitle:'',
              ssex:'',
              sbirthday:'',
              snationality:'',
              shealth_state:'',
              snative_place:'',
              spolitics_status:'',
              sarea_of_interest:''
          },
		  rules: {
          student_id: [
            { required: true, message: '请输入学号', trigger: 'blur' },
            { min: 12, max: 12, message: '长度为12个字符', trigger: 'blur' }
          ],
          s_name: [
            { required: true, message: '输入名字', trigger: 'blur' },
          ],
          sdepartment: [
              { required: true, message: '请输入学生学院', trigger: 'blur' }
          ],
           smajor: [
              { required: true, message: '请输入学生专业', trigger: 'blur' }
          ],
          sclass:[
               { required: true, message: '请输入学生班级', trigger: 'blur' }
          ],
         stime_of_enrollment:[
             { type: 'date', required: true, message: '请选择时间', trigger: 'change' },
         ],
         stime_of_graduation:[
             { type: 'date', required: true, message: '请选择时间', trigger: 'change' },
         ],
		 stitle:[
             { required: true, message: '请选择职务', trigger: 'change' },
         ],
         ssex:[
             { required: true, message: '请选择性别', trigger: 'change' },
         ],
		 sbirthday:[
             { type: 'date', required: true, message: '请选择时间', trigger: 'change' },
         ],
		  snationality:[
             { required: true, message: '请输入民族', trigger: 'change' },
         ],
		 shealth_state:[
             { required: true, message: '请输入健康状态', trigger: 'change' },
         ],
		  snative_place:[
             { required: true, message: '请输入籍贯', trigger: 'change' },
         ],
		 spolitics_status:[
             { required: true, message: '请输入政治面貌', trigger: 'change' },
         ],
		 sarea_of_interest:[
             { required: true, message: '请输入方向', trigger: 'change' },
         ],

        }
      };
  },
  methods:{
        modifyForm(formName) {
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
        this.$router.push({path: '/adminstrator/studentInfo/'})
      }
    }
  }
</script>
<style scoped>
.clear{
  clear: both;
}
.el-main{
    margin-top:3px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;
    height:800px;
}
#infoform{
    padding-top: 60px;
}
#form1{
    width:80%;
    margin:0px auto;
}
#form2{
    width:220px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>