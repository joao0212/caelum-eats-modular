package br.com.caelum.eats.restaurante;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class RestauranteController {

	private RestauranteRepository restauranteRepo;
	private CardapioRepository cardapioRepo;

	@GetMapping("/restaurantes/{id}")
	RestauranteDto detalha(@PathVariable("id") Long id) {
		Restaurante restaurante = restauranteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new RestauranteDto(restaurante);
	}

	@GetMapping("/parceiros/restaurantes/do-usuario/{username}")
	public RestauranteDto detalhaParceiro(@PathVariable("username") String username) {
		Restaurante restaurante = restauranteRepo.findByUsername(username);
		return new RestauranteDto(restaurante);
	}

	@GetMapping("/restaurantes")
	List<RestauranteDto> detalhePorIds(@RequestParam("ids") List<Long> ids) {
		return restauranteRepo.findAllById(ids).stream().map(RestauranteDto::new).collect(Collectors.toList());
	}

	@GetMapping("/parceiros/restaurantes/{id}")
	RestauranteDto detalhaParceiro(@PathVariable("id") Long id) {
		Restaurante restaurante = restauranteRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		return new RestauranteDto(restaurante);
	}

	@PostMapping("/parceiros/restaurantes")
	Restaurante adiciona(@RequestBody Restaurante restaurante) {
		restaurante.setAprovado(false);
		Restaurante restauranteSalvo = restauranteRepo.save(restaurante);
		Cardapio cardapio = new Cardapio();
		cardapio.setRestaurante(restauranteSalvo);
		cardapioRepo.save(cardapio);
		return restauranteSalvo;
	}

  @PutMapping("/parceiros/restaurantes/{id}")
  public RestauranteDto atualiza(@RequestBody RestauranteDto restaurante) {
    Restaurante doBD = restauranteRepo.getOne(restaurante.getId());
    restaurante.populaRestaurante(doBD);
    return new RestauranteDto(restauranteRepo.save(doBD));
  }


  @GetMapping("/admin/restaurantes/em-aprovacao")
	List<RestauranteDto> emAprovacao() {
		return restauranteRepo.findAllByAprovado(false).stream().map(RestauranteDto::new)
				.collect(Collectors.toList());
	}

	@Transactional
	@PatchMapping("/admin/restaurantes/{id}")
	public void aprova(@PathVariable("id") Long id) {
		restauranteRepo.aprovaPorId(id);
	}
}
