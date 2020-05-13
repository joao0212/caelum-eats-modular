module br.com.caelum.eats.seguranca {
	exports br.com.caelum.eats.seguranca.entidade
			to br.com.caelum.eats, br.com.caelum.eats.restaurante, com.fasterxml.jackson.databind, spring.beans;
	exports br.com.caelum.eats.seguranca.dto to br.com.caelum.eats, br.com.caelum.eats.restaurante;
	exports br.com.caelum.eats.seguranca.controller to br.com.caelum.eats, br.com.caelum.eats.restaurante, spring.web;

	requires com.fasterxml.jackson.annotation;
	requires java.persistence;
	requires java.validation;
	requires jjwt;
	requires org.apache.tomcat.embed.core;
	requires org.slf4j;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.config;
	requires transitive spring.security.core;
	requires spring.security.web;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;

	opens br.com.caelum.eats.seguranca to spring.context, spring.beans, spring.core;
	opens br.com.caelum.eats.seguranca.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator;
	opens br.com.caelum.eats.seguranca.controller to spring.core, spring.beans;
	opens br.com.caelum.eats.seguranca.service to spring.beans, spring.core;
	opens br.com.caelum.eats.seguranca.dto to com.fasterxml.jackson.databind;
}