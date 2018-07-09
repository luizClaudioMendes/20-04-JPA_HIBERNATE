package com.algaworks.curso.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="tb_proprietario_celular")
public class ProprietarioCelular {
	
	private Long id;
	private String nome;
	private List<Celular> celulares = new ArrayList<>(0);

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nome_proprietario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ElementCollection //anotaçao de mapeamento informando que este atributo sera armazenado em tabela separada
	@CollectionTable(name="proprietario_celulares", //nome da tabela onde armazena o vinculo do proprietario com telefone
			joinColumns=@JoinColumn(name="cod_proprietario_celular"))//nome da coluna na tabela nova que guardara o id do proprietario
	@AttributeOverrides(value = { @AttributeOverride(name="numero", column=@Column(name="nr_telefone"))})
	public List<Celular> getCelulares() {
		return celulares;
	}
	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}
	
	
	
	
	
	
}
