<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="com.edu.fafica.SGP.servlet.ServletConnectionBancoPesqChamado"%>
<!DOCTYPE HTML>
<html>
<head>
<title>SGP - Altera Atendimento</title>
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
if(session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null){
//out.println("Você está logado com sucesso no sistema, por isso consegue ver está pagina. Seu login é: " + session.getValue("loginUsuario") + " e sua senha: " + session.getValue("senhaUsuario") + ". Clique <a href='Logoff.jsp'>aqui</a> para sair do sistema");
} else {
out.println("<script>document.location.href='index.jsp';</script>");
}
%>
  				<%
 				ServletConnectionBancoPesqChamado svt = new ServletConnectionBancoPesqChamado();
  				String msg = (request.getParameter("msg")).replace("[","").replace("]","");
  				String array[] = new String[9];
  				array = msg.split(", ");
  				
  				for(int i = 0; i < array.length; i++){
  					System.out.println(i + " " + array[i]);
  				} 
				%>
	<!-- Main -->
	<div id="main">
		<!-- Central de Atendimento -->
		<section id="atendimento" class="four">
			<div class="container">

				<header>
					<h2>Alterar Atendimento</h2>
				</header>

				<form action="ServletConnectionBancoAlteraChamado" method="post">
					<div class="row">
						<div class="6u 12u$(mobile)">
							<label>Código</label>
							<input type="number" name="codigo" placeholder="Código" value="<%=array[0]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>Tipo do Atendimento</label>
							<select name="tipo">
								<option>Suporte</option>
								<option>Instalação</option>
								<option>Cancelamento</option>
								<option>transferência</option>
								<option selected><%=array[3]%></option>
							</select>
						</div>
						<div class="6u 12u$(mobile)">
						<label>Status</label>
							<select name="status">
								<option>Aberto</option>
								<option>Em Atendimento</option>
								<option>Cancelado</option>
								<option>Fechado</option>
								<option selected><%=array[6]%></option>
							</select>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>CPF do Cliente</label>
							<input type="text" name="cpfcliente" placeholder="CPF do Cliente" value="<%=array[1]%>" readonly/>
						</div>
						<div class="6u 12u$(mobile)">
							<label>Nome do Cliente</label>
							<input type="text" name="cliente" placeholder="Nome do Cliente" value="<%=array[2]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>Data de Cadastro</label>
							<input type="date" name="dataAbertura" value="<%=array[7]%>" readonly/>
						</div>
						<div class="6u$ 12u$(mobile)">
							<label>Data do Fechamento</label>
							<input type="date" name="dataFechamento" value="<%=array[8]%>"/>
						</div>
						<div class="12u$">
							<label>Observações</label>
							<input type="text" name="obs" placeholder="Mensagem" value="<%=array[4]%>" readonly/>
							<br><label>Observações Finais</label>
							<input type="text" name="obs2" placeholder="Mensagem" value="<%=array[5]%>" readonly/>
							<br>
							<textarea name="descProblema2" placeholder="Mensagem"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<a href="Atendimento.jsp"><button type="button"
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