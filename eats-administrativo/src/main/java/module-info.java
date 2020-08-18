module br.com.caelum.eats.administrativo {

	exports br.com.caelum.eats.administrativo.dto;
	exports br.com.caelum.eats.administrativo.enums;
	exports br.com.caelum.eats.administrativo.service;

	// Export de entidade apenas para Model Mapper
	exports br.com.caelum.eats.administrativo.entidade to modelmapper;

	requires java.persistence;
	requires java.validation;
	requires java.xml.bind;

	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires spring.orm;
	requires spring.beans;
	requires spring.context;

	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires modelmapper;

	opens br.com.caelum.eats.administrativo.dto to com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.administrativo.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator,
			com.fasterxml.jackson.databind, spring.beans;
	opens br.com.caelum.eats.administrativo.controller to spring.context, spring.core, spring.beans;
	opens br.com.caelum.eats.administrativo.service to spring.core;
}