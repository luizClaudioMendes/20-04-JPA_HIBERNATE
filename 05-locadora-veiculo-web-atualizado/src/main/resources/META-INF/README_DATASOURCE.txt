**************************************************************************

**************************************************************************
#TOMCAT

**************************************************************************

**************************************************************************

*************************
persistence.xml
*************************
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<!-- controle de transacao por RESOURCE_LOCAL -->
	<persistence-unit name="locadoraVeiculoPU" transaction-type="RESOURCE_LOCAL">
		<non-jta-data-source>java:comp/env/jdbc/locadoraDB</non-jta-data-source>
		<properties>
			<property name="hibernate.hbm2ddl.auto" value="update"/>
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	</persistence-unit>
	
<!-- 	TESTE COM OUTRO PERSISTENCE UNIT PARA JUNIT -->
	<persistence-unit name="junitPU" transaction-type="RESOURCE_LOCAL">
		<properties>
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/locadora"/>
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.password" value="root"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver"/>
		
			
		<!-- validate | update | create | create-drop -->
			<property name="hibernate.hbm2ddl.auto" value="update"/>
			<property name="hibernate.format_sql" value="false"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	
	</persistence-unit>
	
</persistence>





**************************************************************************

**************************************************************************
#JBOSS

**************************************************************************

**************************************************************************


utilizando JTA e EJB

=> controle da transacao pelo container

1. baixar e extrair o jboss ou o wildfly
2. ao clicar em /bin/standalone.bat, verificamos que o servidor
é startado (localhost:8080)
3. no persistence.xml
* alterar o transaction-type para 'JTA'
* nao tem a properties com as informaçoes de conexao ao banco,
que ficarao no datasource no servidor
* para funcionar, temos que adicionar o 'provider'
<provider>org.hibernate.ejb.HibernatePersistence</provider>
* adicionar tambem o datasource
<jta-data-source>java:/projetoJbossDS</jta-data-source>
4. na pasta do servidor, em modules/com/ devemos criar um novo
modulo, para conexao com mysql
5. criar a pasta /main e colar nela o conector do mysql, na versao que
definimos no POM (ex.mysql-connector-java-5.1.25-bin.jar)
6. criar tambem na mesma pasta, o arquivo module.xml e nele:
<?xml version="1.0" encoding="UTF-8"?>
  <module xmlns="urn:jboss:module:1.0" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.25-bin.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
  </module>
7. configurar o arquivo <jboss_home>/standalone/configuration/standalone.xml
adicionando o datasource. (OBS: nao apagar o datasouce de teste que ja existe)

...
<datasource jta="true" jndi-name="java:/projetoJbossDS" pool-name="MySqlDS" enabled="true" use-java-context="true" use-ccm="true">
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
  <drivers>
    <driver name="mysql" module="com.mysql"/>
  </drivers>
  ...
8. para facilitar, no pom adicionamos um plugin do maven, para
fazer o deploy para nós.

no POM.xml do ear:
<plugin>
	<artifactId>maven-antrun-plugin</artifactId>
	<executions>
		<execution>
			<id>deploy-war</id>
			<phase>install</phase>
			<goals>
				<goal>run</goal>
			</goals>
			<configuration>
				<tasks>
					<copy overwrite="true" file="target/${project.build.finalName}.ear"
						todir="${jboss.home}/standalone/deployments" />
				</tasks>
			</configuration>
		</execution>
		<execution>
			<id>undeploy-DU</id>
			<phase>clean</phase>
			<goals>
				<goal>run</goal>
			</goals>
			<configuration>
				<tasks>
					<delete
						file="${jboss.home}/standalone/deployments/${project.build.finalName}.ear" />
				</tasks>
			</configuration>
		</execution>
	</executions>
</plugin>

que informa ao dar o build ele copia para a pasta deployments do servidor.

quando for executar o run do maven,
acrescentar:

clean install -Djboss.home=CAMINHO_COMPLETO_DO_JBOSS


************************
persistence.xml
************************
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.0"
	xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	
	<persistence-unit name="projetoJbossPU" transaction-type="JTA">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		<jta-data-source>java:/projetoJbossDS</jta-data-source>
		
		<class>com.algaworks.jboss.modelo.Cliente</class>
		
		<properties>			
			<!-- validate | update | create | create-drop -->
			<property name="hibernate.hbm2ddl.auto" value="update"/>
			<property name="hibernate.show_sql" value="true"/>
			<property name="hibernate.format_sql" value="true"/>
			<property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
		</properties>
	</persistence-unit>
	
</persistence>

************************
module.xml
************************

<?xml version="1.0" encoding="UTF-8"?>
  <module xmlns="urn:jboss:module:1.0" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.25-bin.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
  </module>
  
  
  
  
  
  
  
**************************************************************************

**************************************************************************
#WILDFLY

**************************************************************************

**************************************************************************

1. Extrair o wildfly para uma pasta qualquer

2. Configurar o módulo do datasource

  2.1 Criar as pastas mysql/main em <wildfly_home>/modules/system/layers/base/com/
  
  2.2 Copiar o driver (mysql-connector-java-5.1.34-bin.jar) para esta pasta
  
  2.3 Criar o arquivo module.xml com o seguinte conteúdo:
  
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

  2.4 Editar o arquivo <wildfly_home>/standalone/configuration/standalone.xml
  
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
    
	<drivers>
		<driver name="mysql" module="com.mysql">
			<driver-class>com.mysql.jdbc.Driver</driver-class>
		</driver>
    </drivers>
  
3. Crie o schema "cadastro_cliente" no MySQL para o usuário root, se ainda não tiver sido criado.


