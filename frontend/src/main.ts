import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from '@/router'
import pinia from "@/store"
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/reset.css';
import 'virtual:svg-icons-register'
import globalComponent from '@/components/index'
import { message } from 'ant-design-vue';

const app = createApp(App)
app.config.globalProperties.$message = message;
app.use(globalComponent)
app.use(router)
app.use(pinia)
app.use(Antd)
app.mount('#app')
