<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>SGP - Financeiro</title>
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
				<!-- Financeiro -->
					<section id="financeiro" class="three">
						<div class="container">

							<header>
								<h2>Financeiro</h2>
							</header>

							<form method="post" action="#">
							<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="codigo" placeholder="Código" /></div>
									<div class="6u$ 12u$(mobile)">
											<select>
											<option>Pagar</option>
											<option>Receber</option>
										</select>
									</div>
									<div class="6u 12u$(mobile)">
											<select>
											<option>Aberto</option>
											<option>Quitado</option>
											<option>Cancelado</option>
										</select>
									</div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="codcliente" placeholder="Código do Cliente / Fornecedor" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="cliente" placeholder="Cliente / Fornecedor" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="valor" placeholder="valor" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="desconto" placeholder="Desconto" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="acrescimo" placeholder="Acrescimo" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="total" placeholder="Total" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="parcelas" placeholder="Quantidade de Parcelas" /></div>
								</div>								
										<div class="modal-footer">
											<a href="Financeiro.jsp"><button type="button" class="btn btn-danger"	data-dismiss="modal">Cancelar</button></a>
											<button type="submit" class="btn btn-primary" data-dismiss="modal">Salvar</button>
										</div>	
							</form>          
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