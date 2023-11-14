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
          <RouterLink
            :to="{
              name: 'videoDetail',
              params: { id: route.params.videoId, url: route.params.url },
            }"
            type="button"
            class="w-20 me-2 btn btn-outline-primary"
            >목록</RouterLink
          >
          <div class="d-flex">
            <RouterLink
              :to="{
                name: 'reviewUpdate',
                params: {
                  reviewId: route.params.reviewId,
                  videoId: route.params.videoId,
                  url: route.params.url,
                },
              }"
              type="button"
              class="float-end w-20 me-2 btn btn-outline-primary"
              >글 수정</RouterLink
            >
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
            <h3 class="fs-5 fw-medium"></h3>
            <div>{{ store.review.content }}</div>
          </div>
          <hr />
          <div class="p-2">
            <!-- review content -->
            <div>작성자: {{ store.review.writer }}</div>
            <div>작성일: {{ store.review.regDate }}</div>
            <div>조회수: {{ store.review.viewCnt }}</div>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { useReviewStore } from "@/stores/review";
import { onMounted } from "vue";
import axios from "axios";

const store = useReviewStore();

const route = useRoute();
const router = useRouter();

onMounted(() => {
  store.getReview(route.params.reviewId);
});

const deleteReview = function () {
  axios
    .delete(`http://localhost:8080/api/review/${route.params.reviewId}`)
    .then(() => {
      router.push({
        name: "videoDetail",
        params: { id: route.params.videoId, url: route.params.url },
      });
    });
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
