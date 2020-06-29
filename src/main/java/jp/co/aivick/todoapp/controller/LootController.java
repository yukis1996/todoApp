package jp.co.aivick.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LootController {

	@RequestMapping
	public String showLoginForm() {
		return "/login";
	}
}