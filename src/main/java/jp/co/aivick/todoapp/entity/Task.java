package jp.co.aivick.todoapp.entity;

import java.time.LocalDate;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

import jp.co.aivick.todoapp.domain.Prioritize;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Integer taskId;

	@Column(name = "task_name")
	private String taskName;

	@Column(name = "day")
	private LocalDate day;

	@Column(name = "prioritize")
	private Prioritize type;

	@Column(name = "status")
	private Integer status;

	@Column(name = "user_id")
	private Integer userId;

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

//	public Integer getPrioritize() {
//		return prioritize;
//	}
//
//	public void setPrioritize(Integer prioritize) {
//		this.prioritize = prioritize;
//	}

	// 要らない可能性が高いですが後学の比較のため一旦置いています

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Prioritize getType() {
		return type;
	}

	public void setType(Prioritize type) {
		this.type = type;
	}

}
