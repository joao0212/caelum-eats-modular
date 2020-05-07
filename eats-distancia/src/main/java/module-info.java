module br.com.caelum.eats.distancia {
	exports br.com.caelum.eats.distancia.dto;
	exports br.com.caelum.eats.distancia.controller;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.restaurante;
	requires spring.context;
	requires spring.data.commons;
	requires spring.web;
	requires com.fasterxml.classmate;
	requires java.xml.bind;

	opens br.com.caelum.eats.distancia.controller to spring.context, spring.beans, spring.core;
	opens br.com.caelum.eats.distancia.service to spring.context, spring.beans, spring.core;
}