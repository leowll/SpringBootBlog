package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Article {

	@Id
	@GeneratedValue
	@Column(name = "article_id")
	private long id;
	@Column(name = "article_title")
	private String title;
	@Column(name = "article_article")
	private String article;
	@Column(name = "article_create_date")
	private Date createDate;

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            セットする id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            セットする title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return article
	 */
	public String getArticle() {
		return article;
	}

	/**
	 * @param article
	 *            セットする article
	 */
	public void setArticle(String article) {
		this.article = article;
	}

	/**
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            セットする createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
