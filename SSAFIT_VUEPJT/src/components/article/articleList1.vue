<template>
  <div class="articleList1-container">
    <div>
      <table class="table">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col"> 제목 </th>
            <th scope="col"> 쓰니 </th>
            <th scope="col"> 등록일 </th>
            <th scope="col"> 좋아요 </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="article in store.articleList_top4">
            <th scope="row"> {{ article.articleId }} </th>
            <td>
              <RouterLink class="r" :to="{name: 'articleDetail', params: {articleId: `${article.articleId}`}}">{{ article.title }}</RouterLink>
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
  store.getArticleList_top4();
});
</script>

<style scoped>
.articleList1-container {
  font-family: consolas;
  margin: 0 10px 0 0;
}

.r:link {
  /* color: #52796F; */ /* color 미적용, 이미 작업이 수행된 링크는 적용이 안됨  */
  text-decoration: none;
}

</style>
