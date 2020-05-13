module br.com.caelum.eats.pedido {
	exports br.com.caelum.eats.pedido.dto to br.com.caelum.eats.pagamento, com.fasterxml.jackson.databind;
	exports br.com.caelum.eats.pedido.controller to br.com.caelum.eats.pagamento;
	exports br.com.caelum.eats.pedido.entidade to br.com.caelum.eats.pagamento, spring.beans;
	exports br.com.caelum.eats.pedido.service to br.com.caelum.eats.pagamento;

	requires transitive br.com.caelum.eats.restaurante;
	requires java.persistence;
	requires java.transaction;
	requires java.validation;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;
	requires spring.beans;

	opens br.com.caelum.eats.pedido.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.pedido.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pedido.service to spring.beans, spring.context, spring.core;
}