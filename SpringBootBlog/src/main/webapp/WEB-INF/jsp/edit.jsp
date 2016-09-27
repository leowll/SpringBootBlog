<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:page>
	<div class="row">
		<div class="col-md-5 blogs">
			<h2>Edit Blog</h2>
			<div class="input-group">
				<form action="/blog/${article.id}/edit" method="post">
					<input class="form-control" name="title" type="text" value="${article.title}" autofocus="true" />
					<textarea class="form-control" rows="10" name="article">${article.article}</textarea>
					<div class="col-md-6">
						<input class="btn btn-primary btn-block" type="submit" value="Submit" />
					</div>
				</form>
				<form action="/blog/${article.id}/delete" method="post">
					<input type="hidden" value="${article.id}" name="articleId"/>
					<div class="col-md-6">
						<input class="btn btn-danger btn-block" type="submit" value="Delete" />
					</div>
				</form>

			</div>
		</div>
	</div>
</t:page>