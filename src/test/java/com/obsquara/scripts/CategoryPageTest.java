package com.obsquara.scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.pages.CategoriesPage;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

@Listeners(com.obsqura.listners.TestNGListerner.class)
@Test(groups={"Regression"})
public class CategoryPageTest extends TestHelper {
	public void verifyUserCanAddNewCategories() {
	LoginPage loginpage = new LoginPage(driver);
	loginpage.loginWithInvalidLoginCredentials("admin", "123456");
	Homepage homepage = new Homepage(driver);
	homepage.closeEndtour();
	CategoriesPage categoriespge=new CategoriesPage(driver);
	Assert.assertEquals(categoriespge.addNewCategories(),"Category added successfully");

}}
