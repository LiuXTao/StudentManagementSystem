<template>
  <div class="login-wrap">
    <header class="header">
      <div class="logo">教务系统</div>
  </header>
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
          </div>
          <div><span @click="goToModifyPassword" id="ForgetPassword">忘记密码 </span>
          </div>
        </el-form>
      </el-tabs>
    </div>
  </div>
  </div>
</template>

<script>
  import loginImg from '../../assets/LoginWallpaper.jpg'
  export default {
    data: function () {
      return {
        activePane: 'login',
        hostUrl: '/', // IP
        imgUrl: '/checkcode',
        pic_location: loginImg,
        login: {
          username: '',
          password: '',
          verCode: '',
          radio: ''
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
    methods: {
      loginForm (formName) {
        if (this.login.radio === 1) { // 学生
          //取得输入框的值
          //post到后端，进行验证
          //返回必要信息（网络、密码验证、验证码验证等）
          /* ref:https://github.com/doterlin/vue-example-login/blob/master/component/Login.vue  网上登录的例子
          const self = this
        // sessionStorage.setItem('ms_type',2);
         self.$refs[formName].validate((valid) => {
          if (valid) {
            this.$axios({
              url: '/user/login',
              method: 'post',
              baseURL: this.hostUrl,
              data: {
                ID: this.login.username,
                password: this.login.password,
                checkcode: this.login.verCode
              }
            })
          } else {
            console.log('error login!!');
            this.$message({
              title: '格式错误',
              message: '请检查输入域是否正确',
              type: 'error'
            });
            */
          /*  以下为树茂项目的源代码
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
                }*/
          /*
          loginForm(formName) {
                const self = this;
                // sessionStorage.setItem('ms_type',2);
                self.$refs[formName].validate((valid) => {
                    if (valid) {
                       this.$axios({
                            url: '/user/login',
                            method: 'post',
                            baseURL: this.hostUrl,

                            data: {
                                email: this.login.username,
                                password: this.login.password,
                                checkcode: this.login.verCode
                            }
                        })
                        .then((response) => {
                            if (response.data.code === 200) {
                                //user == 0
                                if (response.data.type === 0) {
                                    localStorage.setItem('ms_userid',response.data.userid);
                                    localStorage.setItem('ms_username', response.data.nickname);
                                    sessionStorage.setItem('ms_type', response.data.type);
                                    var compare={data:[]};
                                    localStorage.setItem('compare_data',JSON.stringify(compare));
                                    localStorage.setItem('kind','none');
                                    self.$router.push('/user/news-list');
                                } else {
                                //admin ==1
                                    localStorage.setItem('ms_username', response.data.nickname);
                                    sessionStorage.setItem('ms_type', response.data.type);
                                    self.$router.push('/admin/administrator');
                                }
                            } else {
                                // console.log(response);
                                console.log('code', response.data.code);
                                self.codeParsing(response.data.code);
                            }
                        })
                        .catch((error) => {
                            console.log("【Error】:", error);
                            this.$message({
                                title: '网络请求错误',
                                message: '请检查网络并重试',
                                type: 'error'
                            });
                        });
                    } else {
                        console.log('error login!!');
                        this.$message({
                            title: '格式错误',
                            message: '请检查输入域是否正确',
                            type: 'error'
                        });
                        return false;
                    }
                });
            },
         */
          this.$router.push({path: '/student'})// 进入学生界面，绑定学生界面的ID是学生登录时候的ID
        } else if (this.login.radio === 2) { // 教师
          this.$router.push({path: '/teacher'}) // 进入教师界面，
        } else { // 管理员
          this.$router.push({path: '/admin'}) // 进入管理员界面
        }
        /*
            return false;
          }
        }); */
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
    .header {
      height: 70px;
      background-color:lightgrey;
      top: 0;
      left: 0;
      width: 100%;
      padding-bottom: 10px;
      line-height: 70px;
      z-index: 100;
      display: table;
      position: fixed;

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
        width:100%;
        height:100%;
        overflow-y: scroll;
    }
    .background{
        position:relative;
        width: 100%;
        height: 600px;
    }
    .background-img{
        /*background-image: url(../assets/LoginWallpaper.jpg);
        background: no-repeat center top;
        background-size: contain;*/
        position: absolute;
        width: 100%;
        height:600px;
    }
    .login-btn{
        text-align: center;
    }
    .login-btn button{
        width:100%;
        height:36px;
    }

</style>
