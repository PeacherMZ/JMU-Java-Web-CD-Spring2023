<template>
  <div style="text-align:center; margin: 0 25px">
    <div style=" margin-top:230px">
      <div style="font-size:25px; font-weight: bold">🕊鸽子云盘 注册</div>
      <div style="margin-top: 30px">
        <el-form :model="form" :rules=rules ref="formRef">
          <el-form-item prop="username">
            <el-input v-model="form.username" type="text" placeholder="用户名">
              <template #prefix>
                <el-icon>
                  <User/>
                </el-icon>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="form.password" type="password" placeholder="密码">
              <template #prefix>
                <el-icon>
                  <Lock/>
                </el-icon>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item prop="password_repeat">
            <el-input v-model="form.password_repeat" type="password" placeholder="重复密码">
              <template #prefix>
                <el-icon>
                  <Lock/>
                </el-icon>
              </template>
            </el-input>
          </el-form-item>
          <el-form-item prop="email">
            <el-input v-model="form.email" type="text" placeholder="电子邮件地址">
              <template #prefix>
                <el-icon>
                  <Message/>
                </el-icon>
              </template>
            </el-input>
          </el-form-item>

<!--          <el-form-item prop="code">-->
<!--            <el-row :gutter="10" style="width: 100%">-->
<!--              <el-col :span="18">-->
<!--                <el-input v-model="form.code" type="text" placeholder="验证码">-->
<!--                  <template #prefix>-->
<!--                    <el-icon>-->
<!--                      <EditPen/>-->
<!--                    </el-icon>-->
<!--                  </template>-->
<!--                </el-input>-->
<!--              </el-col>-->
<!--              <el-col :span="6">-->
<!--                <el-button @click="sendCode()">发送验证码</el-button>-->
<!--              </el-col>-->
<!--            </el-row>-->
<!--          </el-form-item>-->

        </el-form>
      </div>
      <div style="margin-top: 40px; text-align: center">
        <el-button style="width: 250px" type="warning" @click="checkAndRegister()" plain>立即注册</el-button>
        <div style="margin-top: 15px">
          <span style="font-size: 13px;color:gray">已有账号？</span>
          <el-link @click="router.push('/')" type="primary" style="translate: 0 -1px">立即登录</el-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import {EditPen, Lock, Message, User} from "@element-plus/icons-vue";
import {reactive, ref} from "vue";
import router from "@/router";
import {ElMessage} from "element-plus";
import {post} from "@/net";

const formRef = ref()

const form = reactive({
  username: '',
  password: '',
  password_repeat: '',
  email: '',
  code: ''
})

const checkAndRegister = () => {
  formRef.value.validate((isValid)=>{
    if(isValid){
      if (form.password === form.password_repeat){
        register()
      } else {
        ElMessage.error("两次密码不一致")
      }
    }else{
      ElMessage.warning("请完整填写注册表单")
    }
  })
}

const rules = {
  username: [
    {required: true, message: '请输入用户名', trigger: ['blur', 'change']}
  ],
  password: [
    {required: true, message: '请输入密码', trigger: ['blur', 'change']}
  ],
  password_repeat:[
    {required: true, message: '请重复密码', trigger: ['blur', 'change']}
  ],
  email:[
    {required: true, message: '请输入电子邮件地址', trigger: ['blur', 'change']}
  ]

}

const register = () => {
  post('/api/auth/register', {
    username: form.username,
    password: form.password,
    email: form.email
  }, (message) => {
    ElMessage.success(message)
    router.push('/')
  })
}

const sendCode = () => {
  ElMessage.info('前面的区域，以后再来探索吧！')
}
</script>

<style scoped>

</style>