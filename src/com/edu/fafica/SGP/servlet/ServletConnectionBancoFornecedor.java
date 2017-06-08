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

@WebServlet("/ServletConnectionBancoFornecedor")
public class ServletConnectionBancoFornecedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoFornecedor() {
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
		
		String razaoSocial = request.getParameter("razaoSocial");
		String nomeFantasia = request.getParameter("nomeFantasia");
		String cnpj = request.getParameter("cnpj");
		String ie = request.getParameter("ie");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String cep = request.getParameter("cep");
		String rua = request.getParameter("endereco");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String uf = request.getParameter("uf");
		String operadora = request.getParameter("operadora");
		
		PrintWriter out = response.getWriter();	
		
		String html = "<div align='center'>";

		html += "<html>";
		
		html += "	<head>";
		html += "		<meta charset='utf-8'/>";
		html += "		<title>@Cadastrado</title>";
		html += "		<link rel='stylesheet' type='text/css' href='estilo.css' />";
		html += "	</head>";
		
		html += "	<body>";
		html += "		<div align='center'><br/><br/><br/><br/>";
		html += "			<h2 style='transition-delay: 10s;'>Cadastrado com Sucesso</h2><br/><br/><h3>Fornecedor "+nomeFantasia+" CNPJ "+cnpj+"</h3><script>document.location.href='CadastroCliente.jsp';</script>";
		html += "		</div>";
		html += "	</body>";
		
		html += "</html>";

		html += "</div>";
		
		out.println(html);		
		Fornecedor fornecedor = new Fornecedor(razaoSocial, cnpj, ie, rua, numero, bairro, cidade, uf, cep, email, telefone, celular, operadora, nomeFantasia);
		try {
			FachadaSGP.getUniqueInstance().cadastrarFornecedor(fornecedor);
		} catch (ClassNotFoundException | SQLException | FornecedorJaCadastradoException | FornecedorCNPJInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
