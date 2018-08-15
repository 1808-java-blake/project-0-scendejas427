package com.revature.screens;

import java.util.Scanner;

public class AccountScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	public Screen start() {
		TitleBox t =new TitleBox();
		t.makeTitle("Welcome to Sals Bank!to Deposit money into your account!to Withdraw money into your account!to View balance!to view transaction history!to wire money to another account!to logout");
		

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
