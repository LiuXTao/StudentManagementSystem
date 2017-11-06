<template>
    <div class="wrapper">
        <v-head></v-head>
        <div class="clear"></div>
        <div class="selectBoard">
          <div id="selectForm">
              <el-form  id="select">
              <div >
              <el-form-item label="学年:" class="labels">
              <el-select v-model="y_value" placeholder="请选择学年" class="sel1">
                    <el-option  v-for="item in years"  :key="item.value":label="item.label"  :value="item.value">   </el-option>
                </el-select>
              </el-form-item>
              </div>
              <div>
              <el-form-item label="学期:" class="labels">
              <el-select v-model="m_value" placeholder="请选择学期" class="sel2">
                    <el-option  v-for="item in months"  :key="item.value"  :label="item.label"  :value="item.value"> </el-option>
                </el-select>
              </el-form-item>
              <el-button type="primary" @click="submit" id="submit">查询</el-button>
              </div>
              <div class="clear"> </div>
            </el-form>
          </div>
        </div>
        <div class="tableBoard">
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
</template>

<script>
import vHead from '../commons/TeacherNav.vue';

export default {
      data() {
      return {
        y_value: '',
        m_value:'',
        years:[
           {label:2013,value:2013},
           {label:2014,value:2014},
           {label:2015,value:2015},
           {label:2017,value:2017},
           {label:2017,value:2017},
           {label:2018,value:2018}
        ],
        months:[
          {label:1,value:1},
          {label:2,value:2}
        ],

        tableData3: [{
          date: '第1，2节   (am)',
          monday: '王小虎',
          tuesday: '上海',
          wednesday: '普陀区',
          thursday: '上海市普陀区金沙江路 1518 弄',
          friday: 200333
        }, {
            date: '第3,4节  (am)',
          monday: '王小虎',
          tuesday: '上海',
          wednesday: '普陀区',
          thursday: '上海市普陀区金沙江路 1518 弄',
          friday: 200333
        }, {
           date: '第5,6节   (pm)',
          monday: '王小虎',
          tuesday: '上海',
          wednesday: '普陀区',
          thursday: '上海市普陀区金沙江路 1518 弄',
          friday: 200333
        }, {
           date: '第7,8节   (pm)',
          monday: '王小虎',
          tuesday: '上海',
          wednesday: '普陀区',
          thursday: '上海市普陀区金沙江路 1518 弄',
          friday: 200333
        }, {
            date: '第9,10,11节   ',
          monday: '王小虎',
          tuesday: '上海',
          wednesday: '普陀区',
          thursday: '上海市普陀区金沙江路 1518 弄',
          friday: 200333
        }
         ]
      }
    },
    methods:{
      submit(){
        console.log(this.y_value);
        console.log(this.m_value);
       if(this.y_value==''){
           console.log("error") ;
                this.$message({
                    type:"info",
                    message:"请选择搜学年"
                });
        }
        else if(this.m_value==''){
           console.log("error") ;
                this.$message({
                    type:"info",
                    message:"请选择搜索学期"
                });
        }
        else 
        $("#table").show();
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
.selectBoard{
    margin-top:8px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;

}
#selectForm{

    padding-top: 10px;

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
.tableBoard{
    margin-top:8px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;

}

#submit{
  margin-top:36px;
  margin-left:10px;
  float:left;
}
#table{
  width:90%;
  padding:10px;  
  margin:0px auto;
  display: none;
}
#classTable{
  width:100%;
}
/* #classTable td{
  color:blue;
  height:55px;
} */

</style>


