package jp.co.aivick.todoapp.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import jp.co.aivick.todoapp.entity.User;

@ConfigAutowireable
@Dao
public interface UserDao {

	@Select
	User findId(String loginId);

	@Insert
	int insert(User user);

}
