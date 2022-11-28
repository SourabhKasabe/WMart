package com.wmart.login;

import java.sql.*;
import java.util.Scanner;
import com.wmart.product.Product;

public class Admin {
	
	Scanner scan = new Scanner(System.in); 
	
	public void Login() throws Exception{		
		Admin admin = new Admin();
		Product pc = new Product();
		User us = new User();
		System.out.println("==========================");
		System.out.println("Enter your UserName");
		String UName= scan.next();
		System.out.println("Enter your Password");
		String Pass = scan.next();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		Statement st = conn.createStatement();
		String sql ="Select * from wmart.admin_log where UserName='"+UName+"' and Password='"+Pass+"'";
		PreparedStatement ps;
		ps=conn.prepareStatement(UName);
		ps=conn.prepareStatement(Pass);
		ResultSet rs=ps.executeQuery(sql);
		
		if(rs.next())
		{
			System.out.println("==========================");
			System.out.println("Your Login is sucessful");
			
		}
		else 
		{
			System.out.println("==========================");
			System.out.println("Your Login is fail");
			admin.Login();
		}
		rs.close();	
		conn.close();
		st.close();
	}
	
	
	public void Register()throws Exception
	{
		System.out.println("==========================");
	   	System.out.println("Enter your UserName");
		String UserName=scan.next();
		System.out.println("Enter your Password");
		String Password=scan.next();
		System.out.println("Enter Your Email");
		String email=scan.next();
		System.out.println("Enter your MobileNo");
		String MobileNo=scan.next();
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into admin_log(UserName,Password,email,MobileNo) value(?,?,?,?)");
	
		ps.setString(1,UserName);
		ps.setString(2,Password);
		ps.setString(3, email);
		ps.setString(4, MobileNo);			
				
		int no = ps.executeUpdate();
		System.out.println("record is inserted : "+no);
		
		conn.close();
		ps.close();
	}

	
}
