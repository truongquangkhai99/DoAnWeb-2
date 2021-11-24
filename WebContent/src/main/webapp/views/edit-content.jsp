<%-- <%@page import="models.Login"%> --%>
<%@ page pageEncoding="utf-8"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>


<head>
<title>Edit Content</title>

<style>
body {
	margin-left: 0px;
}
#addContent {
	border-radius: 5px;
}
#add table {
	width: 100%;
	border-collapse: collapse;
	font-size: 20px;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
}
#add  td {
	padding-left: 20px;
	width: 80px;
	
}
#add input {
	
	width: 80%;
	height: 30px;
	margin: 10px 0 10px 0;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
	padding-left:10px;
}
#add  button {
	margin: 10px 0 20px 0;
	height: 30px;
	border: 1px solid #e7e7e7;
	border-radius: 5px;
	background-color: White;
}

#add   .head {
	padding: 10px 0 10px 20px;
	border: 1px solid #e7e7e7;
	background-color: #f8f8f8;
}
#addContent textarea {
	width:80%;
	border:1px solid #e7e7e7;
	border-radius: 5px;
	padding:10px 0 10px 10px;
	margin:10px 0 10px 0;
}
#add {
	margin-top: 30px;
	margin-left:30px;
}
</style>
</head>


<body>
	<div class="Profile hide">
		<div style="padding-top: 20px ; margin-left:30px">
			<h1>Edit Content</h1>
		</div>
		<hr style="margin-left:30px; border:0.5px solid #e7e7e7"/>
		<div id="add">
			<form id="addContent">
				<table>
					<tr>
						<td class="head">Content form Elements</td>
					</tr>
					<tr>
						<td style="padding-top: 20px"><lable>
							<b>Title</b></lable></td>
					</tr>
					<tr>
						<td><input type="text" id="title" name="title" minlength="10" maxlength="200"
							value="${title}" placeholder="Enter the title" />
						</td>
					</tr>
					<tr>
						<td><lable>
							<b>Brief</b></lable></td>
					</tr>
					<tr>
						<td><textarea rows="3"  name="brief" form="addContent" maxlength="150" minlength="30" >${brief}</textarea></td>
					</tr>
                                        <tr>
						<td><lable>
							<b>Content</b></lable></td>
					</tr>
					<tr>
						<td><textarea rows="5"  name="content" form="addContent" maxlength="1000" minlength="50">${content}</textarea></td>
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
	function resetButton() {
	document.getElementById('title').innerHTML="";
    document.getElementById('brief').innerHTML="";
    document.getElementById('content').innerHTML="";
		}
	</script>