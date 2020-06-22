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

	@Transactional
	public Task create(Task task) {
		taskDao.create(task);
		return task;
	}
}
