<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>
    <div class="container">
        <div style="text-align: center; align-content: center; vertical-align: center; align-items: center">
            <br>
            <br>
            <hr>
            <br>
            <br>
            <div style="margin : auto; border : solid 1px grey; width : fit-content; padding: 10px;">
        <h1>로그인</h1>
        <h1>해주세</h1>
        <h1>요제발</h1>
            </div>
        </div>
        <br><br><hr><br>
        <form method="post" action="login">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floating_input_login_id" name="id">
                <label for="floating_input_login_id">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floating_input_password" name="password" >
                <label for="floating_input_password">Password</label>
            </div>
            <button type="submit" class="btn btn-primary">전송</button>
            <a href="${root}/page" class="btn btn-danger">홈으로</a>
        </form>
        <a href="${root}/page/account/signup" class="btn btn-primary">회원가입</a>
    </div>
<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="../includes/footer.jsp"%>
</html>