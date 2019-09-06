package br.com.caelum.eats.seguranca;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class AuthenticationDto {

	private String username;
	private List<String> roles;
	private String token;

	public AuthenticationDto(User user, String jwtToken) {
		this(user.getName(), user.getRoles(), jwtToken);
	}

}
