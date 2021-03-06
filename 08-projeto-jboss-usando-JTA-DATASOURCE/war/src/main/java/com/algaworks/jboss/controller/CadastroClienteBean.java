package com.algaworks.jboss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.algaworks.jboss.ejb.CadastroClienteEJB;
import com.algaworks.jboss.modelo.Cliente;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes;
	
	@EJB
	private CadastroClienteEJB cadastroClienteEJB;
	//injecao utilizando o EJB
	
	@PostConstruct
	public void inicializar() {
		this.cliente = new Cliente();
		this.clientes = cadastroClienteEJB.buscarTodos();
	}
	
	public void salvar() {
		cadastroClienteEJB.salvar(cliente);
		inicializar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	
}
