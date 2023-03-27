package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Userpage;
import com.obsqura.utiities.ExcelUtilities;
import com.obsqura.utiities.GenericUtilities;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class Userpagetest extends TestHelper {
	
	

	@Test(priority=1,dataProvider="Newuserdata",groups={"Regression"})
	public void verifyWhetherNewUserCanSuccessfullyAdded(String surnme, String frstnme, String lstnme, String email, String paswd, String confrmpaswd) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		Assert.assertEquals(user.addnewUserfunction(surnme, frstnme, lstnme, email, paswd, confrmpaswd), "User added successfully");
	}

	@DataProvider(name = "Newuserdata")
	public Object[][] getInValidData() throws Throwable {
		String path =Constants.EXCEL_FILE_PATH;
		ExcelUtilities  excelu= new ExcelUtilities (path);
		int totalrows = excelu.getRowCount("Newuserdata");
		int totalcols = excelu.getCellCount("Newuserdata", 1);
		String invalidloginData[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				invalidloginData[i - 1][j] = excelu.getCellData("Newuserdata", i, j);
			}

		}
		return invalidloginData;
	}

	@Test(priority = 3,groups={"Regression"})

	public void verifyWhetehraUserCanSuccessfullyDelete() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		user.userDeleteFunctionWorking("ACHU");
		Assert.assertTrue(user.delmsg.isDisplayed()) ;
			
	}

	@Test(priority = 2,groups={"Regression"})

	public void verifyWhetehraUserCanviewalreadyRegisterdUserDetails() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Userpage user = new Userpage(driver);
		user.endtour();
		user.viewUserOption();
		Assert.assertTrue(user.viewusercontent.isDisplayed());
			
	}

	

}
