package blog.service;

import blog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
	Page<Article> findAllArticles(Pageable pageable);
	
	Article findById(Long id);

	void save(Article newArticle);
	
	void update(Article newArticle);
	
	void delete(Article article);
}
