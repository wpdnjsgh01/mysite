<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- pager 추가 -->
<div class="pager">
	<ul>
		<c:if test="${pager.prevPage == -1 }">
			<li>◀</li>
		</c:if>
		<c:if test="${pager.prevPage != -1 }">
			<li><a
				href="${pageContext.request.contextPath }/board?a=list&cur=${pager.prevPage}&keyword=${param.keyword}">◀</a></li>
		</c:if>

		<c:forEach begin="${pager.begin }" end="${pager.end }" step="1"
			varStatus="status">
			<c:choose>
				<c:when test="${status.index <= pager.totalPage }">
					<c:if test="${status.index == pager.curPage}">
						<li class="selected">${status.index}</li>
					</c:if>
					<c:if test="${status.index != pager.curPage}">
						<li><a
							href="${pageContext.request.contextPath }/board?a=list&cur=${status.index}&keyword=${param.keyword}">${status.index}</a></li>
					</c:if>
				</c:when>

				<c:otherwise>
					<li>${status.index }</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${pager.nextPage != -1 }">
			<li><a
				href="${pageContext.request.contextPath }/board?a=list&cur=${pager.nextPage }&keyword=${param.keyword}">▶</a></li>
		</c:if>
		<c:if test="${pager.nextPage == -1 }">
			<li>▶</li>
		</c:if>
	</ul>
</div>
<!-- pager 추가 -->