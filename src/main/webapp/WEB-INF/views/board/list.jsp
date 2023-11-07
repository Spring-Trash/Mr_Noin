<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp" %>
<body>
<div class="container">
    <div>
        <h1>게시판</h1>

        <table>
            <thead>
                <tr>
                    <td>글번호</td>
                    <td>글제목</td>
                    <td>글쓴이</td>
                    <td>등록일</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach items="${list}" var="list">
                        <td>${list.no}</td>
                        <td><a href="${root}/board/detail?no=${list.no}">[${list.type}]${list.subject}</a></td>
                        <td>${list.nickname}</td>
                        <td>${list.registdate}</td>
                    </c:forEach>
                </tr>
            </tbody>
        </table>

    </div>
    <div class="row d-flex flex-direction-column">
        <a href="${root}/board/regist" class="btn btn-warning m-3">글쓰기</a>
        <a href="${root}/" class="btn btn-warning m-3">홈으로</a>

        <c:if test="${account.role == 'ADMIN'}">
            <a href="${root}/board/regist/notice?role=${account.role}" class="btn btn-warning m-3">공지사항 등록</a>
        </c:if>
    </div>
</div>

<script>
    <c:if test="${!empty msg}">
    alert("${msg}");
    </c:if>
</script>
</body>
<%@include file="../includes/footer.jsp" %>
</html>
