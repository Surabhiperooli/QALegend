package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.TaxRatePage;

public class TaxRatePageTest extends TestHelper{
	 
@Test(groups= {"sanity"})
public void  verifyWhetherTheUserCanAddNewTaxRate() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	TaxRatePage taxratepage=new TaxRatePage (driver);
	taxratepage.closeEndtour();
	taxratepage.addNewTaxRate("TAX10", "50");
	if (taxratepage.successmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}

	
}
}
