package com.edu.fafica.SGP.controladores;

import java.sql.SQLException;
import java.util.HashSet;

import com.edu.fafica.SGP.exceptions.FornecedorCNPJInvalidoException;
import com.edu.fafica.SGP.exceptions.FornecedorJaCadastradoException;
import com.edu.fafica.SGP.exceptions.FornecedorNaoEncontradoException;
import com.edu.fafica.SGP.interfaces.IRepositorioFornecedor;
import com.edu.fafica.SGP.pessoas.Fornecedor;
import com.edu.fafica.SGP.repositorios.RepositorioFornecedorList;
import com.edu.fafica.SGP.util.ValidarCNPJ;

public class ControladorFornecedor {

	private IRepositorioFornecedor repositorioFornecedor;
	private HashSet<Fornecedor> listaFornecedor;
	private int index;

	public ControladorFornecedor() {
		// Define qual repositório usar
		this.repositorioFornecedor = new RepositorioFornecedorList();

		// Implementa a lista
		this.listaFornecedor = new HashSet<Fornecedor>();
		this.index = 1;
	}

	public void cadastrarFornecedor(Fornecedor fornecedor)
			throws SQLException, FornecedorJaCadastradoException, FornecedorCNPJInvalidoException {

		try {

			if (!listaFornecedor.contains(fornecedor)) {

				if (ValidarCNPJ.validaCNPJ(fornecedor.getCnpj())) {

					fornecedor.setId(index);
					listaFornecedor.add(fornecedor);
					this.repositorioFornecedor.cadastrarFornecedor(fornecedor);
					index++;

				} else {
					throw new FornecedorCNPJInvalidoException();
				}

			} else {
				throw new FornecedorJaCadastradoException();
			}

		} catch (Exception e) {
			System.out.println(fornecedor.getNomeFantasia() + e.getMessage());
			System.out.println();
		}

	}

	public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException, FornecedorNaoEncontradoException {

		if (this.listaFornecedor.contains(fornecedor)) {

			int i = fornecedor.getId();

			try {

				for (Fornecedor fornecedores : listaFornecedor) {
					if (i == fornecedores.getId()) {
						this.listaFornecedor.remove(fornecedores);
						fornecedor.setId(i);
						this.listaFornecedor.add(fornecedor);
						this.repositorioFornecedor.atualizarFornecedor(fornecedor);
					}
				}

			} catch (Exception e) {
				e.getMessage();
				System.out.println();
			}

		} else {
			System.err.println("\n\t\t O Fornecedor Ainda Não Foi Cadastrado!");
		}

	}

	public void removerFornecedor(String cnpj)
			throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {

		try {

			if (ValidarCNPJ.validaCNPJ(cnpj)) {

				for (Fornecedor fornecedor : listaFornecedor) {

					if (fornecedor.getCnpj().equals(cnpj)) {
						this.listaFornecedor.remove(fornecedor);
						this.repositorioFornecedor.removerFornecedor(cnpj);
					}

				}

			} else {
				System.out.println("Fornecedor Não foi Encontrado!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

	}

	public Fornecedor procurarFornecedor(String cnpj) throws SQLException, FornecedorNaoEncontradoException, FornecedorCNPJInvalidoException {

		try {

			if (ValidarCNPJ.validaCNPJ(cnpj)) {

				for (Fornecedor fornecedor : listaFornecedor) {
					if (fornecedor.getCnpj().equals(cnpj)) {
						this.repositorioFornecedor.procurarFornecedor(cnpj);
						return fornecedor;
					}
				}
			} else {
				System.out.println("CNPJ Inválido!");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println();
		}

		return null;
	}

	public HashSet<Fornecedor> listarFornecedores() {
		return this.repositorioFornecedor.listarFornecedores();
	}

}
