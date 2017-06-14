package com.edu.fafica.SGP.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoAlteraCliente")
public class ServletConnectionBancoAlteraCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAlteraCliente() {
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
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("codigo");
		String status = request.getParameter("status");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String rg = request.getParameter("rg");
		String email = request.getParameter("email");
		String celular = request.getParameter("celular");
		String operadora = request.getParameter("operadora");
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
		
		int idCliente = Integer.parseInt(id);
		int vencimentoPlano = Integer.parseInt(vencimento);
		
		PrintWriter out = response.getWriter();			
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='AlteraClienteMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		
		Cliente cliente = new Cliente(idCliente, status, nome, login, senha, rg, cpf, telefone, celular, operadora, email, rua, numero, bairro, cidade, uf, cep, date_nascimento, date_cadastro, vencimentoPlano);
		try {
			FachadaSGP.getUniqueInstance().atualizarCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Alterado no Banco de Dados!");
		
		
	}

}
