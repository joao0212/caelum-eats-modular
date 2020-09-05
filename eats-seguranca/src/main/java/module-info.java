module br.com.caelum.eats.seguranca {
	requires br.com.caelum.eats.restaurante;

	requires java.persistence;
	requires java.validation;

	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.config;
	requires transitive spring.security.core;
	requires spring.security.web;
	requires spring.web;

	requires com.fasterxml.jackson.annotation;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;
	requires org.apache.tomcat.embed.core;
	requires org.slf4j;
	requires jjwt;

	opens br.com.caelum.eats.seguranca to spring.context, spring.beans, spring.core;
	opens br.com.caelum.eats.seguranca.entidade
			to spring.beans, org.hibernate.orm.core, spring.core, org.hibernate.validator;
	opens br.com.caelum.eats.seguranca.controller to spring.core, spring.beans, spring.web;
	opens br.com.caelum.eats.seguranca.service to spring.beans, spring.core, spring.expression;
	opens br.com.caelum.eats.seguranca.dto to com.fasterxml.jackson.databind;
}