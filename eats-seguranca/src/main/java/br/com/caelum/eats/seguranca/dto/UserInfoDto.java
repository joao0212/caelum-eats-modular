package br.com.caelum.eats.seguranca.dto;

import br.com.caelum.eats.seguranca.entidade.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {

	private String username;
	private String password;

	public User toUser() {
		return new User(username, password);
	}

}
