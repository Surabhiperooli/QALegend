package com.obsquara.scripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Userpage;
import excelutiities.NewExcelLibrary;

public class Userpagetest extends TestHelper {
	
	

	@Test(priority=1,dataProvider="Newuserdata")
	public void verifyWhetherNewUserCanSuccessfullyAdded(String surnme, String frstnme, String lstnme, String email, String paswd, String confrmpaswd) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		user.addnewUserfunction(surnme, frstnme, lstnme, email, paswd, confrmpaswd);
		if (user.successmessage.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@DataProvider(name = "Newuserdata")
	public Object[][] getInValidData() throws Throwable {
		String path =Constants.EXCEL_FILE_PATH +"\\NewuserData.xlsx";
        NewExcelLibrary lib = new NewExcelLibrary(path);
		int totalrows = lib.getRowCount("Sheet1");
		int totalcols = lib.getCellCount("Sheet1", 1);
		String invalidloginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				invalidloginData[i - 1][j] = lib.getCellData("Sheet1", i, j);
			}

		}
		return invalidloginData;
	}

	@Test(priority = 2)

	public void verifyWhetehraUserCanSuccessfullyDelete() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		user.userDeleteFunctionWorking("achu");
		if (user.delmsg.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}

	@Test(priority = 3)

	public void verifyWhetehraUserCanviewalreadyRegisterdUserDetails() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		user.viewUserOption();
		if (user.viewusercontent.isDisplayed()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	

}
