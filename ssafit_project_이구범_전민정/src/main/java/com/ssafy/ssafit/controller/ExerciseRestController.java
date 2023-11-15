package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Exercise;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ExerciseService;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ExerciseRestController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private ExerciseService exerciseService;
	
	
	@GetMapping("/exerciseAll")
	@ApiOperation(value="모든 인증 게시글 조회")
	public ResponseEntity<?> getAllList() {
		List<Exercise> list = exerciseService.getList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Exercise>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/exercise/{exerciseId}")
	@ApiOperation(value="인증 게시글 조회", notes="리뷰 디테일")
	public ResponseEntity<?> getList(@PathVariable int exerciseId) {
		Exercise exercise = exerciseService.getExercise(exerciseId);
		if (exercise == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Exercise>(exercise, HttpStatus.OK);
		}
	}
	

	@PostMapping("/exercise/write")
	@ApiOperation(value="인증 게시글 등록")
	public ResponseEntity<?> writeExercise(@RequestBody Exercise exercise) {
//		User user = (User) session.getAttribute("loginUser");
//		if (user != null) {
//			review.setVideoId(videoId);
//			review.setUserId(user.getUserId());
		
			User user = userService.getUser(exercise.getUserId());
			
			exerciseService.upload(exercise);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@PutMapping("/exercise/modify")
	@ApiOperation(value="리뷰 수정", notes="리뷰 수정하기")
	public ResponseEntity<?> modifyReview(@RequestBody Exercise exercise) {
		exerciseService.modify(exercise);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/exercise/{exerciseId}")
	@ApiOperation(value="리뷰 삭제", notes="리뷰 삭제하기")
	public ResponseEntity<?> removeReview(@PathVariable int exerciseId) {
		exerciseService.delete(exerciseId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}

