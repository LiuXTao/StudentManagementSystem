<<template>
        <div id="mainBoard">
          <br><br>
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
         <div id="board2" >
          <el-form :model="ruleForm2" :rules="rules2" ref="ruleForm2" label-width="100px" class="demo-ruleForm">
              <template v-for="item in items">
              </template>
              <el-form-item label="用户名" prop="username">
                {{ruleForm2.username}}
              </el-form-item>
              <el-form-item label="原密码" prop="primarypass">
                  <el-input icon="search" type="password"v-model="ruleForm2.oldPass" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="新密码" prop="pass">
                  <el-input icon="search"type="password"v-model="ruleForm2.pass" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                  <el-input icon="search"type="password"v-model="ruleForm2.checkPass" auto-complete="off" ></el-input>
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
      var checkOldPassword=(rule,value,callback)=>{
          var vm=this.$data
      }

      return {
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
        }
      } 
    },
    methods:{
        // submit(formname){
        //   //验证
        //      $('#board1').hide();
        //      $('#board2').show();
        // },
        submitForm(formname){
            this.$refs[formname].validate((valid)=>{
                if(valid)
                    alert('submit');
                else{
                    console.log('error submit');
                    return false;
                }
            });
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
