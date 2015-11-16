package com.autofood.fornecedor;

import com.autofood.endereco.Endereco;
import com.autofood.produto.Produto;

public class Fornecedor {

	private Integer idFornecedor;
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String produtoFornecido;
	private String telefoneFornecedor;
	private String emailFornecedor;
	private Endereco enderecoFornecedor;

	public Fornecedor(Integer idFornecedor, String nomeFornecedor,
			String cnpjFornecedor, String produtoFornecido,
			String telefoneFornecedor, String emailFornecedor,
			Endereco enderecoFornecedor) {
		
		setIdFornecedor(idFornecedor);
		setNomeFornecedor(nomeFornecedor);
		setCnpjFornecedor(cnpjFornecedor);
		setProdutoFornecido(produtoFornecido);
		setTelefoneFornecedor(telefoneFornecedor);
		setEmailFornecedor(emailFornecedor);
		setEnderecoFornecedor(enderecoFornecedor);
		

	}
	
	public Fornecedor(String nomeFornecedor,
			String cnpjFornecedor, String produtoFornecido,
			String telefoneFornecedor, String emailFornecedor,
			Endereco enderecoFornecedor) {
		
		setNomeFornecedor(nomeFornecedor);
		setCnpjFornecedor(cnpjFornecedor);
		setProdutoFornecido(produtoFornecido);
		setTelefoneFornecedor(telefoneFornecedor);
		setEmailFornecedor(emailFornecedor);
		setEnderecoFornecedor(enderecoFornecedor);

	}
	
	public Fornecedor(String nomeFornecedor,
			String cnpjFornecedor, String produtoFornecido,
			String telefoneFornecedor, String emailFornecedor) {
		
		setNomeFornecedor(nomeFornecedor);
		setCnpjFornecedor(cnpjFornecedor);
		setProdutoFornecido(produtoFornecido);
		setTelefoneFornecedor(telefoneFornecedor);
		setEmailFornecedor(emailFornecedor);
		
	}
	
	public Fornecedor(Integer idFornecedor,String nomeFornecedor,
			String cnpjFornecedor, String produtoFornecido,
			String telefoneFornecedor, String emailFornecedor) {
		
		setIdFornecedor(idFornecedor);
		setNomeFornecedor(nomeFornecedor);
		setCnpjFornecedor(cnpjFornecedor);
		setProdutoFornecido(produtoFornecido);
		setTelefoneFornecedor(telefoneFornecedor);
		setEmailFornecedor(emailFornecedor);
		
	}
	

	public Integer getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Integer idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNomeFornecedor() {
		return nomeFornecedor;
	}

	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}

	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}

	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}

	public String getProdutoFornecido() {
		return produtoFornecido;
	}

	public void setProdutoFornecido(String produtoFornecido) {
		this.produtoFornecido = produtoFornecido;
	}

	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}

	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	public String getEmailFornecedor() {
		return emailFornecedor;
	}

	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}

	public Endereco getEnderecoFornecedor() {
		return enderecoFornecedor;
	}

	public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}

	public String toString() {
		return "Fornecedor [idFornecedor=" + idFornecedor + ", nomeFornecedor="
				+ nomeFornecedor + ", cnpjFornecedor=" + cnpjFornecedor
				+ ", produtoFornecido=" + produtoFornecido
				+ ", telefoneFornecedor=" + telefoneFornecedor
				+ ", emailFornecedor=" + emailFornecedor
				+ ", enderecoFornecedor=" + enderecoFornecedor + "]";
	}
}
