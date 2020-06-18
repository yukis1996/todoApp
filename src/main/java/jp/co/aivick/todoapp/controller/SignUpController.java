package jp.co.aivick.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.todoapp.entity.User;
import jp.co.aivick.todoapp.form.UserForm;
import jp.co.aivick.todoapp.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignUpController {

	@Autowired
	UserService userService;

	@GetMapping
	public String showSignup(Model model) {
		model.addAttribute("userForm", new UserForm());
		return "signup/index";
	}

	@PostMapping
	public String register(@Validated UserForm userForm, BindingResult buindingResult) {
		if (buindingResult.hasErrors()) {
			return "signup/index";
		}

		User user = new User();
		user.setPassword(userForm.getPassword());
		user.setLoginId(userForm.getLoginId());
		user.setNickname(userForm.getNickname());
		user.setEmail(userForm.getEmail());
		user.setJob(userForm.getJob());
        user.setRole("USER");
		userService.create(user);

		return "redirect:/login";
	}
}
