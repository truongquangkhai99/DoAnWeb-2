<%@page import="models.Login"%>
<%@ page pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<head>
<title>Edit Profile</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#submit').click(function(){
				alert('thanh cong');
			})
		});
	</script>
<style>
	
body {
	margin-left: 0px;
}

#edit table {
	width: 100%;
	border-collapse: collapse;
	font-size: 20px;
	border: 1px solid #e7e7e7;
}

#edit  td {
	padding-left: 20px;
	width: 80px;
}

#edit   input {
	width: 80%;
	height: 30px;
	margin: 10px 0 10px 0;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
}

#edit  button {
	margin: 10px 0 20px 0;
	height: 30px;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
	background-color: White;
}

#description {
	height: 60px;
}

#edit   .email {
	padding: 15px 0 15px 20px;
}

#edit   .head {
	padding: 10px 0 10px 20px;
	border: 1px solid #e7e7e7;
	background-color: #f8f8f8;
}

#edit {
	margin-top: 30px;
}
</style>
</head>


<body>
	<div class="Profile hide">
		<div style="padding-top: 20px">
			<h1>Edit ProFile</h1>
		</div>
		<hr />
		<div id="edit">
			<form>
				<table>
					<tr>
						<td class="head">Profile form Elements</td>
					</tr>
					<tr>
						<td style="padding-top: 20px"><lable>
							<b>First Name</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="firstName" name="firstName"
							value="${firstName}" placeholder="Enter First Name" />
						</td>
					</tr>
					<tr>
						<td><lable>
							<b>Last Name</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="lastName" name="lastName"
							value="${lastName}" placeholder="Enter Last Name" />
						</td>
					</tr>
					<tr>
						<td><lable>
							<b>Email</b></lable></td>
					</tr>
					<tr>
						<td class="email"><lable>${email}</lable></td>
					</tr>
					<tr>
						<td><lable>
							<b>Phone</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="phone" name="phone"
							placeholder="Enter your phone number" value="${Phone}" />
						</td>
					</tr>
					<tr>
						<td><lable>
							<b>Description</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" style="height: 60px" id="description"
							name="description" value="${description}"></td>
					</tr>
					<tr>
						<td>
							<button type="button" id="submit">Submit button</button>
							<button type="submit" id="reset" formaction="reset" formmethod="post">Reset button</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</body>
	<script>
	function reset() {
		document.getElementById('firstName').innerHTML="";
        document.getElementById('lastName').innerHTML="";
        document.getElementById('phone').innerHTML="";
        document.getElementById('description').innerHTML="";
		}
	</script>

