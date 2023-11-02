<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp"%>
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
        <form method="post" action="loginconfirm">
            <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floating_input_login_id" name="id">
                <label for="floating_input_login_id">ID</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floating_input_password" name="password" >
                <label for="floating_input_password">Password</label>
            </div>
            <button type="button" id="loginbutton" class="btn btn-primary">전송</button>
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

<script>
    document.getElementById("loginbutton").addEventListener("click", function(){
       let id = document.getElementById("floating_input_login_id").value();
       let password = document.getElementById("floating_input_password").value();

       let obj = {
           "id" : id,
           "password" : password
       };

       let message = {
           method : "POST",
           headers : {
               "Content-Type" : "application/json",
           },
           body : JSON.stringify(obj),
       }

       console.log(message);

       fetch("${root}/loginconfirm", message)
           .then((response) => {
               console.log(response)
               console.log(response.json());
               return response.json();
           })
           .then((data) => {
               console.log("--------loginconfirm");
               console.log(data);

               // if(data.headers.get("jwt-auth-token")) {
               //     let jwt_Access = data.headers.get("jwt-auth-token");
               //     let jwt_Refresh = data.headers.get("jwt-ref-token");
               //     localStorage.setItem("jwt_Access", jwt_Access);
               //     localStorage.setItem("jwt_Refresh", jwt_Refresh);
               //
               //     console.log(jwt_Access);
               //     console.log(jwt_Refresh);
               //
               //     location.href("/");
               // }
           })
    });
</script>