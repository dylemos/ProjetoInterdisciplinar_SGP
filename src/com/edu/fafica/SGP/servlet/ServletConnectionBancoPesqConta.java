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
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.entidadesDAO.ContaDAO;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;

@WebServlet("/ServletConnectionBancoPesqConta")
public class ServletConnectionBancoPesqConta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoPesqConta() {
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
			ContaDAO contaDAO = new ContaDAO();
			Conta conta = contaDAO.procurarContaNoBancoDeDados(cpf);
			
			if(conta.getCpfCliente() != null 	&& !conta.getCpfCliente().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(conta.getId());
				listaLigada.add(conta.getCpfCliente());
				listaLigada.add(conta.getNomeCliente());
				listaLigada.add(conta.getTipoConta());
				listaLigada.add(conta.getStatusConta());
				listaLigada.add(conta.getValor());
				listaLigada.add(conta.getDesconto());
				listaLigada.add(conta.getTotal());
				listaLigada.add(conta.getDataAbertura());
				listaLigada.add(conta.getDataVencimento());
				listaLigada.add(conta.getDataPago());
				listaLigada.add(conta.getQtdParcelas());
				
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraFinanceiro.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);

			}else{
				out.println("Não Encontrado");
			}
			
			//FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ContaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizada!");


	}

}
