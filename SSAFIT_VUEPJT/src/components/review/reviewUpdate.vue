<template>
  <div class="container">
    <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
      <form
        class="reviewform"
        method="post"
        action="main"
        style="width: 80%; margin: auto"
      >
          <textarea
            class="form-control"
            type="text"
            name="content"
            rows="3"
            v-model="review.content"
          >
        </textarea>
        <button
          type="submit"
          @click.prevent="updateReview"
          class="w-20 me-2 btn"
        > 수정 </button>
        <button class="btn btn-cancel" @click="goToCreate">취소</button>
      </form>
    </div>
  </div>
</template>

<script setup>
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { ref, computed } from "vue";
import { useUsersStore } from "@/stores/users";
import { useReviewStore } from "@/stores/review";

const route = useRoute();
const userStore = useUsersStore();
const reviewStore = useReviewStore();

const reviewIdd = computed (() => {
  return reviewStore.status
})

const goToCreate = function () {
  reviewStore.status = "create"
}

const review = ref({
  reviewId: reviewIdd,
  videoId: route.params.id,
  userId: userStore.loginId,
  title: "",
  content: "",
});

const updateReview = function () {
  // console.log(review.value)
  reviewStore.updateReview(review, route.params.videoType);
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

.form-control {
  margin-bottom: 5px;
}

a:hover {
  text-decoration: none;
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
