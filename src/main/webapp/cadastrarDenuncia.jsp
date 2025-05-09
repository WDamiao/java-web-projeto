<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilo.css">
<title>Thamy</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="cadastrarDenuncia.jsp">Cadastrar Denuncia</a></li>
			<li><a href="consultar.jsp">Consultar Denuncia</a></li>
		</ul>
	</nav>
	
	<main>
		<form action="cadastrarDenuncia" method="post">
			<div>
				<label><strong>Pais</strong></label><input type="text" name="pais">
			</div>
			<div>
				<label><strong>Tipo</strong></label><input type="text" name="tipo">
			</div>
			<div>
				<label><strong>Quantidade de Denuncias</strong></label><input type="text" name="qtdDenuncia">
			</div>
			<div>
				<label><strong>Casos Confirmados</strong></label><input type="text" name="casosConfirmados">
			</div>
			<div>
				<label><strong>Gravidade</strong></label><input type="text" name="gravidade">
			</div>
			<div>
				<input type="submit" name="salvar" value="Cadastrar Denuncia">
			</div>
			<div>
			<%
			String mensagem = (String) request.getAttribute("mensagem");
			if (mensagem != null)
				out.print(mensagem);
			%>
			</div>
		</form>
	</main>
</body>
</html>