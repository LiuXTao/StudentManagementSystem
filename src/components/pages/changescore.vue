<template>
    <div>
<v-head></v-head>
       <el-table
      :data="newsList"
      style="width: 100%">
      <el-table-column
        prop="ID"
        label="ID"
        width="300">
      </el-table-column>
	  <el-table-column
        label="名字"
        width="300" >
		<template slot-scope="scope">
          <div slot="reference">
            <div>{{ scope.row.name }}</div>
          </div>
      </template>
      </el-table-column>
      <el-table-column
        label="分数">
		<template slot-scope="scope">
          <div slot="reference">
		<el-input placeholder="" v-model="scope.row.score "></el-input>
		</div>
      </template>
      </el-table-column>
    </el-table>
	 <el-button type="primary" @click="submit()">提交</el-button>
       
         
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
            score: '60'
          }, {
		  id:3,
             ID: '1',
            name: 'zhangsan',
            score: '50'
          }, {
		  id:4,
             ID: '1',
            name: 'zhangsan',
            score: '50'
          }]
            }
        },
        methods:{
           
            
            getnewsList(id){
                var self = this;
               // self.newsList = [];
               /* self.$axios({
                    url:'/changescore/'+id,
                    method:'get',
                    baseURL: self.hostURL
                }).then((response)=>{
                    self.newsList = response.data;
                    
                    console.log(newsList);
                }).catch((error)=>{
                    console.log(error);
                });*/
            },
           
            submit(){
                var self=this;
                var submitdata={
                    id:1,
                    ID: '1',
                    name: 'zhangsan',
                    score: '50'
                };
                submitdata.id=self.id;
                submitdata.ID=self.ID;
                submitdata.name=self.name;
                submitdata.score=self.score;
               /* self.$axios({
                    url:'/scorechange',
                    method:'post',
                    baseURL: self.hostURL,
                    data:submitdata
                }).then((response)=>{                    
                    var state=response.data;
                    if(state==1){
                        self.$message({
                        type:'info',
                        message:'提交成功'
                        });
                    }
                    else if(state==0){
                        self.$message({
                        type:'info',
                        message:'提交失败'
                        });
                    }
                }).catch((error)=>{
                    console.log(error);
                });*/

            }
        },
        
        mounted(){
            var self= this;
            //self.newsList=[];
            console.log("2222");
            var arr = location.href.split('?');
            console.log(arr[1]);
            var encyclopedia_id = arr[1];
            console.log(encyclopedia_id);
            self.getnewsList(encyclopedia_id);  


        }
    }
</script>

<style scoped>
.el-button{
    width:220px;
    margin-left:0px;
}

</style>