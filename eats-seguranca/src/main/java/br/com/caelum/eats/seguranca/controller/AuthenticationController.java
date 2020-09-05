package br.com.caelum.eats.seguranca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.caelum.eats.seguranca.JwtTokenManager;
import br.com.caelum.eats.seguranca.dto.AuthenticationDto;
import br.com.caelum.eats.seguranca.dto.UserInfoDto;
import br.com.caelum.eats.seguranca.entidade.Role;
import br.com.caelum.eats.seguranca.entidade.User;
import br.com.caelum.eats.seguranca.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private AuthenticationManager authManager;
	private JwtTokenManager jwtTokenManager;
	private UserService userService;

	public AuthenticationController(AuthenticationManager authManager, JwtTokenManager jwtTokenManager,
			UserService userService) {
		this.authManager = authManager;
		this.jwtTokenManager = jwtTokenManager;
		this.userService = userService;
	}

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
