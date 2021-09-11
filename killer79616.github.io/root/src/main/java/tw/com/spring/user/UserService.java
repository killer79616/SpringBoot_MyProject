package tw.com.spring.user;

import java.util.List;

public interface UserService {
	
	User findByEmail(String email);

	void registeUser(User user);
	
	void deleteUser(Long id);
	
	void deleteUserByEmail(String email);
	
	List<User> getAllUser();
	
	void saveUser(User user);
}
