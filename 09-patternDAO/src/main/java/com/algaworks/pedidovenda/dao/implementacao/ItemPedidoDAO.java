package com.algaworks.pedidovenda.dao.implementacao;

import java.util.List;

import com.algaworks.pedidovenda.dao.GenericDAO;
import com.algaworks.pedidovenda.model.ItemPedido;

public interface ItemPedidoDAO extends GenericDAO<ItemPedido, Long>{

	public List<ItemPedido> buscarItensPendentes();
	
}
