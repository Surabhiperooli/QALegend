package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.utiities.ExcelUtilities;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class LoginPageTest extends TestHelper {
	
	@Test(priority = 4, dataProvider = "ValidCredentials")
	public void verifyUserisAbleToLoginWitvalidloginfunction(String usrnme, String paswd) {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials(usrnme, paswd);
		Homepage homepage = new Homepage(driver);
		Assert.assertTrue(homepage.isHomepageLoaded());
	}

	@Test(priority = 5)

	public void checkSignOut() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.islogOutworking("admin", "123456");
		String actualresult = driver.getTitle();
		String expectedresult = "Login - Demo POS";
		Assert.assertEquals(actualresult, expectedresult);

	}

	

	@Test(priority = 1, dataProvider = "Credentials1")
	public void verifyUserIsNotAbleToLoginWitInvalidloginfunction(String usrnme, String paswd) {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials(usrnme, paswd);
		String expctedtitle = "These credentials do not match our records.";
		String actualtitle = loginpage.invalidLoginMessageIsDisplaying();
		Assert.assertEquals(actualtitle, expctedtitle);

	}

	@Test(priority=2,dataProvider="Credentials2")
	public void verifyUserIsNotAbleToLoginWitInvalidPassword(String usrnme, String paswd) {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials(usrnme, paswd);
		String expctedtitle = "These credentials do not match our records.";
		String actualtitle = loginpage.invalidLoginMessageIsDisplaying();
		Assert.assertEquals(actualtitle, expctedtitle);

	}

	@Test(priority=3,dataProvider="Credentials3")
	public void verifyUserIsNotAbleToLoginWitInvalidUsername(String usrnme, String paswd) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials(usrnme, paswd);
		String expctedtitle = "These credentials do not match our records.";
		String actualtitle = loginpage.invalidLoginMessageIsDisplaying();
		Assert.assertEquals(actualtitle, expctedtitle);

	}

	@DataProvider(name = "ValidCredentials")
	public Object[][] getValidData() {

		Object[][] data = new Object[1][2];
		data[0][0] = "admin";
		data[0][1] = "123456";
		return data;

	}

@DataProvider(name="Credentials1")
	public Object[][] getInValidData() throws Throwable {
		String path = Constants.EXCEL_FILE_PATH;
		ExcelUtilities  excelu = new ExcelUtilities (path);
		int totalrows = excelu.getRowCount("Invalidusernameandpassword");
		int totalcols = excelu.getCellCount("Invalidusernameandpassword", 1);
		String invalidloginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				invalidloginData[i - 1][j] = excelu.getCellData("Invalidusernameandpassword", i, j);
			}

		}
		return invalidloginData;
	}

@DataProvider(name="Credentials2")
	public Object[][] getInValidpassword() throws Throwable {
		String path = Constants.EXCEL_FILE_PATH;

		ExcelUtilities  excelu = new ExcelUtilities (path);
		int totalrows = excelu.getRowCount("Invalidpassword");
		int totalcols = excelu.getCellCount("Invalidpassword", 1);
		String invalidloginpassword[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				invalidloginpassword[i - 1][j] = excelu.getCellData("Invalidpassword", i, j);
			}

		}
		return invalidloginpassword;
	}

@DataProvider(name="Credentials3")
	public Object[][] getInValidUsername() throws Throwable {
		String path = Constants.EXCEL_FILE_PATH;

		ExcelUtilities  lib = new ExcelUtilities (path);
		int totalrows = lib.getRowCount("Invalidusername");
		int totalcols = lib.getCellCount("Invalidusername", 1);
		String invalidloginUsername[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				invalidloginUsername[i - 1][j] = lib.getCellData("Invalidusername", i, j);
			}

		}
		return invalidloginUsername;
	}

}
