<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp" %>
<body>
<div class="container">
    <div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
            <h1>안 녕</h1>
            <h3>상태메시지 : ${account.status}</h3>
            <img src="../../resources/developer.png" style="height : 200px; width : 200px;"/>
            <h2>이 개발자가</h2>
            <h2>배부르다는 것을 알까요...?</h2>
            <h2>Donate Here...</h2>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <%-- TODO : 대문 바꾸기 --%>
    </div>
    <div class="row d-flex flex-direction-column">
        <button id="logout" class="btn btn-warning m-3">로그아웃</button>
        <button id="tomypage" class="btn btn-warning m-3">마이페이지</button>
    </div>
</div>

<script>
    <c:if test="${!empty msg}">
        alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="includes/footer.jsp" %>
<script>
    document.getElementById("logout").addEventListener("click", function(){
        localStorage.removeItem("jwt_Access");
        localStorage.removeItem("jwt_Refresh");
        location.href("/tologinpage");
    })

    document.getElementById("tomypage").addEventListener("click", function(){

        let message = {
            method : "GET",
            headers : {
                "Content-Type" : "application/json",
                "jwt-auth-token" : localStorage.getItem("jwt_Access"),
                "jwt-ref-token" : localStorage.getItem("jwt_Refresh"),
            }
        }

        fetch("${root}/tomypage", message);
    })
</script>
</html>
