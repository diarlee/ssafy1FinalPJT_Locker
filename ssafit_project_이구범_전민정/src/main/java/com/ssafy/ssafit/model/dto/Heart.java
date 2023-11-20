package com.ssafy.ssafit.model.dto;

public class Heart {

	private int heartId;
	private int articleId;
	private String userId;
	
	public Heart() {
		
	}

	public Heart(int heartId, int articleId, String userId) {
		this.heartId = heartId;
		this.articleId = articleId;
		this.userId = userId;
	}

	public int getHeartId() {
		return heartId;
	}

	public void setHeartId(int heartId) {
		this.heartId = heartId;
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

	@Override
	public String toString() {
		return "Heart [heartId=" + heartId + ", articleId=" + articleId + ", userId=" + userId + "]";
	}
	
	
}
