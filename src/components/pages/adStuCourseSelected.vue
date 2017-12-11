
<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="selectBoard">
            <div class="firstBar">
            学院 <el-select v-model="academySelected" class="selectBar" clearable placeholder="请选择学院">
                     <el-option label="机械与汽车工程学院" value="jxyqcgc"></el-option>
                         <el-option label="建筑学院" value="jz"></el-option>
                         <el-option label="土木与交通学院" value="tmyjt"></el-option>
                         <el-option label="电子与信息学院" value="dzyxx"></el-option>
                         <el-option label="材料科学与工程学院" value="clkxygc"></el-option>
                         <el-option label="化学与化工学院" value="hxyhg"></el-option>
                         <el-option label="轻工科学与工程学院" value="qgkxygc"></el-option>
                         <el-option label="食品科学与工程学院" value="spkxygc"></el-option>
                         <el-option label="数学学院" value="sx"></el-option>
                         <el-option label="物理与光电学院" value="wlygd"></el-option>
                         <el-option label="经济与贸易学院" value="jjymy"></el-option>
                         <el-option label="建筑自动化科学与工程学院" value="jzzdhkxygc"></el-option>
                         <el-option label="计算机科学与工程学院" value="jsjkxygc"></el-option>
                         <el-option label="电力学院" value="dl"></el-option>
                         <el-option label="生物科学与工程学院" value="swkxygc"></el-option>
                         <el-option label="环境与能源学院" value="hjyny"></el-option>
                         <el-option label="软件学院学院" value="rj"></el-option>
                         <el-option label="工商管理学院" value="gsgl"></el-option>
                         <el-option label="公共管理学院" value="gggl"></el-option>
                         <el-option label="马克思主义学院" value="mkszy"></el-option>
                         <el-option label="外国语学院" value="wgy"></el-option>
                         <el-option label="法学院" value="f"></el-option>
                         <el-option label="新闻与传播学院" value="xwycb"></el-option>
                         <el-option label="艺术学院" value="ys"></el-option>
                         <el-option label="体育学院" value="ty"></el-option>
                         <el-option label="设计学院" value="sj"></el-option>
                         <el-option label="医学院" value="y"></el-option>
                         <el-option label="国际教育学院" value="gjjy"></el-option>
                </el-select>
            年级 <el-select v-model="gradeSelected" class="selectBar" clearable placeholder="请选择年级">
                         <el-option label="大一" value="freshman"></el-option>
                         <el-option label="大二" value="sophomore"></el-option>
                         <el-option label="大三" value="junior"></el-option>
                         <el-option label="大四" value="senior"></el-option>
                    </el-option>
                </el-select>
            选择学期 <el-select v-model="semesterSelected" class="selectBar" clearable placeholder="请选择学期">
                    <el-option label="第一学期" value="firstSemester"></el-option>
                    <el-option label="第二学期" value="secondSemester"></el-option>
                    </el-option>
                  </el-select>
            选择课程性质 <el-select v-model="natureOfCourseSelected" class="selectBar" clearable placeholder="请选择课程性质">
                    <el-option label="必修课" value="required"></el-option>
                    <el-option label="选修课" value="optional"></el-option>
                    </el-option>
                </el-select>
            <el-button type="primary" @click="searchScore" id="query">查询</el-button>
            </div>
            <div class="clear"></div>
          
        </div>
              <div class="tableBar">
                 <div id="table">
                    <el-table
                :data="tableData"
                id="stuTable"
                border
                :default-sort = "{prop: 'Id',order: 'descending'}"
                >
                <el-table-column  
                  prop="name"
                  label="姓名"
                  min-width="10%"
                  sortable
                 >
                </el-table-column>
                <el-table-column
                  prop="Id"
                  label="学号"
                min-width="20%"
                 sortable>
                </el-table-column>
                <el-table-column
                  prop="academy"
                  label="学院"
                min-width="20%"
                sortable>
                </el-table-column>
                </el-table-column>
                <el-table-column
                  prop="class"
                  label="班级"
                min-width="20%"
                sortable>
                </el-table-column>
                <el-table-column
                  prop="dropOut"
                  label="是否退课"
                min-width="20%">
                <template slot-scope="scope">
                <el-button @click="dropOut(scope.row)" type="text" size="medium">退课</el-button>
                </template>
                </el-table-column>
              </el-table>
              <el-button @click="select()" type="primary" size="medium">筛选</el-button>
              <el-button @click="exit()" size="medium">返回</el-button>
                </div>
             </div>

        </div>
        
    </div>
</template>
<script>
import vHead from '../commons/AdminstratorNav.vue';
export default {
  components:{
      vHead,
  },
  data(){
      return{
          academySelected:'',
          gradeSelected:'',
          semesterSelected:'',
          natureOfCourseSelected:'',
          tableData:[{
             name:"林梓龙",
             Id:"201530612330",
             academy:"软件学院",
             class:"软件工程2班"
          },
          {
             name:"刘亦菲",
             Id:"201632032130",
             academy:"软件学院",
             class:"软件工程1班"
          },
           {
             name:"刘亦菲",
             Id:"201632032130",
             academy:"软件学院",
             class:"软件工程1班"
          }
          ]
      }
  },
  methods:{
    dropOut(row){

    },
    select(){
        
    },
    exit(){
        this.$router.push({path: '/adminstrator/stuCourseManagement'})
    }
  }
}
</script>
<style scoped>
#info{
    width:96%;
    margin:0px auto;
    padding-top:10px;
}
#infoTable{
    border-color:#eefff6;
   
}
#query{

    width:100px;
}
.selectBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    height:50px;
}
.firstBar{
   
    margin-left:5px;
}
.firstBar .selectBar{
    margin:5px 20px 5px 0px;
    
}
.scoreBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
    height:800px;
}
.lbl{
    font-family: "微软雅黑";
    color:#CDC1C5;
}
#table{
     margin:0px auto;
    margin-top:20px;
    width:95%;
}
</style>
