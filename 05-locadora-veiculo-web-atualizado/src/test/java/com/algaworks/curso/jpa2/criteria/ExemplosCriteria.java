package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Carro_;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro_;

public class ExemplosCriteria {
	/*
	 * este teste é uma introduçao ao Junit e uma amostra sobre projeçoes.
	 * 
	 * para configurar os testes em um sistema:
	 * 1- clique com o botao direito no projeto e selecione 'properties'
	 * 2- add library e selecione o junit 4
	 * 3- no pom, acrescente a dependencia do maven
	 * 		groupid - junit
	 * 		artifactid - junit
	 * 		versao 4.10
	 * 		scope - test
	 * 
	 * 4- agora a classe deve ser criada, no caso, esta classe.
	 * 5- nos teste, o @Inject nao funciona, entao precisamos criar tudo manualmente.
	 * EntityManagerFactory, estatico, que no metodo init() ira ser inicializado.
	 * no metodo init(), anotamos com @BeforeClass para que seja executado pelo junit 
	 * logo apos a criaçao da classe.
	 * 6- no metodo setUp(), inicializamos o EntityManager, mas queremos que a cada teste este
	 * metodo seja executado, entao anotamos com @Before
	 * 7- tambem queremos que o entitymanager seja fechado logo apos a execuçao do teste, logo
	 * anotamos o metodo tearDown() com @After.
	 * 8- o junit ira executar os metodos anotados com @Test. estes sao os testes.
	 * 
	 */

	private static EntityManagerFactory factory;
	
	private EntityManager manager;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("junitPU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void consultaModeloFiltrandoFabricante() {
		
		/*List<String> modelos = manager.createQuery("select mc.descricao "
				+ "from ModeloCarro mc where mc.fabricante.nome = 'Chevrolet 2'",
	    		 String.class).getResultList();
	    				
		for (String modelo : modelos) {
			System.out.println(modelo);	
		}*/
	}
	
	@Test
	public void projecoes() {
		/*
		 * este exemplo é para a demonstraçao das projections.
		 * projections nada mais é do que, em vez de buscar todo o objeto, a query ira 
		 * buscar somente o que desejamos, neste caso, a placa do carro.
		 */
		
		//INICIO DA CRIACAO DA CRITERIA
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
		
		/*
		 * COMO O ATRIBUTO QUE QUEREMOS ESTA EM CARRO,
		 * LOGO O FROM DA QUERY SERA NA CLASSE CARRO.
		 */
		Root<Carro> carro = criteriaQuery.from(Carro.class); 
		
		/*
		 * DEPOIS SELECIONAMOS O ATRIBUTO QUE DESEJAMOS, NO CASO A PLACA.
		 */
		criteriaQuery.select(carro.<String>get("placa"));
		
		/*
		 * EXECUCAO NORMAL DA QUERY
		 * ATENÇAO PARA O RETORNO, QUE NESTE CASO NAO SERA CARRO E SIM STRING,
		 * QUE É O TIPO DO ATRIBUTO QUE SELECIONAMOS.
		 */
		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> placas = query.getResultList();
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		for (String placa : placas) {
			System.out.println(placa);
		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	@Test
	public void funcoesDeAgregacao() {
		/*
		 * as funcoes de agregacao com criteria sao bem simples!
		 * 
		 * o que sao funcoes de agregacao? sao todas aquelas funcoes utilizadas pelos
		 * bd´s que retornam algum tipo de calculo, como soma, media, max, min, etc.
		 * 
		 * as funçoes de agregaçao sao criadas no builder.
		 * 
		 * neste exemplo queremos ver a soma de todos os alugueis cadastrados no bd.
		 * 
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
		
		/**
		 * o from é sobre a entidade Aluguel, como seria na native query.
		 */
		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		
		/*
		 * aqui criamos a funcao de agregacao, neste caso um sum sobre a coluna valor total 
		 * da classe Aluguel
		 */
		criteriaQuery.select(builder.sum(aluguel.<BigDecimal>get("valorTotal")));
		//equivalente ao select sum(a.valorTotal) from Aluguel a
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
		BigDecimal total = query.getSingleResult();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println("Soma de todos os alugueis: " + total);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	/*
	 * o metodos resultadoComplexo(), resultadoTupla() e resultadoConstrutores() são formas de se buscar com projecoes, mas desta vez, 
	 * retornando varios atributos ao mesmo tempo.
	 * os metodos estao por ordem de complexidade e de elegancia.
	 */
	
	/*
	 * este metodo é o mais rapido e facil dos metodos.
	 * nele é executado um multiselect, que nada mais é do que retornar varios atributos na consulta
	 */
	@Test
	public void resultadoComplexo() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		/*
		 * como sao varios os retornos, entao devemos guarda-lo como object[]
		 */
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 *o multiselect recebe os atributos que se quer receber.
		 *a ordem passada, com inicio no index 0,será a ordem recebida. 
		 */
		criteriaQuery.multiselect(carro.get("placa"), carro.get("valorDiaria"));
		
		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();
		
		/*
		 * para recuperar os valores, baixa acessar o array na posicao desejada, conforme
		 * passado no multiselect.
		 */
		for (Object[] valores : resultado) {
			System.out.println(valores[0] + " - " + valores[1]);
		}
	}
	
	@Test
	public void resultadoTupla() {
		/*
		 * o que sao tuplas?
		 * tuplas sao objetos como se fosse um mapa, com chave e valor.
		 * 
		 * por isso usamos o alias.
		 * 
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		/*
		 * como estamos utilizando tuplas, entao o tipo da CriteriaQuery sera Tupla e o 
		 * builder usara o createTupleQuery()
		 */
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 * no multiselect, alem de colocar os atributos pretendidos, devemos tambem 
		 * colocar o alias, que sera a chave dentro da tupla.
		 * o alias pode ser qualquer palavra. 
		 */
		criteriaQuery.multiselect(carro.get("placa").alias("placaCarro")
						, carro.get("valorDiaria").alias("valorCarro"));
		
		List<Tuple> resultado = null;
		try {
			/*
			 * tanto a typedQuery como a lista de resultado, terao o tipo de tupla.
			 */
			TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
			resultado = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(resultado == null || resultado.isEmpty()) {
			System.out.println("LISTA VAZIA");
		}
		
		
		for (Tuple tupla : resultado) {
			System.out.println(tupla.get("placaCarro") + " - " + tupla.get("valorCarro"));
		}
	}
	
	@Test
	public void resultadoConstrutores() {
		/*
		 * o resultado com construtores é a mais elegante das soluçoes.
		 * ela utiliza um VO para armazenar os dados.
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoCarro> criteriaQuery = builder.createQuery(PrecoCarro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 * utilizamos o metodo construct do builder, e passamos a classe do VO, e a seguir
		 * passamos a sequencia exata do construtor do objeto VO.
		 */
		criteriaQuery.select(builder.construct(PrecoCarro.class, 
						carro.get("placa"), carro.get("valorDiaria")));
		
		/*
		 * o tipo da typedquery é o VO
		 */
		TypedQuery<PrecoCarro> query = manager.createQuery(criteriaQuery);
		List<PrecoCarro> resultado = query.getResultList();
		
		/*
		 * para acessar os dados basta utilizar os get e sets
		 */
		for (PrecoCarro precoCarro : resultado) {
			System.out.println(precoCarro.getPlaca() + " - construtores -  " + precoCarro.getValor());
		}
	}
	
	/*
	 * exemplo de codigo para executar uma funcao do bd, neste caso, um uppercase
	 */
	@Test
	public void exemploFuncao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 * RESTRICAO
		 * o upper funciona da seguinte forma:
		 * (atributo, valor da consulta)
		 * 
		 * no exemplo, o 'BrAnCo' seria o valor vindo do filtro.
		 * e seria estabilizado pelo touppercase e o valor do banco seria estabilizado 
		 * pelo builder.upper
		 */
		Predicate predicate = builder.equal(builder.upper(carro.<String>get("cor")), 
									"BrAnCo".toUpperCase());
		
		criteriaQuery.select(carro);
		
		criteriaQuery.where(predicate);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getCor());
		}
	}
	
	@Test
	public void exemploOrdenacao() {
		/*
		 * para ordenar uma lista de resultados, basta somente incliur 
		 * na criteriaQuery um order by.
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 * o objeto order sera encarregado de fazer a ordenaçao. neste caso é utilizado
		 * a ordenacao desc, criada a partir do builder, em um atributo, neste caso,
		 * o valorDiaria.
		 */
		Order order = builder.desc(carro.get("valorDiaria"));
		
		criteriaQuery.select(carro);
		
		/*
		 * adicionamos o order by.
		 */
		criteriaQuery.orderBy(order);
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
		
		/*
		 * desta forma o resultado na lista estará ordenado pelo valor do valorDiaria
		 * do maior para o menor.
		 */
	}
	
	@Test
	public void exemploJoinEFetch1() {
		/*
		 * este exemplo mostra como fazer um select com as entidades
		 * carro e modelo usando o join e o fetch.
		 * 
		 * o resultados que queremos é que seja impresso
		 * a placa do carro (Carro) e o modelo (ModeloCarro)
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");//join com fetch
		
		criteriaQuery.select(carro);
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
		}
	}
	
	@Test
	public void exemploJoinEFetch2() {
		/*
		 * este exemplo mostra como fazer um select com as entidades
		 * carro e modelo usando o join e o fetch e realizando 
		 * um filtro.
		 * 
		 * o resultados que queremos é que seja impresso
		 * a placa do carro (Carro) e o modelo (ModeloCarro)
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");//join com fetch
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Fit")); //filtro
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
		}
	}
	
	@Test
	public void exemploJoinEFetch3() {
		/*
		 * este exemplo mostra como fazer um select com as entidades
		 * carro e modelo usando somente o join e realizando 
		 * um filtro.
		 * 
		 * o resultados que queremos é que seja impresso
		 * a placa do carro (Carro).
		 * 
		 * o modelo nao pode ser utilizado neste caso porque ele nao 
		 * será recuperado do banco.
		 */
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.join("modelo");//join SEM fetch
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Civic")); //filtro
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		
		/*
		 * neste caso, ele ira fazer selects separados para 
		 * trazer o modelo, como fazia antes. (má performance)
		 * 
		 */
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
		}
	}
	
	@Test
	public void mediaDasDiariasDosCarros() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = builder.createQuery(Double.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.avg(carro.<Double>get("valorDiaria")));//MEDIA do valor da diaria
		
		TypedQuery<Double> query = manager.createQuery(criteriaQuery);
		Double total = query.getSingleResult();
		
		System.out.println("Média da diária: " + total);
	}
	
	@Test
	public void carrosComValoresAcimaDaMedia() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		/*
		 * como a subquery retorna um valor com casas decimais, utiliza-se
		 * o tipo Double.class
		 */
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class); //subquery
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Root<Carro> carroSub = subquery.from(Carro.class); //subquery
		
		subquery.select(builder.avg(carroSub.<Double>get("valorDiaria")));//subquery
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.greaterThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));//subquery
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
		
	}
	
	@Test
	public void carrosComValoresAcimaDaMediaOrganizado() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		
		criteriaQuery.select(carro);
		
		//SUBQUERY
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		Root<Carro> carroSub = subquery.from(Carro.class);
		subquery.select(builder.avg(carroSub.<Double>get("valorDiaria")));
		
		criteriaQuery.where(builder.lessThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
		
	}
	
	@Test
	public void exemploSemMetaModel () {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"),"Civic"));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + "-" + c.getModelo().getDescricao());
		}
	}
	
	/**
	 * METAMODEL
	 * se continuarmos utilizando string para encontrar os atributos
	 * se alterarmos o nome do atributo na classe, não será possivel 
	 * seguir os erros ate as consultas, gerando erros somente em 
	 * tempo de execução.
	 * 
	 * o metamodel resolve este problema para nos e nos ajuda a encontrar
	 * possiveis erros de digitaçao ou alteraçoes seguras em nomes de 
	 * atributos.
	 * 
	 * como utilizar o metamodel?
	 * 1- no pom, adicionar a seguinte dependencia:
	 * 	<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-jpamodelgen</artifactId>
			<version>1.3.0.Final</version>
			<scope>compile</scope>
		</dependency>
		
		2-após adicionar a dependencia, é necessário realizar algumas
		configurações no pom:
		
		no plugin do maven compiler, adicionar uma tag com a informaçao para no compilar 
		as classes geradas no metamodel:
		no <artifactId>maven-compiler-plugin</artifactId>, adicionar:
		
		<compilerArgument>-proc:none</compilerArgument>
		
		isto evita que de erro de duplicaçao de codigo.
		
		3- os outros plugins sao:
		<plugin>
				<groupId>org.bsc.maven</groupId>
				<artifactId>maven-processor-plugin</artifactId>
				<version>2.2.4</version>
				<executions>
					<execution>
						<id>process</id>
						<goals>
							<goal>process</goal>
						</goals>
						<phase>generate-sources</phase>
						<configuration>
			                <outputDirectory>target/metamodel</outputDirectory>
			            </configuration>
					</execution>
				</executions>
			</plugin>

			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>build-helper-maven-plugin</artifactId>
				<version>1.3</version>
				<executions>
					<execution>
						<id>add-source</id>
						<phase>generate-sources</phase>
						<goals>
							<goal>add-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>target/metamodel</source>
							</sources>
						</configuration>
					</execution>
				</executions>
			</plugin>
			
			4-executar o projeto com clean install do maven
			5- na pasta metamodel, será criado uma copia das entidades presentes no projeto.
			a diferença é que o final do nome contem um underline_
			6- para podermos usar estas classes no projeto, temos que confifurar o projeto para
			usar a pasta do metamodel, entao:
				A- clicar com o botao direito no projeto e selecionar 'properties']
				B- em 'java build path' clicar em 'add folder'
				C- adicionar a pasta metamodel
			7- agora podemos utilziar os atibutos criados automaticamente e cada vez que alterarmos 
			a entidade e rodarmos o clean install, seremos avisados caso o sistema já utilize esse 
			atributo.
			
			a vantagem de utilizar o metamodel é que, caso alteremos os atributos da entidade,
			com o metamodel é possivel verificar logo possiveis erros devido a alteraçao dos 
			nomes dos campos.
		
	 */
	@Test
	public void exemploComMetaModel () {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch(Carro_.modelo);//metamodel
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get(ModeloCarro_.descricao),"Civic"));//metamodel
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + "-" + c.getModelo().getDescricao());
		}
	}
	
	@Test
	public void testeAlexandre() {
//		//Query query = this.manager.createNativeQuery("select c.placa, m.descricao from Carro c, ModeloCarro m where c.codigo_modelo = m.codigo");
//		//List<CarModelTemp> resultado = query.getResultList();
//		
//		Query query = this.manager.createNativeQuery("select * from Carro", Carro.class);
//		List<Carro> carros = query.getResultList();
//		for (Carro c : carros) {
//			System.out.println(c.getPlaca());
//			System.out.println(c.getModelo().getDescricao());
//		}
	}
	
	
}










