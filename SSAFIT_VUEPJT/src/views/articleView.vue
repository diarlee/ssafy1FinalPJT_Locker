<template>
    <div class="allArticle-container">
        <div v-for="article in store.articleList">
            <RouterLink :to="{name: 'articleDetail', params: {articleId: `${article.articleId}`}}">{{ article }}</RouterLink>
        </div>
    </div>
</template>

<script setup>
import { useArticleStore } from "@/stores/article";
import { RouterView, RouterLink } from "vue-router";
import { onMounted } from "vue";

const store = useArticleStore();

onMounted(() => {
    store.getArticleList();
});
</script>

<style scoped>

</style>