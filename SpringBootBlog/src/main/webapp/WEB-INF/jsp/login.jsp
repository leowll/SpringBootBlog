<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page>
<div class="row">
	<div class="col-md-4">
		 <form method="POST" action="${contextPath}/login" class="form-signin">
	        <h2 class="form-heading">Log in</h2>
			<div class="form-group">
				<span>${message}</span> 
				<input name="username" type="text" class="form-control" placeholder="Username" autofocus="true" /> 
				<input name="password" type="password" class="form-control" placeholder="Password" /> 
				<span>${error}</span>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
			</div>
		</form>
	</div>
</div>
</t:page>