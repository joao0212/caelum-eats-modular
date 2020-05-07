open module br.com.caelum.eats {

	exports br.com.caelum.eats to spring.boot.devtools;

	requires java.sql;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.webmvc;

	requires br.com.caelum.eats.distancia;
	requires br.com.caelum.eats.pagamento;
	requires br.com.caelum.eats.seguranca;
	
	requires com.fasterxml.jackson.annotation;
	requires java.persistence;
	requires java.validation;
	requires jjwt;
	requires org.apache.tomcat.embed.core;
	requires org.slf4j;
	requires spring.beans;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.config;
	requires transitive spring.security.core;
	requires spring.security.web;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires java.xml.bind;
}