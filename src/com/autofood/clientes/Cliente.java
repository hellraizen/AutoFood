package com.autofood.clientes;

public class Cliente {
	//dyegoooooo

	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private Integer codigo;

	public Cliente(String nome, String cpf, String dataNascimento, String sexo) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);

	}

	public Cliente(String nome, String cpf, String dataNascimento, String sexo, Integer codigo) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setCodigo(codigo);

	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", codigo=" + codigo + "]";
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
