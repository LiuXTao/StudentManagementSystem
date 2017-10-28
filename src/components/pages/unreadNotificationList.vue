<template>
    <div id="mainboard">
    <el-table
    :data="tableData3"
    height="250" border id="list">
     <el-table-column
      type="index" id="no" min-width="10%">
    </el-table-column>
    <el-table-column
      prop="date"
      label="日期"  id="date" min-width="18%">
    </el-table-column>
    <el-table-column
      prop="name"
      label="通知" id="notification" min-width="82%">
    </el-table-column>
   
  </el-table>
    </div>
</template>
<script>
export default {
    data(){
        return {
   tableData3: [{
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-08',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-06',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-07',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
    }
}
}
</script>
<style>
#mainboard {
    width: 100%;
}
#list{
    width: 100%;
    margin:0px auto;
    margin-top:10px;
}

</style>
