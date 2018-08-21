package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDaoJdbc implements UserDao {
	private ConnectionUtil cu = ConnectionUtil.cu;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void createUser(User u) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO account (user_name, pass, firstname, lastname, age, bal, trans) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setInt(5, u.getAge());
			ps.setInt(6, u.getBalance());
			ps.setString(7, u.getTrans());
			int recordsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			}

	

	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		try (Connection conn = cu.getConnection()) {
			// don't do this
//			Statement s = conn.createStatement();
//			ResultSet rs = s.executeQuery("SELECT * FROM app_users WHERE username='" + 
//							username + "' AND pass='" + password + "'");
			
			// do this
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM account WHERE user_name=? and pass=?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				User u = new User();
				u.setAge(rs.getInt("age"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("user_name"));
				u.setBalance(rs.getInt("bal"));
				u.setTrans(rs.getString("trans"));
				u.setAccountNum(rs.getInt("accountnum"));
				return u;
			} else {
				
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User u) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"UPDATE account SET bal=? , trans=? WHERE user_name=?" );
			ps.setInt(1, u.getBalance());
			ps.setString(2, u.getTrans());
			ps.setString(3, u.getUsername());
			int recordsCreated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			}

	
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByUsername(String username) {
		try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM account WHERE user_name=? ");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				User u = new User();
				u.setAge(rs.getInt("age"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("user_name"));
				u.setBalance(rs.getInt("bal"));
				u.setTrans(rs.getString("trans"));
				u.setAccountNum(rs.getInt("accountnum"));
				return u;
			} else {
				
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User findByAccountNum(String num) {
try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM account WHERE accountnum=? ");
			ps.setInt(1, Integer.valueOf(num));
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {
				User u = new User();
				u.setAge(rs.getInt("age"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setUsername(rs.getString("user_name"));
				u.setBalance(rs.getInt("bal"));
				u.setTrans(rs.getString("trans"));
				u.setAccountNum(rs.getInt("accountnum"));
				return u;
			} else {
				
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateNum(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getNum() {
try (Connection conn = cu.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM account WHERE accountnum=MAX(accountnum ");
			ResultSet rs = ps.executeQuery();
					
			if(rs.next()) {

				return rs.getInt("accountnum");
			} else {
				
				return 0;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				return 0;
	}

}
