package blog.service;

import blog.entity.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {
	Page<Article> findAllArticles(Pageable pageable);
}
