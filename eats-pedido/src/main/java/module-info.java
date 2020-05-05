module br.com.caelum.eats.pedido {
	exports br.com.caelum.eats.pedido.dto;
	exports br.com.caelum.eats.pedido.controller;
	exports br.com.caelum.eats.pedido.entidade;
	exports br.com.caelum.eats.pedido.service;

	requires transitive br.com.caelum.eats.restaurante;
	requires java.persistence;
	requires java.transaction;
	requires java.validation;
	requires lombok;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
}