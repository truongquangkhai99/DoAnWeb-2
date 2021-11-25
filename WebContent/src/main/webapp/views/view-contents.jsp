<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="assets/js/viewcontent.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/viewcontent.css">
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
				      <td ><a href="EditContent?id=${content.id}">Edit</a> <p onclick="$.post('ViewContent', { id :<c:out value='${content.id}' />}); $(this).parent().parent().addClass('hide');" > Delete </p></td>
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


