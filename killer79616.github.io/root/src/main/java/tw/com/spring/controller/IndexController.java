package tw.com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping(value = { "", "/", "/index" })
	public String getIndex() {
		return "index";
	}

	@GetMapping("/product")
	public String getProduct() {
		return "product";
	}
	

}
