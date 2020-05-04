package br.com.caelum.eats.restaurante.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardapioDto {

	private Long id;
	private List<CategoriaDoCardapioDto> categorias = new ArrayList<>();

	public CardapioDto(Cardapio cardapio) {
		this(cardapio.getId(), trataCategorias(cardapio.getCategorias()));
	}

	private static List<CategoriaDoCardapioDto> trataCategorias(List<CategoriaDoCardapio> categorias) {
		return categorias.stream().map(CategoriaDoCardapioDto::new).collect(Collectors.toList());
	}
}
