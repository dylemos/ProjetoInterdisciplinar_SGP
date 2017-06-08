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
import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoPlano")
public class ServletConnectionBancoPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoPlano() {
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
		
		String nomePlano = request.getParameter("nomePlano");
		String upload = request.getParameter("upload");
		String download = request.getParameter("download");
		String valor = request.getParameter("valor");
		
		int uploadTaxa = Integer.parseInt(upload);
		int downloadTaxa = Integer.parseInt(download);
		double valorPlano = Double.parseDouble(valor);
		
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
		html += "			<h2 style='transition-delay: 10s;'>Cadastrado com Sucesso</h2><br/><br/><h3>Plano "+nomePlano+" Valor R$"+valorPlano+"</h3><script>document.location.href='CadastroCliente.jsp';</script>";
		html += "		</div>";
		html += "	</body>";
		
		html += "</html>";
		
		out.println(html);
		Plano plano = new Plano(nomePlano, uploadTaxa, downloadTaxa, valorPlano);
		try {
			FachadaSGP.getUniqueInstance().cadastrarPlano(plano);
		} catch (ClassNotFoundException | SQLException | PlanoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
