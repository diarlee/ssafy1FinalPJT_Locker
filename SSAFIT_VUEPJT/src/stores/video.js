import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_VIDEO_API = `http://localhost:8080/api/video`

export const useVideoStore = defineStore('video', () => {
    const videoList = ref([]);
    const getVideoList = function () {
        axios.get(REST_VIDEO_API)
        .then((response) => {
            videoList.value = response.data
        })
    };

    const video = ref({});
    const getVideo = function (videoId) {
        axios.get(`${REST_VIDEO_API}/one/${videoId}`)
        .then((response) => {
            video.value = response.data
        });
    };

    return  { videoList, getVideoList, video, getVideo };
});