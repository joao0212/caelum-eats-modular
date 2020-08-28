module br.com.caelum.eats.restaurante {

	exports br.com.caelum.eats.restaurante.dto;
	exports br.com.caelum.eats.restaurante.service;

	// Export de entidade apenas para Model Mapper
	exports br.com.caelum.eats.restaurante.entidade to modelmapper;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.seguranca;

	requires java.persistence;
	requires java.validation;
	requires java.xml.bind;

	requires spring.context;
	requires transitive spring.data.commons;
	requires spring.data.jpa;
	requires transitive spring.security.core;
	requires spring.tx;
	requires spring.web;
	requires spring.beans;

	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires modelmapper;

	opens br.com.caelum.eats.restaurante.dto to com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.restaurante.controller
			to spring.beans, spring.context, spring.core, spring.aop, spring.web;
	opens br.com.caelum.eats.restaurante.service to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.restaurante.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
}