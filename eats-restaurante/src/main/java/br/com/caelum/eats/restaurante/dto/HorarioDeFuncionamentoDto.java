package br.com.caelum.eats.restaurante.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

import br.com.caelum.eats.restaurante.entidade.HorarioDeFuncionamento;

public class HorarioDeFuncionamentoDto {

	private Long id;
	private DayOfWeek diaDaSemana;
	private LocalTime horarioDeAbertura;
	private LocalTime horarioDeFechamento;

	public HorarioDeFuncionamentoDto(HorarioDeFuncionamento horario) {
		this(horario.getId(), horario.getDiaDaSemana(), horario.getHorarioDeAbertura(),
				horario.getHorarioDeFechamento());
	}

	public HorarioDeFuncionamentoDto(Long id, DayOfWeek diaDaSemana, LocalTime horarioDeAbertura,
			LocalTime horarioDeFechamento) {
		this.id = id;
		this.diaDaSemana = diaDaSemana;
		this.horarioDeAbertura = horarioDeAbertura;
		this.horarioDeFechamento = horarioDeFechamento;
	}

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
}
