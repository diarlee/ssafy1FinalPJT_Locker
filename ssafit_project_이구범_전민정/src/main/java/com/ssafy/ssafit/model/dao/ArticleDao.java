package com.ssafy.ssafit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleDao {

	// 전체 게시글 조회 
	List<Article> selectAll();

	// 최신순 top 4
	List<Article> selectTopfour();
	
	// 최신순 top 5-8
	List<Article> selectTopeight();

	// 게시글 상세 조회
	Article selectOne(int articleId);

	// 게시글 등록
	void insertArticle(Article article);

	// 게시글 수정
	void updateArticle(Article article);

	// 게시글 삭제
	void deleteArticle(int articleId);

	// 게시글 좋아요 누르기
	void updateLike(int articleId);

	// 운동 인증하기
	void updateCheck(int articleId);

	// 전체공개
	void updatePublic(int articleId);

	// 인증 안 된 게시글 가져오기
	List<Article> selectNoCheck();

	// 전체공개 게시글만 가져오기
	List<Article> selectPublic();

	// 달력에 커밋하기
	int commit(@Param("userId") String id, @Param("date") String date);


}
