<template>
<div class='wrapper'>
  <v-head></v-head>
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="form1" :inline="true" :model="form1" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form1.student_id" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form1.s_name" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
    </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form1.sdepartment" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
    <el-form-item label="专业：">
        <el-input v-model="form1.smajor" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
    <el-form-item label="班级：">
        <el-input v-model="form1.sclass" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
         <el-form-item label="入学时间：" >
        <el-date-picker v-model="form1.stime_of_enrollment" type="date" style="width:220px" readonly ="true"></el-date-picker>
     </el-form-item>
    </el-form-item>
         <el-form-item label="毕业时间：" >
        <el-date-picker v-model="form1.stime_of_graduation" type="date" style="width:220px" readonly ="true"></el-date-picker>
     </el-form-item>
    </el-form-item>
    <el-form-item label="职务：" prop="stitle">
        <el-input v-model="form1.stitle" type="text" style="width:220px" readonly ="true"></el-input>
    </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form1.ssex" style="width:220px" disabled>
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
         <el-form-item label="出生日期：" >
        <el-date-picker v-model="form1.sbirthday" type="date" style="width:220px" readonly ="true"></el-date-picker>
     </el-form-item>
        <el-form-item label="民族：" prop="snationality">
        <el-input v-model="form1.snationality" style="width:220px"  type="text" readonly ="true"></el-input>
     </el-form-item>
        <el-form-item label="健康状态：" prop="shealth_state">
        <el-input v-model="form1.shealth_state" style="width:220px"  type="text" readonly ="true"></el-input>
     </el-form-item>
        <el-form-item label="籍贯：" prop="snative_place">
        <el-input v-model="form1.snative_place" style="width:220px"  type="text" readonly ="true"></el-input>
     </el-form-item>    
         <el-form-item label="政治面貌：" prop="spolitics_status">
        <el-input v-model="form1.spolitics_status"  type="text" style="width:220px" readonly ="true"></el-input>
     </el-form-item>
    <el-form-item label="方向：" prop="sarea_of_interest">
        <el-input v-model="form1.sarea_of_interest"  type="text" style="width:220px"  readonly ="true"></el-input>
     </el-form-item>
<el-col></el-col>
</el-form>
<el-form id="form2" :inline="true" label-width="100px" >
<el-form-item>
        <el-button type="primary" @click="exit" >返回</el-button>
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
              student_id: '123456543248',
              s_name: 'xxx',
              sdepartment:'SAFDFAas',
              smajor:'xx工程',
              sclass:'1班',
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
      };
  },
  methods:{
        exit() {
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
    width:75px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>