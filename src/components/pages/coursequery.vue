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
           <div id="table">
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
     
     <div id="context">
       <div class="operation">
            <el-button type="success" @click="back()" id="back-button">返回</el-button>
          
        </div>
        <div class="content">
            <p>调过来了</p>
            <p>{{this.select}}</p>

        </div>
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
  data(){
      return{
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
          courses:[
                {cID:'123',cname:'数据结构',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'软件学院',teacher:'ABC',classroom:'A1-101'},
                {cID:'124',cname:'C++基础教程',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'软件学院',teacher:'CBC',classroom:'A2-101'},
                {cID:'125',cname:'工科数学分析',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'数学学院',teacher:'AEC',classroom:'A3-101'},
                {cID:'113',cname:'java',ctype:'选修课',clscore:'2',cltime:'64.0',cbelongto:'软件学院',teacher:'AAC',classroom:'A4-101'},
                {cID:'126',cname:'线性代数',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'数学学院',teacher:'BBC',classroom:'A1-201'},
                {cID:'131',cname:'操作系统',ctype:'必修课',clscore:'2',cltime:'64.0',cbelongto:'软件学院',teacher:'AAZ',classroom:'A1-301'},
                
                
          ]
      }
  },
  methods:{
      cIDSearch(keywords){
         for(var i=0;i<this.courses.length;i++){       
        if(this.courses[i].cID==keywords)
            this.showCourses.push(this.courses[i]);
            }
      },
      cNameSearch(keywords){
        for(var i=0;i<this.courses.length;i++){       
        if(this. courses[i].cname==keywords)
            this.showCourses.push(this.courses[i]);
            }
      },
      cCollegeSearch(keywords){
        for(var i=0;i<this.courses.length;i++){       
        if(this. courses[i].cbelongto==keywords)
            this.showCourses.push(this.courses[i]);
            }
      },
      cTeachSearch(keywords){
          for(var i=0;i<this.courses.length;i++){       
        if(this. courses[i].teacher==keywords)
            this.showCourses.push(this.courses[i]);
            }
      },
      cTypeSearch(keywords){
        for(var i=0;i<this.courses.length;i++){       
        if(this. courses[i].ctype==keywords)
            this.showCourses.push(this.courses[i]);
            }
      },
      searchCoures(){
          console.log(this.keyWords,this.ways);
          if(this.ways!=''&&this.keyWords!=''){
          this.showCourses.length=0;
            switch(this.ways){
                case "1":this.cIDSearch(this.keyWords);break;
                case "2":this.cNameSearch(this.keyWords);break;
                case "3":this.cCollegeSearch(this.keyWords);break;
                case "4":this.cTeachSearch(this.keyWords);break;
                case "5":this.cTypeSearch(this.keyWords);break;
                default: this.showCourses=[];             
            }
            if(this.showCourses!=[])
                 $("#table").show();
            }
            else if(this.ways==''){
                console.log("error1") ;
                this.$message({
                    type:"info",
                    message:"请选择搜索方式"
                });
            }else{
                 console.log("error2") ;
                this.$message({
                    type:"info",
                    message:"请填写搜索关键字"
                });
            }

      },
      handleRowHandle(row){
          console.log(row);
          this.select=row;
          $("#table").hide();
          $("#context").show();

      },
      back(){
      $("#context").hide();
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
#context{
  display: none;
  width: 100%;
  height:8  800px;
  margin:0px auto;
  margin-top:10px;
  padding:10px;
} 
</style>
