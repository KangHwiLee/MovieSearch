package controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import user.UserService;

@Controller
public class UserController {
	
	@GetMapping("/mypage")
	public String myPage() {
		return "user/mypage";
	}
	
	@GetMapping("/users")
	public String createUser() {
		return "user/login/register";
	}
	
}