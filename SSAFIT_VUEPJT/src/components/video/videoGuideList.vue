<template>
    <div class="guideContainer">
        <div class="video-box1">
          <div class="shadow pe-3 ps-3 pt-4 pb-4">
            <div>
              <p class="fw-bold text-left fs-4">운동할 때 보면좋은</p>
            </div>
            <div class=" d-flex video-list w-100 justify-content-around">
            <RouterLink
              v-for="video in store.guideList4"
              :to="{ name: 'videoDetail', params: { videoType: `guide`, id: `${video.videoId}` } }"
              style="cursor: pointer; width: 30%; padding: 2px">
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
                <div class="video-description">
                  <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
                  <div class="justify-content-between d-flex">
                    <!-- <span>
                        조회수 {{ video.viewCnt }}
                    </span> -->
                    <span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
                  </div>
                </div>
              </div>
            </RouterLink>
          </div>
          <div class="more">
            <RouterLink class="btn-more"
              type="button"
              :to="{ name: 'videoList', params: { videoType: 'guide' } }" style="font-size: 30px; font-weight: bold;">. . .</RouterLink>
          </div>
        </div>
      </div>
    </div>
</template>

<script setup>
// import { ref } from "vue";
import { useVideoStore } from "@/stores/video";
import { onMounted } from "vue";

const store = useVideoStore();

onMounted(() => {
  store.getGuideList4();
});
</script>

<style scoped>
.video-box1 {
  height: 50%;
}

.video-list img {
  width: 100%;
  height: 200px;
  object-fit: cover;
}
.more {
  width: 100%;
  height: 30px;
  /* border: 1px solid; */
  display: flex;
  justify-content: center;
  margin: 10px 0 17px 0;
}

.video-description {
  padding: 0 10px 0 10px;
}

a:link {
  text-decoration: none;
}

a {
  color: black;
}

a:hover {
  color: rgb(186, 41, 41);
}

</style>