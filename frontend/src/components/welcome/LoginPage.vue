<template>
    <div style="text-align:center; margin: 0 25px">
        <div style=" margin-top:230px">
            <div style="font-size:25px; font-weight: bold" >登录到 🕊鸽子云盘</div>
            <div></div>
        </div>
        <div style="margin-top: 30px">
            <el-input v-model="form.username" type="text" placeholder="用户名或邮箱">
                <template #prefix>
                    <el-icon><User /></el-icon>
                </template>
            </el-input>
            <el-input v-model="form.password" type="password" style="margin-top: 15px;" placeholder="密码">
                <template #prefix>
                    <el-icon><Lock /></el-icon>
                </template>
            </el-input>
        </div>
        <div style="margin-top:10px">
            <el-row>
                <el-col :span="12" style="text-align: left">
                    <el-checkbox v-model="form.remember" label="记住我" />
                </el-col>
                <el-col :span="12" style="text-align: right">
                    <el-link>忘记密码？</el-link>
                </el-col>
            </el-row>
        </div>
        <div style="margin-top: 40px">
            <el-button @click="login()" style="width: 250px" type="success" plain>登录</el-button>
        </div>
        <el-divider>
            <span style="color:gray; font-size:13px">还没有账号？</span>
        </el-divider>
        <div>
            <el-button @click="router.push('/register')" style="width: 250px" type="info" plain>立即注册</el-button>
        </div>
    </div>
</template>

<script setup>
import {Lock, User} from '@element-plus/icons-vue'
import {reactive} from "vue";
import {ElMessage} from "element-plus";
import {post} from "@/net"
import router from "@/router";

const form = reactive({
    username: '',
    password: '',
    remember: false
})
const login = () =>{
    if(!form.username || !form.password){
        ElMessage.warning("请输入用户名和密码")
    }
    else{
        post('/api/auth/login',{
            username: form.username,
            password: form.password,
            remember: form.remember
        }, (message)=>{
            ElMessage.success(message)
            router.push('/index')
        })
    }
}
</script>

<style scoped>

</style>