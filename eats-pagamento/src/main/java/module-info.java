module br.com.caelum.eats.pagamento {
	exports br.com.caelum.eats.pagamento.controller to br.com.caelum.eats;
	exports br.com.caelum.eats.pagamento.entidade to br.com.caelum.eats, spring.beans;
	exports br.com.caelum.eats.pagamento.dto to br.com.caelum.eats, com.fasterxml.jackson.databind;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.pedido;
	requires java.persistence;
	requires java.validation;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;
	requires spring.beans;

	opens br.com.caelum.eats.pagamento.controller to spring.beans, spring.context, spring.core;
	opens br.com.caelum.eats.pagamento.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
}