package br.com.caelum.eats.restaurante;

import java.time.DayOfWeek;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class HorarioDeFuncionamentoDto {

	private Long id;

	private DayOfWeek diaDaSemana;

	private LocalTime horarioDeAbertura;

	private LocalTime horarioDeFechamento;

	public HorarioDeFuncionamentoDto(HorarioDeFuncionamento horario) {
		this(horario.getId(), horario.getDiaDaSemana(), horario.getHorarioDeAbertura(), horario.getHorarioDeFechamento());
	}
}
