<template>
  <div>
    <template v-for="item in menuList" :key="item.path">
       <!-- 没有子路由 -->
       <template v-if="!item.meta.hidden">
        <a-menu-item v-if="!item.children" :key="item.path" @click="goRoute(item.path)">
          {{item.meta.title}}
        </a-menu-item>
       </template>
       <!-- 含有一个子路由 -->
       <template v-if="!item.meta.hidden">
         <a-menu-item v-if="item.children&&item.children.length==1" :key="item.children[0].path" @click="goRoute(item.children[0].path)">
           <span>{{item.children[0].meta.title}}</span>
         </a-menu-item>
       </template>
       <!-- 含有多个子路由 -->
       <template v-if="!item.meta.hidden">
        <a-sub-menu v-if="item.children&&item.children.length>1" :key="item.path">
          <template #title>{{item.meta.title}}</template>
          <Menu :menuList="item.children"></Menu>
        </a-sub-menu>
       </template>
    </template>
  </div>
</template>

<script setup lang="ts">
import { ref, defineProps, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import Menu from './index.vue'
const selectedKeys = ref<string[]>(['4']);
const prop = defineProps(['menuList'])
let $router = useRouter();
const goRoute = (pathRoute:String) => {
  console.log(pathRoute)
    $router.push({path: pathRoute})
}
</script>

<style scoped>
#components-layout-demo-fixed-sider .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
.site-layout .site-layout-background {
  background: #fff;
}

[data-theme='dark'] .site-layout .site-layout-background {
  background: #141414;
}
</style>
