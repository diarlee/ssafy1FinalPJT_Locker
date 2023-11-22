<template>
  <div class="allArticle-container">
    <magic-grid>
      <div class="card" style="width: 12%;" v-for="article in articleStore.publicArticles">
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
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
          <path d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
          </svg> {{ article.liked }}
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
//   if (self.name != "reload") {
//   self.name = "reload";
//   self.location.reload(true);
// } else self.name = "";

  articleStore.getPublicArticles();
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
