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
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Orbitron&display=swap" rel="stylesheet">
    <header>
      <nav>
        <div class="container-fluid">
          <div style="font-size: 100px; font-family: 'Orbitron', sans-serif;">
          <RouterLink :to="{ name: 'home' }">LOCKER</RouterLink>
          <!-- <a class="navbar-brand" id="page-name" href="./main?act=main">SSAFIT</a> -->
          </div>
            <div class="nav justify-content-center" style="padding: 0;">
                <ul class="nav nav-underline">
                  <li class="nav-item">
                    <RouterLink class="nav-link" :to="{ name: 'home' }">HOME</RouterLink>
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
                </ul>
              <div class="nav nav-underline" v-if="!store.loginStatus">
                <li class="nav-item">
                  <RouterLink class="nav-link" :to="{ name: 'signin' }">회원가입</RouterLink>
                    <!-- <a class="nav-link" href="/user/login.html">회원가입</a> -->
                </li>
                <li class="nav-item">
                  <RouterLink class="nav-link" :to="{ name: 'login' }">로그인</RouterLink>
                    <!-- <a class="nav-link" href="/user/login.html">로그인</a> -->
                </li>
              </div>
              <div class="nav nav-underline" v-else>
                <li class="nav-item">
                  <button class="nav-link" type="submit" @click="logout">로그아웃</button>
                    <!-- <RouterLink class="nav-link" :to="{ name: 'home' }" @click="logout">로그아웃</RouterLink> -->
                    <!-- <a class="nav-link" href="/user/login.html">로그아웃</a> -->
                </li>
              </div>
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
  padding: 20px;
  box-sizing: border-box;
  list-style: none;
  background-color: #ffffff;
  color: #52796F;
}

a {
  text-decoration: none !important;
}

a:hover {
  color:rgb(186, 41, 41);
}

button:hover {
  color:rgb(186, 41, 41);
}

.container-fluid {
  padding: 0 20px 0 20px !important;
  text-align: center;
}

.nav-link {
  color: #354F52;
  font-size: 18px;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}


</style>
