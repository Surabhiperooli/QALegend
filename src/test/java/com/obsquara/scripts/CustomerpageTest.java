package com.obsquara.scripts;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.pages.CustomerPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class CustomerpageTest extends TestHelper
{
	
	@Test(groups= {"sanity"})
	public void verifyCustomerEntryIsAbleToCopyToClipboard() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		CustomerPage custpage=new CustomerPage(driver);
		custpage.customerentryCopyToClipboard();
		
		String expctedtitle="Copy to clipboard\r\n"
				+ "Copied 25 rows to clipboard";
		String actualtitle=custpage.customerentryCopyToClipboard();
		Assert.assertTrue(actualtitle.contains("Copied 25 rows to clipboard"));
				}
}
