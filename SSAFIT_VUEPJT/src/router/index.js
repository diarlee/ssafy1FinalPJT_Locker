import { createRouter, createWebHistory } from "vue-router";
import MainView from "@/views/MainView.vue";
import Signin from "@/components/user/signin.vue";
import Login from "@/components/user/login.vue";
import VideoDetail from "@/components/video/videoDetail.vue";
import ReviewCreate from "@/components/review/reviewCreate.vue";
import ReviewDetail from "@/components/review/reviewDetail.vue";
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
      path: "/video/detail/:id/:url",
      name: "videoDetail",
      component: VideoDetail,
    },
    {
      path: "/review/create/:id/:url",
      name: "reviewCreate",
      component: ReviewCreate,
    },
    {
      path: "/review/detail/:reviewId/:videoId/:url",
      name: "reviewDetail",
      component: ReviewDetail,
    },
    {
      path: "/review/update/:reviewId/:videoId/:url",
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
