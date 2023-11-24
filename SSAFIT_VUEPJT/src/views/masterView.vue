<template>
  <div class="master-container" style="width: 95%; margin: 0 auto">
    <h1>관리자 페이지</h1>
    <br />
    <table class="table">
      <thead>
        <tr>
          <th scope="col">#articleId</th>
          <th scope="col">userId</th>
          <th scope="col">title</th>
          <th scope="col">regDate</th>
          <th scope="col">liked</th>
          <th scope="col">public</th>
          <th scope="col">checked</th>
        </tr>
      </thead>
      <tbody class="table-group-divider">
        <tr
          v-for="article in articleStore.articleList"
          :class="{ 'table-active': !article.checked }"
        >
          <th scope="row">
            {{ article.articleId }}
          </th>
          <td>{{ article.userId }}</td>
          <td><RouterLink
              class="link"
              :to="{
                name: 'articleDetail',
                params: { articleId: `${article.articleId}` },
              }"
              >{{ article.title }}</RouterLink></td>
          <td>{{ article.regDate }}</td>
          <td>{{ article.liked }}</td>
          <td>{{ article.public }}</td>
          <td v-if="article.checked == true">승인완료</td>
          <td v-else>
            <button @click="doApprove(article.articleId)">승인</button>
            <button @click="doDelete(article.articleId)">삭제</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <br />
  <br />
</template>

<script setup>
// import { ref, computed } from "vue";
import axios from "axios";
import { useUsersStore } from "@/stores/users";
import { useArticleStore } from "@/stores/article";
import { onMounted } from "vue";
import { RouterLink, RouterView } from "vue-router";
// import router from "@/router";

const userStore = useUsersStore();
const articleStore = useArticleStore();

const REST_ARTICLE_API = "http://localhost:8080/api/article";

const doApprove = function (articleId) {
  axios({
    url: `${REST_ARTICLE_API}/check`,
    method: "PUT",
    data: {
      userId: userStore.loginId,
      articleId: articleId,
    },
  })
    .then(() => {
      window.location.reload();
    })
    .catch((err) => {
      console.log(err);
    });
};

const doDelete = function (articleId) {
  axios.delete(`${REST_ARTICLE_API}/delete/${articleId}`).then(() => {
    window.location.reload();
  });
};

onMounted(() => {
  articleStore.getArticleList();
});
</script>

<style>
.link {
  color: black;
}
</style>
