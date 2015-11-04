package com.autofood.produto;

import java.util.Date;

public class Produto {

	private Integer idProduto;
	private String nomeProduto;
	private Integer quantidadeProduto;
	private double precoProduto;
	private String validadeProduto;
	private Date dataFabricacaoProduto;

	public Produto(Integer idProduto, String nomeProduto,
			Integer quantidadeProduto, double precoProduto,
			String validadeProduto, Date dataFabricacaoProduto) {

		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(String nomeProduto, Integer quantidadeProduto,
			double precoProduto, String validadeProduto,
			Date dataFabricacaoProduto) {

		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(Integer idProduto, String nomeProduto,
			Integer quantidadeProduto, double precoProduto) {

		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);

	}

	public Produto(String nomeProduto, Integer quantidadeProduto,
			double precoProduto) {

		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);

	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getValidadeProduto() {
		return validadeProduto;
	}

	public void setValidadeProduto(String validadeProduto) {
		this.validadeProduto = validadeProduto;
	}

	public Date getDataFabricacaoProduto() {
		return dataFabricacaoProduto;
	}

	public void setDataFabricacaoProduto(Date dataFabricacaoProduto) {
		this.dataFabricacaoProduto = dataFabricacaoProduto;
	}

	public String toString() {

		return "ID " + idProduto + " Produto " + nomeProduto + " Quantidade "
				+ quantidadeProduto + " Preço " + precoProduto + " Validade "
				+ validadeProduto + " Data Fabricação " + dataFabricacaoProduto;

	}

}
