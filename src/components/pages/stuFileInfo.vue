<template>
<div class='wrapper' >
    <v-head></v-head>  
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
<el-form id="selfInfo" :inline="true" :model="selfInfo" :rules="inforule" label-width="100px" >
     
     <el-form-item label="账号：">
        <el-input v-model="selfInfo.student_id" id="id" :disabled="true" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="selfInfo.s_name" id="name" :disabled="true" style="width:220px" ></el-input>
     </el-form-item>
    
    <el-form-item label="学院：">
        <el-input v-model="selfInfo.sdepartment" id="depart" :disabled="true" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="专业：">
        <el-input v-model="selfInfo.smajor" id="major" :disabled="true" style="width:220px"></el-input>
     </el-form-item>
    <el-form-item label="班级：">
        <el-input v-model="selfInfo.sclass" id="class" :disabled="true" style="width:220px"></el-input>
     </el-form-item>

    <el-form-item label="入学时间：" >
        <el-date-picker v-model="selfInfo.stime_of_enrollment" id="enrollTime" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    
    <el-form-item label="毕业时间：" >
        <el-date-picker v-model="selfInfo.stime_of_graduation" id="graudateTime" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    
    <el-form-item label="职务：" prop="stitle">
        <el-input v-model="selfInfo.stitle" :disabled="check1" type="text" id="title"style="width:220px" ></el-input>
    </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="selfInfo.ssex"   placeholder="请选择性别" style="width:220px" id="sex">
            <el-option label=" " value="null"></el-option>
            <el-option label="男" value="male"></el-option>
            <el-option label="女" value="female"></el-option>
        </el-select>
     </el-form-item>
    <el-form-item label="出生日期：" >
        <el-date-picker v-model="selfInfo.sbirthday" type="date" style="width:220px" id="birday"placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    <el-form-item label="民族：" prop="snationality">
        <el-input v-model="selfInfo.snationality" style="width:220px"  type="text" id="nation"></el-input>
     </el-form-item>
    <el-form-item label="健康状态：" prop="shealth_state">
        <el-input v-model="selfInfo.shealth_state" style="width:220px"  type="text" id="health"></el-input>
     </el-form-item>
    <el-form-item label="籍贯：" prop="snative_place">
        <el-input v-model="selfInfo.snative_place" style="width:220px" id="home" type="text" ></el-input>
     </el-form-item>    
    <el-form-item label="政治面貌：" prop="spolitics_status">
        <el-input v-model="selfInfo.spolitics_status"  type="text" id="politics"style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="方向：" prop="sarea_of_interest">
        <el-input v-model="selfInfo.sarea_of_interest"  type="text" id="interest"style="width:220px"  ></el-input>
     </el-form-item>
    <el-col></el-col>
</el-form>
<el-form id="form2" :inline="true" label-width="100px" >
    <el-form-item>
        <el-button type="primary" @click="submitForm" >保存</el-button>
     </el-form-item>
    
</el-form>
        </div>
    </div>
</div>


</template>
    
<script>
import Bus from './bus.js'
  import vHead from '../commons/StudentNav';
  export default {
       components:{
              vHead
          },
        created() {
        if(localStorage){
           
            this.stu_id= localStorage.getItem("stuId");
            console.log("-------------------",this.stu_id);

            }else{
            alert('This browser does not supports localStorage');
        }

        this.selfInfo.student_id=this.stu_id
        var self=this;
        $.ajax({
            type:'post',
            url:'/student/fileInfo',
            dataType:'json',
            data:{
                "id":this.selfInfo.student_id
            },
            success:function(response){
                console.log(response);
                localStorage.setItem("s_name",response.name);
                localStorage.setItem("sdepartment",response.depName);
                localStorage.setItem("smajor",response.majName);
                localStorage.setItem("sclass",response.claName);
                localStorage.setItem("snationality",response.nationality);
                localStorage.setItem("snative_place",response.nativePlace);
                localStorage.setItem("spolitics_status",response.politicalStatus);
                localStorage.setItem("ssex",response.sex);
                localStorage.setItem("sarea_of_interest",response.areaInterest);
                localStorage.setItem("stitle",response.title);
                
                self.selfInfo.s_name=response.name;
                self.selfInfo.snationality=response.nationality;
                self.selfInfo.sdepartment=response.depName;
                self.selfInfo.smajor=response.majName;
                self.selfInfo.sclass=response.claName;
                self.selfInfo.snative_place=response.nativePlace;
                self.selfInfo.spolitics_status=response.politicalStatus;
                self.selfInfo.ssex=response.sex;
                self.selfInfo.sarea_of_interest=response.areaInterest;
                self.selfInfo.stitle=response.title;
            },
            error:function(err){
                console.log(err);
                console.log("error");
            }

        });
        },

  
      data: function(){
          var checklength1 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength2 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength5 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };
                  var checklength3 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 5){
              return callback(new Error('长度不可超于5位'));
           }
        };
                  var checklength4 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 20){
              return callback(new Error('长度不可超于20位'));
           }
        };
                  var checklength6 = (rule,value,callback) => {
            var vm = this.$data;
       if( value.length > 10){
              return callback(new Error('长度不可超于10位'));
           }
        };

      return {
          hostUrl:'/student',
          check1: false,
          stu_id:'',
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
         
          selfInfo:{
              student_id: '',
              s_name: '',
              sdepartment:'',
              smajor:'',
              sclass:'',
              stime_of_enrollment:'',
              stime_of_graduation:'',
              stitle:'',
              ssex:'',
              sbirthday:'',
              snationality:'',
              shealth_state:'',
              snative_place:'',
              spolitics_status:'',
              sarea_of_interest:''
          },
          inforule:{
              stitle:[
                { validator: checklength1, trigger:'change'},
                { validator: checklength1, trigger:'blur'}
              ],
              snationality:[
                { validator: checklength2, trigger:'change'},
                { validator: checklength2, trigger:'blur'}
              ],
               shealth_state:[
                { validator: checklength3, trigger:'change'},
                { validator: checklength3, trigger:'blur'}
              ],
               snative_place:[
                { validator: checklength4, trigger:'change'},
                { validator: checklength4, trigger:'blur'}
              ],
                spolitics_status:[
                { validator: checklength5, trigger:'change'},
                { validator: checklength5, trigger:'blur'}
              ],
                sarea_of_interest:[
                { validator: checklength6, trigger:'change'},
                { validator: checklength6, trigger:'blur'}
              ]
          }
      }
    },
       
        methods: {
           
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
                    case 400:
                        msg('权限问题', '用户未登录，请重新登录');
                        break;
                    case 401:
                        msg('权限问题', '用户无权访问，请联系管理员');
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
   
    handleModify:function(key,keyPath){
      this.handleModify=key;
      console.log(this.handleModify);
    },        
        checkAllow:function(){
            var vm=this;
            return vm.check1;
        },
    submitForm() {
        console.log(this.selfInfo.stitle);
        
        var vm=this;
        const h = this.$createElement;
        this.$msgbox({
          title: '消息',
          message: h('p', null, [
            h('span', null, '是否确定要'),
            h('i', { style: 'color: teal' }, '修改')
          ]),
          showCancelButton: true,
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          beforeClose: (action, instance, done) => {
            if (action === 'confirm') {
              console.log("?");
              $.ajax({
                type:'post',
                url:'/student/setInfo',
                dataType:'json',
                // async:false,
                data:{
                  "id":this.selfInfo.student_id,
                  "nationality":this.selfInfo.snationality,
                  "nativePlace":this.selfInfo.snative_place,
                  "politicalStatus":this.selfInfo.spolitics_status,
                  "sex":this.selfInfo.ssex,
                  "areaInterest":this.selfInfo.sarea_of_interest,
                  "title":this.selfInfo.stitle
                },
                success:function(response){
                    
                    if(response.data===1){
                       vm.$message({
                            type: 'success',
                            message: '修改成功!'
                       })
                    }else{
                       vm.$message({
                            type: 'info',
                            message: '网络错误!'
                       })
                    }
                },
                error:function(err){
                    console.log(err)
                }
            })
            done();
            } else {
              console.log("11111111111111111");
               vm.$message({
                        type: 'info',
                        message: '已取消修改'
                      });    
              done();
            }
          }
        })        
        
    



          }
    }
}
</script>
<style scoped>
.clear{
  clear: both;
}
.el-main{
    margin-top:3px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;
    height:800px;
}
#infoform{
    padding-top: 60px;
}
#form1{
    width:80%;
    margin:0px auto;
}
#form2{
    width:200px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>
