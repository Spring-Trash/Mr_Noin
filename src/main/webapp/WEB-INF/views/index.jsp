<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<body>
<div class="container">
    <div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <c:if test="${empty member}">
            <h1>로그인 해라</h1>
        </c:if>
        <c:if test="${!empty member}">
            <h1>안 녕</h1>
            <h3>상태메시지 : ${member.status}</h3>
        </c:if>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%-- TODO : 대문 바꾸기 --%>
    </div>
    <div class="row d-flex flex-direction-column">
        <a href="/sign-up-page" class="btn btn-primary m-3">회원 가입</a>
        <c:if test="${empty member}">
            <a href="/log-in-page" class="btn btn-warning m-3">로그인</a>
        </c:if>
        <c:if test="${!empty member}">
            <a href="/log-out" class="btn btn-warning m-3">로그아웃</a>
        </c:if>
    </div>
</div>
</body>
<%@include file="includes/footer.jsp" %>
</html>
