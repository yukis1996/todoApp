package jp.co.aivick.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/top")
public class TopController {
	
	@RequestMapping
	public String show() {
		return "top";
	}
}
