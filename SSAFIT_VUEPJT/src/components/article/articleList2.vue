<template>
  <div class="articleList2-container">
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">제목</th>
            <th scope="col">쓰니</th>
            <th scope="col">등록일</th>
            <th scope="col">좋아요</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="article in store.articleList_top4to8">
            <th scope="row"> {{ article.articleId }} </th>
            <td>
              <RouterLink :to="{name: 'articleDetail', params: {articleId: `${article.articleId}`}}">{{ article.title }}</RouterLink>
            </td>
            <td> {{ article.writer }} </td>
            <td> {{ article.regDate }} </td>
            <td> {{ article.liked }} </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { useArticleStore } from "@/stores/article";
import { RouterView, RouterLink } from "vue-router";
import { onMounted } from "vue";

const store = useArticleStore();

onMounted(() => {
  store.getArticleList_top4to8();
});
</script>

<style scoped>
.articleList2-container {
  font-family: consolas;
}

a:link {
  text-decoration: none;
}

</style>
