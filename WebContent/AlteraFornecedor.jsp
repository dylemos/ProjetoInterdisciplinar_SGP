<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqFornecedor"%>

<!DOCTYPE html>
<html>
<head>
<title>SGP - Altera Fornecedor</title>
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
		//Verifica se está logado
		if (session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null) {
			//out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
		} else {
			out.println("<script>document.location.href='index.jsp';</script>");
		}
	%>
  				<%
 				ServletConnectionBancoPesqFornecedor svt = new ServletConnectionBancoPesqFornecedor();
  				String msg = (request.getParameter("msg")).replace("[","").replace("]","");
  				String array[] = new String[15];
  				array = msg.split(", ");
				%>
	<!-- Main -->
	<div id="main">
		<!-- Alterar Cliente -->
		<section id="top" class="two">
			<div class="container">

				<header>
					<h2>Alterar Fornecedor</h2>
				</header>

				<form action="ServletConnectionBancoAlteraFornecedor" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<label><b>Código</b></label>
							<input type="text" name="codigo" placeholder="Código" value="<%=array[0]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Razao Social</b></label>
							<input type="text" name="razaoSocial" placeholder="Razao Social" value="<%=array[1]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Nome Fantasia</b></label>
							<input type="text" name="nomeFantasia" placeholder="Nome Fantasia" value="<%=array[14]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>CNPJ</b></label>
							<input type="text" name="cnpj" placeholder="CNPJ" value="<%=array[2]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Inscrição Estadual</b></label>
							<input type="text" name="ie" placeholder="Inscrição Estadual" value="<%=array[3]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Email</b></label>
							<input type="email" name="email" placeholder="Email" value="<%=array[10]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Telefone</b></label>
							<input type="number" name="telefone" placeholder="Telefone" value="<%=array[11]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Celular</b></label>
							<input type="number" name="celular" placeholder="Celular" value="<%=array[12]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Operadora</b></label>
							<select name="operadora">
								<option>Claro</option>
								<option>Tim</option>
								<option>Oi</option>
								<option selected><%=array[13]%></option>
							</select>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Cep</b></label>
							<input type="number" name="cep" placeholder="Cep" value="<%=array[9]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Logradouro</b></label>
							<input type="text" name="endereco" placeholder="Endereço" value="<%=array[4]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Número</b></label>
							<input type="text" name="numero" placeholder="Nº" value="<%=array[5]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Bairro</b></label>
							<input type="text" name="bairro" placeholder="Bairro" value="<%=array[6]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Cidade</b></label>
							<input type="text" name="cidade" placeholder="Cidade" value="<%=array[7]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Estado</b></label>
							<input type="text" name="uf" placeholder="Estado" value="<%=array[8]%>"/>
						</div>						
					</div>
					<div class="modal-footer">
						<a href="Cliente.jsp"><button type="button"
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