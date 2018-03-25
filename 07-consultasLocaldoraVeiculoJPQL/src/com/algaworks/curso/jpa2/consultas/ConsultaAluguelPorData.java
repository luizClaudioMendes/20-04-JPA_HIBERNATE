package com.algaworks.curso.jpa2.consultas;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.JPAUtil;
import com.algaworks.curso.jpa2.util.Java8DateUtils;

public class ConsultaAluguelPorData {
	
	public static void main(String[] args) {
		EntityManager em = JPAUtil.createEntitymanager();
		
		StringBuilder sb = new StringBuilder(0);
		sb.append(" SELECT ");
		sb.append(" COUNT(a) ");
		sb.append(" FROM Aluguel a ");
		sb.append(" WHERE ");
		sb.append(" a.dataDevolucao BETWEEN :inicio AND :fim ");
		
		
		//TESTE COM DATE E CALENDAR
		Calendar inicioCalendar = Calendar.getInstance();
		inicioCalendar.set(2018, 0,  10, 7, 0); // 10 de Janeiro de 2018 7:00 horas
		Date inicio = inicioCalendar.getTime();
				
		Calendar fimCalendar = Calendar.getInstance();
		fimCalendar.set(2018, 2, 24, 18, 0); // 24 de Março de 2018 18:00 horas
		Date fim = fimCalendar.getTime();
//		OBS: A contagem dos meses inicia-se com zero, Janeiro é zero, Fevereiro um e assim por diante.
		Long resultado = em.createQuery(sb.toString(), Long.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getSingleResult();
		
		System.out.println("TESTE COM DATE E CALENDAR");
		System.out.println("ENCONTRADOS: " + resultado);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		//TESTE COM JAVA 8 DATE
		
		LocalDateTime inicio1 = LocalDateTime.of(2018, 1, 10, 7, 0);// 10 de Janeiro de 2018 7:00 horas
				
		LocalDateTime fim1 = LocalDateTime.of(2018, 3, 24, 18, 0);
		
		Long resultado1 = em.createQuery(sb.toString(), Long.class)
				.setParameter("inicio", Java8DateUtils.convertLocalDateTimeToDate(inicio1))
				.setParameter("fim", Java8DateUtils.convertLocalDateTimeToDate(fim1))
				.getSingleResult();
		
		System.out.println("TESTE COM NEW JAVA 8 DATE");
		System.out.println("ENCONTRADOS: " + resultado1);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		/*
		 *  mudando o campo de aluguel para "dataEntrega" que é do tipo Calendar e mapeada como TemporalType.DATE.
		 */
		
		StringBuilder sb1 = new StringBuilder(0);
		sb1.append(" SELECT ");
		sb1.append(" COUNT(a) ");
		sb1.append(" FROM Aluguel a ");
		sb1.append(" WHERE ");
		sb1.append(" a.dataEntrega BETWEEN :inicio AND :fim ");
		
		
		//TESTE COM DATE E CALENDAR
		Calendar inicioCalendar1 = Calendar.getInstance();
		inicioCalendar1.set(2018, 0,  10, 7, 0); // 10 de Janeiro de 2018 7:00 horas
				
		Calendar fimCalendar1 = Calendar.getInstance();
		fimCalendar1.set(2018, 2, 24, 18, 0); // 24 de Março de 2018 18:00 horas
//		OBS: A contagem dos meses inicia-se com zero, Janeiro é zero, Fevereiro um e assim por diante.
		
		Long resultado2 = em.createQuery(sb1.toString(), Long.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getSingleResult();
		
		System.out.println("TESTE COM CALENDAR");
		System.out.println("ENCONTRADOS: " + resultado2);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		//TESTE COM JAVA 8 DATE
		
		LocalDateTime inicio2 = LocalDateTime.of(2018, 1, 10, 7, 0);// 10 de Janeiro de 2018 7:00 horas
				
		LocalDateTime fim2 = LocalDateTime.of(2018, 3, 24, 18, 0);
		
		Long resultado3 = em.createQuery(sb.toString(), Long.class)
				.setParameter("inicio", Java8DateUtils.convertLocalDateTimeToDate(inicio2))
				.setParameter("fim", Java8DateUtils.convertLocalDateTimeToDate(fim2))
				.getSingleResult();
		
		System.out.println("TESTE COM NEW JAVA 8 DATE");
		System.out.println("ENCONTRADOS: " + resultado3);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		
		
		
		
		em.close();
		
	}

}
