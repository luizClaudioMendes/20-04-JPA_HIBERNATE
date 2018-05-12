package com.algaworks.curso.modelo;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Veiculo {
	
	private VeiculoId codigo;
	private String fabricante;
	private String modelo;
	private Proprietario prop;
	
	@EmbeddedId //esta anotacao significa que este campo é um id da classe mas composto e embutido
	public VeiculoId getCodigo() {
		return codigo;
	}

	public void setCodigo(VeiculoId codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/*
	 * existem ocasioes onde queremos colocar um objeto embutido em uma classe.
	 * podemos querer manter os dados em uma unica tabela para evitar joins desnecessarios
	 * mas queremos manter as entidades OO separadas ou nao podemos mexer no banco mas 
	 * em OO nao faz sentido manter os dados do proprietario na mesma classe.
	 * 
	 * para isso, podemos utilizar a anotaçao @Embedded em uma classe dentro de outra.
	 * 
	 * na classe embutida, podemos mapear as colunas da mesma forma que fariamos normalmente.
	 * 
	 * a unica diferenca é a anotaçao na classe embutida, que nao é @Entity
	 * e a anotacao na classe que receberá as colunas.
	 * 
	 * assim, ao persistir, as colunas embutidas serao cridas na tabela da entidade que a chamou.
	 */
	@Embedded
	public Proprietario getProp() {
		return prop;
	}

	public void setProp(Proprietario prop) {
		this.prop = prop;
	}
	

}
