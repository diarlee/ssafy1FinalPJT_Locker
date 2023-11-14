<template>
  <div class="container">
    <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
      <form
        class="reviewform"
        method="post"
        action="main"
        style="width: 80%; margin: auto"
      >
        <input type="hidden" name="act" value="doReviewUpdate" />
        <input type="hidden" name="videoId" value="${videoId }" />
        <input type="hidden" name="url" value="${url }" />
        <input type="hidden" name="reviewId" value="${review.reviewId }" />
        <div class="text-center">
          <span class="material-symbols-outlined">dialogs</span>
          <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 수정</h2>
          <span class="material-symbols-outlined">dialogs</span>
        </div>
        <hr class="mb-3" />

        <div class="mb-3">
          <label for="inputTitle" class="col-form-label">제목</label>
          <input
            type="text"
            class="form-control"
            id="inputEmail3"
            name="title"
            v-model="review.title"
          />
        </div>

        <div class="mb-4">
          <label for="inputContent" class="col-form-label">수정할 내용</label>
          <textarea
            class="form-control"
            type="text"
            name="content"
            rows="3"
            v-model="review.content"
          >
          </textarea>
        </div>

        <button
          type="submit"
          @click.prevent="updateReview"
          class="w-20 me-2 btn btn-outline-primary"
        >
          수정
        </button>
        <RouterLink
          :to="{
            name: 'reviewDetail',
            params: {
              reviewId: route.params.reviewId,
              videoId: route.params.videoId,
              url: route.params.url,
            },
          }"
          type="button"
          class="w-20 btn btn-outline-danger"
          >취소</RouterLink
        >
      </form>
    </div>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { ref } from "vue";
import { useUsersStore } from "@/stores/users"
import { useReviewStore } from "@/stores/review";

const route = useRoute();
const userStore = useUsersStore();
const reviewStore = useReviewStore();

const review = ref({
  reviewId: route.params.reviewId,
  videoId: route.params.videoId,
  userId: userStore.loginId,
  title: "",
  content: "",
});

const updateReview = function () {
  // console.log(review.value)
  reviewStore.updateReview(review, route.params.url);
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

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}
</style>
