<template>
  <div>
      你已成功登录。
  </div>
  <div>
      <el-button @click="logout()" type="danger" plain>退出登录</el-button>
  </div>
</template>

<script setup>
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";

const logout = () =>{
    get('/api/auth/logout',(message)=>{
        ElMessage.success(message)
        router.push('/')
    })
}

</script>

<style scoped>

</style>