package com.algaworks.pedidovenda.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.pedidovenda.repository.PedidosImpl;
import com.algaworks.pedidovenda.repository.vo.ValorTotalVendaDoDia;



@ViewScoped
@Named
public class ValorVendasPorDiaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<ValorTotalVendaDoDia> vendas;
	
	@Inject
	private PedidosImpl pedidos;
	
	public void buscarValorTotalVendaDoDia() {
		this.vendas = pedidos.valoresTotaisDasVendasPorDia();
	}

	public List<ValorTotalVendaDoDia> getVendas() {
		return vendas;
	}
	
}
