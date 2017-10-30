<template>
    <div>
        <v-head></v-head>
        <div class="clear"></div>
        <div class="el-main">
          <div id="selectForm">
              <el-form  id="select">
              <div >
              <el-form-item label="学年:" class="labels">
              <el-select v-model="value" placeholder="请选择学年" class="sel1">
                    <el-option  v-for="item in years"  :key="item.value":label="item.label"  :value="item.value">   </el-option>
                </el-select>
              </el-form-item>
              </div>
              <div>
              <el-form-item label="学期:" class="labels">
              <el-select v-model="value" placeholder="请选择学期" class="sel2">
                    <el-option  v-for="item in months"  :key="item.value"  :label="item.label"  :value="item.value"> </el-option>
                </el-select>
              </el-form-item>
              </div>
            </el-form>
          </div>
      <div id="table">
    <el-table :data="tableData3"  border >
    <el-table-column
      prop="date"
      label="节数\日期"
      
      min-width:"5%">
    </el-table-column>

      <el-table-column
        prop="name"
        label="星期一"
        min-width:"20%">
      </el-table-column>
        <el-table-column
          prop="province"
          label="星期二"
          min-width:"20%">
        </el-table-column>
        <el-table-column
          prop="city"
          label="星期三"
           min-width:"20%">
        </el-table-column>
        <el-table-column
          prop="address"
          label="星期四"
           min-width:"20%">
        </el-table-column>
        <el-table-column
          prop="zip"
          label="星期五"
           min-width:"20%">
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
        value: '',
        years:[
           {label:2013,velue:2013},
           {label:2014,velue:2014},
           {label:2015,velue:2015},
           {label:2017,velue:2017},
           {label:2017,velue:2017},
           {label:2018,velue:2018}
        ],
        months:[
          {label:1,value:1},
          {label:2,value:2}
        ],

        tableData3: [{
          date: '2016-05-03',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-02',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-08',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-06',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }, {
          date: '2016-05-07',
          name: '王小虎',
          province: '上海',
          city: '普陀区',
          address: '上海市普陀区金沙江路 1518 弄',
          zip: 200333
        }]
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
.el-main{
    margin-top:3px;
    background-color:#eef1f6;
    color: #333;
    text-align: center;
    height:800px;
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
#table{
  /* width:90%; */
  margin:0px auto;
}
/* .sel{
    float:left;
    display: inline;
} */

</style>


