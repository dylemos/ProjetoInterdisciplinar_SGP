<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>SGP - Cadastro de Fornecedor</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		<link rel="stylesheet" href="assets/css/main.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
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

							<form method="post" action="#">
								<input type="button" value="Cadastrar" data-toggle="modal" data-target="#cadastroFornecedor"/>
								<input type="button" value="Alterar"/>
								<input type="button" value="Pesquisar"/>
								<input type="submit" value="Deletar"/>
								<br><br>

<table>
  <tr>
    <th>Código</th>
    <th>Nome Fantasia</th>
    <th>CNPJ</th>
  </tr>
  <tr>
    <td>001</td>
    <td>Maria Anders</td>
    <td>595.551.373-66</td>
  </tr>
  <tr>
    <td>002</td>
    <td>Francisco Chang</td>
    <td>840.294.254-70</td>
  </tr>
  <tr>
    <td>003</td>
    <td>Roland Mendel</td>
    <td>311.241.638-40</td>
  </tr>
  <tr>
    <td>004</td>
    <td>Helen Bennett</td>
    <td>568.771.652-17</td>
  </tr>
  <tr>
    <td>005</td>
    <td>Yoshi Tannamuri</td>
    <td>753.606.171-44</td>
  </tr>
  <tr>
    <td>006</td>
    <td>Giovanni Rovelli</td>
    <td>741.885.834-52</td>
  </tr>
    <tr>
    <td>007</td>
    <td>Giovanni Rovelli</td>
    <td>741.885.834-52</td>
  </tr>
    <tr>
    <td>008</td>
    <td>Giovanni Rovelli</td>
    <td>741.885.834-52</td>
  </tr>
    <tr>
    <td>009</td>
    <td>Giovanni Rovelli</td>
    <td>741.885.834-52</td>
  </tr>
    <tr>
    <td>010</td>
    <td>Giovanni Rovelli</td>
    <td>741.885.834-52</td>
  </tr>
</table>
																
<div class="container">
								

  <!--<h2>Large Modal</h2>
  <!-- Trigger the modal with a button
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button> -->

  <!-- Modal -->
  <div class="modal fade" id="cadastroFornecedor" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Cadastro de Fornecedor</h4>
        </div>
        <div class="modal-body">
								<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="codigo" placeholder="Código" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="nome" placeholder="Nome" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="cnpj" placeholder="CNPJ" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="ie" placeholder="Inscrição Estadual" /></div>
									<div class="6u 12u$(mobile)"><input type="email" name="email" placeholder="Email" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="telefone" placeholder="Telefone" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="celular" placeholder="Celular" /></div>
									<div class="6u$ 12u$(mobile)">
										<select>
											<option>Claro</option>
											<option>Tim</option>
											<option>Oi</option>
											<option>Vivo</option>
										</select></div>
									<div class="6u 12u$(mobile)"><input type="number" name="cep" placeholder="Cpe" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="endereco" placeholder="Endereço" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="numero" placeholder="Nº" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="bairro" placeholder="Bairro" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="cidade" placeholder="Cidade" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="uf" placeholder="Estado" /></div>
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
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  			
<%@ include file="footer.html" %>
</body>
</html>