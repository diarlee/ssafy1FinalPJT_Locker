package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Article;

public interface ArticleService {

	// 전체 게시글 가져오기
	public List<Article> getAll();
	
	// 게시글 상세 조회
	public Article getArticle(int articleId);

	// 게시글 생성
	public void writeArticle(Article article);

	// 게시글 수정
	public void modifyArticle(Article article);

	// 게시글 삭제
	public void removeArticle(int articleId);
	
	// 게시글 좋아요
	public void likeIt(int articleId);
	
	// 운동 인증하기
	public void checkIt(int articleId);
}
