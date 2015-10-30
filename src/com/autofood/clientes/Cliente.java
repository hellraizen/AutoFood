package com.autofood.clientes;

import com.autofood.endereco.Endereco;

public class Cliente {

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private Integer codigo;
	private String email;
	private String telefone;
	private Endereco endereco;

	public Cliente(String nome, String cpf, String dataNascimento, String sexo, String email, String telefone) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setEmail(email);
		setTelefone(telefone);

	}


	public Cliente(String nome, String cpf, String dataNascimento, String sexo, Integer codigo, String email,
			String telefone) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setCodigo(codigo);
		setEmail(email);
		setTelefone(telefone);

	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", codigo=" + codigo + ", email=" + email + ", telefone=" + telefone + "]";
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
