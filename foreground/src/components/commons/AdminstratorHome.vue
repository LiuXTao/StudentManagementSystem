<template>
    <div id="wrapper">
    <v-head></v-head>
       <div class="content">
            <transition name="move" mode="out-in"><router-view></router-view></transition>
        </div>
    </div>
</template>
<script>
import vHead from './AdminstratorNav.vue'

export default {
components:{
    vHead,
},
 mounted() {
    console.log("home active");
}
}
</script>
<style scoped>

</style>