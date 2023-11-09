
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>

<div class="container">

    <h2>회원 가입</h2>
    <form>
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_login_id" name="id">
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
            <input type="text" class="form-control" id="floating_input_name" name="name">
            <label for="floating_input_name">name</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_nickname" name="nickname">
            <label for="floating_input_nickname">nickname</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_age" name="age">
            <label for="floating_input_age">age</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floating_input_status" name="status">
            <label for="floating_input_status">status</label>
        </div>
        <button type="button" id="signupbutton" class="btn btn-primary">전송</button>
        <a href="${root}/page" class="btn btn-danger">홈으로</a>
    </form>

</div>

<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>

    document.querySelector("#signupbutton").addEventListener("click", async function(){
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
            method : "POST",
            headers : {
                "Content-Type" : "application/json",
            },
            body : JSON.stringify(body),
        }

        await fetch("http://localhost:8080/account", message)
            .then((response) => {
                if(response.ok){
                    location.href = "http://localhost:8080/";
                }
            });
    })
</script>
</body>
<%@include file="../includes/footer.jsp"%>
</html>
