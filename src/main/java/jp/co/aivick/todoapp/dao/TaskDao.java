package jp.co.aivick.todoapp.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.todoapp.entity.Task;

@ConfigAutowireable
@Dao
public interface TaskDao {

	@Select
	List<Task> findMyTask(Integer userId);

	@Insert
	int create(Task task);
}
