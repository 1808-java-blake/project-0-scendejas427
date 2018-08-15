package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class AdminScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	User u=new User();
	
	public Screen start() {
		TitleBox t =new TitleBox();
		t.makeTitle("Welcome to your bank!to search account information by username!search account information by account number!to see all bank information!to charge a fee by username!to log out");
		
 
		String selection = scan.nextLine();
		switch (selection) {
		case "1":

			return new AdminTransScreen();
		case "2":

			
			return new AdminTransScreen1();
		case "3":

			
			return new AdminAllTrans();
		case "4":

			
			return new AdminFeeScreen();
			

		case "5":
 
			return new HomeScreen();
		default:
			break;
		}
		return this;
	}


}
