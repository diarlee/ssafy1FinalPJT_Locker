package com.ssafy.ssafit.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.UserService;
import com.ssafy.ssafit.util.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UserRestController {
	
//	private static final String SUCCESS = "success";
//	private static final String FAIL = "fail";
//	
//	@Autowired
//	private JwtUtil jwtUtil;

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
	// vue를 거쳐 json 데이터로 전달되므로 @RequestBody + Map
	public ResponseEntity<?> login(@RequestBody Map<String, String> map, HttpSession session) {
//		System.out.println(map.get("id") + " " + map.get("pwd"));
		
		String userId = map.get("id");
		String password = map.get("pwd");
		
		User user = userService.getUser(userId);
		
		if (user == null || !password.equals(user.getPassword())) {
			System.out.println(user);
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		} else {
			session.setAttribute("loginUser", user);
			System.out.println(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
	
//	public ResponseEntity<?> login(@RequestBody User user){
//		Map<String, Object> result = new HashMap<String, Object>();
//		
//		HttpStatus status = null;
//		
//		try {
//			if (user.getUserId() != null && user.getUserId().length() > 0) {
//				System.out.println(user);
//				result.put("access-token", jwtUtil.createToken("userId", user.getUserId()));
//				result.put("message", SUCCESS);
//				status = HttpStatus.ACCEPTED;
//			} else {
//				result.put("message", FAIL);
//				status = HttpStatus.NO_CONTENT;
//			}
//		} catch (UnsupportedEncodingException e) {
//			result.put("message", FAIL);
//			status = HttpStatus.INTERNAL_SERVER_ERROR;
//		}
//		
//		return new ResponseEntity<Map<String, Object>>(result, status);
//	}
	

	@GetMapping("/logout")
	@ApiOperation(value="로그아웃")
	public ResponseEntity<?> logout(HttpSession session) {
		System.out.println("logout");
		session.invalidate();
//		System.out.println("logout");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	public ResponseEntity<?> logout(@RequestBody Map<String, Object> result){
//		result.clear();
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}


}
