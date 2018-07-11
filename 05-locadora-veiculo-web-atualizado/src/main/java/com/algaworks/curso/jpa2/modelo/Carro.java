package com.algaworks.curso.jpa2.modelo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//select c from Carro c inner join fetch c.modelo order by c.codigo
@Entity
@NamedQueries({//named queries
		@NamedQuery(name = "Carro.buscarTodos", query = "select c from Carro c inner join fetch c.modelo"),
		@NamedQuery(name = "Carro.buscarCarroComAcessorios", query = "select c from Carro c left JOIN fetch c.acessorios a "
				+ " where c.codigo = :codigo") })
public class Carro {

	private Long codigo;
	private String placa;
	private String cor;
	private String chassi;
	private BigDecimal valorDiaria;
	private ModeloCarro modelo;
	private List<Acessorio> acessorios;
	private List<Aluguel> alugueis;
	private Date dataCriacao;
	private Date dataModificacao;

	private byte[] foto;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

//	@JoinColumn(name = "codigo_modelo")
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // o cascade = CascadeType.PERSIST permite salvar o carro e juntamente salvar secundariamente um novo modelo de carro
	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	/*
	 * para exclusoes em relacionamentos many to many nao é necessario nenhuma anotaçao.
	 * desta forma, ira apenas excluir o carro e o relacionamento entre carro e acessorio, nao apagando o acessorio, que pode estar sendo utilizado por outro carro.
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "carro_acessorio", joinColumns = @JoinColumn(name = "codigo_carro"), inverseJoinColumns = @JoinColumn(name = "codigo_acessorio"))//name = nome da tabela, joinColumns mapeia o nome das primary keys de Carro e inverseJoinColumns de acessorios
	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	/*
	 * => o mappedBy referencia o atributo java da outra classe que mapeou o carro
	 * 
	 * DELETE EM CASCADE
	 * ao usar a anotacao 
	 * @OneToMany(mappedBy = "carro", cascade = CascadeType.REMOVE)
	 * quando removermos o carro, ira tambem remover todos os alugueis daquele carro.
	 * 
	 * como não é um comportamento que queremos nesta parte do codigo, na anotacao utilizada
	 * nao tera a parte do REMOVE.
	 * 
	 * DELETE DE ORFAOS
	 * 
	 * @OneToMany(mappedBy = "carro", cascade = CascadeType.PERSIST, orphanRemoval = true)
	 * quando por exemplo, editamos uma lista em um objeto, exemplo um carro, e editamos a lista de aluguéis, excluindo um aluguel, este aluguel que ficou excluído da lista ficou órfão.
		neste caso, precisamos adicionar uma outra anotação:
		@OneToMany(mappedBy = "carro", cascade = CascadeType.PERSIST, orphanRemoval = true)

		então a sequencia é a seguinte:
		buscamos um carro no banco e editamos a lista de aluguéis (removendo o primeiro por exemplo).
		logo a seguir, persistimos o carro.
		com essa ação queremos que o carro seja salvo com os alugueis restantes (sem o que foi removido).
		para que isso aconteça a anotação orphanRemoval = true tem que estar presente.

	 */
	@OneToMany(mappedBy = "carro")
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@PrePersist//interceptacao da alteraçao do ciclo de vida do JPA
	@PreUpdate//interceptacao da alteraçao do ciclo de vida do JPA
	public void configuraDatasCriacaoAlteracao() {
		this.dataModificacao = new Date();

		if (this.dataCriacao == null) {
			this.dataCriacao = new Date();
		}
	}

	@Lob //anotaçao importante para upload da foto
	@Column(name="foto_carro")
	public byte[] getFoto() {
		return this.foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public boolean hasFoto() {
		return this.foto != null && this.foto.length > 0;
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
		Carro other = (Carro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
