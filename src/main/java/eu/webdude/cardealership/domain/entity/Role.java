package eu.webdude.cardealership.domain.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	@NotEmpty
	private String role;

	public Role(String role) {
		this.role = role;
	}

	public Role() {

	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String getAuthority() {
		return this.getRole();
	}
}
