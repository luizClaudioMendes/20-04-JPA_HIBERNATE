package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import com.algaworks.curso.jpa2.modelo.NFe;

public interface NFeInterface extends Serializable {

	public NFe guardar(NFe nfe);
	
}