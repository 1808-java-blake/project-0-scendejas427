package com.revature.launcher;

import com.revature.screens.HomeScreen;
import com.revature.screens.Screen;

public class Launcher {
		public static void main(String[] args) {
			Screen s = new HomeScreen();
			while(true) {
				s = s.start();
			}
		}
}
