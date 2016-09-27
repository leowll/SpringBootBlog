<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pagination">
	<c:forEach begin="1" end="${pageCnt}" varStatus="loop">
		<li><a href="/blog?pageNo=${loop.index}">${loop.index}</a></li>
	</c:forEach>
</ul>