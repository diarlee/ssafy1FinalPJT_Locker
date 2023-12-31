import { createRouter, createWebHistory } from "vue-router";
import MainView from "@/views/mainView.vue";
import Signin from "@/components/user/signin.vue";
import Login from "@/components/user/login.vue";
import Master from "@/views/masterView.vue"
import KeysInfoView from "@/views/keysInfoView.vue"
import YoutubeView from "@/views/youtube.vue"
import myHeartsView from "@/views/myHeartsView.vue"
import ArticleList from "@/views/articleView.vue"
import ArticleCreate from "@/components/article/articleCreate.vue"
import ArticleDetail from "@/components/article/articleDetail.vue"
import ArticleUpdate from "@/components/article/articleUpdate.vue"
import VideoList from "@/views/videoView.vue"
import VideoDetail from "@/components/video/videoDetail.vue";
import ReviewCreate from "@/components/review/reviewCreate.vue";
import ReviewUpdate from "@/components/review/reviewUpdate.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: MainView,
    },
    {
      path: "/signin",
      name: "signin",
      component: Signin,
    },
    {
      path: "/login",
      name: "login",
      component: Login,
    },
    {
      path: "/master",
      name: "master",
      component: Master,
    },
    {
      path: "/keysInfo",
      name: "keysInfo",
      component: KeysInfoView,
    },
    {
      path: "/myHeart",
      name: "myHeart",
      component: myHeartsView,
    },
    {
      path: "/youtube",
      name: "youtube",
      component: YoutubeView,
    },
    {
      path: "/article/all",
      name: "articleList",
      component: ArticleList,
    },
    {
      path: "/article/write",
      name: "articleCreate",
      component: ArticleCreate,
    },
    {
      path: "/article/detail/:articleId",
      name: "articleDetail",
      component: ArticleDetail,
    },
    {
      path: "/article/modify/:articleId",
      name: "articleUpdate",
      component: ArticleUpdate,
    },
    {
      path: "/video/:videoType",
      name: "videoList",
      component: VideoList,
    },
    {
      path: "/video/:videoType/detail/:id",
      name: "videoDetail",
      component: VideoDetail,
    },
    {
      path: "/review/create/:id",
      name: "reviewCreate",
      component: ReviewCreate,
    },
    {
      path: "/review/update/:reviewId/:videoId",
      name: "reviewUpdate",
      component: ReviewUpdate,
    },


    // {
    //   path: "/review",
    //   name: "review",
    //   component: Review,
    //   children: [
    //     {
    //       path: "create",
    //       name: "reviewCreate",
    //       component: ReviewCreate,
    //     },
    //     {
    //       path: ":id",
    //       name: "reviewDetail",
    //       component: ReviewDetail,
    //     },
    //     {
    //       path: "update",
    //       name: "reviewUpdate",
    //       component: ReviewUpdate,
    //     },
    //   ],
    // },

  ],
});

export default router;
