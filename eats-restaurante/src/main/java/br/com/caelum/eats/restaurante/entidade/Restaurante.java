package br.com.caelum.eats.restaurante.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 18)
	private String cnpj;

	@NotBlank
	@Size(max = 255)
	private String nome;

	@Size(max = 1000)
	private String descricao;

	@NotBlank
	@Size(max = 9)
	private String cep;

	@NotBlank
	@Size(max = 300)
	private String endereco;

	@Positive
	private BigDecimal taxaDeEntregaEmReais;

	@Positive
	@Min(10)
	@Max(180)
	private Integer tempoDeEntregaMinimoEmMinutos;

	@Positive
	@Min(10)
	@Max(180)
	private Integer tempoDeEntregaMaximoEmMinutos;

	private Boolean aprovado;

	@Column(name = "tipo_de_cozinha_id")
	private Long tipoDeCozinhaId;

	@Column(name = "user_id")
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getTaxaDeEntregaEmReais() {
		return taxaDeEntregaEmReais;
	}

	public void setTaxaDeEntregaEmReais(BigDecimal taxaDeEntregaEmReais) {
		this.taxaDeEntregaEmReais = taxaDeEntregaEmReais;
	}

	public Integer getTempoDeEntregaMinimoEmMinutos() {
		return tempoDeEntregaMinimoEmMinutos;
	}

	public void setTempoDeEntregaMinimoEmMinutos(Integer tempoDeEntregaMinimoEmMinutos) {
		this.tempoDeEntregaMinimoEmMinutos = tempoDeEntregaMinimoEmMinutos;
	}

	public Integer getTempoDeEntregaMaximoEmMinutos() {
		return tempoDeEntregaMaximoEmMinutos;
	}

	public void setTempoDeEntregaMaximoEmMinutos(Integer tempoDeEntregaMaximoEmMinutos) {
		this.tempoDeEntregaMaximoEmMinutos = tempoDeEntregaMaximoEmMinutos;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Long getTipoDeCozinhaId() {
		return tipoDeCozinhaId;
	}

	public void setTipoDeCozinhaId(Long tipoDeCozinhaId) {
		this.tipoDeCozinhaId = tipoDeCozinhaId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Restaurante other = (Restaurante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
