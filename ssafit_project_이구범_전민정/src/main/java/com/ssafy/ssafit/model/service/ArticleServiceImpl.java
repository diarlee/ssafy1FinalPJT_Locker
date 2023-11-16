package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getAll() {
		// TODO Auto-generated method stub
		return articleDao.selectAll();
	}

	@Override
	public Article getArticle(int articleId) {
		// TODO Auto-generated method stub
		return articleDao.selectOne(articleId);
	}

	@Override
	public void writeArticle(Article article) {
		articleDao.insertArticle(article);
		
	}

	@Override
	public void modifyArticle(Article article) {
		articleDao.updateArticle(article);		
	}

	@Override
	public void removeArticle(int articleId) {
		articleDao.deleteArticle(articleId);
		
	}

	@Override
	public void likeIt(int articleId) {
		articleDao.updateLike(articleId);		
	}

	@Override
	public void checkIt(int articleId) {
		articleDao.updateCheck(articleId);		
	}

}
