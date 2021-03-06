package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	/*
	 * é costume abrir a transacao no service, pois assim é possivel 
	 * aproveitar a mesma transacao.
	 * 
	 * esta anotação (@Transactional) é criada no projeto e controla a transacao.
	 */
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (StringUtils.isEmpty(fabricante.getNome())) { 
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
	
}
