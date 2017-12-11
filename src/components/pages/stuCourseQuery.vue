<template>
  <div class="wrapper">
      <v-head></v-head>
     <div class="clear"></div>
     <div id="selectBoard">
         搜索方式&nbsp;&nbsp;<el-select v-model="ways" class="selectBar" clearable placeholder="请选择搜索方式">
                    <el-option v-for="item in searchWay" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
        <br>
        <el-input v-model="keyWords" placeholder="请输入关键字" id="keyWords"></el-input>
        <el-button type="primary" @click="searchCoures" id="search">搜索</el-button>
		</div>
      <div id="showCourse">
           <div id="table" ref="table">
            <el-table
                    :data="showCourses"
                    id="classTable"
                    @row-click='handleRowHandle'
                    border>
                    <el-table-column
                    prop="cID"
                    label="课程编号"
                     sortable
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="cname"
                    label="课程名"
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="ctype"
                    label="课程性质"
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="clscore"
                    label="课程学分"
                     sortable
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="cltime"
                    label="课程学时"
                     sortable
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="cbelongto"
                    label="所属学院"
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="teacher"
                    label="授课老师"
                    min-width="20%">
                    </el-table-column>  
                    <el-table-column
                    prop="classroom"
                    label="课室"
                    min-width="20%">
                    </el-table-column>  
                
                </el-table>
      </div>
     
     <!-- <div id="content" ref="content">
       <div class="operation">
            <el-button type="success" @click="back()" id="back-button">返回</el-button>
          
        </div> -->

    <el-dialog title="课程详情" :visible.sync="dialogFormVisible">
        <el-form v-model="showCourses">
            <el-form-item >
                课程编号:&nbsp;{{this.courses.cID}}<br>
                课程名:&nbsp;{{this.courses.cname}} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程讲师:&nbsp;{{this.courses.teacher}} <br>
                开课学院:&nbsp;{{this.courses.cbelongto}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;&nbsp;课程学分:&nbsp;{{this.courses.clscore}}<br>
                课程性质:&nbsp;{{this.courses.ctype}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程学时:&nbsp;{{this.courses.cltime}}<br>
                教室:&nbsp;{{this.courses.classroom}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上课时段:&nbsp;{{this.courses.weeks}}<br>
                课程容量&nbsp;;{{this.courses.quantity}}<br>
                课程介绍:
               
            </el-form-item>
        
        </el-form>
         <el-button @click="success">确定</el-button>
    </el-dialog>
      
    </div>
        
    </div>
  </div>
</template>
<script>
import vHead from '../commons/StudentNav.vue'
export default {
  components:{
      vHead,
  },
    created(){
        this.stu_id=localStorage.getItem("stuId");
    },

  data(){
      return{
          	dialogFormVisible: false,
          stu_id:'',
          ways:'',
          keyWords:'',
          select:'',
          showCourses:[],
          searchWay:[
              {label:'按ID搜索',value:'1'},
              {label:'按课程名搜索',value:'2'},
              {label:'按学院搜索',value:'3'},
              {label:'按教师搜索',value:'4'},
              {label:'按课程性质搜索',value:'5'},
          ],
          courses:{
              cID:'',cname:'',teacher:'',ctype:'',clscore:'',cltime:'',cbelongto:'',weeks:'',classroom:''

          }
        
      }
  },
  methods:{

      searchCoures(){
          console.log(this.keyWords,this.ways);
         
            if(this.ways==''){
                console.log("error1") ;
                this.$message({
                    type:"info",
                    message:"请选择搜索方式"
                });
            }else if(this.keyWords==''){
                 console.log("error2") ;
                this.$message({
                    type:"info",
                    message:"请填写搜索关键字"
                });
            }else{
                this.showCourses=[];
                var vm=this;
                console.log(this.ways,this.keyWords);
                // this.keyWords=this.courseType(this.keyWords);
                $.ajax({
                    type:'post',
                    url:'/student/coursequery',
                    dataType:'json',
                    data:{
                        "id":this.stu_id,
                        "searchWay":this.ways,
                        "searchKeyWords":this.keyWords
                    },
                    success:function(response){
                        console.log("-->",response);
                        if(vm.ways=='1' && response.string=="error IDs"){
                            vm.$message({
                                type:'info',
                                message:response.string
                            })
                        }else{
                                
                            vm.analysisData(vm,response.string);
                            vm.$refs.table.style.display="block";
                        }
                    },
                    error:function(err){
                        console.log("error");
                        console.log(err);
                        vm.$message({
                            type:'info',
                            message:'网络出错'
                        })
                    }
                })
            }
      },
      analysisData(vm,coursesList){
          var arraya=coursesList.split(';');
          console.log(arraya.length);
          for(var i=0;i<arraya.length;i++){
             var ele=arraya[i].split(',');
             var dist=new Array();
            for(var j=0;j<ele.length;j++){
                var eleItem=ele[j].split(':')
                console.log(eleItem[0],'->',eleItem[1])
                dist[eleItem[0]]=eleItem[1]
            }
            vm.showCourses.push(dist);
        }
        console.log(vm.showCourses)
      },

      handleRowHandle(row){
          console.log(row.cID);
          for(var i=0;i<this.showCourses.length;i++){
              if(row.cID==this.showCourses[i].cID){
                  this.courses=this.showCourses[i]

              }
          }
          
          this.dialogFormVisible = true ;
          
      },
    sure(){
        this.dialogFormVisible = false;
            
    },

      back(){
     
      $("#table").show();

      }
  

  }  

}
</script>
<style scoped>
.clear{
    clear: both;
}
#selectBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    display: block;    
}
.selectBar{
    width:20%;
    padding-top:10px;
}
#showCourse{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    display: block;    
}
#table{
    width:94%;
    margin: 0px auto;
    padding:10px;
    display:none;
}
#keyWords{
    width:21%;
    
    margin:0px auto;
    margin-top:10px;
    padding-bottom: 10px;
}

</style>
