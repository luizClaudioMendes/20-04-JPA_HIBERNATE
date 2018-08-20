package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.dao.ItemPedidoDAOImpl;
import com.algaworks.pedidovenda.model.ItemPedido;

@ViewScoped
@Named
public class EntregasPendentesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ItemPedido> itensPendentes;

	@Inject
	private ItemPedidoDAOImpl itemPedidoDAO;

	public void buscarItensPendentes() {
		this.itensPendentes = itemPedidoDAO.buscarItensPendentes();
	}

	public List<ItemPedido> getItensPendentes() {
		return itensPendentes;
	}

}
