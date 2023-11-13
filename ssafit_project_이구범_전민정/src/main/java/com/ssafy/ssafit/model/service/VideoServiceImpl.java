package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.VideoDao;
import com.ssafy.ssafit.model.dto.Video;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoDao videoDao;

	public VideoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	@Override
	public List<Video> getList() {
		// TODO Auto-generated method stub
		return videoDao.selectAll();
	}

	@Override
	public List<Video> getByPart(String part) {
		// TODO Auto-generated method stub
		return videoDao.selectByPart(part);
	}

	@Override
	public Video getVideo() {
		// TODO Auto-generated method stub
		return videoDao.selectVideo();
	}

	@Override
	public void modifyViewCnt(int viewCnt, String videoId) {
		// TODO Auto-generated method stub
		videoDao.updateViewCnt(viewCnt, videoId);
		
	}

	@Override
	public Video getVideoOne(String videoId) {
		// TODO Auto-generated method stub
		return videoDao.selectOne(videoId);
	}

}
