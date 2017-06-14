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
import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.entidadesDAO.FornecedorDAO;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;

@WebServlet("/ServletConnectionBancoPesqFornecedor")
public class ServletConnectionBancoPesqFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletConnectionBancoPesqFornecedor() {
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

		String cnpj = request.getParameter("Pesquisar");

		PrintWriter out = response.getWriter();

		try {
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			Fornecedor fornecedor = fornecedorDAO.procurarFornecedorNoBancoDeDados(cnpj);
			
			if(fornecedor.getCnpj() != null 	&& !fornecedor.getCnpj().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(fornecedor.getId());
				listaLigada.add(fornecedor.getRazaoSocial());
				listaLigada.add(fornecedor.getCnpj());
				listaLigada.add(fornecedor.getIe());
				listaLigada.add(fornecedor.getRua());
				listaLigada.add(fornecedor.getNumero());
				listaLigada.add(fornecedor.getBairro());
				listaLigada.add(fornecedor.getCidade());
				listaLigada.add(fornecedor.getUf());
				listaLigada.add(fornecedor.getCep());
				listaLigada.add(fornecedor.getEmail());
				listaLigada.add(fornecedor.getTelefone());
				listaLigada.add(fornecedor.getCelular());
				listaLigada.add(fornecedor.getOperadora());
				listaLigada.add(fornecedor.getNomeFantasia());
				
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraFornecedor.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);


			}else{
				out.println("Não Encontrado");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FornecedorNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizado!");


	}

}
