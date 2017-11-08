<template>
<div class="mainscore">
<v-head></v-head>
    <el-table
      :data="newsList"
      style="width: 100%">
	  
      <el-table-column
        label="课程名字"
        width="200" >
		<template slot-scope="scope">
		<p>{{scope.row.coursename}}</p>
		 </template>
      </el-table-column>
      <el-table-column
        label="教学班"
        width="200">
		<template slot-scope="scope">
		<p>{{scope.row.teachclass}}</p>
		 </template>
      </el-table-column>
      <el-table-column
        label="学生人数"
		 width="200">
		 <template slot-scope="scope">
		<p>{{scope.row.studentnumber}}</p>
		 </template>
      </el-table-column>
	   <el-table-column
        label="操作">
		<template slot-scope="scope">
          <el-button  size="mini" type="primary" @click="newsClick1(scope.row)">批量录入</el-button>
		  <el-button size="mini" type="primary" @click="newsClick2(scope.row)">单个录入</el-button>
		  <el-button size="mini" type="primary" @click="newsClick3(scope.row)">修改成绩</el-button>
		  <el-button size="mini" type="primary" @click="newsClick4(scope.row)">查看成绩</el-button> 
      </template>
      </el-table-column>
    </el-table>
	
<el-dialog title="单个录入成绩" :visible.sync="dialogFormVisible">
<el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
  <el-form-item label="学号" prop="pass">
    <el-input  v-model="ruleForm2.pass" auto-complete="off"></el-input>
  </el-form-item>
  <el-form-item label="成绩" prop="score">
    <el-input v-model.number="ruleForm2.score"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
    <el-button @click="quxiao('ruleForm2')">取消</el-button>
  </el-form-item>
</el-form>
</el-dialog>

	</div>
  </template>

  <script>
  import vHead from '../commons/TeacherNav.vue';
    export default {
	 components:{
        vHead,
    },
      data(){
	 
	  var checkscore = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('成绩不能为空'));
        }
        setTimeout(() => {
          if (!Number.isInteger(value)) {
            callback(new Error('请输入数字值'));
          } else {
            if (value<0||value>100) {
              callback(new Error('必须在0-100之间'));
            } else {
              callback();
            }
          }
        }, 1000);
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入学号'));
        } else {
          callback();
        }
      };
        return {
		 hostUrl:"/",
		  k:1,
          newsList: [{
		  id:1,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:2,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:3,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:4,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }],
		  ruleForm2: {
          pass: '',
          score: ''
        },
        rules2: {
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
          score: [
            { validator: checkscore, trigger: 'blur' }
          ]
        },
		dialogFormVisible: false
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
	   newsClick1(m){
                
                console.log("11111111");
                //console.log(coursename);
                this.$router.push('/teacher/batchscore?'+m.id);
            },
	   newsClick2(m){
	   
                this.dialogFormVisible = true;
				this.k=m.id;
                console.log("11111111");
                
            },
		newsClick3(m){
                
                console.log("11111111");
                //console.log(coursename);
                this.$router.push('/teacher/changescore?'+m.id);
            },
		newsClick4(m){
                
                console.log("11111111");
                //console.log(coursename);
                this.$router.push('/teacher/seescore?'+m.id);
            },	
        getNews(){//向后端获取数据
                var self = this;
               // self.newsList=[];
                self.$http({
                    url:'/score',
                    method:'get',
                    baseURL:self.hostURL
                }).then((response)=>{
                    self.newsList = [];
                    self.newsList = response.data;
                }).catch((error)=>{
                    self.$message({
                        type:'info',
                        message:'connect fail'
                    });
                });
            },
			
			submitForm(formName) {//提交单个录入成绩
			 
	// alert(this.ruleForm2.score);
	  //alert(this.k);
	     
		 
        this.$refs[formName].validate((valid) => {
          if (valid) {
		    this.dialogFormVisible = false;
           //添加与后端交互的代码
		    this.$http({
                            url: '/score',
                            method: 'post',
                            baseURL: this.hostUrl,
                            data:this.ruleForm2
                        })
                        .then((response) => {
                            if(response.data.code == "200"){
                                this.$message({
                                    type:'success',
                                    message:'提交成功'
                                });
                                
                            }
                            else {
                                console.log(response.data.code);
                                this.codeParsing(response.data.code);                                
                            }
                            setTimeout(()=>{window.location.reload()},1000);

                        })
                        .catch((error) => {
                            console.log("Error:", error);
                            this.$message({
                                    type:'warning',
                                    message:'网络无连接'
                                });
                           

                        });
          } else {
		  //this.dialogFormVisible = true;
            console.log('error submit!!');
            return false;
          }
        });
		
		setTimeout(() => {
         this.resetForm(formName);
        }, 2000);
		
      },
      resetForm(formName) {
	    //this.dialogFormVisible = false;
        this.$refs[formName].resetFields();
      },
	  quxiao(formName){
	  this.dialogFormVisible = false;
	    this.$message({
            message:'已取消'
                                });
        this.$refs[formName].resetFields();
		
	  }

        },
		  
        mounted(){
            var self = this;
            self.getNews();
        }
	 
	   
    }
  </script>
  <style scoped>
  .mainscore{
  width:70%;
  margin:50px 200px;
  }
  a {
    text-decoration: none;
}
a:hover, a:visited {
    text-decoration: none;
}
.el-table{
text-align:left;
}
  </style>