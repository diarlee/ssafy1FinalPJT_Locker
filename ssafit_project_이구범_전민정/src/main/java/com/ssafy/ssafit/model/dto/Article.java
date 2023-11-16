package com.ssafy.ssafit.model.dto;

public class Article {

	private int articleId;
	private String userId;
	private String title;
	private String content;
	private boolean isChecked;
	private boolean isPublic;
	private String image;
	private String regDate;
	private int liked;
	
	public Article() {
		
	}

	public Article(int articleId, String userId, String title, String content, boolean isChecked, boolean isPublic,
			String image, String regDate, int liked) {
		this.articleId = articleId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.isChecked = isChecked;
		this.isPublic = isPublic;
		this.image = image;
		this.regDate = regDate;
		this.liked = liked;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getLiked() {
		return liked;
	}

	public void setLiked(int liked) {
		this.liked = liked;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", isChecked=" + isChecked + ", isPublic=" + isPublic + ", image=" + image + ", regDate=" + regDate
				+ ", liked=" + liked + "]";
	}
	
	
	
}
