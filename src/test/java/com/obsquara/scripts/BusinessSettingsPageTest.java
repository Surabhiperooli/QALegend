package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.BusinessSettingsPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class BusinessSettingsPageTest extends TestHelper{
	@Test
	public void verifyUserCanUpdateBusinessSettings() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		BusinessSettingsPage businesspage=new BusinessSettingsPage(driver);
		businesspage.updateBusinessSettings();
		if (businesspage.successmessage.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	}


