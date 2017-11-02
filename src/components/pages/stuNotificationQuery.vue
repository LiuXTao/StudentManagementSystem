<template>
    <div id="wrapper">
        <v-head></v-head>
        <div class="clear"></div>
        <div class="mainborder">
            <div>
                <div class="left">
                <el-menu default-active="onRoutes" class="siderBar" @select="handleSelect" theme="light">
                    <el-menu-item index="unRead"><i class="el-icon-setting"></i>未读通知</el-menu-item>
                    <el-menu-item index="readed"><i class="el-icon-setting"></i>已读通知</el-menu-item>
                    <div class="tianchong"></div>
                </el-menu>
                </div>
                <div class="right">
                    <template v-if="selectIndex==('unRead')">
                        <un-read-list :child-un="this.unList" v-on:readedNo="readedNode"></un-read-list>
                    </template>
                    <template v-else>
                        <readed-list :child-ed="this.reList"></readed-list>
                    </template>
                </div>
                  <div class="clear"></div>
            </div>
            </div>
        </div>


    </div>
</template>
<script>
import vHead from '../commons/StudentNav.vue';
 import unReadList from './unreadNotificationList.vue';
  import ReadedList from './readNotificationList.vue';
export default {
  components:{
      vHead,
      unReadList,
      ReadedList
  },

  data(){
      return {
          selectIndex:'',
          reList:[
        {
         
          date: '2016-05-03',
          name: '王虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
        
          date: '2016-05-02',
          name: '王虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
            date: '2016-05-04',
          name: '王虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-01',
          name: '王小',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          
          date: '2016-05-08',
          name: '王小',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
           
          date: '2016-05-06',
          name: '王虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
           
          date: '2016-05-07',
          name: '王虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }
          ],
          unList:[
              {
         
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
        }
          ]
      }
  },
    methods:{
        handleSelect:function(key,keyPath){
            console.log(keyPath);
            this.selectIndex=key;
        },
        readedNode(item){
            this.reList.unshift(item)
        }
    }

}
</script>
<style scoped>
.clear{
    clear: both;
}
.mainborder{
     border: 2px solid #F5F5F5;
      
}
.left{
  width: 14%;
  margin-top: 5px;
  float: left;
}
.tianchong{
  height: 400px;
  width: 100%
}
.right{
  float: right;
  width:85%;
  text-align: center;
   margin-top: 5px;
   background-color:#eef1f6;
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
