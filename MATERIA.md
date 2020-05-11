# CURSO DE JAX-WS-SOAP
###### concluído em 04/02/2018
###### markup em 07/04/2020

## WHAT I NEED?
- Objetivo: **desenvolver um projeto Java para criar um serviço SOAP**. 

- necessário:

    Java JDK 8 (pode ser JDK 7) 

    Eclipse IDE for Java EE Developers. 

    JBoss Wildfly 8.x 

    SoapUI.
    
    
## INTRODUÇÃO




1.1. Introdução ao curso de JPA 2 e Hibernate
o que você vai aprender?
utilizar o mysql como banco de dados para trabalhar com persistência.
introdução a persistência
criar um projeto com método main para iniciar os passos com jpa e hibernate
criar um sistema de locadora de veiculo, com situações reais que ocorrem quando trabalhamos com jpa e hibernate.
tomcat, jsf2, maven, primefaces
geração das primary keys, mapeamentos de muitos para um um para muitos, etc, lazy e eager, chaves compostas, data, enumeração, herança. ver detalhes da transação, evoluir consultas utilizando JPQL, criteria, gravação em cascata.

1.2. O que é persistência?
persistência é tudo aquilo que você consegue gravar e recuperar. mesmo passado muito tempo. 


1.3. Instalando o MySQL
fazer o download do mysql
 
para instalar o mysql, executar o setup do instalador.

configuração normal.

inicializar o mysql como serviço manualmente :
painel de controle
administrative tools
services
na lista, encontrar o mysql e clicar em start


1.4. Exercício: Instalando o MySQL no Linux Ubuntu
A demonstração da instalação do MySQL abaixo foi realizada no Ubuntu 12.04 32-bit.

Se você usa uma distribuição diferente, deixe seu comentário abaixo que tentaremos ajudar.
1. Abra um terminal e execute o comando: sudo apt-get install mysql-server-5.5 mysql-workbench
2. Digite y para as próximas confirmações e o início do download do repositório IMPORTANTE: Você precisa estar conectado a internet.
3. Para iniciar o servidor, execute o comando: sudo service mysql start
4. Para abrir o workbench você pode na linha de comando digitar: mysql-workbench ou utilizar o atalho criado.
Você então irá ver a tela inicial do workbench 
5. Clicando em "localhost" na caixa "Open Connection to Start Querying", você irá para a o workbench e poderá fazer todas as consultas.


1.5. Criando as primeiras tabelas no MySQL
criar um schema:
criar um novo schema usando o wizard do workbench.

(CREATE SCHEMA ‘cadastro_cliente’;)


criar uma tabela:

CREATE TABLE cliente (
	codigo BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	idade INTEGER,
	sexo VARCHAR(1) NOT NULL,
	profissao VARCHAR(30),
	PRIMARY KEY(codigo)
);

inserir um cliente:

insert into cliente (nome, idade, sexo, profissao) ]
values ( “jose da sila”, 25, “M”, “Engenheiro”);


select * from cliente;

insert into cliente (nome, idade, sexo, profissao) ]
values ( “maria rita”, 22, “F”, “Medica”);

select * from cliente;

1.6. Mapeamento Objeto Relacional (ORM)
o JPA2/hibernate faz o mapeamento objeto relacional. eles são a ponte entre o banco e a aplicação.

JPA2 é a especificação e o hibernate é a implementação.


modelo relacional
modelo OO
tabela
classe
linha
objeto
coluna
atributo


O JPA Java Persistence API (ou simplesmente JPA) é uma API padrão da linguagem Java que descreve uma interface comum para frameworks de persistência de dados. A JPA define um meio de mapeamento objeto-relacional para objetos Java simples e comuns (POJOs), denominados beans de entidade. Diversos frameworks de mapeamento objeto/relacional como o Hibernate implementam a JPA. Também gerencia o desenvolvimento de entidades do Modelo Relacional usando a plataforma nativa Java SE e Java EE.
Originou-se num projeto comum entre os desenvolvedores para se criar o padrão[1]. Fortemente baseado nas ideias trazidas pelo Hibernate, tanto que o líder da primeira versão dessa especificação é o criador do framework.
Ou seja, é utilizado principalmente para conexão e acesso a banco de dados relacionais.

O Hibernate é um framework para o mapeamento objeto-relacional escrito na linguagem Java, mas também é disponível em .Net com o nome NHibernate. Este framework facilita o mapeamento dos atributos entre uma base tradicional de dados relacionais e o modelo objeto de uma aplicação, mediante o uso de arquivos (XML) ou anotações Java (veja Annotation (java)).
Hibernate é um software livre de código aberto distribuído com a licença LGPL.
O objetivo do Hibernate é diminuir a complexidade entre os programas Java, baseado no modelo orientado a objeto, que precisam trabalhar com um banco de dados do modelo relacional (presente na maioria dos SGBDs). Em especial, no desenvolvimento de consultas e atualizações dos dados.
Sua principal característica é a transformação das classes em Java para tabelas de dados (e dos tipos de dados Java para os da SQL). O Hibernate gera as chamadas SQL e libera o desenvolvedor do trabalho manual da conversão dos dados resultante, mantendo o programa portável para quaisquer bancos de dados SQL, porém causando um pequeno aumento no tempo de execução.
Nas questões relacionadas para o gerenciamento de transações e na tecnologia de acesso à base de dados são de responsabilidade de outros elementos na infraestrutura do programa. Apesar de existirem API no Hibernate para possuir operações de controle transacional, ele simplesmente delegará estas funções para a infraestrutura na qual foi instalada.
No caso de aplicações construídas para serem executadas em servidores de aplicação, o gerenciamento das transações é realizado segundo o padrão JTA. Já nas aplicações standalone, o programa delega o tratamento transacional ao driver JDBC.
Hibernate pode ser utilizado em aplicações Java standalone ou em aplicações Java EE, utilizando servlet ou sessões Enterprise Java Beans.
Hibernate foi criado por desenvolvedores Java, espalhados ao redor do mundo, e liderado por Gavin King. Posteriormente, JBoss Inc (empresa comprada pela Red Hat) contratou os principais desenvolvedores do programa para fazer o seu suporte.
A atual versão do Hibernate é a 5.x, que incorporou características como a nova arquitetura Interceptor/Callback, filtros definidos pelo usuário e anotações JDK 5.0 (Metadados do Java), que substitui os arquivos XML. Hibernate 3 também se aproxima das especificações EJB 3.0 e atua como a espinha dorsal das implementações EJB 3.0 em JBoss.
A HQL (Hibernate Query Language) é um dialeto SQL para o Hibernate. Ela é uma poderosa linguagem de consulta que se parece muito com a SQL, mas a HQL é totalmente orientada a objeto, incluindo os paradigmas de herança, polimorfismo e encapsulamento.
No Hibernate, você pode escolher tanto usar a SQL quanto a HQL. Escolhendo a HQL, você poderá executar os pedidos SQL sobre as classes de persistência do Java ao invés de tabelas no banco de dados.
Utilizando o HQL temos a vantagem de portabilidade de banco, ou seja, suponha que estamos utilizando um banco de dados A, ao trocarmos para um banco B o HQL automaticamente cria comandos referentes a cada banco de dados. Isso facilita, pois no SQL teríamos que rastrear e alterar vários códigos no sistema.
https://pt.wikipedia.org/wiki/Hibernate


1.7. Relacionamento entre tabelas
criar outra tabela chamada de conta corrente: 


CREATE TABLE conta_corrente (
	codigo BIGINT NOT NULL AUTO_INCREMENT,
	numero VARCHAR(12) NOT NULL,
	saldo DECIMAL,
	codigo_cliente BIGINT NOT NULL,
	PRIMARY KEY (codigo),
	FOREIGN KEY (codigo_cliente) REFERENCES cliente (codigo)
);

e depois vamos inserir um valor na conta:

insert into conta_corrente (numero, saldo, codigo_cliente) values (123456, 1000.00, 1);


o código do cliente relacionado deve existir na tabela cliente, se não ocorre erro:
insert into conta_corrente (numero, saldo, codigo_cliente) values (22222, 5000.00, 5);

o cliente 5 ainda não existe.

agora vamos corrigir o insert para o cliente 2:
insert into conta_corrente (numero, saldo, codigo_cliente) values (22222, 5000.00, 2);


para exibir na mesma consulta o nome e o saldo, devemos executar o seguinte select:

select cli.nome, cc.saldo from cliente cli , conta_corrente cc where cli.codigo = cc.codigo_cliente


1.8. Instalando e configurando o Eclipse
após instalar o java, configurar as variáveis de ambiente.

baixar o eclipse java EE developer

descompactar o eclipse


no eclipse, 
window - preference

encoding
workspace
text-file encoding
UTF-8

line delimiter
unix

css files
encoding UTF-8

html files
		encoding UTF-8

jsp files
	encoding UTF-8

xml files
		enconding UTF-8


spelling
disable spelling


validation
	validation
		suspend all validators


1.9. Download e configuração do Hibernate
baixar o hibernate para utilizar na parte inicial do curso, antes de usarmos o maven

www.hibernate.org

downloads

baixar a versão do hibernate ORM

extrair o conteudo do zip em uma pasta para o hibernate local

no eclipse
window
preference
	java	
user library
	adicionar uma nova biblioteca
após adicionar a biblioteca, clicar em add new external jar
selecionar a pasta do hibernate, lib, jpa
selecionar a pasta required e adicionar todas

		

	1.10. Download e configuração do driver MySQL
em mysql.com, em downloads

na página da community edition, procurar por connector j e fazer o download em zip

descompactar o zip em uma pasta

no eclipse,
window
preferences
	driver definitions
		add
			selecionar o mysql jdbc driver
			em jar list
				dar um clear
				add e selecionar o local da pasta onde o jar do driver se encontra.



2.1. Salvando o primeiro objeto no Banco de Dados
criar um projeto simples de teste, com método main.

file > new > java project

na construção do novo projeto, em java settings, na aba libraries, adicionar uma biblioteca em add library, user libraries, e adicionar o hibernate criado na aula anterior.

add library, connectivity driver definition, 

selecionar o mysql/ jdbc driver


após criar o projeto, 
criar uma classe, no pacote, com.algaworksw.curso.main, com nome de SalvandoPrimeiroObjeto

configurar o entitymanager

dentro da pasta src, criar uma pasta chamada META-INF
e agora criar um arquivo e chamá-lo de persistence.xml


persistence.xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<persistence-unit name="exemploPU" transaction-type="RESOURCE_LOCAL">
		
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/cadastro_cliente"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="root"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
			
			<!-- validate | update | create | create-drop -->
<!-- atualiza automaticamente o banco de dados-->
	<property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	
	</persistence-unit>
	
</persistence>



no método main,

public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Pedro Bial");
		cliente.setIdade(40);
		cliente.setProfissao("Jornalista");
		cliente.setSexo("M");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Cliente salvo com sucesso!");
		//em.close();
	}




e no pacote modelo, criar a classe Cliente,

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private Integer idade;
	private String sexo;
	private String profissao;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
}


2.2. Primeira consulta com JPA
criar outra nova classe chamada ConsultandoPrimeiroObjeto

public class ConsultandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Cliente cliente = entitymanager.find(Cliente.class, 1L);
		if(cliente != null) {
			System.out.println("nome: " +cliente.getNome());
			System.out.println("idade: " +cliente.getIdade());
			System.out.println("profissao: " +cliente.getProfissao());
			System.out.println("sexo: " +cliente.getSexo());
		} else {
			System.out.println("cliente nao encontrado");
		}
		
		
		
//		entitymanager.close();

	}

}

para realizar uma consulta básica, basta usar o método find do entityManager.

2.3. Removendo objeto do banco de dados
criar uma nova classe chamada RemovendoPrimeiroObjeto com o código:

public class RemovendoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		
		Cliente cliente = entitymanager.find(Cliente.class, 2L);
		
		
		entitymanager.getTransaction().begin();
		//IMPORTANTE -- para remover um objeto este deve estar dentro do 
		//contexto de gerenciamento do entitymanager ou seja ja deve ter
		//sido carregado pelo sistema
		entitymanager.remove(cliente);
		entitymanager.getTransaction().commit();
		
		System.out.println("cliente apagado!");
//		entitymanager.close();		

	}

}

2.4. Atualizando o banco de dados
crie outra classe chamada AtualizandoPrimeiroObjeto com o código:

public class AtualizandoPrimeiroObjeto {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		//para atualizar um objeto no banco de dados,
		//é necessário que o objeto esteja gerenciado pelo entityManager
		Cliente cliente = entitymanager.find(Cliente.class, 1L);
		
		entitymanager.getTransaction().begin();
		cliente.setNome("lionel da silva sauro");
		cliente.setIdade(33);
		
		entitymanager.getTransaction().commit();
		
		System.out.println("cliente atualizado com sucesso!");
//		entitymanager.close();	

	}

}

2.6. Entendendo um pouco mais da transação
para entender um pouco mais sobre transação devemos observar:
necessitamos de transação para o insert, delete e update.

a transação deve seguir o ACID, ou seja, deve ter ATOMICIDADE, CONSISTÊNCIA, ISOLAMENTO, DURABILIDADE.
a atomicidade representa o iniciar uma alteração você deve terminar. se houver problemas deve ser tudo alterado novamente para o estado inicial.
a consistência representa que os dados devem sempre estar consistentes, ou seja ou tudo foi alterado ou nada foi alterado.
o isolamento significa que a transação não deve interferir em outra transação
e a durabilidade significa que as alterações devem ser persistidas.


então devemos criar um novo projeto, importando as bibliotecas do hibernate e o driver do mysql.
então devemos criar uma classe conta, com id e saldo.

@Entity
public class Conta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	private Double saldo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}




uma transação começa no .begin() e somente termina no .commit() ou no .rollback().

para fazermos um teste, escreva a seguinte classe executável:

public class Transferencia {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bancoTabajaraPU");
		EntityManager em = emf.createEntityManager();

		Scanner entrada = new Scanner(System.in);
		Conta conta1 = em.find(Conta.class, 1L);
		if (conta1 == null) {
			System.out.print("Digite o saldo inicial da conta 1: ");
			Double saldoInicialConta1 = entrada.nextDouble();
			conta1 = new Conta();
			conta1.setSaldo(saldoInicialConta1);
		}
		
		Conta conta2 = em.find(Conta.class, 2L);
		if (conta2 == null) {
			System.out.print("Digite o saldo incial da conta 2: ");
			Double saldoInicialConta2 = entrada.nextDouble();
			conta2 = new Conta();
			conta2.setSaldo(saldoInicialConta2);
		}
		
		em.getTransaction().begin();
		em.persist(conta1);
		em.persist(conta2);
		em.getTransaction().commit();
		System.out.println("Saldo da conta1: " + conta1.getSaldo() 
				+ ". Saldo conta2: " + conta2.getSaldo());
		
		System.out.println("---------------------");
		System.out.print("Digite o valor a retirar da conta 1 e depositar na conta 2: ");
		Double valorTransferencia = entrada.nextDouble();
		
		em.getTransaction().begin();
		conta1.setSaldo(conta1.getSaldo() - valorTransferencia);
		conta2.setSaldo(conta2.getSaldo() + valorTransferencia);
		
		if (conta1.getSaldo() > 0) {
			em.getTransaction().commit();
			System.out.println("Transferência realizada com sucesso!");
		} else {
			em.getTransaction().rollback();
			System.err.println("Transferência não realizada, saldo insuficiente!");
		}
	}

}


devemos também criar o schema no banco chamado banco-tabajara e na persistence unit devemos colocar o nome do schema.

ao executar o comando de inserir saldo, a transação ocorre sem problemas. mas ao retirar mais dinheiro da conta do que ela possui, a transação executa o rollback e não é alterado nada no banco. 



2.7. A Java Persistence Query Language (JPQL)
um banco de dados utiliza SQL para realizar consultas no banco. em Java, existe o JPQL, java persistence query language, que é uma consulta da JPA. ela é um pouco diferente do SQL porque ela trabalha a nível de objeto.

dentro do JPQL existe uma subdivisão, que são as named query, que sao queries estáticas e as dynamic query é criada na hora.

para fazermos um teste, vamos utilizar o projeto crud-jpa-hibernate e criar uma classe executável chamada ConsultaComJPQL

public class ConsultaComJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		List<Cliente> clientes = em.createQuery("from Cliente where sexo = 'M'", Cliente.class).getResultList();
		for (Cliente cliente : clientes) {
			System.out.println("Código: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("----------------------------");
		}
	}
}



no createQuery, não precisamos colocar o select *, podendo ser abstraído.
também podemos colocar as cláusulas where, diretamente na string.

o interessante é que trabalhamos com objetos, ou seja, se queremos uma lista de Cliente basta utilizar a classe Cliente no select e não o nome da tabela (ex. tb_cliente, etc)


2.8. Fechando o Entity Manager
normalmente em aplicações web o entity manager é fechado logo após a transação. mas isso é configurável e não uma regra.

mas o que acontece quando o entity manager é fechado? bom, todos os objetos que estavam sendo gerenciados pelo em deixam de ser conhecidos, mesmo se criarmos um novo em.

se tentarmos fazer uma alteração sem iniciar o novo em, ele irá exibir uma mensagem de erro informando que o entity manager está fechado.

mas e se criarmos o entity manager novo e prosseguirmos com as alterações, usando somente o commit? nao ira dar erro no log mas os objetos não serão persistidos, pois o novo em nao está gerenciando os objetos, logo as alterações serão perdidas.

então para persistirmos os objetos, usamos o método merge() do em. o método merge() recoloca os objetos passados como parâmetro novamente dentro do controle do em, persistindo as alterações.

Estados de um objeto JPA
É importante entendermos os estados das entidades JPA, pois estão diretamente relacionados com a função deste método.
No JPA um objeto pode assumir quatro estados: New, Managed, Removed e Detached.
Quando um objeto é criado, ele se encontra no estado New. Neste estado, o objeto não tem nenhuma relação com EntityManager ou uma representação
no banco de dados. Qualquer alteração no objeto, neste estado, não é notada pelo JPA.
Quando o objeto é persistido (geralmente em um banco de dados), ele passa para o estado Managed. Neste, qualquer alteração no objeto será sincronizada com o dado persistido. Essa sincronização não é em tempo real. Uma alteração no objeto não irá executar automaticamente um comando SQL, isso só irá acontecer em "flush time".
O "flush time" ocorre por padrão (de acordo com a implementação do Hibernate, uma vez que a especificação do JPA não define isso) em três momentos:
Antes da execução de uma query.
Na chamada do método commit() de EntityTransaction.
Na chamada do método flush() de EntityManager.
É muito comum o objeto se manter por pouco tempo no estado Managed, pois, geralmente, após persistí-lo, o EntityManager já é fechado e então ele passa para o estado Detached.
O estado Detached significa que o objeto não está vinculado ao EntityManager. Qualquer alteração não irá impactar no dado persistido. Isso só irá ocorrer se o estado voltar a ser Managed.
Por fim, temos o estado Removed. O objeto assume este estado quando um objeto Managed é marcado para a remoção com o método remove.
Funcionamento do merge e persist
Agora que conhecemos os estados de um objeto JPA, é possível afirmar que ele só pode ser alterado, quando este está no estado Managed. Mas como definir um objeto neste estado? Bom, isso pode ser feito através de dois métodos: persist e merge.
O funcionamento do persist é bem simples: ao ser chamado, o objeto é salvo no banco e o seu estado muda para Managed.
Já o funcionamento do merge irá depender de alguns fatores. O seu comportamento principal é lidar com objetos no estado Detached. Quando um objeto neste estado é passado para o método merge, é retornado um novo objeto no estado Managed.
Se o objeto estiver no estado New, mas tendo os seus dados exatamente iguais aos persistidos na base, o merge retornará um novo objeto no estado Managed. Mas, se o objeto no estado New contiver ao menos um dado diferente dos persistidos, será gerado um novo registro e, um novo objeto no estado Managed será retornado.
Se o objeto contiver outros objetos relacionados (através de uma propriedade de relacionamento) e o JPA não conseguir localizar seus dados no banco, também será gerado um novo registro do objeto e também dos que estiverem relacionados. Além disso, um novo objeto no estado Managed também será retornado.
Se o objeto estiver no estado Removed o método merge irá gerar um erro.
Repare que sempre cito que o merge retorna o objeto no estado Managed.
 Assim, o uso correto desse método é:
Entidade e = new Entidade();

Entidade e2 = em.merge(e);

e2.setAtributo(novoValor);


Veja que apenas o objeto e2 se encontra no estado Managed. Qualquer alteração em e não será sincronizada com o banco. Se o e fosse alterado, como abaixo:
Entidade e = new Entidade();

em.merge(e);

e.setAtributo(novoValor);


Ao executar o "flush", a alteração não seria refletida no banco de dados.
Caso não tenha certeza se o método merge irá gerar um novo registro ou não, opte pelo uso do find:
Entidade e = em.find(Entidade.class, 1);


Este método sempre irá retornar um objeto no estado Managed (ou null se o registro não for encontrado). Aí não corremos o risco de gerar um novo registro apenas para se obter um objeto neste estado.
https://www.treinaweb.com.br/blog/entendendo-o-metodo-merge-do-jpa/
3.2. Introdução ao Apache Tomcat
para baixar o tomcat, vá em www.tomcat.apache.org e baixe o zip.

descompacte o zip em uma pasta.

dentro da pasta bin temos os executáveis para startar o servidor mas nao iremos utilizar desta forma.

no eclipse, adicionar o tomcat.

na tela de adição de servidor, na aba ‘apache’, devemos encontrar a versão do tomcat que baixamos.

3.3. Introdução ao Apache Maven
para baixar o maven, vá em maven.apache.org.

para o eclipse juno e versões anteriores, é necessário baixar o plugin do maven. isso é possivel no endereço http://download.jboss.org/jbosstools/updates/m2eclipse-wtp/

para o eclipse Kepler e posteriores, o plugin já vem instalado, mas podemos baixá-lo em:
http://download.eclipse.org/m2-wtp/releases/kepler/

mas vamos utilizar a versão externa do maven.

no eclipse, para instalar o plugin (nao necessario a partir da versão kepler), vá em ‘help’ e ‘install new software’

no campo ‘work with’, cole o link do plugin.

selecione os pacotes: m2e maven archiver connector, maven integration for eclipse e maven integration for WTP.

clique em next e aceite os termos.


após extrair o zip do maven, va no eclipse> window > preferences > maven > installations
e inclua no eclipse a versão externa do maven.

na pasta do maven, vá em ‘conf’ e edite o arquivo settings.xml, adicionando o local do repositório local:

C:\luiz-estudo\MAVEN REPOSITORIES

no eclipse> window > preferences > maven > user settings, coloque o caminho para o arquivo settings.xml


3.4. Importando um projeto do GitHub
acesse www.github.com/algaworks/curso-jpa-hibernate onde voce encontrara um pequeno projeto do github para usarmos como exemplo.

baixe o zip do  projeto

pegue o projeto ‘primeiro-projeto-jsf’ e coloque no workspace.

no eclipse, fazer o import em file > import

clique em maven > existing maven projects

selecione o local onde foi extraído o projeto e clique em finish.

o maven irá baixar as dependências.

após concluído, faça o deploy do projeto no tomcat e inicie o servidor.

localhost:8080/primeiro-projeto-jsf/OlaJSF.xhtml


3.5. Introdução ao JSF 2 e Primefaces
pequena introdução ao JSF 2 e primefaces.

no sistema que baixamos, bem basicamente, foi configurado da seguinte maneira:

no POM, é onde colocamos as configurações.

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

	<modelVersion>4.0.0</modelVersion>

	<groupId>com.algaworks</groupId>
	<artifactId>primeiro-projeto-jsf</artifactId>
	<version>1.0.0-SNAPSHOT</version>

	<packaging>war</packaging>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	</properties>
	
	<build>
		<finalName>primeiro-projeto-jsf</finalName>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.7</source>
					<target>1.7</target>
				</configuration>
			</plugin>
		</plugins>
	</build>

	<dependencies>
		<!-- Mojarra (Implementação JSF 2) -->
		<dependency>
			<groupId>org.glassfish</groupId>
			<artifactId>javax.faces</artifactId>
			<version>2.1.17</version>
			<scope>compile</scope>
		</dependency>

		<!-- Primefaces -->
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>3.5</version>
			<scope>compile</scope>
		</dependency>
	</dependencies>

	<repositories>
		<!-- Repositorio Primefaces -->
		<repository>
			<id>prime-repo</id>
			<name>PrimeFaces Maven Repository</name>
			<url>http://repository.primefaces.org</url>
			<layout>default</layout>
		</repository>
	</repositories>


</project>


a configuração do primefaces é a seguinte:

DOWNLOAD dependency configuration would be as follows;
XHTML
1
2
3
4
5
<dependency>
	<groupId>org.primefaces</groupId>
	<artifactId>primefaces</artifactId>
	<version>6.1</version>
</dependency>

PrimeFaces 4.0 and newer are available at Maven Central, for older releases and RC releases add the following repository definition to your pom.xml in repositories section.
XHTML
1
2
3
4
5
6
7
<!-- For 3.5 and older -->
<repository>
	<id>prime-repo</id>
	<name>PrimeFaces Maven Repository</name>
	<url>http://repository.primefaces.org</url>
	<layout>default</layout>
</repository>
https://www.primefaces.org/downloads/



outra configuração é feita em src/main/webapp, no arquivo OlaJSF.xhtml
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:p="http://primefaces.org/ui">

	<h:head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title><ui:insert name="titulo">Primeiro projeto JSF</ui:insert></title>
	</h:head>
	
	<h:body>
		<h:form id="formulario">
			<p:outputLabel value="Digite seu nome"/>
			<p:inputText value="#{meuBean.nome}"/>
			<p:commandButton value="Enviar" action="#{meuBean.transformar}" update="formulario"/>
		</h:form>
	</h:body>

</html>


outra configuração é feita em src/main/webapp/WEB-INF/ no arquivo web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
     version="3.0">
	
	<display-name>primeiro-projeto-jsf</display-name>
	
	<servlet>
		<servlet-name>Faces Servlet</servlet-name>
		<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>
	
	<servlet-mapping>
		<servlet-name>Faces Servlet</servlet-name>
		<url-pattern>*.xhtml</url-pattern>
	</servlet-mapping>
	
</web-app>



e no arquivo faces-config.xml, que vamos deixar somente com a configuração do locale:
<?xml version="1.0" encoding="UTF-8"?>

<faces-config
    xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_1.xsd"
    version="2.1">

	<application>
		<locale-config>
			<default-locale>pt_BR</default-locale>
		</locale-config>
	</application>

</faces-config>


outra configuração é feita em srs/main/resources/META-INF, no arquivo beans.xml,
que de momento ficará vazio (somente cabeçalhos)

na classe MeuBean, ela deve estar anotada com a anotação @ManagedBean para que possa ser possível utilizá-la no JSF.

3.6. Importante: Atualização do projeto principal
atualização de bibliotecas do projeto principal do curso.

link do youtube onde é explicado como importar um projeto maven pelo eclipse:
https://www.youtube.com/watch?v=tHWO7XasMhk

no POM, foram atualizados  varias versoes, como do primefaces, omnifaces, CDI, log, o persistence.xml, estamos usando o datasource. 

no tomcat, adicionar as libs do c3po, mchange

o beans.xml ficará em branco (sem nem os cabeçalhos)

usar o novo código, mesmo que na aula seja diferente.


4.1. Criando o projeto do curso
importar o projeto do curso (atualizado).

é preciso configurar o projeto conforme na aula 3.6.

neste momento somente queremos subir o projeto e o resto será configurado mais tarde.

então precisamos configurar o banco de dados. 


devemos baixar o mysql java driver da versão 5.1.35 (marcado no pom) e colocá-lo na pasta lib do tomcat.

devemos baixar também os jars do hibernate c3p0 e mchange-commons da versao 4.3.11.Final (marcado no pom) do hibernate e colocar também na pasta lib do tomcat.


em src/main/resources/META-INF, existe o arquivo persistence.xml

persistence.xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<persistence-unit name="locadoraVeiculoPU" transaction-type="RESOURCE_LOCAL">
<!--O NOME MARCADO DEVE ESTAR TAMBEM EM src/main/webapp/META-INF/context.xml -->
		<non-jta-data-source>java:comp/env/jdbc/locadoraDB</non-jta-data-source>
		<properties>
			<property name="hibernate.hbm2ddl.auto" value="update"/>
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	</persistence-unit>
	
</persistence>


context.xml

<?xml version="1.0" encoding="UTF-8"?>
<Context>
	<Manager pathname="" />
	
	<Resource name="BeanManager" auth="Container"
		type="javax.enterprise.inject.spi.BeanManager" factory="org.jboss.weld.resources.ManagerObjectFactory" />
		
	<Resource name="jdbc/locadoraDB" auth="Container"
		factory="org.apache.naming.factory.BeanFactory" type="com.mchange.v2.c3p0.ComboPooledDataSource"
		driverClass="com.mysql.jdbc.Driver" jdbcUrl="jdbc:mysql://localhost:3306/locadora"
		user="root" password="root" minPoolSize="3" maxPoolSize="3" />
</Context>


e no web.xml 

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	version="3.0">

	<display-name>locadora-veiculo-web</display-name>

	<welcome-file-list>
		<welcome-file>Home.xhtml</welcome-file>
	</welcome-file-list>
	
	<resource-ref>
		<description>DB Connection</description>
		<res-ref-name>jdbc/locadoraDB</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>

	<context-param>
		<param-name>javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE</param-name>
		<param-value>true</param-value>
	</context-param>
	
	<context-param>
		<param-name>javax.faces.FACELETS_REFRESH_PERIOD</param-name>
		<param-value>0</param-value>
	</context-param>
	
	<context-param>
		<param-name>primefaces.FONT_AWESOME</param-name>
		<param-value>true</param-value>
	</context-param>
	
	<context-param>
		<param-name>javax.faces.PROJECT_STAGE</param-name>
		<param-value>Development</param-value>
	</context-param>
	
	<context-param>
    	<param-name>facelets.SKIP_COMMENTS</param-name>
    	<param-value>true</param-value>
	</context-param>

	<listener>
		<listener-class>org.jboss.weld.environment.servlet.Listener</listener-class>
	</listener>

	<servlet>
		<servlet-name>Faces Servlet</servlet-name>
		<servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
		<load-on-startup>1</load-on-startup>
	</servlet>

	<servlet-mapping>
		<servlet-name>Faces Servlet</servlet-name>
		<url-pattern>*.xhtml</url-pattern>
	</servlet-mapping>

	<filter>
		<filter-name>PrimeFaces FileUpload Filter</filter-name>
		<filter-class>org.primefaces.webapp.filter.FileUploadFilter</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>PrimeFaces FileUpload Filter</filter-name>
		<servlet-name>Faces Servlet</servlet-name>
	</filter-mapping>

</web-app>


agora vamos clicar com o botão direito no projeto e em seguida em ‘properties’ > e em ‘project faces’

marcar ‘dynamic web module’
se precisar configurar mais, no ‘content directory’ colocar ‘src/main/webapp’

marcar ‘java script’

marcar ‘java server faces’ como 2.2
disable library configuration   e todo o resto da página.

marcar ‘java’ como 1.7

executar maven update

ATENÇÃO: para subir o projeto pela primeira vez, o schema no banco de dados deverá estar criado.



4.2. Cadastrando o primeiro objeto
então a arquitetura do sistema será o seguinte:

Modelo
Visão (SERVLET, JSP, JSF, SWING)
Lógica(regras de negócio) (SPRING, EJB3)
DAO (JPA/HIBERNATE)
mysql BD


então para começar, devemos criar uma nova classe, no pacote modelo, com nome Fabricante.

Fabricante.java

package com.algaworks.curso.jpa2.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity//para informar que é uma entidade persistida
public class Fabricante {

	private Long codigo;//id
	private String nome;

	@Id//informa que este atributo eh o id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//permite o mysql usar o autoincrement
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

agora vamos criar a classe do DAO, para acesso a esta entidade, no pacote DAO, com nome FabricanteDAO

FabricanteDAO.java

package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;
 
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class FabricanteDAO implements Serializable {//importar o serializable por causa do JSF, que necessita guardar objetos em memória

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;//a vantagem de usar frameworks é que ele pode injetar o entity manager para nós, usando a anotação @Inject do JPA
	
	public void salvar(Fabricante fabricante) {
		//NÃO IMPLEMENTADO AINDA NO CURSO
		//em.merge(fabricante);
	}

	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante", Fabricante.class).getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {
		try {
			Fabricante fabricanteTemp = this.buscarPeloCodigo(fabricante.getCodigo());
		
			em.remove(fabricanteTemp);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Fabricante não pode ser excluído.");
		}
	}

	public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}
	
}


pronto, agora vamos criar a lógica. criar nova classe no pacote service com nome de CadastroFabricanteService

CadastrofabricanteService.java

package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
/*
	 * é costume abrir a transação no service, pois assim é possível 
	 * aproveitar a mesma transação.
	 * 
	 * esta anotação (@Transactional) é criada no projeto e controla a transação.
	 */
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (StringUtils.isEmpty(fabricante.getNome())) { 
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
	
}



e agora vamos criar a exception NegocioException

NegocioException.java

package com.algaworks.curso.jpa2.service;

public class NegocioException extends Exception {

	public NegocioException(String message) {
		super(message);
	}	
}

agora vamos criar a visão,
criar uma nova classe, no pacote controller, com nome CadastroFabricanteBean

CadastroFabricanteBean.java

package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.CadastroFabricanteService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named//usando CDI e ajuda na tarefa de injeção de dependência
@ViewScoped//escopo da página
public class CadastroFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroFabricanteService cadastroFabricanteService;
	
	private Fabricante fabricante;
	
	@Inject
	private FacesMessages facesMessages;//arquivo próprio que auxilia na exibição das mensagens
	
//	@PostConstruct // anotação constante do video
	public void inicializar() {
		if (this.fabricante == null) {
			limpar();
		}
	}
	
	public void salvar() {
		try {
			cadastroFabricanteService.salvar(fabricante);
			facesMessages.info("Fabricante salvo com sucesso!");
			
			limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
//	public boolean isEditando() {
//		return this.fabricante.getCodigo() != null;
//	}
	
	private void limpar() {
		this.fabricante = new Fabricante();
	}
	
}

a agora vamos criar o nosso xhtml, em src/main/webapp criar uma nova pasta e chamá-la de fabricante.

e dentro dessa pasta, criar um novo arquivo , HTML file, com o nome CadastroFabricante

CadastroFabricante.xhtml

<ui:composition template="/WEB-INF/template/LayoutPadrao.xhtml"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://xmlns.jcp.org/jsf/html"
    xmlns:f="http://xmlns.jcp.org/jsf/core"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:p="http://primefaces.org/ui"
    xmlns:o="http://omnifaces.org/ui">
    
    <ui:define name="titulo">#{cadastroFabricanteBean.editando ? 'Edição fabricante' : 'Novo fabricante'}</ui:define>
    
    <ui:define name="corpo">
    	<f:metadata>
<!--     		QUANDO ELE FOR EDITAR ELE IRÁ PASSAR POR ESTA PARTE PARA SETAR O FABRICANTE -->
			<o:viewParam name="fabricante" value="#{cadastroFabricanteBean.fabricante}" />
<!-- 			EM VEZ DE CHAMAR O POSTCONSTRUCT NO BEAN, ELE USA O VIEWACTION -->
			<f:viewAction action="#{cadastroFabricanteBean.inicializar}"/>
		</f:metadata>
    
    	<h1>#{cadastroFabricanteBean.editando ? 'Edição fabricante' : 'Novo fabricante'}</h1>
    	
    	<h:form id="frmCadastro">
    		<p:messages id="messages" autoUpdate="true" closable="true" />

	    	<p:toolbar style="margin-top: 20px">
	    		<p:toolbarGroup>
	    			<p:commandButton value="Salvar" id="botaoSalvar" action="#{cadastroFabricanteBean.salvar}" update="frmCadastro"/>
	    		</p:toolbarGroup>
	    		<p:toolbarGroup align="right">
					<p:button value="Pesquisa" outcome="/fabricante/PesquisaFabricantes"/>
				</p:toolbarGroup>
	    	</p:toolbar>
	    	
	    	<p:panelGrid columns="2" id="painel" style="width: 100%; margin-top: 20px"
	    			columnClasses="rotulo, campo">
	    		<p:outputLabel value="Código" for="codigo"/>
	    		<p:inputText id="codigo" size="20" maxlength="20" value="#{cadastroFabricanteBean.fabricante.codigo}" readonly="true"/>
	    		
	    		<p:outputLabel value="Nome" for="nome"/>
	    		<p:inputText id="nome" size="60" maxlength="80" value="#{cadastroFabricanteBean.fabricante.nome}"/>
	    	</p:panelGrid>
    	</h:form>
    </ui:define>
</ui:composition>


nosso código está quase pronto. 

falta criar um converter para a classe Fabricante.

no pacote converter, criar uma nova classe chamada FabricanteConverter.

FabricanteConverter.java

package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}



4.3. Implementando a consulta e exclusão
para implementarmos a pesquisa, devemos criar um xhtml com o nome PesquisaFabricantes, dentro da pasta Fabricantes, que criamos na aula passada.

PesquisaFabricantes.xhtml

<ui:composition template="/WEB-INF/template/LayoutPadrao.xhtml"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://xmlns.jcp.org/jsf/html"
    xmlns:f="http://xmlns.jcp.org/jsf/core"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:p="http://primefaces.org/ui">

    <ui:define name="titulo">Pesquisa de Fabricantes</ui:define>
    
    <ui:define name="corpo">
    	<f:metadata>
			<f:viewAction action="#{pesquisaFabricanteBean.inicializar}" />
		</f:metadata>
    
    	<h1>Pesquisa de Fabricantes</h1>
    	
    	<h:form id="frmPesquisa">
    		<p:messages id="messages" autoUpdate="true" closable="true" />
    		
    		<p:toolbar style="margin-top: 20px">
    			<p:toolbarGroup>
    				<p:button value="Novo" outcome="/fabricante/CadastroFabricante"/>
    			</p:toolbarGroup>
    		</p:toolbar>
    	
	    	<p:dataTable id="fabricantesTable" value="#{pesquisaFabricanteBean.fabricantes}" var="fabricante"
		    		style="margin-top: 20px" emptyMessage="Nenhum fabricante encontrado." rows="20"
		    		paginator="true" paginatorAlwaysVisible="false" paginatorPosition="bottom">
		    		<p:column headerText="Código" style="text-align: center; width: 100px">
		    			<h:outputText value="#{fabricante.codigo}" />
		    		</p:column>
		    		<p:column headerText="Nome">
		    			<h:outputText value="#{fabricante.nome}" />
		    		</p:column>
		    		<p:column style="width: 100px; text-align: center">
		    			<p:button outcome="CadastroFabricante" icon="ui-icon-pencil" title="Editar">
		    				<f:param name="fabricante" value="#{fabricante.codigo}"/>
		    			</p:button>
		    			<p:commandButton icon="ui-icon-trash" title="Excluir" oncomplete="PF('confirmacaoExclusao').show()"
								process="@this" update=":frmPesquisa:confirmacaoExclusaoDialog">
							<f:setPropertyActionListener target="#{pesquisaFabricanteBean.fabricanteSelecionado}" value="#{fabricante}" />
						</p:commandButton>
		    		</p:column>
		    </p:dataTable>
		    
		    <p:confirmDialog id="confirmacaoExclusaoDialog" widgetVar="confirmacaoExclusao"
	        		message="Tem certeza que deseja excluir o fabricante #{pesquisaFabricanteBean.fabricanteSelecionado.nome}?"  
	                header="Exclusão de fabricante" severity="alert">
	        	<p:button value="Não" onclick="PF('confirmacaoExclusao').hide(); return false;" />
	        	<p:commandButton value="Sim" update=":frmPesquisa:fabricantesTable"
	        			oncomplete="PF('confirmacaoExclusao').hide()" action="#{pesquisaFabricanteBean.excluir}" />
	    	</p:confirmDialog>
	    </h:form>
    </ui:define>
</ui:composition>


e agora, criar uma classe com o nome PesquisaFabricanteBean, no pacote controller

PesquisaFabricanteBean.java

package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.modelo.Fabricante;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesMessages;

@Named
@ViewScoped
public class PesquisaFabricanteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FabricanteDAO fabricanteDAO;
	
	private List<Fabricante> fabricantes;
	
	private Fabricante fabricanteSelecionado;
	
	@Inject
	private FacesMessages facesMessages;
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	
	public void excluir() {
		try {
			fabricanteDAO.excluir(fabricanteSelecionado);
			this.fabricantes.remove(fabricanteSelecionado);
			facesMessages.info("Fabricante " + fabricanteSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}
	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}
	
//	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}
}


E agora, no FabricanteDAO, devemos adicionar os métodos :

	public List<Fabricante> buscarTodos() {
		//JPQL
		return em.createQuery("from Fabricante", Fabricante.class).getResultList();
	}

e o de excluir

@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException {
		try {
			//o objeto precisa estar gerenciado no entitymanager
			Fabricante fabricanteTemp = this.buscarPeloCodigo(fabricante.getCodigo());
		
			em.remove(fabricanteTemp);
			em.flush();//execute neste momento o commit
		} catch (PersistenceException e) {
			throw new NegocioException("Fabricante não pode ser excluído.");
		}
	}

e o método auxiliar

public Fabricante buscarPeloCodigo(Long codigo) {
		return em.find(Fabricante.class, codigo);
	}

e pronto.

importante: lembre-se sempre da transação.


4.4. Implementando a edição

Para podermos fazer a edição, passamos o código do fabricante para o bean. 
Ao passar o código, o sistema deverá ir no banco e recuperar o fabricante, mas para isso, precisamos de um converter.

Para criar o converter, no pacote converter, criamos a classe FabricanteConverter

FabricanteConverter.java

package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;

@FacesConverter(forClass = Fabricante.class)
public class FabricanteConverter implements Converter {

	@Inject
	private FabricanteDAO fabricanteDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Fabricante retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.fabricanteDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Fabricante) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}


e no FabricanteDAO, criar o método buscarPeloCodigo() que será onde vamos utilizar o find().

ao salvar o fabricante, após a edição, o fabricante está detached do entitymanager, devemos utilizar o método merge. O merge sabe como pegar a entidade detached e colocá-la novamente no escopo gerenciador do entitymanager.

logo, o método salvar(fabricante fabricante) deve utilizar o merge em vez do persist.

mesmo sendo uma nova entidade, o merge sabe como tratar o objeto e persiste no banco de dados.
4.5. Mapeando a Primary Key
ao anotar um atributo como @Id, estamos mapeando o atributo para ser o identificador único da tabela.

podemos usar também a anotação @Column(name=”xxxxx”) para que o nome na tabela seja o inserido na anotação. mas sem a anotação, o nome do atributo é utilizado como nome da tabela.

os tipos do atributo que queremos que seja a id da tabela podem ser:
primitivos: byte, int, short, long, char
Wrappers: Byte, Integer, Short, Long e Character
String
e ainda java.math.BigInteger ou java.util.Date

não é recomendado utilizar os tipos float, double ou BigDecimal

a anotação @GeneratedValue(strategy=GenerationType.IDENTITY).
existem 4 strategies para a geração do generatedValue:

AUTO, TABLE, SEQUENCE e IDENTITY

IDENTITY ou autogeração, quando o banco de dados suporta, o autoincrement do mysql cria automaticamente o número do id.

SEQUENCE, quando o banco de dados suporta, é necessário definir o nome da sequence.

TABLE é a forma mais portável que existe, pois funciona praticamente em todos os bancos de dados.
como funciona? ela cria uma tabela no banco de dados que armazena o valor das primary keys. 

AUTO de automático. Que deixa o JPA escolher a melhor forma entre as outras. Não é comum pois você não sabe como será gerado.


O mais comum é SEQUENCE para Oracle e IDENTITY para MySQL.

4.6. Exercício: Mapeando a Primary Key
Como vimos nas últimas aulas, temos algumas possibilidades de mapeamento da Primary Key. Especialmente em como podemos gerar o valor para este ID.
Temos quatro estratégias de geração do valor da Primary Key, são elas: AUTO, TABLE, SEQUENCE e IDENTITY. Nem todas são suportadas por todos os banco de dados, você irá aprender à medida que for conhecendo e testando estas opções nos banco de dados que trabalhar.

Para o MySQL a forma mais comum de mapeamento é usando IDENTITY, pois irá usar o AUTO INCREMENTO. 

No Oracle SEQUENCE é uma estratégia bastante comum também.

Se você precisar mapear uma SEQUENCE, é necessário informar o nome dela no mapeamento, veja abaixo como ficaria o mapeamento.

@Id
@SequenceGenerator(name="gerador", sequenceName="NOME_SEQUENCE_NO_BANCO")
@GeneratedValue(generator="gerador", strategy=GenerationType.SEQUENCE)
private Long codigo;


Agora é hora de você fazer alguns testes e aprender o que o irá acontecer no banco de dados. Vamos utilizar a estratégia TABLE na entidade Fabricante.

* DICA: Delete suas tabelas à medida que ver a necessidade de se observar um comportamento novo no banco de dados.

Para isso a forma mais simples e o seu primeiro teste é mapear a Primary Key como abaixo. Você irá reparar que uma nova tabela foi criada no banco de dados com o nome padrão (Na versão que estou utilizando o nome foi hibernate_sequences).

@Id
@GeneratedValue(strategy=GenerationType.TABLE)
private Long codigo;


Salve um novo fabricante no sistema utilizando a interface web. Repare que o código foi gerado corretamente.

Agora consulte a tabela hibernate_sequences (select * from hibernate_sequences), repare que ela tem duas colunas - sequence_name e sequence_next_hi_value.

A primeira coluna é o nome da entidade, no nosso caso Fabricante. Perceba que se nós utilizarmos essa estratégia (TABLE) em outras entidades, o que irá acontecer é uma nova entrada para cada tabela mapeada dessa maneira.

Agora tem um segredo com esse mapeamento que nós iremos desvendá-lo agora. Salve mais 5 fabricantes utilizando sempre a interface web.

Se você consultar a tabela fabricante, verá que todos os códigos foram gerados corretamente. Agora faça uma consulta na hibernate_sequences.

Ficou confuso? Porque ainda está 1 no sequence_next_hi_value?

O segredo é que o Hibernate não irá toda vez no banco de dados buscar qual é o próximo valor, ele simplesmente faz uma alocação (pega uma determinada quantidade por vez).

Quer entender um pouco melhor, para o Apache Tomcat dentro do eclipse e inicie novamente. 

ATENÇÃO: agora não apague nada no banco de dados, deixe ele como está.

Salve um novo fabricante. Pesquise e veja se ele foi inserido. Qual é o código gerado para ele?
O que!?!?

Agora faça uma consulta na tabela hibernate_sequences. Ficou mais confuso ainda?

Vamos a explicação. O Hibernate irá fazer apenas uma consulta para essa tabela e irá alocar uma quantidade de códigos em memória. Quando esses códigos terminarem que ele volta no banco, mas não para saber qual é o próximo código, mas sim para saber qual é o próximo montante que ele tem que pegar. Vou explicar isso melhor agora.

Vamos alterar algumas propriedades deste mapeamento para deixá-lo mais customizado. Agora é uma boa hora de apagar as tabelas do schema locadora.

Veja o código abaixo.
@Id
@TableGenerator(name="fabricante_generator", table="GERADOR_CODIGO", pkColumnName="ENTIDADE", 
valueColumnName="ALOCACAO", allocationSize=5)
@GeneratedValue(generator="fabricante_generator", strategy=GenerationType.TABLE)
private Long codigo;


Com a anotação @TableGenerator eu consigo customizar esta tabela de códigos. Repare acima que além de trocar o nome da tabela e das colunas eu consigo dizer o tamanho da alocação.
Neste caso reduzi para 5, significando que ele fará alocações de 5 em 5. Faça agora vários testes. Insira 6 fabricantes. Pare o Tomcat, inicie novamente. Qual o valor do código gerado? Use sua imaginação, crie, delete, apague as tabelas, etc. O importante é se divertir e aprender. 


4.7. Identidade de um objeto - equals() e hashCode()

o override do equals() e do hashcode() é controverso mas tentaremos explicar de uma forma que é bem implementada.

quando temos uma tabela, no caso Fabricante, temos a primary key sendo o código (id). 

se perguntarmos quando dois fabricantes são iguais? quando a primary key é a mesma.

mas no java, com instâncias, quando que dois fabricantes serão iguais? se não alteramos o equals() e o hashcode(), no java, e com instâncias, elas serão iguais quando ocuparem o mesmo espaço de memória.

exemplo:
Fabricante f1 = new Fabricante();
f1.setCodigo(1L);

Fabricante f2 = new Fabricante();
f2.setCodigo(2L);

System.out.println(“f1.equals(f2)? ” + f1.equals(f2);

a resposta é falso, pois cada new Fabricante utiliza espaços de memória diferente.

mas e se alterarmos o f2:
Fabricante f2 = new Fabricante();
f2.setCodigo(1L);

System.out.println(“f1.equals(f2)? ” + f1.equals(f2);

continua imprimindo falso, pelo mesmo motivo.

mas e se alterarmos o f2:
Fabricante f2 = f1;
f2.setCodigo(12L);

System.out.println(“f1.equals(f2)? ” + f1.equals(f2);

imprime true! porque o f1 e f2 apontam para o mesmo espaço de memória.

então o que precisamos fazer para que não seja comparado o espaço de memória e sim os atributos dos objetos? precisamos implementar um override no equals() e no hashcode();

o hashcode auxilia na busca hash, tornando-a mais rápida.

o eclipse tem um auxílio para ajudar a criar o equals() e o hashcode():
source > generate hashcode() e equals()

um wizard aparece e você seleciona os campos e o eclipse cria os overrides necessários.


4.8. Relacionamento Muitos-Para-Um
Exemplo, o ModeloCarro tem um fabricante, mas um fabricante tem varios modelosCarro.
Vendo pela perspectiva do ModeloCarro, a leitura é muitos(modelo de carro) para um (fabricante).

Entao, no ModeloCarro, representamos assim:

no getter do fabricante (ou no atributo), colocamos a anotação @ManyToOne   (@ManyToOne(argumentos))

Existem muitas opções para serem inseridas nos argumentos da anotação, que serão abordadas mais para frente.

IMPORTANTE: na camada de visão, ao selecionarmos o fabricante, o converter será acionado (para converter em objeto e em string). O que acontece é que ele irá comparar os objetos (selecionado e o do banco) usando o equals(). Só que, neste momento, o equals é o padrão do Object, logo ele irá comparar localização de memória em vez de comparar o id. Então, devemos neste momento, implementar o equals e o hashcode nas entidades.


4.9. Mais do mapeamento Muitos-Para-Um
Já vimos como é simples criar um mapeamento Muitos-Para-Um com a anotação @ManyToOne.
Agora vamos fazer alguns exercícios para aprender um pouco mais desse mapeamento?
Você deve ter percebido que quando colocamos apenas @ManyToOne sobre o Fabricante, a coluna gerada na tabela modelocarro tem o nome de fabricante_codigo. Mas, se você quiser trocar esse nome? Ou talvez um DBA já tenha criado o banco de dados e nome da coluna é diferente, como trocamos esse nome?
É bem simples, será?
Nós iremos adicionar outra anotação @JoinColumn. A propriedade "name" irá definir o nome da coluna gerada.
Vamos definir o nome da coluna em português, deixando "codigo_fabricante". Deixe o seu mapeamento como abaixo. Se o Tomcat estiver iniciado, pare e inicie novamente.
@ManyToOne
@JoinColumn(name="codigo_fabricante")
public Fabricante getFabricante() {
  // ...


Veja o que aconteceu com sua tabela no banco de dados. Estranho, não?
O problema é que o Hibernate não irá simplesmente alterar o nome da coluna "fabricante_codigo". Ele irá criar outra coluna, no caso, "codigo_fabricante" e deixará de usar a primeira coluna.
Fica uma dica importante: cuidado ao fazer alterações em mapeamentos do banco de dados quando seu sistema já está funcionando! No nosso caso, já havíamos feito testes com o Modelo de Carro usando a interface, então alterar o modelo pode atrapalhar todo o funcionamento do sistema.
Como ainda estamos em fase de testes e não em produção, podemos simplesmente apagar a tabela modelocarro, ou apagar as linhas que o código_fabricante está nulo ou até fazer a migração dos valores da coluna "fabricante_codigo" para "codigo_fabricante".
Fique a vontade para tentar fazer qualquer uma dessas alterações e ficando com alguma dúvida, é só perguntar.

4.10. Relacionamento Muitos-Para-Muitos
O relacionamento muitos para muitos é simples. Vamos utilizar o exemplo do carro e de acessórios.

Um carro pode ter muitos acessórios, mas um acessório também pode pertencer a vários carros diferentes. (ex. Ar condicionado)

Então, no banco de dados será criada uma tabela relacional, entre a tabela do carro e a de acessórios, onde será guardada somente o id do carro, com o id do acessório.

a anotação é @ManyToMany(atributos)

Como estamos mapeando em carro, Carro receberá uma lista de objetos.

O Acessório não terá conhecimento dos carros, somente os carros terão a lista de acessórios.


4.11. Mapeando Muitos-Para-Muitos
Vamos aprender um pouco mais sobre o relacionamento muitos-para-muitos?
Você viu que o mapeamento é feito utilizando a anotação @ManyToMany do pacote javax.persistence.
Vimos também que a tabela gerada entre Carro e Acessorio foi carro_acessorio, com as chaves estrangeiras Carro_codigo e acessorios_codigo.
Como já é normal e você já deve ter percebido, no JPA conseguimos customizar esses nomes.
Vamos então adicionar a anotação @JoinTable do pacote javax.persistence.
As propriedades que vamos ver agora são "name", "joinColumns" e "inverseJoinColumns".
"Name" irá definir o nome da tabela que faz o relacionamento. Se você quiser trocar para fazer um teste, fique a vontade. Mas lembre-se, alterar o modelo depois de testes iniciados, significam comportamentos estranhos. Então fique atento para fazer a migração dos dados ou até apagar todas as tabelas e começar novamente. :)
A propriedade "joinColumns" recebe um array de @JoinColumn. Array? Será que você leu errado?
Não é isso mesmo, pois se tivermos um relacionamento com chaves compostas, teríamos que usar mais de uma @JoinColumn. Mas isso é assunto para vermos em outro momento, vamos com calma agora.
Voltando ao "joinColumns", essa propriedade então irá definir a coluna de mapeamento entre a tabela de relacionamento (no nosso caso carro_acessorio) e a tabela que está implementando o relacionamento (neste caso Carro). Vamos colocar um nome mas em português também, trocando para "codigo_carro". Veja abaixo como está até agora.
@JoinTable(name="carro_acessorio"
    , joinColumns=@JoinColumn(name="codigo_carro"))
public List<Acessorio> getAcessorios() {
  // ...


A última propriedades que iremos ver aqui é a "inverseJoinColumns", que também recebe um array de @JoinColumn. Se "joinColumn" é a coluna que faz o mapeamento para Carro, "inverseJoinColumns" irá configurar a propriedade no sentido inverso, ou seja para Acessório. Vamos também trocar o nome da column para "codigo_acessorio".
O código final ficará como abaixo.
@JoinTable(name="carro_acessorio"
    , joinColumns=@JoinColumn(name="codigo_carro")
    , inverseJoinColumns=@JoinColumn(name="codigo_acessorio"))
public List<Acessorio> getAcessorios() {
  // ...





4.12. Relacionamento Um-Para-Um
O mapeamento um para um é igual ao que fizemos anteriormente. agora vamos criar um novo aluguel e uma apólice de seguro. Ou seja, quando cadastrar um aluguel ele terá a apólice de seguro.

A apólice de seguro é um bean simples.

Opcionalmente, podemos alterar o nome da tabela, usando o @Table(name=”tb_apolice_seguro”).
Desta forma, a tabela será criada com o nome passado no parâmetro e não no nome padrão.

Neste mapeamento, somente aluguel terá o relacionamento para a apólice de seguros. A apólice não terá conhecimento do aluguel.

No mapeamento da apólice de seguro usamos:
@OneToOne(cascade=CascadeType.ALL)

Se na anotação não colocarmos o cascade, teremos que salvar primeiro a apólice (criar o DAO, etc, etc). Se utilizarmos o cascade, o framework faz isso para nós.

Os outros tipos do cascade são: ALL, DETACHED, MERGE, PERSIST, REFRESH e REMOVE.
para utilizá-los, devemos colocar o CascadeType dentro de {}, ex: @OneToOne({cascade=CascadeType.PERSIST, CascadeType.MERGE)



4.13. Mapeamento Um-Para-Um
Você viu o poder da propriedade "cascade" na anotação @OneToOne. Agora vamos ver outra alternativa, criando o DAO da Apólice de Seguro . Assim nós iremos salvar primeiro a Apólice antes de salvar o Aluguel.
Primeiro vamos remover a propriedade "cascade" do @OneToOne. Deixando como abaixo.
@OneToOne
@JoinColumn(name="codigo_apolice_seguro")
public ApoliceSeguro getApoliceSeguro() {
  // ...


Agora crie o DAO ApoliceSeguroDAO.
package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.modelo.ApoliceSeguro;

public class ApoliceSeguroDAO implements Serializable {

    private static final long serialVersionUID = 1L;
	
    @Inject
    private EntityManager manager;
	
    public void salvar(ApoliceSeguro apoliceSeguro) {
        manager.persist(apoliceSeguro);
     }

}


Onde você acharia melhor salvar a Apólice, no método salvar de CadastroAluguelService ou em AluguelDAO? Eu sei que isso pode ser complicado de decidir, qualquer uma das respostas estará certa, irá funcionar!
Eu preferiria deixar no DAO pois faz parte de como decidimos implementar nosso mapeamento e essa é uma operação de banco de dados e não faz parte das regras de negócio. Portanto, vamos editar a classe AluguelDAO.
Primeiro precisamos injetar a ApoliceSeguroDAO.
@Inject
private ApoliceSeguroDAO apoliceSeguroDAO;


Depois editar o método salvar, para antes de salvar o aluguel, persistirmos a apólice.
public void salvar(Aluguel aluguel) {
    apoliceSeguroDAO.salvar(aluguel.getApoliceSeguro());
    manager.merge(aluguel);
}


E ai, qual abordagem você prefere? Na verdade não é questão de escolha mas sim de sabedoria (gastei, hein?!). Vão existir situações que utilizar o DAO vai ser a melhor opção, pois você pode querer ter mais controle de como salvar seu objeto!
Um detalhe importante, esse código só estará disponível nesta aula. Para continuar com o projeto, utilizarei a propriedade cascade.

4.14. Relacionamento Um-Para-Muitos
Agora vamos trabalhar entre aluguel e carro.

O aluguel possui um carro e um carro tem vários alugueis. Um para muitos.

Isso significa que em aluguel terá uma coluna setando o carro referente ao aluguel.

E o contrário também é possível. Se quisermos saber, quando estamos com o objeto Carro, quais Aluguéis já foram feitos com ele, podemos mapear, só que neste caso, em uma lista.

Para mapear o carro no aluguel usamos a anotação @manyToOne e a @joinColumn(name=”codigo_carro)

Porque se lermos, existem vários alugueis para um carro.

Agora, em Carro, para mapear os Aluguéis, teremos que ter uma lista de aluguéis.

e o mapeamento dessa lista vai ser:
@OneToMany(mappedBy=”carro”)

É uma boa prática falar que o mapeamento foi mapeado na classe aluguel
@OneToMany(mappedBy=”nome_atributo_java”)


4.16. Camada de persistência
Agora que já vimos muita coisa sobre Mapeamento Objeto-Relacional (ORM), o que acha de tentar criar a camada de persistência (Modelo e DAO) de um sistema novo?
Abaixo está a descrição de um sistema simples de matrícula, mas com alguns relacionamentos para você praticar.
O sistema deve permitir o CRUD de um Aluno. Este possui um nome e um número de matrícula.
Também devemos ter um professor que irá ministrar um curso, que possui um nome e sua especialidade (por exemplo, Banco de Dados, programação, etc)
E claro que precisamos de uma turma. Uma turma possui uma descrição da sala (ex: B03).
Até aqui parece simples, não? Mas ainda não acabou.
Uma turma possui vários alunos e um aluno pode estar matriculado em várias turmas. No momento da matrícula, você deve armazenar uma observação referente ao pagamento do aluno, por exemplo: "parcelado em 2 vezes", "pagamento à vista", etc.
Se você pensou que teremos uma tabela matrícula e que essa tabela faz o relacionamento entre os alunos e a turma, parabéns, você está indo bem!
Mas como vamos fazer isso? Simples, o relacionamento Muitos-Para-Muitos pode ser quebrado em Um-Para-Muitos e Muitos-Para-Um!
Pense comigo: Um aluno pode fazer várias matrículas, mas uma matrícula é de apenas um aluno. Portanto de Aluno para Matrícula teremos um mapeamento Um-Para-Muitos.
Agora uma matrícula é feita em apenas uma turma, mas uma turma pode ter várias matrículas. Então de Matrícula para Turma é Muitos-Para-Um.
Gostou do desafio? Faça-o com calma e se possível crie classes de testes (da forma como fizemos no início do curso) para testar e verificar o que está acontecendo no banco de dados.

5.1. Inicialização Tardia (lazy-loading) e Ansiosa (eager-loading)
Lazy loading significa que o sistema não irá buscar as entidades marcadas como lazy quando fizer um select da entidade principal. 
Eager loading significa que o sistema irá buscar as entidade marcadas como eager toda vez que fizer um select da entidade principal. Este comportamento pode afetar a performance da aplicação.

O método default de loading da anotação @ManyToMany é lazy.

Então para exemplificar, usaremos a classe Carro, que tem uma lista de Acessório.

O comportamento que pretendemos é: ao listar os carros, a lista de acessórios não deve ser carregada.
Ao clicar no botão para exibir acessórios, o sistema deve ir no banco e recuperar o carro com os acessórios (somente o clicado).
Se não anotarmos nada, na anotação @ManyToMany será usado o tipo default, que é lazy loading.

Então, ao acrescentarmos o lazy loading no carro, para obtermos os acessórios, devemos fazer o select do carro com um join no atributo do acessório.

select c from Carro c join c.acessórios

5.2. Mapeando enumerações
Para mapear um enum (enumeration) é muito fácil. O enum é uma ‘classe’ de constantes imutáveis.

Como exemplo, vamos utilizar o enum de ‘categoria’ para o modelo de carro.

Para converter os valores do enum como lista, utiliza-se o Arrays.asList(Categoria.values())

A anotação que deve ser utilizada para mapear um enum é a @Enumerated(EnumType.XXXXX)

O EnumType pode ser STRING ou ORDINAL. Se escolhermos STRING ele irá gravar o valor do enum (O QUE ESCREVEMOS COM MAIÚSCULAS). Se escolhermos o ORDINAL, ele irá gravar o índice do enum que escolhermos, com base 0.

Enum no Java
São tipos de campos que consistem em um conjunto fixo de constantes (static final), sendo como uma lista de valores pré-definidos. Na linguagem de programação Java, pode ser definido um tipo de enumeração usando a palavra chave enum.
Todos os tipos enums implicitamente estendem a classe java.lang.Enum, sendo que o Java não suporta herança múltipla, não podendo estender nenhuma outra classe.
Características dos tipos enum
Em relação às propriedades é preciso tomar os seguintes cuidados:
As instâncias dos tipos enum são criadas e nomeadas junto com a declaração da classe, sendo fixas e imutáveis (o valor é fixo).;
Não é permitido criar novas instâncias com a palavra chave new;
O construtor é declarado private, embora não precise de modificador private explícito;
Seguindo a convenção, por serem objetos constantes e imutáveis (static final), os nomes declarados recebem todas as letras em MAIÚSCULAS;
As instâncias dos tipos enum devem obrigatoriamente ter apenas um nome;
Opcionalmente, a declaração da classe pode incluir variáveis de instância, construtor, métodos de instância, de classe, etc.
Declaração Enum
Na declaração é definida uma classe chamada de tipo enum. O corpo da classe enum pode incluir métodos e outros campos. O compilador automaticamente adiciona alguns métodos especiais quando se cria um enum.
Inicializando valores
Para iniciar os valores declarados dentro das variáveis Enum, é preciso declarar um construtor para iniciar os seus atributos que são declarados.
Listagem 2: Declarar valor Enum
public enum CartasEnum {
    J(11),Q(12),K(13),A(14);

    public int valorCarta;
    CartasEnum(int valor) {
        valorCarta = valor;
    }
}


Como mostrado na Listagem 2 inicializamos o construtor com apenas um argumento, o que corresponde ao mesmo número de argumentos declarados nos atributos. Pode ser possível declarar com mais argumentos, basta declarar suas variáveis com seus tipos e inicializar dentro do construtor.
Percorrendo Valores
Os valores Enum tem um método estático chamado values< que retorna uma matriz contendo todos os valores do enum na ordem em que são declarados. Este método é normalmente usado em combinação com o for para construir cada repetição dos valores de um tipo de enumeração.
Neste exemplo é percorrido o tipo Enum feitos na Listagem 3.
Listagem 7: Percorrendo Valor
public class TestadoraEnum {    
    public static void main(String[] args) {
for(OpcoesMenu op : OpcoesMenu.values()){
            System.out.print("Menu " + op + " = " + op.getValor()+"\n");
}
    }
}
Comparando Valores Enum
Um Enum pode ser comparado com outro objeto através do método equals.
Na Listagem 8 declaramos o método comparaEnum do tipo static para ser acessível para toda a classe e fazer referência ao tipo Enum declarado.
Nos tipos Enum também existem outros métodos descritos abaixo.
String toString(): retorna uma String com o nome da instância (em maiúsculas).
valueOf (String nome) – retorna o objeto da classe enum cujo nome é a string do argumento.
int ordinal(): retorna o número de ordem do objeto na enumeração.


5.3. Mapeando datas
mapear datas é bem simples.

Para evitar conflitos com outros frameworks, é recomendável sempre utilizar o java.util.Date ou java.util.Calendar.

Existem outras classes de data, como os java.sql.Date, java.sql.Time e java.sql.Timestamp, mas outros frameworks não aceitam esses tipos de data.

Para anotar um campo como data, utilizamos a anotação @Temporal(TemportalType.XXXXXX)

O TemporalType pode ser DATE para somente a data e TIMESTAMP, para data/hora

5.4. Mapeando herança com tabela única
neste exemplo iremos ver como funciona o mapeamento com herança. basicamente é isto: temos um motorista, que é uma pessoa. existem 2 classes, Motorista e Pessoa.

existem várias maneiras de se fazer este mapeamento, cada um com suas vantagens e desvantagens.

então neste exemplo, a classe motorista extends pessoa.

Pessoa será uma entidade comum, com alguns pontos diferenciados (todas as anotações comuns de entidade):
a classe será abstract
@Inherirance(strategy=InheritanceType.SINGLE_TABLE) (estrategia de tabela unica, ou seja, nao serao criados outras tabelas e esta terá uma coluna inserida pelo JPA, que terá o tipo de objeto que está inserido, que é definida em outra anotação)
@DiscriminatorColumn(name=”TIPO_PESSOA”, discriminatorType=DiscriminatorType.STRING)

Motorista deverá estender Pessoa e terá seus próprios atributos. ela receberá:
@Entity
@DiscriminatorValue(“MOTORISTA”)

desta forma, será criada somente a tabela pessoa, com todas as informações necessárias, incluindo a coluna que só existe em Motorista (ou de qualquer outra entidade que estendeu de Pessoa).

5.5. Mapeando herança com Joined
Quer aprender outra forma de mapear herança? A segunda opção que temos é usando a estratégia "Joined".
Nesta estratégia cada entidade terá sua própria tabela. Parece que faz mais sentido, não é verdade? O modelo no banco irá ficar mais organizado (normalizado), pois não teremos colunas extras e nem valores nulos.
O maior problema é que fica complicado para o Hibernate fazer os INSERTs e os SELECTs, o que deixa um pouco mais lento. E também o banco de dados, que irá fazer JOIN entre as tabelas, fazendo as consultas serem um pouco mais lentas também.
Mas se isso não for um problema para você, vamos aprender a fazer!
Antes de mais nada, te aconselho a apagar a tabela "pessoa" do banco de dados, pois os dados que já estão salvos, poderão te confundir um pouco.
Vamos começar na nossa classe Pessoa. Alterando a estratégia para JOINED. E o tipo do discriminador para INTEGER. Veja:
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TIPO_PESSOA", discriminatorType=DiscriminatorType.INTEGER)
public abstract class Pessoa {
  //...


Agora na classe Motorista, vamos colocar um valor inteiro (mesmo que esteja entre aspas duplas) para representar um motorista na anotação @DiscriminatorValue. Veja:
@Entity
@DiscriminatorValue("1")
public class Motorista extends Pessoa {
  //...


Pronto! Inicie o Tomcat e faça o cadastro de um Motorista.
Dê uma olhada nas duas tabelas criadas no banco de dados.
Repare que a tabela "pessoa" tem código, cpf, data_nascimento e nome. E a tabela "motorista" tem o numeroCNH e um código.
Não viu nada nas tabelas relacionados ao TIPO_PESSOA nas tabelas? Isso porque o Hibernate não precisa deles mas, pode ser que algum outro framework utilize, então deixe lá, não irá te incomodar muito, não é? :)
O detalhe mais importante que temos que observar é o código na tabela motorista. Ele é uma chave estrangeira (foreign key) para a tabela pessoa.
Se você entrar na tela de consulta, e olhar os logs gerados pelo Hibernate no console do eclipse, irá ver o select sendo feito com join entre a tabela pessoa e motorista.
O que achou dessa forma de mapeamento? Implementar é fácil, não é verdade?
Qual estratégia você gostou mais? Usando "JOINED" ou "SINGLE_TABLE"?
Ainda existem outras formas que iremos ver ao longo do curso. Fique tranquilo que não acabou. ;)

5.6. Cadastro de funcionário
Será que com tudo que já vimos você poderia me ajudar e terminar o cadastro de Funcionário?
Vou deixar abaixo o código das páginas JSF, dos Managed Beans e do converter. Fica para você fazer a entidade Funcionário, o serviço e o DAO. Combinado?
Qualquer dúvida você pode me perguntar ou até pegar o código no GitHub, mas te aconselho perguntar primeiro se tiver algum problema, ok?
Boa sorte!
DICA: Sempre que copiar e colar um código, ou mesmo quiser dar uma organizada na indentação, utilize o atalho do eclipse: Ctrl+Shif+F
As páginas JSF ficarão dentro de "src/main/webapp/" na pasta "funcionario".
Segue abaixo a página CadastroFuncionario.xhtml

<ui:composition template="/WEB-INF/template/LayoutPadrao.xhtml"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:p="http://primefaces.org/ui"
    xmlns:o="http://omnifaces.org/ui">

    <ui:define name="titulo">Novo funcionário</ui:define>
    
    <ui:define name="corpo">
    	<f:metadata>
			<o:viewParam name="funcionario" value="#{cadastroFuncionarioBean.funcionario}" />
		</f:metadata>
    
    	<h1>Novo funcionário</h1>
    	
    	<h:form id="frmCadastro">
    		<p:messages id="messages" autoUpdate="true" closable="true" />
    	
	    	<p:toolbar style="margin-top: 20px">
	    		<p:toolbarGroup>
	    			<p:commandButton value="Salvar" id="botaoSalvar" action="#{cadastroFuncionarioBean.salvar}" update="frmCadastro"/>
	    		</p:toolbarGroup>
	    		<p:toolbarGroup align="right">
					<p:button value="Pesquisa" outcome="/funcionario/PesquisaFuncionarios"/>
				</p:toolbarGroup>
	    	</p:toolbar>
	    	
	    	<p:panelGrid columns="2" id="painel" style="width: 100%; margin-top: 20px"
	    			columnClasses="rotulo, campo">
	    		<p:outputLabel value="Código" for="codigo"/>
	    		<p:inputText id="codigo" size="20" maxlength="20" value="#{cadastroFuncionarioBean.funcionario.codigo}" readonly="true"/>
	    		
	    		<p:outputLabel value="Nome" for="nome"/>
	    		<p:inputText id="nome" size="60" maxlength="80" value="#{cadastroFuncionarioBean.funcionario.nome}"/>
	    		
	    		<p:outputLabel value="Data de nascimento" for="dataNascimento"/>
	    		<p:calendar id="dataNascimento" size="20" value="#{cadastroFuncionarioBean.funcionario.dataNascimento}" pattern="dd/MM/yyyy"/>
	    		
	    		<p:outputLabel value="CPF" for="cpf"/>
	    		<p:inputText id="cpf" size="20" maxlength="20" value="#{cadastroFuncionarioBean.funcionario.cpf}"/>
	    		
	    		<p:outputLabel value="Matrícula" for="matricula"/>
	    		<p:inputText id="matricula" size="20" maxlength="20" value="#{cadastroFuncionarioBean.funcionario.matricula}"/>
	    	</p:panelGrid>
    	</h:form>
    </ui:define>
</ui:composition>


A tela de pesquisa - PesquisaFuncionarios.xhtml
<ui:composition template="/WEB-INF/template/LayoutPadrao.xhtml"
    xmlns="http://www.w3.org/1999/xhtml"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:p="http://primefaces.org/ui">

    <ui:define name="titulo">Pesquisa de Funcionário</ui:define>
    
    <ui:define name="corpo">
    	<h1>Pesquisa de Funcionário</h1>
    	
    	<h:form id="frmPesquisa">
    		<p:messages id="messages" autoUpdate="true" closable="true" />
    		
    		<p:toolbar style="margin-top: 20px">
    			<p:toolbarGroup>
    				<p:commandButton value="Novo" id="botaoNovo" action="/funcionario/CadastroFuncionario.xhtml"/>
    			</p:toolbarGroup>
    		</p:toolbar>
    	
	    	<p:dataTable id="funcionariosTable" value="#{pesquisaFuncionarioBean.funcionarios}" var="funcionario"
		    		style="margin-top: 20px" emptyMessage="Nenhum funcionário encontrado." rows="20"
		    		paginator="true" paginatorAlwaysVisible="false" paginatorPosition="bottom">
		    		<p:column headerText="Código" style="text-align: center; width: 100px">
		    			<h:outputText value="#{funcionario.codigo}" />
		    		</p:column>
		    		<p:column headerText="Nome">
		    			<h:outputText value="#{funcionario.nome}" />
		    		</p:column>
		    		<p:column headerText="Data de nascimento">
		    			<h:outputText value="#{funcionario.dataNascimento}" />
		    		</p:column>
		    		<p:column headerText="CPF">
		    			<h:outputText value="#{funcionario.cpf}" />
		    		</p:column>
		    		<p:column headerText="Matrícula">
		    			<h:outputText value="#{funcionario.matricula}" />
		    		</p:column>
		    		<p:column style="width: 100px; text-align: center">
		    			<p:button outcome="CadastroFuncionario" icon="ui-icon-pencil" title="Editar">
		    				<f:param name="funcionario" value="#{funcionario.codigo}"/>
		    			</p:button>
		    			<p:commandButton icon="ui-icon-trash" title="Excluir" oncomplete="confirmacaoExclusao.show()"
								process="@this" update=":frmPesquisa:confirmacaoExclusaoDialog">
							<f:setPropertyActionListener target="#{pesquisaFuncionarioBean.funcionarioSelecionado}" value="#{funcionario}" />
						</p:commandButton>
		    		</p:column>
		    </p:dataTable>
		    
		    <p:confirmDialog id="confirmacaoExclusaoDialog" widgetVar="confirmacaoExclusao"
	        		message="Tem certeza que deseja excluir o funcionario #{pesquisaFuncionarioBean.funcionarioSelecionado.nome}?"  
	                header="Exclusão de funcionario" severity="alert">
	        	<p:button value="Não" onclick="confirmacaoExclusao.hide(); return false;" />
	        	<p:commandButton value="Sim" update=":frmPesquisa:funcionariosTable"
	        			onclick="confirmacaoExclusao.hide()" action="#{pesquisaFuncionarioBean.excluir}" />
	    	</p:confirmDialog>
	    </h:form>
    </ui:define>
</ui:composition>



Para você adicionar o caminho da página de pesquisa ao menu de navegação. Edite o arquivo LayoutPadrao.xhtml em "src/main/webapp/WEB-INF/template/" e procure o elemento e deixe-o como abaixo:

<p:menuitem value="Funcionário" outcome="/funcionario/PesquisaFuncionarios.xhtml" />



Agora vamos a parte Java. Primeiro o Converter de Funcionário (FuncionarioConverter.java).

package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Funcionario.class)
public class FuncionarioConverter implements Converter {

	private FuncionarioDAO funcionarioDAO;
	
	public FuncionarioConverter() {
		this.funcionarioDAO = CDIServiceLocator.getBean(FuncionarioDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario retorno = null;

		if (value != null) {
			retorno = this.funcionarioDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Funcionario) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}


Agora o managed bean de cadastro (CadastroFuncionarioBean.java).

package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.CadastroFuncionarioService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Funcionario funcionario;
	
	@Inject
	private CadastroFuncionarioService cadastroFuncionarioService;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
	}
	
	public void salvar() {
		try {
			this.cadastroFuncionarioService.salvar(funcionario);
			FacesUtil.addSuccessMessage("Funcionário salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}


E o managed bean de consulta (PesquisaFuncionarioBean.java).

package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FuncionarioDAO;
import com.algaworks.curso.jpa2.modelo.Funcionario;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FuncionarioDAO funcionarioDAO;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	private Funcionario funcionarioSelecionado;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void excluir() {
		try {
			funcionarioDAO.excluir(funcionarioSelecionado);
			this.funcionarios.remove(funcionarioSelecionado);
			FacesUtil.addSuccessMessage("Funcionário " + funcionarioSelecionado.getNome() + " excluído com sucesso.");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}
	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}
	
	@PostConstruct
	public void inicializar() {
		funcionarios = funcionarioDAO.buscarTodos();
	}
}




5.7. Adicionando mais uma enumeração
Por favor, me ajude a terminar esse sistema. Vou deixar por sua conta adicionar o sexo no momento do cadastro de Funcionário e Motorista.
Mas atenção - é uma propriedade comum a ambas as entidades, o que significa que será adicionada na entidade Pessoa. Certo?
Abaixo está o código JSF necessário para fazer os cadastros funcionários, o resto é com você.
No CadastroFuncionario.xhtml, logo abaixo da entrada de CPF adicione o trecho abaixo:
<p:outputLabel value="Sexo" for="sexo"/>
<p:selectOneMenu id="sexo" value="#{cadastroFuncionarioBean.funcionario.sexo}">
	<f:selectItem itemLabel="Selecione o sexo" />
    	<f:selectItems value="#{cadastroFuncionarioBean.sexos}" var="sexo" 
						itemLabel="#{sexo.descricao}" itemValue="#{sexo}"/>
</p:selectOneMenu>


Repare que precisamos de ter uma lista de sexo no managed bean CadastroFuncionarioBean. Portanto edite-o e adicione os trechos abaixo.
OBS: Não irá compilar até você criar o Enum "Sexo". Não se esqueça dele. :)

//...

private List<Sexo> sexos;

//...

// No método inicializar, adicione a linha abaixo.
this.sexos = Arrays.asList(Sexo.values());

//...

// Finalmente o getter para sexos.
public List<Sexo> getSexos() {
	return sexos;
}



Na tela PesquisaFuncionarios.xhtml só precisamos adicionar mais uma coluna na dataTable.

<p:column headerText="Sexo">
     <h:outputText value="#{funcionario.sexo.descricao}" />
</p:column>

Em motorista é bem parecido, o que muda basicamente são os arquivo que iremos alterar.
Em CadastroMotorista.xhtml adicione o trecho abaixo logo abaixo de CPF:

<p:outputLabel value="Sexo" for="sexo"/>
     <p:selectOneMenu id="sexo" value="#{cadastroMotoristaBean.motorista.sexo}">
  	<f:selectItem itemLabel="Selecione o sexo" />
        <f:selectItems value="#{cadastroMotoristaBean.sexos}" var="sexo" 	itemLabel="#{sexo.descricao}" itemValue="#{sexo}"/>
</p:selectOneMenu>


As alterações em CadastroMotoristaBean são as mesmas que você acabou de fazer em CadastroFuncionarioBean.
Mãos a obra. Termine o mapeamento e faça os testes.
Boa sorte! E qualquer dúvida é só perguntar.


5.8. Implementando mais um Muitos-Para-Um
E o relacionamento entre Aluguel e Motorista, você pode fazê-lo para mim?
Nesse momento vamos fazer apenas no sentido de Aluguel para Motorista. Portanto não iremos alterar nada na classe Motorista.
Vou deixar o código JSF aqui e deixar por sua conta o mapeamento e testes. Assim, quando formos fazer um novo Aluguel, já teremos que selecionar o motorista.

Veja que um Aluguel tem um motorista apenas. Já um motorista pode fazer vários alugueis.
Você irá trabalhar no mapeamento e nos DAOs necessários para que na tela de Novo Aluguel, um Select apresente todos os motoristas cadastrados.
Para isso segue abaixo o código JSF para você não perder tempo com ele e focar no JPA.
No arquivo NovoAluguel.xhtml, adicione o trecho abaixo logo após o select de carro.

<p:outputLabel value="Motorista" for="motorista"/>
<p:selectOneMenu id="motorista" value="#{novoAluguelBean.aluguel.motorista}">
    <f:selectItem itemLabel="Selecione o motorista" />
    <f:selectItems value="#{novoAluguelBean.motoristas}" var="motorista" 
	itemLabel="#{motorista.nome}" itemValue="#{motorista}"/>
</p:selectOneMenu>



Agora vamos ao Managed Bean NovoAluguelBean.

//...
// Injete o MotoristaDAO
@Inject
private MotoristaDAO motoristaDAO;

// Também crie uma lista de Motoristas necessária para o select na tela
private List<Motorista> motoristas;

// Inicialize essa lista no método void inicializar()
this.motoristas = this.motoristaDAO.buscarTodos();

// E também crie o get para a lista
public List<Motorista> getMotoristas() {
    return motoristas;
}



Para que o select de Motorista funcione, é necessário criar o Converter do Motorista. Então crie a classe MotoristaConverter no pacote com.algaworks.curso.jpa2.converter e deixe-a como abaixo.

package com.algaworks.curso.jpa2.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.model.Motorista;
import com.algaworks.curso.jpa2.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Motorista.class)
public class MotoristaConverter implements Converter {

	private MotoristaDAO motoristaDAO;
	
	public MotoristaConverter() {
		this.motoristaDAO = CDIServiceLocator.getBean(MotoristaDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Motorista retorno = null;

		if (value != null) {
			retorno = this.motoristaDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Motorista) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}



Muita atenção agora - quando criamos o mapeamento de Pessoa, Motorista e Funcionário faltou uma parte muito importante. Consegue descobrir o que é?
Se você já implementou até agora e não percebeu o que ficou faltando nesse mapeamento, quando salvar irá ver o erro abaixo.



Agora, consegue me dizer o motivo?
É uma coisa muito, mas muito boba que faz muita, muita diferença! Faltou implementar o equals() e o hashCode()!
Mande o eclipse gerar esses métodos na classe Pessoa utilizando o código como parâmetro. Assim Motorista e Funcionário herdarão os métodos. ;)
6.1. Introdução a Java Persistence Query Language (JPQL)
o JPQL é uma linguagem que facilita o trabalho para sistemas em java.
ele é parecido com SQL exatamente para não precisar aprender muita coisa diferente e ser mais fácil a adaptação.

então para fazermos um select na tabela de fabricantes fazemos:

List<Fabricante> fabricantes = em.createQuery("select f from Fabricante f", Fabricante.class).getResultList();

List<Fabricante> fabricantes = em.createQuery(QUERY_A_SER_EXECUTADA, CLASSE_PARA_CONVERTER.class).getResultList();

o f em ‘select f from Fabricante f’ é um alias para a entidade Fabricante.
Fabricante é a entidade Java.

caso não queiramos receber toda a entidade Fabricante, e sim somente os nomes, é só utilizar os nomes do atributo:
List<String> fabricantes1 = em.createQuery("select f.nome from Fabricante f", String.class).getResultList();
		

6.2. Selecionando uma entidade de uma entidade
é possível encontrar uma entidade a partir de outra entidade utilizando o JPQL.
como exemplo, iremos encontrar fabricantes pelo modelo de carro.

o ModeloCarro tem um relacionamento many to one com fabrincante. 

então, por modeloCarro, é possível encontrar os fabricantes:

select mc.fabricante.nome from ModeloCarro mc 

o próprio JPA se encarrega de fazer as joins com os determinados ONs.

detalhe:
como o select esta sendo feito pela entidade modeloCarro, ele ira trazer todos os fabricantes existentes na tabela de modelo de carro, logo, irá haver fabricantes duplicados na lista.

 

6.3. Filtrando resultados
também é possível filtrar um resultado usando dados de outra entidade, utilizando o JPQL.
continuaremos com o exemplo do ModeloCarro. supondo que queremos achar todos os modelos de carro que tenha o fabricante ford:

select mc.descricao from ModeloCarro mc where mc.fabricante.nome = ‘ford’ 

o select irá trazer todos os modelos de carro que tem a ford como fabricante.

neste exemplo utilizamos o ‘=’ mas poderíamos ter utilizado o ‘like’, ‘in ( ) ’, etc

6.4. Exercício: Filtrando resultados
Para você brincar um pouco mais com os filtros em JPQL, vamos criar uma outra classe de consulta e fazer duas pesquisas de modelo de carro.
A primeira iremos fazer um filtro utilizando "in" e a outra utilizando "like".
Crie a classe ConsultaModeloFiltroEmFabricanteECategoria e crie o método main. Inicialize o EntityManager.
A primeira consulta quero buscar os modelos dos carros, de um determinado fabricante que esteja dentro de algumas categorias específicas.
OBS: Se quiser popular seu banco de dados com diversos fabricantes e modelos de carro para ter uma base maior, fique a vontade.
Vamos começar a montar nossa consulta. Já vimos que para buscar a descrição de ModeloCarro, basta fazermos o select no atributo do objeto.
select mc.descricao from ModeloCarro mc


Para fazer o filtro no nome do fabricante, adicionamos where e fazemos o filtro como se estivéssemos trabalhando com objetos.
select mc.descricao from ModeloCarro mc
  where mc.fabricante.nome = 'Honda'


Agora precisamos de adicionar outro filtro, isso é bem simples, basta usarmos a palavra chave "and" e filtrar apenas as categorias que queremos com a "in".
select mc.descricao from ModeloCarro mc
  where mc.fabricante.nome = 'Honda'
    and mc.categoria in ('SEDAN_MEDIO', 'SEDAN_GRANDE')


Pronto! Nossa consulta já está pronta para ser executada.
Vou deixar uma dica importante. Quando você colocar essa consulta dentro de String do Java e você utilizar quebra de linha, tenha cuidado de deixar um espaço vazio no fim ou início de cada linha. Veja abaixo como ficaria a consulta completa.
String jpql = "select mc.descricao from ModeloCarro mc "
              + "where mc.fabricante.nome = 'Honda' "
                + "and mc.categoria in ('SEDAN_MEDIO','SEDAN_GRANDE')"
List<String> modelos = em.createQuery(jpql, String.class).getResultList();



6.5. Trabalhando com projeções
bom, mas agora, e se tivermos problemas de performance das queries e precisamos só de pedaços da entidade? podemos usar as PROJECTIONS.

o que são as projections? projections é somente o retorno de algumas colunas das entidades (em vez de trazer elas completas).

usando o exemplo de modeloCarro. podemos querer trazer somente a descrição e a categoria, sem ter a necessidade de consultar o fabricante.

então podemos utilizar:

select mc.descricao, mc.categoria from ModeloCarro mc

as colunas mc.descricao, mc.categoria serão retornadas, mas não existe nenhum objeto que receba esses dois atributos. então o retorno será um object[], e nas posições do array, estarão os valores das colunas.
ex:
na posição obj[0] estará a descrição e na posição obj[1] estará a categoria.


6.6. Fazendo Join entre entidades
agora veremos como linkar duas entidades sem aparentemente nenhum relacionamento.

neste caso, teremos como exemplo Carro e acessórios. carro e acessórios são muitos para muitos, logo, o método de navegar pela entidade, acessando as propriedades não funciona, pois acessorios em carros é uma lista.

neste caso, precisamos fazer um JOIN.

em JPQL, um join é muito fácil.

select a.descricao
from Carro c
JOIN c.acessorios a
where c.modelo.descricao = ‘cruze’

somente precisamos da linha ‘JOIN c.acessorios a’ para fazer o join.

muito mais fácil que em sql.

o próprio JPA irá realizar as associações.

6.7. Trabalhando com queries agregadas
as consultas agregadas são funções que existem em sql.

exemplos:
AVG -- média
COUNT -- contador
MIN - valor mínimo
MAX - valor máximo
SUM - soma

se quisermos, podemos agrupar por determinada entidade, usando o GROUP BY

e também podemos fazer filtros utilizando o HAVING.

no nosso exemplo, utilizaremos as entidades Carro e Aluguel. queremos saber as informações do aluguel de cada carro.

 SELECT c, COUNT(a), MAX(a.valorTotal), AVG(a.valorTotal) FROM Carro c JOIN c.alugueis a GROUP BY c HAVING COUNT(a) > 1

neste select irá trazer um objec[] contendo o carro, a quantidade de aluguéis, o valor máximo do aluguel, a média do aluguel de todos os carros que tenham mais de 1 aluguel..

6.8. Novos tipos de retorno
Se você ficou triste com aquela List na classe ConsultasAgregadasEmCarro, pode ficar feliz, seus problemas acabaram!
JPA é tão fantástico que podemos criar um novo objeto na hora da consulta com os valores do select. Não entendeu? Deixa eu te mostrar.
Estávamos com a seguinte consulta:
select c, count(a), max(a.valorTotal), avg(a.valorTotal) 
   from Carro c JOIN c.alugueis a 
   group by c 
   having count(a) > 1


Temos 4 campos de retorno "c" (tipo Carro), "count(a)" (pode ser um Long), "max(a.valorTotal)" (um decimal) e "avg(a.valorTotal)" (também um decimal).
Não temos nenhuma classe que agrupam esses valores, bem na verdade não tínhamos. Vamos criar agora e deixar o JPA criar esse objeto na consulta.
Crie uma classe chamada AlguelCarroInfo no pacote com.algaworks.curso.jpa2.info. Adicione cada atributo para os tipos do retorno e um construtor que inicializa todos eles. Veja abaixo.
public class AluguelCarroInfo {
    private Carro carro;
    private Long totalAlugueis;
    private BigDecimal valorMaximo;
    private BigDecimal valorMedio;

    public AluguelCarroInfo(Carro carro, Long totalAlugueis,
            Number valorMaximo, Number valorMedio) {
        this.carro = carro;
        this.totalAlugueis = totalAlugueis;
        this.valorMaximo = BigDecimal.valueOf(valorMaximo.doubleValue());
        this.valorMedio = BigDecimal.valueOf(valorMedio.doubleValue());
    }

    // Getters ans setters


Já te explico o porque estamos recebendo Number e convertendo para BigDecimal, aguarde um pouquinho só.
Voltando agora a nossa consulta em ConsultasAgregadasEmCarro, ao invés de retornarmos diretamente as agregações, vamos criar um AluguelCarroInfo usando o operador NEW. Veja como nossa consulta fica agora.
select NEW com.algaworks.curso.jpa2.info.AluguelCarroInfo(c, count(a), 
               max(a.valorTotal), avg(a.valorTotal))
   from Carro c JOIN c.alugueis a 
   group by c 
   having count(a) > 1


Repare que estamos criando um novo objeto do tipo AluguelCarroInfo chamando o seu construtor (veja o fecha-parênteses no fim do construtor).
E agora que vem a explicação de utilizarmos o Number ao invés do BigDecimal direto. Como é o próprio framework que chama o construtor, ele não sabe que precisa converter para BigDecimal, por isso deixamos Number e na implementação fazemos a conversão de Number para BigDecimal (quando terminar esse exercício, altere diretamente o tipo de dados no construtor para BigDecimal e veja a exceção que irá acontecer).
Para finalizar, vamos trocar aquela lista horrorosa para o código mais elegante abaixo.
List<AluguelCarroInfo> resultados = em.createQuery(jpql, AluguelCarroInfo.class).getResultList();
for (AluguelCarroInfo aci : resultados) {
    System.out.println("Modelo: " + aci.getCarro().getModelo().getDescricao());
    System.out.println("Quantidade de alugueis: " + aci.getTotalAlugueis());
    System.out.println("Valor máximo: " + aci.getValorMaximo());
    System.out.println("Valor médio: " + aci.getValorMedio());
    System.out.println();
}


6.9. Passando parâmetros para queries
ao passarmos parâmetros para as queries, podemos passá-los de três formas:
diretamente concatenando as strings;
usando o ‘tipo posicional’ (usando ?);
usando o ‘tipo parametro’ (usando :parametro);

exemplo:

menos elegante:
select mc.descricao from ModeloCarro mc where mc.fabricante.nome = ‘“+fabricante+”’”; 


select mc.descricao from ModeloCarro mc where mc.fabricante.nome = ? ;

e na criação da query coloque:
em.createQuery(sb.toString(), String.class).setParameter(1, fabricante).getResultList();

ou mais elegante:

select mc.descricao from ModeloCarro mc where mc.fabricante.nome = :fabricante ;

e na criação da query coloque:
em.createQuery(sb.toString(), String.class).setParameter(“fabricante”, fabricante).getResultList();



6.10. Passando datas como parâmetros
Já vimos que trabalhar com datas requer uma atenção especial, pois precisamos tomar cuidado com o tipo que escolhemos - java.util.Date ou java.util.Calendar. Isso porque alguns frameworks podem exigir um ou outro.
Agora vamos ver como filtrar uma query passando uma data como parâmetro. Lembra que no mapeamento fizemos uso da anotação @Temporal e da enumeração TemporalType? A enumeração indica se o campo que estamos persistindo é somente uma data, horas ou data e horas juntos.
Quando formos fazer o filtro, temos que informar que tipo de campo ele é.
Para exemplificar, vamos criar uma classe de consulta, no nosso projeto de consultas. Vamos então filtrar os aluguéis vendidos entre dois dias quaisquer.
Para isso salve alguns alugueis no banco com datas diferentes para que você veja o filtro em ação.
Crie a classe ConsultaAluguelPorData e vamos criar primeiro a jpql usando BETWEEN para o filtro da data.
String jpql = "select count(a) "
 	      + "from Aluguel a "
	      + "where a.dataDevolucao BETWEEN :inicio AND :fim";


Repare que vamos buscar a quantidade de devoluções em um determinado período.
Uma parte importante dessa consulta é o tipo do campo "dataDevolucao". Isso porque se ele for um Calendar, devemos passar um Calendar, se for um java.util.Date, devemos passar o mesmo tipo.
Neste caso, "dataDevolucao" é do tipo java.util.Date e é mapeada como TIMESTAMP.
Portanto vamos criar as variáveis para fazer o filtro.
Calendar inicioCalendar = Calendar.getInstance();
inicioCalendar.set(2013, 7,  28, 7, 0); // 24 de Agosto de 2013 7:00 horas
Date inicio = inicioCalendar.getTime();
		
Calendar fimCalendar = Calendar.getInstance();
fimCalendar.set(2013, 7, 30, 18, 0); // 25 de Agosto de 2013 18:00 horas
Date fim = fimCalendar.getTime();


OBS: A contagem dos meses inicia-se com zero, Janeiro é zero, Fevereiro um e assim por diante.
Agora basta utilizarmos o EntityManager para criar a query, executar e então mostrarmos o resultado na tela.
Long quantidadeDevolucoes = em.createQuery(jpql, Long.class)
			.setParameter("inicio", inicio, TemporalType.TIMESTAMP)
			.setParameter("fim",  fim, TemporalType.TIMESTAMP)
			.getSingleResult();

System.out.println("Quantidade de devoluções: " + quantidadeDevolucoes);


Faça alguns testes mudando o campo de aluguel para "dataEntrega" que é do tipo Calendar e mapeada como TemporalType.DATE.
6.11. Trabalhando com Named Query
as named queries são muito fáceis de trabalhar. elas tem a simplicidade de organizar as queries em um único lugar, neste caso no modelo.

queries que são muito repetidas são propensas a virarem named queries.

o que precisamos para utilizar as named queries?

somente anotar o modelo com a anotacao @NamedQuery(name=”XXXXX”, query=”select …..”
caso existam mais de uma query, basta utilizar a anotação @NamedQueries({
@namedQuery(name=”1212313”, query=”select….”), @namedQuery(name=”1212313”, query=”select….”), ….})

muito fácil. podemos também utilizar normalmente a passagem de parâmetros. na DAO, quando formos chamar a named query, passamos os parâmetros no setParameter normalmente.

e uma boa prática é nomear as namedQueries com o nome da classe.nomeDaQuery, ex Carro.buscarTodos

isso é necessário pois o nome da named query tem que ser único no sistema.

6.12. Entendendo a paginação
o que é necessário para a paginação em uma tabela?

bom, depende de cada framework utilizado, mas no nosso caso, iremos fazer tendo em vista o primefaces e o hibernate.

no arquivo xhtml, na tag p:dataTable, devemos ter os atributos:
rows=”10”
paginator=”true”
paginatorAlwaysVisible=”false”
paginatorPosition=”bottom”
lazy=”true”
rowsPerPageTemplate=”5, 10,15,20”
e o value deve apontar para um DataModel no bean.

agora devemos criar uma nova classe, LazyCarroDataModel.class, 
e devemos extends LazyDataModel do primefaces, informando o modelo (neste caso é Carro) e implementar Serializable.

criamos um atributo para o respectivo DAO e criamos um construtor que recebe esse DAO como parâmetro.

no datamodel devemos sobrescrever o método load, e repassar o retorno para o dao, com as informações necessárias.

ex: List<Carro> carros = this.carrosDao.buscarComPaginacao(inicial, tamanhoDaPagina)

devemos também informar  a quantidade de registros:
this.setRowCount(this.carroDao.encontrarQuantidadeDeCarros().intValue());

e retornamos a lista de carros.

no dao, para criar a query com paginação, vamos utilizar a named query já utilizada para buscar todos, só que, na dao, antes do getResultList(), iremos passar os métodos:
setFirstResult(first)
.setMaxResult(pageSize)
.getResultList()

o first e o pageSize vem da chamada do metodo (this.carrosDao.buscarComPaginacao(inicial, tamanhoDaPagina)) 

para o método para encontrar a quantidade de carros, implementamos o método onde irá fazer um select count(c) … , retornando um long com a quantidade de registros.

no bean, a tabela do primefaces deve buscar a classe do datamodel criado.


7.1. Entendendo a Sessão e Transação no projeto
o que precisamos para fazer o inject do entity manager? como controlar a transação?

no nosso exemplo, utilizamos o framework CDI para injeção de dependência, na implementação do WELD. 

http://weld.cdi-spec.org/

Weld is the reference implementation of CDI: Contexts and Dependency Injection for the Java EE Platform - a JCP standard for dependency injection and contextual lifecycle management and one of the most important and popular parts of the Java EE. Weld is integrated into many Java EE application servers such as WildFly, JBoss Enterprise Application Platform, GlassFish, Oracle WebLogic Server,WebSphere Application Server and others. Weld can also be used in plain servlet containers (Tomcat, Jetty) or Java SE.

no projeto, criamos um pacote util.jpa
la teremos uma classe EntityManagerProducer.java

@ApplicationScoped
public class EntityManagerProducer {

	private EntityManagerFactory factory;

	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Produces
	@RequestScoped
	public EntityManager create() {
		return factory.createEntityManager();
	}

	public void close(@Disposes EntityManager manager) {
		manager.close();
	}
	
}

quando utilizamos a anotação @ApplicationScoped eu informo que quero que somente um objeto destes seja criado na aplicação.

no construtor, criamos a entity manager factory

usando o @Produces e o @RequestScoped, eu estou falando que, quando alguém injetar o entitymanger, a anotação @Produces irá criar um novo entity manager, usando o escopo de request.

para controlar a transação, usamos a anotação @Transactional, criada por nós mesmos:

@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transactional {

}

uai, mas nao tem nada nela!

isso mesmo, mas existe um interceptor, que intercepta a chamada da anotação e executará em seu lugar:
@Priority(Interceptor.Priority.LIBRARY_BEFORE)
@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject EntityManager manager;
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		EntityTransaction transaction = manager.getTransaction();
		boolean owner = false;

		try {
			if (!transaction.isActive()) {
				// truque para fazer rollback no que já passou
				// (senão, um futuro commit, confirmaria até mesmo operações sem transação)
				transaction.begin();
				transaction.rollback();
				
				// agora sim inicia a transação
				transaction.begin();
				
				owner = true;
			}

			return context.proceed();
		} catch (Exception e) {
			if (transaction != null && owner) {
				transaction.rollback();
			}

			throw e;
		} finally {
			if (transaction != null && transaction.isActive() && owner) {
				transaction.commit();
			}
		}
	}

}

quando encontrar a anotação @Transactional, o interceptor, por meio de outra anotação @AroundInvoke, executará coisas antes e depois do método que invocou o @Transactional.

no nosso caso, ele irá abrir e fechar a conexão e dar commit ou rollback.

e no persistence.xml, no transactionType, colocamos RESOURCE_LOCAL, que quer dizer que a aplicação que controla a transação. mas poderíamos utilizar o JPA, mas precisaríamos de outras configurações que serão exibidas posteriormente.

7.2. Usando JTA em um ambiente Java EE
usaremos o jboss como container javaee para esta aula. 
nela utilizaremos o container controlar a transação.

no novo projeto-jboss, iremos implementar a consulta utilizando JTA. nele iremos fazer um cadastro simples de cliente. com isso, demonstraremos o controle da transação pelo container.

então, primeiro devemos baixar o jboss as7.1.1.final.

para instalar ele basta somente extrair a pasta.

dentro da pasta bin, existe o standalone.bat, iniciamos o jboss.

localhost:8080 veremos a tela de boas vindas.

os arquivos diferentes são:

persistence.xml
	alteramos o nome da persistence-unit, a transaction-type agora é JT, as properties de conexão são retiradas, pois iremos utilizar um datasource. 

acrescentamos as seguintes informações:
<provider>org.hibernate.ejb.HibernatePersistence</provider>
<jta-data-source>java:/projetoJbossDS</jta-data-source>

agora na pasta do jboss, na modules -> com
criamos uma nova pasta com o nome mysql
e dentro dela a main e colocamos aqui dentro os drivers do mysql.

criamos também um novo arquivo xml chamado de module.xml
 nele colocamos o seguinte texto:


<?xml version="1.0" ?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.34-bin.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>



agora na pasta do jboss -> standalone -> configuration -> standalone.xml
adicionamos o DS:


 <datasource jndi-name="java:/projetoJbossDS" pool-name="MySqlDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/cadastro_cliente</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>root</user-name>
                        <password>root</password>
                    </security>
                    <timeout>
                        <idle-timeout-minutes>0</idle-timeout-minutes>
                        <query-timeout>600</query-timeout>
                    </timeout>
                </datasource>


para garantir que o jboss está ok, basta executarmos o arquivo .bat novamente.

no persistence.xml ainda incluímos o dialeto do mysql:
	<persistence-unit name="projetoJbossPU" transaction-type="JTA">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<jta-data-source>java:/projetoJbossDS</jta-data-source>
		
		<class>com.algaworks.jboss.modelo.Cliente</class>
		
		<properties>
<!-- 			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/cadastro_cliente"/> -->
<!-- 			<property name="javax.persistence.jdbc.user" value="root"/> -->
<!-- 			<property name="javax.persistence.jdbc.password" value="root"/> -->
<!-- 			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/> -->
			
			<!-- validate | update | create | create-drop -->
			<property name="hibernate.hbm2ddl.auto" value="update"/>
			<property name="hibernate.show_sql" value="true"/>
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	</persistence-unit>


e também é preciso mapear as entidades usando a tag:
<class>com.algaworks.jboss.modelo.Cliente</class>

deve ser feito isso para todas as classes persistidas.

a tela é muito simples, então nem vamos aprofundar muito.

o bean para a tela se chama de CadastroClienteBean.java

package com.algaworks.jboss.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.algaworks.jboss.ejb.CadastroClienteEJB;
import com.algaworks.jboss.modelo.Cliente;

@Named
@SessionScoped
public class CadastroClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> clientes;
	
	@EJB
	private CadastroClienteEJB cadastroClienteEJB;
	//injecao utilizando o EJB
	
	@PostConstruct
	public void inicializar() {
		this.cliente = new Cliente();
		this.clientes = cadastroClienteEJB.buscarTodos();
	}
	
	public void salvar() {
		cadastroClienteEJB.salvar(cliente);
		inicializar();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}	
}



o modelo cliente é o Cliente.java:
package com.algaworks.jboss.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

	private long codigo;
	private String nome;
	private Integer idade;
	private String sexo;
	private String profissao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}



e o DAO neste caso é um EJB, CadastroClienteEJB.java
package com.algaworks.jboss.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.algaworks.jboss.modelo.Cliente;

@Stateless
public class CadastroClienteEJB {
	
	@PersistenceContext(unitName="projetoJbossPU")
	private EntityManager em;
	//injecao utilizando o @PersistenceContext e utilizado o persistence.xml

	public void salvar(Cliente cliente) {
		em.merge(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return em.createQuery("from Cliente c").getResultList();
	}
	
}



por causa do plugin do maven com o ant, (que ira copiar o war gerado para a pasta deploy do servidor) precisamos ao executar o job do maven build, precisamos passar como goals:
clean install -Djboss.home=c:\bla bla bla (onde está o jboss)

localhost:8080/projeto-jboss


7.3. Ciclo de vida e Estados dos objetos
quando um objeto é criado (new) entao, para o JPA o estado dele é new.

quando neste objeto new chamarmos o persist() ou merge(), este objeto irá assumir o status de managed.

outra situação com objeto quando realizamos uma consulta, este objeto assume o status de managed.

a partir de um objeto managed, e invocamos o método remove(), o objeto assume o status de removed.
se chamarmos o persist() ou o merged() neste objeto removed, ele ficará novamente com o status de managed.

se a partir de um objeto managed, invocarmos o método detach() ou o entity manager é fechado, então esse objeto passa para o status detached. se chamarmos o merge() neste objeto, ele ficará novamente com o status de managed.

ou seja, somente existem os seguintes status para objetos no JPA (new, managed, removed ou detached)

podemos também executar algumas ações se interpretarmos algum dos status acima. eles são chamados de callbacks.

existe o prepersist, o postpersist, preremove, postremove, preupdate, posupdate e o postload.

com essas anotações, podemos interceptar as alterações de status da entidade.

ex.
na classe Carro, precisamos registrar 2 atributos de data, que registrem quando o objeto foi criado e quando foi alterado.
quando o persist ou o merge da entidade for invocado, um método deverá ser executado antes.
esse método será anotado com @PrePersist e @PreUpdate

e nesse método setamos as datas conforme regras de negócio.

pronto. agora, sempre que esta entidade for ser persistida, ela será interceptada e as datas serão inseridas.

7.4. Movendo os objetos pelo ciclo de vida
Vamos fazer uma entidade passar pelos ciclos de vida testando no projeto crud-jpa-hibernate que fizemos em outras aulas. Para isso, crie uma classe TesteDoCicloDeVida com um método main.
Dica: Se você for executando passo a passo o exemplo abaixo, recomendo que você vá deletando a tabela cliente no banco de dados, assim ficará mais fácil de você ver as alterações.
Se apenas criarmos um objeto, para o EntityManager ele estará no estado "new".
// Uma nova entidade, está no estado "new"
Cliente cliente1 = new Cliente();
cliente1.setNome("Fernando Alonso");
cliente1.setIdade(32);
cliente1.setProfissao("Piloto");
cliente1.setSexo("M");


Para passarmos a entidade para o estado "managed", ou gerenciado, podemos usar os métodos persist ou merge no EntityManager.
// Com persist, fazemos o objeto passar para o estado "managed"
em.getTransaction().begin();
em.persist(cliente1);
em.getTransaction().commit();


Neste momento o objeto já está no banco de dados já está atualizado com o novo cliente, "Fernando Alonso".
A entidade cliente1 continua no estado "managed" neste EntityManager que criamos. Vamos agora desanexar esse objeto com o método detached, removendo ele do EntityManager.
// Agora passamos cliente1 para o estado "detached"
em.detach(cliente1);


Se neste momento tentarmos persistir uma entidade neste estado, o Hibernate irá lançar uma exceção com a mensagem: "detached entity passed to persist", ou seja, estamos tentando salvar uma entidade desanexada para o método persist.
O código abaixo está com o try/catch para podermos continuar a executar nosso exemplo em sequência.
// Se tentarmos agora, persistir uma entidade que está desanexada, 
// iremos receber uma exception
try {
	em.getTransaction().begin();
	cliente1.setIdade(33);
	em.persist(cliente1);
	em.getTransaction().commit();
} catch (PersistenceException e) {
	System.err.println("Erro ao persistir a entidade. " + e.getMessage());
	em.getTransaction().rollback();
}


A ideia acima é a mesma de quando fechamos o EntityManager, em um projeto web e depois tentamos passar essa entidade a um novo EntityManager. Se quiser fazer o teste, fique a vontade, feche esse EntityManager, crie outro e tente persistir o cliente1 - não se esqueça de iniciar a transação.
Um ponto muito importante acima é o rollback da transação. Veja que se iniciamos a transação e a falha ocorreu no método persist, a transação ficará aberta e marcada para rollback, portanto devemos chamar o rollback() para poder abrir outra transação no mesmo Entity Manager
Para colocar o objeto gerenciado novamente, utilizamos o método merge ou buscamos com o método find (ou outros métodos de consulta) no banco de dados.
// Buscando no banco de dados. Atenção ao valor do código!
cliente1 = em.find(Cliente.class, 1L);
em.getTransaction().begin();
cliente1.setIdade(33); // Agora sim conseguimos alterar a idade
em.getTransaction().commit();


Para entrar no estado "Removed", basta chamar o método remove.
// Agora entrando no estado removed
em.getTransaction().begin();
em.remove(cliente1);
em.getTransaction().commit();


Para finalizar, vamos reconectar o objeto removido com o método merge e aprender um detalhe muito importante desse método, ele devolve um outro objeto!
Isso significa que se você fizer a alteração no cliente1, nada será alterado no banco de dados! Agora, se fizer o objeto retornado sim, as alterações irão para o banco. Veja o código abaixo:
// Reconectando um objeto removido.
Cliente cliente2 = em.merge(cliente1);
System.out.println(cliente1 == cliente2);
em.getTransaction().begin();
cliente1.setIdade(34); // Não irá alterar a idade!
em.getTransaction().commit();
		
em.getTransaction().begin();
cliente2.setIdade(34); // Agora sim irá alterar a idade.
em.getTransaction().commit();


Interessante, não é verdade? Tente fazer os testes bem devagar, entenda todo o processo e realmente veja os objetos sendo movidos pelo ciclo de vida. No início pode parecer confuso, mas depois que você entende isso, será muito mais fácil trabalhar e encontrar os erros em produção.
8.1. O que é API Criteria?
a API criteria do JPA 2, é somente a especificação do que já existia no JPA 1, onde o hibernate criou a Criteria. desta forma, todos os frameworks que utilizam a especificação do JPA 2, podem se beneficiar da Criteria, e nao mais so somente o hibernate.

a criteria é excelente para grandes queries, onde seria necessário utilizar muitas concatenações de string se fossem realizadas de forma nativa.

aos poucos iremos aprender sobre a criteria mas, como exemplo, citamos 2 casos simples:

para substituir o seguinte :
select * from Cliente

criamos na criteria:
CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<Cliente> criteriaQuery = builder.createQuery(Cliente.class);

criteriaQuery.from(Cliente.class);
		
List<Cliente> clientes = em.createQuery(criteriaQuery).getResultList();

e para substituir o seguinte :
 select c from Cliente where c.nome like = 'chaves%'

criamos:
CriteriaBuilder builder2 = em.getCriteriaBuilder();
CriteriaQuery<Cliente> criteriaQuery2 = builder2.createQuery(Cliente.class);

Root<Cliente> c = criteriaQuery2.from(Cliente.class); // a variavel c é a equivalente ao select c
		criteriaQuery2.select(c); // criacao do select c
criteriaQuery2.where(builder2.like(c.get("nome"), "chaves%")); //criacao do where, passando um like, comparando o atributo nome (c.get("nome")) ao passado no segundo parametro ("chaves%"). equivalente ao c.nome like = 'chaves%'
		
List<Cliente> clientes2 = em.createQuery(criteriaQuery2).getResultList();


8.2. Consulta com Criteria
agora vamos implementar uma consulta simples com criteria e também passar um filtro na pesquisa.

então, basicamente queremos receber uma lista de aluguéis e vamos ou não passar um filtro.

então a implementação da criteria, no DAO, vai ser:

public List<Aluguel> buscarPorDataDeEntregaEModeloCarro(Date dataEntrega, ModeloCarro modelo) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Aluguel> criteriaQuery = builder.createQuery(Aluguel.class);
		Root<Aluguel> a = criteriaQuery.from(Aluguel.class); //equivalente ao select a from aluguel
		criteriaQuery.select(a);// implementa o select
		
		List<Predicate> predicates = new ArrayList<>(0); //lista de filtros
		
		if (dataEntrega != null) { //se tivermos selecionado alguma data
			/*
			 * ParameterExpression sao parâmetros do filtro.
			 * ao escrevermos : builder.parameter(Date.class, "dataEntregaInicial") 
			 * a 'dataEntregaInicial' é equivalente ao :dataEntregaInicial do JPQL
			 */
			ParameterExpression<Date> dataEntregaInicial = builder.parameter(Date.class, "dataEntregaInicial");
			ParameterExpression<Date> dataEntregaFinal = builder.parameter(Date.class, "dataEntregaFinal");
			
			/*
			 * o between tem como parâmetros:
			 * a.<Date>get("dataEntrega") -- busca na variável a o atributo 'dataEntrega', que é um Date
			 *  dataEntregaInicial, dataEntregaFinal -- seta como valor inicial e final no between (que tem dois parâmetros)
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


8.3. Projeções
 As projeções servem para trazer somente um pedaço da entidade, exemplo, neste caso queremos somente a placa do carro.

neste exemplo, além das projeções, iremos criar também uma classe de teste.

INTRODUÇÃO AO JUNIT

para configurar os testes em um sistema:
	  1- clique com o botão direito no projeto e selecione 'properties'
	  2- add library e selecione o junit 4
	  3- no pom, acrescente a dependência do maven
	  		groupid - junit
	  		artifactid - junit
	  		versão 4.10
	  		scope - test
	  
	  4- agora a classe deve ser criada, no caso, a classe ExemplosCriteria.java.
	  5- nos teste, o @Inject nao funciona, então precisamos criar tudo manualmente.
	  EntityManagerFactory, estático, que no método init() ira ser inicializado.
	  no método init(), anotamos com @BeforeClass para que seja executado pelo junit 
	  logo após a criação da classe.
	  6- no método setUp(), inicializamos o EntityManager, mas queremos que a cada teste este
	  método seja executado, então anotamos com @Before
	  7- também queremos que o entitymanager seja fechado logo após a execução do teste, logo
	  anotamos o método tearDown() com @After.
	  8- o junit ira executar os métodos anotados com @Test. estes são os testes.

	
PROJEÇÕES
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
		
		for (String placa : placas) {
			System.out.println(placa);
		}
	}

8.4. Funções de agregação

  as funções de agregação com criteria são bem simples!
		  
  o que são funções de agregação? são todas aquelas funções utilizadas pelos
  bd´s que retornam algum tipo de cálculo, como soma, média, max, min, etc.
		  
 as funções de agregação são criadas no builder.
  
 neste exemplo queremos ver a soma de todos os aluguéis cadastrados no bd.
		  
		 
@Test
	public void funcoesDeAgregacao() {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<BigDecimal> criteriaQuery = builder.createQuery(BigDecimal.class);
		
		/**
		 * o from é sobre a entidade Aluguel, como seria na native query.
		 */
		Root<Aluguel> aluguel = criteriaQuery.from(Aluguel.class);
		
		/*
		 * aqui criamos a função de agregação, neste caso um sum sobre a coluna valor total 
		 * da classe Aluguel
		 */
		criteriaQuery.select(builder.sum(aluguel.<BigDecimal>get("valorTotal")));
		//equivalente ao select sum(a.valorTotal) from Aluguel a
		
		TypedQuery<BigDecimal> query = manager.createQuery(criteriaQuery);
		BigDecimal total = query.getSingleResult();
	
		System.out.println("Soma de todos os aluguéis: " + total);
	}


8.5. Resultados complexos, tuplas e construtores
o metodos resultadoComplexo(), resultadoTupla() e resultadoConstrutores() são formas de se buscar com projeções, mas desta vez,  retornando vários atributos ao mesmo tempo.

os métodos estão por ordem de complexidade e de elegância
.
este método é o mais rápido e fácil dos métodos. nele é executado um multiselect, que nada mais é do que retornar vários atributos na consulta
	
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
		 * o que são tuplas?
		 * tuplas são objetos como se fosse um mapa, com chave e valor.
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
			 * tanto a typedQuery como a lista de resultado, terão o tipo de tupla.
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

8.6. Funções
algumas vezes precisamos realizar um consulta com uma restrição, sem saber a diferença se no banco está em uppercase ou lowercase.

neste caso utilizamos as funções. e para outras também.

@Test
	public void exemploFuncao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		/*
		 * RESTRIÇÃO
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

8.7. Ordenação de resultado
para ordenar uma lista de resultados, basta somente incluir na criteriaQuery um order by.

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

8.8. Join e Fetch
resumidamente: o join somente linka as tabelas, o fetch traz os dados das tabelas.

a performance de um sistema depende muito de como os seus selects são executados e seu mapeamento é criado.

vários selects e mapeamentos eager sem necessidade fazem com que o sistema fique lento.

para isso existe o join e o fetch.

uma entidade que tenha mapeamento eager com outra entidade e esta por consequência tem mapeamento eager para outra entidade e assim por consequente, o sistema fica executando selects trazendo todas as entidades mapeadas.

para contornar isso, é aconselhável colocar todas os mapeamentos como lazy, exceto os que são realmente necessários.

se realizarmos um simples select c from carro c, sem os mapeamentos corretos, ele irá trazer individualmente os selects dos mapeamentos.

ex. select c from Carro c

então para evitar esses selects indesejados, podemos utilizar o join e o fetch.
o join irá linkar as duas tabelas e o fetch irá buscar os resultados.

ex. select c from Carro c inner join fetch c.modelo

mas sem o correto mapeamento do modelo, ele irá buscar o fabricante.
para corrigir isso devemos colocar o fetchtype como lazy no mapeamento do modelo.

nisso reduzimos de umas 4 ou 5 consultas para apenas uma consulta.

Em Carro ficaria assim:
@NamedQuery(name = "Carro.buscarTodos", query = "select c from Carro c inner join fetch c.modelo"),

e nas anotações ficaria:
@ManyToOne(fetch = FetchType.LAZY) 
e em qualquer outra anotação entre entidades. adiciona-se o fetch = FetchType.LAZY

e em ModeloCarro
a mesma coisa com as anotações de relacionamentos entre entidades.

agora com criteria, basta fazer exatamente a mesma coisa.

CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");
		
		criteriaQuery.select(carro);
		criteriaQuery.where(builder.equal(modelo.get("descricao"), "Fit"));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca());
		}

8.9. Subqueries
as subqueries são outros selects realizados dentro de um select maior, onde o resultado do select menor é utilizado no select maior.

uma subquery é muito fácil de ser feita.

seguem dois exemplos: um organizado por tema e outro por selects;

Tema:
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



selects:
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


8.10. Metamodel
METAMODEL
	 * se continuarmos utilizando string para encontrar os atributos
	 * se alterarmos o nome do atributo na classe, não será possível 
	 * seguir os erros até as consultas, gerando erros somente em 
	 * tempo de execução.
	 * 
	 * o metamodel resolve este problema para nós e nos ajuda a encontrar
	 * possíveis erros de digitação ou alterações seguras em nomes de 
	 * atributos.
	 * 
	 * como utilizar o metamodel?
	 * 1- no pom, adicionar a seguinte dependência:
	 * 	<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-jpamodelgen</artifactId>
			<version>1.3.0.Final</version>
			<scope>compile</scope>
		</dependency>
		
		2-após adicionar a dependência, é necessário realizar algumas
		configurações no pom:
		
		no plugin do maven compiler, adicionar uma tag com a informação para não compilar 
		as classes geradas no metamodel:
		no <artifactId>maven-compiler-plugin</artifactId>, adicionar:
		
		<compilerArgument>-proc:none</compilerArgument>
		
		isto evita que de erro de duplicação de código.
		
		3- os outros plugins são:
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
			5- na pasta metamodel, será criado uma cópia das entidades presentes no projeto.
			a diferença é que o final do nome contém um underline _
			6- para podermos usar estas classes no projeto, temos que configurar o projeto para
			usar a pasta do metamodel, então:
				A- clicar com o botão direito no projeto e selecionar 'properties']
				B- em 'java build path' clicar em 'add folder'
				C- adicionar a pasta metamodel
			7- agora podemos utilizar os atributos criados automaticamente e cada vez que alterarmos a entidade e rodarmos o clean install, seremos avisados caso o sistema já utiliza esse atributo.


a vantagem de utilizar o metamodel é que, caso alteremos os atributos da entidade, com o metamodel é possível verificar logo possiveis erros devido a alteração dos nomes dos campos.
		
8.11. Mais consultas com Criteria
Agora que já fizemos várias consultas com Criteria, para você conseguir fazer sozinho, vou te propor esse desafio.
Tente criar consultas diferentes, baseados no nosso modelo. Me ajude e ajude os outros alunos a verem essas consultas.
Por exemplo, crie uma consulta, em um método de teste mesmo (por enquanto, no próximo você irá fazer em telas JSF), quais são os motoristas que mais alugaram carros no último mês?
Use sua imaginação e pense no que poderia ser útil para o sistema.
Não se esqueça de depois de ter criado sua consulta, deixar um comentário para os outros alunos darem uma olhada também.
8.12. Implementando mais consultas
Já fizemos muitas consultas com Criteria nos testes, agora é hora de fazê-las em telas JSF!
Aproveite algumas das suas consultas do exercício passado e desafie-se, tente criar as telas JSF para as consultas, assim você irá treinar em um sistema mais parecido com o real, passando parâmetros e visualizando na tela.
Boa sorte!
9.1. Gravação em cascata
as vezes precisamos gravar varios objetos em sequência e sem muita preocupação em como fazer isso.
para isso, podemos salvar individualmente os objetos nas sequências necessárias (o que é trabalhoso e demorado e passível de erros) ou podemos mandar o hibernate fazer isso para nós.

para isso utiliza-se o cascade.

para se utilizar o cascade, basta juntarmos a anotação cascade = CascadeType.XXXXX  no momento da definição do relacionamento.

exemplo:

@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // o cascade = CascadeType.PERSIST permite salvar o carro e juntamente salvar secundariamente um novo modelo de carro
	public ModeloCarro getModelo() {
		return modelo;
	}
isso fará com que, ao salvar um carro (persist), se no momento da persistência for verificado que o modelo setado no carro não existe em bd, ele também irá ser adicionado automaticamente.

9.2. Exercício: Gravação em cascata
Faça a gravação em cascata entre Carro e Acessório.
A ideia é você criar um método de teste que irá criar um Carro, vários Acessórios NOVOS, adicioná-los na lista e salvar o carro. Neste momento, todos os acessórios deverão ser salvos também.
@Test
	public void exercicio1() {
		/*
		 * exercicio do capitulo 9.2
		 */
		System.out.println("CRIANDO NOVO CARRO");
		Carro carro = new Carro();
		carro.setCor("Azul");
		carro.setPlaca("CCC-0124");
		
		System.out.println("CRIANDO NOVO ACESSORIO");
		Acessorio ace0 = new Acessorio();
		ace0.setDescricao("aquecedor de bancos");
		
		Acessorio ace1 = new Acessorio();
		ace1.setDescricao("espelhos retrateis");
		
		Acessorio ace2 = new Acessorio();
		ace2.setDescricao("Camera de re");
		
		Acessorio ace3 = new Acessorio();
		ace3.setDescricao("sensor de estacionamento");
		
		List<Acessorio> listaAcessorios = new ArrayList<>(0);
		
		listaAcessorios.add(ace0);
		listaAcessorios.add(ace1);
		listaAcessorios.add(ace2);
		listaAcessorios.add(ace3);
		
		carro.setAcessorios(listaAcessorios);
		
		System.out.println("INICIANDO TRY");
		try {
			
			this.manager.getTransaction().begin();
			System.out.println("PERSISTINDO");
			this.manager.persist(carro);
			this.manager.getTransaction().commit();
		}catch (Exception e) {
			System.out.println("ERRO!");
			e.printStackTrace();
		}
		
		System.out.println("CARRO PERSISTIDO!");
	}

9.3. Exclusão com Many-to-Many
a exclusão com relacionamento many to many não precisa de anotação.
no caso de carro e acessórios, nós não queremos apagar os acessórios, pois outros carros podem utilizar o acessório.
então o que queremos é somente apagar o relacionamento entre carro e acessório e apagar o carro.

isso é feito automaticamente, logo não necessitamos de nenhuma anotação para isso ocorrer
.

9.4. Exclusão em cascata
uma exclusão em um relacionamento one to many é necessário a explícita anotação do delete.
como exemplo, utilizaremos o carro e o aluguel.

supondo que, quando queremos apagar um carro também queremos apagar todos os aluguéis que aquele carro já teve, então precisamos adicionar a anotação:

@OneToMany(mappedBy = "carro", cascade = CascadeType.REMOVE)

após colocado o REMOVE na anotação, quando excluirmos um carro ele irá também excluir todos os aluguéis que este carro ja teve.

9.5. Exclusão de objetos órfãos
quando por exemplo, editamos uma lista em um objeto, exemplo um carro, e editamos a lista de aluguéis, excluindo um aluguel, este aluguel que ficou excluído da lista ficou órfão.
neste caso, precisamos adicionar uma outra anotação:
@OneToMany(mappedBy = "carro", cascade = CascadeType.PERSIST, orphanRemoval = true)


então a sequência é a seguinte:
buscamos um carro no banco e editamos a lista de aluguéis (removendo o primeiro por exemplo).
logo a seguir, persistimos o carro.

com essa ação queremos que o carro seja salvo com os aluguéis restantes (sem o que foi removido).

para que isso aconteça a anotação orphanRemoval = true tem que estar presente.

9.6. Gravação e exclusão em cascata
Como desafio tente criar um novo modelo e fazer vários testes de gravação e exclusão em cascata, inclusive com objetos órfãos.
Vou deixar para você duas entidades para você criar tudo e pensar nos testes de gravação e exclusão em cascata, assim como vimos na locadora de veículo.
É muito importante você tentar em um modelo diferente do que já vimos, irá te forçar a pensar mais.
@Entity
@Table(name = "produto")
public class Produto {
	
	private Long id;
	private String nome;
	private Categoria categoria;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// hashCode e equals
}


@Entity
@Table(name = "categoria")
public class Categoria {

	private Long id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	@Column
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(mappedBy = "categoria")
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	


10.1. Mapeando chaves compostas

chaves compostas são ids de entidades compostas por vários campos criados em outra classe.

neste exemplo iremos criar um veículo e o id dele será um objeto chamado veiculoId, que contém os campos placa e cidade.
estes dois campos serão o id composto da entidade veículo.

então vamos criar um método main, uma classe veículo e uma classe veiculoId

public static void main(String[] args) {
		/*
		 * IMPORTANTE:
		 * caso ocorram erros na criação automática das tabelas, e o erro for este:
		 * com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Specified key was too long; max key length is 1000 bytes
		 * 
		 * indica que o engine do banco foi criado usando utf-8
		 * 
		 * deve-se alterar para set GLOBAL storage_engine='InnoDb'; 
		 * 
		 * ou colocando o engine do banco como latin1
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		Veiculo v = new Veiculo();
		v.setCodigo(new VeiculoId("ABB-2222", "São Paulo"));
		v.setFabricante("honda");
		v.setModelo("civic");
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(v);
		entitymanager.getTransaction().commit();
		
		
		/*
		 * este veículo já havia sido criado anteriormente na primeira 
		 * execução do método.
		 */
		VeiculoId codigo = new VeiculoId("ABC-1111", "São Paulo");		
		Veiculo v2 = entitymanager.find(Veiculo.class, codigo);
		
		System.out.println("VEículo :" + v2.getCodigo().getPlaca());

	}



@Entity
public class Veiculo {
	
	private VeiculoId codigo;
	private String fabricante;
	private String modelo;
	
	@EmbeddedId //esta anotação significa que este campo é um id da classe mas composto e embutido
	public VeiculoId getCodigo() {
		return codigo;
	}

	public void setCodigo(VeiculoId codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	

}




@Embeddable //informa que esta classe pode ser embutida em outra classe.
public class VeiculoId implements Serializable {
	

	private static final long serialVersionUID = -8456248261923843163L;
	
	/*
	 * o campo placa e o campo cidade servirao de id para a classe veiculo.
	 * este é um exemplo de um id composto, neste caso, por duas strings:
	 * placa e cidade.
	 */
	private String placa;
	private String cidade;
	
	public VeiculoId () { }//necessário para os frameworks
		
	public VeiculoId(String placa, String cidade) {
		super();
		this.placa = placa;
		this.cidade = cidade;
	}



	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoId other = (VeiculoId) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (placa == null) {
			if (other.placa != null)
				return false;
		} else if (!placa.equals(other.placa))
			return false;
		return true;
	}
	
	
	
}





a anotação @Embeddable e correlatas indica que a classe passada ali será embutida na classe atual.
e a outra anotação @EmbedableId (????) indica que aquele campo será um id embutido.

na classe que recebe o id composto (veiculo) será criado as colunas mencionadas no veiculoid.

se repararmos o veiculoId não é uma entidade, logo ela será injetada na classe que a chamou e os campos serão criados na mesma.


10.2. Mapeando objetos embutidos
/*
	 * existem ocasiões onde queremos colocar um objeto embutido em uma classe.
	 * podemos querer manter os dados em uma única tabela para evitar joins desnecessários
	 * mas queremos manter as entidades OO separadas ou não podemos mexer no banco mas 
	 * em OO nao faz sentido manter os dados do proprietario na mesma classe.
	 * 
	 * para isso, podemos utilizar a anotaçao @Embedded em uma classe dentro de outra.
	 * 
	 * na classe embutida, podemos mapear as colunas da mesma forma que faríamos normalmente.
	 * 
	 * a única diferença é a anotação na classe embutida, que não é @Entity
	 * e a anotação na classe que receberá as colunas.
	 * 
	 * assim, ao persistir, as colunas embutidas serão criadas na tabela da entidade que a chamou.
	 */
	@Embedded
	public Proprietario getProp() {
		return prop;
	}

	public void setProp(Proprietario prop) {
		this.prop = prop;
	}
	

}



@Embeddable
public class Proprietario {
	
	private String nome;
	private String telefone;
	private String email;
	
	@Column(name="nome_proprietario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="telefone_proprietario")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="email_proprietario")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}


10.3. Propriedades transientes
propriedades transientes sao metodos gets de atributos ou concatenaçao de atributos que necessitamos em uma classe, mas que nao devem ser persistidos no banco, ou seja, nao representam um atributo persistivel.

exemplo: voce tem a classe veiculo e quer uma descriçao do veiculo, que é a concatenação da placa + fabricante.

neste caso, você cria um get na classe, que retorna a placa e fabricante. mas este atributo string, que é retornado, nao vai ser persistido na classe. logo, neste método get, devemos anota-lo com @Transient, do javax.persistence.

@Transient
	public String getDescricao() {
		return getFabricante() + " : " + getCodigo().getPlaca();
	}

10.4. Coleções de tipos básicos
coleções de tipos básicos são grupos de dados com ‘formato’ de tipos básicos do java, ou seja, string, int, etc.

quando você quer armazenar em tabelas separadas dados básicos mas nao quer fazer todo aquele mapeamento de entidades e etc. você usa uma coleção de tipo básico.

no atributo da classe, no nosso caso exemplo, uma lista de Strings que irá armazenar telefone, no get do atributo, anotamos da seguinte forma:

@ElementCollection //anotação de mapeamento informando que este atributo será armazenado em tabela separada
	@CollectionTable(name="proprietario_telefones", //nome da tabela onde armazena o vinculo do proprietário com telefone
			joinColumns=@JoinColumn(name="cod_proprietario"))//nome da coluna na tabela nova que guardara o id do proprietário
	@Column(name="numero_telefone")//nome da coluna na tabela nova que armazenará o número do telefone
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}


desta forma, irá ser criada uma tabela auxiliar, vinculando o proprietário com os telefones.

para consultar esses telefones, basta somente recuperar a entidade proprietário e por ela, acessar a lista de telefones.

10.5. Coleções com objetos embutidos
se a coleção não for de um tipo básico, for de um objeto, é muito semelhante ao anterior.

tem somente algumas alterações, conforme código abaixo:

@Entity
@Table(name="tb_proprietario_celular")
public class ProprietarioCelular {
	
	private Long id;
	private String nome;
	private List<Celular> celulares = new ArrayList<>(0);

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nome_proprietario")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ElementCollection //anotaçao de mapeamento informando que este atributo sera armazenado em tabela separada
	@CollectionTable(name="proprietario_celulares", //nome da tabela onde armazena o vinculo do proprietario com telefone
			joinColumns=@JoinColumn(name="cod_proprietario_celular"))//nome da coluna na tabela nova que guardara o id do proprietario
	@AttributeOverrides(value = { @AttributeOverride(name="numero", column=@Column(name="nr_telefone"))})
	public List<Celular> getCelulares() {
		return celulares;
	}
	public void setCelulares(List<Celular> celulares) {
		this.celulares = celulares;
	}
}


@Embeddable
public class Celular {
	
	private String prefixo;
	private String numero;
	
	public Celular(String prefixo, String numero) {
		super();
		this.prefixo = prefixo;
		this.numero = numero;
	}

	public Celular() {
		super();
	}

	public String getPrefixo() {
		return prefixo;
	}

	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}

10.6. Objetos grandes
para guardar objetos grandes como fotos ou vídeos, é bem simples. a anotação @Blob somente faz o trabalho, conforme podemos ver no código abaixo:

no arquivo POM.xml adicionamos:
<!-- 	DEPENDENCIA NECESSARIA PARA REALIZAR O UPLOAD DE ARQUIVOS -->
		<dependency>
   			<groupId>commons-fileupload</groupId>
    		<artifactId>commons-fileupload</artifactId>
    		<version>${commons-fileupload.version}</version>
    		<scope>compile</scope>
		</dependency>		
<!-- 	FIM DEPENDENCIA NECESSARIA PARA REALIZAR O UPLOAD DE ARQUIVOS -->	

No arquivo CadastroCarroBean.java :
//	atributo criado para realizar o upload da foto do carro
	private UploadedFile fotoCarro;


este atributo é utilizado pelo primefaces para realizar o upload da foto.

em Carro.java

//	atributo criado para realizar o upload da foto do carro
	private UploadedFile fotoCarro;

….
	@Lob //anotaçao importante para upload da foto
	@Column(name="foto_carro")
	public byte[] getFoto() {
		return this.foto;
}

public boolean hasFoto() {
		return this.foto != null && this.foto.length > 0;
}

e no web.xml adicionamos o filtro do primefaces:
<!-- FILTRO NECESSARIO PARA FAZER O UPLOAD DE ARQUIVOS -->
    <filter>
        <filter-name>PrimeFaces FileUpload Filter</filter-name>
        <filter-class>org.primefaces.webapp.filter.FileUploadFilter</filter-class>
    </filter>
    
    <filter-mapping>
        <filter-name>PrimeFaces FileUpload Filter</filter-name>
        <servlet-name>Faces Servlet</servlet-name>
    </filter-mapping>
<!-- FIM FILTRO NECESSARIO PARA FAZER O UPLOAD DE ARQUIVOS -->

e em cadastroCarro.xhtml
o form deve estar com a seguinte alteraçao:
<!-- importante para o upload da foto  enctype="multipart/form-data"-->
    	<h:form id="frmCadastro" enctype="multipart/form-data">


e neste caso especifico, devemos retirar o ajax do botao
<!-- importante para o upload da foto  ajax="false"-->
	    			<p:commandButton value="Salvar" id="botaoSalvar" action="#{cadastroCarroBean.salvar}" update="frmCadastro" ajax="false" />

e adicionamos as tags para o upload:
<p:outputLabel value="Foto" for="foto"/>
			    <h:panelGroup>
			    	<p:commandButton rendered="#{cadastroCarroBean.carro.hasFoto()}" icon="ui-icon-extlink" title="Imagem"
			    			process="@this" oncomplete="PF('mostraImagem').show()" update=":frmCadastro:mostraImagemDialog">
						<f:setPropertyActionListener target="#{fotoCarroBean.carroSelecionado}" value="#{cadastroCarroBean.carro}" />
					</p:commandButton>
			    	<p:fileUpload id="foto" value="#{cadastroCarroBean.fotoCarro}" mode="simple"/>

			    </h:panelGroup>

e pronto!

OBS:
em versões mais atualizadas do primefaces ocorre o erro onde  o método getContents() vem sempre null, é necessário usar o método getInputStream e transformar em array de bytes

OBS 2:
Para mapeamento de objetos grandes usamos o @Lob 

10.7. Exibindo a imagem
Agora que já temos uma imagem no banco de dados, tenho uma proposta para você.
Será você mostrar a imagem através de um código simples, utilizando o JOptionPane. 
Você pode usar a parte de testes do projeto locadora-veiculo-web e criar mais um teste com o código abaixo.
@Test
public void buscaFoto() throws IOException {
	Carro carro = manager.find(Carro.class, 18L);
		
	if (carro.getFoto() != null) {
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(carro.getFoto()));
		JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
	} else {
		System.out.println("Carro não possui foto.");
	}
}
11.1. Schema e Catalog
alguns bancos como o Oracle utilizam a definição de schema e catalog.

é somente um parâmetro na definição da anotação @Table. ela organiza bancos novos e ajuda na implementação em bancos legados.

no arquivo Persistence.xml adicione a property:
<property name="hibernate.default_schema" value="locadora" />

onde:
<property name="hibernate.default_schema" value="nome_schema_principal_do_banco" />


agora , nas entidades, adicione a anotação:
@Table(name="tb_carro", schema="teste")


neste exemplo, todas as classes que não tiverem a definição do schema, serão criadas no schema ‘locadora’ e a entidade Carro será criada no schema ‘teste’


11.2. Mais detalhes de @Column
existem algumas propriedades ou circunstâncias que gostariamos de deixar no controle do banco de dados.
para isso, utilizamos os parâmetros na anotação @Column e na anotação @JoinColumn.

por exemplo, gostaríamos de deixar um campo marcado no banco de dados que este nao pode ser nulo.
então passamos como parâmetro nullable=false.

outros exemplos são;
name=”nome_da_coluna_no_BD”
nullable=true/false
unique=true/false
insertable=true/false
updatable=true/false


11.3. Problema n+1
um problema de performance que pode ocorrer em uma anotação @ManytoOne é o problema do n+1.
mas o que é isto? imagine que queremos fazer um select de carro:
select * from carro

como carro tem uma anotação com modelo de carro @ManyToOne, ou seja, muitos carros possuem um modelo, executando essa consulta, para cada carro encontrado, ele irá tambem realizar outro select para o modelo. isso para CADA carro encontrado na tabela. isso não é eficiente.

então para isso, utilizamos o inner join.
o inner join faz com que seja executado somente um select no banco, que reptorna os resultados todos juntos.

em HQL a query com problemas seria:
from Carro c

e HQL corrigida seria 
from Carro c inner join fetch c.modelo

e em criteria ficaria:
Session session = manager.unwrap(Session.class);
Criteria criteria = session.createCriteria(Carro.class);
criteria.createAlias("modelo", "m"); //Aqui faz a associação entre as entidades e busca o modelo
List<Carro> carros = criteria.list();



11.4. Cache de primeiro nível
o cache de primeiro nível nada mais é do que a manutenção dos valores recuperados no banco de dados no entitymanager enquanto este estiver aberto.

exemplo:
caso eu solicite uma lista de carros em um select e sem deixar fechar o entity manager eu solicite um carro que já está contido naquele select, ele nao ira fazer um novo select, pois o cahce de primeiro nivel o manteve.

agora, se fecharmos o entitymanager e executarmos o mesmo select, ele ira fazer dois selects, um para obter a lista, ai o entity manager é fechado, e outro para obter o carro no segundo select.

o local onde se abre e fecha a transação é importante, pois no local correto auxilia no desempenho do sistema.

ex:
/*
	 * neste exemplo, o entitymanager sao dois, aberto no inicio do metodo e fechado no final da primeira consulta 
	 * e é criado outro logo em seguida,
	 * que nao tem em cache os valores dos selects e 
	 * por isso é repetindo o select novamente.
	 * 
	 */
	@Test
	public void exemploSemCache() {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		}
		
		//aqui fechamos o entitymanager
		this.manager.close();
		//aqui reabrimos o entitymanager
		this.manager = factory.createEntityManager();
		
		
		System.out.println("------------------------------------");
		Carro carro = this.manager.find(Carro.class, 10L);
		System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
	}
	
	/*
	 * neste exemplo, o entitymanager é somente um, aberto no inicio do metodo e fechado somente no final do método
	 * mantendo em cache todos os valores dos selects e nao repetindo-os novamente.
	 * 
	 */
	@Test
	public void exemploComCache() {
		TypedQuery<Carro> query = this.manager.createQuery("from Carro c", Carro.class);
		List<Carro> carros = query.getResultList();
		
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		}
		
		
		
		System.out.println("------------------------------------");
		Carro carro = this.manager.find(Carro.class, 10L);
		System.out.println(carro.getPlaca() + " - " + carro.getModelo().getDescricao());
		
	}
	
11.5. Consultas nativas
utilizar consultas nativas nada mais é do que fazer a aplicação executar o sql puro, aquele que podemos rodar no mysql workbench ou em qualquer gerenciador de BD.

a unica alteração é que , no entitymanager, devemos solicitar um createNativeQuery em vez de um createQuery normal.

TypedQuery<Carro> query = (TypedQuery<Carro>) this.manager.createNativeQuery(" SELETC * FROM  teste.tb_carro c");
		List<Carro> carros = query.getResultList();


11.6. Testes com jUnit, DBUnit e JIntegrity
Esta aula referência a testes de integração. 
utilizaremos o Junit, o DBUnit e o JIntegrity.

os testes de integração faz os testes entre sistemas, no caso, o sistema e o mysql.

vamos configurar a aplicação;

no POM.xml adicionamos;

<!-- DBUnit --> 
 		<dependency> 
 			<groupId>org.dbunit</groupId> 
 			<artifactId>dbunit</artifactId> 
 			<version>2.4.9</version> 
 			<scope>test</scope> 
 		</dependency> 
 
 		<!-- Necessário para o DBUnit --> 
 		<dependency> 
 			<groupId>org.slf4j</groupId> 
 			<artifactId>slf4j-api</artifactId> 
 			<version>1.5.6</version> 
 			<scope>test</scope> 
 		</dependency> 
 		<dependency> 
 			<groupId>org.slf4j</groupId> 
 			<artifactId>slf4j-simple</artifactId> 
 			<version>1.5.6</version> 
 			<scope>test</scope> 
 		</dependency> 
 
 		<!-- jIntegrity --> 
 		<dependency> 
 			<groupId>com.jintegrity</groupId> 
 			<artifactId>jintegrity</artifactId> 
 			<version>0.1.2</version> 
 			<scope>test</scope> 
 		</dependency> 



agora em src/test/resources, criamos o jintegrity.properties

path=xml
xml=Carro,CarroAcessorio


e agora criamos os XML referidos no jintegrity.properties, dentro da pasta XML:

Carro.xml

<?xml version="1.0" encoding="UTF-8"?>

<dataset>
	<carro codigo="100" placa="AAA-1111" valorDiaria="200.0" dataCriacao="2013-10-12 10:00:00" />
</dataset> 

e CarroAcessorio.xml

<?xml version="1.0" encoding="UTF-8"?>

<dataset>
	<carro_acessorio />
</dataset> 

e agora configuramos o hibernate.properties, que o jintegrity irá utilizar para se conectar com o banco de dados  e executar as alterações no banco de teste.

hibernate.connection.driver_class=com.mysql.jdbc.Driver 
hibernate.connection.url=jdbc:mysql://localhost:3306/locadora 
hibernate.connection.username=root 
hibernate.connection.password=root 

agora criamos a classe CarroDAOTest.java

package com.algaworks.curso.jpa2.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Carro;
import com.jintegrity.core.JIntegrity;
import com.jintegrity.helper.JPAHelper;

public class CarroDAOTest {

	private JIntegrity helper = new JIntegrity();
	
	private CarroDAO carroDAO;
	
	@Before
	public void init() {
		helper.cleanAndInsert();
		
		this.carroDAO = new CarroDAO();
		this.carroDAO.setEntityManager(JPAHelper.currentEntityManager());
	}
	
	@Test
	public void buscarCarroPeloCodigo() {
		Carro carro = this.carroDAO.buscarPeloCodigo(1L);
		
		assertEquals(1L, carro.getCodigo().longValue());
		assertEquals("AAA-1111", carro.getPlaca());
	}
	
}


em em CarroDAO.java adicionamos o metodo

public void setEntityManager(EntityManager em) {
		this.manager = em;
	}

pois não temos a injeção de dependência no teste, logo é preciso inserir o entityManager manualmente.

11.7. Bean Validation
o bean validation nada mais é do que utilizar o sistema para validar certas propriedades das entidades ao salvar.

a integração com o JSF e o bean validation é muito boa nao sendo necessario nada além de anotações nas colunas, que a mensagem é exibida na tela.

primeiro precisamos adicionar no POM a dependência do bean validation

<!-- 		BEAN VALIDATION -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>5.0.1.Final</version>
			<scope>compile</scope>
		</dependency>
agora, na entidade, no método get ou onde você coloca as anotações das colunas, podemos colocar as anotações:

@NotNull -- não permite inserir nulos (somente validação de campo, para obrigar no BD usar o @Column nullable)
@NotEmpty -- o not empty verifica se a string ou colocação tem tamanho maior que zero , o que pode ter um monte de strings vazias que passará
@NotBlank -- o not blank verifica se é nulo e verifica se depois do trim nao pode ser vazio


na anotação colocamos a mensagem que queremos ser exibidas
@NotBlank(message=”mensagem a ser exibida”)

uma coisa interessante é que você pode construir suas próprias anotações de validação.
existem várias anotações do bean validation que você pode utilizar.

mais informações:

https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-validating-bean-constraints


mais exemplos:

@NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;

    @Min(2)
    private int seatCount;


11.8. Aplicação Java EE no Glassfish
ver a aula 11.8, devido a complexidade de explicaçao da instalação.

12.1. Introdução - Restrições between e eq
a criteria do hibernate é muito mais facil do que a criteria do JPA. é muito mais simples.

veja este exemplo:

para fazer somente um select * from, usamos:

		Session session = this.manager.unwrap(Session.class); 
// o entity manager contém a session do hibernate. utilizando o unwrap, agente consegue obter a session do hibernate.
		Criteria criteria = session.createCriteria(Aluguel.class); // criamos a criteria do hibernate
				
		return criteria.list(); // se somente utilizarmos esta linha é equivalente a select * from
	}

isto é equivalente a select * from tb_aluguel.

para colocarmos alguns wheres na query, utilizamos as restrictions.

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
	


12.2. Função de agregação sum e restrições sql
as funções de agregação nada mais sao do que funções do banco de dados, que nos retornam um resultado onde é calculado dependendo do tipo da função passada.
neste exemplo, foi utilizada um exemplo de soma (sum), entao o banco ira somar todos os resultados das colunas passadas e retornar o resultado, em vez de retornar uma lista de entidades onde iriamos ter que fazer um for e somar todos os resultados.

as restriçoes SQL sao funcoes em SQL nativo que, facilitam o select. neste exemplo, passamos o mes de uma data e queremos todos os resultados daquele mes.

public BigDecimal calcularTotalDoMesDe(int mes) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Aluguel.class); //cria uma criteria normal
		
		/*projections são utilizadas quando não queremos a entidade
		 * toda, somente um pedaço dela (colunas) ou o retorno de uma função
		 * do SQL, como é o caso desta.
		 */
		criteria.setProjection(Projections.sum("valorTotal")); //queremos que retorne somente uma coluna com o resultado da soma
		//restrição utilizando SQL nativo, passando uma function que encontra todas as datas com o mês passado
//		criteria.add(Restrictions.sqlRestriction("SQL_function = ?", nome do parametro para utilizar, tipo_do_parametro));
		criteria.add(Restrictions.sqlRestriction("month(dataPedido) = ?", mes, StandardBasicTypes.INTEGER));
		
		return (BigDecimal) criteria.uniqueResult();
	}


12.3. Criando subselects
as vezes é necessário utilizar um subselect em um select maior.

como exemplo:

SQL:

select * from carro where codigo not in ( select codigo_carro from aluguel where codigo_carro is not null)

//OBS: se deixar buscar pelos nulos corre o risco de não trazer nenhum, pois se existir algum valor nulo, ele inviabiliza o select


CRITERIA DO HIBERNATE
Session session = this.manager.unwrap(Session.class);
Criteria criteria = session.createCriteria(Carro.class);
		
		//o DetachedCriteria é o objeto utilizado nos subselect do criteria do hibernate
		DetachedCriteria criteriaAluguel = DetachedCriteria.forClass(Aluguel.class)
				.setProjection(Projections.property("carro")) //queremos somente o id do carro
				.add(Restrictions.isNotNull("carro")); // clausula where

		criteria.add(Property.forName("codigo").notIn(criteriaAluguel)); //inserção do subselect no select principal

		return criteria.list();


CRITERIA DO JPA

  Subquery<Aluguel> subquery = criteriaQuery.subquery(Aluguel.class);
		  Root<Aluguel> rootAluguel = subquery.from(Aluguel.class);
		  subquery.select(rootAluguel.get("carro.codigo"));
		  subquery.where(criteriaBuilder.isNotNull("carro.codigo"));

		  CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		  CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery();
		  Root<Carro> root = criteriaQuery.from(Carro.class);
		  criteriaQuery.where(root.get("codigo").in(subquery).not());

		  TypedQuery<Lancamento> query = entityManager.createQuery(criteriaQuery);    
		  return query.getResultList();


12.4. LazyLoading e o FetchMode
a exception de lazy loading ocorre quando buscamos um objeto, como por exemplo, carro, e nele, tem uma coleçao, no caso, de acessorios, marcada como LAZY.

se a sessao que o buscou nao foi fechada, entao, ao acessar a coleçao, o hibernate ira efetuar novo select no banco para retornar os valores.

isso geralmente não ocorre com sistema web, pois a sessão costuma ser fechada logo apos o retorno dos valores.
e um segundo select não é muito apropriado.

logo quando a aplicação tentar acessar a lista de acessórios, irá ocorrer o lazyloadingexception.

a outra solução nada apropriada é alterar o fetchmode da lista de LAZY para EAGER, mas ai impactamos todo o sistema.

a solução correta é, na query que você está executando, utilizar o fetch mode. assim, somente a sua query irá trazer os valores da lista.

	@Test
	public void simulaLazyLoading() {
		/*
		 * simulando um ambiente web, onde, logo apos o retorno de uma consulta, e o fechamento da sessao, 
		 * se tenta acessar uma lista LAZY
		 */
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.add(Restrictions.eq("codigo", 3L));
		
		Carro c = (Carro) criteria.uniqueResult();
		
		System.out.printf("Codigo: %d. Placa: %s\n", c.getCodigo(), c.getPlaca());
		
		
		session.close();
		
		/*
		 * aqui ocorre o erro de lazyLoading
		 */
		for (Acessorio acessorio : c.getAcessorios()) {
			System.out.println(acessorio.getDescricao());
		}
	}
	
	@Test
	public void simulaLazyLoadingCorrigido() {
		/*
		 * simulando um ambiente web, onde, logo apos o retorno de uma consulta, e o fechamento da sessao, 
		 * se tenta acessar uma lista LAZY
		 */
		
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.setFetchMode("acessorios", FetchMode.JOIN); //ao colocarmos neste select o fetch mode join, iremos buscar a lista

		
		criteria.add(Restrictions.eq("codigo", 3L));
		
		Carro c = (Carro) criteria.uniqueResult();
		
		System.out.printf("Codigo: %d. Placa: %s\n", c.getCodigo(), c.getPlaca());
		
		
		session.close();
		
		/*
		 * aqui nao ocorre mais o erro de lazyLoading
		 */
		for (Acessorio acessorio : c.getAcessorios()) {
			System.out.println(acessorio.getDescricao());
		}
	
	}

12.5. Transforme, ordene e agrupe a consulta
public List<TotalDeAlugueisPorCarro> buscarTotalAlugueisPorCarro() {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Carro.class);
		
		
		/*
		 * select c.placa
		 * 	, count(a.codigo)
		 * from carro c,
		 * aluguel a
		 * where c.codigo = a.codigo_carro
		 * group by c.placa
		 * order by count(a.codigo)
		 */
		
		criteria.createAlias("alugueis", "a");

		ProjectionList pl = Projections.projectionList()
				.add(Projections.groupProperty("placa").as("placa"))
				.add(Projections.count("a.codigo").as("totalDeAlugueis"));
		
		criteria.setProjection(pl);
		
		criteria.addOrder(Order.asc("totalDeAlugueis"));
		
		criteria.setResultTransformer(Transformers.aliasToBean(TotalDeAlugueisPorCarro.class));

		return criteria.list();
	}
12.6. Navegando e filtrando nos relacionamentos
mostrando um pouco sobre os alias e sobre o ilike.
navegar por relacionamentos de classes no criteria é muito facil.

ex:

String testeInput = "volks"; //simulaçao de inserçao do input
		
		Session session = this.manager.unwrap(Session.class);
		
		Criteria criteria = session.createCriteria(Carro.class);
		
		criteria.createAlias("modelo", "m"); //ALIAS
		criteria.createAlias("m.fabricante", "f"); //ALIAS
		
		criteria.add(Restrictions.ilike("f.nome", testeInput, MatchMode.ANYWHERE)); // equivalente ao ilike do sql. o matchmode indica onde queremos encontrar a string
		
		
		List<Carro> carros = criteria.list();
		for (Carro carro : carros) {
			System.out.println(carro.getPlaca());

13.1. Conversores
algumas das novidades do JPA 2.1 são os conversores.
os conversores servem para converter algum objeto entre o sistema e o banco de dados.
exemplo: queremos usar no sistema a classe LocalDate do java 8, mas ela ainda nao é suportada pelo hibernate. se usarmos o @Temporal, ele irá gerar um erro, pois ele somente pode ser utilizado em Date e Calendar.

então, neste caso, utilizamos um converter.

criamos uma classe para servir de exemplo, neste caso usuario.class

@Entity
@Table(name="tb_usuario", schema="locadora")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String nome;
	
	/*
	 * o que o converter faz? ele irá converter uma classe que não existe no hibernate, como o LocalDate para uma classe que existe.
	 * nisso ele facilita a utilização de classes no sistema.
	 */
	@Convert(converter=LocalDateConverter.class)//necessário pois o hibernante ainda não implementa o LocalDate, mas pode ser utilizado para qualquer classe, mesmo as personalizadas
	@Column(name="dt_nasc")
	private LocalDate dataNascimento;
...
}

e criamos o converter desta forma:

@Converter
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{
//	AttributeConverter<OBJETO_NO_SISTEMA, OBJETO_NO_BANCO>
	/*
	 * (non-Javadoc)
	 * @see javax.persistence.AttributeConverter#convertToDatabaseColumn(java.lang.Object)
	 * 
	 * este converter serve para o JPA converter o localDate para DAte para persistir no banco e vice versa
	 */

	@Override
	public Date convertToDatabaseColumn(LocalDate atributo) {
		Instant instant = atributo.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
		return Date.from(instant);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date atributo) {
		Instant instant = Instant.ofEpochMilli(atributo.getTime());
		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
	}
	

}


pronto.
agora usamos o LocalDate no sistema mas ele ira salvar o Date no banco, ate o hibernate ser compativel com o java 8 por exemplo.

13.2. Delete e Update com Criteria
o criteria do JPA 2.1 vem com a possibilidade de DELETE e UPDATE utilizando criteria.
OBS: o criteria do Hibernate não vem com essa funcionalidade (por enquanto)

UPDATE
this.manager.getTransaction().begin();
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaUpdate<Fatura> criteria = builder.createCriteriaUpdate(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);
		
		criteria.set("vencida", true) //clausa SET do update
				.where(builder.lessThan(root.<Date>get("vencimento"), Date.from(LocalDate.of(2018, 7, 20).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()))); //clausula where
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
		this.manager.getTransaction().commit();
 
DELETE 
this.manager.getTransaction().begin();
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaDelete<Fatura> criteria = builder.createCriteriaDelete(Fatura.class);
		Root<Fatura> root = criteria.from(Fatura.class);
		
		criteria.where(builder.lessThan(root.<Date>get("vencimento"), new Date()));
		
		Query query = this.manager.createQuery(criteria);
		query.executeUpdate();
		this.manager.getTransaction().commit();

13.3. Convertendo o resultado de queries nativas
podemos converter o resultadio de uma native query de varios modos.

vamos ver um deles, utilizando named query e uma anotaçao nova no JPA2.1, chamada de @SqlResultSetMapping

@NamedNativeQuery(name="alertasPorUsuario",
	query="select u.nome as nome, " + 
			" count(a.codigo) as totalAlertas " + 
			" from tb_usuario u, tb_acesso a " + 
			" where u.codigo = a.usuario " + 
			" group by u.nome", //isto ira retornar um object array se nao convertermos
			resultSetMapping="alertasPorUsuarioMapping"
		)
@SqlResultSetMapping(name="alertasPorUsuarioMapping", 
		classes= {
				@ConstructorResult(
						targetClass=AlertasPorUsuario.class, 
						columns= {
							@ColumnResult(name="nome"),
							@ColumnResult(name="totalAlertas")
						}
				)
		}
	)
@Entity
@Table(name="tb_usuario", schema="locadora")
public class Usuario implements Serializable{
….


public class AlertasPorUsuario {
	
	private String nome;
	private BigInteger totalAlertas;
	
	public AlertasPorUsuario(String nome, BigInteger totalAlertas) {
		this.nome = nome;
		this.totalAlertas = totalAlertas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getTotalAlertas() {
		return totalAlertas;
	}

	public void setTotalAlertas(BigInteger totalAlertas) {
		this.totalAlertas = totalAlertas;
	}

	@Override
	public String toString() {
		return "AlertasPorUsuario [nome=" + nome + ", totalAlertas=" + totalAlertas + "]";
	}
	
	

}

/*
	 * exemplo sem utilizar o namedQuery
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios1() {
		String queryString = "select u.nome as nome, count(a.codigo) as totalAlertas from tb_usuario u, tb_acesso a where u.codigo = a.usuario group by u.nome";
		
		
		List<AlertasPorUsuario> lista = this.manager.createNativeQuery(queryString, "alertasPorUsuarioMapping").getResultList();
		
		for (AlertasPorUsuario alerta : lista) {
			System.out.println(alerta);
		}
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * foreach do java 7
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios2() {
		
		
		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		for (AlertasPorUsuario alerta : lista) {
			System.out.println(alerta);
		}
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * 
	 * lambda tipo 1
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios3() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach((AlertasPorUsuario a) -> System.out.println(a));
		
	}
	
	/*
	 * exemplo utilizando o namedQuery
	 * 
	 * lambda tipo 2
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios4() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach( a -> System.out.println(a));
		
	}
	
	/*
	 * exemplo utilizanado o namedQuery
	 * 
	 * lambda tipo 3
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void buscaAcessosDeUsuarios5() {

		List<AlertasPorUsuario> lista = this.manager.createNamedQuery("alertasPorUsuario").getResultList();
		
		lista.forEach(System.out::println);
		
	}

13.4. Gerando o schema
o JPA 2.1 também trouxe alguma facilidades na construção do schema no persistance.XML.


<?xml version="1.0" encoding="UTF-8"?>
<!-- USANDO JPA 2.0 -->
<!-- <persistence version="2.0" -->
<!-- 	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" -->
<!-- 	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"> -->
	
	
<!-- USANDO JPA 2.1	 -->
<persistence version="2.1" 
 	xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
 	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence 
  		http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"> 

 
	
	
	
	<!-- controle de transação por RESOURCE_LOCAL -->
	<persistence-unit name="locadoraVeiculoPU" transaction-type="RESOURCE_LOCAL">
		<non-jta-data-source>java:comp/env/jdbc/locadoraDB</non-jta-data-source>
		<properties>
<!-- 		NÃO UTILIZAR ESTA PROPRIEDADE EM AMBIENTE DE PRODUÇÃO -->
			<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" /> 
<!-- 			POSSÍVEIS VALORES = none, create, drop-and-create, drop -->
<!-- 			COM A PROPERTY ACIMA DO JPA 2.1, A PROPERTY ABAIXO DEIXA DE SER NECESSÁRIA. ATENÇÃO: SOMENTE PARA JPA 2.1 -->
<!-- 			<property name="hibernate.hbm2ddl.auto" value="update"/> -->

<!-- POSSIBILIDADE DE ADICIONAR SCRIPS PARA CRIAR TABELAS ALÉM DAS DO SISTEMA (METADATA), INDO EM UM SCRIPT PARA CRIAR -->
<!-- POSSÍVEIS VALORES: metadata, metadata-then-script, script-then-metadata, script -->
 			<property name="javax.persistence.schema-generation.create-source" value="metadata-then-script" /> 
 			<property name="javax.persistence.schema-generation.create-script-source" value="META-INF/sql/criar-tabelas.sql"/> 


 			<property name="javax.persistence.schema-generation.drop-source" value="metadata-then-script" /> 
<!-- POSSÍVEIS VALORES: metadata, metadata-then-script, script-then-metadata, script -->
 			<property name="javax.persistence.schema-generation.drop-script-source"  value="META-INF/sql/dropar-tabelas.sql"/> 
 			
 			
 			<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/carregar-dados.sql"/> 
			
		
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
			<property name="hibernate.show_sql" value="true"/>
			
			<property name="hibernate.default_schema" value="locadora" />
			
		</properties>
	</persistence-unit>
	
<!-- 	TESTE COM OUTRO PERSISTENCE UNIT PARA JUNIT -->
	<persistence-unit name="junitPU" transaction-type="RESOURCE_LOCAL">
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/locadora"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="root"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
		
			<property name="hibernate.default_schema" value="locadora" />
			
<!-- 		NÃO UTILIZAR ESTA PROPRIEDADE EM AMBIENTE DE PRODUÇÃO -->
			<property name="javax.persistence.schema-generation.database.action" value="drop-and-create" /> 
<!-- 			POSSÍVEIS VALORES = none, create, drop-and-create, drop -->
<!-- 			COM A PROPERTY ACIMA DO JPA 2.1, A PROPERTY ABAIXO DEIXA DE SER NECESSÁRIA. ATENÇÃO: SOMENTE PARA JPA 2.1 -->
<!-- 			<property name="hibernate.hbm2ddl.auto" value="update"/> -->

<!-- POSSIBILIDADE DE ADICIONAR SCRIPS PARA CRIAR TABELAS ALÉM DAS DO SISTEMA (METADATA), INDO EM UM SCRIPT PARA CRIAR -->
<!-- POSSÍVEIS VALORES: metadata, metadata-then-script, script-then-metadata, script -->
 			<property name="javax.persistence.schema-generation.create-source" value="metadata-then-script" /> 
 			<property name="javax.persistence.schema-generation.create-script-source" value="META-INF/sql/criar-tabelas.sql"/> 


 			<property name="javax.persistence.schema-generation.drop-source" value="metadata-then-script" /> 
<!-- POSSÍVEIS VALORES: metadata, metadata-then-script, script-then-metadata, script -->
 			<property name="javax.persistence.schema-generation.drop-script-source"  value="META-INF/sql/dropar-tabelas.sql"/> 
 			
 			
 			<property name="javax.persistence.sql-load-script-source" value="META-INF/sql/carregar-dados.sql"/> 
			
			
			
			
			
			
			
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
			<property name="hibernate.show_sql" value="true"/>
			
		</properties>
	</persistence-unit>
</persistence>


também foi inserido a criação de indexes por anotação:

@Entity
@Table(name="tb_usuario", schema="locadora", 
	indexes= { // criação de índices para melhora da performance de consultas
			@Index(columnList="nome", unique=true),//criação do índice, colocando o nome com a constraint de ser único também
			@Index(columnList="nome, dt_nasc") // criaçao do índice composto, com nome e data de nascimento
			}
)
public class Usuario implements Serializable{
…


13.5. Conclusão
https://www.thoughts-on-java.org/whats-new-in-jpa-2-2/

What’s new in JPA 2.2
At the beginning of this month, Oracle published a Maintenance Draft Review for JPA 2.2, and the Review Ballot will close at the end of this week. So, it’s about time to have a look at the maintenance release and the changes it will bring to the specification.
As expected, it’s only a small release, and I think that’s ok. JPA 2.1 already provides a good enough toolset for most applications. But there was nevertheless some work to do.
Unfortunately, it’s very hard to get details about the changes in JPA 2.2. The expert group only published a short changelog which lists 5 proposed changes and links to the corresponding github artifacts. But these are not updated. Most of them are still open and have no commit links. So, I did my best to collect the information from the changelog, github and the mailing list. I will update this post as soon as there is an updated version of the specification.
So, here’s a list of the proposed changes.
 
Stream query results
This change is tracked in the JPA spec issue #99 and it might sound familiar to you. Hibernate introduced a similar feature in version 5.2.
The JPA interfaces Query and TypedQuery got a new method called getResultStream() which returns a Java 8 Stream of the query result. By default, this method delegates to getResultList().stream(). But a persistence provider, like Hibernate, can override it to provide a better implementation.
That’s what Hibernate already does with the stream() method of its proprietary version of the Query interface. Instead of fetching all records of the query result at once, it uses a ScrollableResult to scroll through the result records. This is way more efficient if you need to process a huge result set.
I expect that the Hibernate Team will provide the same functionality for the getResultStream() method as soon as a final version of JPA 2.2 got released. So you will then able to use the following code to scroll through your query results.
1
2
3
Stream<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultStream();
books.map(b -> b.getTitle() + " was published on " + b.getPublishingDate())
    .forEach(m -> log.info(m));
 
Make annotations @Repeatable
This is another Java 8 related change and it’s tracked in the JPA spec issue #115.
It allows you to use the same annotation multiple times for a class or attribute without using a container annotation. So, you can annotate your entity class with multiple @NamedQuery annotations without wrapping them in a @NamedQueries annotation. This makes the code much easier to read, as I showed when Hibernate made their annotations @Repeatable.
With JPA 2.2, the following annotations will be repeatable:
AssociationOverride
AttributeOverride
Convert
JoinColumn
MapKeyJoinColumn
NamedEntityGraph
NamedNativeQuery
NamedQuery
NamedStoredProcedureQuery
PersistenceContext
PersistenceUnit
PrimaryKeyJoinColumn
SecondaryTable
SqlResultSetMapping
 
Support Java 8 Date and Time API
The Date and Time API was one of the most popular features in Java 8. It’s no surprise that a lot of developers were asking for official support in JPA even so you can add it with a simple AttributeConverter .
With JPA 2.2, you will no longer need the converter. As documented in the JPA spec artifact 63, JPA 2.2 will add the support for java.time.LocalDate, java.time.LocalTime, java.time.LocalDateTime, java.time.OffsetTime and java.time.OffsetDateTime.
Unfortunately, the github artifact doesn’t provide any information on how these classes will be supported. But I guess they will be supported as basic types as suggested in the first comment of issue 63. Hibernate already showed that the classes of the Date and Time API provide all required information to map them to the correct database columns and that there is no need for the old @Temporal annotation.
So, you will, most likely, be able to use the classes of the Date and Time API as shown in the following code snippet.
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
@Entity
public class MyEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
     
    @Column
    private LocalDate date;
     
    @Column
    private LocalDateTime dateTime;
     
    ...
}
 
Support CDI Injection in AttributeConverters
This is probably just a minor improvement for most developers. With JPA 2.2 you will be able to use CDI injection in your AttributeConverter. You can follow the discussion about this change in artifact 109.
The support for CDI Injection will allow you to inject your reusable conversion implementation into an AttributeConverter.
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
@Converter(autoApply = true)
public class MyAttributeConverter implements AttributeConverter<MyObject, String> {
 
    @Inject
    private Converter convert;
     
    @Override
    public String convertToDatabaseColumn(MyObject obj) {
        return convert.toString(obj);
    }
 
    @Override
    public MyObject convertToEntityAttribute(String s) {
        return convert.toMyObject(s);
    }
}
 
Change Persistence Provider Discovery Mechanism for Java 9 Modules
A lot of frameworks and specifications require a few adaptions to work with the JDK9 module system. That’s also the case for the JPA specification and it got discussed in artifact #146.
The expert group changed the wording of the specifcation in a few places so that the persistence provider implementation now needs to provide a service provider configuration which can be used in a Java SE environment.
 
Summary
The JPA 2.2 MR suggests just a small set of changes to adapt JPA to Java 8 and prepare it for the Java 9 module system. As I wrote at the beginning of this post, that’s not an issue because version 2.1 already provided a powerful toolset.
But I had hoped for a few more changes. The different JPA implementations support several proprietary features which would make the specification a lot better, like the support for ad-hoc joins in JPQL or a better API to load multiple entities by their primary key.
Let’s hope that we get some of them with Java EE 9. So far, Oracle only announced that they want to release it in 2018 but didn’t say anything about the scope of it.
14.2. Tipos de cache do Hibernate
existem 3 tipos diferentes de cache:
o cache de 1º nível, que é o cache da sessão do entity manager. enquanto o entity manager estiver aberto, ele irá manter os dados em memória, sendo este manter um cache de sessao ou de 1º nível.

existe o cache de 2º nível, que é um cache de entidades.
e existe também o cache de query que é o cache de consultas.

14.3. Cache de segundo nível
neste exemplo, iremos demonstrar como o cache funciona. iremos utilizar uma propriedade do hibernate para testes. no POM devemos adicionar:
<!-- Hibernate Testing --> 
  		<dependency> 
  			<groupId>org.hibernate</groupId> 
  			<artifactId>hibernate-testing</artifactId> 
  			<version>4.3.5.Final</version> 
  			<scope>compile</scope> 
  		</dependency> 

e no persistence.xml:
<property name="hibernate.cache.region.factory_class" value="org.hibernate.testing.cache.CachingRegionFactory"/>

essa configuração é para configurar as fábricas onde o hibernate irá guardar as informações do cache.

nas entidades, basta somente anotar a entidade desta forma:
@Entity
@Table(name = "estado")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Estado implements Serializable {

possíveis valores para o CacheConcurrencyStrategy:
NONSTRICT_READ_WRITE -- informa que a entidade pode ser alterada a qualquer momento
NONE -- nao tem nenhuma estratégia de concorrência
READ_WRITE -- informa que a entidade pode ser alterada de vez em quando
READ_ONLY -- informa que a entidade não será alterada
TRANSACTIONAL -- 

Repare que existe a anotação @Cache. É ela quem determina que essa entidade deve ser colocada em cache.
Quando a entidade for consultada, o Hibernate irá guardá-la em memória e, quando precisar consultar essa entidade pelo identificador, ele irá verificar se a entidade já está no cache antes de buscar no banco de dados. E como você sabe, acesso em memória é muito mais rápido que acesso em um banco de dados externo.
A propriedade usage determina a estratégia de concorrência que deve ser usada. Essa estratégia, basicamente, controla quem está alterando e quem pode alterar ao mesmo tempo uma entidade no cache.
Deixei definido como CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, que diz que iremos eventualmente editar essa entidade e que o controle de concorrência pode ser mais “simples”, pois é muito pouco provável que dois processos estejam alterando ao mesmo tempo essa entidade.
14.4. Cache de coleções
o cache de coleções é um pouco mais complicado do que o cache de entidades.
vamos ter como exemplo a entidade Usuario. nela temos uma lista de Grupo.

script para teste:
insert into tb_usuario_com_grupo (nome, status) values ("João", "ATIVO");
insert into tb_usuario_com_grupo (nome, status) values ("Maria", "INATIVO");

insert into tb_grupo (nome) values ("ADMINISTRADOR");
insert into tb_grupo (nome) values ("VENDEDOR");

insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1,1);
insert into usuario_grupo (codigo_usuario, codigo_grupo) values (1,2);
insert into usuario_grupo (codigo_usuario, codigo_grupo) values (2,2);

classe usuario:
/**
 * classe utilizada para demonstrar o cache de coleções
 * 
 * @author admin
 *
 */
@Entity
@Table(name = "tb_usuario_com_grupo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UsuarioComGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String nome;
	private Status status;
	private List<Grupo> grupos;

...

	@ManyToMany
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn(name = "codigo_usuario"), inverseJoinColumns = @JoinColumn(name = "codigo_grupo"))
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public List<Grupo> getGrupos() {
		return grupos;
	}



classe grupos:
@Entity
@Table(name = "tb_grupo")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Grupo implements Serializable {
….


o truque do cache de coleções é que alem de anotarmos as entidades, devemos tambem anotar a coleçao. no final, deverao ser 3 anotações, (entidade, coleçao e entidade) para um cache completo.
caso alguma das tres anotaçoes nao seja feita, o hibernate ainda irá buscar no banco de dados os dados faltantes.

14.5. Cache de queries
 o cache de queries também é bem simples. mas o que é o cache de queries?
o cache de queries é guardar os resultados de uma query, de forma a que, quando chamada novamente, nao seja necessario executá-la novamente.

para implementar um cache de queries é bem simples;

persistence.xml

<property name="hibernate.cache.use_query_cache" value="true"/>

e no DAO

Session session = manager.unwrap(Session.class);
		return (Long) session.createQuery("select count(u) from UsuarioComGrupo u")
				.setCacheable(true)//definição para colocar a query em cache
				.uniqueResult();


somente isso irá ativar o cache desta query.

com criteria tambem ocorre o cache, da mesma forma:

Session session = manager.unwrap(Session.class);
		return (Long) session.createCriteria(UsuarioComGrupo.class)
				.setProjection(Projections.count("codigo"))
				.add(Restrictions.eq("status", Status.ATIVO))
				.setCacheable(true)//definição para colocar a query em cache
				.uniqueResult();

lembrando que somente o hibernate implementa o cache de queries. o JPA ainda nao tem essa funcionalidade.

14.6. Cache com Ehcache
14.6.1 alterar para ser utilizado um datasource no tomcat:
no persistence.xml, remover as properties:
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/locadora"/>
		<property name="javax.persistence.jdbc.user" value="root"/>
		<property name="javax.persistence.jdbc.password" value="root"/>
		<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>

em context.xml, adicionar:
<Resource name="jdbc/locadoraDB" auth="Container"
		factory="org.apache.naming.factory.BeanFactory" type="com.mchange.v2.c3p0.ComboPooledDataSource"
		driverClass="com.mysql.jdbc.Driver" jdbcUrl="jdbc:mysql://localhost:3306/locadora"
		user="root" password="root" minPoolSize="3" maxPoolSize="3" />

no web.xml colocar;
<resource-ref>
		<description>DB Connection</description>
		<res-ref-name>jdbc/locadoraDB</res-ref-name>
		<res-type>javax.sql.DataSource</res-type>
		<res-auth>Container</res-auth>
	</resource-ref>

no pom.xml, retirar o driver do mysql:
<dependency> 
 	<groupId>mysql</groupId> 
 	<artifactId>mysql-connector-java</artifactId> 
	<version>${mysql.connector.version}</version> 			
<scope>provided</scope> 
 </dependency>

14.6.2 cache com ehcache
alterar o POm.xml, retirando o hibernate testing 

  		<dependency> 
  			<groupId>org.hibernate</groupId> 
  			<artifactId>hibernate-testing</artifactId> 
  			<version>4.3.5.Final</version> 
  			<scope>compile</scope> 
  		</dependency> 


e colocar a dependencia do ehcache;
<!-- Ehcache -->
		<dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache-core</artifactId>
			<version>2.6.9</version>
			<scope>compile</scope>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
			<version>${hibernate.version}</version>
			<scope>compile</scope>
		</dependency>

e no persistence.xml, retirar se houver qualquer regionfactory (do hibernate testing por exemplo) e colocar esta:
<property name="hibernate.cache.region.factory_class" value="org.hibernate.cache.ehcache.EhCacheRegionFactory"/>

criar um arquivo ehcache.xml em META-INF

<ehcache>




	<diskStore path="/opt/cache" />


	<defaultCache


		maxElementsInMemory="1000"


		eternal="false"


		timeToIdleSeconds="60"


		timeToLiveSeconds="120"


		overflowToDisk="true"


		maxElementsOnDisk="100000"


		diskExpiryThreadIntervalSeconds="120"


		memoryStoreEvictionPolicy="LRU" />


</ehcache>

descriçao dos campos
	<diskStore path="/opt/cache" /> criar este diretório para armazenar o cache no disco rigido
	<defaultCache 
		maxElementsInMemory="1000"  no máximo 1000 elementos na memória
		eternal="false" irão ficar sempre na memoria?
		timeToIdleSeconds="120"  quanto tempo uma entidade por ficar sem ser utilizada
		timeToLiveSeconds="120"  quanto tempo de vida de cache
		overflowToDisk="true" quando atingirmos o máximo ele irá utilizar o disco rígido
		maxElementsOnDisk="100000" máximo de elementos no disco rígido
		diskExpiryThreadIntervalSeconds="120"   quanto tempo as entidade ficarão no disco
		memoryStoreEvictionPolicy="LRU" /> forma de retirar as entidades - LRU least recent used


14.7. Cache com Infinispan, JTA e no WildFly

14.7.1 - configurar o wildfly
após instalar o wildfly (descompactar), você deve:
entrar em standalone
se digitar standalone.sh ou o equivalente no windows, ele irá subir
no browser, a porta 9990 é a tela de administrador. como é uma instalação nova, deve ser feito o registro de um usuário.
pare o servidor
na pasta bin do servidor, digite add-user.sh ou equivalente
tipos de usuário (admin ou applications user)
username : admin
senha : admin
deixar grupos vazio
não será usado para conectar várias aplicações entre si
subir novamente o standalone ./standalone.sh
inserir o usuário e senha no browser
parar o servidor
ir na pasta do servidor, para configurar o driver do mysql. modules > system > layers > base > com
criar o diretorio mysql
entrar em mysql e criar o diretorio main
copiar o driver do mysql para o diretorio main
criar o arquivo module.xml


<WILDFLY_HOM>/modules/system/layers/base/com/mysql/main/module.xml









<?xml version="1.0" encoding="UTF-8"?>


<module xmlns="urn:jboss:module:1.1" name="com.mysql">


 <resources>


     <resource-root path="mysql-connector-java-5.1.31-bin.jar"/>


 </resources>


 <dependencies>


     <module name="javax.api"/>


     <module name="javax.transaction.api"/>


     <module name="javax.servlet.api" optional="true"/>


 </dependencies>


</module>







- Não se esqueça de copiar o arquivo .jar.
configurar o datasource 
standalone > configuration > abrir o standalone.xml
<datasource jta="true" jndi-name="java:jboss/datasources/gerenciador-acesso-ds" pool-name="gerenciador_acesso" enabled="true" use-java-context="true">
 <connection-url>jdbc:mysql://localhost:3306/gerenciador_acesso</connection-url>
  <driver>mysql</driver>
    <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
    <pool>
        <min-pool-size>10</min-pool-size>
        <max-pool-size>100</max-pool-size>
    </pool>
    <security>
        <user-name>root</user-name>
        <password>root</password>
    </security>
</datasource>


<driver name="mysql" module="com.mysql">
  <driver-class>com.mysql.jdbc.Driver</driver-class>
</driver>

atualizar a lib do mysql no wildfly
ir no diretorio do wildfly modules > system > layers > base > org > hibernate > main
substituir os jars necessários para a versão pretendida.
atualizar o arquivo module.xml da pasta do hibernate, alterando os nomes dos jars utilizados



OBS: para mudar as portas do wildfly:
In your standalone.xml file, look for this element:
<socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:0}">
The port-offset attribute lets you modify all the ports wildfly uses, by adding the number you specify.
For example, the default value is 0, which means that http port will be 8080, remoting 4447, etc.
If you use ${jboss.socket.binding.port-offset:100}, http port will be 8180 (8080+100), remoting 4547 (4447+100), etc.
So you need to change the offset, nothing else.


14.7.2 - configurar a aplicação
no pom, alterar:
<dependencies>
		<!-- OmniFaces (utilitarios para JSF) -->
		<dependency>
		    <groupId>org.omnifaces</groupId>
		    <artifactId>omnifaces</artifactId>
		    <version>${omnifaces.version}</version>
		    <scope>compile</scope>
		</dependency>
		<!-- PrimeFaces (Biblioteca de componentes) -->
		<dependency>
			<groupId>org.primefaces</groupId>
			<artifactId>primefaces</artifactId>
			<version>${primefaces.version}</version>
			<scope>compile</scope>
		</dependency>
		<!-- Mojarra (Implementação JSF 2) -->
		<dependency>
			<groupId>org.glassfish</groupId>
			<artifactId>javax.faces</artifactId>
			<version>${javax.faces.version}</version>
			<scope>provided</scope>
		</dependency>
		<!-- Implementação de EntityManager da JPA -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>${hibernate.version}</version>
			<scope>provided</scope>
		</dependency>
		<!-- Weld (implementação do CDI) -->
        <dependency>
            <groupId>org.jboss.weld.servlet</groupId>
            <artifactId>weld-servlet</artifactId>
            <version>${weld.version}</version>
            <scope>provided</scope>
        </dependency>
        
        <dependency>
			<groupId>org.jboss</groupId>
		    <artifactId>jandex</artifactId>
		    <version>${jandex.version}</version>
		    <scope>compile</scope>
		</dependency>		
		<!-- Logging -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${slf4j.version}</version>
		</dependency>
		
<!-- 		NECESSARIO PARA O DBUNIT -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>${slf4j.version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-simple</artifactId>
			<version>1.5.6</version>
		</dependency>
<!-- 		FIM NECESSARIO PARA O DBUNIT -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>${slf4j.version}</version>
		</dependency>
		
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>${log4j.version}</version>
			<scope>compile</scope>
		</dependency>
	
<!-- 	DEPENDÊNCIA NECESSÁRIA PARA REALIZAR O UPLOAD DE ARQUIVOS -->
		<dependency>
   			<groupId>commons-fileupload</groupId>
    		<artifactId>commons-fileupload</artifactId>
    		<version>${commons-fileupload.version}</version>
    		<scope>compile</scope>
		</dependency>
<!-- 	FIM DEPENDÊNCIA NECESSÁRIA PARA REALIZAR O UPLOAD DE ARQUIVOS -->		
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>${commons-lang3.version}</version>
			<scope>compile</scope>
		</dependency>
		
<!-- 		JUNIT -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>${junit.version}</version>
			<scope>test</scope>
		</dependency>
		
<!-- 		 DBUNIT -->
		<dependency>
			<groupId>org.dbunit</groupId>
			<artifactId>dbunit</artifactId>
			<version>${dbunit.version}</version>
			<scope>test</scope>
		</dependency>
		
<!-- 		BEAN VALIDATION -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>${hibernate.version}</version>
			<scope>provided</scope>
		</dependency>
		
		
	</dependencies>

no persistence.xml
<!-- controle de transacao por RESOURCE_LOCAL -->
	<persistence-unit name="locadoraVeiculoPU" transaction-type="RESOURCE_LOCAL">
<!-- 		JTA DATASOURCE - WILDFLY -->
		<jta-data-source>java:jboss/datasources/locadora-ds</jta-data-source>
		<properties>
			<property name="javax.persistence.schema-generation.database.action" value="none" /> 
			<property name="hibernate.hbm2ddl.auto" value="update"/>

			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
			<property name="hibernate.show_sql" value="true"/>
			
			<property name="hibernate.default_schema" value="locadora" />
			

<!-- 			INFINISPAN // RECOMENDADO PARA PRODUç O -->
<!-- 			a configuração para utilizar o infinispan é não colocar nada de fabrica, que ele ativa automaticamente -->
<!-- 				somente precisa da property hibernate.cache.use_second_level_cache e hibernate.cache.use_query_cache como true  -->
			
<!-- 			cache de 2o nivel -->
			<property name="hibernate.cache.use_second_level_cache" value="true"/>
			
<!-- 			CACHE de queries -->
			<property name="hibernate.cache.use_query_cache" value="true"/>
		</properties>
	</persistence-unit>

15.1. O pattern DAO
quando precisamos acessar o banco de dados, criamos uma camada de software para acesso ao banco. essa camada se chama DAO. as responsabilidades dela é acessar o banco.
nao colocamos regras de negocio na DAO. as regras de negocio estao na service/manager.

no DAO colocamos o entitymanager, fazemos as queries e criterias, etc.

no exemplo enviado para o Git, temos como exemplos significativos:

criação de uma classe VO direto no resultado da consulta:

public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia() {
		return manager.createQuery("select "
		          + "NEW com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia(p.dataVenda, sum(p.valorTotal)) "
		          + "from Pedido p "
		          + "group by p.dataVenda", ValorTotalVendaDoDia.class)
		        .getResultList();
	}



Executar um metodo logo ao carregar a tela:
	<f:metadata>
<!-- 		QUANDO ELE CARREGAR A TELA, ELE IRA EXECUTAR ESTE METODO -->
		<f:viewAction action="#{entregasPendentesBean.buscarItensPendentes}" />
	</f:metadata>


15.2. Criando um DAO Genérico
um dao generico serve para facilitar e impedir a propagação de codigo repetitivo.

todas os metodos que sao mais utilizados pelas classes dao podem ser colocados no dao generico, de forma a ser somente escrita uma vez.

é bom tambem implementar uma iterface para as classes dao, de forma a melhor controlar o acesso à classe dao.

criar uma interface generica GenericDAO

public interface GenericDAO <T, ID extends Serializable>{
	
	public T buscarPeloCodigo(ID id);
	
	public void salvar(T entidade);
	
	public List<T> filtrar(T entidade, String... propriedades);

}

criar a classe HibernateGenericDAO

public class HibernateGenericDAO <T, ID extends Serializable> implements GenericDAO<T, ID>{

	@Inject
	private EntityManager manager;
	
	private Class<T> classeEntidade;//classe representada pelo T
	
	
	@SuppressWarnings("unchecked")
	public HibernateGenericDAO() {
		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T buscarPeloCodigo(ID id) {
		return manager.find(classeEntidade, id);
	}

	@Override
	public void salvar(T entidade) {
		manager.merge(entidade);
	}

	/*
	 * (non-Javadoc)
	 * @see com.algaworks.pedidovenda.dao.GenericDAO#filtrar(java.lang.Object, java.lang.String[])
	 * 
	 * para utilizar este tipo de filtro adicionar no POM a dependencia:
	 * <!-- commons beanutils -->
		<dependency>
			<groupId>commons-beanutils</groupId>
			<artifactId>commons-beanutils</artifactId>
			<version>1.9.2</version>
			<scope>compile</scope>
		</dependency>
	 */
	@Override
	public List<T> filtrar(T entidade, String... propriedades) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classeEntidade);
		
		if(propriedades != null) {
			for (String propriedade : propriedades) {
				try {
					Object valor = PropertyUtils.getProperty(entidade, propriedade);
					
					if(valor != null) {
						if(valor instanceof String) {
							criteria.add(Restrictions.ilike(propriedade, (String) valor, MatchMode.ANYWHERE));
						}else {
							criteria.add(Restrictions.eq(propriedade, valor));							
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("propriedade nao encontrada", e);
				}
			}
		}
		return criteria.list();
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	protected Session getSession() {
		return manager.unwrap(Session.class);
	}
}

criar as interfaces para acesso ao DAO (opcional)

public interface PedidoDAO  extends GenericDAO<Pedido, Long>{

	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia();
	
}

criar a classe implementacao do DAO

public class PedidoDAOImpl extends HibernateGenericDAO<Pedido, Long> implements PedidoDAO, Serializable {

	private static final long serialVersionUID = 1L;
	

	public List<ValorTotalVendaDoDia> buscarValorTotalVendaDoDia() {
		return getEntityManager().createQuery("select "
		          + "NEW com.algaworks.pedidovenda.dao.vo.ValorTotalVendaDoDia(p.dataVenda, sum(p.valorTotal)) "
		          + "from Pedido p "
		          + "group by p.dataVenda", ValorTotalVendaDoDia.class)
		        .getResultList();
	}

}


na classe de implementacao do DAO somente irá ficar os metodos especificos da entidade do DAO.


15.3. O pattern Repository
a diferenca entre o DAO e o repository:
O objetivo é o mesmo: Servir de abstração para persistir os dados.
Existe apenas uma diferença no seu modo de uso:
Um repositório está vinculado à regra de negócio da aplicação e está associado ao agregado dos seus objetos de negócio e retorna objetos de domínio que representam esses dados.
Já o DAO (Data Access Object) a principio tem o seu escopo limitado na captura e persistência dos dados de um objeto DTO (Data Transfer Object) que representa um registro da base de dados, consequentemente ele transmite apenas o mundo físico relacional da base de dados e não representa o mini-mundo real do negócio da sua aplicação.
Repository: Avaliacao é regra de negócio, engloba tudo sobre essa regra, retornando objetos de domínio do negócio
class AvaliacaoRepository { 
public List<Aluno> AlunosAvaliados(); 
public List<Gerente> GerentesAvaliados(); 
public List<Avaliacao> TodasAvaliacoes(); 
public List<Avaliacao> AvaliacoesEmAguardo(); }
DAO: Avaliacao / Usuario são Tabelas e suas funções retornam objetos (DTO) que representam os registros do banco de dados.
class AvaliacaoDAO { 
public List<DTOAvaliacao> TodasAvaliacoes(); 
public List<DTOAvaliacao> AvaliacoesEmAguardo(); 
} 

class UsuarioDAO { 
public List<DTOUsuario> AlunosAvaliados(); 
public List<DTOUsuario> GerentesAvaliados(); 
}


ou seja, o repository é baseado no negocio enquanto a DAO é baseada nas entidades do banco.
na repository, ela representa a agregacao das classes em uma unica coisa negocial. no nosso exemplo do codigo, um itemPedido nao existe sem um Pedido, logo, nao existira uma classe ItemPedidoRepository pois a PedidoRepository já engloba o contexto negocial do itemPedido.

como forma de organização das nomenclaturas, o repository é visto como uma coleção. logo, o PedidoRepository se chama na verdade Pedidos.

15.4. Datasources
os datasources servem para podermos configurar o acesso da aplicação ao banco de dados.
no caso do tomcat, conforme veremos, a configuração fica no arquivo context.xml, podendo ficar na aplicação ou no tomcat, na pasta conf.

como vimos na aula 14.6.1, a configuracao do context do tomcat é:
<?xml version="1.0" encoding="UTF-8"?>
<Context>
    <Manager pathname="" />
    
    <Resource name="BeanManager" auth="Container"
        type="javax.enterprise.inject.spi.BeanManager" factory="org.jboss.weld.resources.ManagerObjectFactory" />
        
<!--    DATASOURCE -->
    <Resource name="jdbc/locadoraDB" auth="Container"
        factory="org.apache.naming.factory.BeanFactory" type="com.mchange.v2.c3p0.ComboPooledDataSource"
        driverClass="com.mysql.jdbc.Driver" jdbcUrl="jdbc:mysql://localhost:3306/locadora"
        user="root" password="root" minPoolSize="3" maxPoolSize="3" />
        
</Context>

o arquivo context tambem existe na pasta do tomcat, na pasta conf.

se não for alterado, é assim que ele se parece;
<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
--><!-- The contents of this file will be loaded for each web application --><Context>

    <!-- Default set of monitored resources. If one of these changes, the    -->
    <!-- web application will be reloaded.                                   -->
    <WatchedResource>WEB-INF/web.xml</WatchedResource>
    <WatchedResource>WEB-INF/tomcat-web.xml</WatchedResource>
    <WatchedResource>${catalina.base}/conf/web.xml</WatchedResource>

    <!-- Uncomment this to disable session persistence across Tomcat restarts -->
    <!--
    <Manager pathname="" />
    -->
</Context>


neste link estão as configurações necessárias para configurar o datasource do tomcat:
http://commons.apache.org/proper/commons-dbcp/configuration.html

BasicDataSource Configuration Parameters

Parameter
Description
username
The connection user name to be passed to our JDBC driver to establish a connection.
password
The connection password to be passed to our JDBC driver to establish a connection.
url
The connection URL to be passed to our JDBC driver to establish a connection.
driverClassName
The fully qualified Java class name of the JDBC driver to be used.
connectionProperties
The connection properties that will be sent to our JDBC driver when establishing new connections. 
Format of the string must be [propertyName=property;]* 
NOTE - The "user" and "password" properties will be passed explicitly, so they do not need to be included here.

Parameter
Default
Description
defaultAutoCommit
driver default
The default auto-commit state of connections created by this pool. If not set then the setAutoCommit method will not be called.
defaultReadOnly
driver default
The default read-only state of connections created by this pool. If not set then the setReadOnly method will not be called. (Some drivers don't support read only mode, ex: Informix)
defaultTransactionIsolation
driver default
The default TransactionIsolation state of connections created by this pool. One of the following: (see javadoc)
NONE
READ_COMMITTED
READ_UNCOMMITTED
REPEATABLE_READ
SERIALIZABLE

defaultCatalog


The default catalog of connections created by this pool.
cacheState
true
If true, the pooled connection will cache the current readOnly and autoCommit settings when first read or written and on all subsequent writes. This removes the need for additional database queries for any further calls to the getter. If the underlying connection is accessed directly and the readOnly and/or autoCommit settings changed the cached values will not reflect the current state. In this case, caching should be disabled by setting this attribute to false.
defaultQueryTimeout
null
If non-null, the value of this Integer property determines the query timeout that will be used for Statements created from connections managed by the pool. null means that the driver default will be used.
enableAutoCommitOnReturn
true
If true, connections being returned to the pool will be checked and configured with Connection.setAutoCommit(true) if the auto commit setting is false when the connection is returned.
rollbackOnReturn
true
True means a connection will be rolled back when returned to the pool if auto commit is not enabled and the connection is not read-only.

Parameter
Default
Description
initialSize
0
The initial number of connections that are created when the pool is started. 
Since: 1.2
maxTotal
8
The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
maxIdle
8
The maximum number of connections that can remain idle in the pool, without extra ones being released, or negative for no limit.
minIdle
0
The minimum number of connections that can remain idle in the pool, without extra ones being created, or zero to create none.
maxWaitMillis
indefinitely
The maximum number of milliseconds that the pool will wait (when there are no available connections) for a connection to be returned before throwing an exception, or -1 to wait indefinitely.
 NOTE: If maxIdle is set too low on heavily loaded systems it is possible you will see connections being closed and almost immediately new connections being opened. This is a result of the active threads momentarily closing connections faster than they are opening them, causing the number of idle connections to rise above maxIdle. The best value for maxIdle for heavily loaded system will vary but the default is a good starting point.

Parameter
Default
Description
validationQuery


The SQL query that will be used to validate connections from this pool before returning them to the caller. If specified, this query MUST be an SQL SELECT statement that returns at least one row. If not specified, connections will be validation by calling the isValid() method.
validationQueryTimeout
no timeout
The timeout in seconds before connection validation queries fail. If set to a positive value, this value is passed to the driver via the setQueryTimeout method of the Statement used to execute the validation query.
testOnCreate
false
The indication of whether objects will be validated after creation. If the object fails to validate, the borrow attempt that triggered the object creation will fail.
testOnBorrow
true
The indication of whether objects will be validated before being borrowed from the pool. If the object fails to validate, it will be dropped from the pool, and we will attempt to borrow another.
testOnReturn
false
The indication of whether objects will be validated before being returned to the pool.
testWhileIdle
false
The indication of whether objects will be validated by the idle object evictor (if any). If an object fails to validate, it will be dropped from the pool.
timeBetweenEvictionRunsMillis
-1
The number of milliseconds to sleep between runs of the idle object evictor thread. When non-positive, no idle object evictor thread will be run.
numTestsPerEvictionRun
3
The number of objects to examine during each run of the idle object evictor thread (if any).
minEvictableIdleTimeMillis
1000 * 60 * 30
The minimum amount of time an object may sit idle in the pool before it is eligible for eviction by the idle object evictor (if any).
softMinEvictableIdleTimeMillis
-1
The minimum amount of time a connection may sit idle in the pool before it is eligible for eviction by the idle connection evictor, with the extra condition that at least "minIdle" connections remain in the pool. When minEvictableIdleTimeMillis is set to a positive value, minEvictableIdleTimeMillis is examined first by the idle connection evictor - i.e. when idle connections are visited by the evictor, idle time is first compared against minEvictableIdleTimeMillis (without considering the number of idle connections in the pool) and then against softMinEvictableIdleTimeMillis, including the minIdle constraint.
maxConnLifetimeMillis
-1
The maximum lifetime in milliseconds of a connection. After this time is exceeded the connection will fail the next activation, passivation or validation test. A value of zero or less means the connection has an infinite lifetime.
logExpiredConnections
true
Flag to log a message indicating that a connection is being closed by the pool due to maxConnLifetimeMillis exceeded. Set this property to false to suppress expired connection logging that is turned on by default.
connectionInitSqls
null
A Collection of SQL statements that will be used to initialize physical connections when they are first created. These statements are executed only once - when the configured connection factory creates the connection.
lifo
true
True means that borrowObject returns the most recently used ("last in") connection in the pool (if there are idle connections available). False means that the pool behaves as a FIFO queue - connections are taken from the idle instance pool in the order that they are returned to the pool.

Parameter
Default
Description
poolPreparedStatements
false
Enable prepared statement pooling for this pool.
maxOpenPreparedStatements
unlimited
The maximum number of open statements that can be allocated from the statement pool at the same time, or negative for no limit.
 This component has also the ability to pool PreparedStatements. When enabled a statement pool will be created for each Connection and PreparedStatements created by one of the following methods will be pooled:
public PreparedStatement prepareStatement(String sql)
public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
 NOTE - Make sure your connection has some resources left for the other statements. Pooling PreparedStatements may keep their cursors open in the database, causing a connection to run out of cursors, especially if maxOpenPreparedStatements is left at the default (unlimited) and an application opens a large number of different PreparedStatements per connection. To avoid this problem, maxOpenPreparedStatements should be set to a value less than the maximum number of cursors that can be open on a Connection.

Parameter
Default
Description
accessToUnderlyingConnectionAllowed
false
Controls if the PoolGuard allows access to the underlying connection.
When allowed you can access the underlying connection using the following construct:
   Connection conn = ds.getConnection();
    Connection dconn = ((DelegatingConnection) conn).getInnermostDelegate();
    ...
    conn.close()


 Default is false, it is a potential dangerous operation and misbehaving programs can do harmful things. (closing the underlying or continue using it when the guarded connection is already closed) Be careful and only use when you need direct access to driver specific extensions.
 NOTE: Do not close the underlying connection, only the original one.

Parameter
Default
Description
removeAbandonedOnMaintenance 
removeAbandonedOnBorrow
false
Flags to remove abandoned connections if they exceed the removeAbandonedTimout.
A connection is considered abandoned and eligible for removal if it has not been used for longer than removeAbandonedTimeout.
Creating a Statement, PreparedStatement or CallableStatement or using one of these to execute a query (using one of the execute methods) resets the lastUsed property of the parent connection.
Setting one or both of these to true can recover db connections from poorly written applications which fail to close connections.
Setting removeAbandonedOnMaintenance to true removes abandoned connections on the maintenance cycle (when eviction ends). This property has no effect unless maintenance is enabled by setting timeBetweenEvictionRunsMillis to a positive value. 
If removeAbandonedOnBorrow is true, abandoned connections are removed each time a connection is borrowed from the pool, with the additional requirements that
getNumActive() > getMaxTotal() - 3; and
getNumIdle() < 2

removeAbandonedTimeout
300
Timeout in seconds before an abandoned connection can be removed.
logAbandoned
false
Flag to log stack traces for application code which abandoned a Statement or Connection.
Logging of abandoned Statements and Connections adds overhead for every Connection open or new Statement because a stack trace has to be generated.
abandonedUsageTracking
false
If true, the connection pool records a stack trace every time a method is called on a pooled connection and retains the most recent stack trace to aid debugging of abandoned connections. There is significant overhead added by setting this to true.
 If you have enabled removeAbandonedOnMaintenance or removeAbandonedOnBorrow then it is possible that a connection is reclaimed by the pool because it is considered to be abandoned. This mechanism is triggered when (getNumIdle() < 2) and (getNumActive() > getMaxTotal() - 3) and removeAbandonedOnBorrow is true; or after eviction finishes and removeAbandonedOnMaintenance is true. For example, maxTotal=20 and 18 active connections and 1 idle connection would trigger removeAbandonedOnBorrow, but only the active connections that aren't used for more then "removeAbandonedTimeout" seconds are removed (default 300 sec). Traversing a resultset doesn't count as being used. Creating a Statement, PreparedStatement or CallableStatement or using one of these to execute a query (using one of the execute methods) resets the lastUsed property of the parent connection.

Parameter
Default
Description
fastFailValidation
false
When this property is true, validation fails fast for connections that have thrown "fatal" SQLExceptions. Requests to validate disconnected connections fail immediately, with no call to the driver's isValid method or attempt to execute a validation query.
The SQL_STATE codes considered to signal fatal errors are by default the following:
57P01 (ADMIN SHUTDOWN)
57P02 (CRASH SHUTDOWN)
57P03 (CANNOT CONNECT NOW)
01002 (SQL92 disconnect error)
JZ0C0 (Sybase disconnect error)
JZ0C1 (Sybase disconnect error)
Any SQL_STATE code that starts with "08"
To override this default set of disconnection codes, set the disconnectionSqlCodes property.
disconnectionSqlCodes
null
Comma-delimited list of SQL_STATE codes considered to signal fatal disconnection errors. Setting this property has no effect unless fastFailValidation is set to true.

15.5. Pool de conexões com C3P0
o c3p0 é responsável por gerenciar um pool de conexões com o banco de dados.

para configurá-lo é necessário alterar o datasource da aplicação, pois os dados utilizados no resource são diferentes do datasource do dbcp.

é preciso também incluir na pasta lib do tomcat as seguintes bibliotecas:
o download é feito nesta url:
https://sourceforge.net/projects/c3p0/files/c3p0-bin/

e os arquivos sao:
c3p0-0.9.5-pre8.jar
mchange-commons-java-0.2.7.jar


no context.xml, deverá ser colocado:
<Resource 
		auth="Container"
		driverClass="com.mysql.jdbc.Driver" 
		maxPoolSize="3" 
		minPoolSize="3" 
		acquireIncrement="3"	
		name="jdbc/locadoraDB" 
		user="root" 
		password="root" 
		factory="org.apache.naming.factory.BeanFactory" 	
		type="com.mchange.v2.c3p0.ComboPooledDataSource"
		jdbcUrl="jdbc:mysql://localhost:3306/locadora"
		/>

a documentação esta aqui:
https://www.mchange.com/projects/c3p0/

as propriedades que podem ser incluidas sao:
https://www.mchange.com/projects/c3p0/#configuration_properties


acquireIncrement
acquireRetryAttempts
acquireRetryDelay
autoCommitOnClose
automaticTestTable
breakAfterAcquireFailure
checkoutTimeout
connectionCustomizerClassName
connectionTesterClassName
contextClassLoaderSource
dataSourceName
debugUnreturnedConnectionStackTraces
driverClass
extensions
factoryClassLocation
forceIgnoreUnresolvedTransactions
forceSynchronousCheckins
forceUseNamedDriverClass
idleConnectionTestPeriod
initialPoolSize
jdbcUrl
maxAdministrativeTaskTime
maxConnectionAge
maxIdleTime
maxIdleTimeExcessConnections
maxPoolSize
maxStatements
maxStatementsPerConnection
minPoolSize
numHelperThreads
overrideDefaultUser
overrideDefaultPassword
password
preferredTestQuery
privilegeSpawnedThreads
propertyCycle
statementCacheNumDeferredCloseThreads
testConnectionOnCheckin
testConnectionOnCheckout
unreturnedConnectionTimeout
user
usesTraditionalReflectiveProxies


15.6. Trabalhando com procedures
procedures sao como metodos no banco de dados.
podemos chamar uma procedure que ira realizar algum tipo de codigo no servidor do banco de dados, e podem ou nao retornar algum dado.

sao literalmente metodos no banco de dados que podemos chamar.

como exemplo, iremos ver estas 3 tabelas:


create table pedido (




  codigo bigint primary key auto_increment,


  valor decimal(10,2),


  status varchar(50)


);







create table devolucao (


 codigo bigint primary key auto_increment,


 codigo_pedido bigint,


 status varchar(50)


);







create table entrega (


 codigo bigint primary key auto_increment,


 codigo_pedido bigint,


 previsao date


);

entao iremos fazer assim:

temos alguns dados na tabela pedido.
alguns tem o campo status como CANCELADO outros APROVADO.

os que tem o status CANCELADO, irao gerar um lancemento na tabela devolucao.
os que tem o status APROVADO, irao gerar um lancamento na tabela entrega.

insert into pedido (valor, status) values (100, 'CANCELADO');
insert into pedido (valor, status) values (200, 'APROVADO');
insert into pedido (valor, status) values (200, 'APROVADO');


o codigo da procedure é:

DELIMITER $$









CREATE PROCEDURE analisarPedido(vCodigo bigint, OUT vAnalise varchar(50))


BEGIN


  DECLARE vStatus varchar(50);


 


  select status into vStatus from pedido where codigo = vCodigo;


 


  START TRANSACTION;


  if vStatus = 'CANCELADO' then


    insert into devolucao (codigo_pedido, status) values (vCodigo, 'PENDENTE');


    set vAnalise = 'DEVOLUCAO';


   


  elseif vStatus = 'APROVADO' then


    insert into entrega (codigo_pedido, previsao) values (vCodigo, now());


    set vAnalise = 'ENTREGA';


  end if;


 


  COMMIT;







END $$


DELIMITER ;

e agora, iremos criar um metodo java para chamar a procedure. lembre-se que a procedure tem que estar criada no banco de dados primeiro.

15.7. Named Queries em arquivos externos
as named queries são queries estáticas, ou seja, não sofrem alterações depois de criadas, carregadas pelo servidor logo após o deploy.

as vantagens de se utilizar as named queries, em comparação com as dynamic queries normais sao:
mais fácil de ler
mais fácil de manter
melhor performance

as named queries geralmente sao utilizadas nas entidades desta forma:
@Entity
@NamedQueries({//named queries
		@NamedQuery(name = "Carro.buscarTodos", query = "select c from Carro c inner join fetch c.modelo"),
		@NamedQuery(name = "Carro.buscarCarroComAcessorios", query = "select c from Carro c left JOIN fetch c.acessorios a "
				+ " where c.codigo = :codigo") })
@Table(name="tb_carro", schema="locadora")
public class Carro {


mas para utilizar estar named queries em arquivos externos, de forma a facilitar a visualizacao e manutenção?

é facil. 
criar uma pasta chamada NamedQueries dentro de META-INF.

esta pasta ira guardar todas as namedQueries que voce criar em arquivos externos.

agora, voce pode criar um arquivo para cada entidade que voce colocar as namedqueries ou somente um arquivo com todas as namedqueries de todas as entidades. fica a seu criterio.

no nosso exemplo, vamos criar somente um arquivo com todas as named queries, separados por entidades.

dentro da pasta que voce criou, crie o arquivo namedQueries.xml:

<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings xmlns="http://xmlns.jcp.org/xml/ns/persistence/orm"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence/orm http://xmlns.jcp.org/xml/ns/persistence/orm_2_1.xsd"
  version="2.1">
  
<!--   ENTIDADE CARRO -->
  <named-query name="Carro.buscarTodos">
    <query>
      	select c from Carro c 
      	inner join fetch c.modelo
    </query>
  </named-query>
  
  <named-query name="Carro.buscarCarroComAcessorios">
    <query>
     	select c from Carro c 
     	left JOIN fetch c.acessorios a 
    </query>
  </named-query>
  
<!--   OUTRAS ENTIDADES -->

</entity-mappings>

se voce estiver fazendo a migraçao das namedqueries da entidade para o arquivo, nao se esqueça de apagar na entidade as namedqueries.

e agora, no persistence.xml, adicionar a forma que o persistence.xml tem para encontrar o arquivo:

<mapping-file>META-INF/NamedQueries/namedQueries.xml</mapping-file>



ficaria desta forma:
	<persistence-unit name="locadoraVeiculoPU" transaction-type="RESOURCE_LOCAL">

		<non-jta-data-source>java:comp/env/jdbc/locadoraDB</non-jta-data-source>
		
		<mapping-file>META-INF/NamedQueries/namedQueries.xml</mapping-file>
			
		<properties>

		…

tem que estar fora do properties!


16.1. OneToOne Lazy - Com anotações
sempre que carregarmos uma entidade com anotaçao @OneToOne com outra entidade, ela irá trazer a outra entidade tambem.
mas e se adicionarmos o Lazy, será que traz?
sim, e de um jeito pior. ele faz 2 selects …..

o hibernate tem um jeito de nao carregar uma entidade anotada com @OneToOne. mas atenção: SOMENTE FUNCIONA COM UMA ENTIDADE POR CLASSE.
ou seja, se voce nao quiser trazer 2 entidades anotadas com @OneToOne, não ira funcionar.

bom, mas é bem simples de implementar isso;

@Entity
@Table(name = "tb_usuario_com_endereco")
public class UsuarioComEndereco implements Serializable, FieldHandled {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;
	
	private FieldHandler handler; //campo utilizado para 'enganar' o hibernate para que ele não traga a entidade endereco, somente quando necessário
	
	@OneToOne(mappedBy = "usuario", fetch=FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)//informa ao hibernate para nao tentar colocar um objeto proxy nesta entidade (o que levaria ao hibernate realizar a consulta, mesmo que não existam entidades relacionadas)
	private Endereco endereco;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		if (this.handler != null) { //truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
			return (Endereco) this.handler.readObject(this, "endereco", endereco);
		}
		
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		if (this.handler != null) {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
			this.endereco = (Endereco) this.handler.writeObject(this, "endereco"
					, this.endereco, endereco);
		}
		
		this.endereco = endereco;
	}
	
	@Override
	public void setFieldHandler(FieldHandler handler) {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
		this.handler = handler;
	}

	@Override
	public FieldHandler getFieldHandler() {//truque para o hibernate buscar o endereco caso seja necessario. OBS o entitymanager precisa estar aberto para isto ocorrer. se ja tiver fechado, nao funciona
		return this.handler;
	}
 


16.2. OneToOne Lazy - Com instrumentação
podemos tambem obter o resultado anterior, mas sem tanta coisa inserida nas classes.

entao, deixamos a classe sem as coisas necessarias para a aula anterior.

@Entity
@Table(name = "tb_usuario_com_endereco")
public class UsuarioComEndereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;
	
	@OneToOne(mappedBy = "usuario", fetch=FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)//informa ao hibernate para nao tentar colocar um objeto proxy nesta entidade (o que levaria ao hibernate realizar a consulta, mesmo que nao existam entidades relacionadas)
	private Endereco endereco;
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	...

e no POM.xml adicionamos o plugin do ant, que realmente ira fazer a instrumentaçao para nos, ao executar o clean install.

<plugin>
	<artifactId>maven-antrun-plugin</artifactId>
	<version>1.7</version>
	<executions>
	  <execution>
		<id>Instrument domain classes</id>
		<configuration>
		  <tasks>
			<taskdef name="instrument"
			  classname="org.hibernate.tool.instrument.javassist.InstrumentTask">
			  <classpath>
				<path refid="maven.dependency.classpath" />
				<path refid="maven.plugin.classpath" />
			  </classpath>
			</taskdef>
			<instrument verbose="true">
			  <fileset dir="${project.build.outputDirectory}">
				<include name="**/modelo/**/*.class" />
			  </fileset>
			</instrument>
		  </tasks>
		</configuration>
		<phase>process-classes</phase>
		<goals>
		  <goal>run</goal>
		</goals>
	  </execution>
	</executions>
  </plugin>

no include em amarelo, marcamos as classes para execuçao. no caso ele ira executar todas as classes dentro de modelo.


executamos o clean install e quando ele for executar os testes, ele ira fazer o select do teste.

16.3. Lock Otimista
algumas vezes pode acontecer de dois usuários diferentes, em sessões diferentes, estarem editando a mesma entidade ao mesmo tempo. mesma entidade é o mesmo objeto do banco, ex de id =1 .

então o primeiro usuário salva uma alteração e depois o segundo usuário salva outra alteração na mesma entidade, sem ter sido carregada anteriormente com as alterações do primeiro save.

então as alterações do 1 save sao sobrescrevidas pelo segundo sava, mas o primeiro usuario nao sabe disso e edita mais alguma coisa e salva. nisso ele sobrescreve as alterações do 2 usuário, sem que nenhum dos dois soubesse.

tá, então precisamos de um lock na entidade, para evitar que isso ocorra.

o JPA tem uma anotação que faz isso para agente. o chamado lock otimista.

ela cria uma versão da entidade e só permite salvar se o usuário tiver a última versão da entidade no banco.
se o usuário estiver com uma entidade atrasada, então é lançada uma exception.

para implementar isso é muito fácil,
basta acrescentar um atributo na entidade a ser persistida, com:

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String nome;
	private Integer versao;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Version
	public Integer getVersao() {
		return versao;
	}
	public void setVersao(Integer versao) {
		this.versao = versao;
	}


somente isso.

isso impedirá que ocorra o erro relatado.

16.4. Lock Pessimista
 	In pessimistic locking, the object is locked when it is initially accessed for the first time in a given transaction. The lock then is released only when the transaction completes; the object is not accessible for any other transactions during the transaction.
In optimistic locking, the object is not locked when it is accessed for the first time in the transaction. Instead, its state (generally the version number) is saved. When other transactions that are accessing the same object try to modify the state of the object, the present state and the saved state are compared. If the states differ, then it's a clear indication of a conflicting update and the transaction will be rolled back.
Pessimistic Locking in JPA 2
Post a comment
Email Article
Print Article
JPA 2 supports pessimistic locking, with three new locking modes added to the existing optimistic locking such as like READ and WRITE. In all, these are all the locking modes available in JPA (the pessimistic locking modes are bold):
READ (JPA1)
WRITE (JPA1)
OPTMISTIC (Synonymous to READ)
OPTIMISTIC_FORCE_INCREMENT (Synonymous to WRITE)
PESSIMISTIC_READ (JPA2)
PESSIMISTIC_WRITE (JPA2)
PESSIMISTIC_FORCE_INCREMENT (JPA2)
NONE
In this section, we explore the JPA 2 locking modes for pessimistic locking.
PESSIMISTIC_READ
PESSIMISTIC_READ mode generally represents a shared lock. In this mode the EntityManager holds the lock on an entity during read operations as soon as the transaction begins. It is not released until the transaction is completed. This lock is best used when you access data that is not frequently modified, as it allows other transactions to read the entity.
......// Transaction t1 beginst1.begin();// Employee entity is read from the databaseEmployee e = em.find(Employee.class, 1);// Lock is performed after readem.lock(e, LockModeType.PESSIMISTIC_READ);............// Transaction is committedt1.commit();...
At the time of writing, most of the persistence providers such as EclipseLink and Hibernate provided support for PESSIMISTIC_READ through PESSIMISTIC_WRITE.
PESSIMISTIC_WRITE
The PESSIMISTIC_WRITE mode generally represents an exclusive lock. In this mode the EntityManager holds the lock on an entity as soon as the entity is updated in a transaction. This lock is best used in when there is a very high probability of update failure due to multiple transactions accessing the object.
Here is an example of using PESSIMISTIC_WRITE:
......// Transaction t1 beginst1.begin();// Employee entity is read and write lock is appliedEmployee e = em.find(Employee.class, 1, LockModeType.PESSIMISTIC_WRITE);............// Transaction is committedt1.commit();...
PESSIMISTIC_FORCE_INCREMENT
In this mode the EntityManager holds the lock on an entity when a transaction reads the entity. The version number is incremented towards the end of the transaction, irrespective of whether the entity was updated or not.
To understand the concept of PESSIMISTIC_FORCE_INCREMENT better, suppose two transactions (t1and t2) occur concurrently. The t1 transaction locks the department instance by using PESSIMISTIC_FORCE_INCREMENT to ensure that no other transaction (say, t2) can update the state of the same department instance. In the first code snippet below, a lock is performed on the department entity and a flush method of the EntityManager is invoked so that the version number is incremented in the database even if the entity is not modified. After flush, the thread is made to sleep for a while. At the same time, another transaction (t2) tries to update the same department instance, which results in an exception and the t2 transaction getting rolled back.
// Transaction1 – t1   // Transaction t1 beginst1.begin();// Get an instance of Employee entity with Id 1Emp e = em.find(Emp.class, 1);// Get the department of Employee with Id 1 which returns DEP 'A'Dep d = e.getDept();// Perform lock on department entity dem.lock(d, LockModeType.PESSIMISTIC_FORCE_INCREMENT);// Flush the entity manager, so that it increments the version numberem.flush();// Make the Thread to sleepThread.sleep(20000);// Transaction is committed after the thread resumes...t1.commit();// Transaction 2 – t2// Transaction t2 beginst2.begin();// Get an instance of Department entity with Id 'A'Dep d = em.find(Dep.class, 'A');// Modify the state of the Department entityd.setDeptName("RESEARCH");// Transaction is committedt2.commit();
You can lock the entities in JPA 2 using the lock() or find() methods of the EntityManager. When EntityManager.refresh() is invoked it refreshes the state of the entity and applies a lock to it. You can also use the setLockMode() method of the Query interface to set a lock mode to an entity. For NamedQuery annotations, you can use the lockMode element.
Pessimistic Locking in Hibernate
With Hibernate the database obtains the locking and the framework never locks the objects in memory. The LockMode class provides the following set of locks, which can be obtained in a Hibernate application:
LockMode.WRITE: This lock is obtained when Hibernate updates or inserts a new row. LockMode.WRITE is an internal mode (default) and is not specified in the application because it is obtained automatically when a new row is inserted to the database by the framework.
LockMode.UPGRADE: This lock is obtained when a user makes an explicit request using SELECT .. FOR UPDATE. This lock is valid only on databases that support the SELECT .. FOR UPDATE SQL syntax.
LockMode.UPGRADE_NOWAIT: This lock is acquired when a user makes an explicit request using SELECT. . FOR UPDATE NOWAIT, which is supported only by Oracle.
LockMode.READ: This lock is obtained automatically when the framework reads the data under Repeatable Read or Serializable Isolation mode. A version check is performed to compare the version number of the object in memory to the record in the database. This lock can be acquired explicitly by invoking Hibernate APIs (more on this shortly).
LockMode.NONE: This represents the absence of a lock. At the end of each transaction objects attain this lock mode.
The user can acquire locks explicitly by invoking one of the following Hibernate API:
Session.load(): This method is invoked by specifying the locking mode as UPGRADE or UPDATE_NOWAIT . If the object is not loaded by session, then SELECT .. FOR UPDATE is executed to load the object. If the object is loaded with a less restrictive lock, then the framework invokes lock() for that object.
Session.lock(): This method performs a version number check when the lock mode is READ, UPGRADE or UPGRADE_NOWAIT. When the lock mode is UPGRADE or UPGRADE_NOWAIT, the SELECT .. FOR UPDATE statement is used.
Query.setLockMode(): This method is used to set the lock mode for the object specified in the FROM clause of the Query string.
Conclusion
JPA 2 and Hibernate both support pessimistic locking as a concurrency control mechanism, but not in the same way. In this article, we compared how the two technologies implement this feature.



quando queremos travar o acesso a uma entidade complemente no banco de dados para que ninguem possa acessá-la durante a transacao, utiizamos o lock pessimista.

o lock pessimista, basicamente tem dois modos, o que permite o read da entidade mas nao permite o update e o que nao permite o read nem o update.

ta, entao como colocamos o lock pessimista nas queries?

primeiro temos que entender como funciona..

ao voce abrir a transacao, e nela fazer um select de uma entidade para alteração por exemplo, voce pede o lock pessimista nessa entidade.
o lock vai ser solto assim que a transacao terminar.

entao suponha que temos uma conta bancaria.

entao uma chamada para retirar 30 reais da conta é feita.

nessa chamada é aberta a transacao e nisso a conta é bloqueada.

somente apos o termino da transacao é que o lock sera solto.

agora vem a diferenca. se pedirmos o lock de update (read) ele ira permitir o read de outras treads, mas nao ira permitir o update.

se pedirmos o lock de update (write) ele ira bloquear tanto o update quanto o select.

e para fazer isso, basta adicionar o lock na consulta

public Acessorio buscarPeloCodigo(Long codigo) {
		return manager.find(Acessorio.class, codigo, LockModeType.PESSIMISTIC_WRITE); //lock pessimista
	}
A shared (read) lock blocks writers, allowing multiple readers to proceed
An exclusive (write) lock blocks both readers and writers, making all write operations be applied sequentially
Because the locking syntax is not part of the SQL Standard, each RDBMS has opted for a different syntax:
Database name
Shared lock statement
Exclusive lock statement
Oracle
FOR UPDATE
FOR UPDATE
MySQL
LOCK IN SHARE MODE
FOR UPDATE
Microsoft SQL Server
WITH (HOLDLOCK, ROWLOCK)
WITH (UPDLOCK, ROWLOCK)
PostgreSQL
FOR SHARE
FOR UPDATE
DB2
FOR READ ONLY WITH RS
FOR UPDATE WITH RS




































Java Persistence abstraction layer hides the database specific locking semantics, offering a common API that only requires two Lock Modes. The shared/read lock is acquired using the PESSIMISTIC_READ Lock Mode Type, and the exclusive/write lock is requested using PESSIMISTIC_WRITE instead.
16.5. Introdução ao Multi-Tenancy
O que é Multi Tenancy?
Tenant é uma palavra em inglês que é traduzida para locatário, assim como locatário de um imóvel, por exemplo. Esse termo é utilizado em SaaS uma vez que ele reflete o modelo de cobrança geralmente adotado por esses serviços, onde os clientes pagam de alguma forma para utilizá-los. Em um SaaS geralmente o cliente é dono de seus dados, enquanto que o provedor é o dono do software em si.
Um serviço é dito Multi Tenant quando uma única instância ou instalação é capaz de atender vários clientes (Tenants) simultaneamente, ao invés de ter uma instância/instalação para cada cliente. No entanto, um Tenant em um SaaS pode ser representado por diferentes entidades. Por exemplo, um Tenant em um SaaS que ofereça controle financeiro pessoal corresponde a um único Usuário. Já em um SaaS que suporte o controle financeiro de toda uma empresa, com inúmeros usuários e diferentes perfis, um Tenant corresponde a uma empresa, e assim por diante.

São diversos as aplicações web disponíveis, como quadros eletrônicos, sistemas de tracking, email e aplicações para empresas, ou até mesmo controle de clientes e vendas. Eles até ganharam um pomposo nome dentro do cloud computing: Software as a Service (SAAS).
O que essas aplicações possuem em comum? Todas elas atendem diversos clientes sem que um tenha conhecimento da existência dos outros.
Em um post recente no Tectura.com.br foram discutidas vantagens e desvantagens de diversas abordagens para produtos com a necessidade de suportar mais de um tenant.
A Microsoft categoriza três tipos de abordagens dependendo do nível de compartilhamento de recursos entre os clientes e apresente um relatório onde analisa os custos contra a segurança.
Em um extremo, nada é compartilhado entre cada cliente: para cada nova conta criada dentro de seu serviço, é criada uma nova máquina na cloud e uma instalação limpa é executada, com seu próprio banco.

Na outra ponta, tudo é compartilhado: novos clientes são inseridos no mesmo conjunto de máquinas e a instalação é feita através de um simples insert no banco, adicionando um novo cliente. Qual abordagem escolher?

Em qualquer abordagem onde o banco seja compartilhado por diversas empresas, precisamos garantir a segurança dos dados de cada uma, para que nenhum acesso indevido ocorra, trazendo preocupações de autorização para dentro do código de nossa aplicação. Caso seja criado para cada cliente um banco em uma máquina no cloud, essa questão fica concentrada em um único ponto da arquitetura, a segurança está implícita.
Ao mesmo tempo, o processo de customização de seu serviço por cliente também é afetada de acordo com o nível de compartilhamento de dados entre eles. Na abordagem onde os clientes compartilham o mesmo servidor web, a customização é uma preocupação de nossa aplicação, enquanto ao utilizarmos aplicações web distintas para cada cliente, podemos facilmente separar customizações por instância, por deploy efetuado.
A escalabilidade é afetada pois compartilhar recursos em memória na camada web, entre eles dados cacheados do banco ou filas, permitem diminuir o tempo de processamento ou de latência, aumentando o número de requisições suportados.
O processo de escalar também está diretamente ligado: quando uma máquina não aguentar mais as requisições, será levantada uma outra máquina que funcionará em cluster para um, n ou todos os clientes?
Outro fator importante é como limitar o uso do serviço de acordo com as regras contratadas pelo cliente e controlar o dano que um pode causar a outros. Em um pico de uso por parte dos usuários de um cliente, ativamos o chargeback, dependendo do tipo de serviço que é prestado. Implementações comuns de chargeback em cloud (baseados em virtualização) permitem um pico de consumo temporário ou até mesmo mover a aplicação de uma máquina para outra sem que cliente algum perçeba o que está acontecendo.
Ao invés daqueles usuários atrapalharem a performance de outros clientes, é alocado memória e processador distintos dos atuais para ele.
A simplicidade do código é um dos fatores mais afetados pela escolha feita: um código que sabe da existência de múltiplos clientes está diretamente ligado a uma chave que identifica o cliente atual. E essa ligação se reflete por todos os lados do código, uma vez que o comportamento da aplicação em geral depende dele: uma chave estrangeira, um relacionamento, que vai permear toda a aplicação.
Caso a aplicação implemente o suporte a multi tenant através de instalações web distintas, com configurações para cada cliente apontando para um bancos distintos, o código fica mais simples e fácil de manter, uma vez que não é necessário se preocupar com a existência de outros clientes.
Por fim, uma preocupação que surge para a empresa provedora dos serviços é de como agrupar os dados existentes em todos os clientes e gerar relatórios de administração e estatísticas que permitam a melhora do serviço prestado. Quando possuímos um único banco, escalado através de master slave ou múltiplos nós, basta executarmos queries longas (sql ou não), mas se o sistema estiver distribuído entre diversos bancos sem ligação entre si, um processo de batch deve rodar para agrupar os dados e permitir o consumo posterior pelas ferramentas de BI.
É importante analisar todos esses pontos antes de tomar a decisão se o controle de espaço de aplicação por cliente será feito no nosso código, na camada web, no banco ou em algum outro ponto. Como discutimos bastante no curso de arquitetura, toda e qualquer decisão implica em um tradeoff: o importante é saber o que está sendo trocado e qual é o impacto disso.
16.6. Multi-tenancy com bancos separados
OBS:
permitir acesso de outro computador da rede no banco de dados

no banco que se deseja acessar executar:

GRANT ALL PRIVILEGES ON *.* TO USUÁRIO@IP_MAQUINA_QUE_QUER_ACESSO IDENTIFIED BY “senha_do_usuario_na_outra_maquina”

vamos simular varias instancias de banco de dados.
em um computador temos uma instancia do mysql e no localhost tambem temos outra instancia.

dentro do exemplo salvo no codigo terá tambem um exemplo de como buscar os bancos pela alteracao da URL. ou seja se tivermos o mesmo sistema, mas com urls diferentes, tipo
loja1.com.br e loja2.com.br, ele conseguira pegar a url e saber que é para acessar o banco da loja 1 ou da loja 2.

primeiro, o JPA nao tem suporte para multi-tenancy, somente o hibernate.
logo, nao é possivel utilizar nada do JPA. somente do hibernate.

entao, nao utiliza o entitymanager. utilize a session do hibernate.


para criar diferentes hosts no windows:
https://support.norton.com/sp/en/us/home/current/solutions/v72822654_EndUserProfile_en_us

Create a new Windows hosts file
Create a new Windows host file
Press the Windows + R keys to open the Run dialog box.
Type in the following text, and then press Enter.
%systemroot% \system32\drivers\etc
Right-click the hosts file, and select Rename.
Type the following text and then press Enter:
Hosts.old
In the etc folder, right-click on the blank space and select New > Text Document.
Type the following text and then press Enter:
hosts
Click Yes to confirm.
Right-click the hosts file and then click Open With or Open.
Double-click Notepad from the list of programs.
Depending on your version of Windows, copy the following text to the file:
For Windows 10/8/7/Vista:
# Copyright (c) 1993-2006 Microsoft Corp.
#
# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.
#
# This file contains the mappings of IP addresses to host names. Each
# entry should be kept on an individual line. The IP address should
# be placed in the first column followed by the corresponding host name.
# The IP address and the host name should be separated by at least one
# space.
#
# Additionally, comments (such as these) may be inserted on individual
# lines or following the machine name denoted by a '#' symbol.
#
# For example:
#
# 102.54.94.97 rhino.acme.com # source server
# 38.25.63.10 x.acme.com # x client host
127.0.0.1 localhost
::1 localhost
For Windows XP:
# Copyright (c) 1993-1999 Microsoft Corp.
#
# This is a sample HOSTS file used by Microsoft TCP/IP for Windows.
#
# This file contains the mappings of IP addresses to host names. Each
# entry should be kept on an individual line. The IP address should
# be placed in the first column followed by the corresponding host name.
# The IP address and the host name should be separated by at least one
# space.
#
# Additionally, comments (such as these) may be inserted on individual
# lines or following the machine name denoted by a '#' symbol.
#
# For example:
#
# 102.54.94.97 rhino.acme.com # source server
# 38.25.63.10 x.acme.com # x client host
127.0.0.1 localhost
On the File menu, select Save.
On the File menu, select Exit.
16.7. Multi-tenancy com schemas diferentes
agora vamos ver o multi tenancy com schemas diferentes no mesmo banco.

a primeira alteraçao em relaçao ao multi tenancy com bancos diferentes é o persistence.xml
<persistence-unit name="gerenciadorAcessoPU" transaction-type="RESOURCE_LOCAL">
		<properties>
<!-- 			MULTI TENANCY NAO FUNCIONA COM DATASOURCE -->
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/imperio_rodas" />
      		<property name="javax.persistence.jdbc.user" value="root" />
      		<property name="javax.persistence.jdbc.password" value="root" />
      		<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
      		
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />

			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			
<!-- 			MULTI TENANCY COM MESMO BANCO E DIFERENTES SCHEMAS -->
			<property name="hibernate.multiTenancy" value="SCHEMA"/>
			<persistence-unit name="gerenciadorAcessoPU" transaction-type="RESOURCE_LOCAL">
		<properties>
<!-- 			MULTI TENANCY NAO FUNCIONA COM DATASOURCE -->
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/imperio_rodas" />
      		<property name="javax.persistence.jdbc.user" value="root" />
      		<property name="javax.persistence.jdbc.password" value="root" />
      		<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
      		
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect" />

			<property name="hibernate.show_sql" value="true" />
			<property name="hibernate.format_sql" value="true" />
			
<!-- 			MULTI TENANCY COM MESMO BANCO E DIFERENTES SCHEMAS -->
			<property name="hibernate.multiTenancy" value="SCHEMA"/>
			<property name="hibernate.multi_tenant_connection_provider" value="com.algaworks.gerenciador.util.jpa.MultiTenantProvider"/>
		</properties>
	</persistence-unit>

		</properties>
	</persistence-unit>

os schemas no banco de dados nao podem usar (-) traço.
deve-se substituir os schemas com traço por underline.

agora precisamos criar o multi tenant provider, que especificamos no persistence.xml

<property name="hibernate.multi_tenant_connection_provider" value="com.algaworks.gerenciador.util.jpa.MultiTenantProvider"/>




import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;

public class MultiTenantProvider implements MultiTenantConnectionProvider, ServiceRegistryAwareService {

	private static final long serialVersionUID = 1L;

	private DriverManagerConnectionProviderImpl connectionProvider = null;

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		return null;
	}
//inicializa o conection profider a partir das configuraçoes do persistence.xml
	@Override
	public void injectServices(ServiceRegistryImplementor serviceRegistry) {
		Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();

		connectionProvider = new DriverManagerConnectionProviderImpl();
		connectionProvider.injectServices(serviceRegistry);
		connectionProvider.configure(lSettings);
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		return connectionProvider.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		try {
			connection.createStatement().execute("use imperio_rodas");
		} catch (SQLException e) {
			throw new HibernateException("Could not alter JDBC connection to specified schema [public]", e);
		}
		connectionProvider.closeConnection(connection);

	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		final Connection connection = getAnyConnection();
	    try {
	      connection.createStatement().execute("use " + tenantIdentifier);
	    } catch (SQLException e) {
	      throw new HibernateException("Could not alter JDBC connection to specified schema [" + tenantIdentifier + "]", e);
	    }
	    
	    return connection;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		 releaseAnyConnection(connection);
	}

	@Override
	public boolean supportsAggressiveRelease() {
		return false;
	}

}

pronto! lembrando que a diferença entre os tenants esta na url utilizada.

16.8. Engenharia reversa com Hibernate Tools
as vezes temos todas as tabelas do banco mas nao temos o codigo delas. para gerar o codigo delas, utilizamos o hibernate tools.

o hibernate tool é um plugin do eclipse, que vem junto com o jboss tools.

após instalá-lo (se ja nao tiver instalado), para utilizá-lo basta fazer o seguinte:
adicionar uma configuração para o banco de dados em window > open perspective > other > database development
database connections > new > mysql > next
driver adicionamos o driver relacionado
remove o driver que vem com o jboss tools e adiciona o driver que baixamos do musql
nomeamos a database ‘desenvolvimento’
url do banco
root e root
agora em java perspective, criamos um projeto java que sera onde sera criado as classes, podemos chamar ele de model-locadora por exemplo.
no projeto, criar uma pasta lib, que sera onde colocaremos as bibliotecas do hibernate
após criar a pasta, copiar as libs do hibernate, que vem junto com o download, para a pasta lib, primeiro as da pasta lib > required e depois da pasta lib > jpa
depois seleciona as bibliotecas, clica com o direito > build path > add to build path
criar um pacote chamada de com.algaworks.model
criar uma pasta chamada META-INF
window > open perspective > hibernate
clicar com o botão direito > add configuration
na aba main 
seleciona a versão do hibernate, projeto, configuração que fizemos
criar um arquivo de configuração hibernate.cfg.xml na meta-inf
sessionFactory
dialeto do mysql
driver que usamos no persistence.xml
url de conexão
user name e password do banco
finish
tem um botão novo do hibernate, perto do run
clicar em hibernate code generation configurations
new
name: model locadora
hibernate
diretório de saída será o src do projeto
marca reverse engineer
seleciona o pacote que criamos no src do projeto como package
criar um arquivo de engenharia reversa no meta inf
clicar em refresh e aparecerá as tabelas
seleciona em todas
finish
na aba exporters
use java 5
ejb3 annotations
domain code java 
apply
na perspectiva java, as classes já estão la
