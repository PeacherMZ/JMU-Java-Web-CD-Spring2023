<template>
  <div style="text-align: center; margin-top:200px">
    <div>
      你已成功登录。
    </div>
    <div style="margin-top: 20px;">
      <el-button @click="logout()" type="danger" plain>退出登录</el-button>
    </div>
    <div style="margin-top: 20px;">
      <el-button @click="goDiskPeacherCn()" type="success" plain>去别处看看</el-button>
    </div>
    <div style="margin-top: 20px;">
      <el-button @click="goUserList()" type="info" plain>管理用户</el-button>
    </div>
  </div>
</template>

<script setup>
import {get, post} from "@/net";
import {ElMessage} from "element-plus";
import router from "@/router";

const goUserList = () => {
  router.push('/admin/userList')
}

const logout = () => {
  get('/api/auth/logout', (message) => {
    ElMessage.success(message)
    router.push('/')
  })
}
const goDiskPeacherCn = () => {
  window.open('https://disk.peacher.cn', '_blank')
}
</script>

<style scoped>

</style>