<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>SGP - Cadastro de Fornecedor</title>
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
				<!-- Cadastro de Fornecedor -->
					<section id="fornecedor" class="four">
						<div class="container">

							<header>
								<h2>Cadastro de Fornecedor</h2>
							</header>

							<form action="ServletConnectionBancoFornecedor" method="post">
							<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="codigo" placeholder="Código" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="razaoSocial" placeholder="Razao Social" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="nomeFantasia" placeholder="Nome Fantasia" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="cnpj" placeholder="CNPJ" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="ie" placeholder="Inscrição Estadual" /></div>
									<div class="6u$ 12u$(mobile)"><input type="email" name="email" placeholder="Email" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="telefone" placeholder="Telefone" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="celular" placeholder="Celular" /></div>
									<div class="6u 12u$(mobile)">
										<select name="operadora">
											<option>Claro</option>
											<option>Tim</option>
											<option>Oi</option>
											<option>Vivo</option>
										</select></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="cep" placeholder="Cep" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="endereco" placeholder="Endereço" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="numero" placeholder="Nº" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="bairro" placeholder="Bairro" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="cidade" placeholder="Cidade" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="uf" placeholder="Estado" /></div>
									<div class="12u$">
										<!--<textarea name="obs" placeholder="Observações"></textarea>-->
									</div>
								</div>
								<div class="modal-footer">
									<a href="Fornecedor.jsp"><button type="button" class="btn btn-danger"	data-dismiss="modal">Cancelar</button></a>
									<button type="submit" class="btn btn-primary" data-dismiss="modal">Salvar</button>
								</div>	
							</form>

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