<template>
    <div id="mainboard">
    <div id="list" ref="list">
    <el-table
    :data="this.childUn"
    border >
    <el-table-column
      type="index" :index="indexMethod" min-width="10%">
    </el-table-column>
    <el-table-column
      prop="time"
      label="发布日期"  id="date" min-width="24%"  sortable>
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.time }}</span>
      </template>
    </el-table-column>
    <el-table-column
      prop="noticeContent"
      label="通知主题" id="notification" min-width="50%">
    </el-table-column>
     <el-table-column label="操作"  min-width="30%">
      <template slot-scope="scope">
      <el-button type="primary" @click="showDetail(scope.$index,scope.row)" class="ope-button">查看通知</el-button>
      <el-button type="danger"  @click="del(scope.$index,scope.row)" class="ope-button">删除通知</el-button>
      </template>
  </el-table-column>
  </el-table>
    </div>
    <div id="context" ref="context">
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

export default {
  props:['childUn'],
  data(){
    return {
    select:"",
    selectId:'',
    indexs:'',
    userType:'',
    }
  },
  created(){
    this.select="";
    this.selectId="";
    this.indexs="";
    this.userType=localStorage.getItem("UserType");
  },
  methods:{
    indexMethod(index){
      return index+1;
    },
  showDetail(index,row){
    
      console.log(row)
      this.select=row.time;
      this.selectId=row.id;
      this.indexs=index;
      $("#list").hide();
      $("#context").show();
    
    },
  del(index,row){
    console.log(index);
    console.log(row)
    
    this.selectId=row.id;
    var vm=this;
    const h = this.$createElement;
    this.$msgbox({
        title: 'info',
        message: h('p', null, [
           h('span', null, '是否确定要'),
           h('i', { style: 'color: teal' }, '删除')
        ]),
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
         beforeClose: (action, instance, done) => {
                    if (action === 'confirm') {
                        var target='';
                        if(vm.userType==='111')
                          target='/student/deleteNotification'
                        else 
                          target='/teacher/deleteNotification'
                        console.log("confirm");
                        this.childUn.splice(this.indexs,1);
                        $.ajax({
                            type:'post',
                            url:target,
                            dataType:'json',
                            data:{
                              "id":this.selectId
                            },
                            success:function(response){
                              if(response.data===1){
                                    vm.$message({
                                      type: 'success',
                                      message: '删除成功!'
                                    })
                                         
                                    console.log(99) 
                                }else{
                                   vm.$message({
                                    type: 'warning',
                                    message: '删除失败!'
                                    })
                                }
                            },
                            error:function(err){
                              console.log(err)
                              console.log("error")
                            }
                          })
                          done();
                          }else{
                          
                          vm.$message({
                                    type: 'info',
                                    message: '已取消删除'
                                });    
                            done();
                    }
              }
        })       
 
  },
  back(){
       
       var vm=this;
       this.childUn.splice(this.indexs,1);
       var target='';
       if(vm.userType==='111')
           target='/student/ReadNotification'
       else 
           target='/teacher/ReadNotification'      
       $.ajax({
        type:'post',
        url:target,
        dataType:'json',
        data:{
            "id":this.selectId
          },
          success:function(response){
              if(response.data===1){
                console.log("ok")
                vm.$refs.list.style.display='block';
                vm.$refs.context.style.display='none';
                vm.selectId='';  
              }else{
               
              }
          },
          error:function(err){
              console.log(err)
              console.log("error")
          }
         })
  },
  dele(){
    var vm=this;
    const h = this.$createElement;
   
    this.$msgbox({
        title: 'warning',
        message: h('p', null, [
           h('span', null, '是否确定要'),
           h('i', { style: 'color: teal' }, '删除')
        ]),
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消',
         beforeClose: (action, instance, done) => {
                    if (action === 'confirm') {
                        var target='';
                        if(vm.userType==='111')
                          target='/student/deleteNotification'
                        else 
                          target='/teacher/deleteNotification'
                        console.log("confirm");
                        this.childUn.splice(this.indexs,1);     
                        $.ajax({
                            type:'post',
                            url:target,
                            dataType:'json',
                            data:{
                              "id":this.selectId
                            },
                            success:function(response){
                              if(response.data===1){
                                    vm.$message({
                                      type: 'success',
                                      message: '删除成功!'
                                    })
                                  
                                  vm.$refs.list.style.display='none';
                                  vm.$refs.context.style.display='block';
                                   
                                  console.log(99) 
                                }else{
                                   vm.$message({
                                    type: 'warning',
                                    message: '删除失败!'
                                    })
                                }

                            },
                            error:function(err){
                              console.log(err)
                              console.log("error")
                            }
                          })
                          done();
                          }else{
                             console.log("11111111111111111");
                          vm.$message({
                                    type: 'info',
                                    message: '已取消删除'
                                });    
                            done();
                    }
              }
        })       
      // $("#list").show();
      // $("#context").hide();
    
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
    height:8  500px;;
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
#content{
  width: 100%;
  height:8  800px;;
  margin:0px auto;
  
} 

</style>
