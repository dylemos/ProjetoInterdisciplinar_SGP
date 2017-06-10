<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqCliente"%>
<%@ page import="com.edu.fafica.SGP.entidadesDAO.ClienteDAO"%>
<%@ page import="com.edu.fafica.SGP.entidades.Cliente"%>
<%-- <%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.LinkedList"%>
<%@ page import="java.util.HashSet"%> --%>
<%@ page import="java.util.*"%>

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
  				String msg = (request.getParameter("msg"));
  				//Cliente cliente = new Cliente();
  				Object cliente = request.getAttribute("listaLigada");
  				//System.out.println(cliente);
  				ArrayList<Object> listCliente = new ArrayList<Object>();
  				listCliente.add(cliente);
  				//LinkedList linkedList = new LinkedList(); //deu certo
  				//linkedList.add(msg); //deu certo
  				//String msg = request.getParameter("lista");
  				//out.println(msg);
				//ClienteDAO clienteDAO = new ClienteDAO();
				//application.setAttribute("clienteDAO.listaLigada", clienteDAO.listaLigada);
				//list.add(request.getAttribute("lista"));
				//Object obj = (request.getAttribute("lista"));
				//ArrayList lista = new ArrayList();
				//HashSet<Object> list = new HashSet<Object>();
				//list.add(msg);				
				//System.out.println(list.toString());
				//for (Object i : list) {
				//System.out.println(listCliente);
				//for (Cliente i : linkedList)
				for (int i = 0; i < listCliente.size(); i++ ) 
				{
					//System.out.println(listCliente.get(i));
				%>


<%--  				<%String cpf = (request.getParameter("Pesquisar"));%>
 				<jsp:useBean id="controlador"
					class="com.edu.fafica.SGP.entidadesDAO.ClienteDAO" />
				<c:forEach var="i" items="${controlador.procurarClienteNoBancoDeDados(cpf)}">
				</c:forEach> --%>	
	<!-- Main -->
	<div id="main">
		<section id="top" class="two">
			<div class="container">

				<header>
					<h2>Alterar Cliente</h2>
				</header>

				<form action="" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<input type="text" name="codigo" placeholder="Código" value="Código"/>
						</div>
						<div class="6u 12u$(mobile)">
							<select name="status">
								<option>Ativo</option>
								<option>Inativo</option>
							</select>
						</div>

						<div class="6u 12u$(mobile)">
							<input type="text" name="nome" placeholder="Nome" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="text" class="cpf" name="cpf" placeholder="CPF" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="number" name="rg" placeholder="Identidade" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="email" name="email" placeholder="Email" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="number" name="celular" placeholder="Celular" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<select name="operadora">
								<option>Claro</option>
								<option>Tim</option>
								<option>Oi</option>
								<option>Vivo</option>
							</select>
						</div>

						<div class="6u 12u$(mobile)">
							<input type="number" name="telefone" placeholder="Telefone" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="number" name="cep" placeholder="Cep" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="text" name="endereco" placeholder="Endereço" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="text" name="numero" placeholder="Nº" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="text" name="bairro" placeholder="Bairro" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="text" name="cidade" placeholder="Cidade" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="text" name="uf" placeholder="Estado" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="text" name="vencimento"
								placeholder="Data de Vencimento" />
						</div>

						<div class="6u 12u$(mobile)">
							<input type="text" name="login" placeholder="Login" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="text" name="senha" placeholder="Senha" />
						</div>

						<div class="6u 12u$(mobile)">
							<label>Data de Nascimento</label>
						</div>

						<div class="6u$ 12u$(mobile)">
							<label>Data de Cadastro</label>
						</div>

						<div class="6u 12u$(mobile)">
							<input type="date" name="date_nascimento" />
						</div>

						<div class="6u$ 12u$(mobile)">
							<input type="date" name="date_cadastro" />
						</div>
					</div>
					<div class="modal-footer">
						<a href="Cliente.jsp"><button type="button"
								class="btn btn-danger" data-dismiss="modal">Cancelar</button></a>
						<button type="submit" class="btn btn-primary" data-dismiss="modal">Salvar</button>
					</div>
				</form>
   				<%
					}
					%>		
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