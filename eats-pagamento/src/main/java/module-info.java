module br.com.caelum.eats.pagamento {
	exports br.com.caelum.eats.pagamento.controller;
	exports br.com.caelum.eats.pagamento.entidade;
	exports br.com.caelum.eats.pagamento.dto;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.pedido;
	requires java.persistence;
	requires java.validation;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires java.xml.bind;

	opens br.com.caelum.eats.pagamento.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pagamento.entidade to org.hibernate.orm.core, spring.core, org.hibernate.validator;
}