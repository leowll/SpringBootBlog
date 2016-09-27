package blog.service.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import blog.entity.Comment;
import blog.repository.CommentRepository;
import blog.service.CommentService;

@Component
public class CommentServiceImpl implements CommentService {

	@Autowired
	private EntityManager em;
	@Autowired
	private CommentRepository repository;

	@Override
	public Page<Comment> findByArticleId(Long articleId, Pageable pageable) {
		return repository.findAllByArticleId(articleId, pageable);
	}

	@Override
	public Page<Comment> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	@Transactional
	public void saveOrUpdate(Comment comment) {
		if (comment.getId() == null) {
			em.persist(comment);
		} else {
			em.merge(comment);
		}
	}
 
}
