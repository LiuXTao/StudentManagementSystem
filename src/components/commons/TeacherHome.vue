<template>
    <div id="wrapper">
    <v-head></v-head>
       <div class="content">
            <transition name="move" mode="out-in"><router-view></router-view></transition>
        </div>
    </div>
</template>
<script>
import vHead from './TeacherNav.vue'

export default {
components:{
    vHead,
},
 
}
</script>
<style scoped>

</style>
