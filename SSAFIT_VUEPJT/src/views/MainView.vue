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
      <div class="calendar-user-article">
        <div class="calendar-userInfo-container">
          <div><calender class="calendar" /></div>
          <div><userInfo class="userInfo" /></div>
        </div>
        <div class="articleList-container">
          <div class="latestArticle">
            <p class="article-description"> Latest</p>
            <articleList1 class="articleList1" />
          </div>
          <div class="heartArticle">
            <p class="article-description"> Best</p>
            <articleList2 class="articleList2" />
          </div>
        </div>
      </div>
    
      <div class="video-box-container">
        <div class="video-box1">
          <div>
            <p class="fw-bold text-left fs-4">운동할 때 보면좋은</p>
          </div>
          <div class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
            <RouterLink
              v-for="video in store.videoList"
              :to="{ name: 'videoDetail', params: { id: `${video.videoId}` } }"
              style="cursor: pointer; width: 30%">
              <div class="text-wrap fw-bold">
                <div class="text-center">
                  <iframe
                      width="100%"
                      height="auto"
                      :src="video.url"
                      title="YouTube video player"
                      frameborder="0"
                      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                      allowfullscreen></iframe>
                </div>
                <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
                <div class="justify-content-between d-flex">
                  <span class="p-1 rounded-pill fw-bold bg-primary w-auto text-white">
                      {{ video.fitPartName }}
                  </span>
                  <span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
                </div>
              </div>
            </RouterLink>
          </div>
          <div class="more">
            <RouterLink
              type="button"
              :to="{ name: 'videoList', params: { videoType: 'guide' } }"
              >more</RouterLink
            >
          </div>
        </div>
        <div class="video-box2">
          <div><p class="fw-bold text-left fs-4">운동할 때 듣기좋은</p></div>
          <div class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
            <RouterLink
              v-for="video in store.videoList"
              :to="{ name: 'videoDetail', params: { id: `${video.videoId}` } }"
              style="cursor: pointer; width: 30%">
              <div class="text-wrap fw-bold">
                <div class="text-center">
                  <iframe
                        width="100%"
                        height="auto"
                        :src="video.url"
                        title="YouTube video player"
                        frameborder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        allowfullscreen></iframe>
                </div>
                <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
                <div class="justify-content-between d-flex">
                  <span class="p-1 rounded-pill fw-bold bg-primary w-auto text-white">{{ video.fitPartName }}</span>
                  <span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
                </div>
              </div>
            </RouterLink>
          </div>
          <div class="more">
            <RouterLink
                type="button"
                :to="{ name: 'videoList', params: { videoType: 'music' } }"
                >more</RouterLink>
          </div>
        </div>
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
  /* width: 100%; */
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  padding: 0;
  margin: 20px 0 50px 0;
  /* width: 100%; */
}

.calendar-user-article {
  display: flex;
  flex-direction: row;
}

.calendar-userInfo-container {
  width: 400px;
  height: 450px;
  display: flex;
  flex-direction: column;
  margin: 2.25px 10px 0 10px;
}

.calendar {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  /* padding: 3px; */
}

.userInfo {
  margin: 10px 0 0 0;
}

.articleList-container {
  width: 100%;
  height: 400px;
  display: inline-flex;
  flex-direction: row;
  margin-left: 10px;
}

.latestArticle {
  width: 50%;
  height: 200px;
  margin: 0 10px 0 10px;
}

.heartArticle {
  width: 50%;
  height: 200px;
  margin: 0 0 0 10px;
}

.article-description {
  font-size: 25px;
}

.more {
  width: 100%;
  height: 30px;
  /* border: 1px solid; */
  display: flex;
  justify-content: center;
  margin: 10px;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}

.video-list img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}

.video-box-container {
  width: 100%;
}

.video-box1 {
  height: 50%;
}

.video-box2 {
  height: 50%;
}
</style>
