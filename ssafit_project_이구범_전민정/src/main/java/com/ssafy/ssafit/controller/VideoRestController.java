package com.ssafy.ssafit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.ssafit.model.dto.Video;
import com.ssafy.ssafit.model.service.VideoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/video")
@CrossOrigin("*")
public class VideoRestController {

	@Autowired
	private VideoService videoService;

	@GetMapping("/all")
	@ApiOperation(value="모든 영상", notes="모든 영상 조회하기")
	public ResponseEntity<?> getList() {
		List<Video> list = videoService.getList();
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/{type}")
	@ApiOperation(value="타입별 영상", notes="타입별 영상 조회하기")
	public ResponseEntity<?> getByType(@PathVariable String type) {
		List<Video> list = videoService.getByType(type);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}
	
	@GetMapping("/four/{type}")
	@ApiOperation(value="타입별 영상 4개", notes="타입별 영상 4개 조회하기")
	public ResponseEntity<?> getByTypeFour(@PathVariable String type) {
		List<Video> list = videoService.getByTypeFour(type);
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
		}
	}

	@GetMapping("/one/{videoId}")
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
	
	@PostMapping("/insert")
	@ApiOperation(value="추천 영상 등록하기")
	public ResponseEntity<?> insertVideo(@RequestBody Video video){
//		System.out.println(video);
		if(video != null) {
			videoService.addVideo(video);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/update/{videoId}")
	@ApiOperation(value="추천 영상 수정하기")
	public ResponseEntity<?> updateVideo(@PathVariable String videoId, @RequestBody Video video){
		if(video.getVideoId().equals(videoId) && video != null) {
			videoService.modifyVideo(video);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/delete/{videoId}")
	@ApiOperation(value="추천 영상 삭제하기")
	public ResponseEntity<?> deleteVideo(@PathVariable String videoId){
		videoService.removeVideo(videoId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
}
