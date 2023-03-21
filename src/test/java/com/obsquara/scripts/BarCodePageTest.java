package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.BarCodePage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class BarCodePageTest extends TestHelper {
@Test(priority=1)
public void verifyUserCanAddNewBarCodeToProducts() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	BarCodePage barcodepge=new BarCodePage(driver);
	barcodepge.addNewBarcode();
	if (barcodepge.successmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}
}
@Test(priority=2)
public void verifyUserCanDeleteBarCodeS() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	BarCodePage barcodepge=new BarCodePage(driver);
	barcodepge.deleteBarCode();
	if (barcodepge.detetedtoastmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}
}}
