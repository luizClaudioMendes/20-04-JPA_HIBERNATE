package com.algaworks.curso.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable //informa que esta classe pode ser embutida em outra classe.
public class VeiculoId implements Serializable {
	

	private static final long serialVersionUID = -8456248261923843163L;
	
	/*
	 * o campo placa e o campo cidade servirao de id para a classe veiculo.
	 * este é um exemplo de um id composto, neste caso, por duas strings:
	 * placa e cidade.
	 */
	private String placa;
	private String cidade;
	
	public VeiculoId () { }//necessário para os frameworks
		
	public VeiculoId(String placa, String cidade) {
		super();
		this.placa = placa;
		this.cidade = cidade;
	}



	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoId other = (VeiculoId) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
	
}
