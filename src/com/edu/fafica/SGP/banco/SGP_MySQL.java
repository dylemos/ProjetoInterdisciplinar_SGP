package com.edu.fafica.SGP.banco;

import java.sql.Connection;
import java.sql.DriverManager;

public class SGP_MySQL {

	
	private static String status = "O MySQL ainda não foi Concetado!";
	private volatile static SGP_MySQL instance;
	private static Connection connection = null;
	
	private SGP_MySQL() throws ClassNotFoundException{
		
	}
	
	
	public static SGP_MySQL getInstance() throws ClassNotFoundException{
		
		try {
			if(instance == null){
				synchronized(SGP_MySQL.class){
					if(instance == null){
						instance = new SGP_MySQL();
					}
				}
			}else{
				System.err.println("\n\tO SGP_MySQL já está em funcionamento!\n");
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		return instance;
	}
	
	
	public static Connection conectarBD(){
		
		String URL = "jdbc:mysql://localhost:3306/projetointerdisciplinar_sgp";
		String USUARIO = "root";
		String SENHA = "mysql";
		String DRIVER = "org.gjt.mm.mysql.Driver";
		
		try {
			Class.forName(DRIVER).newInstance();
			connection = DriverManager.getConnection(URL, USUARIO, SENHA);
			status = "Connection Opened";
			System.out.println("\n"+status+" Conectado ao MySQL com sucesso!\n");
		} catch (Exception e) {
			status = e.getMessage();
			System.out.println(status);
			throw new RuntimeException("\nErro na conexão: ",e);
		}
		
		return connection;
	}
	
	
	public void desconectarBD()
	{
		try {
		//	connection.close();
			System.out.println("\nConexão ao MySQL finalizada com sucesso!\n");
		} catch (Exception e) {
			System.out.println("\nErro ao fechar conexão com MySQL: "+e.getMessage()+"\n");
		}
		
	}


	public static String getStatus() {
		System.out.println("Status SGP_MySQL: "+status+"\n");
		return status;
	}



}
