open module br.com.caelum.eats.seguranca {
	exports br.com.caelum.eats.seguranca.entidade;
	exports br.com.caelum.eats.seguranca.dto;
	exports br.com.caelum.eats.seguranca.controller;

	requires com.fasterxml.jackson.annotation;
	requires java.persistence;
	requires java.validation;
	requires jjwt;
	requires org.apache.tomcat.embed.core;
	requires org.slf4j;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.security.config;
	requires transitive spring.security.core;
	requires spring.security.web;
	requires spring.web;
}