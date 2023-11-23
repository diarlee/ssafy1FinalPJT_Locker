<template>
  <div class="allGuides-container">
    <div
      class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around"
    >
      <RouterLink
        v-for="video in store.videoListByType"
        :to="{ name: 'videoDetail', params: { videoType: route.params.videoType, id: `${video.videoId}` } }"
        style="cursor: pointer; width: 15%"
      >
        <div class="text-wrap fw-bold">
          <div class="text-center">
            <iframe
              width="100%"
              height="30%"
              :src="video.url"
              title="YouTube video player"
              frameborder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowfullscreen
            ></iframe>
          </div>
          <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
          <div class="justify-content-between d-flex">
            <span> 조회수 {{ video.viewCnt }} </span>
            <span class="fw-normal text-body-secondary">{{
              video.channelName
            }}</span>
          </div>
        </div>
      </RouterLink>
    </div>
  </div>
</template>

<script setup>
import { useVideoStore } from "@/stores/video";
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const store = useVideoStore();

const route = useRoute();

onMounted(() => {
  store.getVideosByType(route.params.videoType);
});
</script>

<style scoped>
.allGuides-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}

.video-list img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
</style>
