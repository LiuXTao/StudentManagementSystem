<template>
    <div class="mainboard">
        <br><br>
        <div id="board1" ref="board1">
        <div class="tips">请回答密保问题</div>
        <br>
        <el-form  :model="this.securityQues"   label-width="100px" class="demo-ruleForm">
            <el-form-item label="第一个问题：">
                {{this.securityQues.firstP}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="answer1"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第二个问题：">
                 {{this.securityQues.secondP}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="answer2"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第三个问题：">
                 {{this.securityQues.thirdP}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="answer3"  auto-complete="off" ></el-input>
            </el-form-item>      
            <el-form-item>
                <el-button type="primary" @click="onSubmit('securityQues')">确认</el-button>
                <el-button @click="resetForm('securityQues')">重置</el-button>
            </el-form-item>
        </el-form>  
        </div>

        <div id="board2" ref="board2">
            <div id="title">设置密保</div>
            <div class="tips">请选择密保问题</div>
            <br>
            <el-form ref="form"  label-width="80px" class="questionaire">
                
                <el-form-item label="问题一">
                    <el-select v-model="form.question1" placeholder="请选择密保问题">
                        <!-- <el-option :label="form.question.question1.label1" :value="form.question.question1.value"></el-option>
                        <el-option label="区域二" value="beijing"></el-option> -->
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input v-model="form.answer.answer1" type="text" auto-complete="off" class="answer"></el-input>
                </el-form-item>
                <el-form-item label="问题二">
                    <el-select v-model="form.question2" placeholder="请选择密保问题">
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input v-model="form.answer.answer2"type="text" auto-complete="off" class="answer"></el-input>
                </el-form-item>
                <el-form-item label="问题三">
                    <el-select v-model="form.question3" placeholder="请选择密保问题">
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input v-model="form.answer.answer3"type="text" auto-complete="off"class="answer"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('form')" id="submit">提交</el-button>
                    <el-button  @click="resetForm('form')" id="reset">重置</el-button>
                </el-form-item>
            </el-form>

            
        </div>    

    </div>
</template>
<script>
export default { 
    props:["securityQues"],

    created:function(){
        this.userType=localStorage.getItem("UserType");
        if(this.userType==="111"){
            this.username=localStorage.getItem("stuId");
        }else{
            this.username=localStorage.getItem("teaId");
        }
        console.log(this.userType);
        console.log(this.username);
    },
    mounted:function(){
        console.log(this.securityQues);
        if(this.securityQues.firstP=="" && this.securityQues.secondP=="" && this.securityQues.thirdP==""&&
        this.securityQues.firstA=="" &&this.securityQues.secondA=="" &&this.securityQues.thirdA=="")
        {   
            this.$refs.board1.style.display='none';
            this.$refs.board2.style.display='block';
            console.log("what??");
        }
        
    },
    data:function() {
       
      return {
        username:'',
        userType:'',
        // 原密保答案
        answer1:'',
        answer2:'',
        answer3:'',
        labels:[
                {label:"你第一所学校是什么",value:"你第一所学校是什么"},
                {label:"你父亲的名字是什么",value:"你父亲的名字是什么"},
                {label:"你母亲的名字是什么", value:"你母亲的名字是什么"},
                {label:"你的手机号码是什么", value:"你的手机号码是什么"},
                {label:"你的故乡是哪里", value:"你的故乡是哪里"},
                {label:"你的邮箱是多少", value:"你的邮箱是多少"},
                {label:"你的班主任叫什么", value:"你的班主任叫什么"},
            ],
        
        form:{
            question1:'',
            question2:'',
            question3:'',
            answer:{
                answer1:"",
                answer2:"",
                answer3:""
            }
        }    

      }
    },
    methods:{

         onSubmit(){
            var target="";
            if(this.userType==="111")
                target="/student/checkAnswer";
            else
                target="/teacher/checkAnswer";
            console.log("checkAns--->"+target);
            var vm=this;
            console.log(vm);
            $.ajax({
                type:'post',
                url:target,
                dataType:'json',
                data:{
                    'id':vm.username,
                    'question1':vm.securityQues.firstP,
                    'question2':vm.securityQues.secondP,
                    'question3':vm.securityQues.thirdP,
                    'answer1':vm.answer1,
                    'answer2':vm.answer2,
                    'answer3':vm.answer3
                },
                success:function(response){
                    console.log("进入succ");
                    if(response.data===1){
                       vm.$message({
                            type: 'success',
                            message: '回答正确!'
                       })
                    vm.$refs.board1.style.display='none';
                    vm.$refs.board2.style.display='block';
                    console.log(localStorage);
                    }else{
                        vm.$message({
                        type:"warning",
                        message:"回答错误"
                        });
                     
                    }
                },
                error:function(err){
                    console.log(err);
                    console.log("error");
                }
            })


        },
        resetForm(){
            this.answer1="";
            this.answer2="";
            this.answer3="";
        },
      submitForm(formname){
        console.log(this.form.question1,this.form.question2,this.form.question3);
        console.log(this.form.answer.answer1,this.form.answer.answer2,this.form.answer.answer3);
        if(this.form.question1==''||this.form.question2==''||this.form.question3==''){
            this.$message({
                type: 'warning',
                message: '密保不能为空!'
            })
        }else if(this.form.answer.answer1==''||this.form.answer.answer2==''||this.form.answer.answer3==''){
            this.$message({
                type:'warning',
                message:'密码不能为空！'
            })
        }else{
        var vm=this;
        const h = this.$createElement;
        this.$msgbox({
          title: '消息',
          message: h('p', null, [
            h('span', null, '是否确定要'),
            h('i', { style: 'color: teal' }, '修改密保')
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
            if (action === 'confirm') {
                console.log(vm.userType);
                var target='';
                if(vm.userType==="111")
                    target='/student/resetSecurity';
                else
                    target='/teacher/resetSecurity'
                console.log("confirm");
                console.log(target)
              $.ajax({
                type:'post',
                url:target,
                dataType:'json',
                data:{
                    'id':vm.username,
                    'queone':vm.form.question1,
                    'quetwo':vm.form.question2,
                    'quethree':vm.form.question3,
                    'ansone':vm.form.answer.answer1,
                    'anstwo':vm.form.answer.answer2,
                    'ansthree':vm.form.answer.answer3
                },
                success:function(response){
                    console.log("进入success");
                    if(response.data===1){
                       vm.$message({
                            type: 'success',
                            message: '修改成功!'
                       })
                       console.log(localStorage);
                    }else{
                       vm.$message({
                            type: 'warning',
                            message: '网络错误!'
                       })
                    }
                },
                error:function(err){
                    console.log(err);
                    console.log("error");
                }
            })
            done();
            } else {
              console.log("取消修改");
               vm.$message({
                        type: 'info',
                        message: '已取消修改'
                      });    
              done();
            }
          }
        });
        }
      }
    }
}
</script>
<style scoped>
.mainboard{
   
   margin:0px auto;
   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.questionaire{
    width:35%;
    margin:0px auto;
}
.tips{
    
    font-size:18px;
}
#title{
    font-size:30px;
}
.answer{
    /* margin-left:42px; */
    width:58%
}
.demo-ruleForm{
  width:35%;
  font-size:20px;
    margin:0px auto;
}

#board1{
    display: inline;
  }
#board2{
    display:none;
  }
</style>
