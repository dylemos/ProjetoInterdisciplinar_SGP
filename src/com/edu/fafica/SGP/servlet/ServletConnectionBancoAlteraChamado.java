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
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

@WebServlet("/ServletConnectionBancoAlteraChamado")
public class ServletConnectionBancoAlteraChamado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletConnectionBancoAlteraChamado() {
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
		String tipoChamado = request.getParameter("tipo");
		String statusChamado = request.getParameter("status");
		String cpfCliente = request.getParameter("cpfcliente");
		String nomeCliente = request.getParameter("cliente");
		String descProblema = request.getParameter("message");
		String dataAbertura = request.getParameter("date_cadastro");
		String dataFechamento = request.getParameter("date_fechamento");
		String descProblema2 = request.getParameter("descProblema2");
		
		int idChamado = Integer.parseInt(id);

		PrintWriter out = response.getWriter();		
		
		String html = " ";
		
		html += "<html>";
		html += "<body>";
		html += "<script>document.location.href='AlteraAtendimentoMsg.jsp';</script>";
		html += "</body>";
		html += "</html>";
		
		out.println(html);	
		Chamado chamado = new Chamado(idChamado, cpfCliente, nomeCliente, tipoChamado, descProblema, statusChamado, dataAbertura, dataFechamento, descProblema2);
		try {
			FachadaSGP.getUniqueInstance().atualizarChamado(chamado);
		} catch (ClassNotFoundException | SQLException | ChamadoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastrado no Banco de Dados!");
		
		
	}

}
