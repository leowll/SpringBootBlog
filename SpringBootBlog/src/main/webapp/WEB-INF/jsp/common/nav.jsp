<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav>
<ul class="nav navbar-nav">
	<li><a href="/">Home</a></li>
	<li><a href="/blog">Blog</a></li>
	<c:if test="${user == null}"> 
	<li><a href="/login">Login</a></li>
	</c:if>
	<c:if test="${user != null}"> 
	<li><a href="/logout">Logout</a></li>
	</c:if>
	<li><a href="/about">About</a></li>
</ul>
</nav>
