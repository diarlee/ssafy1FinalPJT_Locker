package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewService {
	// 전체 리뷰 조회
	public List<Review> getList();

	// 리뷰 조회
	public Review getReview(int id);

	// 리뷰 생성
	public void writeReview(Review review);

	// 리뷰 수정
	public void modifyReview(Review review);

	// 리뷰 삭제
	public void removeReview(int id);
}
