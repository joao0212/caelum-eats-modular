package br.com.caelum.eats.pedido.dto;

public class EntregaDto {

	private Long id;
	private ClienteDto clienteDto;
	private String cep;
	private String endereco;
	private String complemento;

	public Long getId() {
		return id;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public String getCep() {
		return cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
}
