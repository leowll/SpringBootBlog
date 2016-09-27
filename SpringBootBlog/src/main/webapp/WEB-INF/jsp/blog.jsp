<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:page>
	<div class="row">
		<div class="col-md-5 blogs">
			<h2>Blogs</h2>
			<c:if test="${user!=null}">
				<form action="/blog/new" method="get" class="form-group">
					<input type="submit" class="button button-primary" value="New" />
				</form>
			</c:if>
			<c:forEach items="${articles}" var="article">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<a href="/blog/${article.id}"> ${article.title} </a>|${article.createDate }
					</div>
					<div class="panel-body">${article.article}</div>

				</div>

			</c:forEach>
			<t:pagination></t:pagination>
		</div>
	</div>
</t:page>