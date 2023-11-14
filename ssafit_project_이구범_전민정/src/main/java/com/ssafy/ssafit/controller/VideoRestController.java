package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class VideoRestController {

	@Autowired
	private VideoService videoService;

	@GetMapping("/video")
	@ApiOperation(value="모든 영상", notes="모든 영상 조회하기")
	public ResponseEntity<?> getList() {
		List<Video> list = videoService.getList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/video/{part}")
	@ApiOperation(value="부위별 영상", notes="부위별 영상 조회하기")
	public ResponseEntity<?> getByPart(@PathVariable String part) {
		List<Video> list = videoService.getByPart(part);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/videoOne/{videoId}")
	@ApiOperation(value="영상 하나 선택", notes="영상 하나 선택하기")
	public ResponseEntity<?> getVideo(@PathVariable String videoId) {
		Video video = videoService.getVideoOne(videoId);
		if (video == null) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			if(videoId.equals(video.getVideoId())) {
				int viewCnt = video.getViewCnt();
				videoService.modifyViewCnt(viewCnt, videoId);
			}
			return new ResponseEntity<Video>(video, HttpStatus.OK);
		}
	}
}
