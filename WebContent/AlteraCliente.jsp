<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqCliente"%>
<%@ page import="com.edu.fafica.SGP.entidadesDAO.ClienteDAO"%>
<%@ page import="com.edu.fafica.SGP.entidades.Cliente"%>

<!DOCTYPE html>
<html>
<head>
<title>SGP - Alterar Cliente</title>
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
		//Verifica se está logado
		if (session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null) {
			//out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
		} else {
			out.println("<script>document.location.href='index.jsp';</script>");
		}
	%>
  				<%
 				ServletConnectionBancoPesqCliente svt = new ServletConnectionBancoPesqCliente();
  				String msg = (request.getParameter("msg")).replace("[","").replace("]","");
  				String array[] = new String[21];
  				array = msg.split(", ");
				%>
	<!-- Main -->
	<div id="main">
		<section id="top" class="two">
			<div class="container">

				<header>
					<h2>Alterar Cliente</h2>
				</header>

				<form action="ServletConnectionBancoAlteraCliente" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<label><h5>Código</h5></label>
							<input type="text" name="codigo" placeholder="Código" value="<%=array[0]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><h5>Status</h5></label>
							<select name="status">
								<option>Ativo</option>
								<option>Inativo</option>
								<option selected><%=array[1]%></option>
							</select>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Nome</label>
							<input type="text" name="nome" placeholder="Nome" value="<%=array[2]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Cpf</label>
							<input type="text" class="cpf" name="cpf" placeholder="CPF" value="<%=array[4]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Identidade</label>
							<input type="text" name="rg" placeholder="Identidade" value="<%=array[3]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Email</label>
							<input type="email" name="email" placeholder="Email" value="<%=array[7]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Celular</label>
							<input type="text" name="celular" placeholder="Celular" value="<%=array[9]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Operadora</label>
							<select name="operadora" >
								<option>Claro</option>
								<option>Tim</option>
								<option>Oi</option>
								<option>Vivo</option>
								<option selected><%=array[20]%></option>
							</select>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Telefone</label>
							<input type="text" name="telefone" placeholder="Telefone" value="<%=array[8]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Cep</label>
							<input type="text" name="cep" placeholder="Cep" value="<%=array[16]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Logradouro</label>
							<input type="text" name="endereco" placeholder="Logradouro" value="<%=array[11]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Número</label>
							<input type="text" name="numero" placeholder="Nº" value="<%=array[12]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Bairro</label>
							<input type="text" name="bairro" placeholder="Bairro" value="<%=array[13]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Cidade</label>
							<input type="text" name="cidade" placeholder="Cidade" value="<%=array[14]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Estado</label>
							<input type="text" name="uf" placeholder="Estado" value="<%=array[15]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Vencimento</label>
							<input type="text" name="vencimento"
								placeholder="Data de Vencimento" value="<%=array[10]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Login</label>
							<input type="text" name="login" placeholder="Login" value="<%=array[17]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Senha</label>
							<input type="password" name="senha" placeholder="Senha" value="<%=array[18]%>"/>
						</div>

						<div class="6u 12u$(mobile)">
							<label>Data de Nascimento</label>
							<input type="date" name="date_nascimento" value="<%=array[5]%>"/>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Data de Cadastro</label>
							<input type="date" name="date_cadastro" value="<%=array[6]%>"/>
						</div>
					</div>
					<div class="modal-footer">
						<a href="Cliente.jsp"><button type="button"
								class="btn btn-danger" data-dismiss="modal">Cancelar</button></a>
						<button type="submit" class="btn btn-primary" data-dismiss="modal">Salvar</button>
					</div>
				</form>
		
				<div class="container">
		</section>
	</div>
<%-- </c:forEach> --%>
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