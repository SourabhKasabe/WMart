package com.wmart.product;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

import com.wmart.login.Admin;
import com.wmart.login.User;

public class Product {
	Scanner scan = new Scanner(System.in);
	
	public void ProductDetails() throws Exception
	{
		Product pro = new Product();
		Admin ad = new Admin();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		Statement st = conn.createStatement();
		
		ResultSet rs=st.executeQuery("Select * from Product");
		System.out.println("=========================================================");
		System.out.println("Here is Product : Product Id , Price, Discription ");
		while(rs.next())
		{
			System.out.println(rs.getString("Product_id")+"  : "+rs.getString("name")+" : "+rs.getString("price")+" : "+rs.getString("description")+" : "+rs.getString("Qauntity")) ;
			
		}		
		rs.close();
		conn.close();
		st.close();
	}
	
	
	public void AddCart() throws Exception
	{		
		Product pro = new Product();
		Admin ad = new Admin();
		pro.ProductDetails();
		while(true) {
			System.out.println("=========================================================");
			System.out.println("Press 0 for LogOut == Press 1 for add == Press 2 for remove == show cart for 3");
			int i = scan.nextInt();
			if(i==0)
			{
				break;
			}
			switch(i)
			{
			case 1:
				pro.add();
			case 2:
				pro.Remove();
			case 3:
				pro.showcart();
			
		     }
		
		
	   }
	}
	
	
	
	public void add() throws Exception
	{   User us =new User();
		Product pr=new Product();
		System.out.println("==========================");
		System.out.println("Enter your ProductId");
		String productId= scan.next();	
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		Statement st = conn.createStatement();
		
		ResultSet rs;		
		PreparedStatement ps ;		
		ps=conn.prepareStatement("Insert into cart(Name,Price,Qauntity,TotalPrice)value(?,?,?,?)");	
		rs=st.executeQuery("select * from product where Product_Id='"+productId+"'");
		
		
		String userdata="";
		System.out.println("Enter quantity :");
		int pquant= scan.nextInt();
	     
		while(rs.next())	
		{	
			int result=rs.getInt(5);   //  cart Block 3		
			pquant=pquant*result;      
			
			int amount = rs.getInt(3);
			
			int totalAmount=rs.getInt(3);                          //cart block 4
			totalAmount= amount*pquant;                            //cart block 4
			System.out.println("Total Amount is :" +totalAmount);  //cart Block 4
			
			userdata=rs.getString(2);       //cart block 1
			ps.setString(1, userdata);      //cart block 1
			System.out.println(userdata);   //cart block 1
			
			 amount = rs.getInt(3);        //cart block 2
			 ps.setInt(2, amount);        // cart block 2
			 System.out.println(amount);  // cart block 2
			 
			     
			 ps.setInt(3, pquant);         //  cart Block 3
 			 System.out.println(pquant);  //   cart Block 3
		    
		     ps.setInt(4, totalAmount);    //cart Block 4
		    
		    ps.executeUpdate();
		    pr.AddCart();
		}
				
		rs.close();
		conn.close();		
		st.close();
		ps.close();
		
	}
	
			
		

	public void Remove() throws Exception
	{
	
		Product pro = new Product();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		ResultSet rs;
		PreparedStatement ps=conn.prepareStatement(" ");
		Statement st = conn.createStatement();
		rs=st.executeQuery("select * from cart");
		  
		
		while(rs.next()) {
			System.out.println(rs.getString("id")+" : "+rs.getString("Name")+" : "+rs.getString("Price")+" : "+rs.getString("Qauntity")+" : "+rs.getString("TotalPrice"));
		}	
			
			 System.out.println("==========================");
			 System.out.println("Enter your Remove Product id");
			 String id= scan.next();			
			 ps=conn.prepareStatement("delete from cart where id='"+id+"'");	
			 int i =ps.executeUpdate();
			 System.out.println("Element Is Removed"+i);
			
		pro.AddCart();
		
		rs.close();
		conn.close();
		st.close();
		ps.close();
		
	}
	
	public void showcart() throws Exception
	{
		Product pro = new Product();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");	
		ResultSet rs ;
		Statement st = conn.createStatement();
		//PreparedStatement ps;
		rs=st.executeQuery("select * from cart") ;
		while(rs.next())
		{
			System.out.println(rs.getString("id")+" : "+rs.getString("Name")+" : "+rs.getString("Price")+" : "+rs.getString("Qauntity")+" : "+rs.getString("TotalPrice"));
		}
	
		pro.AddCart();
	    rs.close();
		conn.close();
		st.close();
		
	
	}	
	
	
	public void AddProduct() throws Exception {
		System.out.println("==========================");
	   	System.out.println("Enter Product Name");
		String Name=scan.next();
		System.out.println("Enter Product Price");
		String Price=scan.next();
		System.out.println("Enter Product Description");
		String Description=scan.next();
		System.out.println("Enter Product Qauntity");
		String Qauntity=scan.next();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wmart", "root", "root");
		PreparedStatement ps = conn.prepareStatement("insert into product(Name,Price,Description,Qauntity) value(?,?,?,?)");
		
			ps.setString(1, Name);
			ps.setString(2, Price);
			ps.setString(3, Description);
			ps.setString(4, Qauntity);			
			
		int no = ps.executeUpdate();
		System.out.println("Inserting value: "+no);		
		
		conn.close();
		ps.close();
	}
	

}

