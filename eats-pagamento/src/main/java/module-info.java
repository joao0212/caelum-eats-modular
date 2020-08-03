module br.com.caelum.eats.pagamento {

	exports br.com.caelum.eats.pagamento.dto;
	exports br.com.caelum.eats.pagamento.enums;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.pedido;

	requires java.persistence;
	requires java.validation;
	requires java.xml.bind;

	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires spring.beans;
	requires spring.context;

	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;

	opens br.com.caelum.eats.pagamento.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pagamento.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.pagamento.service to spring.beans, spring.core;
}