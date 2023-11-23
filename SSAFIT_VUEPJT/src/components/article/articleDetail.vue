<template>
  <div class="articleDetail-container">
    <div class="title">
      <h3>{{ articleStore.article.title }}</h3>
    </div>
    <div class="writer-date">
      <div class="writer">{{ articleStore.article.writer }}</div>
      <div class="date">{{ articleStore.article.regDate }}</div>
    </div>
    <div class="check">{{ articleStore.article.checked }}</div>
    <div class="image">{{ articleStore.article.image }}</div>
    <div class="content">{{ articleStore.article.content }}</div>
    <button @click="changeStatus">{{ currentStatus }}</button>
    <button class="heart" @click="clickHeart">하트 {{ currentHeart }}</button>
    <RouterLink
      :to="{
        name: 'articleUpdate',
        params: { articleId: route.params.articleId },
      }"
      >수정</RouterLink
    >
  </div>
  <div class="commentList-container">
    <table class="table">
      <thead>
        <tr style="text-align: center">
          <th scope="col">번호</th>
          <th scope="col">작성자</th>
          <th scope="col">내용</th>
          <th scope="col">작성시간</th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="comment in commentStore.commentList"
          style="text-align: center"
        >
          <td>{{ comment.commentId }}</td>
          <td>{{ comment.writer }}</td>
          <td>{{ comment.content }}</td>
          <td>{{ comment.regDate }}</td>
          <td>
            <button
              @click.prevent="changeStatus(comment.commentId)"
              v-show="comment.userId == userStore.loginId"
            >
              수정
            </button>
            <button
              @click="deleteComment(comment.commentId)"
              v-show="comment.userId == userStore.loginId"
            >
              삭제
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="btn-container">
    <RouterLink
      type="button"
      class="btn"
      :to="{
        name: 'articleList',
      }"
      >돌아가기
    </RouterLink>
  </div>
  <commentCreate v-if="commentStore.status == 'create'"></commentCreate>
  <commentUpdate v-else></commentUpdate>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { useCommentStore } from "@/stores/comment";
import { useArticleStore } from "@/stores/article";
import { useUsersStore } from "@/stores/users";
import { computed, onMounted } from "vue";
import commentCreate from "@/components/comment/commentCreate.vue"
import commentUpdate from "@/components/comment/commentUpdate.vue"

const commentStore = useCommentStore();
const articleStore = useArticleStore();
const userStore = useUsersStore();

const route = useRoute();

const currentStatus = computed(() => {
  return articleStore.article.public;
});

const currentHeart = computed(() => {
  return articleStore.article.liked;
});

const changeStatus = function () {
  articleStore.updatePublic(route.params.articleId);
};

const clickHeart = function () {
  articleStore.updateHeart(route.params.articleId, userStore.loginId);
};

onMounted(() => {
  articleStore.getArticle(route.params.articleId);
  commentStore.getCommentList(route.params.articleId)
});
</script>

<style scoped>
.articleDetail-container {
  margin: 20px 0 20px 0;
  border: 1px solid black;
  padding: 10px;
}

.title {
  text-align: center;
}

.writer-date {
  display: flex;
  flex-direction: row;
  justify-content: end;
}

.writer {
  padding: 0 10px 0 0;
}
</style>
