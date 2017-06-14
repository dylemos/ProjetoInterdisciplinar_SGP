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
import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.entidadesDAO.PlanoDAO;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;

@WebServlet("/ServletConnectionBancoPesqPlano")
public class ServletConnectionBancoPesqPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoPesqPlano() {
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

		String nomePlano = request.getParameter("Pesquisar");

		PrintWriter out = response.getWriter();

		try {
			PlanoDAO planoDAO = new PlanoDAO();
			Plano plano = planoDAO.procurarPlanoNoBancoDeDados(nomePlano);
			
			if(plano.getNomePlano() != null 	&& !plano.getNomePlano().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(plano.getId());
				listaLigada.add(plano.getNomePlano());
				listaLigada.add(plano.getUpload());
				listaLigada.add(plano.getDownload());
				listaLigada.add(plano.getValor());
				
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraPlano.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);


			}else{
				out.println("Não Encontrado");
				//out.println("Login ou senha inválidos. <script>document.location.href='index.jsp';</script>");
			}
			
			//FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PlanoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizado!");


	}

}
