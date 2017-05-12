<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>SGP - Cadastro de Planos</title>
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
<!-- Main -->
<div id="main">
				<!-- planos de acesso -->
					<section id="planos" class="two">
						<div class="container">

							<header>
								<h2>Planos de Acesso</h2>
							</header>
					<input type="search" value="Pesquisar Planos" /><br><br>
<table>
  <tr>
    <th>Plano</th>
    <th>Upload</th>
    <th>Download</th>
    <th>Editar</th>
    <th>Deletar</th>
  </tr>
  <tr>
    <td>Livre 5MB</td>
    <td>512</td>
    <td>5120</td>
    <td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
  <tr>
    <td>Livre 7MB</td>
    <td>700</td>
    <td>7168</td>
    <td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
  <tr>
    <td>Livre 10MB</td>
    <td>1024</td>
    <td>10240</td>
    <td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
	<td><a href="#" class="icon fa fa-times"></a></td>
  </tr>
</table>

					<a href="CadastroPlanos.jsp"><input type="button" value="Novo Cadastro"/></a>
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