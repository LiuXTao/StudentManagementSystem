<<template>
        <div id="mainBoard">
          <br><br>
        
         <div id="board2" >
          <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
              
              <el-form-item label="用户名" prop="username">
                {{ruleForm2.username}}
              </el-form-item>
              <el-form-item label="原密码" prop="primarypass">
                  <el-input icon="search" type="password" v-model="ruleForm2.oldPass" :on-icon-click = "handleClick()" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="pass">
                  <el-input icon="search"type="password" v-model="ruleForm2.pass" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                  <el-input icon="search"type="password" v-model="ruleForm2.checkPass" auto-complete="off" ></el-input>
              </el-form-item>      
              <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm2')">确认修改</el-button>
                <el-button @click="resetForm('ruleForm2')">重置</el-button>
              </el-form-item>
            </el-form>  
        </div>
  </div>
</template>

<script>
export default {
 
    data:function(){
      var checkOldPassword = (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[a-zA-Z0-9]+$/;
                if(!value){
                    vm.check1 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if(value.length < 6 || value.length > 16){
                    vm.check1 = true;
                    return callback(new Error('密码长度为6 - 16个字符'));
                }
                else if(!value.match(reg))
                {
                    vm.check2 = true;
                    return callback(new Error('密码仅可由数字与字母组成'));
                }
                else
                {
                    vm.check1 = false;
                }
            };
     var checkNewPassword = (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[a-zA-Z0-9]+$/;
                console.log(typeof value);
                if(!value){
                    vm.check2 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if(value.length < 6 || value.length > 16){

                    vm.check2 = true;
                    return callback(new Error('密码长度为6 - 16个字符'));
                }
                else if(!value.match(reg))
                {
                    vm.check2 = true;
                    return callback(new Error('密码仅可由数字与字母组成'));
                }
                else{
                    vm.check2 = false;
                }
            };

             var checkPassword = (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[a-zA-Z0-9]+$/;
                if(!value){
                    vm.check3 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if(value.length < 6 || value.length > 16){
                    vm.check3 = true;
                    return callback(new Error('密码长度为6 - 16个字符'));
                }
                else if(!value.match(reg))
                {   
                    vm.check3 = true;
                    return callback(new Error('密码仅可由数字与字母组成'));
                }
                else{
                    vm.check3 = false;
                }
            };
    

      return {
        hostUrl:"/",
        check1:true,
        check2:true,
        check3:true,

        ruleForm1: {
            firstP:"你第一所学校是什么",
            firstA:"",
            secondP:"你父亲的名字是什么",
            secondA:"",
            thirdP:"你母亲的名字是什么",
            thirdA:""
        },
        ruleForm2: {
            username:'XXXXXXX ',
            oldPass:'',
            pass: '',
            checkPass: ''
        },
        rules2:{
            oldPass:[
                { validator: checkOldPassword, trigger:'change'},
                { validator: checkOldPassword, trigger:'blur'}
            ],
            pass:[
                { validator: checkNewPassword, trigger:'change'},
                { validator: checkNewPassword, trigger:'blur'}
            ],
            checkPass:[
                { validator: checkPassword, trigger:'change'},
                { validator: checkPassword, trigger:'blur'}
            ]
        }
      } 
    },
    methods:{
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
                    case 302:
                        msg('权限问题', '用户未激活，请去邮箱激活用户');
                        break;
                    case 303:
                        msg('注册问题', '邮箱已占用，请更改邮箱');
                        break;
                    case 304:
                        msg('注册问题', '昵称已占用，请更改昵称');
                        break;
                    case 400:
                        msg('权限问题', '用户未登录，请重新登录');
                        break;
                    case 401:
                        msg('权限问题', '用户无权访问，请联系管理员');
                        break;
                    case 402:
                        msg('操作错误', '删除错误,请刷新重试');
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
        handleClick:function(){
        },
        checkAllow:function(){
            var vm=this;
            return vm.check1||vm.check2||vm.check3;
        },

        submitForm:function(){
            var vm=this;
            
            if(vm.ruleForm2.oldPass==vm.ruleForm2.pass){
                this.$message({
                    type:"info",
                    message:"新旧密码不能相同"
                });
            }else if(vm.ruleForm2.pass!=vm.ruleForm2.checkPass){
               this.$message({
                    type:"info",
                    message:"确认密码不一致"
                });
            }else{
                this.$confirm("确认要修改密码",'提示',{ confirmButtonText: '确定',
                      cancelButtonText: '取消',type:'warning'})
                    .then(()=>{
                        var postData = {
                            oldPassword:"",
                            newPassword:""
                        };
                        postData.oldPassword = vm.ruleForm2.oldPass;
                        postData.newPassword = vm.ruleForm2.pass;
                        this.$http({
                            url:'/passwordModify',
                            method:'post',
                            baseURL: vm.hostUrl,      
                            data:postData
                        })
                        .then((response) => {
                            if(response.data.code == "200"){
                                this.$message({
                                    type:'success',
                                    message:'修改成功'
                                });
                            } else {
                                console.log(response.data.code);
                                vm.codeParsing(response.data.code);
                            }
                        })
                    
                              
                    });
                
                    
            }
         
        },
        
        resetForm(formname){
            this.$refs[formname].resetFields();
        }
    }

}
</script>
<style scoped>
#mainBoard{
   width:60%;
   margin:0px auto;
 font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.tips{   
    font-size:20px;
}
.demo-ruleForm{
    margin:0px auto;

    width: 400px;
}
.bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
   .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }

</style>
<!-- <div id="board1">
        <div class="tips">请回答密保问题</div>
        <br>
        <el-form :model="ruleForm1" :rules="rules1" ref="ruleForm1" label-width="100px" class="demo-ruleForm">
          

            <el-form-item label="第一个问题：" prop="firstQues">
                {{ruleForm1.firstP}}
                <br>
                <el-input type="text"v-model="ruleForm1.firstA" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第二个问题：" prop="secondQues">
                 {{ruleForm1.secondP}}
                <br>
                <el-input type="text"v-model="ruleForm1.secondA" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第三个问题：" prop="thirdQues">
                 {{ruleForm1.thirdP}}
                <br>
                <el-input type="text"v-model="ruleForm1.thirdA" auto-complete="off" ></el-input>
            </el-form-item>      
            <el-form-item>
                <el-button type="primary" @click="submit('ruleForm1')">确认</el-button>
                <el-button @click="resetForm('ruleForm1')">重置</el-button>
            </el-form-item>
        </el-form>  
        </div> -->