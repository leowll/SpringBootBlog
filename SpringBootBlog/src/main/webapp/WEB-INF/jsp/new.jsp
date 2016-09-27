<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<t:page>
	<div class="row">
		<div class="col-md-5 blogs">
			<h2>New Blog</h2>
			<div class="form-group">
				<form action="/blog/new" method="post">
					<input id="input-title" class="form-control col-md-10" name="title" type="text" value="${article.title}" autofocus="true" />
					<textarea class="form-control" rows="10" name="article">${article.article}</textarea>
					<input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" />
				</form>
			</div>
		</div>
	</div>
</t:page>