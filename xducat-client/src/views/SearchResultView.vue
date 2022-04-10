<template>


  <table>
    <tr v-for="item in cats" :key="item">
      <table @click="getDetail(item)"><!-- 如果只是简单的写地址是没有办法显示图片的 -->
        <tr><img class="catImg" :src="require('../../img/catProfile/' + item.img)" alt="猫咪图片" /></tr>
        <tr>猫咪颜色：{{ item.color }}</tr>
        <tr>出现地点：{{ item.location }}</tr>
      </table>
      
    </tr>
  </table>
</template>

<style scoped>

.catImg{
  width: 150px;
  height: 150px;
}

</style>

<script>
export default {
  data() {
    return {
      cats: [],
    };
  },

  mounted() {
    this.getResult();
  },

  methods: {
    getResult() {
      this.$axios
        .post(
          "http://localhost:8888/cat/findCatByColor/" + this.$route.query.color
        )
        .then((resp) => {
          this.cats = resp.data;
        });
    },
    // 点击猫咪项跳转到详情页面
    getDetail(item){
      console.log(item.id);
      this.$router.push({
        path: "/catDetail",
        query: { id: item.id },
      });
    }
  },

    // 当输入的猫改变时，这里刷新页面
    // 这里写的很复杂是因为为了让刷新页面自然些
  watch: {
    $route: {
      handler: function (val, oldVal) {
          if(val.path == oldVal.path)
          {
              if(val.query.color != oldVal.query.color){
                  this.$router.replace("/refresh");
              }
          }
      },
    },
  },
};
</script>

