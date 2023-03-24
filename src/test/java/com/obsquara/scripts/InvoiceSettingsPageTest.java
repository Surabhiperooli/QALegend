package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.BrandPage;
import com.obsqura.pages.InvoiceSettingsPage;
import com.obsqura.pages.LoginPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class InvoiceSettingsPageTest extends TestHelper{
@Test
public void verifyUserCanAddNewInvoiceSettings() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	BrandPage brandpge = new BrandPage(driver);
	brandpge.closeEndtour();
	InvoiceSettingsPage invoicepge=new InvoiceSettingsPage(driver);
	invoicepge.addNewInvoiceSetting();
	Assert.assertTrue (invoicepge.successmessage.isDisplayed());
		
}}

