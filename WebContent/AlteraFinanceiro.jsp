<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqConta"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SGP - Alterar Financeiro</title>
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
 				ServletConnectionBancoPesqConta svt = new ServletConnectionBancoPesqConta();
  				String msg = (request.getParameter("msg")).replace("[","").replace("]","");
  				String array[] = new String[12];
  				array = msg.split(", ");
				%>
	<!-- Main -->
	<div id="main">
		<!-- Alterar Financeiro -->
		<section id="financeiro" class="three">
			<div class="container">

				<header>
					<h2>Alterar Financeiro</h2>
				</header>

				<form action="ServletConnectionBancoAlteraFinanceiro" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<label><b>Código</b></label>
							<input type="number" name="codigo" placeholder="Código" value="<%=array[0]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Tipo</b></label>
							<select name="tipoConta">
								<option>Pagar</option>
								<option>Receber</option>
								<option selected><%=array[3]%></option>
							</select>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Status</b></label>
							<select name="statusConta">
								<option>Aberto</option>
								<option>Quitado</option>
								<option>Cancelado</option>
								<option selected><%=array[4]%></option>
							</select>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Cpf ou Cnpj</b></label>
							<input type="text" name="cpfCliente" placeholder="Cpf ou Cnpj" value="<%=array[1]%>" readonly/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Cliente / Fornecedor</b></label>
							<input type="text" name="cliente"
								placeholder="Cliente / Fornecedor" value="<%=array[2]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Valor</b></label>
							<input type="number" name="valor" placeholder="valor" value="<%=array[5]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label><b>Desconto</b></label>
							<input type="number" name="desconto" placeholder="Desconto" value="<%=array[6]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label><b>Total</b></label>
							<input type="number" name="total" placeholder="Total" value="<%=array[7]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label>Data de Abertura</label>
							<input type="date" name="dataAbertura" value="<%=array[8]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>Data de Vencimento</label>
							<input type="date" name="dataVencimento" value="<%=array[9]%>"/>
						</div>
						<div class="6u 12u$(mobile)">
							<label>Data do Pagamento</label>
							<input type="date" name="dataPagamento" value="<%=array[10]%>"/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>Parcelas</label>
							<input type="text" name="parcelas"
								placeholder="Quantidade de Parcelas" value="<%=array[11]%>"readonly/>
						</div>
					</div>
					<div class="modal-footer">
						<a href="Financeiro.jsp"><button type="button"
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