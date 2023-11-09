
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>

<div class="container">

        <div class="form-floating mb-3">
            <input readonly="readonly" type="text" class="form-control" id="subject" name="subject" value="${board.subject}">
            <label for="subject">제목 입력</label>
        </div>

        <div class="form-floating mb-3">
            <input readonly="readonly" type="text" class="form-control" id="content" name="content" value="${board.content}">
            <label for="content">내용 입력</label>
        </div>

        <div class="form-floating mb-3">
            <input readonly="readonly" type="text" class="form-control" id="nickname" name="nickname" value="${board.nickname}">
            <label for="nickname">status</label>
        </div>

    <div class="row d-flex flex-direction-column">
        <a href="${root}/board/update?no=${board.no}" class="btn btn-warning m-3">글수정</a>
        <a href="${root}/page" class="btn btn-warning m-3">홈으로</a>
    </div>

</div>

<script>
    <c:if test="${!empty msg}">
    alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="../includes/footer.jsp"%>
</html>
