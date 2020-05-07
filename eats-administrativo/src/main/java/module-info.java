module br.com.caelum.eats.administrativo {

	exports br.com.caelum.eats.administrativo.dto;
	exports br.com.caelum.eats.administrativo.controller;
	exports br.com.caelum.eats.administrativo.entidade;

	requires java.persistence;
	requires java.validation;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires spring.orm;
	requires com.fasterxml.classmate;
	requires java.xml.bind;

	opens br.com.caelum.eats.administrativo.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator;
	opens br.com.caelum.eats.administrativo.controller to spring.context, spring.core, spring.beans;
}