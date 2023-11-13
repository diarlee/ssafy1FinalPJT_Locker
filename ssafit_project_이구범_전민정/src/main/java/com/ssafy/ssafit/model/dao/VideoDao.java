package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoDao {
	// 전체 영상 조회
	public List<Video> selectAll();

	// 부위별 영상 조회
	public List<Video> selectByPart(String part);

	// 조회수 가장 많은 영상 조회
	public Video selectVideo();
}
