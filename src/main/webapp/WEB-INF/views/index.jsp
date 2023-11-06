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
            <h1>안 녕</h1>
            <h3>상태메시지 : ${account.status}</h3>
            <img src="../../resources/developer.png" style="height : 200px; width : 200px;"/>
            <h2>이 개발자가</h2>
            <h2>배부르다는 것을 알까요...?</h2>
            <h2>Donate Here...</h2>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%-- TODO : 대문 바꾸기 --%>
    </div>
    <div class="row d-flex flex-direction-column">
        <a href="${root}/logout" class="btn btn-warning m-3">로그아웃</a>
        <a href="${root}/tomypage" class="btn btn-warning m-3">마이페이지</a>
        <a href="${root}/board" class="btn btn-warning m-3">게시판</a>
        <a href="${root}/notice" class="btn btn-warning m-3">공지사항</a>
    </div>
</div>

<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="includes/footer.jsp" %>
</html>
