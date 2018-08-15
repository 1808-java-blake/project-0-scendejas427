package com.revature.screens;

import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;

public class TransactionScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	CurrentUser q=new CurrentUser();
	User u=q.getCurrent();
	TitleBox t=new TitleBox();
	@Override
	public Screen start() {
		for(String each:u.getTrans().split("!")) {
			if(each.equals("null")) {
			}
			else {
				System.out.println(each);
			}
		}
		scan.nextLine();
		return new AccountScreen();
	}

}
