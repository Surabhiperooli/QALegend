package com.obsquara.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.obsqura.constants.Constants;
import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.Profilepage;
import com.obsqura.utiities.ExcelUtilities;
@Listeners(com.obsqura.listners.TestNGListerner.class)
public class ProfilepageTest extends TestHelper {
	
	 
	@Test(groups = {"Regression" })

	public void IsProfilePageLoadedSuccesfully() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
	    Profilepage profile=new Profilepage(driver);
	    profile.profilePageLoading();
	    Assert.assertTrue(profile.profilePageLoading());
	}
	
	
	@Test(groups = {"Regression" })

	public void verifyUserCanEditProfile() throws Throwable{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
	    Profilepage profile=new Profilepage(driver);
	   profile.profilePageLoading();
	   ExcelUtilities excelu=new ExcelUtilities(Constants.EXCEL_FILE_PATH);
	   excelu.selectExcelFile("TestDatafile", "Newprofiledata");
	   String  surnme=excelu.getCellData("Newprofiledata", 1, 0);
	   String  fstnme=	excelu.getCellData("Newprofiledata", 1, 1);
	   String  lstnme=	excelu.getCellData("Newprofiledata", 1, 2);
	   String  emailid=excelu.getCellData("Newprofiledata", 1, 3);
	   
	   Assert.assertEquals(profile.editProfile(surnme,fstnme,lstnme, emailid), "Profile updated successfully");
	    
	}
  
}
