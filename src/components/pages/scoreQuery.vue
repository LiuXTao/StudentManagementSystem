<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="selectBoard">
            <div class="firstBar">
            学期 <el-select v-model="value4" class="selectBar" clearable placeholder="请选择学年">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            学期 <el-select v-model="value5" class="selectBar" clearable placeholder="请选择学期">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                </el-select>
            课程性质 <el-select v-model="value6" class="selectBar" clearable placeholder="请选择课程性质">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value">
                    </el-option>
                  </el-select>
            <el-button type="primary" @click="searchScore" id="query">查询</el-button>
            </div>
            <div class="clear"></div>
          
        </div>
        <div class="scoreBoard">
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
                <div class="tableBar">
        <div id="table">
          <el-table
                :data="tableData3"
                id="classTable"
                border>
                <el-table-column
                  
                  prop="date"
                  label="节数\日期"
                  min-width="10%">
                </el-table-column>
                <el-table-column
                  prop="monday"
                  label="星期一"
                min-width="20%">
                </el-table-column>
                <el-table-column
                  prop="tuesday"
                  label="星期二"
                  min-width="20%">
                </el-table-column>
                <el-table-column
                  prop="wednesday"
                  label="星期三"
                  min-width="20%">
                </el-table-column>
                <el-table-column
                  prop="thursday"
                  label="星期四"
                  min-width="20%">
                </el-table-column>
                <el-table-column
                  prop="friday"
                  label="星期五"
                  min-width="20%">
                </el-table-column>
              </el-table>

        </div>
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
          selfInfo:{
              title:'>>>>>',
              Id:'XXXXXX',
              name:'XXX',
              colleage:'xxxx',
              major:'XXXX',
              class:'XXXX'
          }
      }
  },
  methods:{
      searchScore:function(){

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
    height:50px;
}
.firstBar{
   
    margin-left:5px;
}
.firstBar .selectBar{
    margin:5px 20px 5px 0px;
    
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
