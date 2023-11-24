<template>
  <div class="container">
    <div class="text-wrap fw-bold">
      <div class="btn-container" style="margin-bottom: 5px">
        <RouterLink
          type="button"
          class="btn btn-return"
          :to="{
            name: 'videoList',
            param: { videoType: route.params.videoType, id: route.params.id },
          }"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-box-arrow-left"
            viewBox="0 0 16 16"
          >
            <path
              fill-rule="evenodd"
              d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0z"
            />
            <path
              fill-rule="evenodd"
              d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"
            />
          </svg>
        </RouterLink>
        <button
          class="btn btn-delete"
          @click="deleteVideo"
          style="margin-left: 2px"
        >
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-trash3-fill"
            viewBox="0 0 16 16"
          >
            <path
              d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5m-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5M4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06Zm6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528ZM8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5"
            />
          </svg>
        </button>
      </div>
      <div class="text-center">
        <iframe
          width="560"
          height="315"
          :src="videoStore.video.url"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
          allowfullscreen
        ></iframe>
        <!-- <div class="mt-1 mb-1 d-flex text-wrap">
          {{ videoStore.video.title }}
        </div> -->
        <div class="desc justify-content-between d-flex">
          <span class="fw-normal text-body-secondary">{{
            videoStore.video.channelName
          }}</span>
          <span style="color: darkslategray">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="16"
              height="16"
              fill="currentColor"
              class="bi bi-eye-fill"
              viewBox="0 0 16 16"
            >
              <path d="M10.5 8a2.5 2.5 0 1 1-5 0 2.5 2.5 0 0 1 5 0" />
              <path
                d="M0 8s3-5.5 8-5.5S16 8 16 8s-3 5.5-8 5.5S0 8 0 8m8 3.5a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7"
              />
            </svg>
            {{ videoStore.video.viewCnt }}
          </span>
        </div>
      </div>
    </div>
    <div class="review-box shadow rounded bg-light">
      <div v-for="review in reviewStore.reviewList">
        <div class="rv-status">
          <div class="rvId">
            # {{ review.reviewId }}. {{ review.writer }} 님
          </div>
          <div class="writer-date">
            <div class="rvDate">{{ review.regDate }}</div>
          </div>
        </div>
        <div class="rv-content">
          <div class="content">{{ review.content }}</div>
          <div class="btn-cmt">
            <button
              class="btn btn-rv-update"
              @click.prevent="changeStatus(review.reviewId)"
              v-show="review.userId == userStore.loginId"
              style="margin-right: 2px"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-plus-circle"
                viewBox="0 0 16 16"
              >
                <path
                  d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"
                />
                <path
                  d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4"
                />
              </svg>
            </button>
            <button
              class="btn btn-rv-delete"
              @click="deleteReview(review.reviewId)"
              v-show="review.userId == userStore.loginId"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                width="16"
                height="16"
                fill="currentColor"
                class="bi bi-x-circle-fill"
                viewBox="0 0 16 16"
              >
                <path
                  d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293z"
                />
              </svg>
            </button>
          </div>
        </div>
      </div>
    </div>
    <reviewCreate v-if="reviewStore.status == 'create'"></reviewCreate>
    <reviewUpdate v-else></reviewUpdate>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { useVideoStore } from "@/stores/video";
import { useReviewStore } from "@/stores/review";
import { useUsersStore } from "@/stores/users";
import axios from "axios";
import reviewCreate from "@/components/review/reviewCreate.vue";
import reviewUpdate from "@/components/review/reviewUpdate.vue";
import { storeToRefs } from "pinia";

const route = useRoute();
const router = useRouter();

const videoStore = useVideoStore();
const reviewStore = useReviewStore();
const userStore = useUsersStore();

const deleteVideo = function () {
  // console.log(route.params.id)
  axios
    .delete(`http://localhost:8080/api/video/delete/${route.params.id}`)
    .then(() => {
      router.push({
        name: "videoList",
        params: { videoType: route.params.videoType },
      });
    });
};

const changeStatus = function (reviewId) {
  reviewStore.status = reviewId;
  // console.log(reviewStore.status)
};

const deleteReview = function (reviewId) {
  axios
    .delete(`http://localhost:8080/api/review/delete/${reviewId}`)
    .then(() => {
      location.reload();
    });
};

onMounted(() => {
  videoStore.getVideo(route.params.id);
  reviewStore.getReviewList(route.params.id);
  // console.log(store.reviewList)
  // console.log(route.params.id);
});
</script>

<style scoped>
.container {
  width: 100%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 70px;
  margin-bottom: 140px;
}

.text-center {
  margin-bottom: 20px;
}

.btn-return {
  color: black;
}

.btn-delete {
  background: #ffffff;
  color: #52796f;
}

.btn-return:hover {
  background: #ffffff;
  color: #52796f;
}

.btn-delete:hover {
  background: black;
  color: #ffffff !important;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}

.review-box {
  width: 87%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-top: 30px;
  /* align-content: center; */
}

.rv-status {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  font-size: 10px;
  margin: 2px 10px 2px 10px;
}

.rv-content {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin: 20px;
}
.btn-rv-update {
  color: #52796f;
  margin: 0 1px 0 1px;
}

.btn-rv-update:hover {
  color: #ffffff;
  background: #52796f;
}
.btn-rv-delete {
  color: #52796f;
  margin: 0 1px 0 1px;
}

.btn-rv-delete:hover {
  background: black;
  color: #ffffff;
}

.desc {
  margin-top: 13px;
}
</style>
