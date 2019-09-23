package com.paradecision.organizations.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	public static enum ROLES {
		ADMIN, MASTER, PARADECISION;
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
