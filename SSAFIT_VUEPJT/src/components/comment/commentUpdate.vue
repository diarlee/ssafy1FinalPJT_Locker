<template>
    <div class="container">
      <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 100%">
        <form method="post" action="main" style="width:80%; margin:auto">
          <div class="reviewform">
            <textarea class="form-control" name="content" rows="3" v-model="comment.content" placeholder="내용을 입력하세요."></textarea>
            <div class="btn-container">
              <button class="btn-return" @click="goToCreate">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle-fill" viewBox="0 0 16 16">
                  <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0m3.5 7.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5z"/>
                </svg> 뒤로가기
              </button>
              <button type="submit" @click.prevent="updateComment" class="btn-update">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                  <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                  <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05"/>
                </svg> 업데이트
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { RouterView, RouterLink } from "vue-router";
  import { useRoute, useRouter } from "vue-router";
  import { ref, computed } from "vue";
  import { useUsersStore } from "@/stores/users";
  import { useCommentStore } from "@/stores/comment";
  
  const route = useRoute();
  const userStore = useUsersStore();
  const commentStore = useCommentStore();
  
  const commentIdd = computed (() => {
    return commentStore.status
  })
  
  const goToCreate = function () {
    commentStore.status = "create"
  }
  
  const comment = ref({
    articleId: route.params.articleId,
    commentId: commentIdd,
    userId: userStore.loginId,
    content: "",
  });
  
  const updateComment = function () {
    // console.log(comment.value)
    commentStore.updateComment(comment.value);
  };
  </script>
  
  <style scoped>

  a {
    text-decoration: none !important;
  }
  
  .container {
    width: 100%;
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    margin-top: 100px;
    margin-bottom: 200px;
  }


  #page-name {
    font-weight: bold;
    font-size: 2rem;
  }
  
  input {
    width: 100%;
  }

  .btn-container {
    margin-top: 20px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  </style>
  