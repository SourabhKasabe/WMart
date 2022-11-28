package com.wmart.operation;
import java.util.Scanner;
import com.wmart.login.Admin;
import com.wmart.login.User;
import com.wmart.product.Product;

public class Operations {
	Scanner sc = new Scanner(System.in);

	public void logins() throws Exception
	{
		Admin ad = new Admin();
		User user = new User();
		Product pro = new Product();
		Operations op = new Operations();	
		Scanner scan = new Scanner(System.in);	
		System.out.println("\t\t\t\t\t----------->   Welcome To WMart   <------------- ");	
		
		System.out.println("Press 1 for new Register == Press 2 for User login == Press 3 for Admin login: ");
		int i = scan.nextInt();
				
		if(i==1)
		{
			System.out.println("==========================");
			System.out.println("Please Register Here: "+i);
			
			user.Register();
			user.Login();
			pro.AddCart();
		}
		if(i==2) 
		{			
			System.out.println("======================");
			System.out.println("Please login here: "+i);
			System.out.println("======================");
			user.Login();
			
		}
		if(i==3)
		{
			System.out.println("Admin Log-in: "+i);
			ad.Login();
			while(true) {
				System.out.println("==================================================");
				System.out.println("press 0 to Logout == Press 1 for Add Admin == Press 2 for UserDetails == Press 3 for Product Details == press 4 for cart table == press 5 to AddProduct ");
				int j = scan.nextInt();
				if(j==0)
				{
					break;
				}
				switch(j)
				{
				case 1:
					ad.Register();
				case 2:
					user.UserDetails();		
				case 3:
					pro.ProductDetails();
				case 4:
					pro.showcart();
				case 5:
					pro.AddProduct();
			     }
						
			}
					
		}
	}
	
	

	
   	public static void main(String[] args) throws Exception {
		
		Operations op = new Operations();
	     op.logins();
		
		

	}

}
