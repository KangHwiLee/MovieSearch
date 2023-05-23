package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/guest/movies")
	public String movies() {
		return "test";
	}
	
	@GetMapping("/guest/file-manage")
	public String file_manage() {
		return "file-manage";
	}
	
	@GetMapping("/login")
	public String test() {
		return "index";
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@GetMapping("/test")
	public String permit() {
		return "test";
	}
	@GetMapping("/guest/pay")
	public String pay() {
		return "pay";
	}
}
