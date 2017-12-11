<template>
<div class="mainscore">
<v-head></v-head>

<div class="content">
   
        <div class="firstBar">
            学年 <el-select v-model="yearSelected" class="selectBar" clearable placeholder="请选择学年">
                    <el-option v-for="item in years" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            学期 <el-select v-model="monthSelected" class="selectBar" clearable placeholder="请选择学期">
                    <el-option v-for="item in months" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            课程性质 <el-select v-model="typeSelected" class="selectBar" clearable placeholder="请选择课程性质">
                    <el-option v-for="item in courseTypes" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                  </el-select>
            <el-button type="primary" @click="searchCourse" id="query">我的课程</el-button>
            </div>
            <div class="clear"></div>
    
    </div>
    
    <div class="courseBar" ref="coursetable">
        
        <el-table
        id="coursetable"
        :data="courseList"
       
        border>
        <el-table-column
            label="课程ID"
            min-width="15%"
            >
            <template slot-scope="scope">
            <p>{{scope.row.cID}}</p>
            </template>
        </el-table-column>
        <el-table-column
            label="课程名字"
            min-width="15%"
            >
            <template slot-scope="scope">
            <p>{{scope.row.cname}}</p>
            </template>
        </el-table-column>
        <el-table-column
            label="开课学院"
            min-width="15%"
            >
            <template slot-scope="scope">
            <p>{{scope.row.cbelongto}}</p>
            </template>
        </el-table-column>
        <el-table-column
            label="学生人数"
            min-width="15%"
            >
            <template slot-scope="scope">
            <p>{{scope.row.stuNumber}}</p>
            </template>
        </el-table-column>
        <el-table-column
            label="操作"
            min-width="30%"
            >
		<template slot-scope="scope">
          <el-button  type="primary" @click="newsClick1(scope.row)">批量录入</el-button>
		  <el-button  type="primary" @click="newsClick2(scope.row)">单个录入</el-button>
		  <el-button  type="primary" @click="newsClick3(scope.row)">修改成绩</el-button>
		  <el-button type="primary" @click="newsClick4(scope.row)">查看成绩</el-button> 
      </template>
      </el-table-column>
    </el-table>
	
<el-dialog title="单个录入成绩" :visible.sync="dialogFormVisible">
    <el-form :model="ruleForm2" status-icon :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
    <el-form-item label="学号" prop="stuid">
        <el-input  v-model="ruleForm2.stuid" auto-complete="off"></el-input>
    </el-form-item>
    <el-form-item label="成绩" prop="score">
        <el-input v-model.number="ruleForm2.score"></el-input>
    </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm2')">提交</el-button>
        <el-button @click="quxiao('ruleForm2')">返回</el-button>
    </el-form-item>
    </el-form>
</el-dialog>
   
        </div>
	</div>
  </template>

  <script>
  import vHead from '../commons/TeacherNav.vue';
    export default {
    
    created(){
        if(localStorage.getItem("selectYear")!=null){
            this.yearSelected=localStorage.getItem("selectYear");
            this.monthSelected=localStorage.getItem("selectTerm");
            if(localStorage.getItem("selectType")!=null)
                this.typeSelected=localStorage.getItem("selectType");
            var selectedAlready=localStorage.getItem("openClass");
            this.courseList=localStorage.getItem("getCourses");
            if(selectedAlready===1)
                $("#courseBar").show()

        }

    },
	 components:{
        vHead,
    },
      data(){
           return {
                yearSelected:'',
                monthSelected:'',
                typeSelected:'',
           years:[ 
           {label:'2012-2013',value:'2012-2013'},
           {label:'2013-2014',value:'2013-2014'},
           {label:'2014-2015',value:'2014-2015'},
           {label:'2015-2016',value:'2015-2016'},
           {label:'2016-2017',value:'2016-2017'},
           {label:'2017-2018',value:'2017-2018'}
          ],
          months:[ 
            {label:1,value:1},
            {label:2,value:2}
        ],
        courseTypes:[
         
            {label:'必修课',value:1},
            {label:'选修课',value:2},
            {label:'通选课',value:3}
        ],
        tea_id:'',
		hostUrl:"/",
		k:'',
        courseList: [],

		ruleForm2: {
            stuid: '',
            score: '',
        },
        rules2: {
          stuid: [
            { validator: validatePass, trigger: 'blur' }
          ],
          score: [
            { validator: checkscore, trigger: 'blur' }
          ]
        },
		dialogFormVisible: false
        }
	 
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
                localStorage.setItem("selectCourse",m.cID);
                this.$router.push('/teacher/batchscore');

            },

	   newsClick2(m){
	   
                this.dialogFormVisible = true;
                this.k=m.cID;
                console.log(this.k);
            
            },
		newsClick3(m){
                
                console.log("11111111");
                localStorage.setItem("selectCourse",m.cID);
                this.$router.push('/teacher/changescore?'+m.id);
            },
		newsClick4(m){
                
                console.log("11111111");
                localStorage.setItem("selectCourse",m.cID);
                this.$router.push('/teacher/seescore?'+m.id);
            },	
        getNews(){//向后端获取数据
                var self = this;
               // self.newsList=[];
                
            },
		searchCourse(){
            console.log(this.yearSelected,this.monthSelected,this.typeSelected);
            if(this.yearSelected==''){
                this.$message({
                    type: 'info',
                    message: '查询学年不能为空'
                })
            }
            else if(this.monthSelected==''){
                 this.$message({
                    type: 'info',
                    message: '查询学期不能为空'
                })
            }else{
            //按照检索条件发送搜索要求
            var temp=this.yearSelected.split('-');
            var yearsSelected= temp[0]+temp[1]
            console.log(yearsSelected);
            this.courseList=[]
            this.tea_id=localStorage.getItem("teaId");
            var vm=this;
             $.ajax({
                type:'post',
                url:'/teacher/coursequery',
                dataType:'json',
                data:{
                     "id":this.tea_id,
                    "selectYear":yearsSelected,
                    "selectTerm":this.monthSelected,
                    "selectType":this.typeSelected
                },
                success:function(response){
                    if(response.string!="")
                    {
                        vm.analysisData(vm,response.string);
                        vm.$refs.coursetable.style.display='block';
                        localStorage.setItem("selectYear",vm.yearSelected);
                        localStorage.getItem("selectTerm",vm.monthSelected);
                        if(this.typeSelected!=""){
                            localStorage.getItem("selectType",vm.typeSelected);
                        }
                        localStorage.getItem("openClass",1);
                        localStorage.getItem("getCourses",vm.courseList);
                        
                    }
                    else{
                        this.$message({
                            type: 'info',
                            message: '搜索结果为空'
                        })
                    }    
                },error:function(err){
                    console.log(err)
                    console.log("error")
                }
            })
            }
        },
    analysisData(vm,responseData){
       var arraya=responseData.split(';')
    
        console.log(arraya.length)
        for(var i=0;i<arraya.length;i++){
          var ele=arraya[i].split(',');
          var dist=new Array();
          for(var j=0;j<ele.length;j++){
            var eleItem=ele[j].split(':')
            console.log(eleItem[0],'->',eleItem[1])
            dist[eleItem[0]]=eleItem[1]
          }
         vm.courseList.push(dist);
        }
        console.log(vm.courseList)
        },

		submitForm(formName) {//提交单个录入成绩
			 var vm=this;
                console.log(this.k);
                console.log(this.ruleForm2.stuid);
                console.log(this.ruleForm2.score);
                $.ajax({
                    type:'post',
                    dataType:'json',
                    url:'/teacher/singleScoreSign',
                    data:{
                        "couid":this.k,
                        "stuid":this.ruleForm2.stuid,
                        "score":this.ruleForm2.score,
                    },
                    success:function(response){
                        if(response.data==1){
                            vm.$message({
                                type:'success',
                                message:'录入成绩成功'
                            })
                        }else{
                            vm.$message({
                                type:'warning',
                                message:'成绩录入失败'
                            })
                        }
                    },
                    error:function(err){
                        console.log(err);
                        console.log("error");
                         vm.$message({
                                type:'warning',
                                message:'网络故障'
                            })
                    }
                })
        },

      resetForm(formName) {
	
        this.$refs[formName].resetFields();
      },
	  quxiao(formName){
	  this.dialogFormVisible = false;
	    
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
  /* .mainscore{
    margin-top:3px;
    background-color:#eef1f6;
    text-align: center;
    width: 100%;
  } */
  .content{
    background-color:#eef1f6;
      width: 95%;
    color: #333;
    margin: 0 auto;
    padding: 20px;
    margin-top:5px;
    margin-bottom: 5px;
    
  }
  .courseBar{
        width: 95%;  
        background-color:#eef1f6;
        margin: 0 auto;
        padding: 20px;
        display:none;

  }
  .firstBar{

        width: 100%;
        margin-left:5px;
       
}
  #coursetable{
      width: 94%;
      margin: 0 auto;
     
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