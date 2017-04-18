package com.edu.fafica.SGP.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SGP_MySQL {

	
	private static String status = "";
	
	public static Connection conectarBD(){
		
		Connection connection = null;
		
		String URL = "jdbc:mysql://localhost:3306/projetointerdisciplinar_sgp";
		String USUARIO = "root";
		String SENHA = "mysql";
		String DRIVER = "org.gjt.mm.mysql.Driver";
		
		try {
			Class.forName(DRIVER).newInstance();
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			status = "Connection Opened";
			System.out.println(status+" Conectado ao MySQL com sucesso!");
		} catch (Exception e) {
			status = e.getMessage();
			System.out.println(status);
			throw new RuntimeException("Erro na conexão: ",e);
		}
		
		return connection;
	}
	
	
	public void desconectarBD()
	{
		try {
		//	connection.close();
			System.out.println("Conexão ao MySQL finalizada com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao fechar conexão com MySQL: "+e.getMessage());
		}
		
	}
	

}
