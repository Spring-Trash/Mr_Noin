<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp" %>
<body>
<div class="container">
    <div>
        <h1>게시판</h1>
    </div>
    <div class="row d-flex flex-direction-column">
        <a href="${root}/" class="btn btn-warning m-3">홈으로</a>
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
