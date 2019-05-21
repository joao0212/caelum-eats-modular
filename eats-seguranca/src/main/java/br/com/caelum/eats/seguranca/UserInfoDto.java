package br.com.caelum.eats.seguranca;

import lombok.Data;

@Data
class UserInfoDto {

	private String username;
	private String password;
	
	public User toUser() {
		return new User(username, password);
	}

}
