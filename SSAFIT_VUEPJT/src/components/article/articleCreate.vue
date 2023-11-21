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
        <a @click="createArticle">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
          등록
        </a>
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

const formData = new FormData();
const userId = ref(userStore.loginId);
const title = ref("");
const content = ref("");
const isPublic = ref("");

// const article = ref({
//   userId: userStore.loginId,
//   title: "",
//   image: "",
//   content: "",
//   isPublic: true,
// })

const appendImage = (e) => {
  article.append("image", e.target.files[0]);
};

const getIsPublic = computed(() => {
  return isPublic.value == true ? "private" : "public";
});

const createArticle = function () {
  formData.append("userId", userId.value);
  formData.append("title", title.value),
  formData.append("content", content.value),
  formData.append("isPublic", isPublic.value),
  articleStore.createArticle(formData);
};
</script>

<style scoped>
.articleCreate-container {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  height: 1000px;
  background: linear-gradient(#141e30, #243b55);
}

.articleCreate-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0, 0, 0, 0.5);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0, 0, 0, 0.6);
  border-radius: 10px;
}

.articleCreate-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.articleCreate-box .input-box {
  position: relative;
}

.articleCreate-box .input-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}
.articleCreate-box .input-box label {
  position: absolute;
  top: 0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: 0.5s;
}

.articleCreate-box .input-box input:focus ~ label,
.articleCreate-box .input-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #03e9f4;
  font-size: 12px;
}

.articleCreate-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #03e9f4;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: 0.5s;
  margin-top: 40px;
  letter-spacing: 4px;
}

.articleCreate-box a:hover {
  background: #03e9f4;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4,
    0 0 100px #03e9f4;
}

.articleCreate-box a span {
  position: absolute;
  display: block;
}

.articleCreate-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,
  100% {
    left: 100%;
  }
}

.articleCreate-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: btn-anim2 1s linear infinite;
  animation-delay: 0.25s;
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,
  100% {
    top: 100%;
  }
}

.articleCreate-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: btn-anim3 1s linear infinite;
  animation-delay: 0.5s;
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,
  100% {
    right: 100%;
  }
}

.articleCreate-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: btn-anim4 1s linear infinite;
  animation-delay: 0.75s;
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,
  100% {
    bottom: 100%;
  }
}
</style>
