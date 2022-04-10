<template>
  <div>
    <el-form ref="searchRef" :model="search">
      <el-form-item prop="search">
        <el-input v-model="search.input" placeholder="输入猫咪颜色搜索" />
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSearch(searchRef)">搜索</el-button>
      </el-form-item>
    </el-form>
    <el-carousel :interval="4000" type="card" height="200px">
      <el-carousel-item v-for="item in 6" :key="item">
        <h3>{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from "vue";
const search = reactive({
  input: "",
});
</script>

<script lang="ts" >
import { defineComponent } from "vue";

export default defineComponent({
  methods: {
    onSearch() {
      this.$router.push({
        path: "/searchResult",
        query: { color: this.search.input },
      });
    },
  },
});
</script>


<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>
