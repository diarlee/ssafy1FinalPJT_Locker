<template>
    <div class="articleCreate-container">
    <div class="articleCreate-box">
      <h2>게시글 업로드</h2>
      <form>
        <div class="input-box">
          <input type="file" @change="appendImage" />
          <label for="">이미지</label>
        </div>
        <div class="input-box">
          <input type="text" name="" required="" v-model="title" />
          <label>title</label>
        </div>
        <div class="input-box">
          <input type="text" name="" required="" v-model="content" />
          <label>content</label>
        </div>
        <div class="input-button">
          <button @click="isPublic = !isPublic">
            {{ getIsPublic }}
          </button>
        </div>
        <button @click="updateArticle">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          수정
        </button>
        <RouterLink :to="{name: 'articleDetail', params: {articleId: route.params.articleId}}">취소</RouterLink>
      </form>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useRoute, useRouter } from "vue-router";
import { RouterView, RouterLink } from "vue-router";
import { useUsersStore } from "@/stores/users";
import { useArticleStore } from "@/stores/article";

const userStore = useUsersStore();
const articleStore = useArticleStore();

const route = useRoute();

const formData = new FormData();
const userId = ref(userStore.loginId);
const title = ref("");
const content = ref("");
const isPublic = ref(true);

const appendImage = (e) => {
  formData.append("uploadImage", e.target.files[0]);
};

const getIsPublic = computed(() => {
  return isPublic.value == true ? "private" : "public";
});

const updateArticle = function () {
  formData.append("userId", userId.value);
  formData.append("title", title.value),
  formData.append("content", content.value),
  formData.append("isPublic", isPublic.value)
  articleStore.updateArticle(route.params.articleId, formData);
};
</script>

<style scoped></style>
