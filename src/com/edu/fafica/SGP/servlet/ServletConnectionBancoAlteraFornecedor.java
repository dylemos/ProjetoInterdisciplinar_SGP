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
import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoAlteraFornecedor")
public class ServletConnectionBancoAlteraFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAlteraFornecedor() {
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
		String razaoSocial = request.getParameter("razaoSocial");
		String cnpj = request.getParameter("cnpj");
		String ie = request.getParameter("ie");
		String rua = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String cep = request.getParameter("cep");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String operadora = request.getParameter("operadora");
		String nomeFantasia = request.getParameter("nomeFantasia");
		
		int idCliente = Integer.parseInt(id);
		
		PrintWriter out = response.getWriter();			
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='AlteraFornecedorMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		
		Fornecedor fornecedor = new Fornecedor(idCliente, razaoSocial, cnpj, ie, rua, numero, bairro, cidade, uf, cep, email, telefone, celular, operadora, nomeFantasia);
		try {
			FachadaSGP.getUniqueInstance().atualizarFornecedor(fornecedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Alterado no Banco de Dados!");
		
		
	}

}
