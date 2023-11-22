import { ref, computed } from "vue";
import { defineStore } from "pinia";
import axios from 'axios'
import router from "@/router";

const REST_USER_API = `http://localhost:8080/api`

export const useUsersStore = defineStore("users", () => {
  const loginStatus = ref(false);
  const loginId = ref("");
  const username = ref("")
  const score = ref(0);

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
      .then((response) => {
        loginStatus.value = !loginStatus.value
        loginId.value = userId
        username.value = response.data.username
        score.value = response.data.score

        // sessionStorage.setItem("", response.data[""])
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
        loginStatus.value = !loginStatus.value;
        loginId.value = "";
        score.value = 0;
        console.log("로그아웃 성공");
        window.location.reload(true);
        // router.push({ name: 'home' });
      })
      .catch((err) => {
        console.log(err)
      })

  };

  // user 정보 불러오기
  const getUserInfo = () => {
  }

  return { loginStatus, loginId, username, score, signinFunc, loginFunc, logoutFunc, getUserInfo };
}, {persist: true}); // pinia로 login 상태 local storage에 저장
