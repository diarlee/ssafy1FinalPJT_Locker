package com.ssafy.ssafit.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.dto.Heart;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ArticleService;
import com.ssafy.ssafit.model.service.HeartService;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/article")
@CrossOrigin("*")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HeartService heartService;
	
	@GetMapping("/all")
	@ApiOperation(value = "모든 게시글 조회")
	public ResponseEntity<?> getArticleList(){
		List<Article> article = articleService.getAll();
		
		if(article != null) {
			return new ResponseEntity<List<Article>>(article, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/top4")
	@ApiOperation(value = "최신순 4개")
	public ResponseEntity<?> getTopfour(){
		List<Article> article = articleService.getTopFour();
		
		if(article != null) {
			return new ResponseEntity<List<Article>>(article, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/top4to8")
	@ApiOperation(value = "좋아요 순 4 개")
	public ResponseEntity<?> getTopfourTo(){
		List<Article> article = articleService.getTopEight();
		
		if(article != null) {
			return new ResponseEntity<List<Article>>(article, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/isPublic")
	@ApiOperation(value="전체공개 게시글 목록 가져오기")
	public ResponseEntity<?> getPublic(){
		List<Article> articles = articleService.getPublic();
		if( articles != null ) {
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/getId")
	@ApiOperation(value="id와 날짜 기준 게시글 가져오기")
	public ResponseEntity<?> getArticleByDate(@RequestBody Map<String, String> map){
		// 년 월 일만 추출해서 일치하는 걸로 가져오기
		String userId = map.get("userId");
		String date = map.get("date");
		
		Article article = articleService.commit(userId, date);
		
		if(article != null) {
			int articleId = article.getArticleId();
			return new ResponseEntity<Integer>(articleId, HttpStatus.OK);
		} else {
			return new ResponseEntity<Integer>(0, HttpStatus.OK);
		}
		
	}
	
	
	@PostMapping("/write")
	@ApiOperation(value = "게시글 등록")
	public ResponseEntity<?> createArticle(Article article, @RequestParam(required = true) MultipartFile uploadImage) throws IOException{
		User user = userService.getUser(article.getUserId());
		if(user != null) {
			article.setWriter(user.getUsername());
			articleService.writeArticle(article, uploadImage);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/detail/{articleId}")
	@ApiOperation(value = "게시글 상세 조회")
	public ResponseEntity<?> getArticle(@PathVariable int articleId){
		Article article = articleService.getArticle(articleId);
		if(article != null) {
			return new ResponseEntity<Article>(article, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/modify/{articleId}")
	@ApiOperation(value="게시글 수정")
	public ResponseEntity<?> updateArticle(@PathVariable int articleId, Article article, @RequestParam(required = true) MultipartFile uploadImage) throws IOException{
		User user = userService.getUser(article.getUserId());
		if(article.getArticleId() == articleId && user != null && user.getUserId().equals(article.getUserId())) {
			articleService.writeArticle(article, uploadImage);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);			
		} else {
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	

    @GetMapping("/image/{imgFileName}")
    @ApiOperation(value="이미지 가져오기", notes="이거 뭐하는거닞 모르는데 일단 넣기")
    public ResponseEntity<?> getImage(@PathVariable String imgFileName) {
        Resource image = articleService.loadImage(imgFileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imgFileName + "\"")
                .body(image);
    }

	
	@DeleteMapping("/delete/{articleId}")
	@ApiOperation(value="게시글 삭제")
	public ResponseEntity<?> removeArticle(@PathVariable int articleId){
		Article article = articleService.getArticle(articleId);
		User user = userService.getUser(article.getUserId());
		
		if(user != null) {
			articleService.removeArticle(articleId);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		} else {
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_ACCEPTABLE);
		}	
	}
	
	@PutMapping("/like/{articleId}")
	@ApiOperation(value="좋아요 누르기 기능")
	public ResponseEntity<?> likeIt(@PathVariable int articleId, @RequestBody Map<String, String> map){
		System.out.println(map.get("userId"));
		
		String userId = map.get("userId");
		
		if(heartService.selectHeart(userId, articleId) == null) {
			Heart heart = new Heart();
			heart.setUserId(userId);
			heart.setArticleId(articleId);
			
			heartService.insertHeart(heart);
			articleService.plusLike(articleId);
			
			return new ResponseEntity<String>("Like it!", HttpStatus.OK);
		} else {
			Heart heart = heartService.selectHeart(userId, articleId);
			articleService.minusLike(articleId);
			heartService.deleteHeart(heart);
			
			return new ResponseEntity<String>("Cancel T.T", HttpStatus.OK);
		}
	}
	
	
	@PutMapping("/check")
	@ApiOperation(value="게시글 승인")
	public ResponseEntity<?> checkIt(@RequestBody Map<String, String> map){
		
		String userId = map.get("userId");
		int articleId = Integer.parseInt(map.get("articleId"));
		
		if(userId.equals("master")) {
			articleService.checkIt(articleId);
			Article article = articleService.getArticle(articleId);
			userService.scores(article.getUserId());
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("/public")
	@ApiOperation(value="게시글 전체 공개 설정")
	public ResponseEntity<?> isPublic(@RequestBody Map<String, Integer> map){
			int articleId = map.get("articleId");
			articleService.isPublic(articleId);
			return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
