module br.com.caelum.eats.distancia {

	exports br.com.caelum.eats.distancia.dto;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.restaurante;

	requires spring.context;
	requires spring.data.commons;
	requires spring.web;
	requires spring.beans;

	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;

	requires java.xml.bind;

	opens br.com.caelum.eats.distancia.controller to spring.context, spring.beans, spring.core;
	opens br.com.caelum.eats.distancia.service to spring.context, spring.beans, spring.core;
}