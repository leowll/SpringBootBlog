package blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import blog.entity.Comment;

@Component
public interface CommentRepository extends Repository<Comment, Long> {

	public Page<Comment> findAllByArticleId(Long articleId, Pageable pageable);

	public Page<Comment> findAll(Pageable pageable);


}
