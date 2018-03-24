package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.info.AluguelCarroInfo;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		//FORMA TRADICIONAL
		
		StringBuilder sb = new StringBuilder(0);
		sb.append(" SELECT ");
		sb.append(" c, "); 
		sb.append(" COUNT(a), "); 
		sb.append(" MAX(a.valorTotal), "); //consultas agregadas
		sb.append(" AVG(a.valorTotal), "); //consultas agregadas
		sb.append(" MIN(a.valorTotal), "); //consultas agregadas
		sb.append(" SUM(a.valorTotal) "); //consultas agregadas
		sb.append(" FROM Carro c "); 
		sb.append(" JOIN c.alugueis a "); //JOIN
		sb.append(" GROUP BY c "); //agrupamento necessario para as consultas agregadas
		sb.append(" HAVING "); //filtro
		sb.append(" COUNT(a) > 0 ");//filtro 
		
		
		
		List<Object[]> resultado = em.createQuery(sb.toString()).getResultList();
		
		for (Object[] res : resultado) {
			System.out.println();
			System.out.println("MODELO DO CARRO: " + ((Carro)res[0]).getModelo().getDescricao());
			System.out.println("QUANTIDADE DE ALUGUEIS: "+ res[1]);
			System.out.println("VALOR MAXIMO: "+res[2]);
			System.out.println("VALOR MEDIO:" + res[3]);
			System.out.println("VALOR MINIMO:" + res[4]);
			System.out.println("SOMA: " + res[5]);
			
		}
		
		//FIM FORMA TRADICIONAL
		System.err.println("-----------------------------------------------------------------------------------------------");
		//FORMA COM OBJETO
		StringBuilder sb1 = new StringBuilder(0);
		sb1.append(" SELECT ");
		sb1.append(" NEW com.algaworks.curso.jpa2.info.AluguelCarroInfo( ");
		sb1.append(" 	c, "); 
		sb1.append(" 	COUNT(a), "); 
		sb1.append(" 	MAX(a.valorTotal), "); //consultas agregadas
		sb1.append(" 	AVG(a.valorTotal), "); //consultas agregadas
		sb1.append(" 	MIN(a.valorTotal), "); //consultas agregadas
		sb1.append(" 	SUM(a.valorTotal) "); //consultas agregadas
		sb1.append(" ) ");
		sb1.append(" FROM Carro c "); 
		sb1.append(" JOIN c.alugueis a "); //JOIN
		sb1.append(" GROUP BY c "); //agrupamento necessario para as consultas agregadas
		sb1.append(" HAVING "); //filtro
		sb1.append(" COUNT(a) > 0 ");//filtro 
		
		
		List<AluguelCarroInfo> resultado1 = em.createQuery(sb1.toString(), AluguelCarroInfo.class).getResultList();
		
		for (AluguelCarroInfo res : resultado1) {
			System.out.println();
			System.out.println("MODELO DO CARRO: " + (res.getCarro().getModelo().getDescricao()));
			System.out.println("QUANTIDADE DE ALUGUEIS: "+ res.getQtdAlugueis());
			System.out.println("VALOR MAXIMO: "+res.getValorMaximo());
			System.out.println("VALOR MEDIO:" + res.getValorMedio());
			System.out.println("VALOR MINIMO:" + res.getValorMinimo());
			System.out.println("SOMA: " + res.getSoma());
			
		}
		//FIM FORMA COM OBJETO
		em.close();
		
	}

}
