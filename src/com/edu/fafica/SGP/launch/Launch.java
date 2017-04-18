package com.edu.fafica.SGP.launch;

import java.sql.SQLException;

import com.edu.fafica.SGP.exceptions.ChamadoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ChamadoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ChamadoNaoEncontradoException;
import com.edu.fafica.SGP.exceptions.ClienteCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.ClienteJaCadastradoException;
import com.edu.fafica.SGP.exceptions.ClienteNaoEncontradoException;
import com.edu.fafica.SGP.exceptions.ContaIdInvalidoException;
import com.edu.fafica.SGP.exceptions.ContaJaCadastradaException;
import com.edu.fafica.SGP.exceptions.ContaNaoEncontradaException;
import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;
import com.edu.fafica.SGP.exceptions.PlanoIdInvalidoException;
import com.edu.fafica.SGP.exceptions.PlanoJaCadastradoException;
import com.edu.fafica.SGP.exceptions.PlanoNaoEncontradoException;
import com.edu.fafica.SGP.exceptions.UserAdminCpfInvalidoException;
import com.edu.fafica.SGP.exceptions.UserAdminJaCadastradoException;
import com.edu.fafica.SGP.exceptions.UserAdminNaoEncontradoException;
import com.edu.fafica.SGP.pessoas.Cliente;
import com.edu.fafica.SGP.singletonFachada.FachadaSGP;

public class Launch {
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ClienteJaCadastradoException, ClienteCpfInvalidoException, UserAdminJaCadastradoException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException, FornecedorJaCadastradoException, FornecedorCNPJInvalidoException, PlanoJaCadastradoException, ContaJaCadastradaException, ChamadoJaCadastradoException, ClienteNaoEncontradoException, FornecedorNaoEncontradoException, PlanoNaoEncontradoException, ContaNaoEncontradaException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException, ContaIdInvalidoException, PlanoIdInvalidoException {

		
		FachadaSGP sgp = FachadaSGP.getUniqueInstance();
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		

		/*
	
		Cliente cl1 = new Cliente("Dyego", "DyegoLogin", "DyegoSenha", "147.488.021-54", "81 992638973", "Claro", "dyego_fafica@gmail.com", "Caruaru-PE", "Ouro");
		sgp.cadastrarCliente(cl1);
		System.out.println();


		sgp.cadastrarCliente(cl1);		//DUPLICADO
		System.out.println();
		
		Cliente cl2 = new Cliente("Rafael", "RafaelLogin", "RafaelSenha", "740.882.578-98", "81 997358970", "Tim", "rafael_fafica@gmail.com", "Caruaru-PE", "PREMIUM");
		sgp.cadastrarCliente(cl2);
		System.out.println("\n");
		
		Cliente cl3 = new Cliente("Mylena", "MyleLogin", "MyleSenha", "108.550.874-98", "81 997358970", "Oi", "myle_fafica@gmail.com", "Caruaru-PE", "Platinum");
		sgp.cadastrarCliente(cl3);
		System.out.println("\n");
		
		
		sgp.procurarCliente("147.488.021-54");
		System.out.println();
		
		sgp.listarClientes();

	
		//ATUALIZANDO
		cl1.setNomeCliente("Dyego L de Lima");
		cl1.setLogin("Dye_Login");
		cl1.setSenha("Dye_Senha");
		sgp.atualizarCliente(cl1);
		
		sgp.listarClientes();


 		//Removendo
//		sgp.removerCliente(cl1.getCpf());
		sgp.removerCliente(cl2.getCpf());
		
		System.out.println();
		sgp.listarClientes();
		
		 */

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/*
		
		Fornecedor f1 = new Fornecedor("FaficaADS", "26.975.874/0001-58", "fafica.ads@faculdade.edu.com", "81 37280099", "81 997785644", "TIM", "Caruaru-PE", "ADS_PROVIMENTOS");
		sgp.cadastrarFornecedor(f1);
		
		sgp.cadastrarFornecedor(f1); //DUPLICADO
		
		//Atualizando
		f1.setRazaoSocial("Faculdade de Filosofia Ciências e Letras");
		sgp.atualizarFornecedor(f1);
		
		Fornecedor f2 = new Fornecedor("Faculdade-PE", "50.871.873/0001-48", "faculdade.ads@faculdade.edu.com", "81 37244499", "81 993455644", "Claro", "Caruaru-PE", "ComVC");
		sgp.cadastrarFornecedor(f2);
		
		sgp.listarFornecedores();
		
		sgp.removerFornecedor(f1.getCnpj());
		
		sgp.listarFornecedores();
		
		sgp.procurarFornecedor(f2.getCnpj());

		*/
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		/*

		UserAdmin u1 = new UserAdmin("DyegoLemos","847.523.884-05","admin","admin");
		sgp.cadastrarUserAdmin(u1);
		
		UserAdmin u2 = new UserAdmin("RafaelJosevaldo","852.295.302-35","admin","admin");
		sgp.cadastrarUserAdmin(u2);
		
		sgp.cadastrarUserAdmin(u1);      //DUPLICADO
		
		sgp.listarUserAdmins();
		
		sgp.removerUserAdmin(u1.getCpf());
		
		sgp.listarUserAdmins();
		
		sgp.procurarUserAdmin(u2.getCpf());
		
		//Atualizando
//		u.setNomeUserAdmin("Rafael_Admin");
//		sgp.atualizarUserAdmin(u);
 

			*/		
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		/*
	
		Plano p1 = new Plano("Plus++", "25mb", "5mb", 59.9);
		sgp.cadastrarPlano(p1);

		Plano p2 = new Plano("Extra+", "50mb", "15mb", 99.9);
		sgp.cadastrarPlano(p2);
		
		sgp.cadastrarPlano(p1);      //DUPLICADO
		
		sgp.listarPlanos();
		
		sgp.removerPlano(p1.getId());
		
		sgp.listarPlanos();
		
		//Atualizando
		p2.setNomePlano("Ouro");
		sgp.atualizarPlano(p2);

		sgp.procurarPlano(p2.getId());
		
		*/	
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

		/*
		
		Conta ct1 = new Conta("a Pagar",39.9,"Em Aberto");
		sgp.cadastrarConta(ct1);
		
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

		/*
	
		Chamado ch1 = new Chamado("Reparo em HardWare", "Em Aberto", "CPU com Defeito");
		sgp.cadastrarChamado(ch1);
		
		Chamado ch2 = new Chamado("Compra de HardWare", "Em Aberto", "Compra de CPU");
		sgp.cadastrarChamado(ch2);
		
		sgp.cadastrarChamado(ch1); // Duplicado
		
		sgp.listarChamados();
		
		sgp.removerChamado(ch2.getId());
		
		sgp.listarChamados();
		
	
		//Atualizando
		ch1.setStatusChamado("Pendente");
		sgp.atualizarChamado(ch1);
		
		
		sgp.procurarChamado(ch1.getId());
		
		//Removendo
		sgp.removerChamado(ch1.getId());

		
			*/
		
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------



/*
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1992); 
		c.set(Calendar.MONTH, Calendar.DECEMBER); 
		c.set(Calendar.DAY_OF_MONTH, 18);		
		
		Date data = c.getTime();
*/

	
	//	FachadaSGP sgpTesteDuplicar = FachadaSGP.getUniqueInstance();
		
	}
	

}
