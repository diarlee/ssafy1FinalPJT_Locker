package com.ssafy.ssafit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
	@ApiOperation(value="모든 유저", notes="모든 유저 조회하기")
	public ResponseEntity<?> getList() {
		List<User> list = userService.getList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<User>>(list, HttpStatus.OK);
		}
	}

	// vue를 거쳐 json 데이터로 전달되므로 @RequestBody로 객체 형태로 받기
	@PostMapping("/signup")
	@ApiOperation(value="회원가입")
	public ResponseEntity<?> signup(@RequestBody User user) {
//		System.out.println(user.toString());
		userService.signup(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/login")
	@ApiOperation(value="로그인")
	// vue를 거쳐 json 데이터로 전달되므로 @RequestBody 
	public ResponseEntity<?> login(@RequestBody String userId, @RequestBody String password, HttpSession session) {
//		System.out.println(map.get("id") + " " + map.get("pwd"));
		
		User user = userService.getUser(userId);
		 
		if (user == null || !password.equals(user.getPassword())) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		} else {
			session.setAttribute("loginUser", user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@GetMapping("/logout")
	@ApiOperation(value="로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		System.out.println("logout");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
