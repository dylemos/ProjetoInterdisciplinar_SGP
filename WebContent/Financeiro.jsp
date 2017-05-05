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
								<input type="button" value="Cadastrar" data-toggle="modal" data-target="#CadastroFinanceiro"/>
								<input type="button" value="Alterar"/>
								<input type="button" value="Pesquisar"/>
								<input type="submit" value="Deletar"/>
								<br><br>
								
<table>
  <tr>
    <th>Cliente</th>
    <th>Valor</th>
    <th>Vencimento</th>
  </tr>
  <tr>
    <td>Maria da Silva</td>
    <td>50,00</td>
    <td>20/04/2017</td>
  </tr>
  <tr>
    <td>José João</td>
    <td>70,00</td>
    <td>24/05/2017</td>
  </tr>
  <tr>
    <td>Italo Júnior</td>
    <td>80,00</td>
    <td>03/06/2017</td>
  </tr>
</table>

								
<div class="container">
							
  <!-- Modal -->
  <div class="modal fade" id="CadastroFinanceiro" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Financeiro</h4>
        </div>
        <div class="modal-body">
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
									<!--<div class="6u 12u$(mobile)"><input type="number" name="valorparcela" placeholder="Valor da Parcela" /></div>-->
									<div class="12u$">
										<!--<textarea name="obs" placeholder="Observações"></textarea>-->
									</div>
								</div>								
          
        </div>
        <div class="modal-footer">
          <button type="reset" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
          <button type="submit" class="btn btn-primary" data-dismiss="modal">Salvar</button>
        </div>
      </div>
    </div>
  </div>
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