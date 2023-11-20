import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_ARTICLE_API = "http://localhost:8080/api/article";

export const useArticleStore = defineStore("article", () => {

  // userId와 날짜로 articleId 가져오기
  const getArticleId = function (userId, date) {
    axios({
      url: `${REST_ARTICLE_API}/getId`,
      method: "POST",
      data: {
        userId: userId,
        date: date,
      }
    })
      .then((response) => {
        return response.data
      })
      .catch((err) => {
        console.log(err);
      });
  }

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
    axios({
      url: `${REST_ARTICLE_API}/write`,
      method: "POST",
      headers: {'Content-Type': `multipart/form-data`},
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
  const updateArticle = function (article) {
    axios({
      url: `${REST_ARTICLE_API}/modify/${article.articleId}`,
      method: "PUT",
      data: {},
    })
      .then(() => {
        router.push({
          name: "articleDetail",
          params: { article: article.articleId },
        });
      })
      .catch((err) => {
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
  };
});
