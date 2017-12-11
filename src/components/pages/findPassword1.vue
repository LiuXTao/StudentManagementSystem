<template>
        <div id="mainBoard1">
          <br><br>
        
         <div id="board1" >
		
          <el-form :model="form1" :rules="rules1" ref="form1" label-width="100px" class="demo-ruleForm1">
              <el-form-item label="请填写账号" prop="pass">
                  <el-input icon="search"type="password" v-model="form1.pass" auto-complete="off"></el-input>
              </el-form-item>    
             
            </el-form>  
        </div>
		<el-button type="primary" @click="submitForm1">确认</el-button>
		<br/>
		<br/>
		<br/>
  </div>
</template>

<script>
export default {
 
    data:function(){

             var checkID= (rule,value,callback) => {
                var vm = this.$data;
                var reg = /^[0-9]+$/;
                if(!value){
                    vm.check1 = true;
                    return callback(new Error('账号不能为空'));
                }
                else if(value.length !=12){
                    vm.check2 = true;
                    return callback(new Error('账号长度为12个字符'));
                }
                else if(!value.match(reg))
                {   
                    vm.check1 = true;
                    return callback(new Error('密码仅可由数字组成'));
                }
                else{
                    vm.check1= false;
                }
            };
    

      return {
        hostUrl:"/",
        check1:true,
       
        form1: {
            pass: '',
        },
        rules1:{
            pass:[
                { validator: checkID, trigger:'change'},
                { validator: checkID, trigger:'blur'}
            ],
           
        }
      } 
    },
    methods:{

        submitForm1:function(){
          
         
        }
    }

}
</script>
<style scoped>
#mainBoard1{
   width:60%;
   margin:0px auto;
 font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
}
.demo-ruleForm1{
    margin:0px auto;

    width: 400px;
}
 

</style>
