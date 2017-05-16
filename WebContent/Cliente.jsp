<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SGP - Cadastro de Clientes</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/main.css" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="menu.html"%>
	<!-- Main -->
	<div id="main">
		<!-- Cadastro de Cliente -->
		<section id="top" class="two">
			<div class="container">

				<header>
					<h2>Cadastro de Cliente</h2>
				</header>
					<input type="search" value="Pesquisar Cliente" /><br><br>
				
						<table>

						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>CPF</th>
							<th>Editar</th>
							<th>Deletar</th>
						</tr>
						<tr>
							<td>001</td>
							<td>Maria Anders</td>
							<td>595.551.373-66</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>002</td>
							<td>Francisco Chang</td>
							<td>840.294.254-70</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>003</td>
							<td>Roland Mendel</td>
							<td>311.241.638-40</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>004</td>
							<td>Helen Bennett</td>
							<td>568.771.652-17</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>005</td>
							<td>Yoshi Tannamuri</td>
							<td>753.606.171-44</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>006</td>
							<td>Giovanni Rovelli</td>
							<td>741.885.834-52</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>007</td>
							<td>Giovanni Rovelli</td>
							<td>741.885.834-52</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>008</td>
							<td>Giovanni Rovelli</td>
							<td>741.885.834-52</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>009</td>
							<td>Giovanni Rovelli</td>
							<td>741.885.834-52</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>
						<tr>
							<td>010</td>
							<td>Giovanni Rovelli</td>
							<td>741.885.834-52</td>
							<td><a href="#"class="icon fa fa-pencil-square-o"></a></td>
							<td><a href="#" class="icon fa fa-times"></a></td>
						</tr>

					</table>
					
					<a href="CadastroCliente.jsp"><input type="button" value="Novo Cadastro"/></a>
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
	
		<%@ include file="footer.html"%>
		</body>
</html>