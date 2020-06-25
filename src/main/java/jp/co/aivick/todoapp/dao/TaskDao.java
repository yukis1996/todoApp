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

	// userIdが一致していてかつ、入力された各値と一致するものを返す
	@Select
	List<Task> findMyTask(Integer userId, String taskName, LocalDate day, Integer type);

	// taskIdが一致するものを返す
	@Select
	Task find(Integer taskId);

	// userIdが一致していてかつ、期限(今日)が一致するものを返す
	@Select
	List<Task> findDeadlineTask(Integer userId, LocalDate now);
	
	@Insert
	int create(Task task);

	// true,falseを逆にしstatusを更新する
	// タスク未完了か完了かを入れ替える
	@Update
	int update(Task task);
	
}
