<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="includes/sidebar.jsp" />
<div class="container-fluid d-flex flex-column vh-100 vw-100">
	<div
		class="w-100 h-100 d-flex flex-column justify-content-center  align-items-center">
		<div class="card">
			<c:choose>
				<c:when test="${task.path == null}">

					<img style="width: 400px; height: 200px;"
						src="http://www.ccta.ufpb.br/labeet/contents/acervos/categorias/cordofones/udecra/sem-imagem.jpg/@@images/image.jpeg" />

				</c:when>
				<c:otherwise>
					<img class="card-img-top" style="width: 400px; height: 200px;"
						src="/${task.path}">
				</c:otherwise>
			</c:choose>
			<div class="card-body">
				<form:form class="col"
					action="${s:mvcUrl('TC#update').arg(0, task.id).build()}"
					method="POST" modelAttribute="tarefa" enctype='multipart/form-data'>

					<div class="col-auto">
						<label class="form-label">Título</label>
						<form:input class="form-control" path="titulo"
							value="${task.titulo}" />
						<form:errors path="titulo" />
					</div>
					<div class="col-auto">
						<label class="form-label">Descrição</label>
						<form:input value="${task.descricao}" class="form-control"
							path="descricao" />
						<form:errors path="descricao" />

						<input name="img" type="file" class="form-control mt-2" />
					</div>
					<button class="mt-2 btn btn-outline-secondary" type="submit">Salvar</button>
				</form:form>
			</div>
		</div>
		<span style="color: red;">${msg}</span>
	</div>
	<jsp:include page="includes/footer.jsp" />
</div>