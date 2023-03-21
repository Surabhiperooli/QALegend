package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.pages.CategoriesPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

public class CategoryPageTest extends TestHelper {
	@Test
	public void verifyUserCanAddNewCategories() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	CategoriesPage categotiespge=new CategoriesPage(driver);
	categotiespge.addNewCategories();
		if (categotiespge.successmessage.isDisplayed()) {
		Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}

}}
