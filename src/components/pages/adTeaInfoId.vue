<template>
<div class='wrapper'>
<v-head></v-head>
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="form1" ref="form1" :inline="true" :model="form1" :rules="rule1" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form1.professor_id" readonly="readonly" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form1.pname" readonly="readonly" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form1.psex" style="width:220px" disabled>
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form1.pdepartment"  readonly="readonly" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="教龄：" prop="pteaching_age">
        <el-input v-model="form1.pteaching_age" type="number" style="width:220px" readonly="readonly"></el-input>
     </el-form-item>
    <el-form-item label="职务：" >
       <el-select v-model="form1.ptitle" style="width:220px" disabled>
      <el-option label="  " value="null"></el-option>
      <el-option label="助教" value="assistant"></el-option>
      <el-option label="讲师" value="lecturer"></el-option>
       <el-option label="副教授" value="adjpro"></el-option>
        <el-option label="教授" value="professor"></el-option>
    </el-select>
         </el-form-item>
     <el-form-item label="教育背景：" prop="peducational_background">
        <el-input v-model="form1.peducational_background" auto-complete="off" style="width:220px" type="text" readonly="readonly"></el-input>
     </el-form-item>
         <el-form-item label="出生日期：" >
        <el-date-picker v-model="form1.pbirthday" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions" readonly ="true"></el-date-picker>
     </el-form-item>
         <el-form-item label="民族：" prop="pnationality">
        <el-input v-model="form1.pnationality" style="width:220px"  type="text" readonly ="true"></el-input>
     </el-form-item>
         <el-form-item label="政治面貌：" prop="ppolitics_status">
        <el-input v-model="form1.ppolitics_status"  type="text" style="width:220px" readonly ="true"></el-input>
     </el-form-item>
         <el-form-item label="方向：" prop="parea_of_interest">
        <el-input v-model="form1.parea_of_interest"  type="text" style="width:220px" readonly ="true"></el-input>
     </el-form-item>
	 </el-form-item>
         <el-form-item label="联系方式：" prop="pcontact">
        <el-input v-model="form1.pcontact"  type="text" style="width:220px" ></el-input>
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
              peducation_background:'',
              pbirthday: '',
              pnationality: '',
              pcontact_information: '',
              ppolitics_status: '',
              parea_of_interest: '',
              psex:'',
              ptitle:'',
			  pcontact:''
          },
          
      }
    },
        methods: {
          exit() {
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
    width:70px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>