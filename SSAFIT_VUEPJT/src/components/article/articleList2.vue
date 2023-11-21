<template>
    <div class="articleList2-container">
        <div class="articleList2">
            <div class="articleList" v-for="article in store.articleList_top4to8"> 
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
    store.getArticleList_top4to8();
});
</script>

<style scoped>
.articleList2-container{
    border: solid 1px;
}

.articleList2 {
    display: flex;
    justify-content: space-around;
}

.articleList2 .articleList {
    width: 20%;
}
</style>