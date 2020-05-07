module br.com.caelum.eats.restaurante {
	exports br.com.caelum.eats.restaurante.dto;
	exports br.com.caelum.eats.restaurante.entidade;
	exports br.com.caelum.eats.restaurante.controller;
	exports br.com.caelum.eats.restaurante.exception;
	exports br.com.caelum.eats.restaurante.service;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.seguranca;
	requires java.persistence;
	requires java.validation;
	requires spring.context;
	requires transitive spring.data.commons;
	requires spring.data.jpa;
	requires transitive spring.security.core;
	requires spring.tx;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires java.xml.bind;

	opens br.com.caelum.eats.restaurante.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.restaurante.service to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.restaurante.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator;
}