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
				<button type="submit" class="button">Crear Lista</button>
				<button type="button" onClick="javascript:window.location.href='listaView.jsp'" class="button">Cancelar</button>
			</div>
	
		</form>
		
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>