<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp" />

<jsp:include page="includes/sidebar.jsp" />
<div class="container-fluid d-flex flex-column vh-100 vw-100">
	<div class="w-100 h-100 d-flex flex-column align-items-center">
		<table class="table w-50 mt-5">
			<thead class="thead-dark">
				<tr>
					<th class="col"><a href="/form"><i class="fa fa-plus"></i></a></th>
					<th class="col">Título</th>
					<th class="col">Descrição</th>
					<th class="col">Concluído</th>
					<th class="col">Foto</th>
					<th>Opções</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${allTasks}" var="task">
					<tr>
						<td>${task.id}</td>
						<td>${task.titulo}</td>
						<td>${task.descricao}</td>
						<td><c:choose>
								<c:when test="${task.concluido == true}">
									<p>
										<i class="fa fa-check" aria-hidden="true"></i>
									</p>
								</c:when>
								<c:otherwise>

									<i class="fa fa-window-close"></i>
								</c:otherwise>
							</c:choose></td>
						<td><c:choose>
								<c:when test="${task.path == null}">

									<img
								width="50px" height="40px" src="http://www.ccta.ufpb.br/labeet/contents/acervos/categorias/cordofones/udecra/sem-imagem.jpg/@@images/image.jpeg" />
									
								</c:when>
								<c:otherwise>
									<a href="${task.path}" target="_blank"><img width="50px"
										height="40px" src="${task.path}" /></a>
								</c:otherwise>
							</c:choose></td>
						<td class=""><c:choose>
								<c:when test="${task.concluido == true}">
									<a href="${s:mvcUrl('TC#edit').arg(0, task.id).build()}"><i
										class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
									<a href="${s:mvcUrl('TC#delete').arg(0, task.id).build()}"><i
										class="fa fa-trash" aria-hidden="true"></i></a>

								</c:when>
								<c:otherwise>
									<a href="${s:mvcUrl('TC#edit').arg(0, task.id).build()}"><i
										class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
									<a href="${s:mvcUrl('TC#delete').arg(0, task.id).build()}"><i
										class="fa fa-trash" aria-hidden="true"></i></a>
									<a href="${s:mvcUrl('TC#confirmar').arg(0, task.id).build()}"><i
										class="fa fa-check-square-o" aria-hidden="true"></i></a>
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>
		<c:choose>
			<c:when test="${msg != null}">
				<p class="alert alert-success d-flex align-items-center">${msg}</p>
			</c:when>
		</c:choose>



	</div>

	<jsp:include page="includes/footer.jsp" />
</div>