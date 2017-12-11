<template>
    <div class="mainchange">
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
        label="分数"
		min-width="54%">
		<template slot-scope="scope">
          <div slot="reference">
		<el-input placeholder="" v-model="scope.row.score" number></el-input>
		</div>
      </template>
      </el-table-column>
    </el-table>
	<div class="mainbutton">
	 <el-button type="primary" @click="submit()">提交</el-button>
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
            submit(){//向后端提交数据
                var self=this;
				var send=true;
                for(var i=0;i<self.newsList.length;i++){
				//alert(self.newsList[i].score);
                    if(self.newsList[i].score<0||self.newsList[i].score>100||self.newsList[i].score==""){
					
                        send=false;
                        break;
                    }
                }
				if(send){
                this.$confirm('确定修改？', '提示', {
                      confirmButtonText: '确定',
                      cancelButtonText: '取消',
                      type: 'warning'
                    })
					//此处选择确定则接着向后端提交数据
				}
				else{
				 alert('内容填写不正确，所填分数应在0-100之间！');
				}
            }
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
.mainchange{
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