package br.com.caelum.eats.seguranca;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class UserInfoDto {

	private String username;
	private String password;
	
	public User toUser() {
		return new User(username, password);
	}

}
