package com.revature.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.revature.beans.User;

public class UserSerializer implements UserDao {

	

	@Override
	public void createUser(User u) {
		if (u == null) {
			return;
		}
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
		File f1 = new File("src/main/resources/users/" + u.getAccountNum() + ".txt");
		System.out.println(f.getName());
		if (f.exists()) {
			return;
		}
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		if (f1.exists()) {
			return;
		}
		try {
			f1.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getAccountNum() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public User findByUsername(String username) {
		// verify that what was passed in is not null
		if (username == null ) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			User u = (User) ois.readObject(); // retrieve the user if it can
			// verify that the password matches

				return u;


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// verify that what was passed in is not null
		if (username == null || password == null) {
			return null;
		}
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + username + ".txt"))) {

			User u = (User) ois.readObject(); // retrieve the user if it can
			// verify that the password matches
			if (password.equals(u.getPassword())) {
				return u;
			} else {
				return null;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User u) {
		File f = new File("src/main/resources/users/" + u.getUsername() + ".txt");
		File f1 = new File("src/main/resources/users/" + u.getAccountNum() + ".txt");
		System.out.println(f.getName());
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getUsername() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			f1.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + u.getAccountNum() + ".txt"))) {

			oos.writeObject(u);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}
	@Override
	public User findByAccountNum(String num) {
		// verify that what was passed in is not null
				if (num == null ) {
					return null;
				}
				try (ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream("src/main/resources/users/" + num + ".txt"))) {

					User u = (User) ois.readObject(); // retrieve the user if it can
					// verify that the password matches

						return u;


				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}		return null;
	}
	@Override
	public void updateNum(int i) {
		File f = new File("src/main/resources/users/" + "!!!!" + ".txt");
		System.out.println(f.getName());
		try {
			f.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream("src/main/resources/users/" + "!!!!" + ".txt"))) {

			oos.writeObject(i);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public int getNum() {
		// verify that what was passed in is not null
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream("src/main/resources/users/" + "!!!!" + ".txt"))) {

			int u = (int) ois.readObject(); // retrieve the user if it can
			// verify that the password matches

				return u;


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}		return 0;
	}

}
