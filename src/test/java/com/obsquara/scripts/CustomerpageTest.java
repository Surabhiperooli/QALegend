package com.obsquara.scripts;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class CustomerpageTest extends TestHelper
{
	
	
@Test
	public void verifyUserCanAddNewContact() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		CustomerPage custpage=new CustomerPage(driver);
		custpage.addNewContact();
		Assert.assertTrue(custpage.successmessage.isDisplayed());
	}
	@Test
	public void verifyUserCanUpdateNewlyAddedCustomerData() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();	
		CustomerPage custpage=new CustomerPage(driver);
		custpage.editNewlyAddedCustomerData();
		Assert.assertTrue(custpage.updatedmessage.isDisplayed());
	
	
	}
	
	
	
	
}
