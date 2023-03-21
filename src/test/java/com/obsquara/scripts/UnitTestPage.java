package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPage;
import com.obsqura.pages.UnitsPage;

public class UnitTestPage extends TestHelper {
@Test
public void verifyUsesrCanAddNewUnit() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithvalidLoginCredentials("admin", "123456");
	UnitsPage unitp=new UnitsPage(driver);
	unitp.closeEndtour();
	unitp.addNewUnit();
	if (unitp.message.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}

}
}
