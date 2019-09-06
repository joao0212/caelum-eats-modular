package br.com.caelum.eats.seguranca;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
class AuthenticationController {

	private AuthenticationManager authManager;
	private JwtTokenManager jwtTokenManager;
	private UserService userService;

	@PostMapping
	public ResponseEntity<AuthenticationDto> authenticate(@RequestBody UserInfoDto login) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				login.getUsername(), login.getPassword());

		try {
			Authentication authentication = authManager.authenticate(authenticationToken);
			User user = (User) authentication.getPrincipal();
			String jwt = jwtTokenManager.generateToken(user);
			AuthenticationDto tokenResponse = new AuthenticationDto(user, jwt);
			return ResponseEntity.ok(tokenResponse);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@PostMapping("/parceiro")
	public Long register(@RequestBody UserInfoDto userInfo) {
		User user = userInfo.toUser();
		user.addRole(Role.ROLES.PARCEIRO);
		User salvo = userService.save(user);
		return salvo.getId();
	}

}
