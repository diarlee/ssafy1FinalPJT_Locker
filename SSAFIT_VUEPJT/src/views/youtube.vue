<template>
    <div class="youtube-container">
    <div class="youtubeSearch-container">
      <div class="input-group mb-3" style="width: 70%;">
        <input class="form-control" type="text" aria-describedby="button-addon2" v-model="keyword" placeholder="운동 가이드, 운동 플리" @keyup.enter="search"/>
        <button class="btn btn-outline-secondary" type="button" id="button-addon2" @click="search"> 
          <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
            <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
          </svg>
        </button>
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
              <select class="form-select" aria-label="Default select example" v-model="videoType">
                <option value="" disabled>Please select one</option>
                <option value="guide">guide</option>
                <option value="music">music</option>
              </select>
              <button class="btn btn-regist" @click="addVideo(video)">등록</button>
            </div>
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

  .typeSelect {
    margin-top: 7px;
    margin-bottom: 7px;
    display: flex;
    flex-direction: row;
    align-content: center;
    justify-content: center;
  }

  .form-select {
    width: 85%;
    margin-right: 10px;
  }

  .btn-regist {
    border: 0.5px solid #ffffff;
    background: #52796f;
    color: #ffffff;
    width: 15%;
  }

  .btn-regist:hover {
    border: 0.5px solid #52796f;
    background: #ffffff;
    color: #52796f;
  }

  </style>
  