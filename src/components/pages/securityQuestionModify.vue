<<template>
    <div class="mainboard">
        <br><br>
        <div id="board1">
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

        <div id="board2">
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

    </div>
</template>
<<script>
export default { 
    props:["securityQues"],
    data:function() {
       
      return {
       
        answer1:'',
        answer2:'',
        answer3:'',
        labels:[
                {label:"你第一所学校是什么",value:"你第一所学校是什么"},
                {label:"你父亲的名字是什么",value:"你父亲的名字是什么"},
                {label:"你母亲的名字是什么", value:"你母亲的名字是什么"}
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
          //验证
            //  console.log(this.answer1,this.answer2,this.answer3);
            //  console.log(this.securityQues.firstA,this.securityQues.secondA,this.securityQues.thirdA);
             if(this.answer1==this.securityQues.firstA&&this.answer2==this.securityQues.secondA&&this.answer3==this.securityQues.thirdA)
            {
                   
                   $('#board1').hide();
                   $('#board2').show();
            }  else{
                this.$message({
                    type:"info",
                    message:"密保回答错误"
                });
            }
        },
        resetForm(){
            this.answer1="";
            this.answer2="";
            this.answer3="";
        },
      submitForm(formname){
          console.log(this.form.question1,this.form.question2,this.form.question3);
          console.log(this.form.answer.answer1,this.form.answer.answer2,this.form.answer.answer3);
           this.$confirm("确认要修改密保",'提示',{ confirmButtonText: '确定',
                      cancelButtonText: '取消',type:'warning'})  .catch((error) => {
                            console.log("Error:", error);
                            this.$message({
                                    type:'warning',
                                    message:'AJAX FAIL'
                                });
                        });
      }
    }
}
</script>
<<style scoped>
.mainboard{
   
   margin:0px auto;
   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.questionaire{
    width:35%;
    margin:0px auto;
}
.tips{
    
    font-size:20px;
}
.answer{
    /* margin-left:42px; */
    width:70%
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
