<template>
<div class='wrapper'>
    <v-head></v-head>  
  <div class="clear"></div>
    <div class="mainborder">
      <!-- <div class="position">
        <div class="el-icon-caret-right">当前位置</div>
          >>
        <template v-for='index in indexs'> </template> -->
          <!-- <template v-for="index in indexs">
          <a  :href='index.url'>{{index.title}}</a>
          <template v-if="index.subs.size==0">
            >>
            <template v-for="subindex in index.subs">
            <a  :href='subindex.url'>{{subindex.title}}</a>
            </template>
          </template>
          </template>
        </div> --> 
    
      <div>
      <div class="left">
         <el-col :span="25">
        <el-menu default-active="onRoutes" class="el-menu-vertical-demo" @select="handleSelect" theme="light">
          <el-menu-item index="unRead"><i class="el-icon-setting"></i>未读通知</el-menu-item>
          <el-menu-item index="Readed"><i class="el-icon-setting"></i>已读通知</el-menu-item>
          <div class="tianchong"></div>
        </el-menu>
         </el-col>
        </div>
        <div class="right" >
          <template v-if="selectIndex==('unRead')">
            <un-read-list :child-un="this.tableData3" v-on:readedNo="readedNode"></un-read-list>
          </template>
          <template v-else>
            <readed-list :child-ed="this.tableData4"></readed-list>
          </template>

        </div>

     <div class="clear"></div>
      </div>
    </div>
  
  </div>
</div>
</template>
    
<script>
  import vHead from '../commons/TeacherNav';
  import unReadList from './unreadNotificationList.vue'
  import ReadedList from './readNotificationList.vue'
  export default {
    name:'passmodi',
    components:{
              vHead,
              unReadList,
              ReadedList,
          },
    data () {
      
      return {
      
        selectIndex:'',
         tableData3: [{
         
          date: '2016-05-03',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-02',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
         
          date: '2016-05-04',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
        
          date: '2016-05-01',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
       
          date: '2016-05-08',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
         
          date: '2016-05-06',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-07',
          name: '虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
        tableData4: [{
         
          date: '2016-05-03',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
        
          date: '2016-05-02',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
            date: '2016-05-04',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-01',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-08',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
           
          date: '2016-05-06',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
           
          date: '2016-05-07',
          name: '王',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
      }
    },
    methods: {
    handleSelect:function(key,keyPath){
      this.selectIndex=key;
      console.log(this.selectIndex);
   
    },
    readedNode(item){
      // console.log(item.name);
      this.tableData4.unshift(item);
      // console.log(this.tableData4[0].name)
    }
      }
  };


</script>


<style scoped>

.mainborder{
  border: 2px solid #F5F5F5;
 
}
.clear{
  clear: both;
}
.left{
  width: 14%;
  margin-top: 5px;
  float: left;
}
.right{
  float: right;
  width:85%;
  text-align: center;
   margin-top: 5px;
   background-color:#eef1f6;
}

.tianchong{
  height: 400px;
  width: 100%
}

.position{
  margin-left:15px; 
  float:left;

}
  .el-row {
    margin-bottom: 20px;

  }
  .el-col {
    border-radius: 4px;
  }
   
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: none;
}
a:active {
 text-decoration: none;
}

</style>

  