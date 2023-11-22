<template>
    <div class="youtubeSearch-container">
        <div>
            <input type="text" v-model="keyword">
            <button @click="search">검색</button>
        </div>
    </div>
    <div v-if="videoStore.searched">
        <li>
            <div v-for="video in store.youtubeList">
                {{ video }}
                <iframe width="560" height="315" :src="'https://www.youtube.com/embed/' + video.id.videoId"
                    title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    allowfullscreen></iframe>
                <button @click="addVideo(videoInfo)">등록</button>
            </div>
        </li>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useVideoStore } from "@/stores/video"
import { useUsersStore } from "@/stores/users"

const videoStore = useVideoStore();
const userStore = useUsersStore();

const keyword = ref("")

const search = function () {
    videoStore.searchVideo(keyword.value)
}

const video = ref({
    videoId: "",
    userId: "",
    title: "",
    channelName: "",
    url: "",
})
const addVideo = function (videoInfo) {
    video.value.videoId = videoInfo.id.videoId
    video.value.userId = userStore.loginId
    video.value.title = videoInfo.snippet.title
    video.value.channelName = videoInfo.channelTitle
    video.value.url = `https://www.youtube.com/embed/${videoInfo.id.videoId}`
    store.createVideo(video)
}
</script>

<style scoped>
.youtubeSearch-container {
    display: flex;
    justify-content: center;
}</style>