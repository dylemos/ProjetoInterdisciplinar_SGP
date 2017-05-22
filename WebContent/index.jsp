<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
		<title>SGP - Sistema de Gestão para Provedores</title>
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

					<section id="top" class="two">
 					<div class="container">
 					
<p>Para logar-se no sistema informe seu login e senha:</p><br /><br />
<form name="form1" method="post" action="Logar.jsp">
<table width="180" border="0" cellpadding="0" cellspacing="1">
<tr>
<td width="55">Login:</td>
<td width="122"><input name="login" type="text" id="login"></td>
</tr>
<tr>
<td height="18">Senha:</td>
<td><input name="senha" type="password" id="senha"></td>
</tr>
<tr>
<td colspan="2"><div align="right">
<input type="submit" name="Submit" value="Logar">
</div></td>
</tr>
</table>
</form>
<br><br>
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