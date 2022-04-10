<template>
  {{ this.$route.query.id }}

  <table>
    <tr v-for="item in comments" :key="item">
      {{item.name}}
      {{item.comment}}
      {{item.date }}
    </tr>
  </table>

  <el-form :model="commentForm">
    <el-form-item label="你的昵称">
      <el-input v-model="commentForm.name" placeholder="如果不填会显示为“西电er”噢~" />
    </el-form-item>
    <el-form-item label="评论内容：">
      <el-input
        v-model="commentForm.comment"
        :autosize="{ minRows: 2 }"
        type="textarea"
        placeholder="请输入您的评论，不可以超过200字噢~"
        maxlength="200"
        show-word-limit
      />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit()">提交</el-button>
    </el-form-item>
  </el-form>
</template>


<script lang="ts" setup>
import { reactive } from "vue";

const commentForm = reactive({
  name: "",
  comment: "",
});
</script>

<script lang="ts">
import { ElMessage } from 'element-plus'
export default {
  data() {
    return {
      comments: [],
    };
  },
  created() {
    this.getComments();
  },
  methods: {
    getComments() {
    
      this.$axios
        .post(
          "http://localhost:8888/comment/findCommentByCatId/" +this.$route.query.id)
        .then((resp) => {
          this.comments = resp.data;
        });
    },
    onSubmit() {
        var name=this.commentForm.name;
        if(name=='')name="西电er";
      this.$axios
        .post(
          "http://localhost:8888/comment/insertComment/" +
            this.$route.query.id +"/" +this.commentForm.comment +"/" +name)
        .then((resp) => {
            console.log(resp.data);
          if (resp.data == true) {
                ElMessage({
                message: '留言成功!',
                type: 'success',
            })
             this.$router.replace("/refresh");//刷新页面立即看到留言结果
          } else {
            ElMessage.error('留言失败!')
          }
        });
    },
  },
};
</script>