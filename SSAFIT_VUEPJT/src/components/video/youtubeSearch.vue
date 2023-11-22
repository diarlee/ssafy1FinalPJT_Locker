<template>
    <div class="youtubeSearch-container">
        <input type="text" v-model="keyword">
        <button @click="search">검색</button>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { useVideoStore } from "@/components/stores/video"

const store = useVideoStore();

const keyword = ref("")

const search = function () {
    store.search(keyword.value)
}
</script>

<style scoped></style>