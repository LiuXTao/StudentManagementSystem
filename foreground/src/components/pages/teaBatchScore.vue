<template>
    <div class="mainbatch">
	<v-head></v-head>
    <div id="context"> 
       <el-table
      :data="newsList"
	  border
      style="width: 100%">
      <el-table-column
        prop="courseName"
        label="课程名"
        min-width="33%">
      </el-table-column>
      <el-table-column
        prop="stuid"
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
    </div>
</template>

<script>
    import vHead from '../commons/TeacherNav.vue';
    export default {
	components:{
        vHead,
    },
    created(){
        this.courid=localStorage.getItem("selectCourse");

        var vm=this;
        $.ajax({
            type:'post',
            dataType:'json',
            url:'/teacher/getStudentTakes',
            data:{
                "couID":this.courid
            },
            success:function(response){
                if(response.string!=""){
                    
                    vm.analysisData(vm,response.string);

                }

            },
            error:function(err){
                console.log(err);
                console.log("error");
            }
        })



    },
    data: function(){
        return {
                courid:'',                
                hostURL:"/",
                newsList: []


            }
        },
        methods:{
            getnewsList(id){//从后端获取数据，id表示获取哪个班的数据
                var self = this;

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
                this.$confirm('确定录入？', '提示', {
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
        analysisData(vm,responseData){
        var arraya=responseData.split(';')
        
            console.log(arraya.length)
            for(var i=0;i<arraya.length;i++){
            var ele=arraya[i].split(',');
            var dist=new Array();
            for(var j=0;j<ele.length;j++){
                var eleItem=ele[j].split(':')
                console.log(eleItem[0],'->',eleItem[1])
                dist[eleItem[0]]=eleItem[1]
            }
            vm.newsList.push(dist);
            }
            console.log(vm.courseList)
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
.mainbatch{
 
  }
#context{
    margin:0 auto;
    width:98%;
    background-color:#eef1f6;
    padding:10px;
}
.mainbutton{
    margin-top:50px;
	margin-left:0px;
}
.el-table{
text-align:left;
}
</style>