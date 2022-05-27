<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Peliculas del Actor/Actriz</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.min.css">

<script
	src="https://cdn.datatables.net/1.12.0/js/jquery.dataTables.min.js"></script>
<script src="https://kit.fontawesome.com/81a2ed02b0.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="container-fluid">
			<h1 class="h3 mb-2 text-gray-800">FILMOGRAFÍA</h1>

			<div class="card shadow mb-4">
				<div class="card-header py-3">

					<h3>
						<c:out value="${actor.getFirst_name()}"></c:out>
						<c:out value="${actor.getLast_name()}"></c:out>
					</h3>

					<table class="table" id="tblFilms">
						<thead class="table-dark">
							<tr>
								<th>Id</th>
								<th>Titulo de la película</th>
								<th>Descripción</th>
								<th>Idioma</th>
								<th>Año</th>
								<th>Censura</th>
								<th>Características Especiales</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="f" items="${films}">
								<tr>
									<td><c:out value="${f.getId()}"></c:out></td>
									<td><c:out value="${f.getTitle()}"></c:out></td>
									<td><c:out value="${f.getDescription()}"></c:out></td>
									<td><c:out value="${f.getLanguage()}"></c:out></td>
									<td><c:out value="${f.getRelease_year()}"></c:out></td>
									<td><c:out value="${f.getRating()}"></c:out></td>
									<td><c:out value="${f.getSpecial_features()}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>


	<script>
		$(document).ready(function() {
			$('#tblFilms').DataTable();
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