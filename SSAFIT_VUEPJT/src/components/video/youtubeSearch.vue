<template>
    <div class="youtubeSearch-container">
        <div>
            <input type="text" v-model="keyword">
            <button @click="search">검색</button>
        </div>
    </div>
    <div v-if="store.searched">
        <li>
            <div v-for="video in store.youtubeList">
                <!-- {{ video.snippet.title }} -->
                <iframe width="560" height="315" :src="'https://www.youtube.com/embed/' + video.id.videoId" title="YouTube video player" frameborder="0"
                    allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                    allowfullscreen></iframe>
            </div>
        </li>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useVideoStore } from "@/stores/video"

const store = useVideoStore();

const keyword = ref("")

const search = function () {
    store.searchVideo(keyword.value)
}
</script>

<style scoped>
.youtubeSearch-container {
    display: flex;
    justify-content: center;
}
</style>