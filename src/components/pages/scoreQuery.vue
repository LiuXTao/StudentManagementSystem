<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="selectBoard">
            <div class="firstBar">
            学年 <el-select v-model="yearSelected" class="selectBar" clearable placeholder="请选择学年">
                    <el-option v-for="item in years" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            学期 <el-select v-model="monthSelected" class="selectBar" clearable placeholder="请选择学期">
                    <el-option v-for="item in months" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            课程性质 <el-select v-model="typeSelected" class="selectBar" clearable placeholder="请选择课程性质">
                    <el-option v-for="item in courseTypes" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                  </el-select>
            <el-button type="primary" @click="searchScore" id="query">查询</el-button>
            </div>
            <div class="clear"></div>
          
        </div>
        <div class="infoBoard">
            <div id="info">
                <table  id="infoTable" border="1" cellSpacing="0" cellPadding="3" width="100%" :selfInfo="this.selfInfo">
							<tr>
								<td height="20" colSpan="4" align="center">
                                    <span class="lbl"><b><font size="4"></font></b> {{selfInfo.title}}</span></td>
							</tr>
							<tr>
								<td height="5"><span class="lbl">学号：{{selfInfo.Id}}</span></td>
								<td height="5"><span class="lbl">姓名：{{selfInfo.name}}</span></td>
								<td height="5" colSpan="2"><span class="lbl">学院：{{selfInfo.colleage}}</span></td>
							</tr>
							<tr>
								<td id="tdzymc" colSpan="2"><span class="lbl">专业：</span>
									<span class="lbl">{{selfInfo.major}}</span></td>
								<td id="tdzyfx"><span class="lbl">专业方向:无方向</span></td>
								<td><span class="lbl">行政班：{{selfInfo.class}}</span></td>
							</tr>
							<tr>
								<td colspan="4"></td>
							</tr>
						</table>

            </div>
        </div>
        <div class="scoreBoard">
            <div id="table">
            <el-table
                    :data="scoreSelected"
                    id="classTable"
                    border>
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
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="cltime"
                    label="课程学时"
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="cbelongto"
                    label="所属学院"
                    min-width="20%">
                    </el-table-column>
                    <el-table-column
                    prop="score"
                    label="成绩"
                    min-width="20%">
                    </el-table-column>  
                    <el-table-column
                    prop="point"
                    label="绩点"
                    min-width="20%">
                    </el-table-column>  
                    <el-table-column
                    prop="ranking"
                    label="排名"
                    min-width="20%">
                    </el-table-column>
                </el-table>

            </div>
        </div>
        
    </div>
</template>
<script>
import vHead from '../commons/StudentNav.vue';
export default {
  components:{
      vHead,
  },
  data(){
      return{
          yearSelected:'',
          monthSelected:'',
          typeSelected:'',
          selfInfo:{
              title:'',
              Id:'XXXXXX',
              name:'XXX',
              colleage:'xxxx',
              major:'XXXX',
              class:'XXXX'
          },
          years:[ {label:'2012-2013',value:'2012-2013'},
           {label:'2013-2014',value:'2013-2014'},
           {label:'2014-2015',value:'2014-2015'},
           {label:'2015-2016',value:'2015-2016'},
           {label:'2016-2017',value:'2016-2017'},
           {label:'2017-2018',value:'2017-2018'}
          ],
          months:[
          {label:1,value:1},
          {label:2,value:2}
        ],
        courseTypes:[
            {label:'必修课',value:'必修课'},
            {label:'选修课',value:'选修课'},
            {label:'通选课',value:'通选课'}
        ],
        sampleScore:{
            years:'2015-2016',
            months:'1',
            scores:[
                {cname:'数据结构',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'软件学院',score:'88',point:'3.7',ranking:'14'},
                {cname:'C++基础教程',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'软件学院',score:'98',point:'4.0',ranking:'4'},
                {cname:'工科数学分析',ctype:'必修课',clscore:'4',cltime:'64.0',cbelongto:'数学学院',score:'97',point:'4.0',ranking:'6'},
                 {cname:'java',ctype:'选修课',clscore:'2',cltime:'64.0',cbelongto:'软件学院',score:'97',point:'4.0',ranking:'6'},
                
            ]

        },
        scoreSelected:[]
     }
  },
  methods:{
      searchScore:function(){
          console.log(this.yearSelected,this.monthSelected,this.typeSelected);
          var title=this.yearSelected+' 年第 '+this.monthSelected+' 学期成绩';
          this.selfInfo.title=title;
          //按照检索条件发送搜索要求
           console.log(this.sampleScore.years)
           this.scoreSelected.length=0;
          if(this.sampleScore.years==this.yearSelected&&this.sampleScore.months==this.monthSelected){
              console.log(this.yearSelected);
              for(var i=0;i<this.sampleScore.scores.length;i++){
                  
                  if(this.typeSelected!=''&&this.sampleScore.scores[i].ctype!=(this.typeSelected))
                    continue;
                    this.scoreSelected.push(this.sampleScore.scores[i]);
              }
              $("#table").show();
          }else{
              console.log("没匹配中");
          }
          

      }

  }
}
</script>
<style scoped>
.clear{
    clear:both;
}
.selectBoard{
    margin-top: 10px;
    background-color: #eef1f6;
    width:100%;
  
}
.firstBar{
   
    margin-left:5px;
}
.firstBar .selectBar{
    margin:5px 20px 5px 0px;
    padding:10px;
}
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
.infoBoard{
    margin-top: 8px;
    background-color: #eef1f6;
    width:100%;
    padding-bottom: 8px;
}
.scoreBoard{
    margin-top: 8px;
    background-color: #eef1f6;
    width:100%;
    
}
.lbl{
    font-family: "微软雅黑";
    color:#CDC1C5;
}
#table{
    margin:0px auto;
    width:95%;display: none;
    padding:10px;
}

</style>
