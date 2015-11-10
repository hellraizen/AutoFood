package com.autofood.endereco;

public class Endereco {
	
	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	private String cidade;

	public Endereco(String rua,String bairro,String numero,String cep,String cidade)
	{
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String toString()
	{
		return "[ Rua: "+ this.rua +" | Bairro: " + this.bairro + " | Número: " + this.numero + " | CEP: " + this.cep + " | Cidade: " + this.cidade + " ]";
	}
}
