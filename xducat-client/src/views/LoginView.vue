<template>
  <el-form ref="loginRef" :model="login" :rules="rules">

    <el-form-item prop="username">
      <el-input v-model="login.username" placeholder="用户名" >
        <template #prefix>
          <el-icon class="el-input__icon" id="username" :size="20"><user/></el-icon>
        </template>
      </el-input>
    </el-form-item>

    <el-form-item prop="password">
      <el-input v-model="login.password" type="password" placeholder="密码" show-password >
        <template #prefix>
          <el-icon class="el-input__icon" id="password" :size="20"><lock /></el-icon>
        </template>
      </el-input>
    </el-form-item>

    <el-form-item>
      <el-button type="primary" @click="onLogin('loginRef')">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'
import { User,Lock } from '@element-plus/icons-vue'


const login = reactive({
  username:'',
  password:''
})

const rules = reactive({

  username: [{
    required: true,
    message: '请输入用户名',
    trigger: 'blur'
    }
  ],
  password:[{
      required:true,
      message:'请输入密码',
      trigger:'blur'
    }
  ],
})

</script>

<script lang="ts">
import { defineComponent } from 'vue'
import { ElMessage} from 'element-plus'
import router from '@/router'

export default defineComponent ({
  methods: {
    onLogin() {

      // 这是为了判断空用户名和密码而设置的
      // 表单验证判断似乎会出问题，这里单独写了
      var str = this.login.username;
      if (str == 'undefined' || !str || !/[^\s]/.test(str)){
        ElMessage.error('用户名和密码不得为空')
        return;
      }
      
      str = this.login.password;
      if (str == 'undefined' || !str || !/[^\s]/.test(str)){
        ElMessage.error('用户名和密码不得为空')
        return;
      }

      this.$axios.post('http://localhost:8888/user/login/'+this.login.username+'/'+this.login.password).then((resp)=>{
        if(resp.data==true){
          // 登录成功后动态添加路由
          const manage={
            path: '/manage',
            name: 'manage',
            component: () => import('../views/ManageView.vue')
          };
          router.addRoute(manage);
          
          ElMessage({
            message: ('登录成功！欢迎您，'+this.login.username),
            type: 'success',
          })
          this.$router.push('/manage');//登录成功
        }
        else{
           ElMessage.error('用户名不存在或者密码错误，请检查!')
        }
      })
    }
  }
})
</script>

