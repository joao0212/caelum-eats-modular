package br.com.caelum.eats.seguranca.dto;

import br.com.caelum.eats.seguranca.entidade.User;

public class UserInfoDto {

	public UserInfoDto(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserInfoDto() {
		super();
	}

	private String username;
	private String password;

	public User toUser() {
		return new User(username, password);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
