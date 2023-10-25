<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp"%>
<body>
    <div class="container">
        <h2>로그인</h2>
        <form method="post" action="loginconfirm">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floating_input_login_id" name="id">
                <label for="floating_input_login_id">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floating_input_password" name="password" >
                <label for="floating_input_password">Password</label>
            </div>
            <button class="btn btn-primary">전송</button>
            <a href="/" class="btn btn-danger">뒤로가기</a>
        </form>
        <a href="/tosignuppage" class="btn btn-primary">회원가입</a>
    </div>
<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="includes/footer.jsp"%>
</html>
