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

import com.ssafy.ssafit.model.dto.Article;
import com.ssafy.ssafit.model.service.ArticleService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/article")
@CrossOrigin("*")
public class ArticleRestController {

	@Autowired
	private ArticleService articleService;
	
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
	
	@GetMapping("/detail/${articleId}")
	@ApiOperation(value = "게시글 상세 조회")
	public ResponseEntity<?> detailArticle(@PathVariable int articleId){
		Article article = articleService.getArticle(articleId);
		if(article != null) {
			return new ResponseEntity<Article>(article, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
}
