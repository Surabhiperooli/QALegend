package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.Expensepage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class Expensepagetest extends TestHelper{
	//@Test
	public void verifyUserCanAddNewExpense() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		Expensepage expensepage=new Expensepage(driver);
		expensepage.addExpenses();
		if (expensepage.expenseAddedMessage.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		
}@Test
	public void verifyUserCanAddExpenseCategory() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	Expensepage expensepage=new Expensepage(driver);
	expensepage.addexpensecategory();
	if (expensepage.categoryaddedmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}
	
}}
