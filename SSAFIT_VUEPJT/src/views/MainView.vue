<template style="margin: 0px; overflow: hidden">
  <div class="background-container">
    <div class="container">
      <div class="calendar-user-article">
        <div class="calendar-userInfo-container">
          <div><calender class="calendar" /></div>
          <div class="userInfo-container">
            <userInfo class="userInfo" />
          </div>
        </div>
        <div class="articleList-container">
          <div class="latestArticle">
            <p class="article-description">Latest</p>
            <articleList1 class="articleList1" />
          </div>
          <div class="heartArticle">
            <p class="article-description">Best</p>
            <articleList2 class="articleList2" />
          </div>
        </div>
      </div>

      <div class="video-box-container">
        <guideList></guideList>
        <musicList></musicList>
      </div>
    </div>
  </div>
</template>

<script setup>
// import { RouterLink, RouterView } from "vue-router";
// import { onMounted } from "vue";
import userInfo from "@/components/user/userInfo.vue";
import calender from "@/components/calender/calender.vue";
import articleList1 from "@/components/article/articleList1.vue";
import articleList2 from "@/components/article/articleList2.vue";
import guideList from "@/components/video/videoGuideList.vue";
import musicList from "@/components/video/videoMusicList.vue";
// import { ref } from "vue";
// import { useVideoStore } from "@/stores/video";
// import { onMounted } from "vue";

// const store = useVideoStore();

// onMounted(() => {
//   store.getMusicList4();
// });
</script>

<style scoped>
* {
  /* background: linear-gradient(to right, #485563, #29323c); */
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
}

a {
  text-decoration: none !important;
}

.background-container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.container {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
  left: 0;
  right: 0;
  margin: 20px 0 50px 0;
  /* width: 1400px; */
  width: 100%;
}

.calendar-user-article {
  display: flex;
  flex-direction: row;
  /* width: 100%; */
}

.calendar-userInfo-container {
  width: 400px;
  height: 450px;
  display: flex;
  flex-direction: column;
  padding: 0 20px 0 0;
}

.calendar {
  /* flex-grow: 2; */
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  padding: 5px;
}

.userInfo-container {
  width: 100%;
  height: 40%;
}

.userInfo {
  height: 100%;
  margin: 10px 0 0 0;
}

/* .moreButton {
  margin: 10px 0 0 10px;
  border: 1.35px solid #52796F;
  border-radius: 25px;
  height: 47%;
  width: 47%;
  text-align: center;
} */

.articleList-container {
  width: 100%;
  height: 400px;
  display: flex;
  flex-direction: row;
}

.latestArticle {
  margin: 0 10px 0 0;
}

.heartArticle {
  margin: 0 0 0 10px;
}

.article-description {
  font-size: 25px;
}

.articleList1 {
  width: 100%;
  height: 200px;
}
.articleList2 {
  width: 100%;
  height: 200px;
}

/* .articleList-container > .articleList-more {
  flex-grow: 8;
  width: 265%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
} */

/* .calender_articleList-container > .articleList1 {
  flex-grow: 9;
  height: 200px;
} */

#page-name {
  font-weight: bold;
  font-size: 2rem;
}

input {
  width: 100%;
}

.video-box-container {
  width: 100%;
}
</style>
