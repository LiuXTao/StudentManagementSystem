<template>
<div class='wrapper'>
    <v-head></v-head>
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="form1" ref="form1" :inline="true" :model="form1" :rules="rule1" label-width="100px" >
     <el-form-item label="账号：" prop="professor_id">
        <el-input v-model="form1.professor_id" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="姓名：" prop="pname">
        <el-input v-model="form1.pname" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="性别：" prop="psex">
       <el-select v-model="form1.psex"   placeholder="请选择性别" style="width:220px">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：" prop="pdepartment">
        <el-input v-model="form1.pdepartment"  style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="教龄：" prop="pteaching_age">
        <el-input v-model="form1.pteaching_age" type="number"  max=999 style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="职务：" prop="ptitle" >
       <el-select v-model="form1.ptitle"  placeholder="请选择职务" style="width:220px">
      <el-option label="  " value="null"></el-option>
      <el-option label="助教" value="assistant"></el-option>
      <el-option label="讲师" value="lecturer"></el-option>
       <el-option label="副教授" value="adjpro"></el-option>
        <el-option label="教授" value="professor"></el-option>
    </el-select>
         </el-form-item>
     <el-form-item label="教育背景：" prop="peducational_background">
        <el-input v-model="form1.peducational_background" style="width:220px" type="text" ></el-input>
     </el-form-item>
         <el-form-item label="出生日期：" prop="pbirthday">
        <el-date-picker v-model="form1.pbirthday" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
         <el-form-item label="民族：" prop="pnationality">
        <el-input v-model="form1.pnationality" style="width:220px"  type="text"></el-input>
     </el-form-item>
         <el-form-item label="政治面貌：" prop="ppolitics_status">
        <el-input v-model="form1.ppolitics_status"  type="text" style="width:220px" ></el-input>
     </el-form-item>
         <el-form-item label="方向：" prop="parea_of_interest">
        <el-input v-model="form1.parea_of_interest"  type="text" style="width:220px" ></el-input>
     </el-form-item>
	 </el-form-item>
         <el-form-item label="联系方式：" prop="pcontact">
        <el-input v-model="form1.pcontact"  type="text" style="width:220px" ></el-input>
     </el-form-item>
	 <el-col></el-col>
</el-form>
<el-form id="form2" :inline="true" label-width="100px" >
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
      data: function(){
      return {
          hostUrl:'/teacher',
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
          form1:{
              professor_id: '123456543248',
              pname: 'xxx',
              pdepartment:'SAFDFAas',
              pteaching_age:'',
              peducational_background:'',
              pbirthday: '',
              pnationality: '',
              pcontact_information: '',
              ppolitics_status: '',
              parea_of_interest: '',
              psex:'',
              ptitle:'',
			  pcontact:''
          },
          rule1:{
              professor_id: [
            { required: true, message: '请输入学号', trigger: 'blur' },
            { min: 12, max: 12, message: '长度为12个字符', trigger: 'blur' }
          ],
          pname: [
            { required: true, message: '输入名字', trigger: 'blur' },
          ],
          pdepartment: [
              { required: true, message: '请输入学生学院', trigger: 'blur' }
          ],
		   pteaching_age: [
            { required: true, message: '请输入教龄', trigger: 'blur' },
          ],
		   peducational_background: [
            { required: true, message: '请输入教育背景', trigger: 'blur' },
          ],
		   pbirthday:[
             { type: 'date', required: true, message: '请选择时间', trigger: 'change' },
         ],
		  pnationality:[
             { required: true, message: '请输入民族', trigger: 'change' },
         ],
		   ppolitics_status:[
             { required: true, message: '请输入政治面貌', trigger: 'change' },
         ],
		  parea_of_interest:[
             { required: true, message: '请输入方向', trigger: 'change' },
         ],
		 ptitle:[
             { required: true, message: '请选择职务', trigger: 'change' },
         ],
         psex:[
             { required: true, message: '请选择性别', trigger: 'change' },
         ],
         pcontact:[
             { required: true, message: '请填写联系方式', trigger: 'change' },
         ]

          }
      }
    },
        methods: {
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
        this.$router.push({path: '/adminstrator/teacherInfo/'})
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