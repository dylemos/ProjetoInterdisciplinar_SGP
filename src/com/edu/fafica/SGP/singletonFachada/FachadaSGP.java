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
				System.err.println("\n\t\t\tO SGP j� est� em funcionamento!\n");
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

	public void removerCliente(String cpf) throws Exception {
		this.controladorCliente.removerCliente(cpf);
	}

	public Cliente procurarCliente(String cpf) throws Exception {
		return this.controladorCliente.procurarCliente(cpf);
	}
	
	public HashSet<Cliente> listarClientes() throws Exception{
		return this.controladorCliente.listarClientes();
	}
	
//	------------------------------------------- UserAdmin ----------------------------------------------------------------


	public void cadastrarUserAdmin(UserAdmin userAdmin)	throws SQLException, UserAdminJaCadastradoException,  UserAdminCpfInvalidoException {
		this.controladorUserAdimin.cadastrarUserAdmin(userAdmin);
	}

	
	public void atualizarUserAdmin(UserAdmin userAdmin) throws UserAdminNaoEncontradoException, Exception {
		this.controladorUserAdimin.atualizarUserAdmin(userAdmin);
	}

	
	public void removerUserAdmin(String cpf) throws UserAdminNaoEncontradoException, Exception {
		 this.controladorUserAdimin.removerUserAdmin(cpf);
	}

	
	public UserAdmin procurarUserAdmin(String cpf) throws UserAdminCpfInvalidoException, UserAdminNaoEncontradoException, Exception {
		return this.controladorUserAdimin.procurarUserAdmin(cpf);
	}
	
	public HashSet<UserAdmin> listarUserAdmins() throws ClassNotFoundException{
		return this.controladorUserAdimin.listarUserAdmins();
	}

	
//	------------------------------------------- Fornecedor ----------------------------------------------------------------
	
	
	public void cadastrarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorJaCadastradoException, FornecedorCNPJInvalidoException {
		this.controladorFornecedor.cadastrarFornecedor(fornecedor);
	}
	
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws Exception {
		this.controladorFornecedor.atualizarFornecedor(fornecedor);
	}
	
	
	public void removerFornecedor(String cnpj) throws Exception {
		this.controladorFornecedor.removerFornecedor(cnpj);
	}
	
	
	public Fornecedor procurarFornecedor(String cnpj) throws FornecedorNaoEncontradoException, Exception {
		return this.controladorFornecedor.procurarFornecedor(cnpj);
	}
	
	public HashSet<Fornecedor> listarFornecedores() throws ClassNotFoundException{
		return this.controladorFornecedor.listarFornecedores();
	}

//	------------------------------------------- Plano ----------------------------------------------------------------
	
	public void cadastrarPlano(Plano plano) throws SQLException, PlanoJaCadastradoException {
		this.controladorPlano.cadastrarPlano(plano);
	}
	
	public void atualizarPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, ClassNotFoundException {
		this.controladorPlano.atualizarPlano(plano);
	}
	
	public void removerPlano(Plano plano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {
		this.controladorPlano.removerPlano(plano);
	}
	
	public Plano procurarPlano(String nomePlano) throws SQLException, PlanoNaoEncontradoException, PlanoIdInvalidoException, ClassNotFoundException {
		return this.controladorPlano.procurarPlano(nomePlano);
	}
	
	public HashSet<Plano> listarPlanos() throws ClassNotFoundException{
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
	
	public Conta procurarConta(String cpf) throws SQLException, ContaNaoEncontradaException, ContaIdInvalidoException {
		return this.controladorConta.procurarConta(cpf);
	}

	public HashSet<Conta> listarContas() throws ClassNotFoundException{
		return this.controladorConta.listarContas();
	}
	
	
//	------------------------------------------- Chamado ----------------------------------------------------------------
	
	public void cadastrarChamado(Chamado chamado) throws SQLException, ChamadoJaCadastradoException {
		this.controladorChamado.cadastrarChamado(chamado);
	}
	
	public void atualizarChamado(Chamado chamado) throws SQLException, ChamadoNaoEncontradoException, Exception {
		this.controladorChamado.atualizarChamado(chamado);
	}
	
	public void removerChamado(int id) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		 this.controladorChamado.removerChamado(id);
	}
	
	public Chamado procurarChamado(String cpfCliente) throws SQLException, ChamadoNaoEncontradoException, ChamadoIdInvalidoException {
		return this.controladorChamado.procurarChamado(cpfCliente);
	}
	
	public HashSet<Chamado> listarChamados() throws ClassNotFoundException {
		return this.controladorChamado.listarChamados();
	}
	
//--------------------------------------------------------------------------------------------------------------------------------	
	
}//fim da classe
