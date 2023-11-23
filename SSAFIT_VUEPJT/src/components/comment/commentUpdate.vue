<template>
    <div class="container">
      <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
        <form
          class="reviewform"
          method="post"
          action="main"
          style="width: 80%; margin: auto"
        >
          <div class="text-center">
            <span class="material-symbols-outlined">dialogs</span>
            <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 수정</h2>
            <span class="material-symbols-outlined">dialogs</span>
          </div>
          <hr class="mb-3" />
  
          <div class="mb-4">
            <label for="inputContent" class="col-form-label">수정할 내용</label>
            <textarea
              class="form-control"
              type="text"
              name="content"
              rows="3"
              v-model="comment.content"
            >
            </textarea>
          </div>
  
          <button
            type="submit"
            @click.prevent="updateComment"
            class="w-20 me-2 btn btn-outline-primary"
          >
            수정
          </button>
          <button @click="goToCreate">취소</button>
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
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    list-style: none;
  }
  
  a {
    text-decoration: none !important;
  }
  
  .container {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    left: 0;
    right: 0;
    margin: auto;
    margin-top: 100px;
    margin-bottom: 200px;
    width: 1400px;
  }
  
  #page-name {
    font-weight: bold;
    font-size: 2rem;
  }
  
  input {
    width: 100%;
  }
  </style>
  