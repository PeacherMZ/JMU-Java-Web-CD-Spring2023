<script setup>
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import {useStore} from "@/stores";
import router from "@/router";

const store = useStore();
if(store.auth.user == null){
  get('/api/user/me',(message)=>{
    store.auth.user = message
    // router.push('/index')
  },(message)=>{
    store.auth.user = null
  })
}


</script>

<template>
    <router-view/>
</template>

<style scoped>

</style>
