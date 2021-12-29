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
    <h1>BoardList</h1>
    <div>
        <a href="/board/write"><input type="button" value="write"></a>
    </div>
    <c:choose>
        <c:when test="${fn:length(requestScope.list)==0}">
            <script>
                alert("there's no board");
            </script>
            <div>Nothing</div>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <th>num</th>
                    <th>title</th>
                    <th>hits</th>
                    <th>date</th>
                </tr>
                <c:forEach items="${requestScope.list}" var="item">
                    <tr class="record"
                        data-iboard="${item.iboard}">
                        <td >${item.iboard}</td>
                        <td>${item.title}</td>
                        <td>${item.hits}</td>
                        <td>${item.rdt}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
    <script src="/res/js/board/list.js">
    </script>
</body>
</html>