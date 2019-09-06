package br.com.caelum.eats.restaurante;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class CategoriaDoCardapio {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank @Size(max=100)
	private String nome;

	@ManyToOne(optional=false)
	private Cardapio cardapio;

	@OneToMany(mappedBy="categoria")
	private List<ItemDoCardapio> itens = new ArrayList<>();
	
}
