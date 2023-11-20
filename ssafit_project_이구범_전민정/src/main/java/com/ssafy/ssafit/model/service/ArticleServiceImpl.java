package com.ssafy.ssafit.model.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.ssafit.model.dao.ArticleDao;
import com.ssafy.ssafit.model.dto.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	File uploadFolder = new File("uploads");
	Path uploadFolderPath = null;

	ArticleServiceImpl() throws IOException{
		uploadFolderPath = Paths.get(uploadFolder.getCanonicalPath());
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
	public void writeArticle(Article article, MultipartFile image) throws IOException {
		
		if(!uploadFolder.exists()) {
			Files.createDirectory(uploadFolderPath);
		}
		
		if(!image.isEmpty() && image.getSize() != 0) {
			String today = Long.toString(System.currentTimeMillis());
			String newImageName = today + "_" + image.getOriginalFilename();
			
			article.setOrgImage(image.getOriginalFilename());
			article.setImage(newImageName);
			
			Path imagePath = uploadFolderPath.resolve(article.getImage());
			image.transferTo(new File(imagePath.toString()));
		}
		
		articleDao.insertArticle(article);
	}
	
	@Override
	public Resource loadImage(String imageName) {
		// TODO Auto-generated method stub
		
		Path characterImage = uploadFolderPath.resolve(imageName);
		Resource resource;
		try {
			resource = new UrlResource(characterImage.toUri());
			return resource;
		} catch (MalformedURLException e){
			e.printStackTrace();
		}
		return null;
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
	public Article commit(String id, String date) {
		// TODO Auto-generated method stub
		return articleDao.commit(id, date);
	}



}
