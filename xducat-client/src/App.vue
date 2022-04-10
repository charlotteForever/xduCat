<template>

  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="login">Login</router-link>

    <el-form ref="searchRef" :model="search">
      <el-form-item prop="search">
        <el-input v-if="!$route.meta.showNav" v-model="search.input" placeholder="输入猫咪颜色搜索" />
      </el-form-item>

      <el-form-item>
        <el-button v-if="!$route.meta.showNav" type="primary" @click="onSearch(searchRef)">搜索</el-button>
      </el-form-item>
    </el-form>
  </nav>

  <router-view />
</template>

<script lang="ts" setup>
import { reactive } from "vue";
const search = reactive({
  input: "",
});
</script>

<script lang="ts">
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