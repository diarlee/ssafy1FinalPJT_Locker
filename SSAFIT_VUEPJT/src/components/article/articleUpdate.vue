<template>
    <div class="articleCreate-container">
      <form class="articleCreate-box">
        <div class="form-check form-switch">
          <!-- <button @click="isPublic = !isPublic">
            {{ getIsPublic }}
          </button> -->
          <input type="checkbox" class="form-check-input" role="switch" id="flexSwitchCheckDefault"  @click="isPublic = !isPublic">
          <label class="form-check-label" for="flexSwitchCheckDefault">{{ getIsPublic }}</label>
        </div>
        <div class="mb-3">
          <input class="form-control" type="file" @change="appendImage" />
        </div>
        <div class="mb-3 input-box">
          <input class="form-control" type="text" name="" required="" v-model="title" placeholder="title" />
        </div>
        <div class="mb-3">
          <textarea class="form-control" rows="3" name="" required="" v-model="content" placeholder="content"></textarea>
        </div>
        <div class="buttons">
          <button class="btn" @click="updateArticle">수정</button>
          <RouterLink class="btn btn-cancel" :to="{name: 'articleDetail', params: {articleId: route.params.articleId}}">취소</RouterLink>
        </div>
      </form>
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

<style scoped>
.articleCreate-container {
  margin: 70px 0 140px;
  padding: 0;
  font-family: sans-serif;
  height: 100%;
}

.articleCreate-box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.btn {
  color: #ffffff !important;
  background: #52796f ;
  margin: 5px 2px 0 2px;
}

/* .btn-cancel {
  color: rgb(186, 41, 41) !important; 
  background: #ffffff;
  border: 0.3px solid rgb(186, 41, 41);
} */

.btn:hover {
  color:#52796f !important;
  background: white;
}
/* 
.btn-cancel:hover {
  color: #ffffff !important;
  background: rgb(186, 41, 41);
} */
.mb-3{
  width: 56%;
  padding: 5px 0 5px 0;
}


</style>
