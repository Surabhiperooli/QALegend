package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.TaxRatePage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class TaxRatePageTest extends TestHelper{
	 
@Test(groups= {"sanity"})
public void  verifyWhetherTheUserCanAddNewTaxRate() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	TaxRatePage taxratepage=new TaxRatePage (driver);
	taxratepage.closeEndtour();
	taxratepage.addNewTaxRate("TAX10", "50");
	Assert.assertTrue(taxratepage.successmessage.isDisplayed());
		
	
}
}
