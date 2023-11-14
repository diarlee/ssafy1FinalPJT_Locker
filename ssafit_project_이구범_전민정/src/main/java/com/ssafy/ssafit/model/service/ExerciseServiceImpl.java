package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ExerciseDao;
import com.ssafy.ssafit.model.dto.Exercise;

@Service
public class ExerciseServiceImpl implements ExerciseService{

	@Autowired
	public ExerciseDao exerciseDao;
	
	
	@Override
	public void upload(Exercise exercise) {
		// TODO Auto-generated method stub
		exerciseDao.insertExercise(exercise);
	}

	@Override
	public void modify(Exercise exercise) {
		// TODO Auto-generated method stub
		exerciseDao.updateExercise(exercise);
	}

	@Override
	public List<Exercise> getList() {
		// TODO Auto-generated method stub
		return exerciseDao.selectAll();
	}

	@Override
	public Exercise getExercise(int exerciseId) {
		// TODO Auto-generated method stub
		return exerciseDao.selectOne(exerciseId);
	}

	@Override
	public void delete(int exerciseId) {
		// TODO Auto-generated method stub
		exerciseDao.deleteExercise(exerciseId);
	}

}
