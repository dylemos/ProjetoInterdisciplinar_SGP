<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Sistema de Login :: JSP</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
body, td, a:link, a:visited {
	font-family: Verdana;
	font-size: 10px;
	color: #000000;
	text-decoration: none;
}

a:hover {
	color: #FF0000;
}

input {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	background-color: #FFFFFF;
	border: 1px solid #000000;
}
</style>
</head>
<body>
	<%
		//Verifica se est� logado
		if (session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null) {
			out.println("Voc� est� logado com sucesso no sistema, por isso consegue ver est� pagina. Seu login �: "
					+ session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario")
					+ ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
		} else {
			out.println("Voc� n�o est� logado no sistema. Clique <a href='index.jsp'>aqui</a> para logar-se");
		}
	%>
	<br />
	<br />
	<br />Desenvolvimento:
	<a href="http://darkthales.hcerto.com" target="_blank">DarK ThaleS</a>
</body>
</html>