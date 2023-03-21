package com.obsquara.scripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.BrandPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class BrandpageTest extends TestHelper {

	@Test(dataProvider = "BrandData")
	public void verifyUserCanAddNewBrand(String brndnme, String descrptn) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		BrandPage brandpge = new BrandPage(driver);
		brandpge.closeEndtour();
		brandpge.addaNewBrand(brndnme, descrptn);
		if (brandpge.successmessage.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "BrandData")
	public Object[][] getDataFromDataprovider() {

		Object[][] data = { { "Gap", "International" } };
		return data;
	}

}
