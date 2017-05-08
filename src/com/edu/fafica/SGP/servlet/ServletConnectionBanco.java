package com.edu.fafica.SGP.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.repositoriosJDBC.RepositorioClienteJDBC;

/**
 * Servlet implementation class ServletConnectionBanco
 */
@WebServlet("/ServletConnectionBanco")
public class ServletConnectionBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBanco() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			SGP_MySQL.getInstance().conectarBD();

			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String rg = request.getParameter("rg");
			String email = request.getParameter("email");
			String celular = request.getParameter("celular");
			String telefone = request.getParameter("telefone");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("endereco");
			String numero = request.getParameter("numero");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String uf = request.getParameter("uf");
			String vencimento = request.getParameter("vencimento");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String date_nascimento = request.getParameter("date_nascimento");
			String date_cadastro = request.getParameter("date_cadastro");
			
			int vencimentoPlano = Integer.parseInt(vencimento);
			
			Cliente cliente = new Cliente(nome, login, senha, rg, cpf, telefone, celular, email, rua, numero, bairro, cidade, uf, cep, date_nascimento, date_cadastro, vencimentoPlano);
			RepositorioClienteJDBC repositorio = new RepositorioClienteJDBC();
			repositorio.cadastrarCliente(cliente);
			System.out.println("Cadastrado no Banco de Dados!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
