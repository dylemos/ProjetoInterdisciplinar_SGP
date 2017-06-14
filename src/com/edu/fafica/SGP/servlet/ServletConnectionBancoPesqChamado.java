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
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidadesDAO.ChamadoDAO;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;

@WebServlet("/ServletConnectionBancoPesqChamado")
public class ServletConnectionBancoPesqChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoPesqChamado() {
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
		
		String cpfCliente = request.getParameter("Pesquisar");

		PrintWriter out = response.getWriter();		
	
		try {
			ChamadoDAO chamadoDAO = new ChamadoDAO();
			Chamado chamado = chamadoDAO.procurarChamadoNoBancoDeDados(cpfCliente);
			
			if(chamado.getCpfCliente() != null 	&& !chamado.getCpfCliente().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(chamado.getId());
				listaLigada.add(chamado.getCpfCliente());
				listaLigada.add(chamado.getNomeCliente());
				listaLigada.add(chamado.getTipoChamado());
				listaLigada.add(chamado.getDescProblema());
				listaLigada.add(chamado.getDescProblema2());
				listaLigada.add(chamado.getStatusChamado());
				listaLigada.add(chamado.getDataAbertura());
				listaLigada.add(chamado.getDataFechamento());
				
				System.out.println(listaLigada);
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraAtendimento.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);

			}else{
				out.println("Não Encontrado");
			}
			
			//FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChamadoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizado!");


	}

}
