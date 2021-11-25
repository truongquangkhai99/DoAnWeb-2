<%@ page pageEncoding="utf-8"%>

<head>
<title>Edit Profile</title>
	<meta charset="utf-8">
	    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.2.1.min.js"></script>
	    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js" type="text/javascript"></script>
	    <script src="assets/js/editprofile.js" type="text/javascript"></script>
	<link rel="stylesheet" type="text/css" href="assets/css/editprofile.css">
</head>


<body>
	<div class="Profile hide">
		<div style="padding-top: 20px">
			<h1>Edit ProFile</h1>
		</div>
		<hr />
		<div id="edit">
			<form id="formEditProfile" >
				<table>
					<tr>
						<td class="head">Profile form Elements</td>
					</tr>
					<tr>
						<td style="padding-top: 20px"><lable> <b>First
								Name</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="firstName" name="firstName"
							value="${firstName}" placeholder="Enter First Name" maxlength="30"/></td>
					</tr>
					<tr>
						<td><lable> <b>Last Name</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="lastName" name="lastName"
							value="${lastName}" placeholder="Enter Last Name" maxlength="30"/></td>
					</tr>
					<tr>
						<td><lable> <b>Email</b></lable></td>
					</tr>
					<tr>
						<td class="email"><lable> <span id="email">${email}</span></lable></td>
					</tr>
					<tr>
						<td><lable> <b>Phone</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="phone" name="phone"
							placeholder="Enter your phone number" value="${Phone}" /></td>
					</tr>
					<tr>
						<td><lable> <b>Description</b></lable></td>
					</tr>
					<tr>
						<td><textarea rows="3"  name="description" id="description" form="formEditProfile" maxlength="200" >${description}</textarea></td>
					</tr>
					<tr>
						<td>
							<button type="submit" id="submit" formaction="editprofile" formmethod="post">Submit button</button>
							<button type="submit" id="reset" formaction="editprofile"
								formmethod="get">Reset button</button>
						</td>
					</tr>
				</table>
			</form>
			
		</div>
	</div>

</body>