<template>
  <table>
    <tr v-for="item in cats" :key="item">
      <td>{{ item.color }}</td>
      <td>{{ item.location }}</td>
    </tr>
  </table>
</template>


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