<template>
    <div class="articleDetail-container">
        <div class="check">{{ articleStore.article.checked }}</div>
        <div class="title">{{ articleStore.article.title }}</div>
        <div class="writer">{{ articleStore.article.writer }}</div>
        <div class="date">{{ articleStore.article.regDate }}</div>
        <div class="image">{{ articleStore.article.image }}</div>
        <div class="content">{{ articleStore.article.content }}</div>
        <button @click="changeStatus">{{ currentStatus }}</button>
        <button class="heart" @click="clickHeart">하트 {{ currentHeart }}</button>
        <RouterLink :to="{name: 'articleUpdate', params: {articleId: route.params.articleId}}">수정</RouterLink>
    </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { useArticleStore } from "@/stores/article";
import { useUsersStore } from "@/stores/users";
import { computed, onMounted } from "vue";
import axios from "axios";

const articleStore = useArticleStore();
const userStore = useUsersStore();

const route = useRoute();
const router = useRouter();

const currentStatus = computed (() => {
    return articleStore.article.public
})

const currentHeart = computed (() => {
    return articleStore.article.liked
})

const changeStatus = function () {
    articleStore.updatePublic(route.params.articleId)
}

const clickHeart = function () {
    articleStore.updateHeart(route.params.articleId, userStore.loginId)
}

onMounted(() => {
  articleStore.getArticle(route.params.articleId);
});
</script>

<style scoped></style>
