package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class HomeScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	CurrentUser q=new CurrentUser();
	
	public Screen start() {

		Diamonds here=new Diamonds();
		TitleBox t=new TitleBox();
		t.makeTitle("Welcome to Sals Bank!to login to existing account!to create a new account!to logout");
//		Diamonds here=new Diamonds();
//		here.make(0,68);
//		
//		//screen
//		String wait="        ";
//		String wait1="ooooooo";
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait +"____________________________________________________________"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait +"|_|______________________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|                      Welcome to Sals bank            |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|______________________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 1|            to login into an existing account |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//	
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 2|                to create a new account       |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//			wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 3|              to contact a custumer service   |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		//under screen
//		here.make(78, 90);
		
		//waiting for command
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return new LoginScreen();
		

		case "2":

			return new CreationScreen();
		case "3":
			int time=0;
			String custSer="0";
			while(!custSer.equals("1")) {
				time=time+5;
				System.out.println("Your expected wait time is "+ time+ " minutes.");
				System.out.println("Please hold. Enter 1 to hang up. Enter any else to calculate hold time.");
				custSer=scan.nextLine();
				here.make(0, 90);
				
			}
	
			break;
		default:
			break;
		}
		return this;
	}


}
