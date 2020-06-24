package jp.co.aivick.todoapp.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.aivick.todoapp.domain.Prioritize;
import jp.co.aivick.todoapp.entity.Task;
import jp.co.aivick.todoapp.entity.User;
import jp.co.aivick.todoapp.form.TaskForm;
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

	@PostMapping("/complete")
	@ResponseBody
	public Boolean complete(@RequestParam Integer taskId) {
		var task = new Task();
		task = taskService.find(taskId);
		taskService.chenge(task, true);
		return true;
	}

	@PostMapping("/incomplete")
	@ResponseBody
	public Boolean inComplete(@RequestParam Integer taskId) {
		var task = new Task();
		task = taskService.find(taskId);
		taskService.chenge(task, false);
		return false;
	}

	@GetMapping("/create")
	public String taskCreateForm(Model model, TaskForm taskForm) {
		model.addAttribute("taskForm", new TaskForm());
		return "tasks/create.html";
	}

	@PostMapping("/create")
	public String create(@AuthenticationPrincipal UserDetails userDetails, @Validated TaskForm taskForm,
			BindingResult bindingResult ) {
		if (bindingResult.hasErrors()) {
			return "tasks/create.html";
		}

		Task task = new Task();
		User user = userService.findId(userDetails.getUsername());
		task.setTaskName(taskForm.getTaskName());
		LocalDate date = LocalDate.parse(taskForm.getDay());
		LocalDate now = LocalDate.now();
		Boolean unFinished = true;
		if (afterAndEquals(date, now)) {
			task.setDay(date);
		} else {
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "error.message", "今日以降の日付を入力してください"));
			return "tasks/create.html";
		}

		task.setType(Prioritize.valueOf(taskForm.getType()));
		task.setStatus(unFinished);
		task.setUserId(user.getUserId());
		taskService.create(task);
		return "redirect:/tasks/create";
	}

	public static boolean afterAndEquals(LocalDate date, LocalDate now) {

		return date.isAfter(now) || date.equals(now);
	}
}
