<template>
  <div>
    <div>회원가입 페이지 입니다.</div>
    <div>
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
      <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous"
      />
    </div>
    <div>
      <div class="container">
        <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
          <form class="reviewform" method="post" action="main" style="width: 80%; margin: auto">
            <div class="text-center">
              <span class="material-symbols-outlined">dialogs</span>
              <h2 class="d-inline mb-3 fs-4 fw-semibold">회원가입</h2>
              <span class="material-symbols-outlined">dialogs</span>
            </div>
            <hr class="mb-3" />

            <div class="mb-3">
              <label for="userId" class="col-form-label">아이디</label>
              <input type="text" class="form-control" id="userId" v-model="userId" />
            </div>
            <div class="mb-3">
              <label for="password" class="col-form-label">비밀번호</label>
              <input type="text" class="form-control" id="password" name="title" v-model="password" />
            </div>
            <div class="mb-3">
              <label for="username" class="col-form-label">이름</label>
              <input type="text" class="form-control" id="username" name="title" v-model="username" />
            </div>
            <div class="mb-3">
              <label for="email" class="col-form-label">이메일</label>
              <input type="text" class="form-control" id="email" name="title" v-model="email" />
            </div>

            <!-- <RouterLink class="w-20 me-2 btn btn-outline-primary" :to="{ name: 'login' }" @click="signin">회원가입</RouterLink> -->
            <button class="w-20 me-2 btn btn-outline-primary" @click="signin">회원가입</button>
            <RouterLink class="w-20 btn btn-outline-danger" :to="{ name: 'home' }">취소</RouterLink>
            <!-- <button type="button" onclick="location.href='./main?act=reviewList&videoId=${videoId}&url=${url }'" class="w-20 btn btn-outline-danger">취소</button> -->
          </form>
        </div>
      </div>
    </div>
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
  text-decoration: none !important;
}

.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  left: 0;
  right: 0;
  margin: auto;
  margin-top: 100px;
  margin-bottom: 200px;
  width: 1400px;
}

.container-fluid {
  padding: 0 20px 0 20px !important;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

.main-image {
  width: 100%;
  height: 200px;
}

.search-box {
  width: 100%;
  padding: 10px;
}

input {
  width: 100%;
}

.video-list img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.video-box {
  width: 100%;
}
</style>
