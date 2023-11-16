<template>
  <div>
    <title>SSAFIT</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <header>
      <nav class="navbar shadow navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <RouterLink class="navbar-brand" id="page-name" :to="{ name: 'home' }">SSAFIT</RouterLink>
          <!-- <a class="navbar-brand" id="page-name" href="./main?act=main">SSAFIT</a> -->
          <div class="justify-end d-flex" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px">
              <li class="nav-item">
                <RouterLink class="nav-link active" aria-current="page" :to="{ name: 'home' }">HOME</RouterLink>
                <!-- <a class="nav-link active" aria-current="page" href="/board.main.jsp">HOME</a> -->
              </li>

              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> 사용자 </a>
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="/user/likeList.html">찜</a>
                  </li>
                  <li>
                    <a class="dropdown-item" href="/user/follow.html">팔로우</a>
                  </li>
                </ul>
              </li>
              <div style="display: flex">
                <div v-if="!store.loginStatus" style="display: flex">
                  <li class="nav-item">
                    <RouterLink class="nav-link" :to="{ name: 'signin' }">회원가입</RouterLink>
                    <!-- <a class="nav-link" href="/user/login.html">회원가입</a> -->
                  </li>
                  <li class="nav-item">
                    <RouterLink class="nav-link" :to="{ name: 'login' }">로그인</RouterLink>
                    <!-- <a class="nav-link" href="/user/login.html">로그인</a> -->
                  </li>
                </div>
                <div v-else>
                  <li class="nav-item">
                    <button type="submit" class="nav-link"  @click="logout">로그아웃</button>
                    <!-- <RouterLink class="nav-link" :to="{ name: 'home' }" @click="logout">로그아웃</RouterLink> -->
                    <!-- <a class="nav-link" href="/user/login.html">로그아웃</a> -->
                  </li>
                </div>
              </div>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { computed } from "vue";
import { useUsersStore } from "@/stores/users";
const store = useUsersStore();

const logout = () => {
  store.logoutFunc();
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

.container-fluid {
  padding: 0 20px 0 20px !important;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}

</style>
