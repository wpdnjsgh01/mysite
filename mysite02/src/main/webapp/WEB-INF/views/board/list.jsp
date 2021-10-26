<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath }/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.request.contextPath }/board?a=search"
					method="post">
					<input type="text" id="kwd" name="kwd" value=""> <select
						id="box" name="box" size="1">
						<option value="tit">제목으로</option>
						<option value="cont">내용으로</option>
					</select> <input type="submit" value="검색">
					<table class="tbl-ex">
						<tr>
							<th>번호</th>
							<th style="text-align: left">제목</th>
							<th>글쓴이</th>
							<th>조회수</th>
							<th>작성일</th>
							<th>&nbsp;</th>
						</tr>
						<c:forEach items='${list }' var='vo' varStatus='status'>
							<c:set var='dto' value='${list2[status.index] }' />

							<!-- 원본글 시작 -->
							<c:choose>

								<c:when test="${vo.depth == 0 && vo.delete_check == false}">
									<tr>
										<td>${vo.no }</td>
										<td style="text-align: left; padding-left: 0px"><a
											href="${pageContext.request.contextPath }/board?a=view&no=${vo.no}">${vo.title }</a></td>
										<td>${dto.userName }</td>
										<td>${vo.hit }</td>
										<td>${vo.regDate }</td>
										<c:choose>
											<c:when test="${authUser.no == vo.userNo }">
												<td><a
													href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no}">
														<img
														src="${pageContext.request.contextPath }/assets/images/recycle.png" />
												</a></td>
											</c:when>
											<c:otherwise>
												<td></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>

								<c:when test="${vo.depth == 0 && vo.delete_check == true }">
									<tr>
										<td>&nbsp;</td>
										<td style="text-align: left; padding-left: 0px">삭제되었습니다.</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
								</c:when>

							</c:choose>
							<!-- 원본글 end -->

							<!-- 댓글 start -->
							<c:choose>

								<c:when test="${vo.depth != 0 && vo.delete_check == false}">
									<tr>
										<td>${vo.no }</td>
										<td style="text-align:left; padding-left:${20*vo.depth }px">
											<img
											src='${pageContext.servletContext.contextPath }/assets/images/reply.png' />
											<a
											href="${pageContext.request.contextPath }/board?a=view&no=${vo.no}">
												${vo.title } </a>
										</td>
										<td>${dto.userName}</td>
										<td>${vo.hit }</td>
										<td>${vo.regDate }</td>
										<c:choose>
											<c:when test="${authUser.no == vo.userNo }">
												<td><a
													href="${pageContext.request.contextPath }/board?a=delete&no=${vo.no}">
														<img
														src="${pageContext.request.contextPath }/assets/images/recycle.png" />
												</a></td>
											</c:when>
											<c:otherwise>
												<td></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:when>

								<c:when test="${vo.depth != 0 && vo.delete_check == true}">
									<tr>
										<td></td>
										<td style="text-align:left; padding-left:${20*vo.depth }px">
											<img
											src='${pageContext.servletContext.contextPath }/assets/images/reply.png' />
											삭제되었습니다.
										</td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</c:when>

							</c:choose>
							<!-- 댓글 start -->

						</c:forEach>
					</table>
				</form>
				

				<div class="pager">
					<ul>
						<c:if test="${page.pageSet == 1}">
							<li>◀</li>
						</c:if>
						<c:if test="${page.pageSet != 1}">
							<li><a
								href="${pageContext.request.contextPath }/board?a=list&cur=${page.prevPage}&keyword=${param.keyword}">◀</a></li>
						</c:if>



						<c:choose>
							<c:when test = "${page.totalPage <= status.index}">
								<c:forEach begin="${page.beginPage }" end="${page.endPage }" step="1" varStatus="status">
									<li>
										<a href="${pageContext.request.contextPath }/board?a=list&cur=${status.index}&keyword=${param.keyword}">${status.index}
										</a>
									</li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<li>
									${status.index}
								</li>
							</c:otherwise>
						</c:choose>
						
						
					
						<c:if test="${page.nextPage != -1 }">
							<li>
								<a href="${pageContext.request.contextPath }/board?a=list&cur=${page.nextPage }&keyword=${param.keyword}">▶</a>
							</li>
						</c:if>
						<c:if test="${page.pageSet == page.totalPage }">
							<li>▶</li>
						</c:if>
					</ul>
				</div>


				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?a=writeform"
						id="new-book">글쓰기</a>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>