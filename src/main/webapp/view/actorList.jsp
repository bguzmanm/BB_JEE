<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Lista de Actores</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.min.css">
	
<script
	src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Listado de Actores y Actrices</h1>

		<table id="tblActores" class="table">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${actores}">
					<tr>
						<td><a href="${pageContext.request.contextPath}/DetalleActorServlet?id=${a.getId()}"><c:out value="${a.getId()}"></c:out></a></td>
						<td><c:out value="${a.getFirst_name()}"></c:out></td>
						<td><c:out value="${a.getLast_name()}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

	<script>
		$(document).ready(function() {
			$('#tblActores').DataTable();
		});
	</script>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
</body>
</html>