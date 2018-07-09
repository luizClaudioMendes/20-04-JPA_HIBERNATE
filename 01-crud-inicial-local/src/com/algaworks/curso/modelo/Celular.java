package com.algaworks.curso.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Celular {
	
	private String prefixo;
	private String numero;
	
	public Celular(String prefixo, String numero) {
		super();
		this.prefixo = prefixo;
		this.numero = numero;
	}

	public Celular() {
		super();
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}
