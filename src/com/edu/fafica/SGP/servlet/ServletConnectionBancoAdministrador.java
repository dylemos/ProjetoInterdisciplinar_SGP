package com.edu.fafica.SGP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoAdministrador")
public class ServletConnectionBancoAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doPost(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SGP_MySQL.getInstance().conectarBD();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String status = request.getParameter("status");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		PrintWriter out = response.getWriter();		
		
		String html = " ";
		
		html += "<html>";
		
		html += "	<head>";
		html += "		<meta charset='utf-8'/>";
		html += "		<title>@Cadastrado</title>";
		html += "		<link rel='stylesheet' type='text/css' href='estilo.css' />";
		html += "	</head>";
		
		html += "	<body>";
		html += "		<div align='center'><br/><br/><br/><br/>";
		html += "			<h2 style='transition-delay: 10s;'>Cadastrado com Sucesso</h2><br/><br/><h3>Administrador "+nome+" CPF "+cpf+"</h3><script>document.location.href='CadastroCliente.jsp';</script>";
		html += "		</div>";
		html += "	</body>";
		
		html += "</html>";
		
		out.println(html);
		UserAdmin userAdmin = new UserAdmin(status, nome, cpf, login, senha);
		try {
			FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException | UserAdminJaCadastradoException | UserAdminCpfInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
