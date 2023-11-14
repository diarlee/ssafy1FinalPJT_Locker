package com.ssafy.ssafit.model.service;

import java.util.List;

import com.ssafy.ssafit.model.dto.Exercise;

public interface ExerciseService {
	
	// 모든 게시글 조회
	public List<Exercise> getList();
	
	// 게시글 조회
	public Exercise getExercise(int exerciseId);

	// 게시글 등록
	public void upload(Exercise exercise);

	// 게시글 수정 
	public void modify(Exercise exercise);
	
	// 게시글 삭제 
	public void delete(int exerciseId);
}
