import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from 'axios'
import router from "@/router";

const REST_USER_API = `http://localhost:8080/api`

export const useUsersStore = defineStore("users", () => {
  const loginStatus = ref(false);

  const signinFunc = (userId, password, username, email) => {
    // console.log(userId, password, username, email);
    axios({
      // controller @RequestBody 필수!
      url: `${REST_USER_API}/signup`,
      method: 'POST',
      // headers: {
      //   "Content-Type": "application/json"
      // },
      data: {
        userId: userId,
        password: password,
        username: username,
        email: email
      }
    })
      .then(() => {
        console.log("회원가입 성공")
        router.push({ name: 'login' })
      })
      .catch((err) => {
        // 실패창 띄우기
        console.log("회원가입 실패")
        console.log(err)
      })
  };

  const loginFunc = (userId, password) => {
    // console.log(userId + password);
    axios({
      // controller @RequestBody 필수!
      url: `${REST_USER_API}/login`,
      method: 'POST',
      data: {
        id: userId,
        pwd: password
      }
    })
      .then(() => {
        loginStatus.value = true;
        console.log("로그인 성공");
        router.push({ name: 'home' });
      })
      .catch((err) => {
        // 실패창 띄우기
        console.log("로그인 실패")
        console.log(err)
      })
  };

  const logoutFunc = () => {
    axios.get(`${REST_USER_API}/logout`)
      .then(() => {
        loginStatus.value = false;
        console.log("로그아웃 성공");
        router.push({ name: 'home' });
      })
      .catch((err) => {
        console.log(err)
      })

  };

  return { loginStatus, signinFunc, loginFunc, logoutFunc };
});
