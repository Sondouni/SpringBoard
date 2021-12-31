<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <div>${requestScope.msg}</div>
    <c:if test="${sessionScope.loginUser.iuser == requestScope.data.writer}">
        <div>
            <button class="btnUpd">change</button>
            <button class="btnDel">delete</button>
        </div>
    </c:if>
    <div class="iboard"
            data-iboard="${requestScope.data.iboard}">
        num : ${requestScope.data.iboard}</div>
    <div>title : ${requestScope.data.title}</div>
    <div>context : ${requestScope.data.ctnt}</div>
    <div>hits : ${requestScope.data.hit}</div>
    <div>wirter : ${requestScope.data.writerNm}</div>
    <div>writeTime : ${requestScope.data.rdt}</div>
    <div>changedTime : ${requestScope.data.mdt}</div>
    <script src="/res/js/board/detail.js"></script>
</body>
</html>