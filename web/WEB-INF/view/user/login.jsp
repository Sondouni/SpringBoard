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
    <div class="msgAlert">${requestScope.msg}</div>
    <div>
        <form method="post" action="/user/login">
            <div>ID&nbsp;:&nbsp;&nbsp;<input type="text" name="uid" placeholder="ID"></div>
            <div>PW&nbsp;:&nbsp;&nbsp;<input type="password" name="upw" placeholder="PASSWORD"></div>
            <div><input type="submit" class="loginBtn" value="login"></div>
        </form>
        <div>
            <a href="/user/join"><input type="button" value="Join"></a>
            <a href="/board/list"><input type="button" value="without login"></a>
        </div>
    </div>
    <script src="/res/js/user/login.js?ver=1"></script>
</body>
</html>