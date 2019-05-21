package br.com.caelum.eats.seguranca;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
class AuthorizationService {

	private List<AuthorizationTargetService> authorizationServices;

	public boolean checaTargetId(Authentication authentication, long id) {
		User user = (User) authentication.getPrincipal();
		for (AuthorizationTargetService authorizationTargetService : authorizationServices) {
			Long targetId = authorizationTargetService.getTargetIdByUser(user);
			if (targetId != null && targetId == id) {
				return true;
			}
		}
		return false;
	}

}
