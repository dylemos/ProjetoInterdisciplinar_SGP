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
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoChamado")
public class ServletConnectionBancoChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoChamado() {
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
		
		String tipoChamado = request.getParameter("tipo");
		String statusChamado = request.getParameter("status");
		String cpfCliente = request.getParameter("cpfcliente");
		String nome = request.getParameter("cliente");
		String descProblema = request.getParameter("message");
		String dataAbertura = request.getParameter("dataAbertura");
		//String dataFechamento = request.getParameter("dataFechamento");

		PrintWriter out = response.getWriter();		
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='CadastraAtendimentoMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		Chamado chamado = new Chamado(cpfCliente, tipoChamado, descProblema, statusChamado, dataAbertura);
		try {
			FachadaSGP.getUniqueInstance().cadastrarChamado(chamado);
		} catch (ClassNotFoundException | SQLException | ChamadoJaCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
