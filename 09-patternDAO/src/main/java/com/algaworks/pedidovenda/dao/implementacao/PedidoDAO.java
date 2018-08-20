package com.algaworks.pedidovenda.dao.implementacao;

import java.util.List;

import com.algaworks.pedidovenda.dao.GenericDAO;
import com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia;
import com.algaworks.pedidovenda.model.Pedido;

public interface PedidoDAO  extends GenericDAO<Pedido, Long>{

	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia();
	
}
