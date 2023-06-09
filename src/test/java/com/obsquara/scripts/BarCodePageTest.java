package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.BarCodePage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class BarCodePageTest extends TestHelper {
@Test(priority=1,groups={"Regression"})
public void verifyUserCanAddNewBarCodeToProducts() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	BarCodePage barcodepge=new BarCodePage(driver);
	Assert.assertEquals(barcodepge.addNewBarcode(),"Barcode setting added successfully");
	
}
@Test(priority=2,groups={"Regression"})
public void verifyUserCanDeleteBarCodeS() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	BarCodePage barcodepge=new BarCodePage(driver);
	Assert.assertEquals(barcodepge.deleteBarCode(),"Barcode setting deleted successfully");
}}