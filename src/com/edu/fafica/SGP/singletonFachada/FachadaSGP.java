package com.edu.fafica.SGP.singletonFachada;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.controladores.ControladorChamado;
import com.edu.fafica.SGP.controladores.ControladorCliente;
import com.edu.fafica.SGP.controladores.ControladorConta;
import com.edu.fafica.SGP.controladores.ControladorFornecedor;
import com.edu.fafica.SGP.controladores.ControladorPlano;
import com.edu.fafica.SGP.controladores.ControladorUserAdmin;
import com.edu.fafica.SGP.entidades.Chamado;
import com.edu.fafica.SGP.entidades.Cliente;
import com.edu.fafica.SGP.entidades.Conta;
import com.edu.fafica.SGP.entidades.Fornecedor;
import com.edu.fafica.SGP.entidades.Plano;
import com.edu.fafica.SGP.entidades.UserAdmin;
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

public class FachadaSGP {
	
	private volatile static FachadaSGP uniqueInstance;
	
	private ControladorCliente controladorCliente;
	private ControladorUserAdmin controladorUserAdimin;
	private ControladorFornecedor controladorFornecedor;
	private ControladorPlano controladorPlano;
	private ControladorConta controladorConta;
	private ControladorChamado controladorChamado;
	
	private FachadaSGP() throws Exception{
		
		System.err.println("\t\t <<< SGP em funcionamento >>>\n");
		
		this.controladorCliente = new ControladorCliente();
		this.controladorUserAdimin = new ControladorUserAdmin();
		this.controladorFornecedor = new ControladorFornecedor();
		this.controladorPlano = new ControladorPlano();
		this.controladorConta = new ControladorConta();
		this.controladorChamado = new ControladorChamado();
		
	}

	public static FachadaSGP getUniqueInstance() throws ClassNotFoundException{
		
		try {
			if(uniqueInstance == null){
				synchronized (FachadaSGP.class) {
					if(uniqueInstance == null){
						uniqueInstance = new FachadaSGP();
					}else{
						return null;
					}
				}
			}else{
				System.err.println("\n\t\t\tO SGP já está em funcionamento!\n");
			}
		} catch (Exception e) {
			System.out.println("\nErro: "+e.getMessage()+"\n");
		}
		
		return uniqueInstance;
	}

	
//------------------------------------------- Cliente ----------------------------------------------------------------
	
	public void cadastrarCliente(Cliente cliente) throws SQLException, ClienteJaCadastradoException, ClienteCpfInvalidoException {
		this.controladorCliente.cadastrarCliente(cliente);
	}

	public void atualizarCliente(Cliente cliente) throws ClienteCpfInvalidoException, Exception {
		this.controladorCliente.atualizarCliente(cliente);
		
	}

	public void removerCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		this.controladorCliente.removerCliente(cpf);
	}

	public Cliente procurarCliente(String cpf) throws SQLException, ClienteNaoEncontradoException, ClienteCpfInvalidoException {
		return this.controladorCliente.procurarCliente(cpf);
	}
	
	public HashSet<Cliente> listarClientes(){
		return this.controladorCliente.listarClientes();
	}
	
//	------------------------------------------- UserAdmin ----------------------------------------------------------------


	public void cadastrarUserAdmin(UserAdmin userAdmin)	throws SQLException, UserAdminJaCadastradoException,  UserAdminCpfInvalidoException {
		this.controladorUserAdimin.cadastrarUserAdmin(userAdmin);
	}

	
	public void atualizarUserAdmin(UserAdmin userAdmin) throws SQLException, UserAdminNaoEncontradoException {
		this.controladorUserAdimin.atualizarUserAdmin(userAdmin);
	}

	
	public void removerUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {
		 this.controladorUserAdimin.removerUserAdmin(cpf);
	}

	
	public UserAdmin procurarUserAdmin(String cpf) throws SQLException, UserAdminNaoEncontradoException, UserAdminCpfInvalidoException {
		return this.controladorUserAdimin.procurarUserAdmin(cpf);
	}
	
	public HashSet<UserAdmin> listarUserAdmins(){
		return this.controladorUserAdimin.listarUserAdmins();
	}

	
//	------------------------------------------- Fornecedor ----------------------------------------------------------------
	
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException, FornecedorCNPJInvalidoException {
		this.controladorFornecedor.cadastrarFornecedor(fornecedor);
	}
	
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {
		this.controladorFornecedor.atualizarFornecedor(fornecedor);
	}
	
	
	public void removerFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		this.controladorFornecedor.removerFornecedor(cnpj);
	}
	
	
	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {
		return this.controladorFornecedor.procurarFornecedor(cnpj);
	}
	
	public HashSet<Fornecedor> listarFornecedores(){
		return this.controladorFornecedor.listarFornecedores();
	}

//	------------------------------------------- Plano ----------------------------------------------------------------
	
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException {
		this.controladorPlano.cadastrarPlano(plano);
	}
	
	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException {
		this.controladorPlano.atualizarPlano(plano);
	}
	
	public void removerPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		this.controladorPlano.removerPlano(id);
	}
	
	public Plano procurarPlano(int id) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException {
		return this.controladorPlano.procurarPlano(id);
	}
	
	public HashSet<Plano> listarPlanos(){
		return this.controladorPlano.listarPlanos();
	}
	
	
//	------------------------------------------- Conta ----------------------------------------------------------------
	
	
	public void cadastrarConta(Conta conta) throws SQLException, ContaJaCadastradaException {
		this.controladorConta.cadastrarConta(conta);
	}
	
	public void atualizarConta(Conta conta) throws SQLException, ContaNaoEncontradaException {
		this.controladorConta.atualizarConta(conta);
	}
	
	public void removerConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		this.controladorConta.removerConta(id);
	}
	
	public Conta procurarConta(int id) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		return this.controladorConta.procurarConta(id);
	}

	
	public HashSet<Conta> listarContas() {
		return this.controladorConta.listarContas();
	}
	
	
//	------------------------------------------- Chamado ----------------------------------------------------------------
	
	public void cadastrarChamado(Chamado chamado, Cliente cliente) throws SQLException, ChamadoJaCadastradoException {
		this.controladorChamado.cadastrarChamado(chamado, cliente);
	}
	
	public void atualizarChamado(Chamado chamado, Cliente cliente) throws SQLException, ChamadoNaoEncontradoException {
		this.controladorChamado.atualizarChamado(chamado, cliente);
	}
	
	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		 this.controladorChamado.removerChamado(id);
	}
	
	public Chamado procurarChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		return this.controladorChamado.procurarChamado(id);
	}
	
	public HashSet<Chamado> listarChamados() {
		return this.controladorChamado.listarChamados();
	}
	
//--------------------------------------------------------------------------------------------------------------------------------	
	
}//fim da classe
