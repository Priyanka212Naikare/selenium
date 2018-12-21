package day3;

import org.openqa.selenium.By;

public class DemoGuru99Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Guru99Project g=new Guru99Project();
	g.invokeBrowser();
	g.printTitle();
	g.login("mngr167120", "sebAbyr");
	g.addCustomer();
	
	String id= g.getCustomerId();
	System.out.println("id:"+id);
	g.addAccount(id);
	g.closeBrowser();
	
	
		
	}

}
