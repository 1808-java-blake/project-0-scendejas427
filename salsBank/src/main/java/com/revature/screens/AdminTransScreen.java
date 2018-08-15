package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class AdminTransScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	User u=new User();
	public Screen start() {
		System.out.println("Enter Username: ");
		String username = scan.nextLine();
		u=ud.findByUsername(username);
		if(u!=null) {
			System.out.println("Name is: "+u.getFirstName()+" "+u.getLastName());
			System.out.println("Age is: "+u.getAge());
			System.out.println("Account number is: "+u.getAccountNum());
			System.out.println("Current balance is: "+ u.getBalance());
			System.out.println("Transaction history is below");
			for(String each:u.getTrans().split("!")) {
				if(each.equals("null")) {
				}
				else {
					System.out.println(each);
				}
			}
			scan.nextLine();
		}
		else {
			System.out.println("Not a valid username");
			scan.nextLine();
		}
		return new AdminScreen();
	}

}
