package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.Expensepage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class Expensepagetest extends TestHelper{
	@Test
	public void verifyUserCanAddNewExpense() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		Expensepage expensepage=new Expensepage(driver);
		expensepage.addExpenses();
		Assert.assertTrue (expensepage.expenseAddedMessage.isDisplayed());
			
		}
	@Test
	public void verifyUserCanAddExpenseCategory() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	Expensepage expensepage=new Expensepage(driver);
	expensepage.addexpensecategory();
	Assert.assertTrue (expensepage.categoryaddedmessage.isDisplayed());
		
	
}}
