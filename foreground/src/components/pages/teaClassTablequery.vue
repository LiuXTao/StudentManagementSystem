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
          <div id="table" ref="table">
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
      created(){
        this.tea_id=localStorage.getItem("teaId");
      },
      data() {
      return {
        course:{
        name:'数据结构',
        date:'1',
        jieshu:'34'  
        },
        tea_id:'',
        y_value: '',
        m_value:'',
        years:[
           {label:'2012-2013',value:'20122013'},
           {label:'2013-2014',value:'20132014'},
           {label:'2014-2015',value:'20142015'},
           {label:'2015-2016',value:'20152016'},
           {label:'2017-2018',value:'20172018'},

        ],
        months:[
          {label:"1",value:1},
          {label:"2",value:2}
        ],
        emptyTable:[{
            date:'上午第一，二节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'上午第三，四节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
             date:'下午第一，二节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'下午第三，四节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'晚上第一,二,三节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        }]
        ,
        tableData3: [{
            date:'上午第一，二节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'上午第三，四节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
             date:'下午第一，二节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'下午第三，四节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        },{
            date:'晚上第一,二,三节',
            monday:'',
            tusday:'',
            wednesday:'',
            thursday:'',
            friday:'',
        }]
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
        else {
          // 使用emptyTable对tableData3内容进行清空
          this.tableData3=this.emptyTable
          
          var vm=this;
          $.ajax({
            type:'post',
            url:'/teacher/classtablequery',
            dataType:'json',
            data:{
              "id":this.tea_id,
              "selectYear":this.y_value,
              "selectMonth":this.m_value
            },
            success:function(response){
              if(response.string!=""){
                var courseList=response.string;
                vm.dataSplit(vm,courseList);
                vm.$refs.table.style.display='block';
              }else{
                vm.$message({
                  type:'info',
                  message:'课程加载失败'
                })
              } 
            },
            error:function(err){
              console.log(err);
              console.log("error");
              vm.$message({
                type:'info',
                message:'网络请求失败'
              })
            }
          })
        }
      },
      dataSplit(vm,courseList){
          var arrays=courseList.split(";");
          console.log(arrays.length)
          for(var i=0;i<arrays.length;i++){
            var ele=arrays[i].split(":");
            console.log(ele);
            var times=ele[1].split("-");
            var date=vm.transDate(times[0]);
            var jieshu=vm.transjieshu(times[1]);     
            vm.tableData3[jieshu-1][date]=ele[0];
          }
          console.log(vm.tableData3);

      },
      transjieshu(jieshu){
        switch(jieshu){
          case '12':return 1;
          case '34':return 2;
          case '56':return 3;
          case '78':return 4;
          case '91011':return 5;
        }
      },
      transDate(date){
        switch(date){
          case '1':return "monday";
          case '2':return "tuesday";
          case '3':return "wednesday";
          case '4':return "thursday";
          case '5':return 'friday';
        }
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
  width:80%;
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


