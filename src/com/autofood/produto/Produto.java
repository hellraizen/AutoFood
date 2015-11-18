package com.autofood.produto;


public class Produto {

	private Integer idProduto;
	private String codigoProduto;
	private String nomeProduto;
	private Integer quantidadeProduto;
	private Double precoProduto;
	private String validadeProduto;
	private String dataFabricacaoProduto;

	public Produto(Integer idProduto,String codigoProduto, String produto,
			Integer quantidadeProduto, Double precoProduto,
			String validadeProduto, String dataFabricacaoProduto) {

		setCodigoProduto(codigoProduto);
		setIdProduto(idProduto);
		setNomeProduto(produto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(String codigoProduto,String nomeProduto, Integer quantidadeProduto,
			Double precoProduto, String validadeProduto,
			String dataFabricacaoProduto) {

		setCodigoProduto(codigoProduto);
		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);
		setValidadeProduto(validadeProduto);
		setDataFabricacaoProduto(dataFabricacaoProduto);

	}

	public Produto(Integer idProduto,String codigoProduto,String nomeProduto,
			Integer quantidadeProduto, Double precoProduto) {

		setIdProduto(idProduto);
		setCodigoProduto(codigoProduto);
		setNomeProduto(nomeProduto);
		setQuantidadeProduto(quantidadeProduto);
		setPrecoProduto(precoProduto);

	}

	public Produto(String codigoProduto ,String nomeProduto, Integer quantidadeProduto,
			Double precoProduto) {

		setCodigoProduto(codigoProduto);
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

	public String getCodigoProduto(){
		
		return codigoProduto;
	}
	
	public void setCodigoProduto(String codigoProduto){
		
		this.codigoProduto = codigoProduto;
		
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

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", codigoProduto="
				+ codigoProduto + ", nomeProduto=" + nomeProduto
				+ ", quantidadeProduto=" + quantidadeProduto
				+ ", precoProduto=" + precoProduto + ", validadeProduto="
				+ validadeProduto + ", dataFabricacaoProduto="
				+ dataFabricacaoProduto + "]";
	}
}