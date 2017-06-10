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
			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.procurarClienteNoBancoDeDados(cpf);
			//HashSet<Cliente> lista = pesq.listarClientesNoBancoDeDados();
			//Cliente cliente = new Cliente();
			
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
				
				//System.out.println(listaLigada);
				//getServletContext().setAttribute("clienteDAO.list", clienteDAO.list);
				request.setAttribute("listaLigada", listaLigada);
				//response.sendRedirect("AlteraCliente.jsp?msg=" + clienteDAO.list);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("AlteraCliente.jsp?msg=" + listaLigada);
				dispatcher.forward(request, response);
				//out.println("<script>document.location.href='AlterarCliente.jsp';</script>");

/*				String html = " ";
				
				

									for (Cliente cliente : lista) {
										if(cliente.getCpf().equals(cpf)){
											html += "<h2>"+cliente.toStringBasica()+"</h2>";
										}
									}
		
				
				out.println(html);*/

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
