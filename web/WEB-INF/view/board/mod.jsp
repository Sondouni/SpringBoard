<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>수정</h1>
    <form action="/board/mod" method="post">
        <div><input type="hidden" name="iboard" value="${param.iboard}"></div>
        <div><input type="text" name="title" placeholder="title" value="${requestScope.data.title}" ></div>
        <div><textarea name="ctnt" placeholder="context">${requestScope.data.ctnt}</textarea></div>
        <div>
            <input type="submit" value="change">
        </div>
    </form>
</body>
</html>