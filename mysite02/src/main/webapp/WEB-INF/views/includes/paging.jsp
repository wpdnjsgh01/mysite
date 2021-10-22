<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- pager 추가 -->
<div class="pager">
	<ul>
		<!-- 좌측 -->
		<c:choose>
			<c:when test="${page == 1 }">
				<li>◀</li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.servletContext.contextPath }/board?page=${page-1 }">◀</a></li>
			</c:otherwise>
		</c:choose>
						
		<!-- 중앙 -->
		<c:forEach begin="${startPage }" end="${endPage }" var="pager" step="1">
			<c:choose>
				<c:when test="${page == pager }">
					<li class="selected">${pager }</li>
				</c:when>
				<c:when test="${pager > lastPage }">
					<li>${pager }</li>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.servletContext.contextPath }/board?page=${pager }">${pager }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
						
		<!-- 우측 -->
		<c:choose>
			<c:when test="${page != lastPage }">
				<li><a href="${pageContext.servletContext.contextPath }/board?page=${page+1 }">▶</a></li>
			</c:when>
			<c:otherwise>
				<li>▶</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>					
<!-- pager 추가 -->