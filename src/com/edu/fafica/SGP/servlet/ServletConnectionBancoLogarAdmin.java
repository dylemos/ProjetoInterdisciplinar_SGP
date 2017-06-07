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
import com.edu.fafica.SGP.entidadesDAO.LogarAdminDao;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;

@WebServlet("/ServletConnectionBancoLogarAdmin")
public class ServletConnectionBancoLogarAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoLogarAdmin() {
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
		HttpSession session = request.getSession();
		try {
			SGP_MySQL.getInstance().conectarBD();

		} catch (Exception e) {
			e.printStackTrace();
		}

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		//LogarAdminDao lad = new LogarAdminDao();
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		//boolean status = lad.VerificarLogin(login, senha);

		PrintWriter out = response.getWriter();
		/*if(lad.result== true){
			out.println("<script>document.location.href='inicio.jsp';</script>");
		}else{
			out.println("Login ou senha inválidos. <script>document.location.href='index.jsp';</script>");
		}*/

		try {
			LogarAdminDao lad = new LogarAdminDao();
			boolean status = lad.VerificarLogin(login, senha);
			if(lad.result== true){
				session.putValue("loginUsuario", login);
				session.putValue("senhaUsuario", senha);
				out.println("<script>document.location.href='inicio.jsp';</script>");
			}else{
				out.println("Login ou senha inválidos. <script>document.location.href='index.jsp';</script>");
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
		System.out.println("Login Realizado!");


	}

}
