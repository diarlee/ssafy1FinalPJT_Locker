<template>
  <div class="allArticle-container">
    <magic-grid>
      <div class="article" v-for="article in articleStore.articleList">
        <RouterLink
          :to="{
            name: 'articleDetail',
            params: { articleId: `${article.articleId}` },
          }"
        >
          <!-- test image -->
          <img src="https://source.unsplash.com/random/?workout" alt="" />
          <div class="main">{{ article.title }}</div>
          <div class="main">{{ article.content }}</div>
          <div>{{ article.regDate }}</div>
        </RouterLink>
        <button @click="clickHeart(article.articleId)">
          {{ article.liked }}
        </button>
      </div>
    </magic-grid>
  </div>
</template>

<script setup>
import { useArticleStore } from "@/stores/article";
import { useUsersStore } from "@/stores/users";
import { RouterView, RouterLink } from "vue-router";
import { ref, onMounted } from "vue";

const articleStore = useArticleStore();
const userStore = useUsersStore();

const clickHeart = function (articleId) {
  articleStore.updateHeart(articleId, userStore.loginId);
};

onMounted(() => {
  articleStore.getArticleList();
});
</script>

<style scoped>
.article {
  border: 1px solid;
  border-radius: 2rem;
  display: flex;
  flex-direction: column;
  width: 12%;
  /* height: 500px; */
}

.article img {
  width: 90%;
  height: 200px;
}

.article .main {
  word-break: break-word;
}
</style>
