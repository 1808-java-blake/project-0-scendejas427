package com.revature.daos;

import com.revature.beans.User;

public interface UserDao {
	public static final UserDao currentUserDao = new UserDaoJdbc();
	
	User findByUsername(String username);
	User findByAccountNum(String num);
	void createUser(User u);
	User findByUsernameAndPassword(String username, String password);
	void updateUser(User u);
	void deleteUser(User u);
	void updateNum(int i);
	int getNum();

}
