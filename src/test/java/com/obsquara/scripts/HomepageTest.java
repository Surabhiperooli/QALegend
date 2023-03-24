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

	@Test

	public void checkHomePageloaded() {

		LoginPage loginpage = new LoginPage(driver);
		Homepage homepage = new Homepage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		homepage.closeEndtour();
		boolean result = homepage.isHomepageLoaded();
		Assert.assertTrue(result);// hard assertion
	}



	@Test
	public void verifyWelcomeMessageShowingAsExpected() {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		boolean status = homepage.iswelcomemsgHomepageShowing();
		Assert.assertTrue(status) ;
			
	}

	

	@Test(retryAnalyzer=com.obsqura.listners.RetryAnalyzer.class)
	public void verifyCalcutatorShowingWhileClickingOnCalculatorIcon() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		homepage.calculatordisplaying();
		Assert.assertTrue(homepage.calculatordisplay.isDisplayed()); 
			}

	@Test(retryAnalyzer=com.obsqura.listners.RetryAnalyzer.class)
	public void verifyTodaysProfitMessageDisplayingWhileClickingOnTodaysProfitIcon() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginWithInvalidLoginCredentials("admin", "123456");
		Homepage homepage = new Homepage(driver);
		homepage.closeEndtour();
		homepage.todaysProfitPopUpMessage();
		Assert.assertTrue(homepage.todaysprofitmessagedisplay.isDisplayed()) ;
		

	}

	@Test
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
