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
                    <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
              </el-form-item>
              </div>
              <div>
              <el-form-item label="学期:" class="labels">
              <el-select v-model="value" placeholder="请选择学期" class="sel2">
                    <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
              </el-form-item>
              </div>
            </el-form>
          </div>
        <el-table
            :data="tableData3"
            style="width: 100%">
    <el-table-column
      prop="date"
      label="日期"
      width="150">
    </el-table-column>

      <el-table-column
        prop="name"
        label="姓名"
        width="120">
      </el-table-column>

        <el-table-column
          prop="province"
          label="省份"
          width="120">
        </el-table-column>
        <el-table-column
          prop="city"
          label="市区"
          width="120">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址"
          width="300">
        </el-table-column>
        <el-table-column
          prop="zip"
          label="邮编"
          width="120">
        </el-table-column>


            </el-table>

        </div>
    </div>
</template>

<script>
import vHead from '../commons/TeacherNav.vue';

export default {
      data() {
      return {
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
/* .sel{
    float:left;
    display: inline;
} */

</style>


