package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.ssafit.model.dao.ArticleCommentDao;
import com.ssafy.ssafit.model.dto.ArticleComment;

@Service
public class ArticleCommentServiceImpl implements ArticleCommentService{

	private ArticleCommentDao commentDao;

	public ArticleCommentServiceImpl() {

	}

	@Autowired
	public ArticleCommentServiceImpl(ArticleCommentDao commentDao) {	
		this.commentDao = commentDao;
	}
	
	
	@Override
	public List<ArticleComment> getComment(int articleId) {
		// TODO Auto-generated method stub
		return commentDao.selectList(articleId);
	}
	
	@Override
	public ArticleComment getOne(int commentId) {
		return commentDao.selectOne(commentId);
	}

	@Override
	public void createComment(ArticleComment comment) {
		// TODO Auto-generated method stub
		commentDao.insertComment(comment);
	}

	@Override
	public void modifyComment(ArticleComment comment) {
		// TODO Auto-generated method stub
		commentDao.updateComment(comment);
	}

	@Override
	public void removeComment(int commentId) {
		// TODO Auto-generated method stub
		commentDao.deleteComment(commentId);
	}

}
