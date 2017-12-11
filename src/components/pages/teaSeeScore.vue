<template>
    <div class="mainsee">
	<v-head></v-head>
       <el-table
      :data="newsList"
	  border
      style="width: 100%">
      <el-table-column
        prop="ID"
        label="ID"
        min-width="33%">
      </el-table-column>
	  <el-table-column
	    prop="name"
        label="名字"
        min-width="33%" >
		
      </el-table-column>
      <el-table-column
	    prop="score"
        label="分数"
		min-width="54%">
      </el-table-column>
    </el-table>
	<div class="mainbutton">
      <el-button type="primary" @click="back()">返回</el-button>
     </div>    
    </div>
</template>

<script>
     import vHead from '../commons/TeacherNav.vue';
    export default {
		components:{
        vHead,
    },
        data: function(){
            return {
                
            hostURL:"/VR",
            newsList: [{
		    id:1,
            ID: '1',
            name: 'zhangsan',
            score: '50'
          }, {
		    id:2,
             ID: '2',
             name: '李四',
             score: '89'
          }, {
		     id:3,
             ID: '1',
            name: 'zhangsan',
           score: '98'
          }, {
		    id:4,
             ID: '1',
            name: 'zhangsan',
           score: '100'
          }]
            }
        },
        methods:{
            getnewsList(id){//从后端获取数据，id表示获取哪个班的数据
                var self = this;
               // self.newsList = [];
            },
           back(){
		    self=this;
		    self.$router.push('/teacher/registerScore');
		   },
        },
        
        mounted(){
            var self= this;
            //self.newsList=[];
            var arr = location.href.split('?');
            console.log(arr[1]);
            var encyclopedia_id = arr[1];
            console.log(encyclopedia_id);
            self.getnewsList(encyclopedia_id);  


        }
    }
</script>

<style scoped>
.mainsee{
  //width:70%;
  //margin:50px 200px;
  }
.mainbutton{
    margin-top:50px;
	margin-left:0px;
}
.el-table{
text-align:left;
}
</style>