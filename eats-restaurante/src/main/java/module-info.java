open module br.com.caelum.eats.restaurante {
	exports br.com.caelum.eats.restaurante.dto;
	exports br.com.caelum.eats.restaurante.entidade;
	exports br.com.caelum.eats.restaurante.controller;
	exports br.com.caelum.eats.restaurante.exception;
	exports br.com.caelum.eats.restaurante.service;

	requires transitive br.com.caelum.eats.administrativo;
	requires br.com.caelum.eats.seguranca;
	requires java.persistence;
	requires java.validation;
	requires lombok;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.core;
	requires spring.tx;
	requires spring.web;
}