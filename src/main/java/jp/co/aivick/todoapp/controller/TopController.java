package jp.co.aivick.todoapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.todoapp.entity.User;
import jp.co.aivick.todoapp.service.TaskService;
import jp.co.aivick.todoapp.service.UserService;

@Controller
@RequestMapping("/top")
public class TopController {

	@Autowired
	TaskService taskService;
	
	@Autowired
	UserService userService;

	@RequestMapping
	public String show(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		User user = userService.findId(userDetails.getUsername());
		LocalDate now = LocalDate.now();
		model.addAttribute("user", user);
		model.addAttribute("todayList", taskService.todayTask(user.getUserId(), now));
		return "top.html";
	}
}
