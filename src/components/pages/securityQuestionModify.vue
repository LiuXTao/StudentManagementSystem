<<template>
    <div class="mainboard">
        <br><br>
        <div id="board1">
        <div class="tips">请回答密保问题</div>
        <br>
        <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
            <el-form-item label="第一个问题：" prop="firstQues">
                {{ruleForm2.firstP}}
                <br>
                <el-input type="text"v-model="ruleForm2.firstA" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第二个问题：" prop="secondQues">
                 {{ruleForm2.secondP}}
                <br>
                <el-input type="text"v-model="ruleForm2.secondA" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第三个问题：" prop="thirdQues">
                 {{ruleForm2.thirdP}}
                <br>
                <el-input type="text"v-model="ruleForm2.thirdA" auto-complete="off" ></el-input>
            </el-form-item>      
            <el-form-item>
                <el-button type="primary" @click="submit('ruleForm2')">确认</el-button>
                <el-button @click="resetForm('ruleForm2')">重置</el-button>
            </el-form-item>
        </el-form>  
        </div>

        <div id="board2">
            <div class="tips">请选择密保问题</div>
            <br>
            <el-form ref="form" :model="form" label-width="80px" class="questionaire">
                
                <el-form-item label="问题一">
                    <el-select v-model="form.question.question1" placeholder="请选择密保问题">
                        <!-- <el-option :label="form.question.question1.label1" :value="form.question.question1.value"></el-option>
                        <el-option label="区域二" value="beijing"></el-option> -->
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input :value="answer.answer1" type="text" auto-complete="off" class="answer"></el-input>
                </el-form-item>
                <el-form-item label="问题二">
                    <el-select v-model="form.question.question2" placeholder="请选择密保问题">
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input :value="answer.answer2"type="text" auto-complete="off" class="answer"></el-input>
                </el-form-item>
                <el-form-item label="问题三">
                    <el-select v-model="form.question.question3" placeholder="请选择密保问题">
                        <template v-for="lable in labels">
                            <el-option :lable="lable.label" :value="lable.value"></el-option>
                        </template>
                    </el-select>
                    <br>
                    <el-input :value="answer.answer3"type="text" auto-complete="off"class="answer"></el-input>
                </el-form-item>
            </el-form>
            </div>
        </div>    

    </div>
</template>
<<script>
export default {
    data:function() {
      return {
        ruleForm2: {
            firstP:"你第一所学校是什么",
            firstA:"",
            secondP:"你父亲的名字是什么",
            secondA:"",
            thirdP:"你母亲的名字是什么",
            thirdA:""
        },
        labels:[
                {label:"你第一所学校是什么",value:"你第一所学校是什么"},
                {label:"你父亲的名字是什么",value:"你父亲的名字是什么"},
                {label:"你母亲的名字是什么", value:"你母亲的名字是什么"}
            ],
        answer:{
            answer1:"",
            answer2:"",
            answer3:""
        },
        form:{
            
            question:[{
                // question1:[{label1:"你第一所学校是什么",label2:"你父亲的名字是什么",label3:"你母亲的名字是什么"
                // question2:[{labels:["你第一所学校是什么","你父亲的名字是什么","你母亲的名字是什么",],value:""}],  
                // question3:[{labels:["你第一所学校是什么","你父亲的名字是什么","你母亲的名字是什么",],value:""}]
            }],
           
        }
        

      }
    },
    methods:{

         submit(formname){
          //验证
             $('#board1').hide();
             $('#board2').show();
        },
      submitForm(formname){
          
           
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
