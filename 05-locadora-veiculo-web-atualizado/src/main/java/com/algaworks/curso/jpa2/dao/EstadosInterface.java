package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import com.algaworks.curso.jpa2.modelo.Estado;


public interface EstadosInterface extends Serializable {

	public Estado guardar(Estado estado);
	public List<Estado> todos();
	public Estado peloCodigo(Long codigo);
	
}