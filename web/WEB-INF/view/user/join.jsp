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
        <form method="post" action="/user/join">
            <div><input type="text" name="uid" placeholder="id" required></div>
            <div><input type="password" name="upw" placeholder="password" required></div>
            <div><input type="password" id="reupw" placeholder="password comfirm" required></div>
            <div><input type="text" name="nm" placeholder="name" required></div>
            <div>
                <label>female<input type="radio" value="0" name="gender" checked></label>
                <label>male<input type="radio" value="1" name="gender"></label>
            </div>
            <div>
                <input type="submit" value="join">
                <input type="reset" value="reset">
            </div>
        </form>
        <script src="/res/js/user/login.js"></script>
</body>
</html>