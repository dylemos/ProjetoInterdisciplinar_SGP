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
				<!-- planos de acesso -->
					<section id="planos" class="two">
						<div class="container">

							<header>
								<h2>Planos de Acesso</h2>
							</header>

							<form method="post" action="#">
								<input type="button" value="Cadastrar" data-toggle="modal" data-target="#planoAcesso"/>
								<input type="button" value="Alterar"/>
								<input type="button" value="Pesquisar"/>
								<input type="submit" value="Deletar"/>
								<br><br>
								
<table>
  <tr>
    <th>Plano</th>
    <th>Upload</th>
    <th>Download</th>
  </tr>
  <tr>
    <td>Livre 5MB</td>
    <td>512</td>
    <td>5120</td>
  </tr>
  <tr>
    <td>Livre 7MB</td>
    <td>700</td>
    <td>7168</td>
  </tr>
  <tr>
    <td>Livre 10MB</td>
    <td>1024</td>
    <td>10240</td>
  </tr>
</table>



<div class="container">
								

  <!--<h2>Large Modal</h2>
  <!-- Trigger the modal with a button
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button> -->

  <!-- Modal -->
  <div class="modal fade" id="planoAcesso" role="dialog">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
			<h4 class="modal-title">Planos de Acesso</h4>
        </div>
        <div class="modal-body">
								<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="codigo" placeholder="Código" /></div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="nome" placeholder="Nome" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="upload" placeholder="Upload" /></div>
									<div class="6u$ 12u$(mobile)"><input type="number" name="download" placeholder="Download" /></div>
									<div class="6u 12u$(mobile)"><input type="number" name="valor" placeholder="Valor" /></div>
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