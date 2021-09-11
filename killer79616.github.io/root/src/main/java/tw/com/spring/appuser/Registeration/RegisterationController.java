package tw.com.spring.appuser.Registeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tw.com.spring.user.User;
import tw.com.spring.user.UserService;

@Controller
public class RegisterationController {
	@Autowired
	private UserService userService;

	@GetMapping("/registeration")
	public String getRegisteration(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/registerUser")
	public String saveEmployee(User user) {
		userService.registeUser(user);
		return "redirect:/";
	}

	@GetMapping("/admin")
	public String getAllUser(Model model) {
			model.addAttribute("user", userService.getAllUser());
		
		return "admin";
	}
	
	@GetMapping("/login")
	public String getLoginView() {
		return "login";
	}
	
//	@GetMapping("/admin/admindelete/{id}")
//	public String deleteUserById(@PathVariable(value = "id") Long Id) {
//		userService.deleteUser(Id);
//		return "redirect:/admin";
//	}
	
	@GetMapping("/admin/admindelete/{id}")
	public String deleteUserByEmail(@PathVariable(name = "id") String email) {
		userService.deleteUserByEmail(email);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/adminupdate/{id}")
	public String showUserUpdate(@PathVariable(name = "id")String email, Model model) {
		User user = userService.findByEmail(email);
		model.addAttribute("user", user);
		
		return "adminupdate";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/admin";
	}

}
