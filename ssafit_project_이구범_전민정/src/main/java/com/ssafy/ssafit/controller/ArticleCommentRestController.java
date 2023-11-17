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

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.dto.ArticleComment;
import com.ssafy.ssafit.model.dto.User;
import com.ssafy.ssafit.model.service.ArticleCommentService;
import com.ssafy.ssafit.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("*")
public class ArticleCommentRestController {

	@Autowired
	private ArticleCommentService commentService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all/${articleId}")
	@ApiOperation(value="댓글 보여줘잉")
	public ResponseEntity<?> getList(@PathVariable int articleId){
		List<ArticleComment> list = commentService.getComment(articleId);
		
		if(list != null) {
			return new ResponseEntity<List<ArticleComment>>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/write/${articleId}")
	@ApiOperation(value = "댓글 등록")
	public ResponseEntity<?> createArticle(@PathVariable int articleId, @RequestBody ArticleComment comment){
		User user = userService.getUser(comment.getUserId());
		
		if(user != null && comment.getArticleId() == articleId) {
			commentService.createComment(comment);
			return new ResponseEntity<Void>(HttpStatus.CREATED);			
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	
	@PutMapping("/modify/${articleId}")
	@ApiOperation(value="댓글 수정")
	public ResponseEntity<?> updateArticle(@PathVariable int articleId, @RequestBody ArticleComment comment){
		User user = userService.getUser(comment.getUserId());
		
		if(comment.getArticleId() == articleId && user != null) {
			commentService.modifyComment(comment);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
		
	}
	
	@DeleteMapping("/delete/${articleId}")
	@ApiOperation(value="게시글 삭제")
	public ResponseEntity<?> removeArticle(int commentId, @PathVariable int articleId){
		ArticleComment comment = commentService.getOne(commentId);
		User user = userService.getUser(comment.getUserId());
		
		if(comment.getArticleId() == articleId && user != null) {
			commentService.removeComment(commentId);
			return new ResponseEntity<Void>(HttpStatus.OK);			
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}	
	}
}
