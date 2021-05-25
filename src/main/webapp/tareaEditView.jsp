<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Editar Tarea</h1>

	
	<% String controller = "tareanew"; %>
	
	<c:if test="${not empty tarea}">
    	<% controller = "tareaupdate"; %>
	</c:if>
	
	<div class="container">
	 
		<form action="<%= controller %>" method="post">
	
			<label for="titulo">Titulo: </label> 
			<input id="titulo" name="titulo" type="text" required="required" value="${tarea.titulo}"> 
			
			<label for="descripcion">Descripcion: </label> 
			<input id="descripcion" name="descripcion" type="text" required="required" value="${tarea.descripcion}">
			
			<label for="categoria">Categoria: </label> 
			<input id="categoria" name="categoria" type="text" required="required" value="${tarea.categoria}">
			  
			<label for="completado">Completado: </label> 
			<input id="completado" name="completado" type="text" required="required" value="${tarea.completado}">
			
			<label for="fechaVencimiento">FechaVencimiento: </label> 
			<input id="fechaVencimiento" name="fechaVencimiento" type="text" required="required" value="${tarea.fechaVencimiento}">
			
			<label for="ubicacion">Ubicación: </label> 
			<input id="ubicacion" name="ubicacion" type="text" required="required" value="${tarea.ubicacion}">
			
			
			<input name="listaId" type="hidden" value="${param['listaId']}">
			
			<c:if test="${not empty tarea}">
				<input name="tareaId" type="hidden" value="${tarea.tareaId}"></input>
				<input name="operation" type="hidden" value="update"></input>
			</c:if>
	
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='lista/${param['listaId']}'" class="button">Cancel</button>
			</div>
	
		</form>
		
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>