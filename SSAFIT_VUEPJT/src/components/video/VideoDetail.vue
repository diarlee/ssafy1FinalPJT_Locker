<template>
  <div class="container">
    <div class="shadow pt-5 pb-5 m-5 bg-light rounded" style="width: 80%">
      <form class="reviewform" style="width: 80%; margin: auto">
        <div class="text-center">
          <span class="material-symbols-outlined">dialogs</span>
          <h2 class="d-inline mb-3 fs-4 fw-semibold">운동영상 리뷰 목록</h2>
          <span class="material-symbols-outlined">dialogs</span>
        </div>

        <hr class="mb-3" />
        <div class="text-center">
          <iframe
            width="560"
            height="315"
            :src="route.params.url"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
          ></iframe>
        </div>

        <hr class="mb-3" />

        <div class="d-flex justify-content-between">
          <!-- <button
            type="button"
            @click="goToCreateReview"
            class="w-20 me-2 btn btn-outline-primary"
          >
        </button> -->
          <RouterLink
            type="button"
            class="w-20 me-2 btn btn-outline-primary"
            :to="{ name: 'reviewCreate', param: { id: route.params.id, url: route.params.url } }"
            >글 작성</RouterLink
          >
          <div
            style="border-bottom: solid gray 1px"
            class="d-flex align-items-center"
          >
            <span class="material-symbols-outlined align-items-center"
              >search</span
            >

            <input
              style="border: none; background-color: transparent"
              placeholder="제목,내용으로 검색"
            />
          </div>
        </div>

        <hr class="mb-3" />

        <div class="d-flex justify-content-center">
          <table style="width: 95%">
            <tr>
              <th class="border-bottom p-3">번호</th>
              <th class="border-bottom p-3">제목</th>
              <th class="border-bottom p-3">작성자</th>
              <th class="border-bottom p-3">조회수</th>
              <th class="border-bottom p-3">작성시간</th>
            </tr>
            <div v-for="review in store.reviewList">
              <RouterLink
                :to="{ name: 'reviewDetail', param: { id: route.params.id, url: route.params.url } }"
                style="cursor: pointer; text-decoration: underline"
                class="link-dark link-offset-2 link-underline-opacity-0 link-underline-opacity-100-hover"
              >
                <tr>
                  <td class="p-3">{{ review.reviewId }}</td>
                  <td class="p-3">{{ review.title }}</td>
                  <td class="p-3">{{ review.writer }}</td>
                  <td class="p-3">{{ review.viewCnt }}</td>
                  <td class="p-3">{{ review.regDate }}</td>
                </tr>
              </RouterLink>
            </div>

            <!-- <c:forEach items="${reviewList}" var="review">
              <tr
                onclick="location.href='./main?act=reviewDetail&videoId=${videoId}&url=${url }&reviewId=${review.reviewId }'"
                style="cursor: pointer; text-decoration: underline"
                class="link-dark link-offset-2 link-underline-opacity-0 link-underline-opacity-100-hover"
              >
                <td class="p-3">${review.reviewId }</td>
                <td class="p-3">${review.title }</td>
                <td class="p-3">${review.writer }</td>
                <td class="p-3">${review.viewCnt }</td>
                <td class="p-3">${review.regDate }</td>
              </tr>
            </c:forEach> -->
          </table>
        </div>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { RouterView, RouterLink } from "vue-router";
import { useRoute, useRouter } from "vue-router";
import { useReviewStore } from "@/stores/review";

const route = useRoute();
const router = useRouter();

const store = useReviewStore();

onMounted(() => {
  store.getReviewList(route.params.id);
  // console.log(store.reviewList)
  // console.log(route.params.id);  
});
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
