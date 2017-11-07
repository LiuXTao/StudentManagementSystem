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
				 <el-table-column
                  label="退课">
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
      submit(){
       
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