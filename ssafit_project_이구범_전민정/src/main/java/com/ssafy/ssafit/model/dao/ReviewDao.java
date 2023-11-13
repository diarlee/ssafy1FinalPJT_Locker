package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Review;

public interface ReviewDao {
	// 전체 리뷰 조회 
	public List<Review> selectAllList();

	// 해당하는 리뷰 조회
	public List<Review> selectAll(String videoId);

	// 리뷰 조회
	public Review selectReview(int id);

	// 리뷰 생성
	public void insertReview(Review review);

	// 리뷰 수정
	public void updateReview(Review review);

	// 리뷰 삭제
	public void deleteReview(int id);

}
