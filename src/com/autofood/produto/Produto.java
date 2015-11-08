package com.autofood.produto;



public class Produto {

	private Integer idProduto;
	private String nomeProduto;
	private Integer quantidadeProduto;
	private Double precoProduto;
	private String validadeProduto;
	private String dataFabricacaoProduto;

	public Produto(Integer idProduto, String produto,
			Integer quantidadeProduto, Double precoProduto,
			String validadeProduto, String dataFabricacaoProduto) {

		setIdProduto(idProduto);
		setNomeProduto(produto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(String nomeProduto, Integer quantidadeProduto,
			Double precoProduto, String validadeProduto,
			String dataFabricacaoProduto) {

		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(Integer idProduto, String nomeProduto,
			Integer quantidadeProduto, Double precoProduto) {

		setIdProduto(idProduto);
		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);

	}

	public Produto(String nomeProduto, Integer quantidadeProduto,
			Double precoProduto) {

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

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getValidadeProduto() {
		return validadeProduto;
	}

	public void setValidadeProduto(String validadeProduto) {
		this.validadeProduto = validadeProduto;
	}

	public String getDataFabricacaoProduto() {
		return dataFabricacaoProduto;
	}

	public void setDataFabricacaoProduto(String dataFabricacaoProduto) {
		this.dataFabricacaoProduto = dataFabricacaoProduto;
	}

	public String toString() {

		return "ID " + idProduto + " Produto " + nomeProduto + " Quantidade "
				+ quantidadeProduto + " Preço " + precoProduto + " Validade "
				+ validadeProduto + " Data Fabricação " + dataFabricacaoProduto;

	}

}
