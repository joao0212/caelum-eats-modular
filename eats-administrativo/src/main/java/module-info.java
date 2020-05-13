module br.com.caelum.eats.administrativo {

	exports br.com.caelum.eats.administrativo.dto
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pagamento, br.com.caelum.eats.restaurante;
	exports br.com.caelum.eats.administrativo.controller
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pagamento, br.com.caelum.eats.restaurante;
	exports br.com.caelum.eats.administrativo.entidade
			to br.com.caelum.eats.distancia, br.com.caelum.eats.pagamento, br.com.caelum.eats.restaurante, spring.beans;

	requires java.persistence;
	requires java.validation;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.web;
	requires net.bytebuddy;
	requires spring.orm;
	requires com.fasterxml.classmate;
	requires com.fasterxml.jackson.databind;
	requires java.xml.bind;
	requires spring.beans;

	opens br.com.caelum.eats.administrativo.dto to com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.administrativo.entidade
			to org.hibernate.orm.core, spring.core, org.hibernate.validator, com.fasterxml.jackson.databind;
	opens br.com.caelum.eats.administrativo.controller to spring.context, spring.core, spring.beans;
}