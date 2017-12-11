<template>
    <div>
        <v-head></v-head>
        <div class="clear"></div>
        <div class="selectBar">
          <div id="selectForm">
              <el-form  id="select">
              <div >
              <el-form-item label="课程性质:" class="labels">
              <el-select v-model="y_value" placeholder="请选择" class="sel1">
                    <el-option  v-for="item in leixing"  :key="item.value":label="item.label"  :value="item.value">   </el-option>
                </el-select>
              </el-form-item>
              </div>
              <div>
              <el-form-item label="有无余量:" class="labels">
              <el-select v-model="m_value" placeholder="请选择" class="sel2">
                    <el-option  v-for="item in youwu"  :key="item.value"  :label="item.label"  :value="item.value"> </el-option>
                </el-select>
              </el-form-item>
              <el-button type="primary" @click="search" id="search">查询</el-button>
              </div>
              <div class="clear"> </div>
            </el-form>
          </div>
        </div>
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
				</el-table-column>
                <el-table-column
                  prop="tname"
                  label="开课教师"
                 >
                </el-table-column>
				</el-table-column>
                <el-table-column
                  prop="num"
                  label="课程余量"
                 >
                </el-table-column>
				 <el-table-column
                  label="选否">
		      <template slot-scope="scope">
			   <el-checkbox v-model="scope.row.checked">选择</el-checkbox>
               </template>
                </el-table-column>
				
              </el-table>
        
        </div>
	    <br/>
		<el-button type="primary" @click="submit()">提交</el-button>
      </div>
    </div>
</template>

<script>
import vHead from '../commons/StudentNav.vue';

export default {
      data() {
      return {
        y_value: '',
        m_value:'',
        leixing:[
           {label:"必修课",value:"必修课"},
           {label:"通选课",value:"通选课"}
        ],
        youwu:[
          {label:"有",value:"有"},
          {label:"无",value:"无"}
        ],

        tableData3: [{
          courseid: '123',
          coursename: '数据挖掘',
          courseclass: '选修课',
          adress: 'A1101',
          time: '4-18周',
          xueyuan: '软件学院',
		  tname:'XX',
		  num:'90',
		  checked:true
        }
         ]
      }
    },
    methods:{
      search(){
        console.log(this.y_value);
        console.log(this.m_value);
      }
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
#search{
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