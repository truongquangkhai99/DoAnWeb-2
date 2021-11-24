<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Register</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="assets/css/register.css">
<script type="text/javascript" src= "assets/js/register.js"></script>

</head>
<body>
	<div class="center">
		<div class="header">Register</div>
            <form action ="RegisterController" class="Menu" id ="Menu" method="post" onsubmit="return validateform()">
                <p style="color:red; text-align: left" id ="err"></p>
                 <p style="color:red; text-align: center"></p>
                <p><input type="text" placeholder="User name" size="50"  maxlength="30" id="username" class ="username" name ="username"></p>
                <p><input type="email" placeholder="E-mail" size="50"  id="email" class ="email" name ="email"></p>
                <p><input type="password" placeholder="Password" size="50"  maxlength="30" id="password" class ="password" name ="password"></p>
                <p><input type="password" placeholder="Re Password"  maxlength="30" id="repassword" class ="repassword" name ="repassword"></p>
                <p><button type="submit" value="Register" id="btnRegister">Register</button></p>
                <p><a href="login.jsp">Click here to Login</a></p>
            </form>
    </div>
</body>
</html>