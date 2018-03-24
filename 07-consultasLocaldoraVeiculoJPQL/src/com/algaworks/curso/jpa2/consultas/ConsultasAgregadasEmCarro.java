package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultasAgregadasEmCarro {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
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
		
		em.close();
		
	}

}
