<template>
  <div class="container">
    <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 90%">  
      <form
        @submit.prevent="createReview"
        style="width: 80%; margin: auto">
        <div class="reviewform">
            <textarea
              v-model="review.content"
              name="content"
              class="form-control"
              rows="3"
              placeholder="내용을 입력하세요"
            ></textarea>
            <!-- <button class="btn btn-outline-secondary" type="button" for="button-addon"></button> -->
          <button type="submit" class="btn">
            리뷰 등록
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
  width: 100%;
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  margin-top: 30px;
  margin-bottom: 200px;
}

.reviewform {
  margin-top: 20px;
}

.form-control {
  margin-bottom: 5px;
}

.btn {
  margin-top: 0;
  color: #ffffff;
  background: #52796F;
}

.btn:hover {
  color: #52796F;
  background-color: #ffffff;
}

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}
</style>
