package com.obsquara.scripts;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.BrandPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class BrandpageTest extends TestHelper {

	@Test(dataProvider = "BrandData",groups= {"Regression","Sanity"})
	public void verifyUserCanAddNewBrand(String brndnme, String descrptn) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		BrandPage brandpge = new BrandPage(driver);
		brandpge.closeEndtour();
		Assert.assertEquals(brandpge.addaNewBrand(brndnme, descrptn),"Brand added successfully");

	}

	@DataProvider(name = "BrandData")
	public Object[][] getDataFromDataprovider() {

		Object[][] data = { { "Gap", "International" } };
		return data;
	}

}
