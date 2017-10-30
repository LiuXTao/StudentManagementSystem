<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
    <div class="mainborder">
      <!-- <div class="position">
        <div class="el-icon-caret-right">当前位置</div>
          >>
        <template v-for='index in indexs'> </template> -->
          <!-- <template v-for="index in indexs">
          <a  :href='index.url'>{{index.title}}</a>
          <template v-if="index.subs.size==0">
            >>
            <template v-for="subindex in index.subs">
            <a  :href='subindex.url'>{{subindex.title}}</a>
            </template>
          </template>
          </template>
        </div> --> 
    
      <div>
      <div class="left">
         <el-col :span="25">
    <el-row></el-row>
        <el-button v-model="modify" type="primary" @click="confirm">保存</el-button>
               <template v-if="handleModify==true">
            <filesInfomodify></filesInfomodify>
          </template>
          <template v-else>
          </template>
             <el-row></el-row>
        <el-button v-model="rutern" type="primary" @click="handleReturn"> 返回</el-button>
         </el-col>
        </div>
        <div class="right">
            <h1>个人档案管理</h1>
<el-form ref="info" :inline="true" :model="form" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form.pid" :disabled="true" style="width:140px" maxlength="12" minlength="12"></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form.pname" :disabled="true" style="width:130px" maxlength="15"></el-input>
     </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form.psex"  style="width:140px" placeholder="请选择性别">
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form.pdept" :disabled="true" style="width:140px"></el-input>
     </el-form-item>
    <el-form-item label="教龄：">
        <el-input v-model="form.pteaage" style="width:50px" maxlength="3"></el-input>
     </el-form-item>
    <el-form-item label="职务：">
       <el-select v-model="form.ptitle" style="width:140px" placeholder="请选择职务">
      <el-option label="助教" value="assistant"></el-option>
      <el-option label="讲师" value="lecturer"></el-option>
       <el-option label="副教授" value="adjpro"></el-option>
        <el-option label="教授" value="professor"></el-option>
    </el-select>
         </el-form-item>
     <el-form-item label="教育背景：">
        <el-input v-model="form.peduback" maxlength="20"></el-input>
     </el-form-item>
         <el-form-item label="出生日期：" >
        <el-date-picker v-model="form.pbirth" type="date" style="width:150px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
         <el-form-item label="民族：" >
        <el-input v-model="form.pnation" style="width:140px"  maxlength="10"></el-input>
     </el-form-item>
         <el-form-item label="联系方式：" >
        <el-input v-model="form.pconinfo" style="width:160px" maxlength="11" minlength="11"></el-input>
     </el-form-item>
         <el-form-item label="政治面貌：">
        <el-input v-model="form.ppolsta" style="width:100px" maxlength="5"></el-input>
     </el-form-item>
         <el-form-item label="方向：">
        <el-input v-model="form.pareainter" style="width:140px" maxlength="10"></el-input>
     </el-form-item>
</el-form>
        </div>

     <div class="clear"></div>
      </div>
    </div>
  
  </div>
</div>
</template>
    
<script>
  import vHead from '../commons/TeacherNav';
  export default {
    name:'passmodi',
    components:{
              vHead
          },
    data () {
      return {
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
          form:{
              pid: '123456543248',
              pname: 'xxx',
              pdept: 'xxxxx学院',
          }
      }
    },
        methods: {
    handleReturn:function(){
        this.$router.push('/');
    },
    handleModify:function(key,keyPath){
              this.handleModify=key;
      console.log(this.handleModify);
    },
    confirm() {
        this.$confirm('是否确定修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$message({
            type: 'success',
            message: '修改成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消修改'
          });          
        });
      }

    }

}
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
  margin-top: 5px;height:500px;
  float: left;
    background-color:#eef1f6;
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
    height:80px;

  }
  .el-col {
    border-radius: 4px;
  }
  .el-form-item{
      float:left;
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
h1{
    height:80fx;
}
</style>

  
  