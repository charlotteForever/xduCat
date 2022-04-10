<template>
  <div>
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="login">Login</router-link>
    </nav>
    <router-view />
  </div>
</template>

<style lang="css">
a {
  font-size: 20px;
  color: black;
  text-decoration: none;
}
a:visited {
  color: rgb(49, 146, 238);
}
nav {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 15px;
}
</style>