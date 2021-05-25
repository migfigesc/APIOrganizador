<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>New list</h1>

	
	<div class="container">
	 
		<form action="newlist" method="post">
	
			<label for="titulo">Titulo: </label> 
			<input id="titulo" name="titulo" type="text" required="required"> 
						
			<input name="listaId" type="hidden" value="${param['listaId']}">
	
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='lista/${param['listaId']}'" class="button">Cancel</button>
			</div>
	
		</form>
		
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>