module br.com.caelum.eats.pedido {

	exports br.com.caelum.eats.pedido.dto;
	exports br.com.caelum.eats.pedido.service;
	exports br.com.caelum.eats.pedido.enums;

	// Export de entidade apenas para Model Mapper
	exports br.com.caelum.eats.pedido.entidade to modelmapper;

	requires transitive br.com.caelum.eats.restaurante;

	requires java.persistence;
	requires java.transaction;
	requires java.validation;
	requires java.xml.bind;

	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires spring.beans;

	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires modelmapper;

	opens br.com.caelum.eats.pedido.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.pedido.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pedido.service to spring.core;
}