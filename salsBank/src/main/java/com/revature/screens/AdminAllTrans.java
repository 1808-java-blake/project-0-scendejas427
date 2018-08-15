package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.daos.UserDao;

public class AdminAllTrans implements Screen{
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;
	User u=new User();
	public Screen start() {
		int i=1;
		String num=""+i+"";
		u=ud.findByAccountNum(num);
		int sum=0;
			while(u!=null) {
				System.out.println("Name is: "+u.getFirstName()+" "+u.getLastName());
				System.out.println("Age is: "+u.getAge());
				System.out.println("Account number is: "+u.getAccountNum());
				System.out.println("Current balance is: "+ u.getBalance());
				System.out.println("Transaction history is below");
				sum=sum+u.getBalance();
				for(String each:u.getTrans().split("!")) {
					if(each.equals("null")) {
					}
					else {
						System.out.println(each);
					}
				}
				System.out.println();
				i++;
				num=""+i+"";
				u=ud.findByAccountNum(num);
			}
			System.out.println("there are "+(i-1)+" accounts and a total of $"+sum+" deposited in all bank accounts combine.");
		
			scan.nextLine();
		return new AdminScreen();

	}
}
