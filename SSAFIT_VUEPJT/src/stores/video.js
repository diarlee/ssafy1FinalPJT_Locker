import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_VIDEO_API = `http://localhost:8080/api/video`;

export const useVideoStore = defineStore(
  "video",
  () => {
    const searched = ref(false);
    const youtubeList = ref([]);
    const searchVideo = function (keyword) {
      const URL = "https://www.googleapis.com/youtube/v3/search";
      const API_KEY = "AIzaSyDoEB5mHHa--IDlOiozgvsxGsGf1X7RSeU";

      axios({
        url: URL,
        method: "GET",
        params: {
          key: API_KEY,
          part: "snippet",
          q: keyword,
          type: "video",
          maxResults: 20,
        },
      }).then((response) => {
        youtubeList.value = response.data.items;
        searched.value = true;
      });
    };

    const guideList4 = ref([])
    const getGuideList4 = function () {
      axios.get(`${REST_VIDEO_API}/four/guide`).then((response) => {
        guideList4.value = response.data
      })
    }

    const musicList4 = ref([]);
    const getMusicList4 = function () {
      axios.get(`${REST_VIDEO_API}/four/music`).then((response) => {
        musicList4.value = response.data
      })
    }
    const videoListByType = ref([]);
    const getVideosByType = function (type) {
      axios.get(`${REST_VIDEO_API}/${type}`).then((response) => {
        videoListByType.value = response.data
      })
    }

    const createVideo = function (video) {
      console.log(video);
      axios({
        url: `${REST_VIDEO_API}/insert`,
        method: "POST",
        data: {
          videoId: video.videoId,
          userId: video.userId,
          title: video.title,
          channelName: video.channelName,
          type: video.type,
          url: video.url,
        },
      })
        .then(() => {
          router.push({
            name: "home",
            params: {
              videoType: video.type,
            },
          });
        })
        .catch((err) => {
          console.log(err);
        });
    };

    const videoList = ref([]);
    const getVideoList = function () {
      axios.get(REST_VIDEO_API).then((response) => {
        videoList.value = response.data;
      });
    };

    const video = ref({});
    const getVideo = function (videoId) {
      axios.get(`${REST_VIDEO_API}/one/${videoId}`).then((response) => {
        video.value = response.data;
      });
    };

    return {
      searched,
      youtubeList,
      searchVideo,
      videoList,
      getVideoList,
      guideList4,
      getGuideList4,
      musicList4,
      getMusicList4,
      videoListByType,
      getVideosByType,
      createVideo,
      video,
      getVideo,
    };
  },
  { persist: true }
);
