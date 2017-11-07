<template>
    <div>
        <v-head></v-head>
        <div class="clear"></div>
        
        <div class="tableBar">
        <div id="table">
          <el-table
                :data="tableData3"
                id="classTable"
                border>
                <el-table-column
                  
                  prop="courseid"
                  label="课程编号"
                  >
                </el-table-column>
                <el-table-column
                  prop="coursename"
                  label="课程名字"
               >
                </el-table-column>
                <el-table-column
                  prop="courseclass"
                  label="课程性质"
                  >
                </el-table-column>
                <el-table-column
                  prop="adress"
                  label="上课地点"
                 >
                </el-table-column>
                <el-table-column
                  prop="time"
                  label="上课时间"
                  >
                </el-table-column>
                <el-table-column
                  prop="xueyuan"
                  label="开课学院"
                 >
                </el-table-column>
				
				
              </el-table>
        
        </div>
	   
      </div>
    </div>
</template>

<script>
import vHead from '../commons/StudentNav.vue';

export default {
      data() {
      return {
	   hostUrl:"/",
        tableData3: [{
          courseid: '123',
          coursename: '数据挖掘',
          courseclass: '选修课',
          adress: 'A1101',
          time: '4-18周',
          xueyuan: '软件学院',
		  checked:true
        }
         ]
      }
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
			
			    getNews(){//从后台获取数据
                var self = this;
                self.tableData3=[];
                self.$http({
                    url:'/selectedclass',
                    method:'get',
                    baseURL:self.hostURL
                }).then((response)=>{
                    self.tableData3 = [];
                    self.tableData3 = response.data;
                }).catch((error)=>{
                    self.$message({
                        type:'info',
                        message:'connect fail'
                    });
                });
            },
     
    },
	 mounted(){
            var self = this;
            self.getNews();
        },

    components:{
        vHead,
    }
}

</script>
 <style scoped>
 .clear{
     clear:both;
 }
.selectBar{
    margin-top:6px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;
    height:80px;
}
.tableBar{
    margin-top:5px;
    padding-top:6px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;
    height:500px;
}
#selectForm{

    padding-top: 1px;

}
#select{
    width:40%;
    margin:0px auto;
}
.labels{
    float:left;
    width:40%;
    display: inline;
}
#submit{
  margin-top:36px;
  margin-left:10px;
  float:left;
}
#table{
  width:90%;
  text-align:left;
  margin:0px auto;
}
#classTable{
  width:100%;
}
/* #classTable td{
  color:blue;
  height:55px;
} */

</style>