package jp.co.aivick.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.todoapp.dao.TaskDao;
import jp.co.aivick.todoapp.entity.Task;

@Service
public class TaskService {

	@Autowired
	private TaskDao taskDao;

	public List<Task> findTask(Integer userId) {
		return taskDao.findMyTask(userId);
	}

	public Task find(Integer taskId) {
		return this.taskDao.find(taskId);
	}

	@Transactional
	public Task create(Task task) {
		taskDao.create(task);
		return task;
	}

	// statusのtrue,falseを逆にする
	@Transactional
	public Task change(Task task, Boolean doLike) {
		task.setStatus(!doLike);
		this.taskDao.update(task);
		return task;
	}
}
