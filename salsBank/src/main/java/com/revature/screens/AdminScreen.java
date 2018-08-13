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
		t.makeTitle("Welcome to your bank!to search account information by username!to charge a fee by username!to log out");
		//above screen
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
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|                      Welcome to your bank            |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|______________________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 1|  to search account information by username   |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//	
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 2|  to charge a fee to an account by username   |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//			wait=wait+" ";
//		wait1=wait1.replaceFirst("o", "");
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|Enter 3|                 to log out                   |_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		System.out.println(wait+wait1+wait1+wait+wait+wait1+wait1+wait+"|_|_______|______________________________________________|_|"+wait+wait1+wait1+wait+wait+wait1+wait1+wait+wait+wait1);
//		wait1=wait1+"o";
//		wait=wait.replaceFirst(" ", "");
//		
//		//under screen
//		here.make(78, 90);
 
		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			System.out.println("Enter Username: ");
			String username = scan.nextLine();
			u=ud.findByUsername(username);
			System.out.println("Name is: "+u.getFirstName()+" "+u.getLastName());
			System.out.println("Age is: "+u.getAge());
			System.out.println("Current balance is: "+ u.getBalance());
			System.out.println("Transaction history is below");
			for(String each:u.getTrans().split("!")) {
				if(each.equals("null")) {
					System.out.println("new account");
				}
				else {
					System.out.println(each);
				}
			}
			scan.nextLine();
			return new AdminScreen();
		case "2":
			System.out.println("Enter username to charge: ");
			username=scan.nextLine();
			u=ud.findByUsername(username);
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



			
			return new AdminScreen();
			

		case "3":
 
			return new HomeScreen();
		default:
			break;
		}
		return this;
	}


}
