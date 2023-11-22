<template>
  <div class="allArticle-container">
    <magic-grid>
      <div class="card" style="width: 12%;" v-for="article in articleStore.articleList">
        <RouterLink :to="{ name: 'articleDetail', params: { articleId: `${article.articleId}` },}" style="color: black;">
          <!-- test image -->
          <img class="card-img-top" src="https://source.unsplash.com/random/?workout" alt="" />
          <div class="card-body">
            <h5 class="card-title">{{ article.title }}</h5>
            <div class="card-text">{{ article.content }}</div>
            <!-- <div>{{ article.regDate }}</div> -->
          </div>
        </RouterLink>
        <button class="btn" @click="clickHeart(article.articleId)">
          ♡ {{ article.liked }}
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
.allArticle-container {
  margin: 0 0 20px 0;
}


a:link {
  text-decoration: none;
}

a:hover {
  /* color: rgb(186, 41, 41) !important; */
  color: #52796f !important;
}

.btn:hover {
  color:rgb(186, 41, 41) !important;
}

.card .main {
  word-break: break-word;
}

</style>
