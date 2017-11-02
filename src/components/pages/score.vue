<template>
<div>
<v-head></v-head>
    <el-table
      :data="newsList" border
      style="width: 100%" @row-click="newsClick" >
	  
      <el-table-column
        prop="coursename"
        label="课程名字"
        width="300" >
      </el-table-column>
      <el-table-column
        prop="teachclass"
        label="教学班"
        width="300">
      </el-table-column>
      <el-table-column
        prop="studentnumber"
        label="学生人数">
      </el-table-column>
	   <el-table-column
        label="是否修改"
        width="300" >
		  <template slot-scope="scope">
          <div slot="reference">
          <el-button type="primary" @row-click="newsClick(scope.row)">录入成绩</el-button>
          </div>
      </template>
      </el-table-column>
    </el-table>
	</div>
  </template>

  <script>
  import vHead from '../commons/TeacherNav.vue';
    export default {
	 components:{
        vHead,
    },
      data: function(){
        return {
          newsList: [{
		  id:1,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:2,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:3,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }, {
		  id:4,
            coursename: '数据挖掘',
            teachclass: '1',
            studentnumber: '50'
          }]
		  
        }
      },
	   methods:{
	   ceshi()
	   {
	   alert("error")
	   },
	   newsClick(m){
                var self=this;
                console.log("11111111");
                //console.log(coursename);
                self.$router.push('/changescore?'+m.id);
            },
            getNews(str){
                var self = this;
                //self.newsList=[];
               /* self.$axios({
                    url:'/student/score/'+str,
                    method:'get',
                    baseURL:self.hostURL
                }).then((response)=>{
                    self.newsList = [];
                    self.newsList = response.data;
                }).catch((error)=>{
                    self.$message({
                        type:'info',
                        message:'connect fail'
                    });
                });*/
            },

        },
		  
        mounted(){
            var self = this;
            //self.getNews(self.pageNum);
        }
	 
	   
    }
  </script>
  <style scoped>
  a {
    text-decoration: none;
}
a:hover, a:visited {
    text-decoration: none;
}
  </style>