package jp.co.aivick.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.aivick.todoapp.dao.UserDao;
import jp.co.aivick.todoapp.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public User create(User user) {
		User newUser = new User();
		newUser.setLoginId(user.getLoginId());
		newUser.setNickname(user.getNickname());
		newUser.setEmail(user.getEmail());
		newUser.setJob(user.getJob());
		newUser.setRole(user.getRole());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.insert(newUser);
		return user;
	}
}
