package br.com.caelum.eats.restaurante.entidade;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class HorarioDeFuncionamento {

	public HorarioDeFuncionamento(Long id, @NotNull DayOfWeek diaDaSemana, @NotNull LocalTime horarioDeAbertura,
			@NotNull LocalTime horarioDeFechamento, Long restauranteId) {
		this.id = id;
		this.diaDaSemana = diaDaSemana;
		this.horarioDeAbertura = horarioDeAbertura;
		this.horarioDeFechamento = horarioDeFechamento;
		this.restauranteId = restauranteId;
	}

	public HorarioDeFuncionamento() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Enumerated(EnumType.STRING)
	private DayOfWeek diaDaSemana;

	@NotNull
	private LocalTime horarioDeAbertura;

	@NotNull
	private LocalTime horarioDeFechamento;

	@Column(name = "restaurante_id")
	private Long restauranteId;

	public Long getId() {
		return id;
	}

	public DayOfWeek getDiaDaSemana() {
		return diaDaSemana;
	}

	public LocalTime getHorarioDeAbertura() {
		return horarioDeAbertura;
	}

	public LocalTime getHorarioDeFechamento() {
		return horarioDeFechamento;
	}

	public Long getRestauranteId() {
		return restauranteId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		HorarioDeFuncionamento other = (HorarioDeFuncionamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
