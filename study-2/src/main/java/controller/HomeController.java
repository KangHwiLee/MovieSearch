package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String test() {
		return "index";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
}
