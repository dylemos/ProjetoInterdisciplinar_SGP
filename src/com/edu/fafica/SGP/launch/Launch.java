package com.edu.fafica.SGP.launch;

import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.entidades.UserAdmin;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

public class Launch {
	
	
	public static void main(String[] args) throws Exception {

		
		FachadaSGP sgp = FachadaSGP.getUniqueInstance();
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	
		
				
			
//		Cliente cl1 = new Cliente("Ativo","Dyego", "DyegoLogin", "Dyego123", "8.119.697","077.795.324-29", "81 30454633", "81 987345678", "Tim", "rafael_fafica@gmail.com", "Veneza", "100", "Universitário","Caruaru","PE","55028-400","1993-06-21","2017-04-05","AceleraNet",10);
//			sgp.cadastrarCliente(cl1);
		/*
//					sgp.cadastrarCliente(cl1);		//DUPLICADO

		Cliente cl2 = new Cliente("Ativo""Rafael", "RafaelLogin", "RafaelSH", "7.239.777","740.882.578-98", "81 30454601", "81 997345678", "Tim", "rafael_fafica@gmail.com", "Rua Preta", "786", "São Francisco","Caruaru","PE","55035-566","1987-05-14","2017-01-20","Acelera+",15);
//		sgp.cadastrarCliente(cl2);
						
		Cliente cl3 = new Cliente("Ativo""Mylena", "MylenaLogin", "MylenaSH", "4.986.745","108.550.874-98", "81 30452340", "81 994538973", "Claro", "mylena_fafica@gmail.com", "Guaratinguetá", "02A", "Centro","Caruaru","PE","55044-230","1977-05-14","2017-01-05","Plus++",30);
	//	sgp.cadastrarCliente(cl3);
		System.out.println("\n");
*/	
	
// 		sgp.procurarCliente(cl1.getCpf());
 		/*			System.out.println();
		
		

	*/
	
/*		//ATUALIZANDO
		cl1.setNomeCliente("Dyego L de Lima");
		cl1.setLogin("Dye_Login");
		cl1.setSenha("Dye_Senha");
		sgp.atualizarCliente(cl1);
		


 	*/
//		sgp.listarClientes();
 		//Removendo
//		sgp.removerCliente(cl1.getCpf());

//		sgp.removerCliente(cl2.getCpf());
		
//		sgp.listarClientes();
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
			
//		Fornecedor f1 = new Fornecedor("INFORTUDO","INFOTUDO", "26.975.874/0001-58", "Guaratinguetá", "101", "Centro","Caruaru","PE","55044-230", "fornecedor.vip@fornecedor.com", "81 37280099", "81 997785644", "TIM", "VIP_INFORMÁTICA");
//		sgp.cadastrarFornecedor(f1);
	
					
//		sgp.cadastrarFornecedor(f1); //DUPLICADO
				
		//Atualizando
//		f1.setRazaoSocial("TUDO EM INORMÁTICA");
//		sgp.atualizarFornecedor(f1);
		
/*				
		Fornecedor f2 = new Fornecedor("Faculdade-PE", "50.871.873/0001-48", "faculdade.ads@faculdade.edu.com", "81 37244499", "81 993455644", "Claro", "Caruaru-PE", "ComVC");
		sgp.cadastrarFornecedor(f2);
		
		sgp.listarFornecedores();
		
*/
//		sgp.removerFornecedor(f1.getCnpj());
	
		
//			sgp.procurarFornecedor(f1.getCnpj());
//		sgp.listarFornecedores();
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



//		UserAdmin u1 = new UserAdmin("Ativo","DyegoLemos","847.523.884-05","admin","admin");
//		sgp.cadastrarUserAdmin(u1);

//		UserAdmin u2 = new UserAdmin("Ativo","RafaelJosevaldo","852.295.302-35","adminRafa","admin");
//		sgp.cadastrarUserAdmin(u2);
		
//		sgp.cadastrarUserAdmin(u1);      //DUPLICADO
		
//		sgp.listarUserAdmins();
		
			//Atualizando
//		u1.setSenha("SenhaAqui");
//		sgp.atualizarUserAdmin(u1);


//		sgp.listarUserAdmins();
//		sgp.procurarUserAdmin(u2.getCpf());
		
//		sgp.removerUserAdmin(u1.getCpf());
//		sgp.removerUserAdmin(u2.getCpf());
		
//		sgp.procurarUserAdmin(u2.getCpf());
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		

//		Plano p1 = new Plano("Plus++", 2, 25, 59.9);
//		sgp.cadastrarPlano(p1);
		
/*	
		Plano p2 = new Plano("Economico", 1, 10, 29.9);
		sgp.cadastrarPlano(p2);
		
		sgp.cadastrarPlano(p1);      //DUPLICADO
	
		//Atualizando
		p1.setUpload(5);
		sgp.atualizarPlano(p1);
*/	
		
//		sgp.listarPlanos();
//		sgp.procurarPlano(p1.getNomePlano());
//		sgp.removerPlano(p1);
//		sgp.listarPlanos();
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


	
//		Conta ct1 = new Conta("071.414.714-13","a Pagar","Em Aberto",39.9,0.0,0.0,"","","",10);
//		sgp.cadastrarConta(ct1);
		/*	
		sgp.cadastrarConta(ct1);      //DUPLICADO
		
		Conta ct2 = new Conta("a Pagar",89.9,"Pendente");
		sgp.cadastrarConta(ct2);
		
		ct1.setStatusConta("Concluída");  //Atualizando
		sgp.atualizarConta(ct1);
		
		sgp.listarContas();
		
		sgp.removerConta(ct1.getId());
		
		sgp.listarContas();
		
		sgp.procurarConta(ct2.getId());
	 */
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
							
		
//		Chamado ch1 = new Chamado("071.414.714-13","Reparo em HardWare", "CPU com Defeito","Em Aberto", "2017-04-30", "2017-05-05");
//				sgp.cadastrarChamado(ch1);
				/*	
					
		Chamado ch2 = new Chamado(cl1,"Compra de HardWare", "Mouse com Defeito","Em Aberto", "2017-04-30", "2017-05-05");
		sgp.cadastrarChamado(ch2);
			
		sgp.cadastrarChamado(ch1); // Duplicado
		
		sgp.listarChamados();
		
		sgp.removerChamado(ch2.getId());
		
		sgp.listarChamados();
		
		
		//Atualizando
		ch1.setStatusChamado("Pendente");
		sgp.atualizarChamado(ch1);
		*/		
		
//		sgp.procurarChamado(ch1.getId());
		
		//Removendo
//		sgp.removerChamado(ch1.getId());

		
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



		
	/*	Calendar clCadastro = Calendar.getInstance();
		clCadastro.set(Calendar.YEAR, 1992); 
		clCadastro.set(Calendar.MONTH, Calendar.DECEMBER); 
		clCadastro.set(Calendar.DAY_OF_MONTH, 18);
	*/		


	
	//	FachadaSGP sgpTesteDuplicar = FachadaSGP.getUniqueInstance();
		
	}
	

}
