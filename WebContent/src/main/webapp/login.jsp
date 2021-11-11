<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<style>
	#login {
    font-size:20px ;
    line-height : 20px;
    padding: 0 400px 0 0;
    width:250px;
  }
  #login input {
    margin: 10px 0 10px 10px;
  }
  #login lable {
  	padding:10px 0 10px 10px;
  	margin:10px 0 10px 0;
  }
  h1 {
  	padding-left:10px;
  }
</style>
</head>
<body>
	<div id = "login">
	<fieldset>  
		<h1> Login</h1>
		<form action="login" method ="get">
			<lable>Username or email address</lable></br>
        <input type="text" name="UserName"/> </br>
        <lable>	Password </lable> </br>
        <input type="password" name="Password" /> </br>
        <input type="submit" value="login"/>
        <input type="radio">remember me </br>
        <a href ="Register.jsp"><u>lost your password</u> </a>
		</form>
	</fieldset>
	</div>
</body>
</html>