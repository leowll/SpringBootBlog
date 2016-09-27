package blog.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

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
	private EntityManager em;

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public Page<Article> findAllArticles(Pageable pageable) {
		return articleRepository.findAll(pageable);
	}

	@Override
	public Article findById(Long id) {

		return articleRepository.findById(id);
	}

	@Override
	@Transactional
	public void save(Article newArticle) {
		em.persist(newArticle);
	}

	@Override
	@Transactional
	public void update(Article newArticle) {
		em.merge(newArticle);

	}

	@Override
	@Transactional
	public void delete(Article article) {
		em.remove(article);
	}

}
