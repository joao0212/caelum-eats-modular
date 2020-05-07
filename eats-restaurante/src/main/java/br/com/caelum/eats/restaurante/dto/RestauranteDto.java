package br.com.caelum.eats.restaurante.dto;

import java.math.BigDecimal;

import br.com.caelum.eats.administrativo.dto.TipoDeCozinhaDto;
import br.com.caelum.eats.restaurante.entidade.Restaurante;

public class RestauranteDto {

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

	public RestauranteDto(Restaurante restaurante) {
		this(restaurante.getId(), restaurante.getCnpj(), restaurante.getNome(), restaurante.getDescricao(),
				restaurante.getCep(), restaurante.getEndereco(), restaurante.getTaxaDeEntregaEmReais(),
				restaurante.getTempoDeEntregaMinimoEmMinutos(), restaurante.getTempoDeEntregaMaximoEmMinutos(),
				restaurante.getAprovado(), new TipoDeCozinhaDto(restaurante.getTipoDeCozinha()));
	}

	public void populaRestaurante(Restaurante restaurante) {
		restaurante.setCnpj(cnpj);
		restaurante.setNome(nome);
		restaurante.setDescricao(descricao);
		restaurante.setCep(cep);
		restaurante.setEndereco(endereco);
		restaurante.setTaxaDeEntregaEmReais(taxaDeEntregaEmReais);
		restaurante.setTempoDeEntregaMinimoEmMinutos(tempoDeEntregaMinimoEmMinutos);
		restaurante.setTempoDeEntregaMaximoEmMinutos(tempoDeEntregaMaximoEmMinutos);
		restaurante.setTipoDeCozinha(tipoDeCozinha.toTipoDeCozinha());
	}

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
}
