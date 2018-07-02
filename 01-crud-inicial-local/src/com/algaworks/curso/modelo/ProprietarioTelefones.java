package com.algaworks.curso.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class ProprietarioTelefones {
	
	private Long id;
	private String nome;
	private List<String> telefones = new ArrayList<>(0);

	
	@Column(name="nome_proprietario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ElementCollection //anotaçao de mapeamento informando que este atributo sera armazenado em tabela separada
	@CollectionTable(name="proprietario_telefones", //nome da tabela onde armazena o vinculo do proprietario com telefone
			joinColumns=@JoinColumn(name="cod_proprietario"))//nome da coluna na tabela nova que guardara o id do proprietario
	@Column(name="numero_telefone")//nome da coluna na tabela nova que armazenara o numero do telefone
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
