<template>
    <div class="master-container">
        <div v-for="article in notCheckedArticles">
            <div>{{ article }}
            <button @click="doApprove(article.articleId)">승인하기</button>
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from "vue";
import axios from "axios";
import { useUsersStore } from "@/stores/users"
import { onMounted } from "vue";
import router from "@/router";

const REST_ARTICLE_API = "http://localhost:8080/api/article";

const notCheckedArticles = ref([]);
const getNotChecked = function () {
    axios.get(`${REST_ARTICLE_API}/notCheck`)
        .then((response) => {
            notCheckedArticles.value = response.data;
            // console.log(notCheckedArticles.value)
        })
};

const userStore = useUsersStore();

const doApprove = function (articleId) {
    axios({
      url: `${REST_ARTICLE_API}/check`,
      method: "PUT",
      data: {
        userId: userStore.loginId,
        articleId: articleId
      },
    })
      .then(() => {
        // router.push({ name: "home" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

onMounted(() => {
    getNotChecked()
});
</script>

<style></style>