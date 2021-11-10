
<div  class="view-content">
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
				    <tr>
				      <td data-label="Name">1</td>
				      <td data-label="Age">24</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job"><a href="#">Edit</a> <p > Delete </p></td>
				    </tr>
				    <tr>
				      <td data-label="Name">2</td>
				      <td data-label="Age">24</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job"><a href="#">Edit</a> <p > Delete </p></td>
				    </tr>
				    <tr>
				      <td data-label="Name">3</td>
				      <td data-label="Age">24</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job"><a href="#">Edit</a> <p > Delete </p></td>
				    </tr>
				    <tr>
				      <td data-label="Name">4</td>
				      <td data-label="Age">24</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job">Engineer</td>
				      <td data-label="Job"><a href="#">Edit</a> <p > Delete </p></td>
				    </tr>
				    
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

</style>