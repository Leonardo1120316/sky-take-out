import { defineStore } from "pinia"
import './type'
import {routes} from '@/router/routes'

const EmployeeStore = defineStore('User',{
    //状态管理
    state: (): EmployeeType => {
        return {
          token: 'aa'
        }
    },
    //异步逻辑处理
    actions: {
       setToken(token:string){
        this.token = token;
       },
       getToken(){
        return this.token;
       }
    },
    //计算属性
    getters: {
    },
    persist: true
})
//暴露仓库
export default EmployeeStore