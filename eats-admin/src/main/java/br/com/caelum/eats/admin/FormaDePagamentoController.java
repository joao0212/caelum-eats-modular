package br.com.caelum.eats.admin;

import java.util.Arrays;
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
class FormaDePagamentoController {

	private FormaDePagamentoRepository formaRepo;

	@GetMapping("/formas-de-pagamento")
	public List<FormaDePagamento> lista() {
		return formaRepo.findAllByOrderByNomeAsc();
	}

	@GetMapping("/admin/formas-de-pagamento/tipos")
	public List<FormaDePagamento.Tipo> tipos() {
		return Arrays.asList(FormaDePagamento.Tipo.values());
	}

	@PostMapping("/admin/formas-de-pagamento")
	public FormaDePagamento adiciona(@RequestBody FormaDePagamento tipoDeCozinha) {
		return formaRepo.save(tipoDeCozinha);
	}

	@PutMapping("/admin/formas-de-pagamento/{id}")
	public FormaDePagamento atualiza(@RequestBody FormaDePagamento tipoDeCozinha) {
		return formaRepo.save(tipoDeCozinha);
	}

	@DeleteMapping("/admin/formas-de-pagamento/{id}")
	public void remove(@PathVariable("id") Long id) {
		formaRepo.deleteById(id);
	}

}
