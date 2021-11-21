<%-- <%@page import="models.Login"%> --%>
<%@ page pageEncoding="utf-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>


<head>
<title>Edit Profile</title>

<style>
body {
	margin-left: 0px;
}
#editProfile {
	border-radius: 5px;
}
#edit table {
	width: 100%;
	border-collapse: collapse;
	font-size: 20px;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
}
#edit  td {
	padding-left: 20px;
	width: 80px;
	
}
#edit input {
	
	width: 80%;
	height: 30px;
	margin: 10px 0 10px 0;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
	padding-left:10px;
}
#edit  button {
	margin: 10px 0 20px 0;
	height: 30px;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
	background-color: White;
}
#edit   .email {
	padding: 15px 0 15px 20px;
}
#edit   .head {
	padding: 10px 0 10px 20px;
	border: 1px solid #e7e7e7;
	background-color: #f8f8f8;
}
#editProfile textarea {
	width:80%;
	border:1px solid #e7e7e7;
	border-radius: 5px;
	padding:10px 0 10px 10px;
	margin:10px 0 10px 0;
}
#edit {
	margin-top: 30px;
	margin-left:30px;
}
</style>
</head>


<body>
	<div class="Profile hide">
		<div style="padding-top: 20px ; margin-left:30px">
			<h1>Edit ProFile</h1>
		</div>
		<hr style="margin-left:30px; border:0.5px solid #e7e7e7"/>
		<div id="edit">
			<form id="editProfile">
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
						<td><textarea rows="3"  name="description" form="editProfile" >${description}</textarea></td>
					</tr>
					<tr>
						<td>
							<button type="submit" id="submit" formaction="login"
								formmethod="post">Submit button</button>
							<button type="button" id="reset" onclick="">Reset button</button>
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