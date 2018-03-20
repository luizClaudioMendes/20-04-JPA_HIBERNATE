package com.algaworks.curso.jpa2.consultas;

import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		
		
		/*buscar os modelos dos carros, de um determinado fabricante que esteja dentro de algumas categorias específicas.*/
		List<String> modelos = em.createQuery("SELECT mc.descricao FROM ModeloCarro mc WHERE mc.fabricante.nome = 'Chevrolet' AND mc.categoria IN ('SEDAN_MEDIO','SEDAN_GRANDE')", String.class).getResultList();
		
		for (String modelo : modelos) {
			System.out.println(modelo);
		}
		
		em.close();
		
	}

}
