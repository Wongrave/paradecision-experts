package com.paradecision.config;

import com.paradecision.organizations.users.User;
import com.paradecision.organizations.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		return user.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
	}

	public UserDetails loadUserById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar o usuário com id: " + userId));
	}

	public User save(User user) {
		user.setPassword("{noop}"+user.getPassword());
		return userRepository.save(user);
	}

}
