package com.ssafy.ssafit.model.dto;

public class User {
	private String userId;
	private String username;
	private String email;
	private String password;
	private String create_time;
	private int score;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userId, String username, String email, String password, String create_time, int score) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.password = password;
		this.create_time = create_time;
		this.score = score;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", create_time=" + create_time + ", socre" + score + "]";
	}
}
