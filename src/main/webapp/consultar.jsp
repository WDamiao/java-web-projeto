<%@ page import = "denuncia.model.Denuncia" %>
<%@ page import ="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/estilo.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
        	<input type="submit" name="salvar" value="Exibir">
        </div>

<%
    // Coletar os dados se existirem
    if(request.getAttribute("denuncias") != null) {
        List<?> denuncias = (List<?>) request.getAttribute("denuncias");
%>
<script>
    // Arrays para armazenar os dados do gráfico
    const labels = [];
    const dataValues = [];

    <% for (Object obj : denuncias) {
        Denuncia denuncia = (Denuncia) obj;
    %>
        labels.push("<%= denuncia.getPais() %>");
        dataValues.push(<%= denuncia.getQtdDenuncia() %>);
    <% } %>

    const ctx = document.createElement('canvas');
    ctx.id = 'graficoDenuncias';
    document.body.appendChild(ctx);

    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                label: 'Quantidade de Denuncias por País',
                data: dataValues,
                backgroundColor: 'rgba(54, 162, 235, 0.6)',
                borderColor: 'rgba(54, 162, 235, 1)',
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Denuncias'
                    }
                },
                x: {
                    title: {
                        display: true,
                        text: 'País'
                    }
                }
            }
        }
    });
</script>
<% } %>
        
        <%
if(request.getAttribute("denuncias") != null) {
    List<?> denuncias = (List<?>) request.getAttribute("denuncias");
%>
    <table class="tabela-denuncias">
        <thead>
            <tr>
                <th>País</th>
                <th>Tipo de Problema</th>
                <th>Denúncias</th>
                <th>Casos Confirmados</th>
                <th>Gravidade</th>
            </tr>
        </thead>
        <tbody>
            <%
            for(int contador = 0; contador < denuncias.size(); contador++) {
                Denuncia denuncia = (Denuncia) denuncias.get(contador);
            %>
            <tr>
                <td><%= denuncia.getPais() %></td>
                <td><%= denuncia.getTipo() %></td>
                <td><%= denuncia.getQtdDenuncia() %></td>
                <td><%= denuncia.getCasosConfirmados() %></td>
                <td><%= denuncia.getGravidade() %></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
<%
}
%>


    </form>
</div>
</body>
</html>