package com.revature.daos;

import com.revature.beans.User;

public interface UserDao {
	public static final UserDao currentUserDao = new UserSerializer();
	
	User findByUsername(String username);
	void createUser(User u);
	User findByUsernameAndPassword(String username, String password);
	void updateUser(User u);
	void deleteUser(User u);

}
