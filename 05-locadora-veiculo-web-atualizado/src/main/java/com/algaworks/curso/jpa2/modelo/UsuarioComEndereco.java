package com.algaworks.curso.jpa2.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;

/**
 * esta entidade serve somente para demonstraçao de como fazer um
 * carregamento de uma entidade onde existe outra entidade 
 * anotada com @OneToOne, de forma a nao trazer a outra entidade.
 * 
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "tb_usuario_com_endereco")
public class UsuarioComEndereco implements Serializable, FieldHandled {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;
	
	private FieldHandler handler; //campo utilizado para 'enganar' o hibernate para que ele nao traga a entidade endereco, somente quando necessario
	
	@OneToOne(mappedBy = "usuario", fetch=FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)//informa ao hibernate para nao tentar colocar um objeto proxy nesta entidade (o que levaria ao hibernate realizar a consulta, mesmo que nao existam entidades relacionadas)
	private Endereco endereco;
	
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

	public Endereco getEndereco() {
		if (this.handler != null) { //truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
			return (Endereco) this.handler.readObject(this, "endereco", endereco);
		}
		
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (this.handler != null) {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
			this.endereco = (Endereco) this.handler.writeObject(this, "endereco"
					, this.endereco, endereco);
		}
		
		this.endereco = endereco;
	}
	
	@Override
	public void setFieldHandler(FieldHandler handler) {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
		this.handler = handler;
	}

	@Override
	public FieldHandler getFieldHandler() {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
		return this.handler;
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
		UsuarioComEndereco other = (UsuarioComEndereco) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
