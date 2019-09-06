package br.com.caelum.eats.restaurante;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDoCardapio {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotBlank @Size(max=150)
	private String nome;

	private String descricao;

	@NotNull @Positive
	private BigDecimal preco;

	@Positive
	private BigDecimal precoPromocional;

	@ManyToOne(optional=false)
	private CategoriaDoCardapio categoria;
	
	public BigDecimal getPrecoEfetivo() {
		return precoPromocional != null ? precoPromocional : preco;
	}
}
