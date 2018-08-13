package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class LoginScreen implements Screen {
	private Scanner scan=new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	CurrentUser q=new CurrentUser();
	
	@Override
	public Screen start() {
		
		Diamonds here=new Diamonds();
		here.make(0,30);
		System.out.println("Bank Account Login");
		System.out.println("Enter Username: ");
		String username = scan.nextLine();
		if(username.equals("admin")){
			System.out.println("Enter Password: ");
			String password = scan.nextLine();
			if(password.equals("pass")) {
				return new AdminScreen();
			}
			else {
				System.out.println("Incorret Credentials");
				scan.nextLine();
				return new HomeScreen();
			}
		}

		System.out.println("Enter Password: ");
		String password = scan.nextLine();

		User currentUser = ud.findByUsernameAndPassword(username, password);
		if (currentUser != null) {
			q.current(currentUser);
			return new AccountScreen();
		}

		System.out.println("unable to login");
		scan.nextLine();
		return new HomeScreen();
	}

}
