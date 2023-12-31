package com.ssafy.ssafit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	// 조회수 증가
	public void updateViewCnt(@Param("viewCnt") int viewCnt, @Param("id")int id);

}
