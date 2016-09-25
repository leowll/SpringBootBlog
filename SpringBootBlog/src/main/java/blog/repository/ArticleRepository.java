package blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import blog.entity.Article;

@Component
public interface ArticleRepository extends Repository<Article, Long> {
	
	/**
	 * すべての文書を取得するメソッド
	 * @param pageable
	 * @return
	 */
	Page<Article> findAll(Pageable pageable);

	/**
	 * Idによって文書を取得するメソッド
	 * @param id
	 * @return
	 */
	Article findById(Long id);

}
