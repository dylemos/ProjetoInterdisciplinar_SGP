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

@WebServlet("/ServletConnectionBancoAlteraPlano")
public class ServletConnectionBancoAlteraPlano extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAlteraPlano() {
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
		String nomePlano = request.getParameter("nomePlano");
		String upload = request.getParameter("upload");
		String download = request.getParameter("download");
		String valor = request.getParameter("valor");
		
		int idPlano = Integer.parseInt(id);
		int uploadTaxa = Integer.parseInt(upload);
		int downloadTaxa = Integer.parseInt(download);
		double valorPlano = Double.parseDouble(valor);
		
		
		PrintWriter out = response.getWriter();			
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='AlteraPlanoMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		
		Plano plano = new Plano(idPlano, nomePlano, uploadTaxa, downloadTaxa, valorPlano);
		try {
			FachadaSGP.getUniqueInstance().atualizarPlano(plano);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Alterado no Banco de Dados!");
		
		
	}

}
