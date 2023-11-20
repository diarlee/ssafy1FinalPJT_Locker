package com.ssafy.ssafit.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.HeartDao;
import com.ssafy.ssafit.model.dto.Heart;

@Service
public class HeartServiceImpl implements HeartService{

	@Autowired
	private HeartDao heartDao;
	
	@Override
	public void insertHeart(Heart heart) {
		// TODO Auto-generated method stub
		heartDao.insertHeart(heart);
	}

	@Override
	public void deleteHeart(Heart heart) {
		// TODO Auto-generated method stub
		heartDao.deleteHeart(heart);
	} 

	@Override
	public Heart selectHeart(String userId, int articleId) {
		// TODO Auto-generated method stub
		return heartDao.selectHeart(userId, articleId);
	}

}
