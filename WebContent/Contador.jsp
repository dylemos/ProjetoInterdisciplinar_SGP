<%@page import="java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.edu.fafica.SGP.entidadesDAO.ClienteDAO"%>
    <%@ page import="com.edu.fafica.SGP.entidades.Cliente"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!int cont = 0; %>
<%cont ++;%>
<%out.println("contador está em " + cont); %>



<%
ClienteDAO clienteDAO = new ClienteDAO();
HashSet<Cliente> cliente = clienteDAO.listarClientesNoBancoDeDados();
for (Cliente i : cliente){
%>
<table>
<tr>
<td><%=i.getNomeCliente()%></td>
<td><%=i.getCpf()%></td>
<td><%=i.getOperadora() %></td>
</tr>

</table>
<%
} 
%>
</body>
</html>