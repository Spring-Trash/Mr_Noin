<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-10-18
  Time: AM 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp" %>
<body>
<div class="container">
    <h2>내 정보</h2>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_login_id" name="id">
        <label for="floating_input_login_id">ID</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="password" class="form-control" id="floating_input_password" name="password">
        <label for="floating_input_password">Password</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_nickname" name="nickname">
        <label for="floating_input_nickname">Nickname</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_name" name="name">
        <label for="floating_input_name">name</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_email" name="email">
        <label for="floating_input_email">Email</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_age" name="age">
        <label for="floating_input_age">Age</label>
    </div>
    <div class="form-floating mb-3">
        <input readonly type="text" class="form-control" id="floating_input_status" name="status">
        <label for="floating_input_status">Status</label>
    </div>
    <a href="${root}/page/account/update" class="btn btn-primary">정보수정페이지</a>
    <a href="${root}/page" class="btn btn-warning">홈으로</a>
</div>

</body>
<%@include file="../includes/footer.jsp" %>
<script>
    fetch("http://localhost:8080/account")
    .then((response) => response.json())
    .then((data) => {
        if(data.account != null && data.account != ""){
            document.querySelector("#floating_input_login_id").value = data.account.id;
            document.querySelector("#floating_input_password").value = data.account.password;
            document.querySelector("#floating_input_nickname").value = data.account.nickname;
            document.querySelector("#floating_input_name").value = data.account.name;
            document.querySelector("#floating_input_email").value = data.account.email;
            document.querySelector("#floating_input_age").value = data.account.age;
            document.querySelector("#floating_input_status").value = data.account.status;
        }
    })
</script>
</html>
