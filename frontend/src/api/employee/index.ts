import request from "@/utils/request";
import './type.ts'

enum API {
    LOGIN_URL = '/admin/employee/login'
}

//登录Api
const reqLogin = (data: reqLoginParam): any => {
    return request.post(API.LOGIN_URL,data);
}

export const EmployeeApi = {
    reqLogin
}