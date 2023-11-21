<template>
  <div class="articleList1-container">
    <div class="articleList1">
            <div class="articleList" v-for="article in store.articleList_top4">
                <RouterLink :to="{name: 'articleDetail', params: {articleId: `${article.articleId}`}}">{{ article }}</RouterLink>
            </div>
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
  border: solid 1px;
  font-family: consolas;
}

</style>
