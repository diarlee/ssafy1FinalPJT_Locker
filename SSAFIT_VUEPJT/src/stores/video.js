import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'

const REST_VIDEO_API = `http://localhost:8080/api/video`

export const useVideoStore = defineStore('video', () => {

    const youtubeList = ref([])
    const searchVideo = function(keyword){
        const URL = 'https://www.googleapis.com/youtube/v3/search';
        const API_KEY = 'AIzaSyDoEB5mHHa--IDlOiozgvsxGsGf1X7RSeU';

        axios({
            url: URL,
            method: "GET",
            params: {
                key: API_KEY,
                part: 'snippet',
                q: keyword,
                type: video,
                maxResults: 10
            }
        })
        .then((response) => {
            youtubeList.value = response.data.items
        })
    }

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

    return  { youtubeList, searchVideo, videoList, getVideoList, video, getVideo };
});