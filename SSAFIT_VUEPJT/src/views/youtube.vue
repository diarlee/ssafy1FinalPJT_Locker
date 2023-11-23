<template>
    <div class="youtube-container">
    <div class="youtubeSearch-container">
      <div>
        <input
          type="text"
          v-model="keyword"
          placeholder="운동 가이드, 운동 플리"
          @keyup.enter="search"
        />
        <button @click="search">검색</button>
      </div>
    </div>
    <br>
    <div class="searchList-container">
      <div v-if="videoStore.searched">
        <li class="results">
          <div v-for="video in videoStore.youtubeList">
            <!-- {{ video }} -->
            <iframe
              width="500"
              height="300"
              :src="'https://www.youtube.com/embed/' + video.id.videoId"
              title="YouTube video player"
              frameborder="0"
              allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
              allowfullscreen
            ></iframe>
            <div class="typeSelect">
              <select v-model="videoType">
                <option value="" disabled>Please select one</option>
                <option value="guide">guide</option>
                <option value="music">music</option>
              </select>
            </div>
            <button @click="addVideo(video)">등록</button>
            <hr>
          </div>
        </li>
      </div>
    </div>
</div>
<br>
  </template>
  
  <script setup>
  import { ref } from "vue";
  import { useVideoStore } from "@/stores/video";
  import { useUsersStore } from "@/stores/users";
  
  const videoStore = useVideoStore();
  const userStore = useUsersStore();
  
  const keyword = ref("");
  
  const search = function () {
    videoStore.searchVideo(keyword.value);
  };
  
  const videoType = ref("");
  
  const video = ref({
    videoId: "",
    userId: "",
    title: "",
    channelName: "",
    type: "",
    url: "",
  });
  const addVideo = function (videoInfo) {
    video.value.videoId = videoInfo.id.videoId;
    video.value.userId = userStore.loginId;
    video.value.title = videoInfo.snippet.title;
    video.value.channelName = videoInfo.snippet.channelTitle;
    video.value.type = videoType.value;
    video.value.url = `https://www.youtube.com/embed/${videoInfo.id.videoId}`;
    videoStore.createVideo(video.value);
  };
  </script>
  
  <style scoped>
  .youtubeSearch-container {
    display: flex;
    justify-content: center;
  }
  
  .results {
      display: flex;
      flex-wrap: wrap;
      justify-content: space-around;
  }
  
  </style>
  