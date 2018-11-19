<%--
  Created by IntelliJ IDEA.
  User: dawit
  Date: 11/18/18
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome ${user.username}</h1>
    <form method="delete" action="logout">
        <input type="submit" value="logout" />
    </form>
</body>
</html>
