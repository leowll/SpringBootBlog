package blog.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import blog.repository.ArticleRepository;
import blog.entity.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ArticleRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ArticleRepository articles;

	@Test
	public void testFindById() {
		Article article = new Article("1st", "abcdefg");
		entityManager.persist(article);
		Article a = articles.findById(1);
		assertNotNull(a);
	}
}
