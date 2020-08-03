package br.com.caelum.eats.restaurante.entidade;

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

@Entity
public class ItemDoCardapio {

	public ItemDoCardapio(Long id, @NotBlank @Size(max = 150) String nome, String descricao,
			@NotNull @Positive BigDecimal preco, @Positive BigDecimal precoPromocional, CategoriaDoCardapio categoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.precoPromocional = precoPromocional;
		this.categoria = categoria;
	}

	public ItemDoCardapio() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 150)
	private String nome;

	private String descricao;

	@NotNull
	@Positive
	private BigDecimal preco;

	@Positive
	private BigDecimal precoPromocional;

	@ManyToOne(optional = false)
	private CategoriaDoCardapio categoria;

	public BigDecimal getPrecoEfetivo() {
		return precoPromocional != null ? precoPromocional : preco;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}

	public CategoriaDoCardapio getCategoriaDoCardapio() {
		return categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDoCardapio other = (ItemDoCardapio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
