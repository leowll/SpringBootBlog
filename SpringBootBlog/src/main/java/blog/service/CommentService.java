package blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import blog.entity.Comment;

public interface CommentService {

	Page<Comment> findAll(Pageable pageable);

	public Page<Comment> findByArticleId(Long articleId, Pageable pagebale);

	void saveOrUpdate(Comment comment);
}
