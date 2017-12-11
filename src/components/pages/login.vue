<template>
  <div class="login-wrap">   
  
  <div class="background">
    <div class="background-img">
      <!--<img src="../assets/LoginWallpaper.jpg">-->
      <img :src="pic_location" style="width:100%">
    </div>
    <div class="ms-login">
      <el-tabs v-model="activePane" id="login">
        <el-form :model="login" :rules="loginRules" ref="login" label-width="0px" >
          <el-form-item prop="username">
            <el-input v-model="login.username" placeholder="账号"></el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input type="password" placeholder="密码" v-model="login.password"></el-input>
          </el-form-item>
          <el-form :model="login" :rules="loginRules" ref="login" label-width="0px">
            <el-form-item prop="verCode">
              <el-popover
                ref="a"
                placement="right-end"
                trigger="hover">
                <img :src="imgUrl" alt="验证码图片" width="200px" @click="getVerCode">
              </el-popover>
              <el-input
                v-popover:a
                placeholder="验证码"
                v-model="login.verCode"
                @keyup.enter.native="loginForm('login')">
              </el-input>
            </el-form-item>
          </el-form>
          <div class="login-radio">
            <el-radio-group v-model="login.radio">
              <el-radio :label="1">学生</el-radio>
              <el-radio :label="2">教师</el-radio>
              <el-radio :label="3">管理员</el-radio>
            </el-radio-group>
          </div>
          <div class="login-btn">
            <el-button type="primary" @click="loginForm('login')">登录</el-button>
          </div >
          <div class="forgetpassword"><span @click="goToModifyPassword" id="ForgetPassword">忘记密码 </span>
          </div>
        </el-form>
      </el-tabs>
    </div>
  </div>
  </div>
</template>

<script>
  import loginImg from '../../assets/jiemian.jpg'
  export default {
    data: function () {
      return {
        activePane: 'login',
        hostUrl: '/', 
        imgUrl: '/checkcode',
        pic_location: loginImg,
        login: {
          username: '',
          password: '',
          verCode: '',
          radio: 1
        },
        loginRules: {
          username: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
          verCode: [
            {required: true, message: '请输入验证码', trigger: 'blur'}
          ]
        }
      }
    },
	created() {

            this.getVerCode();
            
        },
    methods: {
        inputvalidation(id,password){
         
        if(id===""){
           this.$message({
                    type:"info",
                    message:"请输入账号"
                });
               
            return 0;
        }
        if(password===""){
             this.$message({
                    type:"info",
                    message:"请输入密码"
                });
            return 0;
        }
        this.login.username=this.login.username.trim();
        this.login.password=this.login.password.trim();
        var n = Number(this.login.username);
        if(isNaN(n)){
            this.$message({
                type:'info',
                message:"账号错误"
            })
            return 0;
        }
        return 1;
      },
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
       loginForm (formName) {
        var id=this.login.username;
        if(this.inputvalidation(this.login.username,this.login.password)===1){
          if (this.login.radio === 1) { // 学生
          $.ajax({
          type : "post",
          url : '/student/login',
          dataType : 'json',
          data : {
          // 'mydata' : 
          // JSON.stringify({  
              "id":this.login.username,
              "password":this.login.password
            
          },
          success : function(response) {
          console.log(response.data)
          if(response.data===1){

                alert("登陆成功");
                if(localStorage){
                    localStorage.setItem("stuId",id);
                }else{
                    alert('This browser supports localStorage');
                }
                window.location.href="/#/student";
          }else{
              alert("密码错误！");  
          }
          },
          error : function(err){
            console.log(err)
          }
          });
              //取得输入框的值
              //post到后端，进行验证
              //返回必要信息（网络、密码验证、验证码验证等）
            }
        else if (this.login.radio === 2) { 
       
        $.ajax({
          type : "post",
          url : '/teacher/login',
          dataType : 'json',
          data : {
          // 'mydata' : 
          // JSON.stringify({  
              "id":this.login.username,
              "password":this.login.password
              //  })     //注意一定要使用JSON.stringify (在IE6，IE7中不支持)
          },
          success : function(response) {
         
          if(response.data===1){

                alert("登陆成功");
                if(localStorage){
                    localStorage.setItem("teaId",id);
                }else{
                    alert('This browser supports localStorage');
                }
                window.location.href="/#/teacher";
          }else{
              alert("密码错误！");  
          }
          },
          error : function(err){
          console.log(err)
          }
          });
          }

          else if (this.login.radio === 3) { 
          
          $.ajax({
          type : "post",
          url : '/administor/login',
          dataType : 'json',
          data : {
         
              "id":this.login.username,
              "password":this.login.password
              
          },
          success : function(response) {
    
          if(response.data===1){

                alert("登陆成功");
                 if(localStorage){
                    localStorage.setItem("admId",id);
                }else{
                    alert('This browser supports localStorage');
                }
                window.location.href="/#/adminstrator";
          }else{
              alert("密码错误！");  
          }
          },
          error : function(err){
          console.log(err)
          }
          });
            }
            else{
                this.$message({
                        type:"info",
                        message:"请选择登录入口"
                    });
            }
		}
      },


      goToModifyPassword () {
        this.$router.push({path: '/modifyPassword'})// 进入更改密码界面
        //设想修改密码界面并没有绑定刚刚输入的ID，修改界面需要输入ID
      },
      changeUrl () {
        var url = this.imgUrl
        var timeStamp = (new Date()).valueOf()
        url = url.substring(0, 45)
        if ((url.indexOf('&') >= 0)) {
          url = url + 'xtamp=' + timeStamp
        } else {
          url = url + '?timestamp=' + timeStamp
        }
        return url
      },
      getVerCode () {
        var self = this
        self.imgUrl = self.changeUrl()
      }
    
  }
  }
</script>

<style>
    #ForgetPassword {
        color: #fff;
        font-weight: bold;
        cursor: help;
        text-decoration: underline;
    }
    #login {
        color: #fff;
        font-weight: bold;
        cursor: help;
        text-decoration: underline;
        margin-top:100px;
    }
    
    .logo{
      float: left;
      padding-left: 40px;
      font-size: 30px;
      color:cornflowerblue
    }
    .ms-login img {
        float: right;
        height: 34px;
        width: 100%;
        font-size: inherit;
        display: inline-block;
        border-radius: 4px;
        border: 1px solid #bfcbd9;
        cursor: pointer;
    }
    .el-radio{
      color: #fff;
    }
    .login-btn span{
        text-decoration: none;
    }
    .ms-login{
      position: absolute;
      display: inline-block;
      left:75%;
      top:50%;
      width:300px;
      height:300px;
      margin:-100px 0px 100px -190px;
      padding: 40px;
      border-radius: 5px;
    }
    .ms-login el-tabs__item {
      position: relative;
      padding: 0 60px;
    }
    .login-wrap{
        position: absolute;
		margin-top:0px;
        width:100%;
        height:100%;
        overflow-y: scroll;
    }
    .background{
	
        position:relative;
        width: 100%;
        height: 200px;
    }
    .background-img{
        /*background-image: url(../assets/LoginWallpaper.jpg);
        background: no-repeat center top;
        background-size: contain;*/
		
        position: absolute;
        width: 100%;
        height:200px;
    }
    .login-btn{
	    margin-top:10px;
        text-align: center;
    }
    .login-btn button{
        width:100%;
        height:36px;
    }
	.forgetpassword{
	margin-top:20px;
	text-align: center;
	}
	

</style>
