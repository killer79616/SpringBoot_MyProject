package tw.com.spring.user;

import static tw.com.spring.auth.UserRole.USER;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public void registeUser(User user) {
		User userExists = userRepository.findByEmail(user.getEmail());
		boolean passwordInput = user.getPassword().isBlank();
		boolean emailInput = user.getEmail().isBlank();

		if (userExists != null) {
			throw new IllegalStateException("email already taken");
		} else if (passwordInput) {
			throw new IllegalStateException("password cannot be null");
		} else if (emailInput) {
			throw new IllegalStateException("email cannot be null");
		}

		String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());

		user.setPassword(encodePassword);
		user.setUserRole(USER);

		this.userRepository.save(user);
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserByEmail(String email) {
		userRepository.deleteUserByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}
}
