package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import com.algaworks.curso.jpa2.modelo.Cidade;
import com.algaworks.curso.jpa2.modelo.Estado;


public interface CidadesInterface extends Serializable {

	public Cidade guardar(Cidade cidade);

	public List<Cidade> todas();

	public Cidade peloCodigo(Long codigo);

	public List<Cidade> buscarCidadesPorEstado(Estado estado);
	
}