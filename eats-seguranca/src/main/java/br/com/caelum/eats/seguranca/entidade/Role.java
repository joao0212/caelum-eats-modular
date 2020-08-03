package br.com.caelum.eats.seguranca.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {

	public Role(String authority) {
		this.authority = authority;
	}

	public Role() {
	}

	private static final long serialVersionUID = 1L;

	public static enum ROLES {
		ADMIN, PARCEIRO;

		public String asAuthority() {
			return "ROLE_" + name();
		}
	}

	@Id
	private String authority;

	public String getRole() {
		return authority.replace("ROLE_", "");
	}

	public String getAuthority() {
		return authority;
	}

}
