package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Video;

public interface VideoService {
	// 전체 영상 조회
	public List<Video> getList();

	// 타입별 영상 조회
	public List<Video> getByType(String type);

	// 타입별 영상 4개 조회
	public List<Video> getByTypeFour(String type);
	
	// 조회수 가장 많은 영상 조회
	public Video getVideo();
	
	// 운동영상 조회수 증가
	public void modifyViewCnt(int viewCnt, String videoId);
	
	// 운동영상 하나 조회
	public Video getVideoOne(String videoId);
	
	// 운동영상 등록하기
	public void addVideo(Video video);
	
	// 운동영상 수정하기
	public void modifyVideo(Video video);
	
	// 운동영상 삭제하기
	public void removeVideo(String videoId);
}
