package com.paradecision.config;

import com.paradecision.organizations.users.Role;
import com.paradecision.organizations.users.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/auth")
@AllArgsConstructor
class AuthenticationController {

	private AuthenticationManager authManager;
	private JwtTokenManager jwtTokenManager;
	private UserService userService;
	private List<AuthorizationTargetService> authorizationServices;

	@PostMapping
	public ResponseEntity<AuthenticationDto> authenticate(@RequestBody UserInfoDto login) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				login.getUsername(), login.getPassword());

		try {
			Authentication authentication = authManager.authenticate(authenticationToken);
			User user = (User) authentication.getPrincipal();
			String jwt = jwtTokenManager.generateToken(user);
			Long targetId = getTargetIdFor(user);
			AuthenticationDto tokenResponse = new AuthenticationDto(user, jwt, targetId);
			return ResponseEntity.ok(tokenResponse);
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}

	}
	
	@PostMapping("/admin")
	public Long register(@RequestBody User user) {

		user.addRole(Role.ROLES.ADMIN);
		User salvo = userService.save(user);
		return salvo.getId();
	}

	private Long getTargetIdFor(User user) {
		for (AuthorizationTargetService authorizationTargetService : authorizationServices) {
			Long targetId = authorizationTargetService.getTargetIdByUser(user);
			if (targetId != null) {
				return targetId;
			}
		}
		return null;
	}

}
