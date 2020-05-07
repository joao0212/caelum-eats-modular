package br.com.caelum.eats.restaurante.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class CategoriaDoCardapio {

	public CategoriaDoCardapio(Long id, @NotBlank @Size(max = 100) String nome, Cardapio cardapio,
			List<ItemDoCardapio> itens) {
		this.id = id;
		this.nome = nome;
		this.cardapio = cardapio;
		this.itens = itens;
	}

	public CategoriaDoCardapio() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String nome;

	@ManyToOne(optional = false)
	private Cardapio cardapio;

	@OneToMany(mappedBy = "categoria")
	private List<ItemDoCardapio> itens = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public List<ItemDoCardapio> getItens() {
		return itens;
	}
}
