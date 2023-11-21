<template style="margin: 0px; overflow: hidden">
  <div class="background-container">
    <!-- <div class="main-image-container" style="width: 100%">
      <img
        class="main-image object-fit-cover"
        src="https://watermark.lovepik.com/photo/20211126/large/lovepik-gym-picture_501088658.jpg"
        alt="main image"
      />
    </div> -->
    <div class="container">
      <div class="userInfo_articleList-container">
        <userInfo class="userInfo" />
        <articleList1 class="articleList1" />
      </div>
      <div class="calender_articleList-container">
        <div class="articleList-more">
          <articleList2 class="articleList2" />
          <div class="more">
            <RouterLink
              type="button"
              class="moreButton"
              :to="{ name: 'articleList' }"
              >+더보기</RouterLink
            >
          </div>
        </div>
        <calender class="calender" />
      </div>

      <br />
      <br />
      <div class="video-box">
        <div>
          <p class="fw-bold text-left fs-4">운동할 때 보면좋은</p>
        </div>
        <div
          class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around"
        >
          <RouterLink
            v-for="video in store.videoList"
            :to="{ name: 'videoDetail', params: { id: `${video.videoId}` } }"
            style="cursor: pointer; width: 30%"
          >
            <div class="text-wrap fw-bold">
              <div class="text-center">
                <iframe
                  width="100%"
                  height="auto"
                  :src="video.url"
                  title="YouTube video player"
                  frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  allowfullscreen
                ></iframe>
              </div>
              <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
              <div class="justify-content-between d-flex">
                <span
                  class="p-1 rounded-pill fw-bold bg-primary w-auto text-white"
                >
                  {{ video.fitPartName }}
                </span>
                <span class="fw-normal text-body-secondary">{{
                  video.channelName
                }}</span>
              </div>
            </div>
          </RouterLink>
        </div>
      </div>
      <div class="more">
        <RouterLink
          type="button"
          :to="{ name: 'videoList', params: { videoType: 'guide' } }"
          >+더보기</RouterLink
        >
      </div>
      <div class="mt-5 video-box">
        <div>
          <p class="fw-bold text-left fs-4">운동할 때 듣기좋은</p>
        </div>
        <div
          class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around"
        >
          <RouterLink
            v-for="video in store.videoList"
            :to="{ name: 'videoDetail', params: { id: `${video.videoId}` } }"
            style="cursor: pointer; width: 30%"
          >
            <div class="text-wrap fw-bold">
              <div class="text-center">
                <iframe
                  width="100%"
                  height="auto"
                  :src="video.url"
                  title="YouTube video player"
                  frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                  allowfullscreen
                ></iframe>
              </div>
              <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
              <div class="justify-content-between d-flex">
                <span
                  class="p-1 rounded-pill fw-bold bg-primary w-auto text-white"
                >
                  {{ video.fitPartName }}
                </span>
                <span class="fw-normal text-body-secondary">{{
                  video.channelName
                }}</span>
              </div>
            </div>
          </RouterLink>
        </div>
      </div>
      <div class="more">
        <RouterLink
          type="button"
          :to="{ name: 'videoList', params: { videoType: 'music' } }"
          >+더보기</RouterLink
        >
      </div>
    </div>
  </div>
</template>

<script setup>
import { RouterLink, RouterView } from "vue-router";
import { useVideoStore } from "@/stores/video";
import { onMounted } from "vue";
import userInfo from "@/components/user/userInfo.vue";
import calender from "@/components/calender/calender.vue";
import articleList1 from "@/components/article/articleList1.vue";
import articleList2 from "@/components/article/articleList2.vue";

const store = useVideoStore();

onMounted(() => {
  store.getVideoList();
});
</script>

<style scoped>
* {
  /* background: linear-gradient(to right, #485563, #29323c); */
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none !important;
}

.background-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  left: 0;
  right: 0;
  margin: 20px 0 50px 0;
  width: 1400px;
}

.userInfo_articleList-container {
  width: 100%;
  height: 240px;
  display: flex;
}

.userInfo_articleList-container > .userInfo {
  width: 35%;
  height: 220px;
}

.userInfo_articleList-container > .articleList1 {
  height: 200px;
}

.calender_articleList-container {
  width: 100%;
  height: 240px;
  display: flex;
}

.calender_articleList-container > .articleList-more {
  flex-grow: 8;
  width: 265%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.calender_articleList-container > .calender {
  flex-grow: 2;
  height: 240px;
  display: flex;
  justify-content: center;
}

/* .calender_articleList-container > .articleList1 {
  flex-grow: 9;
  height: 200px;
} */

.articleList2 {
  width: 100%;
  height: 200px;
}

.more {
  width: 100%;
  height: 30px;
  border: 1px solid;
  display: flex;
  justify-content: center;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

.main-image {
  width: 100%;
  height: 200px;
}

input {
  width: 100%;
}

.video-list img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.video-box {
  width: 100%;
}
</style>
