<template>
        <div id="mainBoard3">
          <br><br>
        
         <div id="board3" >
          <el-form :model="ruleForm3" :rules="rules3" ref="ruleForm3" label-width="100px" class="demo-ruleForm3">
              <el-form-item label="新密码" prop="pass">
                  <el-input icon="search"type="password" v-model="ruleForm3.pass" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="确认密码" prop="checkPass">
                  <el-input icon="search"type="password" v-model="ruleForm3.checkPass" auto-complete="off" ></el-input>
              </el-form-item>      
           
                
             
            </el-form>  
        </div>
		<el-button type="primary" @click="submitForm3">确认修改</el-button>
                <el-button @click="resetForm3()">重置</el-button>
				<br/><br/><br/>
  </div>
</template>

<script>
export default {
 
    data:function(){
      
     var checkNewPassword = (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[a-zA-Z0-9]+$/;
                console.log(typeof value);
                if(!value){
                    vm.check1 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if(value.length < 6 || value.length > 16){

                    vm.check1 = true;
                    return callback(new Error('密码长度为6 - 16个字符'));
                }
                else if(!value.match(reg))
                {
                    vm.check1 = true;
                    return callback(new Error('密码仅可由数字与字母组成'));
                }
                else{
                    vm.check1 = false;
                }
            };

             var checkPassword = (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[a-zA-Z0-9]+$/;
                if(!value){
                    vm.check2 = true;
                    return callback(new Error('密码不能为空'));
                }
                else if(value.length < 6 || value.length > 16){
                    vm.check2 = true;
                    return callback(new Error('密码长度为6 - 16个字符'));
                }
                else if(!value.match(reg))
                {   
                    vm.check2 = true;
                    return callback(new Error('密码仅可由数字与字母组成'));
                }
                else{
                    vm.check2= false;
                }
            };
    

      return {
        hostUrl:"/",
        check1:true,
        check2:true,

       
        ruleForm3: {
            pass: '',
            checkPass: ''
        },
        rules3:{
            pass:[
                { validator: checkNewPassword, trigger:'change'},
                { validator: checkNewPassword, trigger:'blur'}
            ],
            checkPass:[
                { validator: checkPassword, trigger:'change'},
                { validator: checkPassword, trigger:'blur'}
            ]
        }
      } 
    },
    methods:{
        submitForm3:function(){
         
        },
        
        resetForm(){
            
        }
    }

}
</script>
<style scoped>
#mainBoard3{
   width:60%;
   margin:0px auto;
 font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}

.demo-ruleForm3{
    margin:0px auto;

    width: 400px;
}
</style>
