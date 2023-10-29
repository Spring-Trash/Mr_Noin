<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp" %>
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
        <h1>-- 주의 --</h1>
        <h2>해당 페이지는 개발 전용 에러처리 페이지입니다.</h2>
        <h2>ERROR CODE : ${code}</h2>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
    </div>
</div>

<script>
    <c:if test="${!empty msg}">
    alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="../includes/footer.jsp" %>
</html>
