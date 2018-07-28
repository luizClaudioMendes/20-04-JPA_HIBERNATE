package com.algaworks.curso.jpa2.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.algaworks.curso.jpa2.relatorio.AlertasPorUsuario;
import com.algaworks.curso.jpa2.util.JPAConverters.LocalDateConverter;

@NamedNativeQuery(name="alertasPorUsuario",
	query="select u.nome as nome, " + 
			" count(a.codigo) as totalAlertas " + 
			" from tb_usuario u, tb_acesso a " + 
			" where u.codigo = a.usuario " + 
			" group by u.nome",
			resultSetMapping="alertasPorUsuarioMapping"
		)
@SqlResultSetMapping(name="alertasPorUsuarioMapping", 
		classes= {
				@ConstructorResult(
						targetClass=AlertasPorUsuario.class, 
						columns= {
							@ColumnResult(name="nome"),
							@ColumnResult(name="totalAlertas")
						}
				)
		}
	)
@Entity
@Table(name="tb_usuario", schema="locadora")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	/*
	 * o que o converter faz? ele ira converter uma classe que nao existe no hibernate, como o LocalDate para uma classe que existe.
	 * nisso ele facilita a utilizacao de classes no sistema.
	 */
	@Convert(converter=LocalDateConverter.class)//necessario pois o hibernante ainda nao implementa o LocalDate, mas pode ser utilizado para qualquer classe, mesmo as personalizadas
	@Column(name="dt_nasc")
	private LocalDate dataNascimento;
	
	
	
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
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	
	
	
	
	

}
