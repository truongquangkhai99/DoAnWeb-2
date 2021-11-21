<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function () { 
    	var timeDelay = 1000;  	
    	setTimeout( function (){
        		$(".view-content").removeClass("hide");
        		$(".loading").addClass("hide");
        	}, timeDelay);
    	
    	$("#page-${pageid}").addClass("page-current");
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
				    <tr><th><b>#</b></th>
				    <th><b>Title</b></th>
				    <th><b>Brief</b></th>
				    <th><b>Created Date</b></th>
				    <th><b>Action</b></th>
				  </tr></thead>
				  <tbody>
				  <c:forEach var="content" items="${listContent}">
				    <tr class="top aligned">
				      <td ><c:out value="${content.id}"/></td>
				      <td ><div><c:out value="${content.title}"/></div></td>
				      <td ><c:out value="${content.brief}"/></td>
				      <td ><c:out value="${content.datecreate}"/></td>
				      <td ><a href="#">Edit</a> <p onclick="$.post('ViewContent', { id :<c:out value='${content.id}' />}); $(this).parent().parent().addClass('hide');" > Delete </p></td>
				    </tr>
				    </c:forEach>
				    
				  </tbody>
				</table>
		</div>
	</div>
	
	<c:set var="currentpage" value="${pageid}"/>
	<div class="page-action">
	 	<c:if test = "${pageid > 1}">
			<a class="link-previous" href="<%=request.getContextPath()%>/ViewContent?pageid=${pageid-1}"><i class="angle double left icon"></i>Previous</a>
		</c:if>
		<c:if test = "${pageid < numberpage}">
			<a class="link-next" href="<%=request.getContextPath()%>/ViewContent?pageid=${pageid+1}">Next<i class="angle double right icon"></i></a>
		</c:if>
	</div>
	
	<ul class="list-page">
	<c:forEach begin="1" end="${numberpage}" var="i">
		 	<li id="page-${i}"  ><a class="page-link" href="<%=request.getContextPath()%>/ViewContent?pageid=${i}">${i}</a></li>
		 </c:forEach>
	</ul>
</div>

<style>


.page-current{
	background-color: #d0d9cd;
}


.page-action{
    margin-top: 15px;
    margin-bottom: 10px;
}

.page-action a:hover{
    opacity: 0.7;
}

.page-action a{
	font-weight: 700;
    color: #0e5b95;
}
.link-previous{
    display: inline-block;  
}

.link-next{
    display: inline-block;
    margin-left: 15px;
}


.list-page{
    list-style: none;
    margin-top:0px;
}

.list-page li{
	display: inline-block;
    border: 1px #d8d7d7c9 solid;
    min-width: 32px;
    text-align: center;
    margin-top: 4px;
    font-size: 17px;

}
.list-page a{
    display: block;
    padding: 4px;
}
.list-page a:hover{
    background-color: #f3f2f2;
}

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

.table-content a{
	color: #050505de;
	font-weight: bold;
}

.table-content a:hover{
	opacity: 0.7
}

.table-content table{
    border-radius: 0 !important;
}

.table-content .table thead th {
    font-family: Helvetica;
	font-weight:400;
	font-size:16px;
	color: black;
	border-bottom-width: 3px;
}
.ui.table thead tr:first-child>th:first-child{
	border-radius:unset;
}
.ui.table thead tr:first-child>th:last-child{
	border-radius:unset;
}

.table-content table tr:nth-child(2n+1)
{
	background: #eeeeee9c;
}
.ui.table thead th{
background:#fff;
}


.ui.table thead tr:first-child>th:first-child {
    padding-left: 10px;
    padding-right: 10px;
 }
.table-content tbody td:first-child {
	max-width: 10px;
	word-wrap:break-word;
	padding: unset;
    text-align: center;
    padding-top: 11px;
}

.table-content tbody td:nth-child(2){
	min-width: 160px;
	max-width: 200px;
	word-wrap:break-word;
}
.table-content tbody td:nth-child(3){
	min-width: 220px;
	/* word-wrap:break-word;*/
}

.table-content thead  th:nth-child(4),
.table-content thead  th:nth-child(5){
	max-width: 60px;
}
.table-content tbody td:nth-child(4){
	min-width: 30px;
	max-width: 160px;
	/*max-width: 120px;*/
	word-wrap:break-word;
}
.table-content tbody td:nth-child(5){
	min-width: 100px;
    word-wrap:break-word;
	text-align: center;
}

.table-content td p{
	display:block;
	cursor: pointer;
	color: #050505de;
	padding-top: 1px;
	font-weight: bold;
}

.table-content td p:hover{
    opacity: 0.7;
}

.loading{
    margin-left: 45px;
    margin-top: 34px;
    font-size: 24px;
}

.hide {
    display: none
}

.view-content ul{
	margin-bottom: 30px;
}


@media only screen and (max-width: 1023px){
	.table-content tbody td:nth-child(5){
		min-width: 20px;
	}
	.table-content tbody td:nth-child(2){
		min-width: 115px;
	}
}


@media only screen and (max-width: 767px){
.table-content tbody td:nth-child(4) {
    max-width: unset;
}
.table-content tbody td:first-child {
    max-width: unset;
}

.table-content tbody td:nth-child(5){
    max-width: unset;
}

}

</style>