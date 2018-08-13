package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class DepositScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	CurrentUser q=new CurrentUser();
	private UserDao ud = UserDao.currentUserDao;
	User u=q.getCurrent();
	
	public Screen start() {
		System.out.println("how much would you like to deposit?");
		String bal=scan.nextLine();
		try {
			if(Integer.valueOf(bal)>0) {
				u.setTrans("$"+bal+" on "+LocalDateTime.now().toLocalDate()+" at "+LocalDateTime.now().toLocalTime());
				u.setBalance(Integer.valueOf(bal));
				ud.updateUser(u);
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

