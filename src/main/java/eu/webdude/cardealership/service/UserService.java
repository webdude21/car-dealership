package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User save(User user);
	User register(User user) throws IllegalArgumentException;
}
