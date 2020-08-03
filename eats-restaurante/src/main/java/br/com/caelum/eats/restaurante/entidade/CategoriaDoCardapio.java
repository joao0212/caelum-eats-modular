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
		CategoriaDoCardapio other = (CategoriaDoCardapio) obj;
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
