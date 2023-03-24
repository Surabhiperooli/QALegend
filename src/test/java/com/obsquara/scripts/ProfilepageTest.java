package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Profilepage;
import com.obsqura.utiities.ExcelUtilities;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class ProfilepageTest extends TestHelper {
	
	
	@Test
	public void IsProfilePageLoadedSuccesfully() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
	    Profilepage profile=new Profilepage(driver);
	    profile.profilepageloading();
	    Assert.assertTrue(profile.profilepageloading());
	}
	
	
	@Test(dataProvider="profiledata")
	public void verifyUserCanEditProfile(String surnme,String fstnme,String lstnme,String emailid) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
	    Profilepage profile=new Profilepage(driver);	
	    profile.profilepageloading();
	    profile.editprofile();
	    profile.editprofilefn(surnme,fstnme,lstnme,emailid);
	    Assert.assertTrue(profile.successmessage.isDisplayed());
		
}
	
	
	@DataProvider(name="profiledata")
	public Object[][] getInValidData() throws Throwable {
		
		String path =Constants.EXCEL_FILE_PATH;
		ExcelUtilities excelu= new ExcelUtilities (path);
		int totalrows = excelu.getRowCount("Newprofiledata");
		int totalcols = excelu.getCellCount("Newprofiledata", 1);
		String profileDatas[][] = new String[totalrows][totalcols];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				profileDatas[i - 1][j] = excelu.getCellData("Newprofiledata", i, j);
			}

		}
		return profileDatas;
	}
}
