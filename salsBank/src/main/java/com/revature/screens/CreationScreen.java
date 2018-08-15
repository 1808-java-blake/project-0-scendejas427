package com.revature.screens;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.revature.beans.User;
import com.revature.current.CurrentUser;
import com.revature.daos.UserDao;

public class CreationScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private UserDao ud = UserDao.currentUserDao;


	
	public Screen start() {
		User u = new User();
		System.out.println("Enter new username");
		String username=scan.nextLine();
		if(ud.findByUsername(username)!=null ||username.equals("admin")){
			System.out.println(username+" is already taken. Please try another username");
			return this;
		}
		u.setUsername(username);
		
		System.out.println("Enter password");
		u.setPassword(scan.nextLine());
		System.out.println("Enter first name");
		u.setFirstName(scan.nextLine());
		System.out.println("Enter last name");
		u.setLastName(scan.nextLine());
		System.out.println("Enter age");
		String age = scan.nextLine();
		u.setTrans("New account created on " +LocalDateTime.now().toLocalDate()+" at "+LocalDateTime.now().toLocalTime());
		u.setBalance(0);
		ud.updateNum(ud.getNum()+1);
		u.setAccountNum(ud.getNum());
		try {
			u.setAge(Integer.valueOf(age));
			ud.createUser(u);
			
		} catch (NumberFormatException e) {
			System.out.println("Invalid number");
			return new HomeScreen();
		}
		
		
		return new LoginScreen();
		
		
		
		
		
	}

}
