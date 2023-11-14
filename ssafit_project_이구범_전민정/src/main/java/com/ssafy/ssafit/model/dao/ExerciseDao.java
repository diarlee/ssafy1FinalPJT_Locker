package com.ssafy.ssafit.model.dao;

import java.util.List;

import com.ssafy.ssafit.model.dto.Exercise;

public interface ExerciseDao {

	// 게시글 전체 조회
	List<Exercise> selectAll();
	
	// 게시글 조회
	Exercise selectOne(int exerciseId);
	
	// 게시글 등록 
	void insertExercise(Exercise exercise);

	// 게시글 수정
	void updateExercise(Exercise exercise);

	// 게시글 삭제
	void deleteExercise(int exerciseId);

	
}
