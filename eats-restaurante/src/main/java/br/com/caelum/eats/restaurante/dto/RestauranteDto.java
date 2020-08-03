package br.com.caelum.eats.restaurante.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.TipoDeCozinhaDto;

public class RestauranteDto {

	public RestauranteDto() {

	}

	public RestauranteDto(Long id, String cnpj, String nome, String descricao, String cep, String endereco,
			BigDecimal taxaDeEntregaEmReais, Integer tempoDeEntregaMinimoEmMinutos,
			Integer tempoDeEntregaMaximoEmMinutos, Boolean aprovado, TipoDeCozinhaDto tipoDeCozinha) {
		this.id = id;
		this.cnpj = cnpj;
		this.nome = nome;
		this.descricao = descricao;
		this.cep = cep;
		this.endereco = endereco;
		this.taxaDeEntregaEmReais = taxaDeEntregaEmReais;
		this.tempoDeEntregaMinimoEmMinutos = tempoDeEntregaMinimoEmMinutos;
		this.tempoDeEntregaMaximoEmMinutos = tempoDeEntregaMaximoEmMinutos;
		this.aprovado = aprovado;
		this.tipoDeCozinha = tipoDeCozinha;
	}

	private Long id;
	private String cnpj;
	private String nome;
	private String descricao;
	private String cep;
	private String endereco;
	private BigDecimal taxaDeEntregaEmReais;
	private Integer tempoDeEntregaMinimoEmMinutos;
	private Integer tempoDeEntregaMaximoEmMinutos;
	private Boolean aprovado;
	private TipoDeCozinhaDto tipoDeCozinha;

	public Long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public BigDecimal getTaxaDeEntregaEmReais() {
		return taxaDeEntregaEmReais;
	}

	public Integer getTempoDeEntregaMinimoEmMinutos() {
		return tempoDeEntregaMinimoEmMinutos;
	}

	public Integer getTempoDeEntregaMaximoEmMinutos() {
		return tempoDeEntregaMaximoEmMinutos;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public TipoDeCozinhaDto getTipoDeCozinha() {
		return tipoDeCozinha;
	}

	public void setTipoDeCozinha(TipoDeCozinhaDto tipoDeCozinha) {
		this.tipoDeCozinha = tipoDeCozinha;
	}
}
