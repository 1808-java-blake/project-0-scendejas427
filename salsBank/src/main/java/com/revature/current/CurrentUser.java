package com.revature.current;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class CurrentUser {
	private static User current;

	public void current(User ud) {
		CurrentUser.current=ud;
		
	}
	
	public User getCurrent() {
		return CurrentUser.current;
	}

	

}
