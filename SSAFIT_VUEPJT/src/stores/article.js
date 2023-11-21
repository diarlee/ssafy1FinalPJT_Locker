import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_ARTICLE_API = "http://localhost:8080/api/article";

export const useArticleStore = defineStore("article", () => {
  // 전체 articleList 가져오기
  const articleList = ref([]);
  const getArticleList = function () {
    axios.get(`${REST_ARTICLE_API}/all`).then((response) => {
      articleList.value = response.data;
    });
  };

  // 최근 생성된 articleList 4개 가져오기
  const articleList_top4 = ref([]);
  const getArticleList_top4 = function () {
    axios.get(`${REST_ARTICLE_API}/top4`).then((response) => {
      articleList_top4.value = response.data;
    });
  };

  // 최근 5 ~ 8순위로 생성된 articleList
  const articleList_top4to8 = ref([]);
  const getArticleList_top4to8 = function () {
    axios.get(`${REST_ARTICLE_API}/top4to8`).then((response) => {
      articleList_top4to8.value = response.data;
    });
  };

  // article 등록
  const createArticle = function (formData) {
    // console.log(formData);
    axios({
      url: `${REST_ARTICLE_API}/write`,
      method: "POST",
      headers: { "Content-Type": "multipart/form-data" },
      data: formData,
    })
      .then(() => {
        router.push({ name: "home" });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // article 상세
  const article = ref({});
  const getArticle = function (articleId) {
    axios.get(`${REST_ARTICLE_API}/detail/${articleId}`).then((response) => {
      article.value = response.data;
    });
  };

  // article 수정
  const updateArticle = function (articleId, formData) {
    axios({
      url: `${REST_ARTICLE_API}/modify/${article.articleId}`,
      method: "PUT",
      headers: { "Content-Type": "multipart/form-data" },
      data: formData,
    })
      .then(() => {
        router.push({
          name: "articleDetail",
          params: { articleId: articleId },
        });
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 공개상태 변경
  const updatePublic = function (articleId) {
    axios({
      url: `${REST_ARTICLE_API}/public`,
      method: "PUT",
      data: {
        articleId: articleId,
      },
    })
      .then(() => {
        // window.location.reload()
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // 좋아요 누르기
  const updateHeart = function (articleId, userId) {
    axios({
      url: `${REST_ARTICLE_API}/like/${articleId}`,
      method: "PUT",
      data: {
        userId: userId,
      },
    }).catch((err) => {
      console.log(err);
    });
  };

  return {
    articleList,
    getArticleList,
    articleList_top4,
    getArticleList_top4,
    articleList_top4to8,
    getArticleList_top4to8,
    createArticle,
    article,
    getArticle,
    updateArticle,
    updateHeart,
    updatePublic,
  };
});
