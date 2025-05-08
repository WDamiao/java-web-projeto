<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thamy</title>
</head>
<body>
	<nav>
		<ul>
			<li><a href="cadastrarDenuncia.jsp">Cadastrar Denuncia</a></li>
			<li><a href="consultar.jsp">Consultar Denuncia</a></li>
		</ul>
	</nav>

<div>
	<h1>Denuncias Registradas</h1>
    <form method="post" action="consultarDenuncia">
        <div>
            <label><strong>Buscar por pais</strong></label><input type="text" class="form-control" placeholder="Ex: Brasil" name="pais">
        </div>
        <div>
        <input type="submit" name="salvar" value="Filtrar">
        </div>
    </form>
</div>
</body>
</html>