<template>
  <div style="text-align: center;margin-top: 100px;width: 800px; margin-left:auto;margin-right: auto;">
    <h2>用户列表</h2>
    <el-table :data="userData" style="width: 100%">
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

<script lang="ts" setup>

import router from "@/router";
import {reactive, onMounted} from 'vue';
import {get, post} from "@/net";

onMounted(()=>{
  this.fetchData()
})

const fetchData = () =>{
  post('/api/user/getUserInfo', {
    id: parseInt(userId)
  }, (message) => {
    let data = JSON.parse(message)
    form.username = data.username
    form.email = data.email
  })
}

const fetchUserData = (userId) => {

}

interface User {
  id: number
  username: string
  email: string
}

const userData: User[] = []
const handleEdit = (index: number,row: User) => {
  router.push('/admin/editUser/'+row.id)
}

const handleDelete = (index:number,row:User) => {

}
</script>

<style scoped>

</style>

