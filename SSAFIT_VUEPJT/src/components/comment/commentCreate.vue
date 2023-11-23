<template>
    <div class="container">
      <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 100%">
        <form
          @submit.prevent="createComment"
          style="width: 85%; margin: auto"
        >
          <div class="reviewform">
            <textarea class="form-control"
              v-model="comment.content"
              name="content"
              rows="3"
              placeholder="내용을 입력하세요"
            ></textarea>
            <div class="btn-container">
              <button type="submit" class="btn btn-regist">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                    <path d="M10.97 4.97a.235.235 0 0 0-.02.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05"/>
                  </svg> 
                  등록하기
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useRoute, useRouter } from "vue-router";
  import { RouterView, RouterLink } from "vue-router";
  import { useUsersStore } from "@/stores/users"
  import { useCommentStore } from "@/stores/comment";
  
  const route = useRoute();
  const userStore = useUsersStore();
  const commentStore = useCommentStore();
  
  const comment = ref({
    articleId: "",
    userId: "",
    content: "",
  });
  
  const createComment = function () {
    comment.value.articleId = route.params.articleId
    comment.value.userId = userStore.loginId
    commentStore.createComment(comment);
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
    width: 100%;
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    margin-top: 10px;
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
  }

  .btn {
    font-size: 14px;
    color: #ffffff;
    background: #52796F;
  }

  .btn:hover {
    color: #52796F;
    /* background: #ffffff; */
  }

  </style>
  