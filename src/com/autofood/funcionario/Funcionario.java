package com.autofood.funcionario;

import com.autofood.endereco.Endereco;

public class Funcionario
{
	private Integer idFuncionario;
	private String nomeFuncionario;
	private String cpfFuncionario;
	private Endereco enderecoFuncionario;
	private String dataNascimentoFuncionario;
	private String sexoFuncionario;
	private String telefoneFuncionario;
	private String emailFuncionario;
	private String tipoFuncionario;
	private String login;
	private String senha;
	
	public Funcionario(Integer idFuncionario,String nomeFuncionario,String cpfFuncionario,Endereco enderecoFuncionario,String dataNascimentoFuncionario,String sexoFuncionario,String telefoneFuncionario,String emailFuncionario,String tipoFuncionario,String login,String senha)
	{
		setIdFuncionario(idFuncionario);
		setNomeFuncionario(nomeFuncionario);
		setCpfFuncionario(cpfFuncionario);
		setEnderecoFuncionario(enderecoFuncionario);
		setDataNascimentoFuncionario(dataNascimentoFuncionario);
		setSexoFuncionario(sexoFuncionario);
		setTelefoneFuncionario(telefoneFuncionario);
		setEmailFuncionario(emailFuncionario);
		setTipoFuncionario(tipoFuncionario);
		setLogin(login);
		setSenha(senha);
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public Endereco getEnderecoFuncionario() {
		return enderecoFuncionario;
	}

	public void setEnderecoFuncionario(Endereco enderecoFuncionario) {
		this.enderecoFuncionario = enderecoFuncionario;
	}

	public String getDataNascimentoFuncionario() {
		return dataNascimentoFuncionario;
	}

	public void setDataNascimentoFuncionario(String dataNascimentoFuncionario) {
		this.dataNascimentoFuncionario = dataNascimentoFuncionario;
	}

	public String getSexoFuncionario() {
		return sexoFuncionario;
	}

	public void setSexoFuncionario(String sexoFuncionario) {
		this.sexoFuncionario = sexoFuncionario;
	}

	public String getTelefoneFuncionario() {
		return telefoneFuncionario;
	}

	public void setTelefoneFuncionario(String telefoneFuncionario) {
		this.telefoneFuncionario = telefoneFuncionario;
	}

	public String getEmailFuncionario() {
		return emailFuncionario;
	}

	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}

	public String getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(String tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Funcionario [idFuncionario=" + idFuncionario + ", nomeFuncionario=" + nomeFuncionario
				+ ", cpfFuncionario=" + cpfFuncionario + ", enderecoFuncionario=" + enderecoFuncionario
				+ ", dataNascimentoFuncionario=" + dataNascimentoFuncionario + ", sexoFuncionario=" + sexoFuncionario
				+ ", telefoneFuncionario=" + telefoneFuncionario + ", emailFuncionario=" + emailFuncionario
				+ ", tipoFuncionario=" + tipoFuncionario + ", login=" + login + ", senha=" + senha + "]";
	}
	
	
}
