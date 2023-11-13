package com.ssafy.ssafit.model.dto;

public class Review {
	private int reviewId;
	private String videoId;
	private String userId;
	private String title;
	private String writer;
	private String regDate;
	private String content;
	private int viewCnt;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, String videoId, String userId, String title, String writer, String content,
			int viewCnt) {
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
	}

	public Review(int reviewId, String videoId, String userId, String title, String writer, String regDate,
			String content, int viewCnt) {
		this.reviewId = reviewId;
		this.videoId = videoId;
		this.userId = userId;
		this.title = title;
		this.writer = writer;
		this.regDate = regDate;
		this.content = content;
		this.viewCnt = viewCnt;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", videoId=" + videoId + ", userId=" + userId + ", title=" + title
				+ ", writer=" + writer + ", regDate=" + regDate + ", content=" + content + ", viewCnt=" + viewCnt + "]";
	}
}
