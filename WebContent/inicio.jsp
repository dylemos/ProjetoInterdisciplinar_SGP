<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SGP - Sistema de Gest�o para Provedores</title>
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

	<%
//Verifica se est� logado
if(session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null){
//out.println("Ol� " + session.getValue("loginUsuario") + " Bem Vindo ao SGP");
} else {
out.println("<script>document.location.href='index.jsp';</script>");
}
%>

	<!-- Main -->
	<div id="main">

		<section id="top" class="two">
			<div class="container">
			<% out.println("Ol� " + session.getValue("loginUsuario").toString().toUpperCase() + " Bem Vindo ao SGP - Sistema de Gest�o para Provedores de Internet");%>
				<br><br><span class="image bg_inicio"><img src="images/bg_inicio.jpg"
					alt="" /></span> <br>
				<br>
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