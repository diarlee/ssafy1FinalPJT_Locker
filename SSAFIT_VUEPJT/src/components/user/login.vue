<template>
  <div class="container">
      <form class="login-form">
        <div class="mb-3">
          <!-- <label for="userId" class="col-form-label">아이디</label> -->
          <input type="text" class="form-control" id="userId" v-model="userId" placeholder="  Username"/>
        </div>
        <div class="mb-3">
          <!-- <label for="password" class="col-form-label">비밀번호</label> -->
          <input type="text" class="form-control" id="password" name="title" v-model="password" placeholder="  Password"/>
        </div>
        <button type="submit" class="btn" @click.prevent="login">CHECK IN</button>
        <!-- <RouterLink class="btn" :to="{ name: 'home' }">취소</RouterLink> -->
      </form>
  </div>
</template>

<script setup>
import Snowing from "@/components/common/snowing.vue"
import { RouterView, RouterLink } from "vue-router";
import { ref } from "vue";
import { useUsersStore } from "@/stores/users";
const store = useUsersStore();

const userId = ref("");
const password = ref("");

const login = () => {
  store.loginFunc(userId.value, password.value);
};
</script>

<style scoped>

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

.login-form {
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
