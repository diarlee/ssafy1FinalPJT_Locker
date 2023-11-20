package com.ssafy.ssafit.model.dao;

import org.apache.ibatis.annotations.Param;

import com.ssafy.ssafit.model.dto.Heart;

public interface HeartDao {

	void insertHeart(Heart heart);

	void deleteHeart(Heart heart);

	Heart selectHeart(@Param("userId") String userId, @Param("articleId") int articleId);

}
