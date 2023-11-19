package com.ssafy.ssafit.model.dto;

public class ArticleComment {

	private int commentId;
	private int articleId;
	private String userId;
	private String content;
	private String regDate;
	
	public ArticleComment() {
		
	}

	public ArticleComment(int commentId, int articleId, String userId, String content, String regDate) {
		this.commentId = commentId;
		this.articleId = articleId;
		this.userId = userId;
		this.content = content;
		this.regDate = regDate;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "ArticleComment [commentId=" + commentId + ", articleId=" + articleId + ", userId=" + userId
				+ ", content=" + content + ", regDate=" + regDate + "]";
	}
	
	
}
