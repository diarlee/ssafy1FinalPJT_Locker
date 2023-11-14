<template>
    <div class="container">
      <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
        <form class="reviewform" style="width: 80%; margin: auto">
          <div class="text-center">
            <span class="material-symbols-outlined">dialogs</span>
            <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 상세</h2>
            <span class="material-symbols-outlined">dialogs</span>
          </div>
  
          <hr class="mb-3" />
  
          <div class="d-flex justify-content-between">
            <button 
              type="button"
              @click="goToVideoDetail"
              class="w-20 me-2 btn btn-outline-primary"
            >
              목록
            </button>
            <div class="d-flex">
              <button
                type="button"
                @click="goToReviewUpdate"
                class="float-end w-20 me-2 btn btn-outline-primary"
              >
                글 수정
              </button>
              <button
                type="button"
                @click="deleteReview"
                class="float-end w-20 btn btn-outline-danger"
              >
                글 삭제
              </button>
            </div>
          </div>
  
          <div class="shadow-sm mb-3 text-center border p-4 mt-3">
            <div class="p-2">
              <h3 class="fs-5 fw-medium">${review.content }</h3>
              <div>작성자: ${review.writer }</div>
              <div>작성일: ${review.regDate }</div>
              <div>조회수: ${review.viewCnt }</div>
            </div>
            <hr />
            <div class="p-2">
              <div>${review.content }</div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </template>
  
  <script setup>
  import { useRoute, useRouter } from "vue-router";
  import { useReviewStore } from "@/stores/review";
  import { onMounted } from "vue";
  import axios from "axios";
  import router2 from "@/router";
  
  const store = useReviewStore();
  
  const route = useRoute();
  const router = useRouter();

  onMounted(() => {
    store.getReview(route.params.id);
  });

  const deleteReview = function () {
    axios
      .delete(`http://localhost:8080/api/review/${route.params.id}`)
      .then(() => {
        router.push({ name: "reviewList" });
      });
  };
  
  const updateBoard = function () {
    router.push({ name: "reviewUpdate" });
  };
  
  const goToVideoDetail = function () {
    router2.push({ name: "videoDetail" });
  };
  
  const goToReviewUpdate = function () {
    router2.push({ name: "reviewUpdate" });
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
  