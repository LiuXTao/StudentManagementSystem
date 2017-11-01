<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="info" :inline="true" :model="form" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form.pid" :disabled="true" style="width:140px" maxlength="15"></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form.pname" :disabled="true" style="width:130px" maxlength="15"></el-input>
     </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form.psex"  style="width:140px" placeholder="请选择性别">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form.pdept" style="width:140px" :disabled="true"></el-input>
     </el-form-item>
    <el-form-item label="教龄：">
        <el-input v-model="form.pteaage" style="width:50px" maxlength="3"></el-input>
     </el-form-item>
    <el-form-item label="职务：">
       <el-select v-model="form.ptitle" style="width:140px" placeholder="请选择职务">
      <el-option label="  " value="null"></el-option>
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
     </el-form-item>
         <el-form-item label="籍贯：" >
        <el-input v-model="form.pnative" style="width:140px"  maxlength="10"></el-input>
     </el-form-item>
     </el-form-item>
         <el-form-item label="国籍：" >
        <el-input v-model="form.pcitizen" style="width:140px"  maxlength="10"></el-input>
     </el-form-item>
         <el-form-item label="联系方式：" >
        <el-input v-model="form.pconinfo" style="width:160px" maxlength="15"></el-input>
     </el-form-item>
         <el-form-item label="政治面貌：">
        <el-input v-model="form.ppolsta" style="width:100px" maxlength="10"></el-input>
     </el-form-item>
         <el-form-item label="方向：">
        <el-input v-model="form.pareainter" style="width:140px" maxlength="10"></el-input>
     </el-form-item><el-col></el-col>
</el-form>
<el-form id="info2" :inline="true" :model="form" label-width="100px" >
<el-form-item>
        <el-button v-model="modify" type="primary" @click="confirm" >保存</el-button>
     </el-form-item>
    <el-form-item>
        <el-button v-model="rutern" type="primary" @click="handleReturn"> 返回</el-button>
     </el-form-item>
     </el-form>
        </div>
      </div>
    </div>
   </div>
</div>
</template>
    
<script>
  import vHead from '../commons/TeacherNav';
  export default {
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
              pdept:'SAFDFAas'
          }
      }
    },
        methods: {
           codeParsing(code) {
                var msg = (Title, Message) => {
                    this.$message({
                        title: Title,
                        message: Message,
                        type: 'error'
                    });
                };
                switch(code) {
                    case -1:
                        msg('系统错误', '未知错误，请上报管理员');
                        break;
                    case 201:
                        msg('输入域错误', '验证码错误');
                        break;
                    case 300:
                        msg('输入域错误', '邮箱或密码错误');
                        break;
                    case 301:
                        msg('权限问题', '用户已禁用，请联系管理员');
                        break;
                    case 400:
                        msg('权限问题', '用户未登录，请重新登录');
                        break;
                    case 401:
                        msg('权限问题', '用户无权访问，请联系管理员');
                        break;

                    case 500:
                        msg('系统错误', '未知错误，请上报管理员');
                        break;
                    case 600:
                        msg('TIME_OUT', '访问超时，请检查网络连接');
                        break;
                    case 700:
                        msg('激活错误', '非法激活链接，请联系管理员');
                        break;
                    case 800:
                        msg('激活错误', '用户已被激活，请直接登录');
                        break;
                    default:
                        break;
                }
            },
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
#info{
    width:80%;
    margin:0px auto;
}
#info2{
    width:200px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>
