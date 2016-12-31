package eu.webdude.cardealership.service;

import eu.webdude.cardealership.domain.entity.User;
import eu.webdude.cardealership.repository.UserRepository;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class UserServiceTests {

	private static final String ENCODED_PASSWORD = "encodedPassword";

	private static final String RAW_PASSWORD = "somePassword";

	private static final String VALID_EMAIL = "webdude@dude.eu";

	private User mockedUser;

	private UserRepository mockedUserRepo;

	private UserService userService;

	private PasswordEncoder mockedPasswordEncoder;

	public UserServiceTests() {
		mockedUser = new User("dimo", "petrov", VALID_EMAIL, RAW_PASSWORD);
		mockedUserRepo = mock(UserRepository.class);
		mockedPasswordEncoder = mock(PasswordEncoder.class);
		userService = new UserServiceImpl(mockedUserRepo, mockedPasswordEncoder);
	}

	@Test
	public void fetchingAnExistingUser() {
		when(mockedUserRepo.findOneByEmail(VALID_EMAIL)).thenReturn(mockedUser);
		UserDetails user = userService.loadUserByUsername(VALID_EMAIL);
		assertThat(user, equalTo(mockedUser));
		verify(mockedUserRepo, times(1)).findOneByEmail(VALID_EMAIL);
	}

	@Test(expected = UsernameNotFoundException.class)
	public void requiestingNonExistingUserThrowsException() {
		when(mockedUserRepo.findOneByEmail(VALID_EMAIL)).thenReturn(null);
		userService.loadUserByUsername(VALID_EMAIL);
	}

	@Test
	public void savingAnUserEncodesThePassword() {
		when(mockedPasswordEncoder.encode(RAW_PASSWORD)).thenReturn(ENCODED_PASSWORD);
		userService.save(mockedUser);
		assertThat(mockedUser.getPassword(), equalTo(ENCODED_PASSWORD));
		verify(mockedPasswordEncoder, times(1)).encode(RAW_PASSWORD);
	}

	@Test
	public void callingSaveActuallySavesTheUserAndReturnsIt() {
		when(mockedUserRepo.save(mockedUser)).thenReturn(mockedUser);
		User user = userService.save(mockedUser);
		assertThat(mockedUser, equalTo(user));
		verify(mockedUserRepo, times(1)).save(mockedUser);
	}

	@Test
	public void callingRegisterActuallySavesTheUserAndReturnsIt() {
		when(mockedUserRepo.findOneByEmail(VALID_EMAIL)).thenReturn(null);
		when(mockedUserRepo.save(mockedUser)).thenReturn(mockedUser);
		User user = userService.register(mockedUser);
		assertThat(mockedUser, equalTo(user));
		verify(mockedUserRepo, times(1)).save(mockedUser);
	}

	@Test(expected = IllegalArgumentException.class)
	public void callingRegisterWithAnUserWithAlreadyExistingEmailThrowsAnException() {
		when(mockedUserRepo.findOneByEmail(VALID_EMAIL)).thenReturn(mockedUser);
		userService.register(mockedUser);
	}
}
