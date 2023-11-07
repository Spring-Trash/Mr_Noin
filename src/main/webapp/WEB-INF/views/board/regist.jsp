
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>

<div class="container">

    <h2>게시글 등록</h2>
    <form method="post" action="regist">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="subject" name="subject">
            <label for="subject">제목 입력</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="content" name="content" >
            <label for="content">내용 입력</label>
        </div>

        <div class="form-floating mb-3">
            <input readonly="readonly" type="text" class="form-control" id="nickname" name="nickname" value="${account.nickname}">
            <label for="nickname">글쓴이</label>
        </div>
        <button type="submit" class="btn btn-primary">전송</button>
        <a href="/" class="btn btn-danger">뒤로가기</a>
    </form>

</div>

<script>
    <c:if test="${!empty msg}">
    alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="../includes/footer.jsp"%>
</html>
