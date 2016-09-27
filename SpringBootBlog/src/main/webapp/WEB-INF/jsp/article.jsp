<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:page>
	<div class="row center-block">
		<div class="col-md-5 blogs">
		<h2>Blogs</h2>
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="/blog/${article.id}"> ${article.title}</a>
						<c:if test="${not empty user }">
						<a href="/blog/${article.id}/edit" class="editButton"><span class="fa fa-pencil"></span>編集</a>
						</c:if>
					</div>
					<div class="panel-body">${article.article}</div>
				</div>
				<div class="comment-part">
					<h4 ><span class="fa fa-comments"></span>Comments</h4>
					<div class="comments">
						<c:forEach items="${comments}" var="comment">
							<div class="panel-heading">
							${comment.username} | ${comment.createDate}
							</div>
							<div class="well">
								${comment.content}
							</div>
						</c:forEach>					
					</div>
					<div class="form-group">
						<form action="/blog/${article.id}/comment" method="post">
							<input type="text" class="form-control" name="username"/>
							<textarea rows="5" class="form-control" name="content"></textarea>
							<input type="submit" class="btn btn-primary form-control" value="Comment"/>
						</form>
					</div>
				</div>
	
		</div>
	</div>
</t:page>