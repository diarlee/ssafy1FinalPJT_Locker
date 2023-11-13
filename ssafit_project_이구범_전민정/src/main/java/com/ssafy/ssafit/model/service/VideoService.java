package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	// 전체 영상 조회
	public List<Video> getList();

	// 부위별 영상 조회
	public List<Video> getByPart(String part);

	// 조회수 가장 많은 영상 조회
	public Video getVideo();
}
