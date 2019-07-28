<%--
  Created by IntelliJ IDEA.
  User: zhanglong
  Date: 2019/4/20
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <table border="1px" cellspacing="0" width="50px" align="center">
            <tr>
                <th>用户名</th>
                <th>密码</th>
            </tr>
            <c:forEach items="${list}" var="user">
                <tr>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                </tr>
            </c:forEach>
        </table>
</body>
</html>
