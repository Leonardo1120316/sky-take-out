import axios from 'axios'
import { message } from 'ant-design-vue';


let request = axios.create({
    baseURL: import.meta.env.VITE_APP_BASE_API,
    timeout: 5000
})

request.interceptors.request.use((config)=>{
    return config
})

request.interceptors.response.use((response)=>{
    if(response.status == 200){
        if(response.data.code){
            return response.data.data
        }else{
            message.info(response.data.msg)
            return response.data;
        }
    }else{
        message.info("Unknow Error")
        return response;
    }
},(err)=>{
    console.log(err.code)
    message.info(err.code)
})

export default request;