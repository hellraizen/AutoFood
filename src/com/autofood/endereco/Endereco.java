package com.autofood.endereco;

import com.autofood.clientes.Cliente;
import com.autofood.fornecedor.Fornecedor;
import com.autofood.funcionario.Funcionario;

// CLASSE PRONTA !!

public class Endereco {
	
	private Integer idEndereco;
	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	private String complemento;
	private Cliente cliente;
	private Funcionario funcionario;
	private Fornecedor fornecedor;

	
	
	public Endereco(Integer idEndereco,String rua,String bairro,String numero,String cep,String complemento,Cliente cliente,Funcionario funcionario,Fornecedor fornecedor)
	{
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setComplemento(complemento);  
		setCliente(cliente); 
		setFuncionario(funcionario);
		setFornecedor(fornecedor);
		}

	
	
	public Integer getIdEndereco() {
		return idEndereco;
	}



	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}



	public String getRua() {
		return rua;
	}



	public void setRua(String rua) {
		this.rua = rua;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Funcionario getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	public String toString()
	{
		return "[ ID_Endereço: " + this.idEndereco +" | Rua: "+ this.rua +" | Bairro: " + this.bairro + " | Número: " + this.numero + " | CEP: " + this.cep + " | Complemento: " + this.complemento + "| Cliente: "+ this.cliente+" | Funcionário: "+ this.funcionario + " | Fornecedor: "+ this.fornecedor +" ]";
	}
}
