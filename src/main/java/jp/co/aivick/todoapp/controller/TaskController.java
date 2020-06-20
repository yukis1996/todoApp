package jp.co.aivick.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.aivick.todoapp.entity.User;
import jp.co.aivick.todoapp.service.TaskService;
import jp.co.aivick.todoapp.service.UserService;

@Controller
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskService taskService;

	@Autowired
	UserService userService;

	@GetMapping("list")
	public String list(@AuthenticationPrincipal UserDetails userDetails, Model model) {
		User user = userService.findId(userDetails.getUsername());
		model.addAttribute("taskList", taskService.findTask(user.getUserId()));
		model.addAttribute("user", user);
		return "tasks/list.html";
	}
}
