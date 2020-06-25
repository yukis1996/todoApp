package jp.co.aivick.todoapp.service;

import java.time.LocalDate;
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

	// ログインユーザーのIDと検索時に入力された値を渡す
	public List<Task> findTask(Integer userId, String taskName, LocalDate day, Integer type) {
		return taskDao.findMyTask(userId, taskName, day, type);
	}

	// onclick時のtaskIdを渡す
	public Task find(Integer taskId) {
		return this.taskDao.find(taskId);
	}
	
	// ログインユーザーのIDとLocalCate.now(今日の日付)を渡す
	public List<Task> findDeadlineTask(Integer userId, LocalDate now) {
		return this.taskDao.findDeadlineTask(userId, now);
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
