module br.com.caelum.eats.administrativo {

	exports br.com.caelum.eats.administrativo.dto;
	exports br.com.caelum.eats.administrativo.controller;
	exports br.com.caelum.eats.administrativo.entidade;

	requires java.persistence;
	requires java.validation;
	requires lombok;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
}