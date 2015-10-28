package com.autofood.clientes;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String sexo;
	private Integer codigo;
	private String email;
	private Integer telefone;
	private String rua;
	private String bairro;
	private String numero;
	private String cep;
	


	public Cliente(String nome, String cpf, String dataNascimento, String sexo, String email, Integer telefone, String rua, String bairro, String numero,String cep ) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setEmail(email);
		setTelefone(telefone);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		

	}

	public Cliente(String nome, String cpf, String dataNascimento, String sexo, Integer codigo,String email, Integer telefone, String rua, String bairro, String numero,String cep) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setCodigo(codigo);
		setEmail(email);
		setTelefone(telefone);
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);

	}

	
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
				+ ", codigo=" + codigo + ", email=" + email + ", telefone=" + telefone + ", rua=" + rua + ", bairro="
				+ bairro + ", numero=" + numero + ", cep=" + cep + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
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
