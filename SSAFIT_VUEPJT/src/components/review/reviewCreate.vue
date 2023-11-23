<template>
  <div class="container">
      
      <form
        @submit.prevent="createReview"
        style="width: 80%; margin: auto">
        <div class="text-center">
          <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 등록</h2>
        </div>
        <div class="reviewform">
          <div class="mb-3">
            <textarea
              v-model="review.content"
              name="content"
              class="form-control"
              rows="3"
              placeholder="내용을 입력하세요"
            ></textarea>
            <!-- <button class="btn btn-outline-secondary" type="button" for="button-addon"></button> -->
          </div>
          <button type="submit" class="btn">
            등록
          </button>
        </div>
        <!-- <RouterLink
          class="w-20 btn btn-outline-danger"
          :to="{
            name: 'videoDetail',
            params: { id: route.params.id },
          }"
          >취소</RouterLink> -->
      </form>
    </div>
</template>

<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { RouterView, RouterLink } from "vue-router";
import { useUsersStore } from "@/stores/users"
import { useReviewStore } from "@/stores/review";

const route = useRoute();
const userStore = useUsersStore();
const reviewStore = useReviewStore();

const review = ref({
  videoId: "",
  userId: "",
  title: "",
  content: "",
});

const createReview = function () {
  review.value.videoId = route.params.id
  review.value.userId = userStore.loginId
  reviewStore.createReview(review, route.params.videoType);
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none !important;
}

.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  left: 0;
  right: 0;
  margin: auto;
  margin-top: 100px;
  margin-bottom: 200px;
  width: 1400px;
}

.reviewform {
  margin-top: 20px;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}
</style>
