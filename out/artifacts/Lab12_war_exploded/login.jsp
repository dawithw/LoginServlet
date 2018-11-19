<%--
  Created by IntelliJ IDEA.
  User: dawit
  Date: 11/18/18
  Time: 12:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

--%>
<html>
  <head>
    <title>Remeber Me</title>
      <style>
          p {
              color:red;
          }
      </style>
  </head>
  <body>
    <h1>Login</h1>
    <form method="post" action="login">
        <div id="username">
            <label>Username
                <input type="text" name="username" value=""/>
            </label>
        </div>
        <div id="password">
            <label>Password <input type="password" name="pass" value=""/></label>
        </div>
        <div id="remember-me">
            <label>Remember me
                <input type="checkbox" name="remember"/>
            </label>
        </div>
        <input type="submit" value="login"/>
        <p>${login_error}</p>
    </form>
  </body>
</html>
