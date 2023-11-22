<template>
  <div class="articleList2-container">
    <div>
      <table class="table">
        <thead>
          <tr>
            <!-- <th scope="col">#</th> -->
            <th scope="col">제목</th>
            <th scope="col">쓰니</th>
            <!-- <th scope="col">등록일</th> -->
            <th scope="col">좋아요</th>
            <th scopr="col">인증</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="article in store.articleList_top4to8">
            <!-- <th scope="row"> {{ article.articleId }} </th> -->
            <td>
              <RouterLink class="r" :to="{name: 'articleDetail', params: {articleId: `${article.articleId}`}}">{{ article.title }}</RouterLink>
            </td>
            <td> {{ article.writer }} </td>
            <!-- <td> {{ article.regDate }} </td> -->
            <td style="text-align: center;"> {{ article.liked }} </td>
            <td> {{ article.checked }} </td>
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

.r:link {
  text-decoration: none;
}

.r {
  color: black !important;
}

.r:hover {
  color: rgb(186, 41, 41) !important;
}

</style>
