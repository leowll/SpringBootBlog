package repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import entity.Article;
import repository.ArticleRepository;

public class ArticleRepositoryImpl implements ArticleRepository {

	@Override
	public Page<Article> findAll(Pageable pageable) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Article findById(long id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
