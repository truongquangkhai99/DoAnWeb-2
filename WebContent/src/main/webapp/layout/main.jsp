<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">  
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" integrity="sha512-8bHTC73gkZ7rZ7vpqUQThUDhqcNFyYi2xgDgPDHc+GXVGHXq+xPjynxIopALmOPqzo9JZj0k6OqqewdGO3EsrQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.js" integrity="sha512-dqw6X88iGgZlTsONxZK9ePmJEFrmHwpuMrsUChjAw1mRUhUITE5QU9pkcSox+ynfLhL15Sv2al5A0LVyDCmtUw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style type="text/css">
body {
  margin: 0;
}

header {
	text-align: left;
	vertical-align: top;
	padding: 20px;
	height: 50px;
	color: #707070;
	background-color: #f8f8f8;
	text-align-last
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

aside {
	float: left;
	width: 20%;
	border: 1px solid #e9e9e9;
	padding: 10px;
	min-height: 500px;
	background-color: #f8f8f8;
}

section {
	float: left;
	width: 80%;
	border: 1px solid #e9e9e9;
	padding: 10px;
	min-height: 500px;
	text-overflow: clip;
	background-color: white;
	
}

.dropdown {
  position: relative;
  display: inline-block;
  float:right;
  
}
.dropdown a{
 color: black;
}
.dropdown i{
 color: black;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f8f8f8;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  padding: 12px 16px;
  z-index: 1;
  right: 0;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>
	<header>
		<tiles:insertAttribute name="header" />
	</header>
	
	<div class="row">
		<aside>
			<tiles:insertAttribute name="menu" />
		</aside>
		<section>
			<tiles:insertAttribute name="body" />
		</section>
	</div>

	
</body>
</html>