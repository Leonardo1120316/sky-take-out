<template>
  <div class="login-box">
    <div class="center-box">
      <a-row>
        <a-col :md="15">
          <div class="left">
            <img src="/login/login.png" alt="" class="login-img"/>
          </div>
        </a-col>
        <a-col :md="9">
          <div class="right d-flex align-center justify-center">
            <div class="right-box w-100">
              <div class="text-center">
                <img src="/logo.png" alt="" class="logo-img">
              </div>
              <loginCard></loginCard>
            </div>
          </div>
        </a-col>
      </a-row>
    </div>
  </div>
</template>

<script lang="ts" setup>
import loginCard from "./loginCard/index.vue";
</script>

<style scoped>
.login-box {
  width: 100%;
  height: 100%;
  background-color: #333;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 1% 2%;
}
.center-box {
  background: #fff;
  border-radius: 10px;
  width: 55%;
  margin: auto;
}
.login-img{
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
}
.logo-img{
  width: 60%;
}
.right{
  height: 100%;
  padding: 0 15%;
}

@media screen and (max-width:1200px){
    .right{
      padding: 0 5%;
    }
    .center-box{
      width: 80%;
    }
}
</style>