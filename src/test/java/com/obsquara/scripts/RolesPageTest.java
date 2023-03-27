package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.RolesPage;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class RolesPageTest extends TestHelper{
	@Test(priority=1,groups={"Regression"})
	public void verifyTheUserCanAddNewRole() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		RolesPage rolespge=new RolesPage(driver);
		rolespge.endtour();
		Assert.assertEquals(rolespge.addNewRole(),"Role added successfully");
			}
	@Test(priority=2,groups={"Regression"})
	public void verifyTheUserCanDeleteRole() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		RolesPage rolespge=new RolesPage(driver);
		rolespge.endtour();
		Assert.assertEquals(rolespge.deleteRole(),"Role deleted successfully");
		
		
		}}
	
