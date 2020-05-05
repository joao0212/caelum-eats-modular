module br.com.caelum.eats.distancia {
	exports br.com.caelum.eats.distancia.dto;
	exports br.com.caelum.eats.distancia.controller;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.restaurante;
	requires lombok;
	requires spring.context;
	requires spring.data.commons;
	requires spring.web;
}