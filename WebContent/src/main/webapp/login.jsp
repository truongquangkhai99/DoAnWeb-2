<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="assets/css/Login.css">
    </head>
    <body>
        <div class="center">
            <div class="header">Please Sign In</div>
            <form class="Menu" method="post">
                <p><input type="email" placeholder="E-mail" size="50" minlength="5" maxlength="50" id="email"></p>
                <p><input type="password" placeholder="Password" size="50" min="8" maxlength="30" id="password"></p>
                <p><input type="checkbox" size="1" id="checkbox"> Remember Me</p>
                <p><a href="index.jsp"><input type="button" value="Login" id="btnLogin" formaction="index.jsp" formmethod="get"></a></p>
                <p><a href="register.jsp">Click here to Register</a></p>
            </form>
        </div>
    </body>
</html>