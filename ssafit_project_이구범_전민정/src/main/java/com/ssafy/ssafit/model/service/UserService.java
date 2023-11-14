package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserService {
	// 전체 유저 조회
	public List<User> getList();

	// 유저 정보 조회
	public User getUser(String id);

	// 회원 가입
	public void signup(User user);
	
	// 로그인
//	public User login(String userId, String password);
}
