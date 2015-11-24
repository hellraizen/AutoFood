package com.autofood.cozinha;

import com.autofood.comanda.Comanda;

public class Cozinha 
{
	private Comanda comanda;
	private Integer index;
	private String data;
	
	public Cozinha(Comanda comanda, Integer index, String data) {
		
		setComanda(comanda);
		setIndex(index);
		setData(data);
	}

	public Comanda getComanda() {
		return comanda;
	}

	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Cozinha [comanda=" + comanda + ", index=" + index + ", data=" + data + "]";
	}


	
	
	
		
}
