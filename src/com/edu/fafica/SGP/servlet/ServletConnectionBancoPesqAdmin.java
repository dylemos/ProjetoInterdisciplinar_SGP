package com.edu.fafica.SGP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.entidadesDAO.UserAdminDAO;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;;

@WebServlet("/ServletConnectionBancoPesqAdmin")
public class ServletConnectionBancoPesqAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoPesqAdmin() {
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
			UserAdminDAO UserAdminDAO = new UserAdminDAO();
			UserAdmin userAdmin = UserAdminDAO.procurarUserAdminNoBancoDeDados(cpf);
			//HashSet<Cliente> lista = pesq.listarClientesNoBancoDeDados();
			//Cliente cliente = new Cliente();
			
			if(userAdmin.getCpf() != null 	&& !userAdmin.getCpf().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(userAdmin.getId());
				listaLigada.add(userAdmin.getStatus());
				listaLigada.add(userAdmin.getNomeUserAdmin());
				listaLigada.add(userAdmin.getCpf());
				listaLigada.add(userAdmin.getLogin());
				listaLigada.add(userAdmin.getSenha());
				
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraAdmin.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);

			}else{
				out.println("Não Encontrado");
			}
			
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
