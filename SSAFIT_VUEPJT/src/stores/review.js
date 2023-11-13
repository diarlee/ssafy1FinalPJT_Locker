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

  // review 등록
  // 등록 마무리하기!
  const createReview = function (review, videoId, videoUrl) {
    // console.log(review);
    axios({
      url: `${REST_REVIEW_API}/write`,
      method: "POST",
      data: review,
    })
      .then(() => {
        // reviewList로 수정
        router.push({ name: "videoDetail", params: {id: videoId, url: videoUrl}});
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // review 상세
  const review = ref({});
  const getReview = function (reviewId) {
    axios.get(`${REST_REVIEW_API}/${id}`).then((response) => {
      review.value = response.data;
    });
  };

  // review 수정
  const updateReview = function () {
    axios.put(REST_REVIEW_API, review.value).then(() => {
      router.push({ name: "reviewList" });
    });
  };

  return { reviewList, getReviewList, createReview, getReview, updateReview };
});
