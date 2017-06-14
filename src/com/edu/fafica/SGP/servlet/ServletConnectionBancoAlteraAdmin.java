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

@WebServlet("/ServletConnectionBancoAlteraAdmin")
public class ServletConnectionBancoAlteraAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAlteraAdmin() {
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
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("codigo");
		String status = request.getParameter("status");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		int idCliente = Integer.parseInt(id);
		
		PrintWriter out = response.getWriter();			
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='AlteraAdminMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		
		UserAdmin userAdmin = new UserAdmin(idCliente, status, nome, cpf, login, senha);
		try {
			FachadaSGP.getUniqueInstance().atualizarUserAdmin(userAdmin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Alterado no Banco de Dados!");
		
		
	}

}
