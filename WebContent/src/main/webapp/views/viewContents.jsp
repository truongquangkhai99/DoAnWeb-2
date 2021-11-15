<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () {
    	var timeDelay = 1000;           // MILLISECONDS (5 SECONDS).
    	setTimeout( function (){
        		$(".view-content").removeClass("hide");
        		$(".loading").addClass("hide");
        	}, timeDelay);
    	
    });	
   
</script>
</head>
<div class="loading">Loading</div>
<div  class="view-content hide">
	<h1 style="">View Content</h1>
	<div class="content-container" >
		<div class="header-content" >View Content List</div>
			<div class ="table-content" >		
				<table class="ui celled table">
				  <thead>
				    <tr><th>#</th>
				    <th>Title</th>
				    <th>Brief</th>
				    <th>Date Create</th>
				    <th>Action</th>
				  </tr></thead>
				  <tbody>
				  <c:forEach var="content" items="${listContent}">
				    <tr>
				      <td data-label="Name"><c:out value="${content.id}"/></td>
				      <td data-label="Age"><c:out value="${content.title}"/></td>
				      <td data-label="Job"><c:out value="${content.brief}"/></td>
				      <td data-label="Job"><c:out value="${content.datecreate}"/></td>
				      <td data-label="Job"><a href="#">Edit</a> <p > Delete </p></td>
				    </tr>
				    </c:forEach>
				    
				  </tbody>
				</table>
		</div>
	</div>
</div>

<style>
section{
	padding: 40px 30px 0;
}
.view-content h1{
	border-bottom: solid #eee 1.4px; 
	padding-bottom: 10px;
	font-weight: 500;
}
.content-container {
	border:  2px solid #eee; 
	border-radius: 10px;
}
.content-container .header-content{
	background-color: #eeeeee9c;
	padding-top: 10px;
	margin-top: -1px;padding-left: 20px ;
	padding-bottom: 10px ; 
	font-size: 16px;
	border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
.content-container .table-content{
	padding: 12px 12px 24px;
}
.table-content table{
    border-radius: 0 !important;
}
.table-content .table thead th {
	font-weight:1000;
}
.table-content table tr:nth-child(2n+1)
{
	background: #eeeeee9c;
}
.ui.table thead th{
background:#fff;'
}
.table-content tbody td:first-child {
	max-width: 20px;
	word-wrap:break-word;
}
.table-content tbody td:nth-child(2){
	min-width: 140px;
	max-width: 200px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(3){
	min-width: 240px;
	max-width: 600px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(4){
	min-width: 30px;
	max-width: 60px;
	word-wrap: break-word;
}
.table-content tbody td:nth-child(5){
	min-width: 60px;
	max-width: 60px;
	word-wrap: break-word;
	text-align: center;
}
.table-content td p{
	display:inline-block;
	cursor: pointer;
	margin-left: 10px;
	color: #4183c4;
}
.loading{
    margin-left: 45px;
    margin-top: 34px;
    font-size: 24px;
}
.hide {
    display: none
}
</style>
