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

							<form action="ServletConnectionBancoChamado" method="post">
								<div class="row">
									<div class="6u 12u$(mobile)"><input type="number" name="codigo" placeholder="Código" /></div>
									<div class="6u$ 12u$(mobile)">
											<select name="tipo">
											<option>Suporte</option>
											<option>Instalação</option>
											<option>Cancelamento</option>
											<option>transferência</option>
										</select>
									</div>
									<div class="6u 12u$(mobile)">
											<select name="status">
											<option>Aberto</option>
											<option>Em Atendimento</option>
											<option>Cancelado</option>
											<option>Fechado</option>
										</select>
									</div>
									<div class="6u$ 12u$(mobile)"><input type="text" name="cpfcliente" placeholder="CPF do Cliente" /></div>
									<div class="6u 12u$(mobile)"><input type="text" name="cliente" placeholder="Nome do Cliente" /></div>
									<div class="12u$">
										<textarea name="message" placeholder="Mensagem"></textarea>
									</div>
								</div>
										<div class="modal-footer">
											<a href="Atendimento.jsp"><button type="button" class="btn btn-danger"	data-dismiss="modal">Cancelar</button></a>
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