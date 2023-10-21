
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp"%>
<body>

<div class="container">

    <h2>회원 가입</h2>
<%--    TODO action을 채워 넣으세요--%>
    <form method="post" action="">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_login_id" name="loginId">
            <label for="floating_input_login_id">ID</label>
        </div>

        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floating_input_password" name="password" >
            <label for="floating_input_password">Password</label>
        </div>

        <div class="form-floating mb-3">
            <input type="email" class="form-control" id="floating_input_email" name="email">
            <label for="floating_input_email">Email address</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_user_name" name="name">
            <label for="floating_input_user_name">username</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_nickname" name="nickname">
            <label for="floating_input_nickname">nickname</label>
        </div>
        <button class="btn btn-primary">전송</button>
        <a href="/" class="btn btn-danger">뒤로가기</a>
    </form>

</div>


</body>
<%@include file="includes/footer.jsp"%>
</html>
