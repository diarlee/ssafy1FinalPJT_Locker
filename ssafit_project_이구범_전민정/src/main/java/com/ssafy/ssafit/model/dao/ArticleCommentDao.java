package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.ArticleComment;

public interface ArticleCommentDao {

	// 댓글 가져오기
	List<ArticleComment> selectList(int articleId);

	// 댓글 하나 선택하기
	ArticleComment selectOne(int commentId);
	
	// 댓글 등록하기
	void insertComment(ArticleComment comment);

	// 댓글 수정하기
	void updateComment(ArticleComment comment);

	// 댓글 삭제하기 
	void deleteComment(int commentId);

}
