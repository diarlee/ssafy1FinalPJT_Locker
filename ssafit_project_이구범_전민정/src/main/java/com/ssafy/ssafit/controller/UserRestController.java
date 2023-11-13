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

@RestController
@RequestMapping("/api")
public class UserRestController {

	@Autowired
	private UserService userService;

	@GetMapping("/user")
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
	public ResponseEntity<?> signup(@RequestBody User user) {
//		System.out.println(user.toString());
		userService.signup(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PostMapping("/login")
	// vue를 거쳐 json 데이터로 전달되므로 @RequestBody + map으로 문자열 받기
	public ResponseEntity<?> login(@RequestBody Map<String, String> map, HttpSession session) {
//		System.out.println(map.get("id") + " " + map.get("pwd"));
		String id = map.get("id");
		String pwd = map.get("pwd");
		User temp = userService.getUser(id);
		if (temp == null || !pwd.equals(temp.getPassword())) {
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		} else {
			session.setAttribute("loginUser", temp.getPassword());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@GetMapping("/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		session.invalidate();
		System.out.println("logout");
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
