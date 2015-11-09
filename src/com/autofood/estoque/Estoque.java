package com.autofood.estoque;

public class Estoque {

	private Integer idEstoqueProduto;
	private String nomeProdutoEstoque;
	private Integer quantidadeProdutoEstoque;
	private String dataEntradaProdutoEstoque;
	private String dataValidadeProdutoEstoque;
	private Double precoCustoProdutoEstoque;

	public Estoque(Integer idEstoqueProduto, String nomeProdutoEstoque,
			Integer quantidadeProdutoEstoque, String dataEntradaProdutoEstoque,
			String dataValidadeProdutoEstoque, Double precoCustoProdutoEstoque) {

		setIdEstoqueProduto(idEstoqueProduto);
		setNomeProdutoEstoque(nomeProdutoEstoque);
		setQuantidadeProdutoEstoque(quantidadeProdutoEstoque);
		setDataEntradaProdutoEstoque(dataEntradaProdutoEstoque);
		setDataValidadeProdutoEstoque(dataValidadeProdutoEstoque);
		setPrecoCustoProdutoEstoque(precoCustoProdutoEstoque);

	}

	public Estoque(String nomeProdutoEstoque, Integer quantidadeProdutoEstoque,
			String dataEntradaProdutoEstoque,
			String dataValidadeProdutoEstoque, Double precoCustoProdutoEstoque) {

		setNomeProdutoEstoque(nomeProdutoEstoque);
		setQuantidadeProdutoEstoque(quantidadeProdutoEstoque);
		setDataEntradaProdutoEstoque(dataEntradaProdutoEstoque);
		setDataValidadeProdutoEstoque(dataValidadeProdutoEstoque);
		setPrecoCustoProdutoEstoque(precoCustoProdutoEstoque);
	}

	public Integer getIdEstoqueProduto() {
		return idEstoqueProduto;
	}

	public void setIdEstoqueProduto(Integer idEstoqueProduto) {
		this.idEstoqueProduto = idEstoqueProduto;
	}

	public String getNomeProdutoEstoque() {
		return nomeProdutoEstoque;
	}

	public void setNomeProdutoEstoque(String nomeProdutoEstoque) {
		this.nomeProdutoEstoque = nomeProdutoEstoque;
	}

	public Integer getQuantidadeProdutoEstoque() {
		return quantidadeProdutoEstoque;
	}

	public void setQuantidadeProdutoEstoque(Integer quantidadeProdutoEstoque) {
		this.quantidadeProdutoEstoque = quantidadeProdutoEstoque;
	}

	public String getDataEntradaProdutoEstoque() {
		return dataEntradaProdutoEstoque;
	}

	public void setDataEntradaProdutoEstoque(String dataEntradaProdutoEstoque) {
		this.dataEntradaProdutoEstoque = dataEntradaProdutoEstoque;
	}

	public String getDataValidadeProdutoEstoque() {
		return dataValidadeProdutoEstoque;
	}

	public void setDataValidadeProdutoEstoque(String dataValidadeProdutoEstoque) {
		this.dataValidadeProdutoEstoque = dataValidadeProdutoEstoque;
	}

	public Double getPrecoCustoProdutoEstoque() {
		return precoCustoProdutoEstoque;
	}

	public void setPrecoCustoProdutoEstoque(Double precoCustoProdutoEstoque) {
		this.precoCustoProdutoEstoque = precoCustoProdutoEstoque;
	}

	public String toString() {
		return "Estoque ID =" + idEstoqueProduto + ", Produto ="
				+ nomeProdutoEstoque + ", quantidade ="
				+ quantidadeProdutoEstoque + ", Data Entrada ="
				+ dataEntradaProdutoEstoque + ", Validade ="
				+ dataValidadeProdutoEstoque + ", Pre�o ="
				+ precoCustoProdutoEstoque;
	}

}
