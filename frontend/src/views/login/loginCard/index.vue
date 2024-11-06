<template>
  <div class="login-card-box">
    <div class="form-box">
      <a-form :model="formValue">
        <a-form-item>
          <a-input v-model:value="formValue.username" placeholder="账号">
            <template #prefix>
              <UserOutlined class="login-icon" />
            </template>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-input
            v-model:value="formValue.password"
            type="password"
            placeholder="密码"
          >
            <template #prefix>
              <LockOutlined class="login-icon" />
            </template>
          </a-input>
        </a-form-item>
        <a-form-item>
          <a-button type="primary" html-type="submit" @click="login()"> 登录 </a-button>
        </a-form-item>
      </a-form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { UserOutlined, LockOutlined } from "@ant-design/icons-vue";
import { reactive, UnwrapRef, ref } from "vue";
import { EmployeeApi } from "@/api/employee";
import './type'
import EmployeeStore from "@/store/modules/employee";

const formValue: UnwrapRef<FormValue> = reactive({
  username: "",
  password: ""
});

const login = () => {
  EmployeeApi.reqLogin(formValue).then((res:any)=>{
    const employeeStore = EmployeeStore();
    employeeStore.setToken(res.token);
    console.log(employeeStore.$state.token);
  })
}

</script>

<style scoped>
.login-card-box {
  background-color: #fff;
}
.login-icon {
  font-size: 14px;
  color: rgba(0, 0, 0, 0.25);
}
.form-box :where(.css-dev-only-do-not-override-1hsjdkk).ant-form-item {
  margin-bottom: 10px;
  margin-top: 10px;
}
.ant-input-affix-wrapper {
  padding: 3px;
  border: 0px;
  border-bottom: 1px solid #e9e9e8;
  border-radius: 0;
  box-shadow: none;
}
:where(.css-dev-only-do-not-override-1hsjdkk).ant-input-affix-wrapper:not(
    .ant-input-affix-wrapper-disabled
  ):hover {
  border-color: #ffc200;
}
:where(.css-dev-only-do-not-override-1hsjdkk).ant-btn-primary {
  color: black;
  border-radius: 20px;
  width: 100%;
  background-color: #ffc200;
}
:where(.css-dev-only-do-not-override-1hsjdkk).ant-btn-primary:not(:disabled):hover{
  color: black;
  background-color: #ffc200;
}
</style>