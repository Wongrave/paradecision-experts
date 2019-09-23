package com.paradecision.config;

import com.paradecision.organizations.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

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
