import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_REVIEW_API = "http://localhost:8080/api/review";

export const useReviewStore = defineStore("review", () => {

  // reviewList 가져오기
  const reviewList = ref([]);
  const getReviewList = function (videoId) {
    axios.get(`${REST_REVIEW_API}/${videoId}`)
    .then((response) => {
      reviewList.value = response.data
    })
  }

  const status = ref("create");

  // review 등록
  const createReview = function (review, videoType) {
    // console.log(review.value);
    axios({
      url: `${REST_REVIEW_API}/write`,
      method: "POST",
      data: {
        videoId: review.value.videoId,
        userId: review.value.userId,
        title: review.value.title,
        content: review.value.content,
      },
    })
      .then(() => {
        // router.push({ name: "videoDetail", params: {videoType: videoType, id: review.value.videoId }});
        location.reload();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // review 상세
  const review = ref({});
  const getReview = function (reviewId) {
    axios.get(`${REST_REVIEW_API}/detail/${reviewId}`)
    .then((response) => {
      review.value = response.data;
    });
  };

  // review 수정
  const updateReview = function (review, videoType) {
    axios({
      url: `${REST_REVIEW_API}/modify/${review.value.reviewId}`,
      method: 'PUT',
      data: {
        reviewId: review.value.reviewId,
        videoId: review.value.videoId,
        userId: review.value.userId,
        title: review.value.title,
        content: review.value.content
      }
    })
    .then(() => {
      // router.push({ name: "videoDetail" , params: {videoType: videoType, id: review.value.videoId }});
      // console.log(review.value.reviewId)
      location.reload()
    })
    .catch((err) => {
      console.log(err)
    })
  };

  return { reviewList, review, getReviewList, status, createReview, getReview, updateReview };
});
