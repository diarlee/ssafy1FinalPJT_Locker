package com.ssafy.ssafit.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

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

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ReviewService;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
public class ReviewRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/reviewAll")
	@ApiOperation(value = "모든 리뷰 조회", notes = "모든 리뷰 조회하기")
	public ResponseEntity<?> getAllList() {
		List<Review> list = reviewService.getAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/review/{videoId}")
	@ApiOperation(value = "리뷰 조회", notes = "영상 아이디에 해당하는 모든 리뷰 조회하기")
	public ResponseEntity<?> getList(@PathVariable String videoId) {
		List<Review> list = reviewService.getList(videoId);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/review/detail/{id}")
	@ApiOperation(value = "리뷰 상세 조회", notes = "리뷰 상세 조회하기")
	public ResponseEntity<?> getReview(@PathVariable int id) {
		Review review = reviewService.getReview(id);
		if (review == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			if (id == review.getReviewId()) {
				int viewCnt = review.getViewCnt();
				reviewService.modifyViewCnt(viewCnt, id);
			}
			return new ResponseEntity<Review>(review, HttpStatus.OK);
		}
	}

	@PostMapping("/review/write")
	@ApiOperation(value = "리뷰 등록", notes = "리뷰 작성하기")
	public ResponseEntity<?> writeReview(@RequestBody Review review) {
//		User user = (User) session.getAttribute("loginUser");
//		if (user != null) {
//			review.setVideoId(videoId);
//			review.setUserId(user.getUserId());

		User user = userService.getUser(review.getUserId());
		review.setWriter(user.getUsername());

		reviewService.writeReview(review);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
//		} else {
//			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//		}
	}

	@PutMapping("/review/modify/{id}")
	@ApiOperation(value = "리뷰 수정", notes = "리뷰 수정하기")
	public ResponseEntity<?> modifyReview(Review review, @PathVariable int id) {

		if (review.getReviewId() == id) {
			reviewService.modifyReview(review);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/review/{id}")
	@ApiOperation(value = "리뷰 삭제", notes = "리뷰 삭제하기")
	public ResponseEntity<?> removeReview(@PathVariable int id) {
		reviewService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
