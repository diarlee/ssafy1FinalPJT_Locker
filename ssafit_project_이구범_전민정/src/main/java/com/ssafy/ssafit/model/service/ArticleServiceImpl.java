package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleDao articleDao;

	public ArticleServiceImpl() {

	}

	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao) {	
		this.articleDao = articleDao;
	}

	@Override
	public List<Article> getAll() {
		// TODO Auto-generated method stub
		return articleDao.selectAll();
	}

	@Override
	public List<Article> getTopFour() {
		return articleDao.selectTopfour();
	}

	@Override
	public List<Article> getTopEight() {
		// TODO Auto-generated method stub
		return articleDao.selectTopeight();
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

	@Override
	public void isPublic(int articleId) {
		// TODO Auto-generated method stub
		articleDao.updatePublic(articleId);
	}
	
	@Override
	public List<Article> getNotChecked() {
		// TODO Auto-generated method stub
		return articleDao.selectNoCheck();
	}

	@Override
	public List<Article> getPublic() {
		// TODO Auto-generated method stub
		return articleDao.selectPublic();
	}

	@Override
	public int commit(String userId, String date) {
		// TODO Auto-generated method stub
		return articleDao.commit(userId, date);
	}


}
