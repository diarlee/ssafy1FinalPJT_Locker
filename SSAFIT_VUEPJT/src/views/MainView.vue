<template>
    <div class="main-image-container">
        <img class="main-image object-fit-cover"
            src="https://watermark.lovepik.com/photo/20211126/large/lovepik-gym-picture_501088658.jpg" alt="main image">
    </div>
    <div class="container">
        <div style="width: 100%; padding: 10px; border-radius: 8px;" class="d-flex align-items-center shadow-sm mb-4">
            <span class="material-symbols-outlined">search</span>
            <div style="flex-grow: 1; margin-left: 10px;">
                <input
                    style="width: 100%; border: none; background-color: transparent; margin: 6px 2px 6px 2px; padding: 2px;"
                    list="datalistOptions" placeholder="운동 제목 검색">

            </div>
            <datalist id="datalistOptions">
                <option value="상체"></option>
                <option value="하체"></option>
                <option value="어깨"></option>
                <option value="가슴"></option>
                <option value="삼두"></option>
            </datalist>
        </div>
        <div class=" video-box">
            <div>
                <p class="fw-bold text-left fs-4">최근 가장 많이 본 영상</p>
            </div>
            <div class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
                <RouterLink v-for="video in store.videoList" :to="{ name: 'videoDetail', params: {id: `${video.videoId}`, url: `${video.url}`} }"
                    style="cursor: pointer; width: 30%;">
                    <div class="text-wrap fw-bold">
                        <div class="text-center">
                            <iframe width="100%" height="auto" :src="video.url" title="YouTube video player" frameborder="0"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                allowfullscreen></iframe>
                        </div>
                        <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
                        <div class="justify-content-between d-flex">
                            <span class="p-1 rounded-pill fw-bold bg-primary w-auto text-white">
                                {{ video.fitPartName }} </span>
                            <span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
                        </div>
                    </div>
                </RouterLink>
            </div>
        </div>
        <div class=" mt-5 video-box">
            <div>
                <p class="fw-bold text-left fs-4">최근 가장 많이 본 영상</p>
            </div>
            <div class="shadow pe-3 ps-3 pt-4 pb-4 d-flex video-list w-100 justify-content-around">
                <RouterLink v-for="video in store.videoList" :to="{ name: 'videoDetail', params: {id: `${video.videoId}`, url: `${video.url}`} }"
                    style="cursor: pointer; width: 30%;">
                    <div class="text-wrap fw-bold">
                        <div class="text-center">
                            <iframe width="100%" height="auto" :src="video.url" title="YouTube video player" frameborder="0"
                                allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                                allowfullscreen></iframe>
                        </div>
                        <div class="mt-1 mb-1 d-flex text-wrap">{{ video.title }}</div>
                        <div class="justify-content-between d-flex">
                            <span class="p-1 rounded-pill fw-bold bg-primary w-auto text-white">
                                {{ video.fitPartName }} </span>
                            <span class="fw-normal text-body-secondary">{{ video.channelName }}</span>
                        </div>
                    </div>
                </RouterLink>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useVideoStore } from "@/stores/video";
import { onMounted } from "vue";

const store = useVideoStore();

onMounted(() => {
    store.getVideoList()
})
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

.container-fluid {
    padding: 0 20px 0 20px !important;
}

#page-name {
    font-weight: bold;
    font-size: 2rem;
}

.main-image {
    width: 100%;
    height: 200px;
}

.search-box {
    width: 100%;
    padding: 10px;
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