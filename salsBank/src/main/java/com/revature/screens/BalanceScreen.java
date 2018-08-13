package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class BalanceScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	CurrentUser q=new CurrentUser();
	User u=q.getCurrent();
	@Override
	public Screen start() {
		System.out.println("$"+u.getBalance());
		scan.nextLine();
		return new AccountScreen();
	}

}
