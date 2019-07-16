<%--
  Created by IntelliJ IDEA.
  User: zhanglong
  Date: 2019/5/1
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="login.action"  method="post">
    ${msg}<br/>
    用户名<input type="text" name="username" ><br/>
    密码<input type="password" name="password" ><br/>
    <input type="submit" value="登录">
</form>

</body>
</html>
