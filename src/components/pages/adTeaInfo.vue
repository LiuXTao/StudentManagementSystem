
<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="selectBoard">
            <div class="firstBar">
            学院 <el-select v-model="academy" class="selectBar" clearable placeholder="请选择学院">
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
                    </el-option>
                </el-select>
            专业方向 <el-select v-model="inClass" class="selectBar" clearable placeholder="请选择专业方向">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
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
                id="teaTable"
                border
                :default-sort = "{prop: 'Id',order: 'descending'}"
                >

                <el-table-column  
                  prop="Id"
                  label="ID"
                  min-width="10%"
                  sortable>
                </el-table-column>   
                <el-table-column
                  prop="name"
                  label="姓名"
                  min-width="20%"
                  sortable>
                </el-table-column>
                <el-table-column
                  prop="academy"
                  label="学院"
                min-width="20%"
                sortable>
                </el-table-column>
                <el-table-column
                  prop="major"
                  label="专业方向"
                  min-width="20%"
                  sortable>
                </el-table-column>
                <el-table-column
                  label="操作"
                   width="100">
                <template slot-scope="scope">
                <el-button @click="viewInfo(scope.row)" type="text" size="small">查看</el-button>
                <el-button @click="modifyInfo(scope.row)" type="text" size="small">修改</el-button>
                <el-button @click="deleteInfo(scope.row)" type="text" size="small">删除</el-button>
                </template>
                </el-table-column>
              </el-table>
			  <br/>
              <el-button type="primary" @click="add()">添加</el-button>
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
          academy:'',
          tableData:[{
             Id:'201530612330',
             name:'林梓龙',
             academy:'软件学院',
             major:'软件工程'
          },
          {
              Id:'201632132130',
             name:'刘亦菲',
             academy:'软件学院',
             major:'软件工程'
          }
          ]
      }
  },
  methods:{
    viewInfo(row){
        this.$router.push({path: '/adminstrator/teacherInfo/'+row.Id})
    },    
    modifyInfo(row){
        this.$router.push({path: '/adminstrator/teacherInfoModify/'+row.Id})
    },
     deleteInfo(row){
         
    },
    add(){
        this.$router.push({path: '/adminstrator/teacherInfoAdd/'})
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
