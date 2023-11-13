package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Review;
import com.ssafy.ssafit.model.service.ReviewService;

@RestController
@RequestMapping("/api")
public class ReviewRestController {

	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/reviewAll")
	public ResponseEntity<?> getAllList() {
		List<Review> list = reviewService.getAll();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/review")
	public ResponseEntity<?> getList(String videoId) {
		List<Review> list = reviewService.getList(videoId);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Review>>(list, HttpStatus.OK);
		}
	}
	
	

	@GetMapping("/review/{id}")
	public ResponseEntity<?> getReview(@PathVariable int id) {
		Review review = reviewService.getReview(id);
		if (review == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Review>(review, HttpStatus.OK);
		}
	}

	@PostMapping("/write")
	public ResponseEntity<?> writeReview(Review review) {
		reviewService.writeReview(review);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping("/modify")
	public ResponseEntity<?> modifyReview(Review review) {
		reviewService.modifyReview(review);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@DeleteMapping("/review/{id}")
	public ResponseEntity<?> removeReview(@PathVariable int id) {
		reviewService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
