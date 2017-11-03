<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form ref="form1" :inline="true" :model="form1" :rules="rule1" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form1.pid" :disabled="true" style="width:140px" ></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form1.pname" :disabled="true" style="width:130px" ></el-input>
     </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form1.psex"  style="width:140px" placeholder="请选择性别">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form1.pdept" style="width:140px" :disabled="true" ></el-input>
     </el-form-item>
    <el-form-item label="教龄：">
        <el-input v-model="form1.pteaage" type="number" style="width:100px" max="999"></el-input>
     </el-form-item>
    <el-form-item label="职务：">
       <el-select v-model="form1.ptitle" style="width:140px" placeholder="请选择职务">
      <el-option label="  " value="null"></el-option>
      <el-option label="助教" value="assistant"></el-option>
      <el-option label="讲师" value="lecturer"></el-option>
       <el-option label="副教授" value="adjpro"></el-option>
        <el-option label="教授" value="professor"></el-option>
    </el-select>
         </el-form-item>
     <el-form-item label="教育背景：">
        <el-input v-model="form1.peduback" auto-complete="off" type="text" maxlength="20"></el-input>
     </el-form-item>
         <el-form-item label="出生日期：" >
        <el-date-picker v-model="form1.pbirth" type="date" style="width:150px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
         <el-form-item label="民族：" >
        <el-input v-model="form1.pnation" style="width:140px"  type="text" maxlength="10"></el-input>
     </el-form-item>
         <el-form-item label="联系方式：" >
        <el-input v-model="form1.pconinfo" style="width:160px" atype="text" maxlength="15"></el-input>
     </el-form-item>
         <el-form-item label="政治面貌：">
        <el-input v-model="form1.ppolsta" style="width:100px" type="text" maxlength="10"></el-input>
     </el-form-item>
         <el-form-item label="方向：">
        <el-input v-model="form1.pareainter" style="width:140px" type="text" maxlength="10" ></el-input>
     </el-form-item><el-col></el-col>
</el-form>
<el-form id="form2" :inline="true" label-width="100px" >
<el-form-item>
        <el-button type="primary" @click="submitForm" >保存</el-button>
     </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="handleReturn"> 返回</el-button>
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
      data: function(){
          var checklength1 = (rule,value,callback) => {
            var vm = this.$data;
            if( value.gblen() > 3){
              vm.check6 = true;
              return callback(new Error('长度不可超于3位'));
           }else {
              vm.check4 = false;
           }
        };
          var checklength2 = (rule,value,callback) => {
            var vm = this.$data;
            if( value.gblen() > 20){
              vm.check6 = true;
              return callback(new Error('长度不可超于20个字符'));
           }else {
              vm.check4 = false;
           }
        };
          var checklength3 = (rule,value,callback) => {
            var vm = this.$data;
            console.log(typeof value);
            if( value.gblen() > 10){
              vm.check6 = true;
              return callback(new Error('长度不可超于10个字符'));
           }else {
              vm.check4 = false;
           }
        };
          var checklength4 = (rule,value,callback) => {
            var vm = this.$data;
            console.log(typeof value);
                           if(!value){
                    vm.check1 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if( value.gblen() > 15){
              vm.check6 = true;
              return callback(new Error('长度不可超于15个字符'));
           }else {
              vm.check4 = false;
           }
        };
          var checklength5 = (rule,value,callback) => {
            var vm = this.$data;
            console.log(typeof value);
                            if(!value){
                    vm.check1 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if( value.gblen() > 10){
              vm.check6 = true;
              return callback(new Error('长度不可超于10个字符'));
           }else {
              vm.check5 = false;
           }
        };
          var checklength6 = (rule,value,callback) => {
            var vm = this.$data;
            var reg = /^[a-zA-Z0-9]+$/;
            console.log(typeof value);
                           if(!value){
                    vm.check1 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if( value.gblen() > 10){
              vm.check6 = true;
              return callback(new Error('长度不可超于10个字符'));
           }else {
              vm.check6 = false;
           }
        };
      return {
          hostUrl:'/teacher',
          check1: false,
          check2: false,
          check3: false,
          check4: false,
          check5: false,
          check6: true,
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
          form1:{
              pid: '123456543248',
              pname: 'xxx',
              pdept:'SAFDFAas',
              pteaage:'',
              peduback:'',
              pbirth:'',
              pnation:'',
              pconinfo:'',
              ppolsta:'',
              pareainter:'',
              psex:'',
              ptitle:''
          },
          rule1:{
              pteaage:[
                { validator: checklength1, trigger:'change'},
                { validator: checklength1, trigger:'blur'}
            ],
              peduback:[
                { validator: checklength2, trigger:'change'},
                { validator: checklength2, trigger:'blur'}
            ],
              pnation:[
                { validator: checklength3, trigger:'change'},
                { validator: checklength3, trigger:'blur'}
            ],
              pconinfo:[
                { validator: checklength4, trigger:'change'},
                { validator: checklength4, trigger:'blur'}
            ],
              ppolsta:[
                { validator: checklength5, trigger:'change'},
                { validator: checklength5, trigger:'blur'}
            ],
              pareainter:[
                { validator: checklength6, trigger:'change'},
                { validator: checklength6, trigger:'blur'}
            ]
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
        this.$router.push('/teacher');
    },
    handleModify:function(key,keyPath){
              this.handleModify=key;
      console.log(this.handleModify);
    },
    submitForm() {
         var vm=this;
        this.$confirm('是否确定修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            var postData = {
                            pteaage:"",
                            peduback:"",
                            pbirth:"",
                            pnation:"",
                            pconinfo:"",
                            ppolsta:"",
                            pareainter:"",
                            psex:"",
                            ptitle:""

                        };
                        postData.pteaage = vm.form1.pteaage;
                        postData.peduback = vm.form1.peduback;
                        postData.pbirth = vm.form1.pbirth;
                        postData. pnation = vm.form1. pnation;
                        postData.pconinfo = vm.form1.pconinfo;
                        postData.ppolsta = vm.form1.ppolsta;
                        postData.pareainter = vm.form1.pareainter;
                        postData. psex = vm.form1. psex;
                        postData.ptitle = vm.form1.ptitle;
                         this.$http({
                            url:'/filesInfo',
                            method:'post',
                            baseURL: vm.hostUrl,      
                            data:postData
                         }).then((response) => {
                if(response.data.code == "200"){
          this.$message({
            type: 'success',
            message: '修改成功!'
          });
            }else {
                console.log(response.data.code);
                vm.codeParsing(response.data.code);
            }
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消修改'
          }) 
        })         
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
#form1{
    width:80%;
    margin:0px auto;
}
#form2{
    width:200px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>
