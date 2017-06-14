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
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidadesDAO.ClienteDAO;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;

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
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.procurarClienteNoBancoDeDados(cpf);
			
			if(cliente.getCpf() != null 	&& !cliente.getCpf().isEmpty()){
				LinkedList listaLigada = new LinkedList();
				listaLigada.add(cliente.getId());
				listaLigada.add(cliente.getStatus());
				listaLigada.add(cliente.getNomeCliente());
				listaLigada.add(cliente.getRg());
				listaLigada.add(cliente.getCpf());
				listaLigada.add(cliente.getDataNascimento());
				listaLigada.add(cliente.getDataCadasatro());
				listaLigada.add(cliente.getEmail());
				listaLigada.add(cliente.getTelefone());
				listaLigada.add(cliente.getCelular());
				listaLigada.add(cliente.getVencimentoPlano());
				listaLigada.add(cliente.getRua());
				listaLigada.add(cliente.getNumero());
				listaLigada.add(cliente.getBairro());
				listaLigada.add(cliente.getCidade());
				listaLigada.add(cliente.getUf());
				listaLigada.add(cliente.getCep());
				listaLigada.add(cliente.getLogin());
				listaLigada.add(cliente.getSenha());
				listaLigada.add(cliente.getTipoPlano());
				listaLigada.add(cliente.getOperadora());
				
				request.setAttribute("listaLigada", listaLigada);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraCliente.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);

			}else{
				out.println("Não Encontrado");
			}
			
			//FachadaSGP.getUniqueInstance().cadastrarUserAdmin(userAdmin);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClienteNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pesquisa Realizado!");


	}

}
