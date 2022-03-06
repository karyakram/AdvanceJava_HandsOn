package com.org.gen.day11;
import com.org.jdbc.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
	static Scanner sc = new Scanner(System.in);
	static int acc_no=0,bal=0;
	static String acc_name = null;
	

	public static void main(String[] args) {
		try{
			Connection con = DataConnection.getConnection();
			System.out.println("Enter your name : ");
			String name = sc.nextLine();
			System.out.println("Enter your account no : ");
			int acc = sc.nextInt();
			System.out.println("Entered details are:"+name +"  "+acc);
			
			PreparedStatement pr = con.prepareStatement("select * from bank where Acc_No=? and Customer_Name=?");
			pr.setString(2, name);
			pr.setInt(1, acc);
			System.out.println(pr);
			
			ResultSet rs = pr.executeQuery();
			rs.next();
			acc_no= rs.getInt(1);
			acc_name=rs.getString(2);
			bal=rs.getInt(3);
			System.out.println(acc_no+" "+ acc_name);
			if(acc==acc_no) {
				int ch=0;
				while(ch!=4) {
					pr.setInt(1, acc);
					rs = pr.executeQuery();
					rs.next();
					acc_no= rs.getInt(1);
					acc_name=rs.getString(2);
					bal=rs.getInt(3);
				
				System.out.println("Select the service you require : ");
				System.out.println("Press 1 to check balance:");
				System.out.println("Press 2 to deposit:");
				System.out.println("Press 3 to withdraw:");
				System.out.println("Press 4 to exit:");
				ch= sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("Available balance: "+bal);
					break;
				case 2:
					PreparedStatement pr1=con.prepareStatement("update bank set AVL_Balance =? where Acc_No=? ");
					System.out.println("Enter amount to deposit :");
					int balc=sc.nextInt();
					pr1.setInt(1, bal+balc);
					pr1.setInt(2, acc_no);
					pr1.executeUpdate();
					System.out.println("Deposited");
					break;
				case 3:
					if(bal>10000) {
						int d=Withdraw(rs);
						if(d>0) {
							rs=pr.executeQuery();
							rs.next();
							System.out.println("Updated Balance:"+rs.getInt(3));
						}
					}
					else {
						System.out.println("Available balance is too low to withdraw money");
					}
					break;
				default:
					System.out.println("Incorrect option. Please Try Again!!");
					break;
				}
				}
			}
			else {
				System.out.println("you are not registered in bank database");
			}
			sc.close();
			con.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	private static int Withdraw(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Enter amount to withdraw :");
		int withdraw=sc.nextInt();
		int data=0;
		if(withdraw>=bal){
			System.out.println("Available balance is too low to withdraw");
			
		}
		else {
			PreparedStatement pr2 =DataConnection.getConnection().prepareStatement("update bank set AVL_Balance =? where Acc_No=?");
			pr2.setInt(1, bal-withdraw);
			pr2.setInt(2, acc_no);
			data =pr2.executeUpdate();
			System.out.println("executed:"+data);
			}
		return data;
		
		
	}


	}