package com.algaworks.curso.jpa2.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

public class ExemploProcedures {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
		EntityManager manager = factory.createEntityManager();
		
		StoredProcedureQuery storedProcedure = manager.createStoredProcedureQuery("analisarPedido"); //nome da procedure criada
		storedProcedure.registerStoredProcedureParameter("codigoPedido", Long.class, ParameterMode.IN); // informaçao dos parametros de entrada
		storedProcedure.setParameter("codigoPedido", 1L); //PASSAGEM DOS PARAMETROS DE ENTRADA
		storedProcedure.registerStoredProcedureParameter("analise", String.class, ParameterMode.OUT);// informcao dos paramentros de saida
		
		storedProcedure.execute(); //EXECUCAO
		
		String analise = (String) storedProcedure.getOutputParameterValue("analise"); //RECUPEROU O PARAMETRO DE RETORNO
		System.out.println("A análise foi: " + analise); 
		
		
		/*
		 * retorno da procedure:
		 * Hibernate: 
    {call analisarPedido(?,?)}
A análise foi: DEVOLUCAO
		 */
	}
	
	
	/*
	 * este codigo nao funcionou neste projeto, embora esteja correto.
	 * foi testado no projeto original e funcionou.
	 * 
	 * acredito que tem a ver com a forma como ele cria o entity manager.
	 * 
	 * 
	 */
}
