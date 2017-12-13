<template>
    <div id="mainboard2">
        <br><br>
        <div id="board2">
        <el-form  :model="form2"   label-width="100px" class="demo-ruleForm2">
            <el-form-item label="第一个问题：">
                 {{this.form2.question1}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="this.form2.answer.answer1"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第二个问题：">
                  {{this.form2.question2}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="this.form2.answer.answer2"  auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="第三个问题：">
                 {{this.form2.question3}}
                <br>
                <el-input type="text" placeholder="请输入答案" v-model="this.form2.answer.answer3"  auto-complete="off" ></el-input>
            </el-form-item>      
        </el-form>  
        </div>
  <el-button type="primary" @click="submitForm2()">确认</el-button>
                <el-button @click="resetForm2">重置</el-button>
				<br/><br/>
    </div>
</template>
<<script>
export default { 
    data:function() {
      return {
        form2:{
            question1:'11',
            question2:'',
            question3:'',
            answer:{
                answer1:"111",
                answer2:"22",
                answer3:"33"
            }
        }
        

      }
    },
    methods:{

        resetForm2(){
            this.form2.answer.answer1="";
			this.form2.answer.answer2="";
			this.form2.answer.answer3="";
           
        },
      submitForm2(){
         
      }
    }
}
</script>
<<style scoped>
#mainboard2{
   
   margin:0px auto;
   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.demo-ruleForm2{
  width:35%;
  font-size:20px;
    margin:0px auto;
}
</style>
