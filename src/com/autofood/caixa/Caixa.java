package com.autofood.caixa;

import java.util.Date;

public class Caixa {
	private Double entrada;
	private Double saida;
	private Integer idComanda;
	private Double totalCaixa;
	private Integer idFuncionario;
	private Date data;

	public Caixa(Double entrada, Integer idComanda, Integer idFuncionario) {
		setEntrada(entrada);
		setIdComanda(idComanda);
		setIdFuncionario(idFuncionario);


	}
	public Caixa(Double entrada,Integer idComanda, Integer idFuncionario, Date data) {
		setEntrada(entrada);
		setIdComanda(idComanda);
		setIdFuncionario(idFuncionario);
		setData(data);

	}
	public Caixa( Double saida,Integer idFuncionario, Date data) {
	
		setSaida(saida);
		setIdFuncionario(idFuncionario);
		setData(data);

	}
	public Caixa(Double entrada,Double saida, Integer idComanda, Integer idFuncionario) {
		setEntrada(entrada);
		setSaida(saida);
		setIdComanda(idComanda);
		setIdFuncionario(idFuncionario);


	}

	public Double getEntrada() {
		return entrada;
	}

	public void setEntrada(double entrada) {
		this.entrada = entrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Double getTotalCaixa() {
		return totalCaixa;
	}

	public void setTotalCaixa(Double totalPago) {
		this.totalCaixa = totalPago;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Caixa [entrada=" + entrada + ", saida=" + saida + ", idComanda=" + idComanda
				+ ", totalCaixa=" + totalCaixa + ", idFuncionario=" + idFuncionario + ", data=" + data + "]";
	}

}
