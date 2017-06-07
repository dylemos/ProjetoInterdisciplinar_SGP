package com.edu.fafica.SGP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidadesDAO.ClienteDAO;
import com.edu.fafica.SGP.entidadesDAO.LogarAdminDao;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;

@WebServlet("/ServletConnectionBancoPesqCliente")
public class ServletConnectionBancoPesqCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoPesqCliente() {
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

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			SGP_MySQL.getInstance().conectarBD();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		String cpf = request.getParameter("Pesquisar");

		PrintWriter out = response.getWriter();

		try {
			ClienteDAO pesq = new ClienteDAO();
			boolean status = pesq.procurarCliente(cpf);
			if(pesq.result== true){
				//out.println("<script>document.location.href='inicio.jsp';</script>");
				out.println("OK");
			}else{
				out.println("Não Encontrado");
				//out.println("Login ou senha inválidos. <script>document.location.href='index.jsp';</script>");
			}
			//FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UserAdminNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizado!");


	}

}
