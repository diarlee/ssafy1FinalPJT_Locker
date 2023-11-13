package com.ssafy.ssafit.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	// 전체 영상 조회
	public List<Video> selectAll();

	// 부위별 영상 조회
	public List<Video> selectByPart(String part);

	// 조회수 가장 많은 영상 조회
	public Video selectVideo();

	// 운동 영상 조회수 증가
	public void updateViewCnt(@Param("viewCnt") int viewCnt, @Param("videoId")String videoId);

	// 운동 영상 하나 조회
	public Video selectOne(String videoId);
}
