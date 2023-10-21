<%--
  Created by IntelliJ IDEA.
  User: SSAFY
  Date: 2023-10-18
  Time: AM 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<body>
<div class="container">
    <h2>내정보수정</h2>
    <form method="POST" action="memberupdate">
        <div class="form-floating mb-3">
            <input readonly type="text" class="form-control" id="floating_input_login_id" name="id"
                   value="${member.id}">
            <label for="floating_input_login_id">ID</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floating_input_password" name="password">
            <label for="floating_input_password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_nickname" name="nickname"
                   value="${member.nickname}">
            <label for="floating_input_nickname">Nickname</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_email" name="email" vaule="${member.email}">
            <label for="floating_input_email">Email</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_age" name="age" value="${member.age}">
            <label for="floating_input_age">Age</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_status" name="status" value="${member.status}">
            <label for="floating_input_status">Status</label>
        </div>
        <button class="btn btn-primary">확인</button>
        <a href="/" class="btn btn-warning">뒤로가기</a>
    </form>
</div>
<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="includes/footer.jsp" %>
</html>
