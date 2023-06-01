<template>
    <div style="text-align: center;margin-top: 250px">
        <h2>编辑用户信息 {{userId}}</h2>
        <div style="margin-top: 30px; width: 350px; margin-left:auto;margin-right: auto;">
            <el-form :model="form" :rules=rules ref="formRef">
                <el-form-item prop="userId">
                    <el-row style="width: 100%">
                        <el-col :span="6" style="text-align: left">
                            <label>用户ID</label>
                        </el-col>
                        <el-col :span="18" style="text-align: right">
                            <el-input v-model="userId" type="text" placeholder="用户ID" disabled>
                                <template #prefix>
                                    <el-icon>
                                        <InfoFilled />
                                    </el-icon>
                                </template>
                            </el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item prop="username">
                    <el-row style="width: 100%">
                        <el-col :span="6" style="text-align: left">
                            <label>用户名</label>
                        </el-col>
                        <el-col :span="18" style="text-align: right">
                            <el-input v-model="form.username" type="text" placeholder="用户名">
                                <template #prefix>
                                    <el-icon>
                                        <User/>
                                    </el-icon>
                                </template>
                            </el-input>
                        </el-col>
                    </el-row>
                </el-form-item>
                <el-form-item prop="password">

                    <el-row style="width: 100%">
                        <el-col :span="6" style="text-align: left">
                            <label>密码</label>
                        </el-col>
                        <el-col :span="18" style="text-align: right">
                            <el-input v-model="form.password" type="text" placeholder="密码">
                                <template #prefix>
                                    <el-icon>
                                        <Lock/>
                                    </el-icon>
                                </template>
                            </el-input>
                        </el-col>
                    </el-row>

                </el-form-item>
                <el-form-item prop="email">
                    <el-row style="width: 100%">
                        <el-col :span="6" style="text-align: left">
                            <label>电子邮件</label>
                        </el-col>
                        <el-col :span="18" style="text-align: right">
                            <el-input v-model="form.email" type="text" placeholder="电子邮件地址">
                                <template #prefix>
                                    <el-icon>
                                        <Message/>
                                    </el-icon>
                                </template>
                            </el-input>
                        </el-col>
                    </el-row>


                </el-form-item>
            </el-form>
        </div>
        <div>
            <el-button style="width: 250px; margin-top: 20px" type="warning" @click="register()" plain>确认修改</el-button>
        </div>
    </div>
</template>

<script setup>
import {onMounted, reactive, ref} from "vue";
import router from "@/router";
import {InfoFilled, Lock, Message, User} from "@element-plus/icons-vue";
import {post} from "@/net";
import {useRoute} from "vue-router";

const rules = {
    username:[
        {required:true, message:'请输入用户名',trigger:['blur','change']}
    ],
    email:[
        {required:true, message:'请输入电子邮件地址',trigger:['blur','change']}
    ]
}

const form = reactive({
    username:'123123123',
    password:'',
    email:'qweqwe@qweqw.com'
})
const formRef = ref()
const userId = ref('');

onMounted(() => {
    const route = useRoute();
    userId.value = route.params.userId;
    fetchUserData(userId.value);
});

const fetchUserData = (userId) =>{
    console.log(userId)
}


const submit = () => {
    post('/api/user/info',{
        id:userId
    },(message) => {
        this.form = message
    })
}
</script>

<style scoped>

</style>