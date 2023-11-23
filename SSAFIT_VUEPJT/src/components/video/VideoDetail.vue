<template>
  <div class="container">
    <div class="text-wrap fw-bold">
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
        <div class="mt-1 mb-1 d-flex text-wrap">
          {{ videoStore.video.title }}
        </div>
        <div class="justify-content-between d-flex">
          <span> 조회수 {{ videoStore.video.viewCnt }} </span>
          <span class="fw-normal text-body-secondary">{{
            videoStore.video.channelName
          }}</span>
        </div>
      </div>
      <button @click="deleteVideo" v-show="userStore.loginId == 'master'">삭제</button>
    </div>
    <form class="reviewform" style="width: 80%; margin: auto">
      <table class="table">
        <thead>
          <tr style="text-align: center">
            <th scope="col">번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th scope="col">내용</th>
            <th scope="col">작성시간</th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="review in reviewStore.reviewList"
            style="text-align: center"
          >
            <td>{{ review.reviewId }}</td>
            <td>
              <RouterLink
                :to="{
                  name: 'reviewDetail',
                  params: {
                    reviewId: `${review.reviewId}`,
                    videoId: route.params.id,
                  },
                }"
                style="cursor: pointer; color: black"
                >{{ review.title }}</RouterLink
              >
            </td>
            <td>{{ review.writer }}</td>
            <td>{{ review.content }}</td>
            <td>{{ review.regDate }}</td>
            <td>
              <button
                @click.prevent="changeStatus(review.reviewId)"
                v-show="review.userId == userStore.loginId"
              >
                수정
              </button>
              <button
                @click="deleteReview(review.reviewId)"
                v-show="review.userId == userStore.loginId"
              >
                삭제
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </form>
    <div class="btn-container">
      <RouterLink
        type="button"
        class="btn"
        :to="{
          name: 'videoList',
          param: { videoType: route.params.videoType, id: route.params.id },
        }"
        >돌아가기
      </RouterLink>
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
  reviewStore.status = reviewId
  console.log(reviewStore.status)
}

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
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}
.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  left: 0;
  right: 0;
  margin: auto;
  margin-top: 70px;
  margin-bottom: 140px;
  width: 1000px;
}

.text-center {
  margin-bottom: 20px;
}

.reviewform {
  padding-top: 50px;
}

a:link {
  text-decoration: none;
}

a:hover {
  color: rgb(186, 41, 41) !important;
}

.btn {
  margin-top: 70px;
  background: #52796f;
  color: #ffffff;
}
.btn:hover {
  background: rgb(186, 41, 41);
  color: #ffffff !important;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}
</style>
