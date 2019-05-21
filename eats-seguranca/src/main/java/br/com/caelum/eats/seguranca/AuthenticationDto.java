package br.com.caelum.eats.seguranca;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class AuthenticationDto {

	private String username;
	private List<String> roles;
	private String token;
	private Long targetId;

	public AuthenticationDto(User user, String jwtToken, Long targetId) {
		this(user.getName(), user.getRoles(), jwtToken, targetId);
	}

}
