<template>
    <div class="container">
      <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
        <form
          class="reviewform"
          method="post"
          action="main"
          style="width: 80%; margin: auto"
        >
          <input type="hidden" name="act" value="doReviewUpdate" />
          <input type="hidden" name="videoId" value="${videoId }" />
          <input type="hidden" name="url" value="${url }" />
          <input type="hidden" name="reviewId" value="${review.reviewId }" />
          <div class="text-center">
            <span class="material-symbols-outlined">dialogs</span>
            <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 수정</h2>
            <span class="material-symbols-outlined">dialogs</span>
          </div>
          <hr class="mb-3" />
  
          <div class="mb-3">
            <label for="inputTitle" class="col-form-label">제목</label>
            <input
              type="text"
              class="form-control"
              id="inputEmail3"
              name="title"
              value="${review.title }"
            />
          </div>
  
          <div class="mb-4">
            <label for="inputContent" class="col-form-label">수정할 내용</label>
            <textarea class="form-control" type="text" name="content" rows="3">
  ${review.content }</textarea
            >
          </div>
  
          <button
            type="submit"
            @click="updateReview"
            class="w-20 me-2 btn btn-outline-primary"
          >
            수정
          </button>
          <button
            type="button"
            @click="goToReviewDetail"
            class="w-20 btn btn-outline-danger"
          >
            취소
          </button>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useReviewStore } from "@/stores/review";
  import router from "@/router";
  const store = useReviewStore();
  
  const updateReview = function () {
    // console.log("ing");
    store.updateReview();
  };
  
  const goToReviewDetail = function () {
    router.push({ name: "reviewDetail" });
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
  