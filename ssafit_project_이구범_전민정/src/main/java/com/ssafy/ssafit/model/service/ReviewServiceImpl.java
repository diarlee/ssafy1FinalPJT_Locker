package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ReviewDao;
import com.ssafy.ssafit.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewDao reviewDao;

	public ReviewServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	@Override
	public List<Review> getAll() {
		// TODO Auto-generated method stub
		return reviewDao.selectAllList();
	}

	@Override
	public List<Review> getList(String videoId) {
		
		
		return reviewDao.selectAll(videoId);
	}

	@Override
	public Review getReview(int id) {
		// TODO Auto-generated method stub
		return reviewDao.selectReview(id);
	}

	@Override
	public void writeReview(Review review) {
		// TODO Auto-generated method stub
		reviewDao.insertReview(review);
	}

	@Override
	public void modifyReview(Review review) {
		// TODO Auto-generated method stub
		reviewDao.updateReview(review);
	}

	@Override
	public void removeReview(int id) {
		// TODO Auto-generated method stub
		reviewDao.deleteReview(id);
	}

	@Override
	public void modifyViewCnt(int viewCnt, int id) {
		reviewDao.updateViewCnt(viewCnt, id);
	}


}
