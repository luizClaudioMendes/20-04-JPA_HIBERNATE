package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public void salvar(Aluguel aluguel) {
		manager.merge(aluguel);
	}

	public List<Aluguel> buscarPorDataDeEntregaEModeloCarro(Date dataEntrega, ModeloCarro modelo) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
		Root<Aluguel> a = criteriaQuery.from(Aluguel.class); //equivalente ao select a from aluguel
		criteriaQuery.select(a);// implementa o select
		
		List<Predicate> predicates = new ArrayList<>(0); //lista de filtros
		
		if (dataEntrega != null) { //se tivermos selecionado alguma data
			/*
			 * ParameterExpression sao parametros do filtro.
			 * ao escrevermos : builder.parameter(Date.class, "dataEntregaInicial") 
			 * a 'dataEntregaInicial' é equivalente ao :dataEntregaInicial do JPQL
			 */
			ParameterExpression<Date> dataEntregaInicial = builder.parameter(Date.class, "dataEntregaInicial");
			ParameterExpression<Date> dataEntregaFinal = builder.parameter(Date.class, "dataEntregaFinal");
			
			/*
			 * o between tem como parametros:
			 * a.<Date>get("dataEntrega") -- busca na variavel a o atributo 'dataEntrega', que é um Date
			 *  dataEntregaInicial, dataEntregaFinal -- seta como valor inicial e final no between (que tem dois parametros)
			 */
			predicates.add(builder.between(a.<Date>get("dataEntrega"), dataEntregaInicial, dataEntregaFinal));
		}
		
		if (modelo != null) {
			ParameterExpression<ModeloCarro> modeloExpression = builder.parameter(ModeloCarro.class, "modelo");
			predicates.add(builder.equal(a.get("carro").get("modelo"), modeloExpression));
		}
		
		criteriaQuery.where(predicates.toArray(new Predicate[0])); // adiciona os filtros na query
		
		TypedQuery<Aluguel> query = manager.createQuery(criteriaQuery); // cria a query
		
		if (dataEntrega != null) {
			Calendar dataEntregaInicial = Calendar.getInstance();
			dataEntregaInicial.setTime(dataEntrega);
			dataEntregaInicial.set(Calendar.HOUR_OF_DAY, 0);
			dataEntregaInicial.set(Calendar.MINUTE, 0);
			dataEntregaInicial.set(Calendar.SECOND, 0);
			
			Calendar dataEntregaFinal = Calendar.getInstance();
			dataEntregaFinal.setTime(dataEntrega);
			dataEntregaFinal.set(Calendar.HOUR_OF_DAY, 23);
			dataEntregaFinal.set(Calendar.MINUTE, 59);
			dataEntregaFinal.set(Calendar.SECOND, 59);
			
			/*
			 * insere os parametros na query
			 * equivalente ao :dataEntregaInicial por exemplo
			 */
			query.setParameter("dataEntregaInicial", dataEntregaInicial.getTime());
			query.setParameter("dataEntregaFinal", dataEntregaFinal.getTime());
		}
		
		if (modelo != null) {
			query.setParameter("modelo", modelo);
		}
		
		return query.getResultList();
	}
	
	
	/**
	 * metodo para exemplificar a crição da criteria do hibernate.
	 * 
	 * @param dataEntrega
	 * @param modelo
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<Aluguel> buscarPorDataDeEntregaEModeloCarroCriteria(Date dataEntrega, ModeloCarro modelo) {
		
		/**
		 * para começar, a criteria do hibernate criada pela session do hibernate.
		 */
		Session session = this.manager.unwrap(Session.class); // o entity manager contem a session do hibernate. utilizando o unwrap, agente consegue obter a session do hibernate.
		Criteria criteria = session.createCriteria(Aluguel.class); // criamos a criteria do hibernate
		
		if (dataEntrega != null) {
			criteria.add(Restrictions.between("dataEntrega", geraDataInicial(dataEntrega), geraDataFinal(dataEntrega))); // restrictions sao as clausulas where no select
//			criteria.add(Restrictions.between(NOME_CAMPO_JAVA, PRIMEIRA_DATA, SEGUNDA_DATA));
		}
		
		if (modelo != null) {
			criteria.createAlias("carro", "c"); // como estamos em aluguel, e aluguel tem carro e carro é quem tem modelo, temos que criar um alias para carro, para podermos acessar o modelo
			criteria.add(Restrictions.eq("c.modelo", modelo)); //acessando modelo a partir do alias
		}
		
		return criteria.list(); // se somente utilizarmos esta linha é equivalente a select * from
	}
	
	private Date geraDataInicial(Date dataEntrega) {
		Calendar dataEntregaInicial = Calendar.getInstance();
		dataEntregaInicial.setTime(dataEntrega);
		dataEntregaInicial.set(Calendar.HOUR_OF_DAY, 0);
		dataEntregaInicial.set(Calendar.MINUTE, 0);
		dataEntregaInicial.set(Calendar.SECOND, 0);
		
		return dataEntregaInicial.getTime();
	}
	
	private Date geraDataFinal(Date dataEntrega) {
		Calendar dataEntregaFinal = Calendar.getInstance();
		dataEntregaFinal.setTime(dataEntrega);
		dataEntregaFinal.set(Calendar.HOUR_OF_DAY, 23);
		dataEntregaFinal.set(Calendar.MINUTE, 59);
		dataEntregaFinal.set(Calendar.SECOND, 59);
		
		return dataEntregaFinal.getTime();
	}

	public BigDecimal calcularTotalDoMesDe(int mes) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluguel.class); //cria uma criteria normal
		
		/*projections sao utilizadas quando nao queremos a etidade
		 * toda, somente um pedaço dela (colunas) ou o retorno de uma função
		 * do SQL, como é o caso desta.
		 */
		criteria.setProjection(Projections.sum("valorTotal")); //queremos que retorne somente uma coluna com o resultado da soma
		//restrição utilizando SQL nativo, passando uma function que encontra todas as datas com o mes passado
//		criteria.add(Restrictions.sqlRestriction("SQL_function = ?", nome do parametro para utilizar, tipo_do_parametro));
		criteria.add(Restrictions.sqlRestriction("month(dataPedido) = ?", mes, StandardBasicTypes.INTEGER));
		
		return (BigDecimal) criteria.uniqueResult();
	}

}



