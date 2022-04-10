<template>

  <div class="login_container">
    <!--外框-->
    <div class="login_box">
      <!-- 头像 -->
  <div class="logo">
    <img src="../../img/catlogo.png" alt="">
  </div>
      <!-- 表单 -->
      <el-form ref="formRef"
               :model="FormData"
               label-width="0px"
               class="sign"
               :rules="Login">
  <el-form ref="loginRef" :model="login" :rules="rules">
    <!--登录名-->
    <el-form-item prop="username">
      <el-input v-model="login.username" placeholder="用户名" prefix-icon="iconfont icon-user" ></el-input>
    </el-form-item>
      <!--密码-->
    <el-form-item prop="password">
      <el-input v-model="login.password" type="password" placeholder="密码" show-password
                prefix-icon="iconfont icon-3702mima"></el-input>
    </el-form-item>

    <!--按钮-->
    <el-form-item>
      <el-button type="primary" @click="onLogin('loginRef')" >登录</el-button>
    </el-form-item>
  </el-form>
      </el-form>
    </div>
  </div>
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
<style lang="less" scoped>

.login_container {
  height: 100%;
  background-image: url("../../img/catbackground.jpg");
  background-size: 100% 100%;
  width: 100%;
  position: fixed;
}

.login_box {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  height: 300px;
  width: 450px;
  border-radius: 14px;
  background-color: #dcdddd;
  .logo {
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 130px;
    height: 130px;
    border-radius: 50%;
    border: 1px solid #eee;
    padding: 10px;
    background-color: #fff;
    box-shadow: 0 0 10px #ddd;
    img {
      height: 100%;
      width: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }
  .el-button--primary
  {
    color: #ffffff;
    background:#00C07A;
    border-color: #00C07A;
  }
  .sign {
    margin-top: 90px;
    padding: 0 20px;

    .btns {
      display: flex;
      justify-content: flex-end;
    }
  }
}
</style>

