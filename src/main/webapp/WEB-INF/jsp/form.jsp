<jsp:include page="includes/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<jsp:include page="includes/sidebar.jsp" />
<div class="container-fluid d-flex flex-column vh-100 vw-100">
	<div
		class="w-100 h-100 d-flex flex-column justify-content-center  align-items-center">
		<div class="card">
			<div class="card-body">
				<form:form class="col"
					action="${s:mvcUrl('TC#postTarefa').build()}" method="POST"
					modelAttribute="tarefa"
					enctype='multipart/form-data'>
					<div class="col-auto">
						<label class="form-label">Título</label>
						<form:input class="form-control" path="titulo" />
						<form:errors path="titulo" />
					</div>
					<div class="col-auto">
						<label class="form-label">Descrição</label>
						<form:input class="form-control" path="descricao" />
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