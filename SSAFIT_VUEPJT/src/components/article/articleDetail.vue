<template>
  <div class="container">
    <div class="articleDetail-container">
        <RouterLink type="button" class="btn btn-return" :to="{ name: 'articleList', }">
          <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
          <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
          </svg> -->
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
            <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"/>
            <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
          </svg>
        </RouterLink>
        <div class="status">
          <div class="public" v-if="currentStatus==true" @click=changeArticleStatus>public</div>
          <div class="public" v-else="currentStatus==false" @click=changeArticleStatus>private</div>
          <div class="writer-date">
            <div class="writer">{{ articleStore.article.writer }}</div>
            <div class="date">{{ articleStore.article.regDate }}</div>
            <div class="check" v-if="articleStore.article.checked==false">인증이 안 된 글입니다.</div>
            <div class="check" v-else="articleStore.article.checked==true">인증 된 글입니다.</div>
          </div>
      </div>
      <div class="title">
        <hr class="mb-3">
        <h3 style="margin: 0;">{{ articleStore.article.title }}</h3>
        <hr class="mb-3">
      </div>
      <div class="image-content">
        <div class="image"><img :src="`http://localhost:8080/api/article/image/${articleStore.article.image}`" alt=""></div>
        <br/>
        <div class="content">{{ articleStore.article.content }}</div>
      </div>
      <hr class="mb-3">
      <div class="btn-public-heart">
        <button class="btn btn-heart" @click="clickHeart"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-suit-heart" viewBox="0 0 16 16">
          <path d="m8 6.236-.894-1.789c-.222-.443-.607-1.08-1.152-1.595C5.418 2.345 4.776 2 4 2 2.324 2 1 3.326 1 4.92c0 1.211.554 2.066 1.868 3.37.337.334.721.695 1.146 1.093C5.122 10.423 6.5 11.717 8 13.447c1.5-1.73 2.878-3.024 3.986-4.064.425-.398.81-.76 1.146-1.093C14.446 6.986 15 6.131 15 4.92 15 3.326 13.676 2 12 2c-.777 0-1.418.345-1.954.852-.545.515-.93 1.152-1.152 1.595zm.392 8.292a.513.513 0 0 1-.784 0c-1.601-1.902-3.05-3.262-4.243-4.381C1.3 8.208 0 6.989 0 4.92 0 2.755 1.79 1 4 1c1.6 0 2.719 1.05 3.404 2.008.26.365.458.716.596.992a7.55 7.55 0 0 1 .596-.992C9.281 2.049 10.4 1 12 1c2.21 0 4 1.755 4 3.92 0 2.069-1.3 3.288-3.365 5.227-1.193 1.12-2.642 2.48-4.243 4.38z"/>
        </svg> {{ currentHeart }}</button>
        <div class="btn-container">
          <RouterLink class="btn btn-update" :to="{ name: 'articleUpdate', params: { articleId: route.params.articleId }, }" v-show="articleStore.article.userId == userStore.loginId">수정</RouterLink>
          <button class="btn btn-remove"
                @click.prevent="removeArticle(articleStore.article.articleId)"
                v-show="articleStore.article.userId == userStore.loginId"
              >
                삭제
              </button>
        </div>
      </div> 
    </div>
    <div class="comment-box shadow rounded bg-light">
      <div v-for="comment in commentStore.commentList">
        <div class="cmt-status">
          <div class="cmtId"> # {{ comment.commentId }}. {{ comment.writer }} 님</div>
          <div class="writer-date">
            <!-- <div class="cmtWiter"></div> -->
            <div class="cmtDate">{{ comment.regDate }}</div>
          </div>
        </div>
        <div class="cmt-content">
          <div class="content">{{ comment.content }}</div>
          <div class="btn-cmt">
            <button class="btn btn-cmt-update"
                @click.prevent="goToUpdate(comment.commentId)"
                v-show="comment.userId == userStore.loginId"
              >
              <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-wrench-adjustable-circle" viewBox="0 0 16 16">
                <path d="M12.496 8a4.491 4.491 0 0 1-1.703 3.526L9.497 8.5l2.959-1.11c.027.2.04.403.04.61Z"/>
                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-1 0a7 7 0 1 0-13.202 3.249l1.988-1.657a4.5 4.5 0 0 1 7.537-4.623L7.497 6.5l1 2.5 1.333 3.11c-.56.251-1.18.39-1.833.39a4.49 4.49 0 0 1-1.592-.29L4.747 14.2A7 7 0 0 0 15 8m-8.295.139a.25.25 0 0 0-.288-.376l-1.5.5.159.474.808-.27-.595.894a.25.25 0 0 0 .287.376l.808-.27-.595.894a.25.25 0 0 0 .287.376l1.5-.5-.159-.474-.808.27.596-.894a.25.25 0 0 0-.288-.376l-.808.27.596-.894Z"/>
              </svg> -->
              <!-- <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-r-circle" viewBox="0 0 16 16">
                <path d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M5.5 4.002h3.11c1.71 0 2.741.973 2.741 2.46 0 1.138-.667 1.94-1.495 2.24L11.5 12H9.98L8.52 8.924H6.836V12H5.5zm1.335 1.09v2.777h1.549c.995 0 1.573-.463 1.573-1.36 0-.913-.596-1.417-1.537-1.417z"/>
              </svg> -->
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-circle" viewBox="0 0 16 16">
                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"/>
              </svg>
              </button>
              <button class="btn btn-cmt-delete"
                @click.prevent="removeComment(comment.commentId)"
                v-show="comment.userId == userStore.loginId"
              >
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293z"/>
              </svg>
              </button>
          </div>
        </div>
      </div>
    </div>
  <commentCreate v-if="commentStore.status == 'create'"></commentCreate>
  <commentUpdate v-else></commentUpdate>
</div>
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

const changeArticleStatus = function () {
  articleStore.updatePublic(route.params.articleId);
};

const clickHeart = function () {
  articleStore.updateHeart(route.params.articleId, userStore.loginId);
};

const goToUpdate = function (commentId) {
    commentStore.status = commentId
    // console.log(commentStore.status)
}

const removeArticle = function (articleId) {
  articleStore.deleteArticle(articleId);
}

const removeComment = function (commentId) {
    commentStore.deleteComment(commentId, route.params.articleId)
}

onMounted(() => {
  articleStore.getArticle(route.params.articleId);
  commentStore.getCommentList(route.params.articleId)
});
</script>

<style scoped>

.container {
  width: 90%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.articleDetail-container {
  width: 90%;
  margin: 20px;
  /* border: 1px solid black; */
  padding: 10px;
}

.btn-return {
  margin-bottom: 20px;
  padding: 0;
}

.btn-container {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
}

.mb-3 {
  margin: 10px !important;
}

.title {
  text-align: center;
}

.status {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 10px;
}
.public {
  padding: 0 10px 0 10px;
}
.writer-date {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}

.writer {
  padding: 0 6px 0 6px;
}

.date {
  padding: 0 6px 0 6px;
}

.check {
  padding: 0 10px 0 6px;
}


.image-content {
  width: 100%;
  height: 70%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-content: center;
  text-align: center;
  padding: 20px;
}

.btn-public-heart {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.btn-heart {
  color: rgb(186, 41, 41);
}

.btn-heart:hover {
  background: rgb(186, 41, 41);
  color: #ffffff !important;
}

.btn-update {
  background: #ffffff;
  color: #52796f;
  padding: 10px;
}
.btn-remove {
  background: #ffffff;
  color: rgb(186, 41, 41);
  padding: 10px;
}

.btn-update:hover {
  color: #ffffff;
  background: #52796f;
}

.btn-remove:hover {
  color: #ffffff;
  background: rgb(150, 41, 41);
}

.comment-box {
  width: 87%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  /* align-content: center; */
}

.cmt-status {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 10px; 
  margin: 2px 10px 2px 10px;
}

.cmt-content {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin: 20px;
}
.btn-cmt-update{
  color: #52796f;
  margin: 0 1px 0 1px;
}

.btn-cmt-update:hover {
  color: #ffffff;
  background: #52796f;
}
.btn-cmt-delete {
  color: #52796f;
  margin: 0 1px 0 1px;
}

.btn-cmt-delete:hover {
  background: black;
  color: #ffffff;
}


</style>
