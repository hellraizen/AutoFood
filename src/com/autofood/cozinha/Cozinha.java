package com.autofood.cozinha;

import com.autofood.comanda.Comanda;
import com.autofood.produto.Produto;

public class Cozinha 
{
	private Comanda idComanda;
	private Produto produto;
	private String data;
	
	public Cozinha(Comanda idComanda, Produto produto, String data) {
		super();
		this.idComanda = idComanda;
		this.produto = produto;
		this.data = data;
	}

	public Comanda getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(Comanda idComanda) {
		this.idComanda = idComanda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cozinha [idComanda=" + idComanda + ", produto=" + produto + ", data=" + data + "]";
	}
	
	
	
		
}
