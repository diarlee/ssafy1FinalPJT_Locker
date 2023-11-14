package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.User;

public interface UserDao {
	// 전체 유저 조회
	public List<User> selectAll();

	// 유저 정보 조회
	public User selectUser(String id);

	// 회원 가입
	public void insertUser(User user);
	
	//로그인
//	public User login(String userId, String password);
}
