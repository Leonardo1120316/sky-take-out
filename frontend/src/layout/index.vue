<template>
  <a-layout style="height: 100%">
    <!-- 左侧栏菜单 -->
    <a-layout-sider
      :style="{
        overflow: 'auto',
        height: '100vh',
        left: 0,
        top: 0,
        bottom: 0,
      }"
    >
      <h1 style="color: white;display:grid;justify-items: center;margin-top:20px">学生成绩分析系统</h1>
      <a-menu v-model:selectedKeys="selectedKeys" theme="dark" mode="inline">
        <Menu :menuList="userStore.menuRoutes"></Menu>
      </a-menu>
    </a-layout-sider>
    <!-- 右侧内容 -->
    <a-layout>
      <!-- 顶部setting栏 -->
      <a-layout-header :style="{ background: '#fff', padding: 0 }" >
        <div style="height:100%;float:right;display:grid;align-items:center">
          <a-button style="float:right;margin-right:10px" @click="exit">退出登录</a-button>
        </div>
      </a-layout-header>
      <!-- 路由页面 -->
      <a-layout-content :style="{ margin: '24px 16px 0' }">
        <div :style="{ padding: '24px', background: '#fff', height: '100%' }">
          <router-view v-slot="{ Component }">
            <transition name="fade">
              <component :is="Component" />
            </transition>
          </router-view>
        </div>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>

<script setup lang="ts">
import Menu from "@/layout/Menu/index.vue";
import useUserStore from "@/store/modules/employee";
import { useRouter } from "vue-router";
const $router = useRouter()
const userStore = useUserStore();
const exit = ()=>{
  $router.push({path: '/login'})
  userStore.currentUser = null
  userStore.userRole = 0
  userStore.menuRoutes = null
}
</script>

<style scoped>
.fade-enter-from {
  opacity: 0;
}
.fade-enter-active {
  transition: all 1s;
}
.fade-enter-to {
  opacity: 100;
}
</style>
