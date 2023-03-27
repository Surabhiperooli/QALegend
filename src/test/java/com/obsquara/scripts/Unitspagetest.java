package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UnitsPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class Unitspagetest extends TestHelper {
@Test(groups={"Regression"})
public void verifyUsesrCanAddNewUnit() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	UnitsPage unitp=new UnitsPage(driver);
	unitp.closeEndtour();
	Assert.assertEquals(unitp.addNewUnit(), "Unit added successfully");
		

}
}
