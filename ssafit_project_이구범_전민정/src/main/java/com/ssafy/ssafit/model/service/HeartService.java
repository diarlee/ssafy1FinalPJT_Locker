package com.ssafy.ssafit.model.service;

import com.ssafy.ssafit.model.dto.Heart;

public interface HeartService {

	public Heart selectHeart(String userId, int articleId);
	
	public void insertHeart(Heart heart);
	
	public void deleteHeart(Heart heart);
}
