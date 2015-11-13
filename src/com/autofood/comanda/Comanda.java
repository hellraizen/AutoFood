package com.autofood.comanda;

import java.util.Date;

public class Comanda {

	private Integer idComanda;
	private String nomeCliente;
	private Integer numeroVenda;
	private Integer idProduto;
	private String produto;
	private Double valor;
	private Integer quantidade;
	private Double total;
	private Date data;

	public Comanda(String nomeCliente, Integer idProduto, String produto, Double valor, Integer quantidade,
			Double total) {

		setNomeCliente(nomeCliente);
		setIdProduto(idProduto);
		setProduto(produto);
		setValor(valor);
		setQuantidade(quantidade);
		setTotal(total);

	}

	public Comanda(Integer idProduto, String produto, Double valor, Integer quantidade, Double total) {

		setIdProduto(idProduto);
		setProduto(produto);
		setValor(valor);
		setQuantidade(quantidade);
		setTotal(total);

	}

	public Comanda(Integer idComanda, String nomeCliente, Integer idProduto, String produto, Double valor,
			Integer quantidade, Double total, Date data) {

		setIdComanda(idComanda);
		setNomeCliente(nomeCliente);
		setIdProduto(idProduto);
		setProduto(produto);
		setValor(valor);
		setQuantidade(quantidade);
		setTotal(total);
		setData(data);

	}

	@Override
	public String toString() {
		return "Comanda [idComanda=" + idComanda + ", nomeCliente=" + nomeCliente + ", numeroVenda=" + numeroVenda
				+ ", idProduto=" + idProduto + ", produto=" + produto + ", valor=" + valor + ", quantidade="
				+ quantidade + ", total=" + total + ", data=" + data + "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Integer idComanda) {
		this.idComanda = idComanda;
	}

	public Integer getIdVenda() {
		return idProduto;
	}

	public void setIdVenda(Integer idVenda) {
		this.idProduto = idVenda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getNumeroVenda() {
		return numeroVenda;
	}

	public void setNumeroVenda(Integer numeroVenda) {
		this.numeroVenda = numeroVenda;
	}

}
