package com.revature.screens;

import java.util.Scanner;

public class AccountScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	public Screen start() {
		TitleBox t =new TitleBox();
		t.makeTitle("Welcome to Sals Bank!to Deposit money into your account!to Withdraw money into your account!to View balance!to view transaction history!to wire money to another account!to logout");
		
		
		//above screen
//		String wait="ooooooooooooooo";
//		String wait1="";
//		Diamonds here=new Diamonds();
//		here.make(0,60);
//		
//		//screen
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1 +"___________________________________________________________"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1 +"|_|______________________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|              Welcome to Your bank account            |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|______________________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|Enter 1|            to Deposit money in account       |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|_______|______________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|Enter 2|         to Withdraw money from account       |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|_______|______________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|Enter 3|                  to View balance             |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|_______|______________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|Enter 4|         to View transaction history          |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|_______|______________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|Enter 5|                  to logout                   |_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		System.out.println(wait1+wait+wait+wait1+wait1+wait+wait+wait1+"|_|_______|______________________________________________|_|"+wait1+wait+wait+wait1+wait1+wait+wait+wait1+wait1+wait);
//		wait1=wait1+" ";
//		wait=wait.replaceFirst("o", "");
//		
//		//under screen
//		here.make(74,90);

		String selection = scan.nextLine();
		switch (selection) {
		case "1":
			return new DepositScreen();
		case "2":
			return new WithdrawScreen();
		case "3":
			return new BalanceScreen();
		case "4":
			return new TransactionScreen();
		case "5":

			return new WireScreen();
		case "6":

			return new HomeScreen();
		default:
			break;
		}
		return this;
	}


}
