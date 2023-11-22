<template>
    <div class="allArticle-container">
        <magic-grid>
            <div class="article" v-for="article in store.articleList">
                <RouterLink :to="{ name: 'articleDetail', params: { articleId: `${article.articleId}` } }">
                    <!-- test image -->
                    <img src="https://source.unsplash.com/random/?workout" alt="" style="width: 90%; height: 200px;">
                    <div>{{ article.title }}</div>
                    <div>{{ article.content }}</div>
                    <div>{{ article.regDate }}</div>
                    <div>{{ article.checked }}</div>
                </RouterLink>
                <button>{{ article.liked }}</button>
            </div>
        </magic-grid>
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
.article {
    border: 1px solid;
    border-radius: 2rem;
    display: flex;
    flex-direction: column;
}
</style>