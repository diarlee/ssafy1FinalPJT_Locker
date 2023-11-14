package com.ssafy.ssafit.model.dto;

public class Exercise {
	
	private int exerciseId;
	private String userId;
	private String title;
	private String img;
	private String exeTime;
	private boolean checked;
	
	// 이거 user 로 넘기기 //
	private String level;
	private int score;
	private String regDate;
	
	public Exercise() {
		
	}

	public Exercise(int exerciseId, String userId, String title, String img, String exeTime, boolean checked, String level, int score, String regDate) {
		this.exerciseId = exerciseId;
		this.userId = userId;
		this.img = img;
		this.title = title;
		this.exeTime = exeTime;
		this.checked = checked;
		this.level = level;
		this.score = score;
		this.regDate = regDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getExeTime() {
		return exeTime;
	}

	public void setExeTime(String exeTime) {
		this.exeTime = exeTime;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	
	@Override
	public String toString() {
		return "Exercise [userId=" + userId + ", title=" + title + ", img=" + img + ", exeTime=" + exeTime + ", checked=" + checked
				+ ", level=" + level + ", score=" + score + ", regDate=" + regDate + ",exerciseId=" + exerciseId + "]";
	}
	
	
	
	
}
