<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>글쓰기</h1>
    <form action="/board/write" method="post">
        <div><input type="text" name="title" placeholder="title"></div>
        <div><textarea name="ctnt" placeholder="context"></textarea></div>
        <div>
            <input type="submit" value="write">
        </div>
    </form>
</body>
</html>