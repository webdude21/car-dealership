package eu.webdude.cardealership.security;

import java.util.Arrays;

public class Roles {

	public static final String ADMIN = "ADMIN";

	public static final String USER = "USER";

	public static final String MODERATOR = "MODERATOR";

	public static Iterable<String> getRoles() {
		return Arrays.asList(USER, ADMIN, MODERATOR);
	}

	public static String[] getRolesAsArray() {
		return new String[]{USER, ADMIN, MODERATOR};
	}
}