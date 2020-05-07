package br.com.caelum.eats.seguranca.dto;

import java.util.List;

import br.com.caelum.eats.seguranca.entidade.User;

public class AuthenticationDto {

	public AuthenticationDto(String username, List<String> roles, String token) {
		this.username = username;
		this.roles = roles;
		this.token = token;
	}

	public AuthenticationDto() {
	}

	private String username;
	private List<String> roles;
	private String token;

	public AuthenticationDto(User user, String jwtToken) {
		this(user.getName(), user.getRoles(), jwtToken);
	}

	public String getUsername() {
		return username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getToken() {
		return token;
	}
}
