package br.com.caelum.eats.admin;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class TipoDeCozinhaController {

	private TipoDeCozinhaRepository repo;

	@GetMapping("/tipos-de-cozinha")
	public List<TipoDeCozinha> lista() {
		return repo.findAllByOrderByNomeAsc();
	}

	@PostMapping("/admin/tipos-de-cozinha")
	public TipoDeCozinha adiciona(@RequestBody TipoDeCozinha tipoDeCozinha) {
		return repo.save(tipoDeCozinha);
	}

	@PutMapping("/admin/tipos-de-cozinha/{id}")
	public TipoDeCozinha atualiza(@RequestBody TipoDeCozinha tipoDeCozinha) {
		return repo.save(tipoDeCozinha);
	}

	@DeleteMapping("/admin/tipos-de-cozinha/{id}")
	public void remove(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}

}
