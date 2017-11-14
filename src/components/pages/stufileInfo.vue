<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="form1" :inline="true" :model="form1" :rules="inforule" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form1.student_id" :disabled="true" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form1.s_name" :disabled="true" style="width:220px" ></el-input>
     </el-form-item>
    </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form1.sdepartment"  :disabled="true" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="专业：">
        <el-input v-model="form1.smajor"  :disabled="true" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="班级：">
        <el-input v-model="form1.sclass"  :disabled="true" style="width:220px"></el-input>
     </el-form-item>
         <el-form-item label="入学时间：" >
        <el-date-picker v-model="form1.stime_of_enrollment" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    </el-form-item>
         <el-form-item label="毕业时间：" >
        <el-date-picker v-model="form1.stime_of_graduation" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    </el-form-item>
    <el-form-item label="职务：" prop="stitle">
        <el-input v-model="form1.stitle" :disabled="check1" type="text" style="width:220px" ></el-input>
    </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form1.ssex"   placeholder="请选择性别" style="width:220px">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
         <el-form-item label="出生日期：" >
        <el-date-picker v-model="form1.sbirthday" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
        <el-form-item label="民族：" prop="snationality">
        <el-input v-model="form1.snationality" style="width:220px"  type="text" ></el-input>
     </el-form-item>
        <el-form-item label="健康状态：" prop="shealth_state">
        <el-input v-model="form1.shealth_state" style="width:220px"  type="text" ></el-input>
     </el-form-item>
        <el-form-item label="籍贯：" prop="snative_place">
        <el-input v-model="form1.snative_place" style="width:220px"  type="text" ></el-input>
     </el-form-item>    
         <el-form-item label="政治面貌：" prop="spolitics_status">
        <el-input v-model="form1.spolitics_status"  type="text" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="方向：" prop="sarea_of_interest">
        <el-input v-model="form1.sarea_of_interest"  type="text" style="width:220px"  ></el-input>
     </el-form-item>
<el-col></el-col>
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
  import vHead from '../commons/StudentNav';
  export default {
      data: function(){
          var checklength1 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength2 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength5 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength3 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 5){
              return callback(new Error('长度不可超于5位'));
           }
        };
                  var checklength4 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 20){
              return callback(new Error('长度不可超于20位'));
           }
        };
                  var checklength6 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };

      return {
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
          inforule:{
              stitle:[
                { validator: checklength1, trigger:'change'},
                { validator: checklength1, trigger:'blur'}
              ],
              snationality:[
                { validator: checklength2, trigger:'change'},
                { validator: checklength2, trigger:'blur'}
              ],
               shealth_state:[
                { validator: checklength3, trigger:'change'},
                { validator: checklength3, trigger:'blur'}
              ],
               snative_place:[
                { validator: checklength4, trigger:'change'},
                { validator: checklength4, trigger:'blur'}
              ],
                spolitics_status:[
                { validator: checklength5, trigger:'change'},
                { validator: checklength5, trigger:'blur'}
              ],
                sarea_of_interest:[
                { validator: checklength6, trigger:'change'},
                { validator: checklength6, trigger:'blur'}
              ]
          }
      }
    },
        components:{
              vHead
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
        checkAllow:function(){
            var vm=this;
            return vm.check1;
        },
    submitForm() {
         var vm=this;
        this.$confirm('是否确定修改', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            var postData = {
              stime_of_enrollment:"",
              stime_of_graduation:"",
              stitle:"",
              ssex:"",
              sbirthday:"",
              snationality:"",
              shealth_state:"",
              snative_place:"",
              spolitics_status:"",
              sarea_of_interest:""

                        };
                        postData.stime_of_enrollment = vm.form1.stime_of_enrollmen;
                        postData.stime_of_graduation = vm.form1.stime_of_graduation;
                        postData.stitle = vm.form1.stitle;
                        postData. ssex = vm.form1. ssex;
                        postData.sbirthday = vm.form1.sbirthday;
                        postData.snationality = vm.form1.snationality;
                        postData.shealth_state = vm.form1.shealth_state;
                        postData. snative_place = vm.form1.snative_place;
                        postData.spolitics_status = vm.form1.spolitics_status;
                        postData.sarea_of_interest = vm.form1.sarea_of_interest;
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
