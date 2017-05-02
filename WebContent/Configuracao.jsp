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
<!-- Configurações -->
					<section id="configuracao" class="four">
						<div class="container">

							<header>
								<h2>Configurações do Sistema</h2>
							</header>

							<form method="get" action="#">
								<input type="button" value="Cadastrar" data-toggle="modal" data-target="#config"/>
								<input type="button" value="Alterar"/>
								<input type="button" value="Pesquisar"/>
								<input type="submit" value="Deletar"/>
								<br><br>
<table>
  <tr>
    <th>IP do Servidor</th>
    <th>Login</th>
    <th>Senha</th>
  </tr>
  <tr>
    <td>172.16.70.1</td>
    <td>admin</td>
    <td>************</td>
  </tr>

</table>

<div class="container">
							
  <!-- Modal -->
  <div class="modal fade" id="config" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Configurações do Sistema</h4>
        </div>
        <div class="modal-body">
								<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="ip" placeholder="ip" /></div>

									<div class="6u 12u$(mobile)"><input type="text" name="login" placeholder="Login" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="senha" placeholder="Senha" /></div>					
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