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
    <h2>내정보수정</h2>
    <form>
        <div class="form-floating mb-3">
            <input readonly type="text" class="form-control" id="floating_input_login_id" name="id" value="${account.id}">
            <label for="floating_input_login_id">ID</label>
        </div>
        <div class="form-floating mb-3">
            <input type="password" class="form-control" id="floating_input_password" name="password">
            <label for="floating_input_password">Password</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_nickname" name="nickname" value="${account.nickname}">
            <label for="floating_input_nickname">Nickname</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_name" name="name" value="${account.name}">
            <label for="floating_input_name">Name</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_email" name="email" value="${account.email}">
            <label for="floating_input_email">Email</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_age" name="age" value="${account.age}">
            <label for="floating_input_age">Age</label>
        </div>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_status" name="status" value="${account.status}">
            <label for="floating_input_status">Status</label>
        </div>
        <button type="button" class="btn btn-primary" id="updatebutton">내정보수정</button>
        <a href="${root}/page" class="btn btn-warning">홈으로</a>
    </form>
</div>
<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>

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

    document.querySelector("#updatebutton").addEventListener("click", function(){
        let id = document.querySelector("#floating_input_login_id").value;
        let password = document.querySelector("#floating_input_password").value;
        let email = document.querySelector("#floating_input_email").value;
        let name = document.querySelector("#floating_input_name").value;
        let nickname = document.querySelector("#floating_input_nickname").value;
        let age = document.querySelector("#floating_input_age").value;
        let status = document.querySelector("#floating_input_status").value;

        let body = {
            "id" : id,
            "password" : password,
            "email" : email,
            "name" : name,
            "nickname" : nickname,
            "age" : age,
            "status" : status,
        }

        let message = {
            method : "PUT",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(body),
        }

        fetch("http://localhost:8080/account", message)
            .then((response) => {
                if(response.ok){
                    location.href = "http://localhost:8080/";
                }
            })
    })
</script>
</body>
<%@include file="../includes/footer.jsp" %>
</html>
