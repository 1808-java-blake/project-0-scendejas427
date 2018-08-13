package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class WireScreen implements Screen{
	private Scanner scan = new Scanner(System.in);
	CurrentUser q=new CurrentUser();
	private UserDao ud = UserDao.currentUserDao;
	User u=q.getCurrent();
	@Override
	public Screen start() {
		System.out.println("Enter username to wire: ");
		String username=scan.nextLine();
		User u1=ud.findByUsername(username);
		System.out.println("Amount to wire user: ");
		String bal =scan.nextLine();
		if(u.getBalance()-Integer.valueOf(bal)<0) {
			System.out.println("Insufficient Funds");
			scan.nextLine();
			return new AccountScreen();
			
		}
		try {
			if(Integer.valueOf(bal)>0) {
				u.setTrans("-$"+bal+" on "+LocalDateTime.now().toLocalDate()+" at "+LocalDateTime.now().toLocalTime()+" wired to "+ u1.getFirstName()+" "+u1.getLastName());
				u.setBalance(-Integer.valueOf(bal));
				ud.updateUser(u);
				u1.setTrans("$"+bal+" on "+LocalDateTime.now().toLocalDate()+" at "+LocalDateTime.now().toLocalTime()+" wired from "+ u.getFirstName()+" "+u.getLastName());
				u1.setBalance(Integer.valueOf(bal));
				ud.updateUser(u1);
			}
			else {
				System.out.println("Incorrect amount please hit enter to try again");
				scan.nextLine();
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
		}



		
		return new AccountScreen();
	}

}
