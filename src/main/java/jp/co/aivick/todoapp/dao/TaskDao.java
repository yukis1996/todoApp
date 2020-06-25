package jp.co.aivick.todoapp.dao;

import java.time.LocalDate;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.todoapp.entity.Task;

@ConfigAutowireable
@Dao
public interface TaskDao {

	@Select
	List<Task> findMyTask(Integer userId, String taskName, LocalDate day, Integer type);

	@Select
	Task find(Integer taskId);

	@Select
	List<Task> todayTask(Integer userId, LocalDate now);
	
	@Insert
	int create(Task task);

	// true,falseを逆にしstatusを更新する
	// タスク未完了か完了かを入れ替える
	@Update
	int update(Task task);
	
}
