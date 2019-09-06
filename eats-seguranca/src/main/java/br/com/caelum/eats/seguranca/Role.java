package br.com.caelum.eats.seguranca;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {

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
}
