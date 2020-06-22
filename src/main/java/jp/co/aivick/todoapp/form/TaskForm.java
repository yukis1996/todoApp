package jp.co.aivick.todoapp.form;

import javax.validation.constraints.NotEmpty;

import jp.co.aivick.todoapp.domain.Prioritize;

public class TaskForm {

	private Integer taskId;

	@NotEmpty
	private String taskName;

	@NotEmpty
	private String day;

	private Integer type;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Prioritize[] getPrioritizes() {
		return Prioritize.values();
	}

}
