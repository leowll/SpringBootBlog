<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pagination">
	<c:forEach begin="0" end="${pageCnt-1}" varStatus="loop">
		<li><a href="?pageNo=${loop.index}">${loop.index+1}</a></li>
	</c:forEach>
</ul>