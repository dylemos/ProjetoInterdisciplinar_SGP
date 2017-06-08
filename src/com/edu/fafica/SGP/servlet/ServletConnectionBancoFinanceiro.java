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
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoPlanoFinanceiro")
public class ServletConnectionBancoFinanceiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoFinanceiro() {
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
		
		String cpfCliente = request.getParameter("cpfCliente");
		String tipoConta = request.getParameter("tipoConta");
		String statusConta = request.getParameter("statusConta");
		String valor = request.getParameter("valor");
		String desconto = request.getParameter("desconto");
		String total = request.getParameter("total");
		String dataAbertura = request.getParameter("dataAbertura");
		String dataVencimento = request.getParameter("dataVencimento");
		String qtdParcelas = request.getParameter("parcelas");
		
		double valorConta = Double.parseDouble(valor);
		double descontoConta = Double.parseDouble(desconto);
		double totalConta = Double.parseDouble(total);
		int qtdParcelasConta = Integer.parseInt(qtdParcelas);

//		cpfCliente, tipoConta, statusConta, valorConta, descontoConta, totalConta, dataAbertura, dataVencimento, dataPago, qtdParcelasConta
		PrintWriter out = response.getWriter();		

		String html = " ";
		
		html += "<html>";
		
		html += "	<head>";
		html += "		<meta charset='utf-8'/>";
		html += "		<title>@Cadastrado</title>";
		html += "		<link rel='stylesheet' type='text/css' href='estilo.css' />";
		html += "	</head>";
		
		html += "	<body>";
		html += "		<div align='center'><br/><br/><br/><br/>";
		html += "			<h2 style='transition-delay: 10s;'>Cadastrado com Sucesso</h2><br/><br/><h3>Tipo Conta "+tipoConta+" Valor R$"+totalConta+"</h3><script>document.location.href='CadastroCliente.jsp';</script>";
		html += "		</div>";
		html += "	</body>";
		
		html += "</html>";
 
		out.println(html);		
		Conta conta = new Conta(cpfCliente, tipoConta, statusConta, valorConta, descontoConta, totalConta, dataAbertura, dataVencimento, qtdParcelasConta);
		try {
			FachadaSGP.getUniqueInstance().cadastrarConta(conta);
		} catch (ClassNotFoundException | SQLException | ContaJaCadastradaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
