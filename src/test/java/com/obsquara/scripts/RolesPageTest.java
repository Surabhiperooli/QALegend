package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.RolesPage;

public class RolesPageTest extends TestHelper{
	@Test(priority=1)
	public void verifyTheUserCanAddNewRole() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		RolesPage rolespge=new RolesPage(driver);
		rolespge.endtour();
		rolespge.addNewRole(Constants.NEWROLE);
		if (rolespge.searchdata.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		}
	@Test(priority=2)
	public void verifyTheUserCanDeleteRole() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		RolesPage rolespge=new RolesPage(driver);
		rolespge.endtour();
		rolespge.deleteRole(Constants.NEWROLE);
		if (rolespge.searchdatadeletemsg.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}}
	
