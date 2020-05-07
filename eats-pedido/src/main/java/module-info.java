module br.com.caelum.eats.pedido {
	exports br.com.caelum.eats.pedido.dto;
	exports br.com.caelum.eats.pedido.controller;
	exports br.com.caelum.eats.pedido.entidade;
	exports br.com.caelum.eats.pedido.service;

	requires transitive br.com.caelum.eats.restaurante;
	requires java.persistence;
	requires java.transaction;
	requires java.validation;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires java.xml.bind;

	opens br.com.caelum.eats.pedido.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator;
	opens br.com.caelum.eats.pedido.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pedido.service to spring.beans, spring.context, spring.core;
}