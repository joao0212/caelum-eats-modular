module br.com.caelum.eats.restaurante {
	exports br.com.caelum.eats.restaurante.dto to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido;
	exports br.com.caelum.eats.restaurante.entidade
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido, spring.beans;
	exports br.com.caelum.eats.restaurante.controller
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido, spring.web;
	exports br.com.caelum.eats.restaurante.exception
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido, br.com.caelum.eats.pagamento;
	exports br.com.caelum.eats.restaurante.service
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido, spring.expression;
	exports br.com.caelum.eats.restaurante.repository to br.com.caelum.eats.distancia, br.com.caelum.eats.pedido;

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
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;
	requires spring.beans;

	opens br.com.caelum.eats.restaurante.dto to com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.restaurante.controller to spring.beans, spring.context, spring.core, spring.aop;
	opens br.com.caelum.eats.restaurante.service to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.restaurante.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
}