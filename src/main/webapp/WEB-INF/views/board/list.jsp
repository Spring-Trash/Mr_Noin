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
            <tbody id="list">
            </tbody>
        </table>

    </div>
    <div class="row d-flex flex-direction-column">
        <a href="${root}/board/regist" class="btn btn-warning m-3">글쓰기</a>
        <a href="${root}/page" class="btn btn-warning m-3">홈으로</a>

        <c:if test="${account.role == 'ADMIN'}">
            <a href="${root}/page/notice/regist" class="btn btn-warning m-3">공지사항 등록</a>
        </c:if>
    </div>
</div>

<script>
    <c:if test="${!empty msg}">
    alert("${msg}");
    </c:if>

    fetch("http://localhost:8080/board")
    .then((response) => response.json())
    .then((data) => data.body.list)
    .then((list) => {
        let tbody = ``;
        for(item of list){
            tbody +=
                `<tr>` +
                `<td>` + item.no + `</td>` +
                `<td><a href="http://localhost:8080/board/` + item.no + `">[` + item.type + `]` + item.subject + `</a></td>` +
                `<td>` + item.nickname + `</td>` +
                `<td>` + item.registdate + `</td>` +
                `</tr>`;
        }
        document.querySelector("#list").innerHTML = tbody;
    })
</script>
</body>
<%@include file="../includes/footer.jsp" %>
</html>
