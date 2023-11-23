<template>
  <div class="row row-cols-1 row-cols-md-2 g-4">
    <RouterLink class="video-list"
      v-for="video in store.videoListByType"
      :to="{ name: 'videoDetail', params: { videoType: route.params.videoType, id: `${video.videoId}` } }"
      style="cursor: pointer;"
    >
    <div class="col">
      <div class="card">
            <iframe class="card-img-top"
                width="100%"
                height="30%"
                :src="video.url"
                title="YouTube video player"
                frameborder="0"
                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                allowfullscreen></iframe>
            <div class="card-body">
              <h6 class="card-title">{{ video.title }}</h6>
              <h8 class="card-text" style="color: dimgrey;">{{ video.channelName }}</h8>
              <p class="card-text"><small class="text-body-secondary"> 조회수 {{ video.viewCnt }} </small></p>
            </div>
          </div>
        </div>
      </RouterLink>
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

/* * {
  padding: 0px !important;
} */

.row {
  margin: 0 100px 50px 100px;
}

a:link {
  text-decoration: none;
}

</style>
