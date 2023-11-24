<template>
  <div class="articleCreate-container">
    <form class="articleCreate-box">
      <div class="form-check form-switch">
        <!-- <button class="btn" @click="isPublic = !isPublic">
          {{ getIsPublic }}
        </button> -->
        <input type="checkbox" class="form-check-input" role="switch" id="flexSwitchCheckDefault"  @click="isPublic = !isPublic">
        <label class="form-check-label" for="flexSwitchCheckDefault">{{ getIsPublic }}</label>
      </div>
      <div class="mb-3">
        <input class="form-control" type="file" @change="appendImage" />
      </div>
      <div class="mb-3 input-box">
        <input class="form-control" type="text" name="" required="" v-model="title" placeholder="title"/>
      </div>
      <div class="mb-3">
        <textarea class="form-control" rows="3" name="" required="" v-model="content" placeholder="content"></textarea>
      </div>
      <div class="create-button">
        <a class="btn" @click="createArticle">등록</a>
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

const formData = new FormData();
const userId = ref(userStore.loginId);
const title = ref("");
const content = ref("");
const isPublic = ref(true);

// const article = ref({
//   userId: userStore.loginId,
//   title: "",
//   image: "",
//   content: "",
//   isPublic: true,
// })

const appendImage = (e) => {
  formData.append("uploadImage", e.target.files[0]);
};

const getIsPublic = computed(() => {
  return isPublic.value == true ? "private" : "public";
});

const createArticle = function () {
  formData.append("userId", userId.value);
  formData.append("title", title.value),
  formData.append("content", content.value),
  formData.append("isPublic", isPublic.value)
  articleStore.createArticle(formData);
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
  margin-top: 5px;
}

.btn:hover {
  color:#52796f !important;
  background: white !important;
}

.mb-3 {
  width: 56%;
  padding: 5px 0 5px 0;
}

</style>
