<template>
    <div id="mainboard2">
      <div id="list"> 
    <el-table
    :data="this.childEd"
    border  >
     <el-table-column
      type="index"
      :index="indexMethod"
       min-width="10%">
     
    </el-table-column>
    <el-table-column
      prop="date"
      label="发布日期"  id="date" min-width="18%">
        <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.date }}</span>
      </template>
    </el-table-column>
    <el-table-column
      prop="name"
      label="通知主题" id="notification" min-width="55%">
    </el-table-column>
    <el-table-column label="操作"  min-width="30%">
      <template scope="scope">
      <el-button type="primary" @click="showDetail(scope.row)" class="ope-button">查看通知</el-button>
      <el-button type="danger"  @click="del(scope.$index)" class="ope-button">删除通知</el-button>
      </template>
  </el-table-column>
  </el-table>
    </div>
    <div id="context">
       <div class="operation">
            <el-button type="success" @click="back()" id="back-button">返回</el-button>
            <el-button type="danger" @click="dele()" id="delete-button">删除</el-button>
        </div>
        <div class="content">
            <p>调过来了</p>
            <p>{{this.select}}</p>

        </div>
    </div>
    </div>
</template>
<script>
import bus from 'D://nodeJs/vueCase/test/src/assets/eventBus';
export default {
     props:['childEd'],
     data(){
        return {
        
          select:'',
        // tableData3: [{
         
        //   date: '2016-05-03',
        //   name: '王虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
        
        //   date: '2016-05-02',
        //   name: '王虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
        //     date: '2016-05-04',
        //   name: '王虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
          
        //   date: '2016-05-01',
        //   name: '王小',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
          
        //   date: '2016-05-08',
        //   name: '王小',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
           
        //   date: '2016-05-06',
        //   name: '王虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }, {
           
        //   date: '2016-05-07',
        //   name: '王虎',
        //   address: '上海市普陀区金沙江路 1518 弄'
        // }],
    }
},  
methods:{
      indexMethod() {
        return index +1;
      }
    ,

     showDetail(row){
      // console.log(index);
      this.select=row;
      $("#list").hide();
      $("#context").show();

  },
  del(index,table){
     console.log(index);
    console.log(this.childEd[index].date);
    this.childEd.splice(index,1);
    
    
  },
  back(){
      console.log(this.select.id);
      this.select="";
      $("#list").show();
      $("#context").hide();
  },
  
  }
}
</script>
<style>
#mainboard2 {
    width: 100%;
}
#list{
    width: 100%;
    height:500px;
    margin:0px auto;
    margin-top:10px;
}
.ope-button{
  display: inline;
}
#context{
  display: none;
  width: 100%;
  height:8  800px;;
  margin:0px auto;
  margin-top:10px;
} 
</style>
