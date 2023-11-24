<template>
  <div>
    <title>SSAFIT</title>
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Orbitron&display=swap"
      rel="stylesheet"
    />
    <header>
      <nav>
        <div class="container-fluid">
          <div style="font-size: 100px; font-family: 'Orbitron', sans-serif;">
            <RouterLink :to="{ name: 'home' }">LOCKER</RouterLink>
          </div>
          <div class="nav justify-content-center" style="padding: 0">
            <ul class="nav nav-underline">
              <li class="nav-item">
                <RouterLink class="nav-link" :to="{ name: 'home' }">HOME</RouterLink>
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" :to="{ name: 'youtube' }">VIDEO</RouterLink>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
                  ARTICLE </a>
                <ul class="dropdown-menu">
                  <li><RouterLink class="dropdown-item" :to="{ name: 'articleList' }">ALL</RouterLink></li>
                  <li><RouterLink class="dropdown-item" :to="{ name: 'articleCreate' }">CREATE</RouterLink></li>
                </ul>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">
                  USER </a>
                <ul class="dropdown-menu">
                  <li><RouterLink :to="{name: 'myHeart'}">HEART</RouterLink></li>
                  <li><RouterLink class="dropdown-item" :to="{ name: 'keysInfo' }">MY PAGE</RouterLink></li>
                </ul>
              </li>
            </ul>
            <div class="nav nav-underline" v-if="!store.loginStatus">
              <li class="nav-item">
                <RouterLink class="nav-link" :to="{ name: 'login' }"
                  >Check In</RouterLink
                >
              </li>
              <li class="nav-item">
                <RouterLink class="nav-link" :to="{ name: 'signin' }"
                  >Sign Up</RouterLink
                >
              </li>
            </div>
            <div class="nav nav-underline" v-else>
              <li class="nav-item">
                <button class="nav-link" type="submit" @click="logout">
                  Check Out
                </button>
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
  color: #52796f;
}

a {
  text-decoration: none !important;
}

a:hover {
  color: rgb(186, 41, 41);
  background-color: #ffffff;
}

button:hover {
  color: rgb(186, 41, 41);
}

.container-fluid {
  padding: 0 20px 0 20px !important;
  text-align: center;
}

.nav-link {
  color: #354f52;
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
