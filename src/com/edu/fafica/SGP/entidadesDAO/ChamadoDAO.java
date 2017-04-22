package com.edu.fafica.SGP.entidadesDAO;

import java.sql.Connection;
import java.sql.Statement;
import com.edu.fafica.SGP.banco.SGP_MySQL;
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;

public class ChamadoDAO {

	public ChamadoDAO() throws Exception {
		SGP_MySQL.getInstance();
	}
	
	
	public void cadastrarChamadoNoBancoDeDados(Chamado chamado, Cliente cliente) throws ClassNotFoundException, ChamadoJaCadastradoException, ChamadoIdInvalidoException, Exception{
		
		Connection conn = SGP_MySQL.conectarBD();
		
		try {
			
			Statement statement = conn.createStatement();
			
			String query = "";
			
			query += "insert into chamado(ID_CHAMADO, ID_CLIENTE, TIPOCHAMADO, DESCPROBLEMA, STATUS, DT_ABERTURA, DT_FECHAMENTO)";
			query += "values('"+chamado.getId()+"','"+cliente.getId()+"', '"+chamado.getTipoChamado()+"', '"+chamado.getDescProblema()+"', '"+chamado.getStatusChamado()+"', '"+chamado.getDataAbertura()+"', '"+chamado.getDataFechamento()+"')";
			statement.execute(query);
		
			System.out.println("\n Chamado "+chamado.getTipoChamado()+" Cadastrado no Banco de Dados! \n");
			
		} catch (Exception e) {
			System.out.println("\nErro : "+e.getMessage()+"\n");
		}
	}
	
	
}
