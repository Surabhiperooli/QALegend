package com.obsquara.scripts;

import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obsqura.pages.Homepage;
import com.obsqura.pages.LoginPage;

@Listeners(com.obsqura.listners.TestNGListerner.class)

public class HomepageTest extends TestHelper {

	@Test (groups = {"Regression" })

	public void checkHomePageloaded() {

		LoginPage loginpage = new LoginPage(driver);
		Homepage homepage = new Homepage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		homepage.closeEndtour();
		boolean result = homepage.isHomepageLoaded();
		Assert.assertTrue(result);
	}



	@Test(groups = {"Regression" })
	public void verifyWelcomeMessageShowingAsExpected() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		boolean status = homepage.iswelcomemsgHomepageShowing();
		Assert.assertTrue(status) ;
			
	}

	

	@Test(retryAnalyzer=com.obsqura.listners.RetryAnalyzer.class,groups = {"Regression" })

	public void verifyCalcutatorShowingWhileClickingOnCalculatorIcon() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		homepage.calculatordisplaying();
		Assert.assertTrue(homepage.calculatordisplay.isDisplayed()); 
			}


	@Test(groups = {"Regression" })

	public void verifyNotificationmessageShowingUponClickingBellButton() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		homepage.notificationshowing();
		System.out.println(homepage.notificationshowing());
		String actualmessage = homepage.notificationshowing();
		String expectedmessage = "No notifications found";
		Assert.assertEquals(actualmessage, expectedmessage);
	}

	
}
