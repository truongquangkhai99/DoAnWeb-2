<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="assets/css/register.css">
    </head>
    <body>
        <div class="center">
            <div class="header">Register</div>
            <form class="Menu" method="post">
                <p><input type="text" placeholder="User name" size="50" minlength="5" maxlength="50" id="username"></p>
                <p><input type="email" placeholder="E-mail" size="50" minlength="5" maxlength="50" id="email"></p>
                <p><input type="password" placeholder="Password" size="50" min="8" maxlength="30" id="password"></p>
                <p><input type="password" placeholder="Re Password" min="8" maxlength="30" id="repassword"></p>
                <p><input type="button" value="Register" id="btnRegister"></p>
                <p><a href="login.jsp">Click here to Login</a></p>
              
            </form>
        </div>
    </body>
</html>