package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.dao.PedidoDAOImpl;
import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;

@ViewScoped
@Named
public class ValorVendasPorDiaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ValorTotalVendaDoDia> vendas;
	
	@Inject
	private PedidoDAOImpl pedidoDAO;
	
	public void buscarValorTotalVendaDoDia() {
		this.vendas = pedidoDAO.buscarValorTotalVendaDoDia();
	}

	public List<ValorTotalVendaDoDia> getVendas() {
		return vendas;
	}
	
}
