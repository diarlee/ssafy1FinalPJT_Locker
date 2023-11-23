import { ref, computed } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

const REST_COMMENT_API = "http://localhost:8080/api/comment";

export const useCommentStore = defineStore("comment", () => {

  // commentList 가져오기
  const commentList = ref([]);
  const getCommentList = function (articleId) {
    axios.get(`${REST_COMMENT_API}/${articleId}`)
    .then((response) => {
      commentList.value = response.data
    })
  }

  const status = ref("create");

  // comment 등록
  const createComment = function (comment) {
    axios({
      url: `${REST_COMMENT_API}/write/${comment.value.articleId}`,
      method: "POST",
      data: {
        articleId: comment.value.articleId,
        userId: comment.value.userId,
        content: comment.value.content,
      },
    })
      .then(() => {
        location.reload();
      })
      .catch((err) => {
        console.log(err);
      });
  };

  // COMMENT 수정
  const updateComment = function (comment) {
    axios({
      url: `${REST_COMMENT_API}/modify/${comment.value.commentId}`,
      method: 'PUT',
      data: {
        commentId: comment.value.commentId,
        articleId: comment.value.articleId,
        userId: comment.value.userId,
        content: comment.value.content
      }
    })
    .then(() => {
      location.reload()
    })
    .catch((err) => {
      console.log(err)
    })
  };

  return { commentList, getCommentList, status, createComment, updateComment };
});
