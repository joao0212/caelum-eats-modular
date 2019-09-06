package br.com.caelum.eats.pedido;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Entrega {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Cliente cliente;

	@NotBlank
	@Size(max=9)
	private String cep;

	@NotBlank
	@Size(max=255)
	private String endereco;

	@Size(max=255)
	private String complemento;

	@OneToOne(optional=false)
	private Pedido pedido;

}
