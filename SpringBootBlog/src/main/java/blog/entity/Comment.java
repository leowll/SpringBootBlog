package blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String email;
	private Long articleId;
	private String content;
	@Column(name="createdate") //do not use camelCase, or JPA will translate to create_Date
	private Date createDate;
	private Long	replyTo;

	public Comment(){
		
	}
	
	public Comment(Long id,String username,String content){
		this.articleId = id;
		this.username = username;
		this.content = content;
		this.createDate = new Date();
	}
	
	/** 
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return articleId
	 */
	public Long getArticleId() {
		return articleId;
	}
	/**
	 * @param articleId セットする articleId
	 */
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content セットする content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate セットする createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return replyTo
	 */
	public Long getReplyTo() {
		return replyTo;
	}

	/**
	 * @param replyTo セットする replyTo
	 */
	public void setReplyTo(Long replyTo) {
		this.replyTo = replyTo;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username セットする username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
}
