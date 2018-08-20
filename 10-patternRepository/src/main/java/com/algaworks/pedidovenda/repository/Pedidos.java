package com.algaworks.pedidovenda.repository;

import java.util.List;

import com.algaworks.pedidovenda.model.ItemPedido;
import com.algaworks.pedidovenda.model.Pedido;
import com.algaworks.pedidovenda.repository.filtro.PedidoFiltro;
import com.algaworks.pedidovenda.repository.vo.ValorTotalVendaDoDia;



public interface Pedidos {

	public List<ValorTotalVendaDoDia> valoresTotaisDasVendasPorDia();
	
	public List<ItemPedido> itensPendentes();

	public Pedido peloCodigo(long codigo);
//	
	public void adicionar(Pedido entidade);
//
	public List<Pedido> filtrar(PedidoFiltro filtro);
	
}
