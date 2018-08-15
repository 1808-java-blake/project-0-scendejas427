package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class AdminFeeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	User u=new User();
	public Screen start() {
		System.out.println("Enter username to charge: ");
		String username=scan.nextLine();
		u=ud.findByUsername(username);
		if(u!=null) {
			System.out.println("Amount to charge user: ");
			String bal =scan.nextLine();
			if(u.getBalance()-Integer.valueOf(bal)<0) {
				System.out.println("Insufficient Funds");
				scan.nextLine();
				return new AdminScreen();
				
			}
			try {
				if(Integer.valueOf(bal)>0) {
					u.setTrans("-$"+bal+" on "+LocalDateTime.now().toLocalDate()+" at "+LocalDateTime.now().toLocalTime()+" for a bank fee");
					u.setBalance(-Integer.valueOf(bal));
					ud.updateUser(u);
				}
				else {
					System.out.println("Incorrect amount please hit enter to try again");
					scan.nextLine();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid number");
			}


		}
		else {
			System.out.println("Not a valid username");
			scan.nextLine();
		} 
		
		return new AdminScreen();
	}

}
