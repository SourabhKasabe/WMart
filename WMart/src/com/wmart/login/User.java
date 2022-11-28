package com.wmart.login;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.wmart.product.Product;

public class User {	

	public void Login() throws Exception
	{
		User user = new User();
		Product pro = new Product();
		Scanner scan = new Scanner(System.in); 
		System.out.println("Enter your UserName");
		String UName= scan.next();
		System.out.println("Enter your Password");
		String Pass = scan.next();		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		Statement st = conn.createStatement();	
		
		String sql ="Select * from wmart.user_log where UserName='"+UName+"' and Password='"+Pass+"'" ;
		PreparedStatement ps;
		
		ps=conn.prepareStatement(UName);
		ps=conn.prepareStatement(Pass);	
		ResultSet rs=st.executeQuery(sql);  
		
		if(rs.next())
		{
			
			System.out.println("Your Login is sucessful:  "+UName);	
			pro.AddCart();
			System.out.println("========================");	
			
		}			
		else 
		{
			System.out.println("Your Login is fail");
			user.Login();
		}	
		
		
		rs.close();	
		conn.close();
		
	   ps.close();
		st.close();
	
		
	}
	
	public void Register() throws Exception{
		Scanner scan = new Scanner(System.in); 		

			System.out.println("Enter You UserName");
			String UserName= scan.next();
			System.out.println("Enter your Password");
			String Password=scan.next();
			System.out.println("Enter Your Email");
			String email=scan.next();
			System.out.println("Enter your MobileNo");
			String MobileNo=scan.next();			
			
			Class.forName("com.mysql.jdbc.Driver");
					
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");			
			PreparedStatement ps = conn.prepareStatement("insert into user_log(UserName,Password,email,MobileNo) value(?,?,?,?)");
             			
			ps.setString(1, UserName);
			ps.setString(2, Password);
			ps.setString(3, email);
			ps.setString(4, MobileNo);
			int no = ps.executeUpdate();
			System.out.println("record is inserted : "+no);
			conn.close();
			ps.close();

	}
	
	public void UserDetails() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		Statement st = conn.createStatement();
		
		ResultSet rs=st.executeQuery("Select * from user_log");
		System.out.println("Here is user Details: "+rs);
		while(rs.next())
		{
			System.out.println(rs.getString("id")+" : "+rs.getString("UserName")+" : "+rs.getString("Password")+" : "+rs.getString("email")+" : "+rs.getString("MobileNo")) ;
			
		}
		
		rs.close();
		conn.close();
		st.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
