<template>
  <div class="container">
      <form class="regist-form">
        <div class="mb-3">
          <!-- <label for="userId" class="col-form-label">아이디</label> -->
          <input type="text" class="form-control" id="userId" v-model="userId" placeholder="  UserId"/>
        </div>
        <div class="mb-3">
          <!-- <label for="password" class="col-form-label">비밀번호</label> -->
          <input type="text" class="form-control" id="password" name="title" v-model="password" placeholder="  Password"/>
        </div>
        <div class="mb-3">
          <!-- <label for="username" class="col-form-label">이름</label> -->
          <input type="text" class="form-control" id="username" name="title" v-model="username" placeholder="  UserName"/>
        </div>
        <div class="mb-3">
          <!-- <label for="email" class="col-form-label">이메일</label> -->
          <input type="text" class="form-control" id="email" name="title" v-model="email" placeholder="  Email"/>
        </div>
        <button class="btn" @click.prevent="signin">Sign Up</button>
        <!-- <RouterLink class="w-20 btn btn-outline-danger" :to="{ name: 'home' }">취소</RouterLink> -->
      </form>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { ref } from "vue";
import { useUsersStore } from "@/stores/users";
const store = useUsersStore();

const userId = ref("");
const password = ref("");
const username = ref("");
const email = ref("");

const signin = () => {
  // console.log("ing")
  store.signinFunc(userId.value, password.value, username.value, email.value);
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none;
}

.btn {
  background: #52796f;
  color: white !important;  
  padding: 10px;
}

.btn:hover {
  background: rgb(186, 41, 41) !important;
}

.container {
  left: 0;
  right: 0;
  margin: auto;
  margin-top: 70px;
  margin-bottom: 150px;
  width: 700px;
}

.regist-form {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

.mb-3 {
  width: 70%;
  padding: 0 0 10px 0;
}

input {
  width: 100%;
  height: 60px;
}


</style>
