package jp.co.aivick.todoapp.form;

import java.time.LocalDate;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jp.co.aivick.todoapp.domain.Prioritize;

public class TaskForm {

	private Integer taskId;

	@NotEmpty
	private String taskName;

	@NotNull
	@DateTimeFormat(pattern = "[yyyy-MM-dd]")
	@FutureOrPresent
	private LocalDate day;

	private Integer type;

	private String memo;

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

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Prioritize[] getPrioritizes() {
		return Prioritize.values();
	}

}
