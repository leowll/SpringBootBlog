package blog.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import blog.entity.Article;
import blog.repository.ArticleRepository;
import blog.service.ArticleService;

@Component
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public Page<Article> findAllArticles(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}

}
