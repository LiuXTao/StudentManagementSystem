<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
 <div class="el-main">
     <div id="infoform">
    <el-form id="form1" ref="form1" :inline="true" :model="form1" :rules="rule1" label-width="100px" >
     <el-form-item label="账号：">
        <el-input v-model="form1.professor_id" :disabled="true" style="width:220px" id="id"></el-input>
     </el-form-item>
    <el-form-item label="姓名：">
        <el-input v-model="form1.pname" :disabled="true" style="width:220px" id="name"></el-input>
     </el-form-item>
    <el-form-item label="性别：">
       <el-select v-model="form1.psex"   placeholder="请选择性别" style="width:220px">
      <el-option label=" " value="null"></el-option>
      <el-option label="男" value="male"></el-option>
      <el-option label="女" value="female"></el-option>
    </el-select>
     </el-form-item>
    <el-form-item label="学院：">
        <el-input v-model="form1.pdepartment"  :disabled="true" style="width:220px" id="depart"></el-input>
     </el-form-item>
    <el-form-item label="教龄：" prop="pteaching_age">
        <el-input v-model="form1.pteaching_age" type="number"  max=999 style="width:220px" id="tage"></el-input>
     </el-form-item>
    <el-form-item label="职务：" >
       <el-select v-model="form1.ptitle"  placeholder="请选择职务" style="width:220px" id="title">
      <el-option label="  " value="null"></el-option>
      <el-option label="助教" value="assistant"></el-option>
      <el-option label="讲师" value="lecturer"></el-option>
       <el-option label="副教授" value="adjpro"></el-option>
        <el-option label="教授" value="professor"></el-option>
        </el-select>
    </el-form-item>
     <el-form-item label="教育背景：" prop="peducation_background">
        <el-input v-model="form1.peducation_background" id="tbackground" auto-complete="off" style="width:220px" type="text" ></el-input>
     </el-form-item>
    <el-form-item label="出生日期：" >
        <el-date-picker v-model="form1.pbirthday" id="birday" type="date" style="width:220px" placeholder="选择日期" :picker-options="pickerOptions"></el-date-picker>
     </el-form-item>
    <el-form-item label="民族：" prop="pnationality">
        <el-input v-model="form1.pnationality" id="nation"style="width:220px"  type="text"></el-input>
     </el-form-item>
    <el-form-item label="政治面貌：" prop="ppolitics_status">
        <el-input v-model="form1.ppolitics_status"  id="politics" type="text" style="width:220px" ></el-input>
     </el-form-item>
    <el-form-item label="方向：" prop="parea_of_interest">
        <el-input v-model="form1.parea_of_interest" id="interest" type="text" style="width:220px" ></el-input>
     </el-form-item>
	 
    <el-form-item label="联系方式：" prop="pcontact">
        <el-input v-model="form1.pcontact" id="contact" type="text" style="width:220px" ></el-input>
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
  import vHead from '../commons/TeacherNav';
  export default {
    components:{
              vHead
          },

created() {
        if(localStorage){
            this.tea_id= localStorage.getItem("teaId");
            console.log("-------------------",this.tea_id);
        }else{
            alert('This browser does not supports localStorage');
        }

        this.form1.professor_id=this.tea_id
        var self=this;
        $.ajax({
            type:'post',
            url:'/teacher/fileInfo',
            dataType:'json',
            data:{
                "id":this.form1.professor_id
            },
            success:function(response){
                console.log("过来了");
                localStorage.setItem("p_name",response.name);
                localStorage.setItem("pdepartment",response.depName);
                localStorage.setItem("pteaching_age",response.teachingAge);
                localStorage.setItem("peducation_background",response.educationBackground);
                localStorage.setItem("pnationality",response.nationality);
                localStorage.setItem("ppolitics_status",response.politicalStatus);
                localStorage.setItem("parea_of_interest",response.areaInterest);
                
                self.form1.pteaching_age=response.teachingAge;
                self.form1.pname=response.name;
                self.form1.pdepartment=response.depName;
                self.form1.peducation_background=response.educationBackground;
                self.form1.pnationality=response.nationality;
                self.form1.ppolitics_status=response.politicalStatus;
                self.form1.parea_of_interest=response.areaInterest; 
                console.log(self.form1);
               
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
            if( value.length > 3){
              return callback(new Error('长度不可超于3位'));
           }
        };
          var checklength2 = (rule,value,callback) => {
            var vm = this.$data;
            if( value.length > 20){
              return callback(new Error('长度不可超于20个字符'));
           }
        };
          var checklength3 = (rule,value,callback) => {
            var vm = this.$data;
            if( value.length > 10){
              return callback(new Error('长度不可超于10个字符'));
           }
        };
          var checklength5 = (rule,value,callback) => {
            var vm = this.$data;
            console.log(typeof value);
            if( value.length > 10){
              return callback(new Error('长度不可超于10个字符'));
           }
        };
          var checklength6 = (rule,value,callback) => {
            var vm = this.$data;
            if( value.length > 10){
              return callback(new Error('长度不可超于10个字符'));
           }
        };
      return {
          hostUrl:'/teacher',
          tea_id:'',
          pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          }
        },
          form1:{
              professor_id: '123456543248',
              pname: 'xxx',
              pdepartment:'SAFDFAas',
              pteaching_age:'',
              peducation_background:'',
              pbirthday: '',
              pnationality: '',
              pcontact_information: '',
              ppolitics_status: '',
              parea_of_interest: '',
              psex:'',
              ptitle:'',
			  pcontact:''
          },
          rule1:{
              pteaching_age:[
                { validator: checklength1, trigger:'change'},
                { validator: checklength1, trigger:'blur'}
            ],
              peducation_background:[
                { validator: checklength2, trigger:'change'},
                { validator: checklength2, trigger:'blur'}
            ],
              pnationality:[
                { validator: checklength3, trigger:'change'},
                { validator: checklength3, trigger:'blur'}
            ],
              ppolitics_status:[
                { validator: checklength5, trigger:'change'},
                { validator: checklength5, trigger:'blur'}
            ],
              parea_of_interest:[
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
    submitForm() {
       console.log("11");
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
                url:'/teacher/setInfo',
                dataType:'json',
                // async:false,
                data:{
                  "id":this.form1.professor_id,
                  "teachingAge":this.form1.pteaching_age,
                  "nationality":this.form1.pnationality,
                  "educationBackground":this.form1.peducation_background,
                  "politicalStatus":this.form1.ppolitics_status,
                  "areaInterest":this.form1.parea_of_interest
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
    margin:0px auto;
}
#infoform{
    padding-top: 60px;
}
#form1{
    width:80%;
    margin:0px auto;
}
#form2{
    width:70px;
    margin:0px auto;
    float: center;
}
  .el-form-item{
      float:left;
  }
</style>
