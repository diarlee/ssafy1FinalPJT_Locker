package com.ssafy.ssafit.model.dto;

public class Video {
	private String videoId;
	private String userId;
	private String title;
	private String type;
	private String channelName;
	private int viewCnt;
	private String url;

	public Video() {
		// TODO Auto-generated constructor stub
	}

	public Video(String videoId, String userId, String title, String type, String channelName, int viewCnt,
			String url) {
		this.videoId = videoId;
		this.userId = userId;
		this.title = title;
		this.type = type;
		this.channelName = channelName;
		this.viewCnt = viewCnt;
		this.url = url;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", userId=" + userId + ", title=" + title + ", type=" + type
				+ ", channelName=" + channelName + ", viewCnt=" + viewCnt + ", url=" + url + "]";
	}
}
