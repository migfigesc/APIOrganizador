<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Aplicación — Organizador</h1>

	<div class="container">
	
		<p>${message}</p>
		
		<form action="list" method="post">
			Lista: <select name="listaId" onchange="this.form.submit()">
			<option value="none">Selecciona una Lista</option>
				<c:forEach items="${requestScope.lista}" var="lista">
    				<option value="${Lista.listaId}" ${Lista.listaId == listaId ? 'selected' : ''}>${Lista.titulo}</option>
    			</c:forEach>
  			</select>
  			<a href="listaEditView.jsp?listaId=${listaId}" class="button">Nueva lista</a>
		</form>
		
		<table id="lista">
			<tr>
				<th>Titulo</th>
				<th>Descripción</th>
				<th>Tareas</th>
			</tr>

			<c:forEach items="${requestScope.ltareas}" var="tarea"> <%-- RequestScope?? --%>
				<tr>
					<td><c:out value="${tarea.titulo}" /></td>
					<td><c:out value="${tarea.descripcion}" /></td>
					<td><c:out value="${tarea.categoria}" /></td>
					<td><c:out value="${tarea.completado}" /></td>
					<td><c:out value="${tarea.fechaVencimiento}" /></td>
					<td><c:out value="${tarea.ubicacion}" /></td>
					<td><a href="tareaupdate?listaId=${listaId}&tareaId=${tarea.tareaId}"><img src="./images/edit.png" width="30px"></a> 
						<a href="tareadelete?listaId=${listaId}&tareaId=${tarea.tareaId}"><img src="./images/delete.png" width="30px"></a></td>
				</tr>
			</c:forEach>
		</table>
		

			<form id="tareaSelector" action="addtarea" method="post">
			Añadir tarea: <select name="tareaId" onchange="this.form.submit()">
					<option value="none">Selecciona una tarea</option>
				<c:forEach items="${requestScope.tarea}" var="tarea"> <%-- RequestScope?? wtf bro que es eso --%>
    				<option value="${tarea.tareaId}">${tarea.titulo}</option>
    			</c:forEach>
  			</select>
  			<input name="tareaId" type="hidden" value="${tareaId}">
			</form>
			<a href="tareaEditView.jsp?tareaId=${listaId}" class="button">Añadir Tarea</a>

	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>