package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.BrandPage;
import com.obsqura.pages.InvoiceSettingsPage;
import com.obsqura.pages.LoginPage;

public class InvoiceSettingsPageTest extends TestHelper{
@Test
public void verifyUserCanAddNewInvoiceSettings() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	BrandPage brandpge = new BrandPage(driver);
	brandpge.closeEndtour();
	InvoiceSettingsPage invoicepge=new InvoiceSettingsPage(driver);
	invoicepge.addNewInvoiceSetting();
	if (invoicepge.successmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}
}
}

