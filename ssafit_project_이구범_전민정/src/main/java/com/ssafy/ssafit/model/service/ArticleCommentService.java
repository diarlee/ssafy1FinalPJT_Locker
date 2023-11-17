package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.ArticleComment;

public interface ArticleCommentService {

	public List<ArticleComment> getComment(int articleId);
	
	public ArticleComment getOne(int commentId);
	
	public void createComment(ArticleComment comment);
	
	public void modifyComment(ArticleComment comment);
	
	public void removeComment(int commentId);
}
