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
    <el-button @click="resetForm('ruleForm2')">重置</el-button>
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
       getNews(str){//从后端获取数据
                
            },
			submitForm(formName) {
			 
	  //alert(this.ruleForm2.score);
	  //alert(this.k);
        this.$refs[formName].validate((valid) => {
          if (valid) {
		    this.dialogFormVisible = false;
            alert('submit!');//添加与后端交互的代码
          } else {
            console.log('error submit!!');
            return false;
          }
        });
		
		 setTimeout(() => {
         this.resetForm(formName);
        }, 1000);
		
      },
      resetForm(formName) {
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