<template>
  <div style="text-align: center;margin-top: 100px;width: 800px; margin-left:auto;margin-right: auto;">
    <h2>用户列表</h2>
    <el-table :data="userData" :key="tableKey" style="width: 100%">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="username" label="用户名"></el-table-column>
      <el-table-column prop="email" label="电子邮件"></el-table-column>
      <el-table-column label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>

import router from "@/router";
import {onMounted, ref} from 'vue';
import {post} from "@/net";

onMounted(()=>{
  fetchData()
})
let userData = ref([])
let tableKey = ref()
const fetchData = () =>{
  post('/api/user/getAllUsers', {}, (message) => {
    userData.value = JSON.parse(message)
    console.log(userData)
  })
}

const fetchUserData = (userId) => {

}


const handleEdit = (index,row) => {
  router.push('/admin/editUser/'+row.id)
}

const handleDelete = (index,row) => {

}
</script>

<style scoped>

</style>

