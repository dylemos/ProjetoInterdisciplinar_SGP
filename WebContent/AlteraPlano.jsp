<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqPlano"%>

<!DOCTYPE html>
<html>
<head>
<title>SGP - Alterar Plano</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/bootstrap.min.css"/>
<link rel="stylesheet" href="assets/css/main.css" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="menu.html"%>
	<%
		//Verifica se est� logado
		if (session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null) {
			//out.println("Voc� est� logado com sucesso no sistema, por isso consegue ver est� pagina. Seu login �: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
		} else {
			out.println("<script>document.location.href='index.jsp';</script>");
		}
	%>
  				<%
 				ServletConnectionBancoPesqPlano svt = new ServletConnectionBancoPesqPlano();
  				String msg = (request.getParameter("msg")).replace("[","").replace("]","");
  				String array[] = new String[5];
  				array = msg.split(", ");
				%>
	<!-- Main -->
	<div id="main">
		<!-- Alterar Admin -->
		<section id="top" class="two">
			<div class="container">

				<header>
					<h2>Alterar Plano</h2>
				</header>

				<form action="ServletConnectionBancoAlteraPlano" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<label><b>C�digo</b></label>
							<input type="text" name="codigo" placeholder="C�digo" value="<%=array[0]%>" readonly/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Nome do Plano</label>
							<input type="text" name="nomePlano" placeholder="Nome" value="<%=array[1]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Upload</label>
							<input type="text" name="upload" placeholder="Upload" value="<%=array[2]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Download</label>
							<input type="text" name="download" placeholder="Download" value="<%=array[3]%>"/>
						</div>
						
						<div class="6u 12u$(mobile)">
							<label>Valor</label>
							<input type="number" name="valor" placeholder="Valor" value="<%=array[4]%>"/>
						</div>
					</div>
					<div class="modal-footer">
						<a href="Planos.jsp"><button type="button"
								class="btn btn-danger" data-dismiss="modal">Cancelar</button></a>
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

	<%@ include file="footer.html"%>
</body>
</html>