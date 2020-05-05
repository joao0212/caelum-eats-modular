module br.com.caelum.eats.pagamento {
	exports br.com.caelum.eats.pagamento.controller;
	exports br.com.caelum.eats.pagamento.entidade;
	exports br.com.caelum.eats.pagamento.dto;

	requires transitive br.com.caelum.eats.administrativo;
	requires transitive br.com.caelum.eats.pedido;
	requires java.persistence;
	requires java.validation;
	requires lombok;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
}