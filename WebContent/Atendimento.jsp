<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>SGP - Atendimento</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/css/main.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
  		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="menu.html" %>
<%
//Verifica se está logado
if(session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null){
//out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
} else {
out.println("<script>document.location.href='index.jsp';</script>");
}
%>
<!-- Main -->
<div id="main">
				<!-- Central de Atendimento -->
					<section id="atendimento" class="four">
						<div class="container">

							<header>
								<h2>Central de Atendimento</h2>
							</header>
					<input type="search" value="Pesquisar Atendimento" /><br><br>
<table>
  <tr>
    <th>Cliente</th>
    <th>Tipo Suporte</th>
    <th>Status</th>
	<th>Editar</th>
	<th>Deletar</th>
  </tr>
  <tr>
    <td>Maria da Silva</td>
    <td>Transferência</td>
    <td>Em Atendimento</td>
	<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
  <tr>
    <td>José João</td>
    <td>Instalação</td>
    <td>Aberto</td>
	<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
  <tr>
    <td>Italo Júnior</td>
    <td>Cancelamento</td>
    <td>Fechado</td>
	<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
</table>
					<a href="CadastroAtendimento.jsp"><input type="button" value="Novo Cadastro"/></a>
</div>
</section>
</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollzer.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>
  			
<%@ include file="footer.html" %>
</body>
</html>